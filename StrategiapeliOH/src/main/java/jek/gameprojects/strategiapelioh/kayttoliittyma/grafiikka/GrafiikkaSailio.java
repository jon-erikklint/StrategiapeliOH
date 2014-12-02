package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class GrafiikkaSailio implements Grafiikkaobjekti{

    private boolean nakyva;
    private List<Grafiikkaobjekti> grafiikkaobjektit;
    
    public GrafiikkaSailio(){
        grafiikkaobjektit = new ArrayList<>();
    }
    
    public void lisaaGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti){
        grafiikkaobjektit.add(grafiikkaobjekti);
    }
    
    public boolean poistaGrafiikkaobjekti(Grafiikkaobjekti grafiikkaobjekti){
        return grafiikkaobjektit.remove(grafiikkaobjekti);
    }
    
    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        if(nakyva){
            
            for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
                grafiikkaobjekti.paint(g, kamera);
            }
            
        }
    }

    public List<Grafiikkaobjekti> getGrafiikkaobjektit() {
        return grafiikkaobjektit;
    }

    public void setGrafiikkaobjektit(List<Grafiikkaobjekti> grafiikkaobjektit) {
        this.grafiikkaobjektit = grafiikkaobjektit;
    }

    @Override
    public Vektori sijainti() {
        return null;
    }

    @Override
    public Vektori koko() {
        return null;
    }

    @Override
    public int getTaso() {
        if(grafiikkaobjektit.isEmpty()){
            return 0;
        }
        
        int taso = grafiikkaobjektit.get(0).getTaso();
        
        for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
            if(grafiikkaobjekti.getTaso()< taso){
                taso = grafiikkaobjekti.getTaso();
            }
        }
        
        return taso;
    }

    @Override
    public void paivita() {
        for(Grafiikkaobjekti grafiikkaobjekti:grafiikkaobjektit){
            grafiikkaobjekti.paivita();
        }
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        nakyva = nakyvyys;
    }

    @Override
    public boolean getNakyvyys() {
        return nakyva;
    }

}
