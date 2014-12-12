package jek.gameprojects.strategiapelioh.domain.kartta;

/**
 * 
 * Kokonaislukuvektori
 * 
 */

public class Koordinaatti {
    
    private int X;
    private int Y;

    public Koordinaatti(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public Koordinaatti(){
        this(0,0);
    }
    
    /**
     * Summaa annetun vektorin tähän vektoriin
     * 
     * @param vektori summattava
     */
    public void summaa(Koordinaatti vektori){
        this.X+=vektori.X;
        this.Y+=vektori.Y;
    }
    
    /**
     * Palauttaa vektorin joka on tämän ja annetun vektorin summa. Ei muuta kummankaan arvoja.
     * 
     * @param vektori summattava
     * @return vektorien summa
     */
    public Koordinaatti summaVektori(Koordinaatti vektori){
        return new Koordinaatti(this.X+vektori.X, this.Y+vektori.Y);
    }
    
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        
        if(o.getClass()!=this.getClass()){
            return false;
        }
        
        Koordinaatti toinen=(Koordinaatti) o;
        
        return toinen.X==this.X && toinen.Y==this.Y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.X;
        hash = 43 * hash + this.Y;
        return hash;
    }
    
    @Override
    public String toString(){
        return "["+X+","+Y+"]";
    }
    
}
