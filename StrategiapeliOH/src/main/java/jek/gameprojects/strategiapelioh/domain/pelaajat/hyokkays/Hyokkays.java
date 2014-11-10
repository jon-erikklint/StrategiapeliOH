package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import java.util.ArrayList;
import java.util.List;

public class Hyokkays {
    
    private boolean onkoHyokkaava;
    
    private int kantama;
    private boolean kaukotaistelu;
    
    private int maksimiElamat;
    
    private List<Ase> aseet;
    private List<Panssari> panssarit;

    public Hyokkays(int elamat, int kantama, boolean kaukotaistelu, boolean onkoHyokkaava, List<Ase> aseet, List<Panssari> panssarit) {
        this.kantama = kantama;
        this.kaukotaistelu = kaukotaistelu;
    }
    
    public Hyokkays(){
        this(1,0,false,false, new ArrayList<Ase>(), new ArrayList<Panssari>());
    }
    
    public boolean isKaukotaistelu() {
        return kaukotaistelu;
    }

    public void setKaukotaistelu(boolean kaukotaistelu) {
        this.kaukotaistelu = kaukotaistelu;
    }
    
    public Hyokkays(int kantama){
        this.kantama=kantama;
    }

    public int getKantama() {
        return kantama;
    }

    public void setKantama(int kantama) {
        this.kantama = kantama;
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
    
    
    
}
