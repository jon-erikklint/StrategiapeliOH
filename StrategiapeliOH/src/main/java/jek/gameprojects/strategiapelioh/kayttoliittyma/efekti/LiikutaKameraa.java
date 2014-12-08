package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class LiikutaKameraa extends PelitilaEfekti{

    private Kamera kamera;
    private Vektori suunta;
    
    public LiikutaKameraa(Pelitila pelitila, Kamera kamera, Vektori suunta) {
        super(pelitila);
        
        this.suunta = suunta;
        this.kamera = kamera;
    }

    @Override
    public void toimi() {
        Vektori kameraS = kamera.getSijainti();
        Vektori kameraK = kamera.getKoko();
        
        if(kameraS.getX()+suunta.getX()<0){
            
            kameraS.setX(0);
            
        }
                
        else if(kameraS.getY()+suunta.getY()<0){

            kameraS.setY(0);
            
        }
        
        else if(kameraS.getX()+kameraK.getX() > pelitila.getRuudunKoko().getX()){
            kameraS.setX(pelitila.getRuudunKoko().getX()-kameraK.getX());
        }
        
        else if(kameraS.getY()+kameraK.getY() > pelitila.getRuudunKoko().getY()){
            kameraS.setY(pelitila.getRuudunKoko().getY()-kameraK.getY());
        }
        
        else{
            kameraS.summaa(suunta);
        }
    }
    
}
