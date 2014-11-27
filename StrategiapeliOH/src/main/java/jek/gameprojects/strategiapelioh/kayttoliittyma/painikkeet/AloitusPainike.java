package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.PeliSisalto;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.RuutujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.logiikka.Peli;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;
import jek.gameprojects.strategiapelioh.logiikka.generointi.PelinAlustaja;

public class AloitusPainike extends NelioPainike{

    private AloitusMaarittely aloitusMaarittely;
    
    private RuutujenHallinnoija ruudunVaihtaja;

    public AloitusPainike(Vektori sijainti, Vektori koko, int taso, RuutujenHallinnoija ruudunVaihtaja, AloitusMaarittely aloitusMaarittely) {
        super(sijainti, koko, taso);
        
        this.ruudunVaihtaja = ruudunVaihtaja;
        
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
        
            PeliSisalto peliruutu = new PeliSisalto(uusiPeli);
            ruudunVaihtaja.lisaaRuutu(peliruutu);
            ruudunVaihtaja.vaihdaRuutu(ruudunVaihtaja.ruutujenMaara());
            
        }
        catch(Exception e){
            ilmoitaVirhe(e);
        }
    }
    
    private void ilmoitaVirhe(Exception e){
        
    }
    
}
