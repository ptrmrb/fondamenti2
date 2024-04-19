import terminale.*;
import java.util.*;

public class Lezione1303 
{
    public static void main(String[] args)
    {
        /*
        Lampadina[] lampadine = new Lampadina[101];
        lampadine[0] = null;
        for (int i = 0; i<=100; i++){
            lampadine[i] = new Lampadina();
        }
        
        for (int numeroPersona = 1; numeroPersona <= 100; numeroPersona ++){
            for (int i = numeroPersona; i<=100; i += numeroPersona){
                lampadine[i].premiBottone();
                
            }
        }

        for (int i = 1; i <=100; i++){
            if(lampadine[i].eAccesa())
                Terminale.stampa("La lampadina " + i + " è rimasta accesa. ");
        }

        */

        // l'array di lunghezza variavbile è l'arraylist 
        // La classa ArrayList non può contenere tipi primitivi, solo oggetti. E tutti gli oggetti
        // all'interno di un arraylist devo essere gli stessi. 
        // ArrayList a = new ArrayList(); NON SI PUO FARE

        ArrayList<String> a = new ArrayList<>(); // è MUTABILISSIMO RAGA
        Terminale.stampa(a.size()); // dice la quantità di oggetti contenuti nell'arraylist 
        // JFC = JAVA COLLECTIONS FRAMEWORK 

        a.add("abc");
        a.add("def");
        a.add("ghi");

        Terminale.stampa(a.size());
        Terminale.stampa(a.get(1)); // prende l'elemento in posizione 1
        Terminale.stampa(a.isEmpty()); // controlla se è vuoto 
        //a.clear(); // lo svuota 
        Terminale.stampa(a.isEmpty());
        Terminale.stampa(a.contains("def")); // true se l'elemento si trova nell'oggetto

        ArrayList<String> b = new ArrayList<>(a);
        Terminale.stampa(a);
        Terminale.stampa(b);
        Terminale.stampa(a.equals(b));
        Terminale.stampa(a == b);

        Terminale.stampa(a.indexOf("def"));

        String daCercare = "def";
        boolean trovata = false;
        for ( int i = 0; i <a.size() && !trovata; i ++){
            if(a.get(i).equals(daCercare)){
                trovata = true;
                break;
            }        
        }

        a.add(1, "xyz"); // equivalente dell'insert di python, mette l'oggetto
        // a quell'indice e sposta il precedente avanti

        a.set(1, "lmn"); // sostituisce il valore che si trova in posizione data


        a.remove("def"); // indovina che fa

        ArrayList<Integer> c = new ArrayList<>(); // un array di interi

        /*

        Integer x = new Integer(10);
        Integer y = new Integer(20);

        c.add(x);
        c.add(y);

        Terminale.stampa(c);
        Terminale.stampa(c.get(1));

        int w = c.get(1).intValue();

        al posto di tutta questa porcaria possiamo usare l' AUTOINSCATOLAMENTO */

        // AUTOBOXING

        c.add(10);
        c.add(20); // si occuperà poi il linguaggio a trasformarlo

        int w = c.get(1); //  possiamo assegnare ad una variabile int
        // un valore integer proprio perchè c'è l' AUTO SPACCHETTAMENTO

        ArrayList<Integer> d = new ArrayList<>();

        for (int n = 1; n <= 100; n++){
            d.add(n);
        }


        Comitiva e = new Comitiva();
        ArrayList<Persona> p = e.getPartecipanti();
        p.add(new Persona("Mario", "Rossi ", 2005));

        Terminale.stampa(e.toString()); 













    }
}

