package lezioni;

public class Lezione1303 
{
    public static void main(String[] args)
    {
        Lampadina[] lampadine = new Lampadina[101];
        lampadine[0] = null;
        for (int i = 0; i<=100; i++){
            lampadine[i] = new Lampadina();
        }
        
        for (int numeroPersona = 1; numeroPersona <= 100; numeroPersona ++){
            for (int i = numeroPersona; i<=100; numeroPersona++){
                lampadine[i].premiBottone();
                
            }
        }

        for (int i = 1; i <=100; i++){
            if(lampadine[i].eAccesa())
                Terminale.stampa("La lampadina " + i + " è rimasta accesa. ");
        }



    }
}

