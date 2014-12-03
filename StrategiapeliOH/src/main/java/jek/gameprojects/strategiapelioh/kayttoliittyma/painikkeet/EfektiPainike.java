package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Efekti;

public abstract class EfektiPainike implements Painike{

    private Efekti efekti;
    
    public EfektiPainike(Efekti efekti){
        this.efekti = efekti;
    }
    
    @Override
    public void toimi() {
        efekti.toimi();
    }

    public Efekti getEfekti() {
        return efekti;
    }

    public void setEfekti(Efekti efekti) {
        this.efekti = efekti;
    }
    
}
