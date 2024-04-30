package ricorsione;

// si scriva una funzione ricorsiva che dato un numero positivo x controlla se x è un numero primo 
public static boolean primo( int x ){
    return primo( x, 2 )
}

private static boolean primo( int x, int i ){
    if ( i > x/2 )
        return true;

    return x%i != 0 && primo( int x, i + 1 );
}
public static void main ( String[] args ){
    System.out.println(primo(1));
}


/* si scriva una funzione ricorsiva con due parametri x ed y interi positivi
che calcola la divisione intera di x e y senza usare l'operatore / ma usando solo 
le operazioni di somma sottrazione e gli operatori relazionali */


public static int divisioneInt( int x , int y ){

    if ( y > x ) return 0;
    if ( x > y ){
        return 1 + divisione( x - y, y ); 
    }
}

public static int sommaCompresi( int da, int a )
{

    
}

