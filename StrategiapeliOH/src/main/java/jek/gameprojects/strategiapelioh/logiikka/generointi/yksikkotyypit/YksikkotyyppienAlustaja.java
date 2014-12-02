package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikkotyypit;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

public interface YksikkotyyppienAlustaja {
    
    public abstract Map<String, Yksikkotyyppi> alustaYksikkotyypit() throws Exception;
    
}
