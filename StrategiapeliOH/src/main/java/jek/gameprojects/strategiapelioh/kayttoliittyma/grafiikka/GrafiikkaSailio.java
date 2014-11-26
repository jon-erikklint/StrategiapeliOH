package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class GrafiikkaSailio implements Grafiikkaobjekti{

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
    public void paint(Graphics2D g) {
        for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
            grafiikkaobjekti.paint(g);
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
    
}
