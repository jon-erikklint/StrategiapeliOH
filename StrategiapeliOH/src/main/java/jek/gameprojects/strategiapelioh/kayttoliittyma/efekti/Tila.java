package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

public class Tila<T> {
    
    private T muuttuja;
    
    public Tila(T t){
        this.muuttuja = t;
    }
    
    public T getMuuttuja(){
        return muuttuja;
    }
    
    public void setMuuttuja(T t){
        muuttuja = t;
    }
    
}
