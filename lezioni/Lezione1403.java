package lezioni;

import terminale.*;
import java.util.*;

public class Lezione1403 {
    // al contrario di java per quanto riguarda le arrayList non possiamo aggiungere 
    // ad un arraylist di integer un arraylist di integer al contrario di python
    // possiamo farlo con il metodo " addAll()"

    public static void main(String[] args)
    {
        Comitiva c = new Comitiva();
        c.aggiungiPartecipante(new Persona("Mario", "Rossi", 2005));
        c.aggiungiPartecipante(new Persona("Luigi", "Neri", 2000));
        Terminale.stampa(c);
        c.rimuoviPartecipante(new Persona("Luigi", "Neri", 2000));

        // oppure posso assegnare le due persone a due variabili e poi andare a eliminare
        // direttamente una delle due variabili sempre attraverso il metodo. 

        /*
         * Persona p1 = new Persona("Mario", "Rossi", 2005);
         * Persona p2 = new Persona("Luigi", "Neri", 2000);
         * 
         * c.aggiungiPartecipante(p1);
         * c.aggiungiPartecipante(p2);
         * 
         * Terminale.stampa(c);
         * 
         * c.rimuoviPartecipante(p2);
         * 
         * Terminale.stampa(c);
         * 
         */

         Biglietto b1 = new Biglietto();
         Terminale.stampa(b1);
         Biglietto b2 = new Biglietto();
         Terminale.stampa(b2);
         Biglietto b3 = new Biglietto();
         Terminale.stampa(b3);
    }
}
