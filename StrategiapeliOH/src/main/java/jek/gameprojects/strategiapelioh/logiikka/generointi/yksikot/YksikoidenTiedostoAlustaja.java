package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;
import jek.gameprojects.strategiapelioh.logiikka.generointi.TiedostoAlustaja;

public class YksikoidenTiedostoAlustaja extends TiedostoAlustaja implements YksikoidenAlustaja{

    private Kartta kartta;
    private Map<Integer,Pelaaja> pelaajat;
    private Map<String,Yksikkotyyppi> yksikkotyypit;
    
    private Indeksoija yksikoidenIndeksoija;
    
    public YksikoidenTiedostoAlustaja(String tiedostonNimi) throws Exception{
        super(tiedostonNimi);
    }
    
    private void alustus(Kartta kartta, Map<Integer, Pelaaja> pelaajat, Map<String,Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija){
        this.yksikoidenIndeksoija = yksikoidenIndeksoija;
        
        this.kartta=kartta;
        this.pelaajat=pelaajat;
        this.yksikkotyypit=yksikkotyypit;
    }
    
    private void lopetus(){
        this.kartta=null;
        this.pelaajat=null;
        this.yksikkotyypit=null;
    }
    
    @Override
    public void alustaYksikot(Kartta kartta, Map<Integer, Pelaaja> pelaajat, Map<String,Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija) throws Exception {
        
        alustus(kartta, pelaajat, yksikkotyypit, yksikoidenIndeksoija);
        
        while(true){
            if(nykyinen().equals("-")){
                break;
            }
            
            tarkistaLukukohta();
            
            alustaYksikko();
        }
        
        lopetus();   
    }
    
    private void alustaYksikko() throws Exception{
        
        Yksikkotyyppi yksikkotyyppi = haeYksikkotyyppi();
        Koordinaatti koordinaatti = tulkitseKoordinaatti();
        Pelaaja pelaaja = haePelaaja();
        
        Joukko joukko = new Joukko();
        int indeksi = yksikoidenIndeksoija.nextIndex();
        
        Yksikko yksikko = new Yksikko(yksikkotyyppi, koordinaatti, pelaaja, joukko, indeksi);
        
        luodunYksikonAlustus(yksikko);
    }
    
    private void luodunYksikonAlustus(Yksikko yksikko){
        
        kartta.getRuutu( yksikko.getSijainti() ).getJoukot().add( yksikko.getJoukko() );
        
    }
    
    private Yksikkotyyppi haeYksikkotyyppi() throws Exception{
        String yksikkotyypinNimi = annaString();
        
        try{    
            return yksikkotyypit.get(yksikkotyypinNimi);
        }catch(Exception e){    
            throw new Exception("Haluttua yksikkötyyppiä ei löydetty rivillä "+(lukukohta()-1));
        }
    }
    
    private Pelaaja haePelaaja() throws Exception{
        int pelaajanId = tulkitseKokonaisluku();
        
        try{
            return pelaajat.get(pelaajanId);
        }catch(Exception e){
            throw new Exception("Pelaajaa ei löydetty indeksillä");
        }
    }
    
}
