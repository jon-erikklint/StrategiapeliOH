package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.AloitusSivu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.Sivu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;

public class Paneeli extends JPanel implements Runnable{
    
    private SivujenHallinnoija sivujenHallinnoija;
    
    private Thread thread;
    
    public Paneeli(){
        super.setPreferredSize(new Dimension(1000,1000));
        
        HiirenKuuntelija hiirenKuuntelija = new HiirenKuuntelija();
        NappaimistonKuuntelija nappaimistonKuuntelija = new NappaimistonKuuntelija();
        
        super.addMouseListener(hiirenKuuntelija);
        super.addKeyListener(nappaimistonKuuntelija);
        
        List<Sivu> sivut = new ArrayList<>();
        sivut.add(new AloitusSivu(sivujenHallinnoija));
        
        sivujenHallinnoija = new SivujenHallinnoija(sivut, 0, hiirenKuuntelija, nappaimistonKuuntelija);
        
        KuvaSailio.lataaKuvat();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        Graphics2D grafiikat = (Graphics2D) g;
        
        sivujenHallinnoija.nykyinenSivu().paint(grafiikat);
        g.dispose();
    }

    @Override
    public void run() {
        
        while(true){
            sivujenHallinnoija.nykyinenSivu().paivita();
            
            repaint();
        }
    }
    
}
