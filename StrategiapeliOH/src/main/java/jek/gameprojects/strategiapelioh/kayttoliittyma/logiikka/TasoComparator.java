package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.Comparator;

public class TasoComparator implements Comparator<Tasollinen>{

    @Override
    public int compare(Tasollinen eka, Tasollinen toka) {
        return toka.getTaso()-eka.getTaso();
    }
    
}
