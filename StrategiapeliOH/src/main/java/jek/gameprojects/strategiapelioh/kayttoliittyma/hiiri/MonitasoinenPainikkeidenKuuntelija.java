package jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MonitasoinenPainikkeidenKuuntelija implements HiirenToiminnot{
    
    private List<PainikkeidenKuuntelija> kuuntelijat;
    
    public MonitasoinenPainikkeidenKuuntelija(){
        kuuntelijat = new ArrayList<>();
    }
    
    public void lisaaPainikkeienKuuntelija(PainikkeidenKuuntelija painikkeidenKuuntelija, int taso){
        kuuntelijat.add(painikkeidenKuuntelija);
    }
    
    public void poistaPainikkeidenKuuntelija(PainikkeidenKuuntelija kuuntelija){
        kuuntelijat.remove(kuuntelija);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(PainikkeidenKuuntelija kuuntelija : kuuntelijat){
            kuuntelija.mouseClicked(e);
            
            if(kuuntelija.isToimiko()){
                kuuntelija.nollaa();
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
