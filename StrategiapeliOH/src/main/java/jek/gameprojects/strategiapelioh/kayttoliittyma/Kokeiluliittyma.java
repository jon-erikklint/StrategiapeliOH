package jek.gameprojects.strategiapelioh.kayttoliittyma;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;


public class Kokeiluliittyma { //debuggerointia yms. varten väliaikainen!
    
    public static void main(String[] args) {
        Ruutu[][] ruudut =new Ruutu[2][2];
        
        Maasto maasto=new Maasto(Aluetyyppi.MAA,Maastotyyppi.AVOMAA,0);
        
        for(int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                Ruutu ruutu=new Ruutu(new Vektori(i,j), maasto);
            }
        }
        
        Kartta kartta=new Kartta(ruudut,2,2);
    }
}
