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
    

}

