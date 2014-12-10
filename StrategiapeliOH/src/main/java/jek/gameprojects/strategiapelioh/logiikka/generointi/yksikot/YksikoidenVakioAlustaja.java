package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

public class YksikoidenVakioAlustaja implements YksikoidenAlustaja{

    private Indeksoija yksikoidenIndeksoija;
    private Map<String, Yksikkotyyppi> yksikkotyypit;
    private Kartta kartta;
    
    @Override
    public void alustaYksikot(Kartta kartta, Map<Integer, Pelaaja> pelaajat, Map<String, Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija) throws Exception {
        this.yksikoidenIndeksoija = yksikoidenIndeksoija;
        this.yksikkotyypit = yksikkotyypit;
        this.kartta = kartta;
        
        
        List<Koordinaatti> pelaajan1 = new ArrayList<>();
        pelaajan1.add(new Koordinaatti(2,0));
        pelaajan1.add(new Koordinaatti(0,2));
        pelaajan1.add(new Koordinaatti(1,0));
        pelaajan1.add(new Koordinaatti(0,1));
        
        List<Koordinaatti> pelaajan2 = new ArrayList<>();
        pelaajan2.add(new Koordinaatti(7,9));
        pelaajan2.add(new Koordinaatti(9,7));
        pelaajan2.add(new Koordinaatti(8,9));
        pelaajan2.add(new Koordinaatti(9,8));
        
        alustaPelaajanYksikot(pelaajat.get(0), pelaajan1);
        alustaPelaajanYksikot(pelaajat.get(1), pelaajan2);
    }
    
    private void alustaPelaajanYksikot(Pelaaja pelaaja, List<Koordinaatti> sijoitusKoordinaatit){
        Joukko puolustusjoukko1 = new Joukko();
        Joukko puolustusjoukko2 = new Joukko();
        Joukko hyokkaysjoukko1 = new Joukko();
        Joukko hyokkaysjoukko2 = new Joukko();
        
        for(int i=0; i<2; i++){
            Joukko lisattava = valitseJoukkoJakojaannoksella(hyokkaysjoukko1, hyokkaysjoukko2, i);
            
            alustaYksikko(yksikkotyypit.get("Tuhoaja"), pelaaja, lisattava, sijoitusKoordinaatit.get(i));
        }
        
        for(int i=0;i<4;i++){
            Joukko lisattava = valitseJoukkoJakojaannoksella(hyokkaysjoukko1, hyokkaysjoukko2, i);
            
            alustaYksikko(yksikkotyypit.get("Tiedustelija"), pelaaja, lisattava, sijoitusKoordinaatit.get(i%2));
        }
        
        for(int i=0; i<2; i++){
            Joukko lisattava = valitseJoukkoJakojaannoksella(puolustusjoukko1, puolustusjoukko2, i);
            
            alustaYksikko(yksikkotyypit.get("Puolustuslinnoitus"), pelaaja, lisattava, sijoitusKoordinaatit.get(i+2));
        }
        
        for(int i=0; i<2; i++){
            Joukko lisattava = valitseJoukkoJakojaannoksella(puolustusjoukko1, puolustusjoukko2, i);
            
            alustaYksikko(yksikkotyypit.get("Tykki"), pelaaja, lisattava, sijoitusKoordinaatit.get(i+2));
        }
        
        alustaYksikko(yksikkotyypit.get("Tarkka-ampuja"), pelaaja, puolustusjoukko2, sijoitusKoordinaatit.get(3));
        
        pelaaja.lisaaJoukko(puolustusjoukko1);
        pelaaja.lisaaJoukko(puolustusjoukko2);
        pelaaja.lisaaJoukko(hyokkaysjoukko1);
        pelaaja.lisaaJoukko(hyokkaysjoukko2);
        
        asetaJoukotRuutuihin(puolustusjoukko1, puolustusjoukko2, hyokkaysjoukko1, hyokkaysjoukko2);
    }
    
    private Joukko valitseJoukkoJakojaannoksella(Joukko a, Joukko b, int n){
        if(n%2==0){
            return a;
        }
        
        return b;
    }
    
    private Yksikko alustaYksikko(Yksikkotyyppi yksikkotyyppi, Pelaaja omistaja, Joukko joukko, Koordinaatti sijainti){
        return new Sotilas(yksikkotyyppi, sijainti, omistaja, joukko, yksikoidenIndeksoija.nextIndex());
    }
    
    private void asetaJoukotRuutuihin(Joukko... joukot){
        for(Joukko joukko : joukot){
            Ruutu sijainti = kartta.getRuutu(joukko.getSijainti());
            
            sijainti.lisaaJoukko(joukko);
        }
    }
    
}
