package lezione;

import java.util.*;
import terminale.*;

public class Lezione0904 {

    public static int massimo(LinkedList<Integer> lista)
    {
        return massimoDa(lista.listIterator());        

    }

    private static int massimoDa(LinkedList<Integer> it)
    {
        int valore = it.next(); 
        if ( !it.hasNext() )
            return valore; // caso di uscita 

        return Math.max(valore, massimoDa(it)); 
    }

    public static int lunghezza (LinkedList<Iterator> lista) // per definire la lunghezza basta sommare 1 + la lunghezza del resto della lista
    {
        return lunghezzaDa(lista.listIterator());
    }

    private static int lunghezzaDa( LinkedList<Integer> it)
    {
        if ( ! it.hasNext() )
            return 0; // se non ha successivo vuol dire che 
        it.next(); 
        return 1 + lunghezzaDa (it);
    }
}