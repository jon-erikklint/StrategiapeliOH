package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;

public class RuutuKuva extends Grafiikkapainike implements Paivittyva{

    private ObjectKuva<Ruutu> ruutukuva;
    
    public RuutuKuva(Painike painike, ObjectKuva<Ruutu> kuva) {
        super(painike, kuva);
    }

    @Override
    public void paivita() {
        ruutukuva.paivita();
    }

}
