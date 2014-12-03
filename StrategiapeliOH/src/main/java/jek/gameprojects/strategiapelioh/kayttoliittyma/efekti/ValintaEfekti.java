package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.Arrays;
import java.util.List;

public abstract class ValintaEfekti<T> implements Efekti{
    
    private List<Efekti> efektit;
    private Tila tila;
    
    public ValintaEfekti(Tila tila, Efekti... efektit){
        this.efektit = Arrays.asList(efektit);
        this.tila = tila;
    }

    @Override
    public void toimi() {
        Efekti toimiva = valitseEfekti();
        toimiva.toimi();
    }
    
    public abstract Efekti valitseEfekti();

    public List<Efekti> getEfektit() {
        return efektit;
    }

    public Tila getTila() {
        return tila;
    }
}
