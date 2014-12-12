package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Color;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Teksti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.TyhjaNappaimistonToiminnot;

public class VoititPelinSivu implements Sivu{
    
    private TyhjaNappaimistonToiminnot nappaimistonToiminnot;
    private PainikkeidenKuuntelija painikkeidenKuuntelija;
    
    private Kamera kamera;
    
    private Teksti voititPelin;
    
    private String voittajanNimi;
    
    public VoititPelinSivu(String voittajanNimi){
        this.voittajanNimi = voittajanNimi;
        
        kamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        nappaimistonToiminnot = new TyhjaNappaimistonToiminnot();
        painikkeidenKuuntelija = new PainikkeidenKuuntelija(kamera);
        
        init();
    }
    
    private void init(){
        String teksti = voittajanNimi;
        if(!voittajanNimi.equals("Ei voittajaa")){
            teksti += " voitti pelin";
        }
        
        voititPelin = new Teksti(new Vektori(450, 490), new Vektori(100,20), 0, teksti, Color.WHITE, true);
    }

    @Override
    public HiirenToiminnot hiirenToiminnot() {
        return painikkeidenKuuntelija;
    }

    @Override
    public NappaimistonToiminnot nappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }

    @Override
    public void paint(Graphics2D g) {
        voititPelin.paint(g, kamera);
    }

    @Override
    public void paivita() {
        
    }
    
}
