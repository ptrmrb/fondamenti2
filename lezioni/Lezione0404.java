package lezioni;

public class Lezione0404
{
    public static void main(String[] args)
    {
        LinkedList<Integer> lista = new LinkedList<>();

        lista.addLast(35);
        lista.addFirst(62);
        lista.addLast(24);
        Terminale.stampa(lista.getFirst());
        Terminale.stampa(lista.getLast());

        // metodi comuni alle collection di java: size, contain, clear -> documentazione  
        
        ListIterator<Integer> iteratore = lista.listIterator(); // si trova prima del primo elemento

        // l'iteratore si muove tra gli elementi della linked list tramite comandi come next e previous

        iteratore.next();
        
        // e possiamo sfruttarlo per aggiungere valori nella posizione in cui si trova

        lista.add(29);

        // possiamo anche sfruttarlo con dei cicli

        int v = iteratore.next();

        while(v != 29 ){
            v  = iteratore.next();
        }
        iteratore.add(100);
        Terminale.stampa(lista);

        // se invoco la funzione remove, l'iteratore rimuove l'ultimo valore attraversato
        // infatti funziona solamente nel momento in cui l'iteratore attraversa qualche valore

        iteratore.set(70); 

        // imposta il valore 70 al valore che ha appena attraversato

        // esercizio: calcola la somma della lista a partire da un elemento

        // portare l'iteratore in posizione con iteratore.next e previous

        int s = sommaDa(iteratore);
        Terminale.stampa(s);

    }

    private static int sommaDa( ListIterator<Integer>  it )
    {
        if ( !it.hasNext() )
            return 0;

        int valore = it.next();
        return valore + sommaDa(it); 

    }

    public static int somma( LinkedList lista)
    {   ListIterator<Integer> it = lista.listIterator();
    return sommaDa(it);
    }

    // ricorsione in coda -> prendo il primo valore e poi faccio la ricorsione sugli altri elementi
    // al contrario della ricorsione in coda che prima effettua la ricorsione e poi effettua un calcolo"


    public static boolean ePalidroma( String s )
    {
        int lunghezza = s.length(); 
        if ( lunghezza < 2 )
            return True;
        if ( s.charAt(0) != s.charAt ( lunghezza - 1))
            return False;
            
        String m = s.substring(1, lunghezza -1);
        return ePalidroma(m);

    }
}   