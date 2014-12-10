package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class YksikonKuvake implements Grafiikkaobjekti{
    
    private YksikonKuva yksikonKuva;
    private Kuva elamatPohja;
    private Kuva elamat;
    
    private Vektori sijainti;
    private Vektori koko;
    private int taso;
    private boolean nakyva;

    public YksikonKuvake(Yksikko yksikko, Vektori sijainti, Vektori koko, int taso, boolean nakyva) {
        this.sijainti = sijainti;
        this.koko = koko;
        this.taso = taso;
        this.nakyva = nakyva;
        
        this.yksikonKuva = new YksikonKuva(KuvaSailio.getKuva(yksikko.getYksikkotyyppi().toString()), sijainti, new Vektori(koko.getX(), koko.getY()-10), taso, nakyva, yksikko);
        
        elamatPohja = new Kuva(KuvaSailio.getKuva("elamatPohja"), new Vektori(sijainti.getX(), sijainti.getY()+40), new Vektori(koko.getX(), 10), taso+1, nakyva);
        elamat = new Kuva(KuvaSailio.getKuva("elamat"), new Vektori(sijainti.getX(), sijainti.getY()+40), new Vektori(koko.getX(), 10), taso, nakyva);
    }
    
    public Yksikko getYksikko(){
        return yksikonKuva.getT();
    }

    @Override
    public Vektori getSijainti() {
        return sijainti;
    }

    @Override
    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
        
        yksikonKuva.setSijainti(sijainti);
        elamatPohja.setSijainti(new Vektori(sijainti.getX(), sijainti.getY()+ 0.8*koko.getY()));
        elamat.setSijainti(new Vektori(sijainti.getX(), sijainti.getY()+ 0.8*koko.getY()));
    }

    @Override
    public Vektori getKoko() {
        return koko;
    }

    @Override
    public void setKoko(Vektori koko) {
        this.koko = koko;
        
        yksikonKuva.setKoko(new Vektori(koko.getX(), 0.8*koko.getY()));
        elamatPohja.setKoko(new Vektori(koko.getX(), 0.2*koko.getY()));
        
        Sotilas sotilas = (Sotilas) yksikonKuva.getT();
        double kerroin = sotilas.hyokkayskerroin();
        
        elamat.setKoko(new Vektori(koko.getX()*kerroin, 0.2*koko.getY()));
    }

    @Override
    public void paint(Graphics2D g, Kamera kamera) {
        if(nakyva){
            elamatPohja.paint(g, kamera);
            elamat.paint(g, kamera);
            yksikonKuva.paint(g, kamera);
        }
    }

    @Override
    public void setNakyvyys(boolean nakyvyys) {
        this.nakyva = nakyvyys;
        
        yksikonKuva.setNakyvyys(nakyvyys);
        elamat.setNakyvyys(nakyvyys);
        elamatPohja.setNakyvyys(nakyvyys);
    }

    @Override
    public boolean getNakyvyys() {
        return nakyva;
    }

    @Override
    public int getTaso() {
        return taso;
    }

    @Override
    public void setTaso(int taso) {
        this.taso = taso;
        
        yksikonKuva.setTaso(taso);
        elamat.setTaso(taso);
        elamatPohja.setTaso(taso-1);
    }

    @Override
    public void paivita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public YksikonKuva getYksikonKuva() {
        return yksikonKuva;
    }

    public void setYksikonKuva(YksikonKuva yksikonKuva) {
        this.yksikonKuva = yksikonKuva;
    }

    public Kuva getElamatPohja() {
        return elamatPohja;
    }

    public void setElamatPohja(Kuva elamatPohja) {
        this.elamatPohja = elamatPohja;
    }

    public Kuva getElamat() {
        return elamat;
    }

    public void setElamat(Kuva elamat) {
        this.elamat = elamat;
    }
    
}
