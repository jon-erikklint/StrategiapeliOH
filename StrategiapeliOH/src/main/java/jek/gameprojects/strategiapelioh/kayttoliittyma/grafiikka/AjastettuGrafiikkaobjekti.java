package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Ajastin;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class AjastettuGrafiikkaobjekti implements Grafiikkaobjekti{
    
    private Grafiikkaobjekti grafiikkaobjekti;
    private Ajastin ajastin;
    
    public AjastettuGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti, long elinaika){
        this.grafiikkaobjekti = grafiikkaobjekti;
        
        ajastin = new Ajastin(elinaika);
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
    public int getTaso() {
        return grafiikkaobjekti.getTaso();
    }

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        grafiikkaobjekti.paint(g, kamera);
    }

    @Override
    public void paivita() {
        grafiikkaobjekti.paivita();
        ajastin.paivita();
        
        if(ajastin.onkoLoppu()){
            setNakyvyys(false);
        }
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        grafiikkaobjekti.setNakyvyys(nakyvyys);
    }

    @Override
    public boolean getNakyvyys() {
        return grafiikkaobjekti.getNakyvyys();
    }

    public Grafiikkaobjekti getGrafiikkaobjekti() {
        return grafiikkaobjekti;
    }

    public void setGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti) {
        this.grafiikkaobjekti = grafiikkaobjekti;
    }

    public Ajastin getAjastin() {
        return ajastin;
    }

    public void setAjastin(Ajastin ajastin) {
        this.ajastin = ajastin;
    }

    @Override
    public void setTaso(int taso) {
        grafiikkaobjekti.setTaso(taso);
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
