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

    /////////////////////////////////////////////

    public static int lunghezza (LinkedList<Iterator> lista) // per definire la lunghezza basta sommare 1 + la lunghezza del resto della lista
    {
        return lunghezzaDa(lista.listIterator());
    }

    private static int lunghezzaDa( LinkedList<Integer> it)
    {
        if ( ! it.hasNext() )
            return 0; 
        it.next(); 
        return 1 + lunghezzaDa (it);
    }

    /////////////////////////////////////////////

    // supponiamo che la lista 

    public static boolean eCrescente( LinkedList<Integer> lista )
    {   
        if(lista.isEmpty())
            return True;

        ListaIterator<Integer> it = lista.ListIterator();
        int primo = it.next();
        return eCrescenteDa(primo, it); 
        

    }

    private static boolean eCrescenteDa( int ultimo, ListIterator<Integer> it )
    {
        if(!it.hasNext())
            return True;

        int nuovo = it.next(); 
        if ( nuovo <= ultimo)
            return false;
        return eCrescenteDa(nuovo, it);
    }

    // per casa fare una variante usando anche .previous()


    
}

