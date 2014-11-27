package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;

public class AloitusSisalto implements Sisalto{

    private PainikkeidenKuuntelija hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Grafiikkapainike grafiikkapainike;
    
    public AloitusSisalto(Vektori ruudunKoko){
        hiirenToiminnot = new PainikkeidenKuuntelija();
        
    }
    
    @Override
    public void paivita() {}

    @Override
    public void paint(Graphics2D g) {
        grafiikkapainike.paint(g);
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
