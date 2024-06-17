package traccia20240216;

import java.util.*;


import terminale.Terminale;


// Classe Sistema
public class Sistema {
    private LinkedList<Viaggio> listaViaggi = new LinkedList<>();
    private LinkedList<Conducente> listaConducenti = new LinkedList<>();

    // che  restituisce  true  se  e  solo  se  per  ogni 
    // destinazione esistono al più numMax viaggi il cui conducente si chiama nomeConducente;  

    public boolean verifica(int numMax, String nomeConducente) {
        LinkedList<String> destinazioni = new LinkedList<>(estraiDestinazioni()); // inserisco in una lista le singole destinazioni senza ripetizioni
        int nViaggi = 0;

        for ( String dest : destinazioni ) // scorro le destinazioni 
        {
            for ( Viaggio v : listaViaggi ) // scorro i viaggi
            {
                if ( dest.equals(v.getDestinazione()) ) // controllo che quel viaggio abbia quella destinazione
                {
                    if ( estraiConducente(v).equals(nomeConducente) ) // se il conducente del viaggio è quello dato in input 
                        nViaggi ++;
                }
            }
            Terminale.stampa(nViaggi);
            if ( nViaggi >= numMax ) // se il numero di viaggi fatti dal conducente verso la attuale destinazione è maggiore o uguale del numero massimo allora restuisco falso 
                return false;
            nViaggi = 0; // altrimenti azzero il numero di viaggi correnti e ricomincio 
        }
        return true; 
    }

    private LinkedList<String> estraiDestinazioni ( )
    {
        LinkedList<String> ret = new LinkedList<>();
        for ( Viaggio v : listaViaggi )
            if ( !ret.contains(v.getDestinazione() ) )
                ret.add(v.getDestinazione()); 
        return ret; 
    }

    private String estraiConducente ( Viaggio viaggio )
    {
        String ret = null;

        for ( Conducente cond : listaConducenti )
        {
            if ( cond.getViaggi().contains(viaggio.getCodice()) )
                ret = cond.getNome();
        }
        return ret; 
    }

    /* Il metodo restituisce la lista dei nomi dei conducenti che risultano sovraccarichi,
    ossia che hanno effettuato un numero di viaggi uguale almeno al doppio del numero 
    di viaggi medio per conducente. */
    
    public LinkedList<String> conducentiSovraccarichi() {
        LinkedList<String> ret = new LinkedList<>();

        for ( Conducente cond : listaConducenti )
            if ( isSovraccarico(cond) )
                ret.add(cond.getNome());
        return ret; 
    }

    private boolean isSovraccarico(Conducente c)
    {
        float viaggiMedio = calcolaMedia();

        if ( c.getViaggi().size() >= 2*viaggiMedio )
            return true;
        return false; 
    }

    private float calcolaMedia()
    {
        float nViaggi = 0;
        int nConducenti = 0; 
        for ( Conducente c : listaConducenti )
        {
            nConducenti ++;
            nViaggi += c.getViaggi().size();
        }
        return nViaggi / nConducenti ; 
    }

    /* Il metodo restituisce la lista dei nomi distinti dei conducenti tali che la durata
    complessiva e il numero di passeggeri complessivo dei loro viaggi sono gli stessi che
    caratterizzano il conducente di nome nomeConducente. */

    public LinkedList<String> stesseCaratteristiche( String nomeConducente ) {
        
        LinkedList<String> ret = new LinkedList<>(); 

        int durataComplessiva = calcolaDurataComplessiva(trovaConducente(nomeConducente)); 
        int passeggeriComplessivi = calcolaPasseggeriComplessivi(trovaConducente(nomeConducente));

        int durataCorrente = 0;
        int passeggeriCorrenti = 0;

        for ( Conducente c : listaConducenti )
        {
            if ( c.getNome().equals(nomeConducente) ) // controllo per verificare che il nome campione non sia nella lista resituita
                break;
            
            durataCorrente = calcolaDurataComplessiva(c);
            passeggeriCorrenti = calcolaPasseggeriComplessivi(c);

            if ( durataComplessiva == durataCorrente &&
                passeggeriComplessivi == passeggeriCorrenti )
                ret.add(c.getNome());
        }

        return ret; 
    }

    private int calcolaDurataComplessiva( Conducente c )
    {
        int durata = 0 ; 

        for ( Viaggio v : listaViaggi )
            if ( c.getViaggi().contains(v.getCodice()) )
                durata += v.getDurata();

        return durata;
    }

    private int calcolaPasseggeriComplessivi( Conducente c )
    {
        int passeggeri = 0;

        for ( Viaggio v : listaViaggi )
            if ( c.getViaggi().contains(v.getCodice()) )
                passeggeri += v.getNumPasseggeri(); 

        return passeggeri;
    }

    private Conducente trovaConducente( String c )
    {
        for ( Conducente cond : listaConducenti )
            if ( c.equals(cond.getNome()))
                return cond;

        return null;
    }


    public static void main(String[] args) {
        // Creazione degli oggetti delle classi di supporto
        LinkedList<String> viaggiRossi = new LinkedList<>();
        viaggiRossi.add("V1");
        viaggiRossi.add("V3");
        viaggiRossi.add("V5");
        viaggiRossi.add("V6");

        LinkedList<String> viaggiBianchi = new LinkedList<>();
        viaggiBianchi.add("V2");

        LinkedList<String> viaggiVerdi = new LinkedList<>();
        viaggiVerdi.add("V4");

        Conducente rossi = new Conducente("Rossi", viaggiRossi);
        Conducente bianchi = new Conducente("Bianchi", viaggiBianchi);
        Conducente verdi = new Conducente("Verdi", viaggiVerdi);

        Viaggio v1 = new Viaggio("V1", "Roma", 2, 5);
        Viaggio v2 = new Viaggio("V2", "Roma", 8, 20);
        Viaggio v3 = new Viaggio("V3", "Salerno", 2, 5);
        Viaggio v4 = new Viaggio("V4", "Salerno", 4, 70);
        Viaggio v5 = new Viaggio("V5", "Reggio Calabria", 3, 5);
        Viaggio v6 = new Viaggio("V6", "Roma", 1, 5);

        // Creazione del sistema
        Sistema sistema = new Sistema();
        sistema.listaViaggi.add(v1);
        sistema.listaViaggi.add(v2);
        sistema.listaViaggi.add(v3);
        sistema.listaViaggi.add(v4);
        sistema.listaViaggi.add(v5);
        sistema.listaViaggi.add(v6);

        sistema.listaConducenti.add(rossi);
        sistema.listaConducenti.add(bianchi);
        sistema.listaConducenti.add(verdi);

        // Esempi di utilizzo dei metodi di Sistema
        boolean risultatoVerifica = sistema.verifica(1, "Rossi");
        LinkedList<String> conducentiSovraccarichi = sistema.conducentiSovraccarichi();
        LinkedList<String> stessiCaratteristiche = sistema.stesseCaratteristiche("Bianchi");

        // Output degli esempi
        System.out.println("Risultato verifica: " + risultatoVerifica);
        System.out.println("Conducenti sovraccarichi: " + conducentiSovraccarichi);
        System.out.println("Stessi caratteristiche di Bianchi: " + stessiCaratteristiche);
    }
}