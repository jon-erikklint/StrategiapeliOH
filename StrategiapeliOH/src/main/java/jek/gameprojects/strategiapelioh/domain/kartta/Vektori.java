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
    
    
}
