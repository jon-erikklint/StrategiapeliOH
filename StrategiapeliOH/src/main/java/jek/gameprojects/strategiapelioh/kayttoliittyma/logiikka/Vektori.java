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
    
    public void summaa(Vektori vektori){
        this.x+=vektori.x;
        this.y+=vektori.y;
    }
    
    public void kerro(double kerroin){
        x *= kerroin;
        y *= kerroin;
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
    
    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }
    
}
