package jek.gameprojects.strategiapelioh.domain;

public class KiertavaLaskuri extends Laskuri{

    private int arvo;
    
    private int ylaraja;
    private int alaraja;
    
    public KiertavaLaskuri(int ylaraja, int alaraja, int alkuarvo){
        this.ylaraja=ylaraja;
        this.alaraja=alaraja;
        
        if(alkuarvo>ylaraja || alkuarvo<alaraja){
            arvo = alaraja;
        }else{
            arvo = alkuarvo;
        }
    }
        
    @Override
    public void lisaaArvoa(int maara) {
        arvo = ((arvo+maara)%(ylaraja-alaraja))+alaraja;
    }

    @Override
    public void setArvo(int arvo) {
        
        if(!(arvo>ylaraja || arvo<alaraja)){
            this.arvo = arvo;
        }
        
    }

    @Override
    public int getArvo() {
        return arvo;
    }

    public int getYlaraja() {
        return ylaraja;
    }

    public int getAlaraja() {
        return alaraja;
    }

    public void setYlaraja(int ylaraja) {
        this.ylaraja = ylaraja;
        
        if(arvo>ylaraja){
            arvo=ylaraja;
        }
    }

    public void setAlaraja(int alaraja) {
        this.alaraja = alaraja;
        
        if(arvo<alaraja){
            arvo=alaraja;
        }
    }
    
    
}
