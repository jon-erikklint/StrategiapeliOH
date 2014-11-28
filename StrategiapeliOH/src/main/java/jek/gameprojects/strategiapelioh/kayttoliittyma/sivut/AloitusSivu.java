package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.Sivu;
import java.awt.Graphics;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.TyhjaNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.AloitusPainike;
import jek.gameprojects.strategiapelioh.logiikka.generointi.AloitusMaarittely;

public class AloitusSivu implements Sivu{

    private PainikkeidenKuuntelija hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera kamera;
    
    private Grafiikkapainike grafiikkapainike;
    
    public AloitusSivu(SivujenHallinnoija sivujenHallinnoija){
        kamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        hiirenToiminnot = new PainikkeidenKuuntelija(kamera);
        nappaimistonToiminnot = new TyhjaNappaimistonToiminnot();
        
        Vektori alkusijainti = new Vektori(450,500);
        Vektori koko = new Vektori(100,20);
        
        AloitusPainike aloitusPainike = new AloitusPainike(alkusijainti, koko, sivujenHallinnoija, new AloitusMaarittely());
        Kuva kuva = new Kuva(KuvaSailio.getKuva("aloituspainike"), alkusijainti, koko, 0, 0);
        
        grafiikkapainike = new Grafiikkapainike(aloitusPainike, kuva);
        
    }
    
    @Override
    public void paivita() {}

    @Override
    public void paint(Graphics2D g) {
        grafiikkapainike.paint(g, kamera);
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
