package listeconcatenate;

import java.util.*;

class NodoInt
{	private int info;
	private NodoInt successivo;
	
	public NodoInt(int info, NodoInt successivo)
	{	this.info = info;
		this.successivo = successivo;		
	}
	
	public NodoInt(int info)
	{	this.info = info;
		successivo = null;		
	}
	
	public int getInfo()
	{	return info;		
	}
	
	public NodoInt getSuccessivo()
	{	return successivo;		
	}
	
	public void setInfo(int info)
	{	this.info = info;		
	}
	
	public void setSuccessivo(NodoInt successivo)
	{	this.successivo = successivo;		
	}
	
	public String toString()
	{	return ""+info;		
	}
	
	public boolean haInfo(int info)
	{	return this.info == info;
	}
}

public class ListaConcatenataInt 
{	private NodoInt testa;
	private NodoInt coda;
	private int lunghezza;
	
	public ListaConcatenataInt()
	{	inizializza();
	}
	
	public ListaConcatenataInt(int[] a)
	{	inizializza();
		for(int v : a)
			aggiungiInCoda(v);
	}
	
	public ListaConcatenataInt(ArrayList<Integer> a)
	{	inizializza();
		for(int v : a)
			aggiungiInCoda(v);
	}
	
	public ListaConcatenataInt(LinkedList<Integer> a)
	{	inizializza();
		for(int v : a)
			aggiungiInCoda(v);
	}
	
	public ArrayList<Integer> adArrayList()
	{	ArrayList<Integer> ret = new ArrayList<>();
		for(NodoInt corrente = testa; corrente != null; 
				corrente = corrente.getSuccessivo())
			ret.add(corrente.getInfo());
		return ret;
	}
	
	public LinkedList<Integer> aLinkedList()
	{	LinkedList<Integer> ret = new LinkedList<>();
		for(NodoInt corrente = testa; corrente != null; 
				corrente = corrente.getSuccessivo())
			ret.add(corrente.getInfo());
		return ret;
	}
	
	public int[] adArray()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		int[] ret = new int[lunghezza];
		int posLibera = 0;
		for(NodoInt corrente = testa; corrente != null; 
				corrente = corrente.getSuccessivo())
		{	ret[posLibera] = corrente.getInfo();
			posLibera++;			
		}
		return ret;
	}
	
	public ListaConcatenataInt listaInvertita()
	{	ListaConcatenataInt ret = new ListaConcatenataInt();
		for(NodoInt corrente = testa; corrente != null; 
				corrente = corrente.getSuccessivo())
			ret.aggiungiInTesta(corrente.getInfo());
		return ret;
	}

	public int get (int i)
	{
		if ( i < 0 || i >= lunghezza )
			throw new EccezioneIndiceNonValido();
		NodoInt corrente = testa; 
		for (k = 1; k <= 1; k++ )
			corrente = corrente.getSuccessivo();
		return corrente.getInfo();

	}
	
	public int indiceDi(int valore)
	{	int i = 0;
		for(NodoInt corrente = testa; corrente != null; 
			corrente = corrente.getSuccessivo())
		{	if(corrente.haInfo(valore))
				return i;
			i++;
		}
		return -1;
	}
	
	public boolean contiene(int valore)
	{	return indiceDi(valore) != -1;
	}
	
	private void inizializza()
	{	testa = null;
		coda = null;
		lunghezza = 0;
	}
	
	public void svuota()
	{	inizializza();		
	}
	
	public boolean eVuota()
	{	return lunghezza == 0;		
	}
	
	public int getLunghezza()
	{	return lunghezza;		
	}

	public void aggiungiInCoda(int valore)
	{	NodoInt nuovo = new NodoInt(valore);
		if(eVuota())
			testa = nuovo;
		else
			coda.setSuccessivo(nuovo);
		coda = nuovo;
		lunghezza++;
	}
	
	public void aggiungiInTesta(int valore)
	{	NodoInt nuovo = new NodoInt(valore,testa);
		testa = nuovo;
		if(eVuota())
			coda = nuovo;
		lunghezza++;
	}
	
	public String toString()
	{	String ret = "[";
		for(NodoInt corrente = testa; corrente != null;
				corrente = corrente.getSuccessivo())
		{	ret += corrente;
			if(corrente.getSuccessivo() != null)
				ret += ", ";
		}
		ret += "]";
		return ret;
	}
	// costruttore per copia
	public ListaConcatenataInt(ListaConcatenataInt l)
	{	
		inizializza();
		for( NodoInt corrente = l.testa; corrente != null; corrente = corrente.getSuccessivo() ) // fa il gitro di tutti gli elementi della lista l
			aggiungiInCoda(corrente.getInfo());
	}

	// equals
	public boolean equals(Object o)
	{
		if ( o == null )
			return false; 
		if ( o == this )
			return true;
		if (!( o instanceof ListaConcatenataInt ))
			return false; 
		
		ListaConcatenataInt l = (ListaConcatenataInt)o;
		if ( lunghezza != l.lunghezza )
			return false;

		NodoInt corrente = testa; 
		NodoInt correnteL = l.testa;

		while ( corrente != null ) // finchè non trova l'ultimo nodo
		{	if(corrente.getInfo() != correnteL.getInfo())
				return false;
			corrente = corrente.getSuccessivo();
			correnteL = correnteL.getSuccessivo();
		}
		return true; 
	}

	public void rimuoviTesta()
	{
		if(eVuota())
			throw new EccezioneListaVuota();
		if(lunghezza == 1)
			svuota();
		else
		{
			testa = testa.getSuccessivo(); // spostiamo il puntatore al nodo successivo e quindi viene eliminato automaticamente
			lunghezza --; 
		}
	}

	public void rimuoviCoda()
	{	// controlliamo che il successivo dell'elemento sia la coda
		for( NodoInt corrente = l.testa; corrente != null; corrente = corrente.getSuccessivo() )
			if (corrente.equals(l.coda))
				l.coda = // TODO 

	}

	// esercizi ricorsivi simili a quelli dell'esame 

	private int sommaDa(NodoInt n)
	{
		if ( n == null )
			return 0;
		return n.getInfo() + sommaDa( n.getSuccessivo() );
	}

	public int somma()
	{
		return sommaDa(testa);
	}

	// dato un valore restituire quante volte il valore compare nella lista

	private int contaDa( NodoInt n , int valore )
	{
		if ( n == null )
			return 0;
		if ( n.haInfo(valore) ) // n.getInfo == valore 
			return 1 + contaDa( n.getSuccessivo(), valore );
		return contaDa(n.getSuccessivo(), valore);
	}
	// ALTERNATIVA: return (n.haInfo(valore) ? 1:0) + contaDa(n.getSuccessivo(), valore);

	public int conta(int valore)
	{
		return contaDa(testa, valore);
	} 

	
}