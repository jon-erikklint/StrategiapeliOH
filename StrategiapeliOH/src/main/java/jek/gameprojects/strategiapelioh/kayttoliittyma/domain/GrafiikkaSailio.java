package jek.gameprojects.strategiapelioh.kayttoliittyma.domain;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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
    
}
