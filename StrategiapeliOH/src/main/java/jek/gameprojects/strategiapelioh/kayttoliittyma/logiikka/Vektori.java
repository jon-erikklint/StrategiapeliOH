package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

public class Vektori {
    
    private double x;
    private double y;

    public Vektori(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vektori(){
        this(0,0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
