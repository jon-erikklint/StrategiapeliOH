package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

public class Hyokkays {
    
    private int kantama;
    private boolean kaukotaistelu;

    public Hyokkays(int kantama, boolean kaukotaistelu) {
        this.kantama = kantama;
        this.kaukotaistelu = kaukotaistelu;
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
    
}
