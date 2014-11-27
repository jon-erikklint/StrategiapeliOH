/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public boolean onkoPaalla(Vektori vektori) {
        return painike.onkoPaalla(vektori);
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
    public Vektori sijainti() {
        return grafiikkaobjekti.sijainti();
    }

    @Override
    public Vektori koko() {
        return grafiikkaobjekti.koko();
    }

    @Override
    public void paint(Graphics2D g) {
        grafiikkaobjekti.paint(g);
    }
}
