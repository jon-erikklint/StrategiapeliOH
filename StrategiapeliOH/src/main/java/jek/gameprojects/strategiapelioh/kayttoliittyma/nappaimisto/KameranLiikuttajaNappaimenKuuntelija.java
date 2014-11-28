package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class KameranLiikuttajaNappaimenKuuntelija extends NappaimenKuuntelija{

    private Vektori kartanKoko;
    
    private Kamera kamera;
    private Vektori suunta;
    
    public KameranLiikuttajaNappaimenKuuntelija(int merkkikoodi) {
        super(merkkikoodi);
    }

    @Override
    public void toimi() {
        Vektori kameraS = kamera.getSijainti();
        Vektori kameraK = kamera.getKoko();
        
        if(kameraS.getX()+suunta.getX()<0 || kameraS.getY()+suunta.getY()<0 || 
                kameraS.getX()+kameraK.getX()>kartanKoko.getX() || kameraS.getY()+kameraK.getY()>kartanKoko.getY()){
            return;
        }
        
        kameraS.summaa(suunta);
    }
    
}
