package traccia20180717;

import java.util.*;
import terminale.*;

public class Gestione 
{
    private static final int MAX_VALUE = 0;
    private LinkedList<Attore> attori;
    private LinkedList<Spettacolo> spettacoli;

    public Gestione() {
        this.attori = new LinkedList<>();
        this.spettacoli = new LinkedList<>();
    }

    public void aggiungiAttore(Attore attore) {
        attori.add(attore);
    }

    public void aggiungiSpettacolo(Spettacolo spettacolo) {
        spettacoli.add(spettacolo);
    }

    public LinkedList<Attore> getAttori() {
        return attori;
    }

    public LinkedList<Spettacolo> getSpettacoli() {
        return spettacoli;
    }


    /* Il metodo restituisce il numero massimo di attori recitanti in uno spettacolo di tipologia t  */

    public int spettacoliRicchi(String t){

        int ret = 0; 

        for ( Spettacolo s : spettacoli )
            if ( s.getTipologia().equals(t) )
                if ( s.getAttori().size() > ret )
                    ret = s.getAttori().size();

        return ret; 
    }

    /*. Il metodo restituisce la lista degli spettacoli tali che l’età media degli attori che vi partecipano
    è minima (tra tutti gli spettacoli presenti); */

    public LinkedList<Spettacolo> spettacoliGiovani()
    {
        LinkedList<Spettacolo> ret = new LinkedList<>();
        float mediaMinima = Integer.MAX_VALUE;
    
        for ( Spettacolo s : spettacoli ) // scorro gli spettacoli
        {
            LinkedList<String> nomiAttori = new LinkedList<>(s.getAttori());
            float mediaCorr = calcolaEtaMedia( nomiAttori ); // calcolo la media degli eta degli attori
            //Terminale.stampa(mediaCorr);

            if ( mediaCorr < mediaMinima ){
                mediaMinima = mediaCorr;
                ret.clear();
                ret.add(s);
            }
            else if ( mediaCorr == mediaMinima ){
                ret.add(s);
            }
        }
        return ret;
    }

    private float calcolaEtaMedia ( LinkedList<String> nomiAttori )
    {
        float ret = 0;

        for ( String nome : nomiAttori )
            for ( Attore a : attori )
                if ( a.getNome().equals(nome) )
                    ret += a.getEta();
        return ret / nomiAttori.size(); 
    }

    /*. Il metodo restituisce la lista degli attori che hanno recitato in spettacoli di tutte le tipologie disponibili.  */

    public LinkedList<Attore> attoriEclettici(){

        LinkedList<Attore> ret = new LinkedList<>();
        LinkedList<String> tipologie = estraiTipologie();
        for ( Attore a : attori )
        {
            LinkedList<String> tipologieAttore = new LinkedList<>();
            
            for ( Spettacolo s : spettacoli )
            {
                if ( s.getAttori().contains( a.getNome() ) && !tipologieAttore.contains( s.getTipologia() ))
                    tipologieAttore.add( s.getTipologia() );    
            }
            
            Terminale.stampa(tipologieAttore); 
            if ( contienteTutte(tipologie, tipologieAttore) )
                ret.add(a);
        }

        return ret;
    }

    private LinkedList<String> estraiTipologie ( )
    {
        LinkedList<String> ret = new LinkedList<>();
        for ( Spettacolo s : spettacoli )
        {
            if ( !ret.contains(s.getTipologia()) )
                ret.add(s.getTipologia());
        }
        return ret;
    }

    private boolean contienteTutte ( LinkedList<String> tipologie, LinkedList<String> tipologieAttore )
    {   
        for ( String t : tipologie )
            if ( !tipologieAttore.contains(t))
                return false;
        return true;
    }


    public static void main(String[] args){
        Gestione gestione = new Gestione();

        // Creazione degli attori
        Attore a1 = new Attore("Sara", 27);
        Attore a2 = new Attore("Laura", 28);
        Attore a3 = new Attore("Andrea", 37);
        Attore a4 = new Attore("Francesco", 32);
        Attore a5 = new Attore("Maria", 40);

        // Aggiunta degli attori alla gestione
        gestione.aggiungiAttore(a1);
        gestione.aggiungiAttore(a2);
        gestione.aggiungiAttore(a3);
        gestione.aggiungiAttore(a4);
        gestione.aggiungiAttore(a5);

        // Creazione degli spettacoli
        LinkedList<String> attoriS0 = new LinkedList<>();
        attoriS0.add("Sara");
        attoriS0.add("Francesco");
        Spettacolo s0 = new Spettacolo(0, "storico", attoriS0);

        LinkedList<String> attoriS1 = new LinkedList<>();
        attoriS1.add("Andrea");
        attoriS1.add("Maria");
        Spettacolo s1 = new Spettacolo(1, "musicale", attoriS1);

        LinkedList<String> attoriS2 = new LinkedList<>();
        attoriS2.add("Sara");
        attoriS2.add("Laura");
        Spettacolo s2 = new Spettacolo(2, "storico", attoriS2);

        LinkedList<String> attoriS3 = new LinkedList<>();
        attoriS3.add("Laura");
        attoriS3.add("Maria");
        attoriS3.add("Andrea");
        Spettacolo s3 = new Spettacolo(3, "sperimentale", attoriS3);

        LinkedList<String> attoriS4 = new LinkedList<>();
        attoriS4.add("Laura");
        attoriS4.add("Maria");
        attoriS4.add("Sara");
        attoriS4.add("Andrea");
        Spettacolo s4 = new Spettacolo(4, "commedia", attoriS4);

        LinkedList<String> attoriS5 = new LinkedList<>();
        attoriS5.add("Andrea");
        attoriS5.add("Francesco");
        attoriS5.add("Sara");
        attoriS5.add("Maria");
        Spettacolo s5 = new Spettacolo(5, "storico", attoriS5);

        LinkedList<String> attoriS6 = new LinkedList<>();
        attoriS6.add("Laura");
        Spettacolo s6 = new Spettacolo(6, "commedia", attoriS6);

        LinkedList<String> attoriS7 = new LinkedList<>();
        attoriS7.add("Sara");
        attoriS7.add("Laura");
        Spettacolo s7 = new Spettacolo(7, "sperimentale", attoriS7);

        // Aggiunta degli spettacoli alla gestione
        gestione.aggiungiSpettacolo(s0);
        gestione.aggiungiSpettacolo(s1);
        gestione.aggiungiSpettacolo(s2);
        gestione.aggiungiSpettacolo(s3);
        gestione.aggiungiSpettacolo(s4);
        gestione.aggiungiSpettacolo(s5);
        gestione.aggiungiSpettacolo(s6);
        gestione.aggiungiSpettacolo(s7);

        /*  Stampa delle informazioni
        System.out.println("Attori:");
        for (Attore attore : gestione.getAttori()) {
            System.out.println(attore);
        }

        System.out.println("\nSpettacoli:");
        for (Spettacolo spettacolo : gestione.getSpettacoli()) {
            System.out.println(spettacolo);
        }
        */

        //Terminale.stampa(gestione.spettacoliRicchi("storico"));
        //Terminale.stampa(gestione.spettacoliGiovani());
        Terminale.stampa(gestione.attoriEclettici());
    }   
    
}
