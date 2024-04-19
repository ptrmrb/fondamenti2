package esercitazioni;

public class Esercitazione2003 {
    // i metodi statici accedono solo alle variabili statiche
    // i metodi dinamici ( di istanza ) accedono a tutte le variabili 

    // String[] args sono i parametri che vengono passati automaticamente al main

    // Riceve in input un array l di lunghezza n con n pari e restituisce un 
    // array di lunghezza n/2 il cui i-esimo elemento è pari a l[2*i] + l[2*i + 1]

    public static int[] rolluUp (int[] l)
    {   int[] ris = new int[l.length/2];

        for ( int i = 0; i < l.length/2; i++)
            ris[i] = l[2*i] + l[2*i + 1];

        return ris;
    }

    // scrivi un metodo alternati che riceve in input un array l di interi e restituisce true
    // se l'arraycontiene valori alternati pari e dispari

    public static boolean alternati (int[] l){

        boolean precPari = (l[0] % 2) == 0;
        for  (int i = 1; i < l.length; i ++){
            if((l[i] % 2 == 0 && precPari) || (l[i] % 2 == 1 && !precPari));
                return false;
            precPari = !precPari;
        }
        
        return true;
    }


/*
 * Si scriva un metodo costruisci array che riceve in input un array di interi e restituisce un a
 * array di interi V2 di pari lungehzza il cui generico elemento i è cosi ottenuto
 * 1) Se la media degli elementi di v1 con indice maggiore o uguale a 1 a V1[i] allora V2[i] è 
 * uguale a tale media
 * 2) altrimenti v2[i ]  uguale alla differenza tra la somma degli elementi lla sinistra di
 * v1[i] e la somma degli elementi alla destra di v1[i]
 */

public static int[] costruisciArray(int[] V1){
    int[] V2 = new int[V1.length];
    for ( int i = 0; i < V1.length; i++){
        int somma = 0; 
        
        for ( int j = i; j < V1.length; j ++){
            somma += V1[j];
        }
        int media = somma / (V1.length -1);    
        if ( media >= V1[i])
            V2[i] = media;
        else{
            int sommaS = 0;
            for ( int j = 0; j < V1.length; j++ ){
                sommaS += V1[j];
            } 
            int sommaD = somma - V1[i];
            
            int differenza = sommaS - sommaD;
            V2[i] = differenza;
        }
    }
    return V2;
}

/* TRACCIA 4
 *  Si scirivano
 * 1 ) un metodo costruisciMatrice che riceve una matrice di interi M  e restituisce 
 * una matrice di booleani M1 della stessa dimensione tale che:
 * a) le celle di M1 sulla cornice esterna contengono tutte il valore false
 * b) ogni altra cella M[i][j] contiene il valore true se e solo se la somma delle celle
* adiacenti a M[i][j] è uguale al valore di M[i][j]
 * 2) verificaMatrice che riceve in ingresso una matice di interi M e restituisce true se e
 * solo se le colonne pari sono ordinate in modo non crescente e quelle dispari in modo 
 * non adiacenti
 */

public static boolean costruisciMatrice(int[][] M ) {
    // passo 1: costruisci risultato
    boolean [][] M1 = new boolean[M.length][M[0].length];
    // CORNICE : settiamo i valori della cornice a false

    for ( int j = 0; j < M[0].length; j++){
        //prima riga
        M1[0][j] = false;
        //ultima riga
        M1[M.length-1][j] = false;
    }

    for ( int i = 0; i < M.length; i++){
        // prima colonna
        M1[i][0] = false; 
        // ultima colonna 
        M1[i][M1[0].length-1] = false; 
    }

    for ( int i = 1; i < M1.length - 1; i++){
        for ( int j = 1; j < M1[0].length - 1; j++){
            // somma adiacenti
            int sommaAd = 0;
            //sopra
            sommaAd += M[i-1][j-1]; // sinistra
            sommaAd += M[i-1][j];  // centro
            sommaAd += M[i-1][j+1]; // destra
            //stessa riga
            sommaAd += M[i][j-1];//sinistra
            sommaAd += M[i][j+1];// destra
            //sotto
            sommaAd += M[i+1][j-1];//sinistra
            sommaAd += M[i+1][j+1];//destra
            sommaAd += M[i][j];//centro

            M1[i][j] = sommaAd == M[i][j];
        }
    }

return M1;

}

public static boolean verificaMatrice(int[][] M)
{   
    // for più esterno sulle colonne
    for ( int j = 0; j < M[0].length; j++)
        if (j % 2 == 0)
        {
            // for interno su righe
            for ( int i = 0; i < M.length; i ++)
                if (M[i][j] < M[i+1][j])
                    return false;
        }
        //caso colonna dispari 
        else {
            for ( int i = 0; i < M.length; i ++)
                if (M[i][j] < M[i+1][j]) 
                    return false;
            }
    return true; 
        }
    }