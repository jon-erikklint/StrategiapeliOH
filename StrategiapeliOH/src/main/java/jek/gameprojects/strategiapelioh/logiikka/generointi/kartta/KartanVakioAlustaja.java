package jek.gameprojects.strategiapelioh.logiikka.generointi.kartta;

import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;

public class KartanVakioAlustaja implements KartanAlustaja{

    @Override
    public Kartta alustaKartta() throws Exception {
        Ruutu[][] ruudut = new Ruutu[10][10];
        
        Maasto vakiomaasto = new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 0);
        Maasto vakiomaasto2 = new Maasto(Aluetyyppi.MAA, Maastotyyppi.METSA, 0);
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10 ;j++){
                if((i+j)%3!=0){
                    ruudut[i][j] = new Ruutu(new Koordinaatti(i,j), vakiomaasto);
                }else{
                    ruudut[i][j] = new Ruutu(new Koordinaatti(i,j), vakiomaasto2);
                }
                
            }
        }
        
        return new Kartta(ruudut, 10, 10);
    }
    
}
