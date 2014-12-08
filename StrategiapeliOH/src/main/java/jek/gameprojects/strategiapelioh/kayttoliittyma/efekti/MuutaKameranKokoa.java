package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class MuutaKameranKokoa extends PelitilaEfekti{

    private final Kamera kamera;
    private Vektori lisattava;
    
    public MuutaKameranKokoa(Pelitila pelitila, Kamera kamera, Vektori lisattava) {
        super(pelitila);
        
        this.kamera = kamera;
        this.lisattava = lisattava;
    }

    @Override
    public void toimi() {
        
        Vektori kameraS = kamera.getSijainti();
        Vektori kameraK = kamera.getKoko();
        
        if(kameraK.getX() + lisattava.getX() < 100 || kameraK.getY() +lisattava.getY() < 100){
            return;
        }
        
        if(kameraK.getX() + lisattava.getX() + kameraS.getX() > pelitila.getRuudunKoko().getX() ||
                kameraK.getY() + lisattava.getY() + kameraS.getY() > pelitila.getRuudunKoko().getY()){
            return;
        }
        
        kameraK.summaa(lisattava);
        
    }
    
}
