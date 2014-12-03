package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.awt.Color;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.AjastettuGrafiikkaobjekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Teksti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.PeliSivu;
import jek.gameprojects.strategiapelioh.logiikka.Peli;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;
import jek.gameprojects.strategiapelioh.logiikka.generointi.PelinAlustaja;

public class PelinAloitus implements Efekti{

    private AloitusMaarittely aloitusMaarittely;
    
    private SivujenHallinnoija sivujenHallinnoija;
    
    private GrafiikkaSailio virheilmoitukset;
    
    public PelinAloitus(SivujenHallinnoija sivujenHallinnoija, AloitusMaarittely aloitusMaarittely, GrafiikkaSailio grafiikkaSailio){
        this.aloitusMaarittely = aloitusMaarittely;
        this.sivujenHallinnoija = sivujenHallinnoija;
        this.virheilmoitukset = grafiikkaSailio;
        
    }
    
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
        Teksti teksti = new Teksti(new Vektori(450, 600), new Vektori(100,20), 0, "Virhe: "+e.getLocalizedMessage(), Color.WHITE, true);
        AjastettuGrafiikkaobjekti ajastettu = new AjastettuGrafiikkaobjekti(teksti, 3000); 
        
        virheilmoitukset.lisaaGrafiikkaobjekti(ajastettu);
    }
    
}
