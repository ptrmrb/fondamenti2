package autostrade;

import java.util.*;

public class GestioneReteAS 
{	private static ArrayList<Citta> citta = new ArrayList<>();
	private static ArrayList<Tratta> tratte = new ArrayList<>();
	private static ArrayList<Autoveicolo> autoveicoli = new ArrayList<>();
	private static ArrayList<Percorrenza> percorrenze = new ArrayList<>();
	
	public static void aggiungiCitta(Citta c)
	{	citta.add(c);		
	}
	
	public static void aggiungiTratta(Tratta t)
	{	tratte.add(t);		
	}
	
	public static void aggiungiAutoveicolo(Autoveicolo a)
	{	autoveicoli.add(a);		
	}
	
	public static void aggiungiPercorrenza(Percorrenza p)
	{	percorrenze.add(p);		
	}
	
	public static int accessi(Citta c)
	{	int cont = 0;
		for(Percorrenza p : percorrenze)
			if(p.getTratta().getCittaDestinazione().equals(c))
				cont++;
		return cont;		
	}
	
	public static ArrayList<Autoveicolo> trovaAutoveicoli(int x)
	{	ArrayList<Autoveicolo> ret = new ArrayList<>();
		for(Autoveicolo a : autoveicoli)
			if(!haPercorsoTrattaPiuLunga(a,x))
				ret.add(a);
		return ret;		
	}
	
	private static boolean haPercorsoTrattaPiuLunga(Autoveicolo a, int x)
	{	for(Percorrenza p : percorrenze)
			if(p.getAutoveicolo().equals(a) && p.getTratta().getDistanza() > x)
					return true;
		return false;
	}

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
