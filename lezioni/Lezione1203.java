package lezioni;

public class Lezione1203 
{
    public static void main ( String[] args){
    /* 

        Persona[] a = new Persona[3];
        a[0] = new Persona("Mario", "Rossi", 2005);
        a[0] = new Persona("Luigi", "Neri", 2005);
        a[0] = new Persona("Francesco", "Verdi", 1980);

        for ( int i = 0; i < 3; i++)
        {   Persona p = a[i];
            if(p.eGiovane())
                Terminale.stampa(a[i] + " è giovane ");
            else
                Terminale.stampa(p + " è giovane ");
        }


        Persona p = new Persona("Pietro", "Mirabelli", 2004);
        //Persona q = new Persona(p.getNome(), p.getCognome(), p.getAnnoNascita()); al posto di questo riga invoco sull' oggetto p, il metodo di copia
        Persona q = new Persona(p);

        Terminale.stampa(q.toString()); */
        
        Lampadina l1 = new Lampadina();

        Lampadina l2 = new Lampadina();
        l2.premiBottone();

        //Terminale.stampa(l2);

        // per sapere se un oggetto è una instanza di una classe esiste il
        // metodo instanceof che restituisce un boolean 

        Persona p1 = new Persona("Mario", "Rossi", 2005);
        Persona p2 = new Persona("Mario", "Rossi", 2005);
        
        Terminale.stampa(p1.equals(p2));

        Lampadina[] striscia = new Lampadina[100];

        for ( int i = 0; i < 100; i++)
            striscia[i] = new Lampadina();
            //operazione di pressione del bottone su alcune lampadine
        striscia[35].premiBottone();
        striscia[24].premiBottone();
            

        for ( int i = 0; i < 100; i++ )
            if (striscia[i].equals(new Lampadina()));
                Terminale.stampa("SI"); 

        }

    }    
