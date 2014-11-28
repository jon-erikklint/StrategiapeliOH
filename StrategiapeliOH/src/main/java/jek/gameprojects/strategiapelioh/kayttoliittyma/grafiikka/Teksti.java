package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Teksti implements Grafiikkaobjekti{

    private Vektori sijainti;
    private Vektori koko;
    
    private String teksti;
    private Color color;
    private Font font;
    
    private int taso;

    public Teksti(Vektori sijainti, Vektori koko, int taso, String teksti, Color color, Font font) {
        this.sijainti = sijainti;
        this.koko = koko;
        this.taso = taso; 
        
        this.teksti = teksti;
        this.color = color;
        this.font = font;
    }
    
    @Override
    public Vektori sijainti() {
        return sijainti;
    }

    @Override
    public Vektori koko() {
        return koko;
    }

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        g.setPaint(color);
        g.setFont(font);
        
        g.drawString(teksti, (int) sijainti.getX(), (int) sijainti.getY());
    }

    @Override
    public int getTaso() {
        return taso;
    }

    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public void setKoko(Vektori koko) {
        this.koko = koko;
    }

    public void setTaso(int taso) {
        this.taso = taso;
    }
    
}
