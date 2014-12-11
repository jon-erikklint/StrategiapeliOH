package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.ValitseYksikko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.EfektiPainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.NelioPainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class YksikoidenKuvakkeet implements Grafiikkaobjekti{
    
    private List<YksikonKuvake> kuvakkeet;
    
    public YksikoidenKuvakkeet(){
        kuvakkeet = new ArrayList<>();
    }
    
    public void alustaKuvakkeet(List<Yksikko> yksikot, PainikkeidenKuuntelija kuuntelijaJohonLisataanPainikkeet, Pelitila pelitila){
        
        int kuvakevali = 10;
        int kuvakkeenLeveys = 50;
        
        int alkukohta = ((int) pelitila.getRuudunKoko().getX()-(yksikot.size()*kuvakkeenLeveys + (yksikot.size()-1)*kuvakevali)) / 2;
        Vektori koko = new Vektori(kuvakkeenLeveys, kuvakkeenLeveys);
        
        for(int i=0 ; i<yksikot.size() ; i++){
            Vektori sijainti = new Vektori(alkukohta + i*kuvakkeenLeveys + i*kuvakevali , pelitila.getRuudunKoko().getY()-kuvakkeenLeveys);
            
            luoYksikonKuvake(yksikot.get(i), sijainti, koko, kuuntelijaJohonLisataanPainikkeet, pelitila);
        }
    }
    
    public void luoYksikonKuvake(Yksikko yksikko, Vektori sijainti, Vektori koko, PainikkeidenKuuntelija kuuntelija, Pelitila pelitila){
        
        YksikonKuvake yksikonKuvake = new YksikonKuvake(yksikko, sijainti, koko, 0, true);
        
        ValitseYksikko valitseYksikko = new ValitseYksikko(pelitila, yksikonKuvake);
        EfektiPainike efektiPainike = new NelioPainike(valitseYksikko, koko, sijainti, 0);
        kuuntelija.lisaaPainike(efektiPainike);
        
        kuvakkeet.add(yksikonKuvake);
        
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
        for(YksikonKuvake kuvake : kuvakkeet){
            kuvake.paint(g, kamera);
        }
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        for(YksikonKuvake kuvake : kuvakkeet){
            kuvake.setNakyvyys(nakyvyys);
        }
    }

    @Override
    public boolean getNakyvyys() {
        return kuvakkeet.get(0).getNakyvyys();
    }

    @Override
    public int getTaso() {
        return kuvakkeet.get(0).getTaso();
    }

    @Override
    public void setTaso(int taso) {
        for(YksikonKuvake kuvake : kuvakkeet){
            kuvake.setTaso(taso);
        }
    }

    @Override
    public void paivita() {
        for(YksikonKuvake kuvake : kuvakkeet){
            kuvake.paivita();
        }
    }
    
}