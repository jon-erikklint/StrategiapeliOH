package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class KuvanLataaja {
    
    public Image lataaKuva(String osoite){
        Image image = null;
        try {
            image = ImageIO.read(new File("StrategiapeliOh/src/main/Resources/Kuvat/"+osoite));
        } catch (Exception e) {}
        
        return image;
    }
    
}
