package lezioni;

public class Lezione1103 
{
    public static void main ( String[] args){
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

        Terminale.stampa(q.toString());

        Lampadina l = new Lampadina();
        Terminale.stampa(l);
        

    }    
}
