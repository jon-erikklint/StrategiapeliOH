package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.awt.Image;
import javax.imageio.ImageIO;

public class KuvanLataaja {
    
    public Image lataaKuva(String osoite){
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Kuvat/"+osoite));
        } catch (Exception e) {
            System.out.println("Virhe tiedostossa: /Kuvat/"+osoite);
        }
        
        return image;
    }
    
}
