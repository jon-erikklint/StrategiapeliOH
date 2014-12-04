package jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.PainikeTasoComparator;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tasollinen;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;

public class PainikkeidenKuuntelija implements HiirenToiminnot, Tasollinen{

    private List<Painike> painikkeet;
    private PainikeTasoComparator comparator;
    
    private Kamera kamera;
    
    private int taso;
    
    private boolean toimiko;
    
    public PainikkeidenKuuntelija(Kamera kamera, int taso){
        comparator = new PainikeTasoComparator();
        painikkeet = new ArrayList<>();
        
        this.kamera=kamera;
        
        toimiko = false;
        this.taso = taso;
    }
    
    public PainikkeidenKuuntelija(Kamera kamera){
        this(kamera, 0);
    }
    
    public void nollaa(){
        toimiko = false;
    }
    
    public void lisaaPainike(Painike painike){
        painikkeet.add(painike);
        jarjestaPainikkeet();
    }
    
    public boolean poistaPainike(Painike painike){
        boolean poistettiinko = painikkeet.remove(painike);
        
        if(poistettiinko){
            jarjestaPainikkeet();
        }
        
        return poistettiinko;
    }
    
    public void jarjestaPainikkeet(){
        Collections.sort(painikkeet, comparator);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for(Painike painike : painikkeet){
            Point point = e.getPoint();
            Vektori sijainti = new Vektori(point.x, point.y);
            
            if(painike.onkoPaalla(sijainti, kamera)){
                painike.toimi();
                toimiko = true;
                
                return;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public int getTaso() {
        return taso;
    }

    @Override
    public void setTaso(int taso) {
        this.taso = taso;
    }

    public boolean isToimiko() {
        return toimiko;
    }

    public void setToimiko(boolean toimiko) {
        this.toimiko = toimiko;
    }

    @Override
    public void paivita() {
        for(Painike painike: painikkeet){
            painike.paivita();
        }
    }
    
}
