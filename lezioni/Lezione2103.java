package lezioni; 

import terminale.*;

public class Lezione2103{
    public static void main (String[] args){
        int eta = Terminale.richiediInt("Età: ");

        // CONDITIONAL EXPRESSION
        //TERNARY OPERATOR

        // dichiaro una variabile s e la inizializzo direttamente

        String s = " ";
        if ( eta >= 18)
            s = "maggiorenne";
        else
            s = "minorenne";

        Terminale.stampa(s);

        // altro modo di scrivere questo assegnamento ma in una sola riga
        // attraverso l'operatore '?'

        String s1 = (eta >= 18 ? "maggiorenne" : " minorenne");

        Terminale.stampa(s1);


        // noi sappiamo che a++ ha un valore, cosa da non fare mai:

        int a = 5; 
        int b = a++; // se faccio stampare b, vale 5 perche assegna il valore prima dell'incremento

        // int b = ++a; questo invece vale 

    }
}