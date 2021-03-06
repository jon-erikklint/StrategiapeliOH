package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;

public class Grafiikkapainike implements Painike, Grafiikkaobjekti{
    
    private Painike painike;
    private Grafiikkaobjekti grafiikkaobjekti;

    public Grafiikkapainike(Painike painike, Grafiikkaobjekti grafiikkaobjekti){
        this.painike = painike;
        this.grafiikkaobjekti = grafiikkaobjekti;
    }

    public Painike getPainike() {
        return painike;
    }

    public void setPainike(Painike painike) {
        this.painike = painike;
    }

    public Grafiikkaobjekti getGrafiikkaobjekti() {
        return grafiikkaobjekti;
    }

    public void setGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti) {
        this.grafiikkaobjekti = grafiikkaobjekti;
    }
    
    @Override
    public boolean onkoPaalla(Vektori vektori, Kamera kamera) {
        return painike.onkoPaalla(vektori, kamera);
    }

    @Override
    public void toimi() {
        painike.toimi();
    }

    @Override
    public int getTaso() {
        return grafiikkaobjekti.getTaso();
    }

    @Override
    public Vektori getSijainti() {
        return grafiikkaobjekti.getSijainti();
    }

    @Override
    public Vektori getKoko() {
        return grafiikkaobjekti.getKoko();
    }

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        grafiikkaobjekti.paint(g, kamera);
    }

    @Override
    public void paivita() {
        grafiikkaobjekti.paivita();
        painike.paivita();
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        grafiikkaobjekti.setNakyvyys(nakyvyys);
    }

    @Override
    public boolean getNakyvyys() {
        return grafiikkaobjekti.getNakyvyys();
    }

    @Override
    public void setTaso(int taso) {
        grafiikkaobjekti.setTaso(taso);
        painike.setTaso(taso);
    }

    @Override
    public void setSijainti(Vektori sijainti) {
        grafiikkaobjekti.setSijainti(sijainti);
    }

    @Override
    public void setKoko(Vektori koko) {
        grafiikkaobjekti.setKoko(koko);
    }
}
