package lezioni;

public class AlgoritmiRicorsivi
{
    public boolean ricercaBinaria(int[] a, int v)
    {
        return ricercaBinariaRicorsiva( a, v, 0, a.length() - 1 );
    }

    private boleean ricercaBinariaRicorsiva( int[] a, int v, int inizio, int fine)
    {
        if( inizio > fine )
            return false;
        int centro = ( inizio + fine ) / 2;
        if ( a[centro] == v )
            return true;
        if( a[centro] < v )
            return ricercaBinariaRicorsiva(a, v, centro+1, fine);
    }

    public int[] merge(int[], v1, int[] v2)
    {
        int[] ret = new int[ v1.length + v2.length ]
        int i = 0;
        int j = 0;
        int posLibera = 0;
        while( i < v1.length && j < v2.length )
        {
            if ( v1[i] <= v2[j] )
            {   ret[posLibera] = v1[i];
                i++;
            }
            else
            {   ret[posLibera] = v2[j];
                j++;
            }
        }

        while( i < v1.length ) // questi due while non andranno mai in esecuzione insieme perchè sono alternativi
        {
            ret[posLibera] = v1[i];
            i++;
            posLibera++;
        }
        while ( j < v2.length )
        {
            ret[posLibera] = v2[j];
            j++;
            posLibera++;
        }
    }

    public int[] mergeSort( int[] v )
    {
        int n = v.length();
        if(n == 1)
            return v;
        
        int [] primaMeta = new int[n / 2];
        int [] secondaMeta = new int[ n - n / 2];

        for ( int i = 0; i < n / 2; i++ )
        {   primaMeta[i] = v[i];
        }

        for ( int i = 0; i < n - n / 2; i ++ )
        {   secondaMeta[ i - n / 2 ] = v[i];
        }

        int [] primaMetaOrdinata = mergeSort(primaMeta);
        int [] secondaMetaOrdinata = mergeSort(secondaMeta);

        return merge( primaMetaOrdinata, secondaMetaOrdinata );
    }


}