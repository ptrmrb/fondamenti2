package traccia20220617;
import java.util.*;

public class Sistema 
{	
	private LinkedList<Volo> voli = new LinkedList<>();
	private LinkedList<Prenotazione> prenotazioni = new LinkedList<>();
	
	//costruttore copia
	/*
	public boolean verificaPrenotazioni(). Il metodo restituisce true se e solo se 
	tutte le prenotazioni sono corrette. Una prenotazione è corretta se esiste un volo per ogni 
	coppia consecutiva di aeroporti nel percorso prenotato.
	*/
	
	//COME SI CHIAMA IL LIST ITERATOR
	//nomelista.listiterator(i)
	
	//se dobbiamo prendere gli indici nella linked list usare ITERATORE
	
	/*
	 * public boolean verificaPrenotazioni(). Il metodo restituisce true se e solo se tutte le prenotazioni
	 *  sono corrette. Una prenotazione è corretta se esiste un volo per ogni coppia consecutiva di aeroporti 
	 *  nel percorso prenotato.
	 */
	
	public boolean verificaPrenotazioni() 
	{	for(Prenotazione p : prenotazioni)
		{	LinkedList<String> percorso = p.getPercorso();
			ListIterator<String> lip = percorso.listIterator();
			ListIterator<String> lid = percorso.listIterator(1);
			
			while(lid.hasNext())
			{	String partenza = lip.next();
				String destinazione = lid.next();
				if(findVolo(partenza,destinazione) == null)
					return false;
			}
		}
		return true;
	}
	
	private Volo findVolo(String partenza, String destinazione)
	{	Volo ret = null;
		for(Volo v : voli)
			if(v.getPartenza().equals(partenza) && v.getArrivo().equals(destinazione))
			{	ret = v;
				break;
			}
		return ret;
	}
	
	/*
	 *  public Volo voloMax(). Il metodo restituisce il volo per il quale è stata incassata la somma maggiore.
	 *   Nel caso in cui più voli soddisfino la proprietà, il metodo restituisce uno qualsiasi di essi.
		L’incasso di un volo è dato dalla formula
		nPrenBusiness × prezzoBusiness + nPrenEconomica × prezzoEconomica
	 * 
	 */
	
	public Volo voloMax()
	{	Volo ret = null;
		int incassoMax = Integer.MIN_VALUE;
		for(Volo v : voli)
		{	int incassoV = calcolaIncasso(v);
			if(incassoV > incassoMax)
			{	incassoMax = incassoV;
				ret = v;
			}
		}
		return ret;
	}
	
	private int calcolaIncasso(Volo v)
	{	int contB = 0;
		int contE = 0;
		int prezzoB = v.getPrezzobusiness();
		int prezzoE = v.getPrezzoEconomico();
		for(Prenotazione p : prenotazioni)
		{	LinkedList<String> percorso = p.getPercorso();
			ListIterator<String> lip = percorso.listIterator();
			ListIterator<String> lid = percorso.listIterator();
			boolean trovato = false;
			while(lid.hasNext() && !trovato)
			{	String partenza = lip.next();
				String dest = lid.next();
				if(findVolo(partenza,dest).equals(v))
				{	if(p.getClasse().equals("business"))
						contB ++;
					else
						contE ++;
				}
			}
		}
		return contB * prezzoB + contE*prezzoE;
	}
	
	/*
	 * public LinkedList<String> destinazioneComune(String cliente). Il metodo restituisce la lista dei nomi 
	 * dei clienti che hanno almeno una destinazione in comune con il cliente cliente, cioè i clienti che hanno 
	 * effettuato almeno una prenotazione avente come destinazione una delle destinazioni presenti nelle 
	 * prenotazioni effettuate dal cliente cliente.
	 */
	
	
	public LinkedList<String> destinazioneComune(String cliente)
	{	LinkedList<String> ret = new LinkedList<>();
		LinkedList<String> tuttiClienti = estraiClienti();
		LinkedList<String> destinazioneCliente = estraiDestinazioni(cliente);
		for(String cl : tuttiClienti)
		{	if(!(cl.equals(cliente)))
			{	LinkedList<String> destCl = estraiDestinazioni(cl);
				for(String dest : destCl)
					if(destinazioneCliente.contains(dest))
					{	ret.add(cl);
						break;
					}
			}
		}
		return ret;
		
	}
	
	private LinkedList<String> estraiClienti()
	{	LinkedList<String> ret = new LinkedList<>();
		for(Prenotazione p : prenotazioni)
		{	String cl = p.getNomeCliente();
			if(!(ret.contains(cl)))
				ret.add(cl);
		}
		return ret;
	}
	
	private LinkedList<String> estraiDestinazioni(String cliente)
	{	LinkedList<String> ret = new LinkedList<>();
		for(Prenotazione p : prenotazioni)
		{	if(p.getNomeCliente().equals(cliente))
			{	String dest = p.getPercorso().getLast();
				if(!(ret.contains(dest)))
					ret.add(dest);
			}
		}
		return ret;
	}

}