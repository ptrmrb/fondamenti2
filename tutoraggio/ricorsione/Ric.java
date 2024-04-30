package ricorsione;
import terminale.*;
import listeconcatenate.*;

public class Ric {
// si scriva una funzione ricorsiva che dato un numero positivo x controlla se x è un numero primo 
public static boolean primo( int x ){
    return primo( x, 2 );
}

private static boolean primo( int x, int i ){
    if ( i > x/2 )
        return true;

    return x%i != 0 && primo( x, i + 1 );
}
public static void main ( String[] args ){
    Terminale.stampa(sommatoria(7,10));
}


/* si scriva una funzione ricorsiva con due parametri x ed y interi positivi
che calcola la divisione intera di x e y senza usare l'operatore / ma usando solo 
le operazioni di somma sottrazione e gli operatori relazionali */


public static int divisioneInt( int x , int y ){

    if ( y > x ) return 0;
    if ( x > y ){
        return 1 + divisioneInt( x - y, y ); 
    }
}

public static int sommaCompresi( int da, int a )
{
    

}
public static int mcd( int x, int y ){
    if ( x % y == 0 ):
        return y;
    return mcd(y, x%y);
}

public static double sommatoria( int x, int n ) {
    int term = (x+n)/(2*n-1);
    if(n==2) return term;
    return term + sommatoria(x, n-1);
}


// dati L2 e L3 di interi, si verifichi che i valori presenti in L1 risultino maggiori di ogni elemento
// in L2 e minori di ogni elemento in L3





}

}
