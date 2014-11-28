package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.PeliSivu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.logiikka.Peli;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;
import jek.gameprojects.strategiapelioh.logiikka.generointi.PelinAlustaja;

public class AloitusPainike extends NelioPainike{

    private AloitusMaarittely aloitusMaarittely;
    
    private SivujenHallinnoija sivujenHallinnoija;

    public AloitusPainike(Vektori sijainti, Vektori koko, SivujenHallinnoija sivujenHallinnoija, AloitusMaarittely aloitusMaarittely) {
        super(sijainti, koko, 0);
        
        this.sivujenHallinnoija = sivujenHallinnoija;
        
        this.aloitusMaarittely = aloitusMaarittely;
    }
    
    @Override
    public Vektori getSijainti() {return null;}

    @Override
    public Vektori getKoko() {return null;}

    @Override
    public void toimi() {
        PelinAlustaja pelinAlustaja = new PelinAlustaja(aloitusMaarittely);
        
        try{Peli uusiPeli = pelinAlustaja.alustaPeli();
        
            PeliSivu peliruutu = new PeliSivu(uusiPeli);
            sivujenHallinnoija.lisaaSivu(peliruutu);
            sivujenHallinnoija.vaihdaSivu(sivujenHallinnoija.sivujenMaara());
            
        }
        catch(Exception e){
            ilmoitaVirhe(e);
        }
    }
    
    private void ilmoitaVirhe(Exception e){
        
    }
    
}
