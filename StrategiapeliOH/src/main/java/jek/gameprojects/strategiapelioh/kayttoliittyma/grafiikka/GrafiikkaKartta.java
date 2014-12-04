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
    
    private Map<Koordinaatti, ObjectKuva<Ruutu>> ruudut;
    private boolean onkoNakyva;
    
    public GrafiikkaKartta(){
        onkoNakyva = true;
        
        ruudut = new HashMap<>();
    }
    
    public List<ObjectKuva<Ruutu>> getRuudut(){
        List<ObjectKuva<Ruutu>> ruudut = new ArrayList<>();
        
        ruudut.addAll(this.ruudut.values());
        
        return ruudut;
    }
    
    public ObjectKuva<Ruutu> getRuutu(Koordinaatti koordinaatti){
        return ruudut.get(koordinaatti);
    }
    
    public void addRuutu(ObjectKuva<Ruutu> ruutu){
        ruudut.put(ruutu.getT().getSijainti(), ruutu);
    }
    
    @Override
    public void paint(Graphics2D g, Kamera kamera){
        if(onkoNakyva){
            
            for(ObjectKuva<Ruutu> ruutu : ruudut.values()){
                ruutu.paint(g, kamera);
            }
            
        }
    }

    @Override
    public Vektori sijainti() {
        return null;
    }

    @Override
    public Vektori koko() {
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
        for(ObjectKuva<Ruutu> ruutu : ruudut.values()){
            ruutu.paivita();
        }
    }

    public Map<Koordinaatti, ObjectKuva<Ruutu>> getRuutuKartta() {
        return ruudut;
    }

    public void setRuutuKartta(Map<Koordinaatti, ObjectKuva<Ruutu>> ruudut) {
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
    
}
