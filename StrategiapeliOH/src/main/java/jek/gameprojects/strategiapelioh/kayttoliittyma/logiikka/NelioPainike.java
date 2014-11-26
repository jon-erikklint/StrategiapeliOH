package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

public abstract class NelioPainike implements Painike{

    public abstract Vektori getSijainti();
    public abstract Vektori getKoko();
    
    @Override
    public boolean onkoPaalla(Vektori vektori) {
        double vx = vektori.getX();
        double vy = vektori.getY();
        double x = getSijainti().getX();
        double y = getSijainti().getY();
        double lev = getKoko().getX();
        double kor = getKoko().getY();
        
        return (vx>=x && vx<x+lev) && (vy>=y && vy<y+kor);
    }
    
}
