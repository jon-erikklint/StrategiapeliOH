package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

public class RuudunValintaEfekti extends ValintaEfekti<Integer>{

    public RuudunValintaEfekti(Tila<Integer> tila, AktivoiRuutu aktivoiRuutu, HyokkaaRuutuun hyokkaaRuutuun, LiikuRuutuun liikuRuutuun) {
        super(tila, aktivoiRuutu, hyokkaaRuutuun);
    }

    @Override
    public Efekti valitseEfekti() {
        return super.getEfektit().get((int) super.getTila().getMuuttuja());
    }
    
}
