package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

public interface PelitietojenAlustaja {
    
    public abstract List<Yksikkotyyppi> alustaYksikkotyypit() throws Exception;
    
}
