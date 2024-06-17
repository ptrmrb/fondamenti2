package traccia20200703;

import java.util.ArrayList;
import java.util.LinkedList;


import terminale.Terminale;

public class Sistema {
    private LinkedList<Acquisto> acquisti;
    private LinkedList<Negozio> negozi;

    public Sistema(LinkedList<Acquisto> acquisti, LinkedList<Negozio> negozi) {
        this.acquisti = new LinkedList<>(acquisti);
        this.negozi = new LinkedList<>(negozi);
    }

    /**
     *
     * @param data
     * @return la lista dei nomi dei negozi presso i quali, nel giorno data,
     * sono stati effettuati il maggior numero di acquisti.
     */

    public LinkedList<String>  negoziPreferiti(int  data)
    {
        LinkedList<String> ret = new LinkedList<>();
        int maxAcquisti = 0;
        int corr = 0;

        for ( Negozio n : negozi )
        {   
            corr = 0;
            for ( Acquisto a : acquisti )
            {
                if ( a.getNomeNegozio().equals(n.getNome()) && a.getData() == data )
                    corr ++;
            }

            if ( corr > maxAcquisti )
            {
                ret.clear();
                ret.add(n.getNome());
                maxAcquisti = corr; 
            }
            else if ( corr == maxAcquisti )
                ret.add(n.getNome()); 
        }

        return ret;
    }

    


    /**
     *
     * @param dataInizio
     * @param dataFine
     * @return la lista dei codici fiscali dei clienti che,
     * nel periodo compreso tra il giorno dataInizio e il giorno dataFine (estremi inclusi),
     * hanno effettuato acquisti solo in negozi ubicati in una città diversa
     * da quella in cui risiedono.
     */

    public  LinkedList<String> clientiEsterniPeriodo(int  dataInizio,  int  dataFine)
    {
        LinkedList<String> ret = new LinkedList<>();



        return ret;
    }

    /**
     *
     * @return la lista dei codici fiscali dei clienti che hanno effettuato acquisti presso
     * almeno 2 città diverse (un acquisto si intende effettuato presso una città se
     * è effettuato presso un negozio di tale città).
     */
    

    public static void main(String[] args) {

        LinkedList<Negozio> negozi = new LinkedList<>();
        negozi.add(new Negozio("Negozio A", "Roma"));
        negozi.add(new Negozio("Negozio B", "Roma"));
        negozi.add(new Negozio("Negozio C", "Milano"));

        LinkedList<Acquisto> acquisti = new LinkedList<>();
        acquisti.add(new Acquisto("Negozio A", "ABCDEF", "Roma", 10));
        acquisti.add(new Acquisto("Negozio A", "GHIJKL", "Napoli", 10));
        acquisti.add(new Acquisto("Negozio A", "MNOPQR", "Palermo", 10));
        acquisti.add(new Acquisto("Negozio B", "MNOPQR", "Palermo", 10));
        acquisti.add(new Acquisto("Negozio B", "GHIJKL", "Napoli", 20));
        acquisti.add(new Acquisto("Negozio C", "MNOPQR", "Palermo", 20));
        acquisti.add(new Acquisto("Negozio C", "ABCDEF", "Roma", 20));

        Sistema s = new Sistema(acquisti, negozi);

        System.out.println(s.negoziPreferiti(10));// restituisce la lista [“Negozio A”].
        //System.out.println(s.clientiEsterniPeriodo(10, 20));// restituisce la lista [“GHIJKL” , “MNOPQR”].
        //System.out.println(s.clientiCittaDiverse());// restituisce la lista [“ABCDEF”, “MNOPQR”].
    }





}
