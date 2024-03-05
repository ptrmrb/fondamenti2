package Lezioni;

import terminale.*; // * vuol dire importa tutte le classi presenti nel package termiale 

public class lezione0503 
{
    public static void main(String[] args)
    {
        String nome  = Terminale.richiediStringa("Come ti chiami?");
        String risposta = " Ciao, " + nome + "!";
        Terminale.stampa(risposta);

        double valore = Math.PI;
        Terminale.stampa(valore);
        Math.sqrt(valore);

    }
    
    public static int[] selezionaPositivi( int[] arr ) 
    {
        int numeroPositivi = 0 ;
        for ( int n : arr)
            if (n > 0)
                numeroPositivi++;
        
        int[] ret = new int[numeroPositivi];

        int posizioneLibera = 0; // tengo a mente la prima posizione libera in cui possiamo posizionare il valore
        for ( int i = 0; i < arr.length; i++ )
            if (arr[i] > 0)




        return 0;


    }
}

