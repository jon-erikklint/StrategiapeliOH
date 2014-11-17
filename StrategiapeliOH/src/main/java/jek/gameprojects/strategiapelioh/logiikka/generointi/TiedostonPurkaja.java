package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiedostonPurkaja {
    
    public List<String> lueTiedosto(String tiedostonNimi) throws FileNotFoundException{
        
        List<String> sisalto = new ArrayList<>();
        
        File tiedosto = new File(tiedostonNimi);
        Scanner lukija = new Scanner(tiedosto);

        while(lukija.hasNext()){
            sisalto.add(lukija.next());
        }
            

        return sisalto;
        
    }
    
}
