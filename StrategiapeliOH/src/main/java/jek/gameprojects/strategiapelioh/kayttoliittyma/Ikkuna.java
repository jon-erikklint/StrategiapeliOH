package jek.gameprojects.strategiapelioh.kayttoliittyma;

import javax.swing.JFrame;

public class Ikkuna extends JFrame{
    
    public Ikkuna(){
        super("StrategiapeliOH");
        
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        Paneeli paneeli = new Paneeli();
        super.getContentPane().add(paneeli);
        
        super.pack();
        super.setVisible(true);
        
        paneeli.run();
    }
    
}
