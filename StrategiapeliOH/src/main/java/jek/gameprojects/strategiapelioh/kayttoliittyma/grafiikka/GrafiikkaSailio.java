package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class GrafiikkaSailio implements Grafiikkaobjekti{

    private boolean nakyva;
    private List<Grafiikkaobjekti> grafiikkaobjektit;
    
    public GrafiikkaSailio(){
        grafiikkaobjektit = new ArrayList<>();
        nakyva = true;
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
    
    public void paint(Collection<Grafiikkaobjekti> grafiikkaobjektit, Graphics2D g, Kamera kamera){
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
    public Vektori getSijainti() {
        if(grafiikkaobjektit.isEmpty()){
            return null;
        }
        
        return grafiikkaobjektit.get(0).getSijainti();
    }

    @Override
    public Vektori getKoko() {
        if(grafiikkaobjektit.isEmpty()){
            return null;
        }
        
        return grafiikkaobjektit.get(0).getKoko();
    }

    @Override
    public int getTaso() {
        if(grafiikkaobjektit.isEmpty()){
            return 0;
        }
        
        return grafiikkaobjektit.get(0).getTaso();
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

    @Override
    public void setTaso(int taso) {
        for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
            grafiikkaobjekti.setTaso(taso);
        }
    }

    @Override
    public void setSijainti(Vektori sijainti) {
        for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
            grafiikkaobjekti.setSijainti(sijainti);
        }
    }

    @Override
    public void setKoko(Vektori koko) {
        for(Grafiikkaobjekti grafiikkaobjekti : grafiikkaobjektit){
            grafiikkaobjekti.setKoko(koko);
        }
    }

}
