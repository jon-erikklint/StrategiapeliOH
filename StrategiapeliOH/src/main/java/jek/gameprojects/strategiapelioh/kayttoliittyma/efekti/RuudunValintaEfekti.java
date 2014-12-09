package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class RuudunValintaEfekti extends ValintaEfekti{

    public RuudunValintaEfekti(Pelitila pelitila, AktivoiRuutu aktivoiRuutu, HyokkaaRuutuun hyokkaaRuutuun, LiikuRuutuun liikuRuutuun) {
        super(pelitila, aktivoiRuutu, hyokkaaRuutuun, liikuRuutuun);
    }

    @Override
    public Efekti valitseEfekti() {
        return super.getEfektit().get(pelitila.getTilat().getPelitila());
    }
    
}
