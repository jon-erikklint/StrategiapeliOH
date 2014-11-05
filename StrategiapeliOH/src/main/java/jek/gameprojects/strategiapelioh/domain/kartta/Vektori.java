package jek.gameprojects.strategiapelioh.domain.kartta;

public class Vektori {
    
    private int X;
    private int Y;

    public Vektori(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public Vektori(){
        this(0,0);
    }
    
    public void summaa(Vektori vektori){
        this.X+=vektori.X;
        this.Y+=vektori.Y;
    }
    
    public Vektori summaVektori(Vektori vektori){
        return new Vektori(this.X+vektori.X, this.Y+vektori.Y);
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
        
        Vektori toinen=(Vektori) o;
        
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
