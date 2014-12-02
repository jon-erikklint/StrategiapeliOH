package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.Comparator;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;

public class PainikeTasoComparator implements Comparator<Painike>{

    @Override
    public int compare(Painike eka, Painike toka) {
        return toka.getTaso()-eka.getTaso();
    }
    
}
