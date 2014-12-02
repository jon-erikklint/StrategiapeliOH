package jek.gameprojects.strategiapelioh.logiikka.generointi.kartta;

import jek.gameprojects.strategiapelioh.logiikka.generointi.kartta.KartanAlustaja;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.logiikka.generointi.TiedostoAlustaja;

public class KartanTiedostoAlustaja extends TiedostoAlustaja implements KartanAlustaja{
    
    public KartanTiedostoAlustaja(String tiedostonNimi) throws Exception{
        
        super(tiedostonNimi);
            
    }
    
    @Override
    public Kartta alustaKartta() throws Exception{
        
        int leveys = tulkitseKokonaisluku();
        int korkeus = tulkitseKokonaisluku();
        
        Ruutu[][] ruudut = new Ruutu[leveys][korkeus];
        
        kasvata(1);
        
        alustaRuudut(ruudut, leveys, korkeus);
        
        return new Kartta(ruudut, leveys, korkeus);
        
    }
    
    private void alustaRuudut(Ruutu[][] ruudut, int leveys, int korkeus) throws Exception{
        
        for(int i=0; i<leveys; i++){
            for(int j=0;j<korkeus;j++){
                if(nykyinen().equals("-")){
                break;
                }

                tarkistaLukukohta();

                ruudut[i][j] = alustaRuutu(i, j);

            }   
        }
        
    }
    
    private Ruutu alustaRuutu(int x, int y) throws Exception{
        
        Aluetyyppi aluetyyppi = Aluetyyppi.valueOf(nykyinen());
        kasvata(1);

        Maastotyyppi maastotyyppi = Maastotyyppi.valueOf(nykyinen());
        kasvata(1);

        int maankorkeus = tulkitseKokonaisluku();
        
        Maasto maasto = new Maasto(aluetyyppi, maastotyyppi, maankorkeus);
        
        return new Ruutu(new Koordinaatti(x,y), maasto);
    }

}
