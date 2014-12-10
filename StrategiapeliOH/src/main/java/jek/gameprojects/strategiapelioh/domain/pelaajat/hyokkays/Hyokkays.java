package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import java.util.List;

/**
 * 
 * Tietopaketti, joka sisältää taistelemiseen tarvittavat tiedot
 * 
 */

public class Hyokkays {
    
    private boolean onkoHyokkaava;
    
    private int maksimiElamat;
    private int hyokkaystenMaara;
    
    private List<Ase> aseet;
    private List<Panssari> panssarit;

    public Hyokkays(int elamat, int hyokkaystenMaara, List<Ase> aseet, List<Panssari> panssarit) {
        onkoHyokkaava = true;
        
        this.maksimiElamat = elamat;
        this.hyokkaystenMaara = hyokkaystenMaara;
        
        this.aseet=aseet;
        this.panssarit=panssarit;
    }
    
    public Hyokkays(){
        onkoHyokkaava = false;
    }
    
    public boolean isOnkoHyokkaava() {
        return onkoHyokkaava;
    }

    public void setOnkoHyokkaava(boolean onkoHyokkaava) {
        this.onkoHyokkaava = onkoHyokkaava;
    }

    public int getMaksimiElamat() {
        return maksimiElamat;
    }

    public void setMaksimiElamat(int maksimiElamat) {
        this.maksimiElamat = maksimiElamat;
    }

    public List<Ase> getAseet() {
        return aseet;
    }

    public void setAseet(List<Ase> aseet) {
        this.aseet = aseet;
    }

    public List<Panssari> getPanssarit() {
        return panssarit;
    }

    public void setPanssarit(List<Panssari> panssarit) {
        this.panssarit = panssarit;
    }

    public int getHyokkaystenMaara() {
        return hyokkaystenMaara;
    }

    public void setHyokkaystenMaara(int hyokkaystenMaara) {
        this.hyokkaystenMaara = hyokkaystenMaara;
    }
}
