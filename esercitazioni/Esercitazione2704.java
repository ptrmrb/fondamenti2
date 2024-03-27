package esercitazioni;

public class Esercitazione2003 
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
    }

    private static boolean rigaTuttiDispari(int[][]m , int riga)
    {
        for( int j = 0; j<m.length; j++){
            if ( m[riga][j] % 2 == 0 )
                return false;
            return true; 
        }
    }
}