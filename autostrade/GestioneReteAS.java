package autostrade;

import java.util.*;

private static ArrayList<Citta> citta = new ArrayList<>;
private ArrayList<Tratta> tratte = new ArrayList<>;
private ArrayList<Autoveicolo> autoveicoli = new ArrayList<>; 
private ArrayList<Percorrenza> percorrenze = new ArrayList<>;

	public static Autoveicolo trovaAutoFrequente(int d1, int d2)
	{	Autoveicolo ret = autoveicoli.get(0);
		int maxTratte = numTratteIntervallo(ret,d1,d2);
		for(int i = 1; i < autoveicoli.size(); i++)
		{	Autoveicolo a = autoveicoli.get(i);
			int tratteA = numTratteIntervallo(a,d1,d2);
			if(tratteA > maxTratte)
			{	ret = a;
				maxTratte = tratteA;			
			}			
		}
		return ret;
	}
	
	private static int numTratteIntervallo(Autoveicolo a, int d1, int d2)
	{	int cont = 0;
		for(Percorrenza p : percorrenze)
			if(p.getAutoveicolo().equals(a) && p.getData() >= d1 && p.getData() <= d2)
				cont++;
		return cont;		
	}
	
	public static ArrayList<Citta> cittaGettonate()
	{	ArrayList<Citta> ret = new ArrayList<>(citta);
		Collections.sort(ret);
		Collections.reverse(ret);
		return ret;		
	}
}
