package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Efekti;

public class EfektiNappaimenKuuntelija extends NappaimenKuuntelija{

    private Efekti efekti;
    
    public EfektiNappaimenKuuntelija(int merkkikoodi, Efekti efekti) {
        super(merkkikoodi);
        
        this.efekti = efekti;
    }

    @Override
    public void toimi() {
        efekti.toimi();
    }
    
}
