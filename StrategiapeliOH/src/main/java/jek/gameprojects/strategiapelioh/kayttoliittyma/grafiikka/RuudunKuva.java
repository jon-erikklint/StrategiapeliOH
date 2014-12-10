package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class RuudunKuva implements Grafiikkaobjekti{
    
    private ToStringObjectKuva<Ruutu> ruutu;
    private YksikoidenKuva yksikot;

    public RuudunKuva(ToStringObjectKuva<Ruutu> ruutu, YksikoidenKuva yksikot) {
        this.ruutu = ruutu;
        this.yksikot = yksikot;
    }
    
    public Ruutu getRuutu(){
        return (Ruutu) ruutu.getT();
    }

    public ToStringObjectKuva<Ruutu> getObjectKuvaRuutu() {
        return ruutu;
    }

    public void setObjectKuvaRuutuRuutu(ToStringObjectKuva<Ruutu> ruutu) {
        this.ruutu = ruutu;
    }

    public YksikoidenKuva getYksikot() {
        return yksikot;
    }

    public void setYksikot(YksikoidenKuva yksikot) {
        this.yksikot = yksikot;
    }

    @Override
    public Vektori getSijainti() {
        return ruutu.getSijainti();
    }

    @Override
    public void setSijainti(Vektori sijainti) {
        ruutu.setSijainti(sijainti);
        yksikot.setSijainti(sijainti);
    }

    @Override
    public Vektori getKoko() {
        return ruutu.getKoko();
    }

    @Override
    public void setKoko(Vektori koko) {
        ruutu.setKoko(koko);
        yksikot.setKoko(koko);
    }

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        if(ruutu.getNakyvyys()){
            
            ruutu.paint(g, kamera);
            yksikot.paint(g, kamera);
            
        }
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        ruutu.setNakyvyys(nakyvyys);
        yksikot.setNakyvyys(nakyvyys);
    }

    @Override
    public boolean getNakyvyys() {
        return ruutu.getNakyvyys();
    }

    @Override
    public int getTaso() {
        return ruutu.getTaso();
    }

    @Override
    public void setTaso(int taso) {
        ruutu.setTaso(taso);
        yksikot.setTaso(taso);
    }

    @Override
    public void paivita() {
        ruutu.paivita();
        yksikot.paivita();
    }
    
    
    
}
