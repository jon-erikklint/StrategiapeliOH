package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Ase;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssari;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.YksikoidenPoistaja;

/**
 * 
 * Laskee taistelussa eri osapuolille koituvat vahingot ja sen kuka puolustaa hyökkääjiä vastaan
 * 
 */

public class Taistelulaskuri {
    
    private YksikoidenPoistaja yksikoidenPoistaja;
    
    private Map<Asetyyppi,Map<Panssarityyppi, Double>> asetyyppienVahvuudet; 
    
    private Random random;
    
    private List<Hyokkaava> hyokkaajat;
    private List<Hyokkaava> puolustajat;
    
    public Taistelulaskuri(Map<Asetyyppi,Map<Panssarityyppi,Double>> asetyyppienVahvuudet, JoukkojenHallinnoija joukkojenHallinnoija){
        random = new Random();
        yksikoidenPoistaja = new YksikoidenPoistaja(joukkojenHallinnoija);
        
        this.asetyyppienVahvuudet = asetyyppienVahvuudet;
    }
    
    //
    /// Taistelu
    
    /**
     * 
     * Taisteluttaa tämänhetkiset hyökkääjät ja puolustajat
     * 
     */
    public void taistele(){
        for(Hyokkaava hyokkaaja:hyokkaajat){
            if(puolustajat.isEmpty()){
                break;
            }
            
            sotilasTaistelee(hyokkaaja);
        }
        
        List<Hyokkaava> kuolevat = new ArrayList<>();
        
        for(Hyokkaava hyokkaaja:hyokkaajat){
            if(hyokkaaja.onkoKuollut()){
                kuolevat.add(hyokkaaja);
            }
        }
        
        for(Hyokkaava kuoleva : kuolevat){
            hallinnoiKuolema(kuoleva, true);
        }
        
    }
    
    /**
     * Yksittäinen hyökkäävä taistelee yhtä puolustajaa vastaan
     * 
     * @param hyokkaaja 
     */
    public void sotilasTaistelee(Hyokkaava hyokkaaja){
        
        Hyokkaava puolustaja = haePahinPuolustaja(hyokkaaja);
        
        taisteluta(hyokkaaja, puolustaja);

        if(puolustajaVoiTehdaVastaiskun(hyokkaaja, puolustaja)){
            taisteluta(puolustaja, hyokkaaja);
        }
        
        if(puolustaja.onkoKuollut()){
            hallinnoiKuolema(puolustaja, false);
        }
        
    }
    
    /**
     * Laskee hyökkääjän tekemän vahingon ja laittaa puolustajan menettämään sen verran elämäpisteitä
     * 
     * @param iskija hyökkääjä
     * @param vastaanottaja puolustaja
     */
    public void taisteluta(Hyokkaava iskija, Hyokkaava vastaanottaja){
        double hyokkayskerroin = haeVahvinPanssari(iskija.getAktiivinenAse().getAsetyyppi(), vastaanottaja.hyokkays().getPanssarit());
        
        int isku = vahinko(hyokkayskerroin, iskija.getAktiivinenAse());
        
        vastaanottaja.menetaElamaa(isku);
    }
    
    /**
     * Hoitaa kuolleen yksikön poistamisen pelistä ja taistelulaskurista
     * 
     * @param hyokkaava
     * @param onkoHyokkaaja 
     */
    public void hallinnoiKuolema(Hyokkaava hyokkaava, boolean onkoHyokkaaja){
        if(onkoHyokkaaja){
            hyokkaajat.remove(hyokkaava);
        }else{
            puolustajat.remove(hyokkaava);
        }

        if(hyokkaava.getClass() == Sotilas.class){
            yksikoidenPoistaja.poistaYksikko((Sotilas) hyokkaava);
        }
    }
    
    /**
     * Laskee tehdyn vahingon annetulla asellaa ja elämäkertoimella
     * 
     * @param elamakerroin
     * @param ase
     * @return tehty vahinko
     */
    public int vahinko(double elamakerroin, Ase ase){
        double odotusisku = ase.getIsku();
        
        odotusisku*=annaSatunnaisuuskerroin(ase.getTarkkuus());
        
        odotusisku*=elamakerroin;
        
        return (int)odotusisku;
    } 
    
    /**
     * Antaa aseen tarkkuudesta riippuvan satunnaisuuskertoimen
     * 
     * @param tarkkuus
     * @return satunnaisuuskerroin
     */
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
    
    /**
     * Kertoo voiko puolustaja tehdä vastaiskun hyökkääjään
     * 
     * @param hyokkaaja
     * @param puolustaja
     * @return 
     */
    public boolean puolustajaVoiTehdaVastaiskun(Hyokkaava hyokkaaja, Hyokkaava puolustaja){
        return !hyokkaaja.getAktiivinenAse().isKaukotaistelu();
    }
    
    /**
     * Etsii puolustajista sen, joka kestää parhaitan hyökkääjän iskua
     * 
     * @param hyokkaava
     * @return pahin puolustaja
     */
    public Hyokkaava haePahinPuolustaja(Hyokkaava hyokkaava){
        Hyokkaava puolustaja = puolustajat.get(0);
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
    
    /**
     * Etsii panssareista sen, joka on vahvin annettua asetyyppiä vastaan
     * 
     * @param asetyyppi
     * @param panssarit
     * @return 
     */
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
    
    /**
     * 
     * Nollaa taistelulaskurin muistin
     * 
     */
    public void nollaa(){
        hyokkaajat.clear();
        puolustajat.clear();
    }
    
    public List<Hyokkaava> getHyokkaajat() {
        return hyokkaajat;
    }

    public void setHyokkaajat(List<Hyokkaava> hyokkaajat) {
        this.hyokkaajat = hyokkaajat;
    }

    public List<Hyokkaava> getPuolustajat() {
        return puolustajat;
    }

    public void setPuolustajat(List<Hyokkaava> puolustajat) {
        this.puolustajat = puolustajat;
    }
    
    protected void setRandomSeed(long seed){
        random.setSeed(seed);
    }
}
