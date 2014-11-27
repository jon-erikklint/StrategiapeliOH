package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.AloitusSisalto;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Sisalto;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.RuutujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Paneeli extends JPanel{
    
    private RuutujenHallinnoija ruudunVaihtaja;
    
    public Paneeli(){
        super.setPreferredSize(new Dimension(1000,1000));
        
        HiirenKuuntelija hiirenKuuntelija = new HiirenKuuntelija();
        NappaimistonKuuntelija nappaimistonKuuntelija = new NappaimistonKuuntelija();
        
        super.addMouseListener(hiirenKuuntelija);
        super.addKeyListener(nappaimistonKuuntelija);
        
        List<Sisalto> ruudut = new ArrayList<>();
        AloitusSisalto aloitusRuutu = new AloitusSisalto(new Vektori(1000, 1000));
        
        ruudunVaihtaja = new RuutujenHallinnoija(ruudut, 0, hiirenKuuntelija, nappaimistonKuuntelija);
    }
    
}
