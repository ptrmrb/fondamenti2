package traccia20210127;

import java.util.*;

import terminale.Terminale;

public class Sistema {
    private LinkedList<Fornitore> fornitori;
    private LinkedList<Merce> merci;

    public Sistema(LinkedList<Fornitore> fornitori, LinkedList<Merce> merci) {
        this.fornitori = new LinkedList<>(fornitori);
        this.merci = new LinkedList<>(merci);
    }

    //  Il metodo restituisce la lista dei nomi dei fornitori che forniscono il
    //  maggior numero di merci.

    public LinkedList<String> grandiFornitori()
    {
        int merciFornite;
        int maxMerciFornite = 0; 
        LinkedList<String> nomiGrandiFornitori = new LinkedList<>();

        for ( Fornitore f : fornitori )
        {   
            merciFornite = 0;
            String nomeFornitore = f.getNome();

            for ( Merce m : merci )
            {   
                Terminale.stampa(merciFornite);
                if ( m.getFornitori().contains(nomeFornitore) )
                {
                    merciFornite++;
                }
            }

            if ( ! ( merciFornite < maxMerciFornite ) )
                {
                    if ( maxMerciFornite == merciFornite ) 
                    {   
                        nomiGrandiFornitori.add(nomeFornitore);
                    }
                    else // merciFornite > maxMerciFornite
                    {
                        maxMerciFornite = merciFornite;
                        nomiGrandiFornitori.clear();
                        nomiGrandiFornitori.add(nomeFornitore);
                    }
                }
        }
        return nomiGrandiFornitori; 
    }

    /*  Il metodo restituisce la lista dei nomi dei fornitori
        che forniscono solo merci della marca passata come argomento. */

    public LinkedList<String> fornitoriMonoMarca(String marca){

        LinkedList<String> ret = new LinkedList<>(estraiFornitori()); //[ F1, F2, F3, F4 ]

        for ( Fornitore f : fornitori )
        {  
            String nomeFornitore = f.getNome();
            for ( Merce m : merci )
            {
                if ( m.getMarca() != marca && m.getFornitori().contains(nomeFornitore) )
                {
                    ret.remove(nomeFornitore);
                }
            }
        }
        return ret;
    }

    private LinkedList<String> estraiFornitori()
    {
        LinkedList<String> ret = new LinkedList<>();
        for ( Fornitore f : fornitori )
        {
            if ( !( ret.contains(f.getNome())) )
            {
                ret.add(f.getNome());
            }
        }
        return ret; 
    }

    /*Il metodo restituisce la lista dei nomi delle merci che sono fornite in almeno due città 
        diverse (una merce è fornita in una città se è fornita da un fornitore di tale città) */

    public LinkedList<String> merciCittaDiverse(){
        
        LinkedList<String> ret = new LinkedList<>();
        
            
        for ( Merce m : merci )
        {   
            LinkedList<String> fornitoriMerce = new LinkedList<>(m.getFornitori());
            LinkedList<String> cittaMerce = new LinkedList<>();
            for ( String fm : fornitoriMerce )
            {
                for ( Fornitore f : fornitori )
                {
                    if ( fm.equals(f.getNome()) && !( cittaMerce.contains(f.getCitta()) )) // se il fornitore corrisponde e la citta non si trova già nelle citta fornite
                        cittaMerce.add(f.getCitta()); // aggiungi alle citta fornite 
                }
            }
            if ( cittaMerce.size() >= 2 )
                ret.add(m.getNome());
        }
        return ret;
    } 

    public static void main(String[] args) {

        // Fornitori
        Fornitore f1 = new Fornitore("F1", "Roma");
        Fornitore f2 = new Fornitore("F2", "Roma");
        Fornitore f3 = new Fornitore("F3", "Milano");
        Fornitore f4 = new Fornitore("F4", "Roma");

        LinkedList<Fornitore> fornitori = new LinkedList<>(Arrays.asList(f1, f2, f3, f4));

        // Merci
        Merce m1 = new Merce("M1", "Barilla", new LinkedList<>(Arrays.asList("F1", "F4")));
        Merce m2 = new Merce("M2", "Barilla", new LinkedList<>(Arrays.asList("F1", "F2", "F3")));
        Merce m3 = new Merce("M3", "Voiello", new LinkedList<>(Arrays.asList("F3")));

        LinkedList<Merce> merci = new LinkedList<>(Arrays.asList(m1, m2, m3));

        Sistema s = new Sistema(fornitori, merci);

        // Testing methods
        Terminale.stampa("  ");   
        //Terminale.stampa(s.grandiFornitori());
        //System.out.println(s.fornitoriMonoMarca("Barilla"));
        System.out.println(s.merciCittaDiverse());
    
    }
}
