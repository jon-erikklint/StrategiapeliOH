package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

public class Ajastin implements Paivittyva{
    
    private long kuluttavaAika;
    private long aloitusaika;
    
    private boolean onkoLoppu;
    
    public Ajastin(long kuluttavaAika){
        this.kuluttavaAika = kuluttavaAika;
        aloitusaika = System.currentTimeMillis();
        
        onkoLoppu = false;
    }

    @Override
    public void paivita() {
        if(System.currentTimeMillis()>aloitusaika+kuluttavaAika){
            onkoLoppu = true;
        }
    }
    
    public boolean onkoLoppu(){
        return onkoLoppu;
    }
    
}
