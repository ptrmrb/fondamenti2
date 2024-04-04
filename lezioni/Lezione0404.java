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

    }

}