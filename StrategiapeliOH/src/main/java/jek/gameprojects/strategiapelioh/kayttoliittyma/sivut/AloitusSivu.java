package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.PelinAloitus;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.TyhjaNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.NelioPainike;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;
import jek.gameprojects.strategiapelioh.logiikka.generointi.aseet.PanssarivahvuuksienVakioAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.kartta.KartanVakioAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.pelaajat.PelaajienVakioAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.yksikkotyypit.YksikkotyyppienVakioAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot.YksikoidenVakioAlustaja;

public class AloitusSivu implements Sivu{

    private PainikkeidenKuuntelija hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera kamera;
    
    private Grafiikkapainike grafiikkapainike;
    
    private GrafiikkaSailio valitukset;
    
    
    public AloitusSivu(){
        kamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        hiirenToiminnot = new PainikkeidenKuuntelija(kamera);
        nappaimistonToiminnot = new TyhjaNappaimistonToiminnot();
        
        valitukset = new GrafiikkaSailio();
        
    }
    
    public void alusta(SivujenHallinnoija sivujenHallinnoija){
        AloitusMaarittely aloitusMaarittely = new AloitusMaarittely();
        
        Vektori alkusijainti = new Vektori(450,500);
        Vektori koko = new Vektori(100,20);
        
        PelinAloitus aloitusEfekti = new PelinAloitus(sivujenHallinnoija, aloitusMaarittely, valitukset);
        NelioPainike aloitusPainike = new NelioPainike(aloitusEfekti, alkusijainti, koko, 0);
        Kuva kuva = new Kuva(KuvaSailio.getKuva("aloituspainike"), alkusijainti, koko, 0, true);
        
        grafiikkapainike = new Grafiikkapainike(aloitusPainike, kuva);
        hiirenToiminnot.lisaaPainike(aloitusPainike);
        
        alustaMaarittelyt(aloitusMaarittely);
    }
    
    public final void alustaMaarittelyt(AloitusMaarittely aloitusMaarittely){
        
        aloitusMaarittely.setPelaajienAlustaja( new PelaajienVakioAlustaja() );
        aloitusMaarittely.setYksikkotyyppienAlustaja( new YksikkotyyppienVakioAlustaja() );
        aloitusMaarittely.setKartanAlustaja( new KartanVakioAlustaja() );
        aloitusMaarittely.setPanssarivahvuuksienAlustaja( new PanssarivahvuuksienVakioAlustaja() );
        aloitusMaarittely.setYksikoidenAlustaja(new YksikoidenVakioAlustaja());
        
        List<String> pelaajienNimet = new ArrayList<>();
        pelaajienNimet.add("Pelaaja 1");
        pelaajienNimet.add("Pelaaja 2");
        
        aloitusMaarittely.setPelaajienNimet(pelaajienNimet);
        
    }
    
    @Override
    public void paivita() {
        valitukset.paivita();
    }

    @Override
    public void paint(Graphics2D g) {
        grafiikkapainike.paint(g, kamera);
        
        valitukset.paint(g, kamera);
    }

    @Override
    public HiirenToiminnot hiirenToiminnot() {
        return hiirenToiminnot;
    }

    @Override
    public NappaimistonToiminnot nappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }
    
}
