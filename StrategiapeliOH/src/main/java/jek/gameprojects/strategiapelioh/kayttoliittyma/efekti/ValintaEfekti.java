package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.Arrays;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;

public abstract class ValintaEfekti extends PelitilaEfekti{
    
    private List<Efekti> efektit;
    
    public ValintaEfekti(Pelitila pelitila, Efekti... efektit){
        super(pelitila);
        
        this.efektit = Arrays.asList(efektit);
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
}
