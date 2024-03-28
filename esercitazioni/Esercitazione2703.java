package esercitazioni;

public class Esercitazione2703 
{
    /* Si scriva un metodo filtraMatrice che riceve in input una
    matrice di interi e restituisce un array contenente tutti gli 
    elementi presenti sulle righe di indice pari che contengono solo
    elementi dispari*/

    public static int[] filtraMatrice (int[][] m)
    {
        int[] ret = new int [dim]; // utilizzare quando non conosciamo la dimensione di qualche ogetto
        int dim = 0;
        int numRigheOk = 0;

        for ( int i = 0; i<m.length; i+=2) // incrementiamo di 2 in modo tale da controllare le righe pari, ovvero il passo
        {
            if ( rigaTuttiDispari(m,i) )
                numRigheOk ++; 
        }
        dim = numRigheOk * m[0].length;
        int[] ris = new int[dim];
        int pos = 0;

        for ( int i = 0; i<m.length; i+=2)
        {   if ( rigaTuttiDispari(m,i) )
            {   for ( int j = 0; i<m[0].length; j++ )
                {   ris[pos] = m[i][j];
                    pos++;
                } 
            }
        }   

    private static boolean rigaTuttiDispari(int[][]m , int riga)
    {
        for( int j = 0; j<m.length; j++)
        {   if ( m[riga][j] % 2 == 0 )
                return false;
            return true; 
        }
        return ris;
    }
    
}

public static void main( String[] args)
{   int[][] m = {{1,1,3,1},
                  {2,2,1,3}, 
                  {15,1,7,9}};
    int[] x = filtraMatrice(m);

    Terminale.stampaMatrice(x);
}

// data una matrice di interi non negativi restituire l'indice
// di riga con somma più alto 

public static int rigaMaggiore( int[][]m )
{
    int sommaMax = 0; // inizializzazione fittizia
    int indexMax = 0; // inizializzazione fittizia

    for ( int i = 0; i < m.length ; i++)
    {
        int sommaRiga = calcolaSommaRiga(m,i);
        if ( sommaRiga > sommaMax )
        {
            sommaMax = sommaRiga;
            indexMax = i; 
        }
        return indexMax;
    }

}

private static int calcolaSommaRiga ( int [][] m , int indice)
{
    int sommma = 0; 
    for ( int j = 0; j < m.length ; j++)
    {
        sommma += m[indice][j];
    }
    return somma; 
}

}

/* Data una matrice di interi restituire true se la somma degli
elementi sulla diagonale principale è uguale alla somma degli 
elementi della diagonale secondaria , false altrimenti.*/

