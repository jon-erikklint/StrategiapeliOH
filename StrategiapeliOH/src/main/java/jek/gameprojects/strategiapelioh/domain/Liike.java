package jek.gameprojects.strategiapelioh.domain;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;

public class Liike {
    
    private Vektori kohde;
    private int tarvittavaLiikunta;

    public Liike(Vektori kohde, int tarvittavaLiikunta) {
        this.kohde = kohde;
        this.tarvittavaLiikunta = tarvittavaLiikunta;
    }

    public Vektori getKohde() {
        return kohde;
    }

    public void setKohde(Vektori kohde) {
        this.kohde = kohde;
    }

    public int getTarvittavaLiikunta() {
        return tarvittavaLiikunta;
    }

    public void setTarvittavaLiikunta(int tarvittavaLiikunta) {
        this.tarvittavaLiikunta = tarvittavaLiikunta;
    }
    
    
}
