import terminale.*;
import java.util.*;

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
        Terminale.stampa(s); 

        String s = (eta >= 18 ? "maggiorenne" : " minorenne");

        Terminale.stampa(s);
    }
}