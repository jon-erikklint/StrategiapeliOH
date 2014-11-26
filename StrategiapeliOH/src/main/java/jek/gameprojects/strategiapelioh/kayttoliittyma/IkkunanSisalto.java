package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.AloitusRuutu;

public class IkkunanSisalto extends JPanel{
    
    private List<Ruutu> ruudut;
    private Integer aktiivinenRuutu;
    
    private HiirenKuuntelija hiirenKuuntelija;
    private NappaimistonKuuntelija nappaimistonKuuntelija;
    
    public IkkunanSisalto(){
        hiirenKuuntelija = new HiirenKuuntelija();
        nappaimistonKuuntelija = new NappaimistonKuuntelija();
        
        super.addMouseListener(hiirenKuuntelija);
        super.addKeyListener(nappaimistonKuuntelija);
        
        ruudut = new ArrayList<>();
        AloitusRuutu aloitusRuutu = new AloitusRuutu();
        
        aktiivinenRuutu=0;
    }
    
    public void lisaaRuutu(Ruutu ruutu){
        ruudut.add(ruutu);
    }
    
    public void setAktiivinenRuutu(int n){
        if(n>=0 && n<ruudut.size()){
            aktiivinenRuutu = n;
        }
    }
    
}
