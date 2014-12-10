package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class GrafiikkaKartta implements Grafiikkaobjekti{
    
    private Map<Koordinaatti, RuudunKuva> ruudut;
    private boolean onkoNakyva;
    
    public GrafiikkaKartta(){
        onkoNakyva = true;
        
        ruudut = new HashMap<>();
    }
    
    public List<RuudunKuva> getRuudut(){
        List<RuudunKuva> ruudut = new ArrayList<>();
        
        ruudut.addAll(this.ruudut.values());
        
        return ruudut;
    }
    
    public RuudunKuva getRuutu(Koordinaatti koordinaatti){
        return ruudut.get(koordinaatti);
    }
    
    public void addRuutu(RuudunKuva ruudunKuva){
        Ruutu ruutu = (Ruutu) ruudunKuva.getRuutu();
        
        ruudut.put(ruutu.getSijainti(), ruudunKuva);
    }
    
    @Override
    public void paint(Graphics2D g, Kamera kamera){
        if(onkoNakyva){
            
            for(RuudunKuva ruutu : ruudut.values()){
                ruutu.paint(g, kamera);
            }
            
        }
    }

    @Override
    public Vektori getSijainti() {
        return null;
    }

    @Override
    public Vektori getKoko() {
        return null;
    }

    @Override
    public int getTaso() {
        return 0;
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        onkoNakyva = false;
    }

    @Override
    public boolean getNakyvyys() {
        return onkoNakyva;
    }

    @Override
    public void paivita() {
        for(RuudunKuva ruutu : ruudut.values()){
            ruutu.paivita();
        }
    }

    public Map<Koordinaatti, RuudunKuva> getRuutuKartta() {
        return ruudut;
    }

    public void setRuutuKartta(Map<Koordinaatti, RuudunKuva> ruudut) {
        this.ruudut = ruudut;
    }

    public boolean isOnkoNakyva() {
        return onkoNakyva;
    }

    public void setOnkoNakyva(boolean onkoNakyva) {
        this.onkoNakyva = onkoNakyva;
    }

    @Override
    public void setTaso(int taso) {}

    @Override
    public void setSijainti(Vektori sijainti) {
        for(Koordinaatti koordinaatti : ruudut.keySet()){
            ruudut.get(koordinaatti).setSijainti(sijainti);
        }
    }

    @Override
    public void setKoko(Vektori koko) {
        for(Koordinaatti koordinaatti : ruudut.keySet()){
            ruudut.get(koordinaatti).setKoko(koko);
        }
    }
    
}
