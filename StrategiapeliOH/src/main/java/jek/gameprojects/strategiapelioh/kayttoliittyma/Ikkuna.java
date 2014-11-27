package jek.gameprojects.strategiapelioh.kayttoliittyma;

import javax.swing.JFrame;

public class Ikkuna extends JFrame{
    
    public Ikkuna(){
        super("StrategiapeliOH");
        
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().add(new Paneeli());
        
        super.pack();
        super.setVisible(true);
    }
    
}
