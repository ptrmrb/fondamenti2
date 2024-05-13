package lezioni; 
import terminale.*;

public class AlgoritmiRicorsivi 
{	public static boolean ricercaBinaria(int[] a, int v)
	{	return ricercaBinariaRicorsiva(a, v, 0, a.length - 1);
	}
	
	private static boolean ricercaBinariaRicorsiva(int[] a, int v, int inizio, int fine)
	{	if(inizio > fine)
			return false;
		int centro = (inizio + fine) / 2;
		if(a[centro] == v)
			return true;
		if(a[centro] < v)
			return ricercaBinariaRicorsiva(a, v, centro + 1, fine);
		return ricercaBinariaRicorsiva(a, v, inizio, centro - 1);
	}
	
	private static int[] merge(int[] v1, int[] v2)
	{	int[] ret = new int[v1.length + v2.length];
		int i = 0;
		int j = 0;
		int posLibera = 0;
		while(i < v1.length && j < v2.length)
		{	if(v1[i] < v2[j])
			{	ret[posLibera] = v1[i];
				i++;
			}
			else
			{	ret[posLibera] = v2[j];
				j++;
			}
			posLibera++;
		}
		while(i < v1.length)
		{	ret[posLibera] = v1[i];
			i++;
			posLibera++;
		}
		while(j < v2.length)
		{	ret[posLibera] = v2[j];
			j++;
			posLibera++;
		}
		return ret;
	}
	
	public static int[] mergeSort(int[] v)
	{	int n = v.length;
		if(n == 1)
			return v;
		int[] primaMeta = new int[n / 2];
		int[] secondaMeta = new int[n - n / 2];
		for(int i = 0; i < n / 2; i++)
			primaMeta[i] = v[i];
		for(int i = n / 2; i < n; i++)
			secondaMeta[i - n / 2] = v[i];
		
		int[] primaMetaOrdinata = mergeSort(primaMeta);
		int[] secondaMetaOrdinata = mergeSort(secondaMeta);
		
		return merge(primaMetaOrdinata, secondaMetaOrdinata);
	}
	
	public static void quickSort(int[] v)
	{	quickSortRicorsivo(v,0,v.length - 1);
	}

	private static void quickSortRicorsivo(int[] v, int inizio, int fine)
	{	if(inizio < fine)
		{	int p = partiziona(v, inizio, fine);
			quickSortRicorsivo(v, inizio, p - 1);
			quickSortRicorsivo(v, p + 1, fine);
		}
	}
	
	private static int partiziona(int[] v, int inizio, int fine)
	{	int pivot = v[fine];
		int posLibera = inizio;

		for(int j = inizio; j < fine; j++)

			if(v[j] <= pivot)
			{	scambia(v,posLibera,j);
				posLibera++;
			}

		scambia(v,posLibera,fine);
		return posLibera;
	}

	private static int partiziona2(int[] v, int inizio, int fine) {
		// Scegliamo come pivot, il primo elemento dell'array
		int pivot = v[inizio];
	
		int posLibera = inizio;  // Indice per tenere traccia della posizione del pivot
	
		// Scorrimento dell'array
		for (int j = inizio; j < fine; j++) {
			// Se l'elemento corrente è minore o uguale al pivot, incrementa l'indice posLibera e scambia gli elementi
			if (v[j] <= pivot) {
				posLibera++;
				// Scambia v[posLibera] con v[j]
				scambia(v, posLibera, j);
			}
		}
	
		// Alla fine del ciclo, posiziona il pivot nella sua posizione corretta
		// Scambia v[i + 1] con v[fine] (posizione del pivot)
		scambia(v, posLibera, fine);
	
		// Ritorna l'indice del pivot
		return posLibera;
	}

	
	private static void scambia(int[] v, int i, int j)
	{	int t = v[i];
		v[i] = v[j];
		v[j] = t;
	}
	

	public static void main(String[] args) {
		int[] v = { 1,5,1,7,12,-51,1,7,9 };
		quickSort(v);
		Terminale.stampa(v);
	}
	
}
