package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Teksti implements Grafiikkaobjekti{

    private Vektori sijainti;
    private Vektori koko;
    
    private String teksti;
    private Color color;
    private Font font;
    
    private boolean nakyva;
    private int taso;

    public Teksti(Vektori sijainti, Vektori koko, int taso, String teksti, Color color, Font font, boolean nakyva) {
        this.sijainti = sijainti;
        this.koko = koko;
        this.taso = taso; 
        
        this.teksti = teksti;
        this.color = color;
        this.font = font;
        this.nakyva = nakyva;
    }
    
    public Teksti(Vektori sijainti, Vektori koko, int taso, String teksti, Color color, boolean nakyva) {
        this(sijainti, koko, taso, teksti, color, null, nakyva);
    }
    
    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        g.setPaint(color);
        if(font!=null){
            g.setFont(font);
        }
        
        Vektori muutettuSijainti = kamera.muutaSijainti(sijainti);
        
        g.drawString(teksti, (int) muutettuSijainti.getX(), (int) muutettuSijainti.getY());
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

    @Override
    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    @Override
    public void setKoko(Vektori koko) {
        this.koko = koko;
    }

    @Override
    public void setTaso(int taso) {
        this.taso = taso;
    }

    @Override
    public void paivita() {}

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        this.nakyva = nakyvyys;
    }

    @Override
    public boolean getNakyvyys() {
        return nakyva;
    }

    @Override
    public Vektori getSijainti() {
        return sijainti;
    }

    @Override
    public Vektori getKoko() {
        return koko;
    }
    
}
