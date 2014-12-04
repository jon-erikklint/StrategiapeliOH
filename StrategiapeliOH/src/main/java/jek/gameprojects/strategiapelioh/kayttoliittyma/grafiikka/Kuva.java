package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.awt.Image;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Kuva implements Grafiikkaobjekti{

    private Image image;
    
    private Vektori sijainti;
    private Vektori koko;
    
    private int taso;
    private boolean nakyva;

    public Kuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva) {
        this.image = image;
        this.sijainti = sijainti;
        this.koko = koko;
        
        this.nakyva=nakyva;
        this.taso = taso;
    }
    
    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        Vektori[] muunnetutSijainnit = kamera.koordinaatinmuutos(sijainti, koko);
        
        g.drawImage(image, (int) muunnetutSijainnit[0].getX(), (int)muunnetutSijainnit[0].getY(), 
                (int) muunnetutSijainnit[1].getX(), (int) muunnetutSijainnit[1].getY(), null);
        
    }

    @Override
    public Vektori sijainti() {
        return sijainti;
    }

    @Override
    public Vektori koko() {
        return koko;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public Vektori getSijainti() {
        return sijainti;
    }

    public Vektori getKoko() {
        return koko;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public void setKoko(Vektori koko) {
        this.koko = koko;
    }

    @Override
    public int getTaso() {
        return taso;
    }

    @Override
    public void paivita() {}

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        nakyva = nakyvyys;
    }

    @Override
    public boolean getNakyvyys() {
        return nakyva;
    }

    @Override
    public void setTaso(int taso) {
        this.taso = taso;
    }
    
}
