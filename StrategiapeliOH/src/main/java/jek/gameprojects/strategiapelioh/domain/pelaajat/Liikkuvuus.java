package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.maasto.Maastotyyppi;

public class Liikkuvuus {
    
    private Map<Aluetyyppi, Boolean> mihinVoiLiikkua;
    private Map<Maastotyyppi, Double> hitauskertoimetMaastossa;
    private int liikkuvuus;

    public Liikkuvuus(Map<Aluetyyppi, Boolean> mihinVoiLiikkua, Map<Maastotyyppi, Double> hitauskertoimetMaastossa) {
        this.mihinVoiLiikkua = mihinVoiLiikkua;
        this.hitauskertoimetMaastossa = hitauskertoimetMaastossa;
    }
    
    public Map<Aluetyyppi, Boolean> getMihinVoiLiikkua() {
        return mihinVoiLiikkua;
    }

    public void setMihinVoiLiikkua(Map<Aluetyyppi, Boolean> mihinVoiLiikkua) {
        this.mihinVoiLiikkua = mihinVoiLiikkua;
    }

    public Map<Maastotyyppi, Double> getHitauskertoimetMaastossa() {
        return hitauskertoimetMaastossa;
    }

    public void setHitauskertoimetMaastossa(Map<Maastotyyppi, Double> hitauskertoimetMaastossa) {
        this.hitauskertoimetMaastossa = hitauskertoimetMaastossa;
    }

    public int getLiikkuvuus() {
        return liikkuvuus;
    }

    public void setLiikkuvuus(int liikkuvuus) {
        this.liikkuvuus = liikkuvuus;
    }
    
}
