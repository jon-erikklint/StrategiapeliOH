package jek.gameprojects.strategiapelioh.kayttoliittyma.tilat;

public class Tila<T> {
    
    private T t;
    
    public Tila(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
    @Override
    public String toString(){
        if(t == null){
            return "";
        }
        
        return t.toString();
    }
}
