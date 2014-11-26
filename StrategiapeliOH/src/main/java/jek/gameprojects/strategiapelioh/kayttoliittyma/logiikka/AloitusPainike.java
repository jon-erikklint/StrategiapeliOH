package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.PeliRuutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Ruutu;
import jek.gameprojects.strategiapelioh.logiikka.Peli;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;
import jek.gameprojects.strategiapelioh.logiikka.generointi.PelinAlustaja;

public class AloitusPainike extends NelioPainike{

    private AloitusMaarittely aloitusMaarittely;
    
    private List<Ruutu> peliruudut;
    private Integer nykyinenRuutu;
    
    private int taso = 0;
    
    public AloitusPainike(AloitusMaarittely aloitusMaarittely, List<Ruutu> ruudut, Integer nykyinenRuutu){
        this.aloitusMaarittely = aloitusMaarittely;
        this.peliruudut = ruudut;
        this.nykyinenRuutu = nykyinenRuutu;
    }
    
    @Override
    public Vektori getSijainti() {return null;}

    @Override
    public Vektori getKoko() {return null;}

    @Override
    public void toimi() {
        PelinAlustaja pelinAlustaja = new PelinAlustaja(aloitusMaarittely);
        
        try{Peli uusiPeli = pelinAlustaja.alustaPeli();
        
            PeliRuutu peliruutu = new PeliRuutu(uusiPeli);
            peliruudut.add(peliruutu);
            this.nykyinenRuutu = peliruudut.size()-1;
        }
        catch(Exception e){
            ilmoitaVirhe(e);
        }
    }
    
    private void ilmoitaVirhe(Exception e){
        
    }

    @Override
    public int getTaso() {
        return taso;
    }
    
}
