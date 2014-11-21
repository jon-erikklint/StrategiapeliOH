package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.List;
import java.util.Map;
import java.util.Random;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Ase;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssari;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;

public class Taistelulaskuri {
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    private Map<Asetyyppi,Map<Panssarityyppi, Double>> asetyyppienVahvuudet; 
    
    private Random random;
    
    private List<Sotilas> hyokkaajat;
    private List<Sotilas> puolustajat;
    
    public Taistelulaskuri(Map<Asetyyppi,Map<Panssarityyppi,Double>> asetyyppienVahvuudet){
        random = new Random();
        joukkojenHallinnoija = new JoukkojenHallinnoija();
        
        this.asetyyppienVahvuudet = asetyyppienVahvuudet;
    }
    
    //
    /// Taistelu
    public void taistele(){
        for(Sotilas hyokkaaja:hyokkaajat){
            sotilasTaistelee(hyokkaaja);
        }
        
        for(Sotilas hyokkaaja:hyokkaajat){
            hallinnoiMahdollinenKuolema(hyokkaaja, true);
        }
    }
    
    public void sotilasTaistelee(Sotilas hyokkaaja){
        
        Sotilas puolustaja = haePahinPuolustaja(hyokkaaja);
        boolean voikoPuolustautua = voikoPuolustajaTehdaVastaiskun(hyokkaaja, puolustaja);
        double hyokkayskerroin = haeVahvinPanssari(hyokkaaja.getAktiivinenAse().getAsetyyppi(), puolustaja.hyokkays().getPanssarit());

        puolustaja.menetaElamaa(vahinko(hyokkayskerroin, hyokkaaja.getAktiivinenAse()));

        if(voikoPuolustautua){
            double puolustajanHyokkayskerroin = haeVahvinPanssari(puolustaja.getAktiivinenAse().getAsetyyppi(), hyokkaaja.hyokkays().getPanssarit());
            hyokkaaja.menetaElamaa(vahinko(puolustajanHyokkayskerroin, puolustaja.getAktiivinenAse()));
        }
        
        hallinnoiMahdollinenKuolema(puolustaja, false);
    }
    
    public void hallinnoiMahdollinenKuolema(Sotilas sotilas, boolean onkoHyokkaaja){
        if(sotilas.onkoKuollut()){
            
            if(onkoHyokkaaja){
                hyokkaajat.remove(sotilas);
            }else{
                puolustajat.remove(sotilas);
            }
            
            joukkojenHallinnoija.poistayksikkoJoukostaan(sotilas);
        }
    }
    
    public int vahinko(double hyokkayskerroin, Ase ase){
        double odotusisku = ase.getIsku();
        
        odotusisku*=annaSatunnaisuuskerroin(ase.getTarkkuus());
        
        odotusisku*=hyokkayskerroin;
        
        return (int)odotusisku;
    } 
    
    public double annaSatunnaisuuskerroin(double tarkkuus){
        double randomkerroin=random.nextDouble();
        randomkerroin+=tarkkuus;
        
        if(randomkerroin>1){
            randomkerroin=1;
        }
        
        if(randomkerroin<0.5){
            randomkerroin=0;
        }
        
        return randomkerroin;
    }
    
    public boolean voikoPuolustajaTehdaVastaiskun(Sotilas hyokkaaja, Sotilas puolustaja){
        return !hyokkaaja.hyokkays().isKaukotaistelu();
    }
    
    public Sotilas haePahinPuolustaja(Sotilas hyokkaava){
        Sotilas puolustaja = puolustajat.get(0);
        double hyokkayskerroin = haeVahvinPanssari(hyokkaava.getAktiivinenAse().getAsetyyppi(), puolustaja.hyokkays().getPanssarit());
        
        for(int i=1; i<puolustajat.size(); i++){
            double vastaavaHyokkayskerroin = haeVahvinPanssari( hyokkaava.getAktiivinenAse().getAsetyyppi(), puolustajat.get(i).hyokkays().getPanssarit());
            
            if(vastaavaHyokkayskerroin<hyokkayskerroin){
                hyokkayskerroin=vastaavaHyokkayskerroin;
                puolustaja=puolustajat.get(i);
            }
        }
        
        return puolustaja;
    }
    
    public double haeVahvinPanssari(Asetyyppi asetyyppi, List<Panssari> panssarit){
        
        if(panssarit.isEmpty()){
            return 1;
        }
        
        Map<Panssarityyppi, Double> asetyypinVahvuudet = asetyyppienVahvuudet.get(asetyyppi);

        double vahvin = asetyypinVahvuudet.get(panssarit.get(0).getPanssarityyppi())*panssarit.get(0).getPanssarinVahvuus();


        for(int i=1;i<panssarit.size();i++){
            double panssarinVahvuus = asetyypinVahvuudet.get(panssarit.get(i).getPanssarityyppi())*panssarit.get(i).getPanssarinVahvuus();
            
            if(panssarinVahvuus<vahvin){
                vahvin=panssarinVahvuus;
            }
        }

        return vahvin;
        
    }
    ///
    //
    
    public void nollaa(){
        hyokkaajat.clear();
        puolustajat.clear();
    }
    
    public List<Sotilas> getHyokkaajat() {
        return hyokkaajat;
    }

    public void setHyokkaajat(List<Sotilas> hyokkaajat) {
        this.hyokkaajat = hyokkaajat;
    }

    public List<Sotilas> getPuolustajat() {
        return puolustajat;
    }

    public void setPuolustajat(List<Sotilas> puolustajat) {
        this.puolustajat = puolustajat;
    }
}
