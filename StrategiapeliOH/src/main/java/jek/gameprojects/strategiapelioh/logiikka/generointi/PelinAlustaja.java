package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

public abstract class PelinAlustaja {
    
    public abstract List<Pelaaja> alustaPelaajat(List<String> pelaajienNimet);
    
    public abstract List<Yksikkotyyppi> alustaYksikkotyypit() throws Exception;
    
    public abstract Kartta alustaKartta() throws Exception;
    
    public abstract void alustaYksikot(List<Pelaaja> pelaajat, Kartta kartta) throws Exception;
    
}
