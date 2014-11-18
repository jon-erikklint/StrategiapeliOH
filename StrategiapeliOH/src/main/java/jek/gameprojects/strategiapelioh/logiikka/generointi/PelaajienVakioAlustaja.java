/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class PelaajienVakioAlustaja implements PelaajienAlustaja{
    
    @Override
    public List<Pelaaja> alustaPelaajat(List<String> pelaajienNimet) {
        List<Pelaaja> pelaajat = new ArrayList<>();
        
        int id=0;
        
        for(String nimi : pelaajienNimet){
            Pelaaja pelaaja = new Pelaaja(id, nimi);
            pelaajat.add(pelaaja);
            
            id++;
        }
        
        return pelaajat;
    }
    
}
