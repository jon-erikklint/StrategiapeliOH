package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

public class Grafiikkalaskuri {
    
    public static Vektori kaanna(Vektori vektori, double kulma){
        Vektori kaannettyVektori = new Vektori();
        
        kaannettyVektori.setX(Math.cos(vektori.getX())-Math.sin(vektori.getY()));
        kaannettyVektori.setY(Math.sin(vektori.getX()+Math.cos(vektori.getY())));
        
        return kaannettyVektori;
    }
    
    public static Vektori[] muutaKulmamuotoon(Vektori sijainti, Vektori koko){
        Vektori[] kulmat = new Vektori[4];
        
        kulmat[0] = new Vektori(sijainti.getX(), sijainti.getY());
        kulmat[1] = new Vektori(sijainti.getX()+koko.getX(), sijainti.getY());
        kulmat[2] = new Vektori(sijainti.getX()+koko.getX(), sijainti.getY()+koko.getY());
        kulmat[3] = new Vektori(sijainti.getX(), sijainti.getY()+koko.getY());
        
        return kulmat;
    }
    
    public static Vektori[] kaannaNelio(Vektori sijainti, Vektori koko, double kulma){
        Vektori[] kulmat = muutaKulmamuotoon(sijainti, koko);
        
        for(int i=0;i<4;i++){
            kulmat[i]=kaanna(kulmat[i], kulma);
        }
        
        return kulmat;
    }
}
