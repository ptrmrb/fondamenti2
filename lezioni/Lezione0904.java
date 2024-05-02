package lezioni;

import java.util.LinkedList;
import java.util.ListIterator;

public class Lezione0904 {

    public static int massimo(LinkedList<Integer> lista) {
        return massimoDa(lista.listIterator());
    }

    private static int massimoDa(ListIterator<Integer> it) {
        if (!it.hasNext())
            throw new IllegalArgumentException("La lista non può essere vuota");

        int valore = it.next();
        if (!it.hasNext())
            return valore; // caso di uscita

        return Math.max(valore, massimoDa(it));
    }

    public static int lunghezza(LinkedList<Integer> lista) {
        return lunghezzaDa(lista.listIterator());
    }

    private static int lunghezzaDa(ListIterator<Integer> it) {
        if (!it.hasNext())
            return 0;
        it.next();
        return 1 + lunghezzaDa(it);
    }

    public static boolean eCrescente(LinkedList<Integer> lista) {
        if (lista.isEmpty())
            return true;

        ListIterator<Integer> it = lista.listIterator();
        int primo = it.next();
        return eCrescenteDa(primo, it);
    }

    private static boolean eCrescenteDa(int ultimo, ListIterator<Integer> it) {
        if (!it.hasNext())
            return true;

        int nuovo = it.next();
        if (nuovo <= ultimo)
            return false;
        return eCrescenteDa(nuovo, it);
    }
}
