package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.AloitusSivu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;

public class Paneeli extends JPanel implements Runnable{
    
    private SivujenHallinnoija sivujenHallinnoija;
    
    public Paneeli(){
        super.setPreferredSize(new Dimension(1000,1000));
        super.setBackground(Color.BLACK);
        super.setFocusable(true);
        
        KuvaSailio.lataaKuvat();
                
        HiirenKuuntelija hiirenKuuntelija = new HiirenKuuntelija();
        NappaimistonKuuntelija nappaimistonKuuntelija = new NappaimistonKuuntelija();
        
        super.addMouseListener(hiirenKuuntelija);
        super.addKeyListener(nappaimistonKuuntelija);
        
        sivujenHallinnoija = new SivujenHallinnoija(hiirenKuuntelija, nappaimistonKuuntelija);
        AloitusSivu aloitus = new AloitusSivu();
        sivujenHallinnoija.alusta(aloitus);
        aloitus.alusta(sivujenHallinnoija);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D grafiikat = (Graphics2D) g;
        
        sivujenHallinnoija.nykyinenSivu().paint(grafiikat);

    }

    @Override
    public void run() {

        while(true){
            sivujenHallinnoija.nykyinenSivu().paivita();
            
            repaint();
        }
    }
    
}
