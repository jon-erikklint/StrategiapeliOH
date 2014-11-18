package jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;

public class Liikkuvuus {
    
    private Map<Aluetyyppi, Boolean> mihinVoiLiikkua;
    private Map<Maastotyyppi, Double> hitauskertoimetMaastossa;
    
    private int liikuntamaara;

    public Liikkuvuus(Map<Aluetyyppi, Boolean> mihinVoiLiikkua, Map<Maastotyyppi, Double> hitauskertoimetMaastossa, int liikuntamaara) {
        this.mihinVoiLiikkua = mihinVoiLiikkua;
        this.hitauskertoimetMaastossa = hitauskertoimetMaastossa;
        
        this.liikuntamaara=liikuntamaara;
    }

    public int getLiikuntamaara() {
        return liikuntamaara;
    }

    public void setLiikuntamaara(int liikuntamaara) {
        this.liikuntamaara = liikuntamaara;
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
    
}
