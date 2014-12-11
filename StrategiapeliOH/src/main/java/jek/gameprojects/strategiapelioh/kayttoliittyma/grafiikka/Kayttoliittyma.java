package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Kayttoliittyma implements Grafiikkaobjekti{
    
    private EhdollinenGrafiikkapainike hyokkayspainike;
    private EhdollinenGrafiikkapainike liikkumispainike;
    private Grafiikkapainike vuoronLopetuspainike;
    
    private YksikoidenKuvakkeet yksikoidenKuvakkeet;
    
    private GrafiikkaSailio vakioObjektit;
    
    public Kayttoliittyma(){
        vakioObjektit = new GrafiikkaSailio();
    }
    
    public void lisaaGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti){
        vakioObjektit.lisaaGrafiikkaobjekti(grafiikkaobjekti);
    }
    
    public void poistaGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti){
        vakioObjektit.poistaGrafiikkaobjekti(grafiikkaobjekti);
    }

    @Override
    public Vektori getSijainti() {
        return null;
    }

    @Override
    public void setSijainti(Vektori sijainti) {}

    @Override
    public Vektori getKoko() {
        return null;
    }

    @Override
    public void setKoko(Vektori koko) {}

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        vuoronLopetuspainike.paint(g, kamera);
        hyokkayspainike.paint(g, kamera);
        liikkumispainike.paint(g, kamera);
        
        if(yksikoidenKuvakkeet != null){
            yksikoidenKuvakkeet.paint(g, kamera);
        }
        
        vakioObjektit.paint(g, kamera);
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {}

    @Override
    public boolean getNakyvyys() {
        return true;
    }

    @Override
    public int getTaso() {
        return 0;
    }

    @Override
    public void setTaso(int taso) {}

    @Override
    public void paivita() {
        if(yksikoidenKuvakkeet != null){
            yksikoidenKuvakkeet.paivita();
        }
        
        hyokkayspainike.paivita();
        liikkumispainike.paivita();
        
        vakioObjektit.paivita();
    }
    
    public EhdollinenGrafiikkapainike getHyokkayspainike() {
        return hyokkayspainike;
    }

    public void setHyokkayspainike(EhdollinenGrafiikkapainike hyokkayspainike) {
        this.hyokkayspainike = hyokkayspainike;
    }

    public EhdollinenGrafiikkapainike getLiikkumispainike() {
        return liikkumispainike;
    }

    public void setLiikkumispainike(EhdollinenGrafiikkapainike liikkumispainike) {
        this.liikkumispainike = liikkumispainike;
    }

    public Grafiikkapainike getVuoronLopetuspainike() {
        return vuoronLopetuspainike;
    }

    public void setVuoronLopetuspainike(Grafiikkapainike vuoronLopetuspainike) {
        this.vuoronLopetuspainike = vuoronLopetuspainike;
    }

    public YksikoidenKuvakkeet getYksikoidenKuvakkeet() {
        return yksikoidenKuvakkeet;
    }

    public void setYksikoidenKuvakkeet(YksikoidenKuvakkeet yksikoidenKuvakkeet) {
        this.yksikoidenKuvakkeet = yksikoidenKuvakkeet;
    }

    public GrafiikkaSailio getVakioObjektit() {
        return vakioObjektit;
    }

    public void setVakioObjektit(GrafiikkaSailio vakioObjektit) {
        this.vakioObjektit = vakioObjektit;
    }
    
    
}
