/*
 * Progettare e implementare una classe Concessionaria tenendo conto delle seguenti
 * specifiche:
 * 		-	La concessionaria contiene un magazzino (cioè una lista di automobili).
 * 		-	La classe deve contenere metodi per:
 * 				-	aggiungere un'auto al magazzino;
 * 				-	rimuovere un'auto dal magazzino;
 * 				-	stampare tutte le auto;
 * 				-	calcolare la somma dei prezzi di tutte le auto;
 * 				-	trovare la casa produttrice più ricorrente;
 * 				-	trovare l'auto con la cilindrata più bassa tra quelle con un prezzo
 * 					inferiore a 10.000 euro;
 * 				-	trovare l'auto con la cilindrata più alta tra quelle con un prezzo
 * 					superiore alla media dei prezzi delle auto;
 * 				-	trovare le case produttrici che producono solo auto con un prezzo
 * 					inferiore alla media dei prezzi delle auto;
 * 				-	trovare le case produttrici che producono solo auto con la stessa
 * 					cilindrata.
 */

package concessionaria;
 
import java.util.*;
import terminale.*;

public class Concessionaria {
	
	private ArrayList<Automobile> magazzino;
	
	public Concessionaria() 
	{ 	magazzino = new ArrayList<>(); 
	}
	
	// aggiungere un'auto al magazzino;
	public void aggiungiAuto(Automobile a) 
	{	magazzino.add(a);
	}
	
	// rimuovere un'auto dal magazzino;
	public void eliminaAuto(Automobile a) 
	{	magazzino.remove(a);
	}
	
	// stampare tutte le auto;
	public void stampaAutoMagazzino() 
	{	for(Automobile a: magazzino)
			Terminale.stampa(a);
	}
	
	// calcolare la somma dei prezzi di tutte le auto;
	public float sommaPrezziAuto() 
	{	float somma = 0;
		for(Automobile a: magazzino)
			somma += a.getPrezzo();
		return somma;
	}
	
	// trovare la casa produttrice più ricorrente;
	public String casaPiuRicorrente() 
	{	ArrayList<String> caseProduttrici = estraiCase();
		String casaPiuRicorrente = caseProduttrici.get(0);
		int maxOcc = occorrenzeCasa(casaPiuRicorrente);
		for(int i=1; i<caseProduttrici.size(); i++) 
		{	String casa = caseProduttrici.get(i);
			int numOcc = occorrenzeCasa(casa);
			if(numOcc > maxOcc) 
			{	casaPiuRicorrente = casa;
				maxOcc = numOcc;
			}
		}
		return casaPiuRicorrente;
	}
	
	private ArrayList<String> estraiCase() 
	{	ArrayList<String> ris = new ArrayList<>();
		for(Automobile a: magazzino) 
		{	String casa = a.getCasaProduttrice();
			if(!ris.contains(casa))
				ris.add(casa);
		}
		return ris;
	}
	
	private int occorrenzeCasa(String casa) 
	{	int c = 0;
		for(Automobile a: magazzino)
			if(a.getCasaProduttrice().equals(casa)) 
				c++;
		return c;
	}
	
	// trovare l'auto con la cilindrata più bassa tra quelle con un prezzo inferiore a 10.000 euro;
	public Automobile cilindrataBassa() 
	{	Automobile ris = null;
		for(Automobile a: magazzino) 
		{	if(a.getPrezzo() < 10000 && ( ris==null || a.getCilindrata() < ris.getCilindrata() ))
				ris = a;
		}
		return ris;
	}
	
	// trovare l'auto con la cilindrata più alta tra quelle con un prezzo superiore alla media dei prezzi delle auto;
	public Automobile cilindrataAlta() 
	{	float media = mediaPrezzi();
		Automobile ris = null;
		for(Automobile a: magazzino)
			if(a.getPrezzo() > media && (ris==null || a.getCilindrata() > ris.getCilindrata()))
				ris = a;
		return ris;
	}
	
	private float mediaPrezzi() 
	{	return sommaPrezziAuto()/magazzino.size();
	}
		
	// trovare le case produttrici che producono solo auto con un prezzo inferiore alla media dei prezzi delle auto;
	public ArrayList<String> caseEconomiche()
	{	ArrayList<String> ris = new ArrayList<>();
		float media = mediaPrezzi();
		ArrayList<String> caseProd = estraiCase();
		for(String casa: caseProd) 
		if(tuttiPrezziInferiori(casa, media))
				ris.add(casa);
		return ris;
	}
	
	private boolean tuttiPrezziInferiori(String casa, float media) 
	{	for(Automobile a: magazzino)
			if(a.getCasaProduttrice().equals(casa) && a.getPrezzo()>=media)
				return false;
		return true;
	}
	
	// trovare le case produttrici che producono solo auto con la stessa cilindrata.
	public ArrayList<String> caseStessaCilindrata() 
	{	ArrayList<String> ris = new ArrayList<>();
		ArrayList<String> caseProd = estraiCase();
		for(String casa: caseProd)
			if(tutteStessaCilindrata(casa))
				ris.add(casa);
		return ris;
	}
	
	private boolean tutteStessaCilindrata(String casaProd) 
	{	ArrayList<Automobile> automobili = new ArrayList<>();
		for(Automobile a: magazzino)
			if(a.getCasaProduttrice().equals(casaProd))
				automobili.add(a);
		int cil = automobili.get(0).getCilindrata();
		for(int i=1; i<automobili.size(); i++)
			if(automobili.get(i).getCilindrata() != cil)
				return false;
		return true;
	}

}