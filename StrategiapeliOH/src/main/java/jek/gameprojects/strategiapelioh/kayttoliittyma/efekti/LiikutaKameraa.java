package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class LiikutaKameraa extends PelitilaEfekti{

    private Kamera kamera;
    private Vektori suunta;
    
    public LiikutaKameraa(Pelitila pelitila, Kamera kamera, Vektori suunta) {
        super(pelitila);
        
        this.kamera = kamera;
    }

    @Override
    public void toimi() {
        Vektori kameraS = kamera.getSijainti();
        Vektori kameraK = kamera.getKoko();
        
        if(kameraS.getX()+suunta.getX()<0 || kameraS.getY()+suunta.getY()<0 || 
            kameraS.getX()+kameraK.getX()>pelitila.getRuudunKoko().getX() || 
                kameraS.getY()+kameraK.getY()>pelitila.getRuudunKoko().getY()){
            return;
        }
        
        kameraS.summaa(suunta);
    }
    
}
