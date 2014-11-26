package jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Painike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class PainikkeidenKuuntelija implements HiirenToiminnot{

    private List<Painike> painikkeet;
    
    public PainikkeidenKuuntelija(){
        painikkeet = new ArrayList<>();
    }
    
    public void lisaaPainike(Painike painike){
        painikkeet.add(painike);
    }
    
    public boolean poistaPainike(Painike painike){
        return painikkeet.remove(painike);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for(Painike painike : painikkeet){
            Point point = e.getPoint();
            Vektori sijainti = new Vektori(point.x, point.y);
            
            if(painike.onkoPaalla(sijainti)){
                painike.toimi();
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
    
}
