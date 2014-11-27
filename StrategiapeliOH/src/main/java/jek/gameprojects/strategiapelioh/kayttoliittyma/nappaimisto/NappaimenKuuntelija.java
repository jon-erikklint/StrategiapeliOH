package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

public abstract class NappaimenKuuntelija {
    
    private int merkkikoodi;

    public NappaimenKuuntelija(int merkkikoodi) {
        this.merkkikoodi = merkkikoodi;
    }
    
    public int merkkikoodi(){
        return merkkikoodi;
    }
    
    public abstract void toimi();
}
