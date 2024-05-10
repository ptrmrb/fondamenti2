package listeconcatenate;

import terminale.*;
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
	
	public ListaConcatenataInt(ListaConcatenataInt l)
	{	inizializza();
		for(NodoInt corrente = l.testa; corrente != null;
				corrente = corrente.getSuccessivo())
			aggiungiInCoda(corrente.getInfo());
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
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof ListaConcatenataInt))
			return false;
		ListaConcatenataInt l = (ListaConcatenataInt)o;
		if(lunghezza != l.lunghezza)
			return false;
		NodoInt corrente = testa;
		NodoInt correnteL = l.testa;
		while(corrente != null)
		{	if(corrente.getInfo() != correnteL.getInfo())
				return false;
			corrente = corrente.getSuccessivo();
			correnteL = correnteL.getSuccessivo();
		}
		return true;
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
	
	public int get(int i)
	{	if(i < 0 || i >= lunghezza)
			throw new EccezioneIndiceNonValido();
		NodoInt corrente = testa;
		for(int k = 1; k <= i; k++)
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
	
	public void rimuoviTesta()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		if(lunghezza == 1)
			svuota();
		else
		{	testa = testa.getSuccessivo();
			lunghezza--;
		}
	}
	
	public void rimuoviCoda()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		if(lunghezza == 1)
			svuota();
		else
		{	for(NodoInt corrente = testa; corrente != null;
					corrente = corrente.getSuccessivo())
				if(corrente.getSuccessivo() == coda)
				{	corrente.setSuccessivo(null);
					coda = corrente;
				}
			lunghezza--;
		}	
	}
	
	public void rimuovi(int indice)
	{	if(indice < 0 || indice >= lunghezza)
			throw new EccezioneIndiceNonValido();
		if(indice == 0)
		{	rimuoviTesta();
			return;
		}
		if(indice == lunghezza - 1)
		{	rimuoviCoda();
			return;
		}
		NodoInt corrente = testa;
		for(int i = 1; i < indice; i++)
			corrente = corrente.getSuccessivo();
		corrente.setSuccessivo(corrente.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
	public boolean rimuoviPrimo(int valore)
	{	// ALTERNATIVA:
		//rimuovi(indiceDi(valore));
		if(eVuota())
			return false;
		if(testa.haInfo(valore))
		{	rimuoviTesta();
			return true;
		}
		for(NodoInt corrente = testa; corrente != null;
					corrente = corrente.getSuccessivo())
		{	NodoInt successivo = corrente.getSuccessivo();
			if(successivo != null && successivo.haInfo(valore))
			{	corrente.setSuccessivo(successivo.getSuccessivo());
				if(successivo == coda)
					coda = corrente;
				lunghezza--;
				return true;
			}
		}
		return false;
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
	
	private int sommaDa(NodoInt n)
	{	if(n == null)
			return 0;
		return n.getInfo() + sommaDa(n.getSuccessivo());
	}
	
	public int somma()
	{	return sommaDa(testa);		
	}
	
	private int contaDa(NodoInt n, int valore)
	{	if(n == null)
			return 0;
		if(n.haInfo(valore))
			return 1 + contaDa(n.getSuccessivo(),valore);
		return contaDa(n.getSuccessivo(),valore);
		// ALTERNATIVA DAL SECONDO IF IN POI:
		// return (n.haInfo(valore) ? 1 : 0) + contaDa(n.getSuccessivo(),valore);
	}
	
	public int conta(int valore)
	{	return contaDa(testa,valore);		
	}
	
	private int minimoDa(NodoInt n)
	{	if(n.getSuccessivo() == null)
			return n.getInfo();
		return Math.min(n.getInfo(), minimoDa(n.getSuccessivo()));
	}
	
	public int minimo()
	{	if(eVuota())
			throw new EccezioneListaVuota();		
		return minimoDa(testa);		
	}
	
	private int massimoDa(NodoInt n)
	{	if(n.getSuccessivo() == null)
			return n.getInfo();
		return Math.max(n.getInfo(), massimoDa(n.getSuccessivo()));
	}
	
	public int massimo()
	{	if(eVuota())
			throw new EccezioneListaVuota();		
		return massimoDa(testa);		
	}


	// esercizi tutoraggio 
	public void stampaInversa()
	{
        stampaInversa(testa);
    }

    private void stampaInversa(NodoInt n)
	{
        if ( n == null )
            return; // importante altrimenti andrebbe in errore perche chiami 
					//un metodo su un istanza che non esiste

		stampaInversa(n.getSuccessivo());
		Terminale.stampa(n.getInfo());
	}

	public void pulisci(){
		pulisci(testa);
	}

	private void pulisci(NodoInt n){
		if ( n.getSuccessivo() == null )
			return;

		NodoInt succ = n.getSuccessivo();
		if ( succ.getInfo() == n.getInfo() )

		{	// aggiorniamo la coda
			if ( succ == coda )
				coda = n; // perche se stiamo per eliminare la coda serve un altra coda,
						  // quindi la impostiamo al precedente

			n.setSuccessivo((succ.getSuccessivo())); // invece di rimuoverlo spostiamo il puntatore al
			lunghezza--;							 // successivo del successivo...
			pulisci(n); // chiamata ricorsiva
			return; 
		}
		pulisci(succ);
	}

	public int firstEven(){
		return firstEven(testa);
	}

	private int firstEven(NodoInt n){
		if ( n == null )
			return -1;

		int valore = n.getInfo(); 

		if (valore % 2 == 0)
			return indiceDi(valore);
		
		return firstEven(n.getSuccessivo());

	}

	public int firstEven1(){
		return firstEven(testa, 0);
	}

	private int firstEven(NodoInt n, int indice){
		if ( n == null )
			return -1;
			
		int valore = n.getInfo(); 

		if (valore % 2 == 0)
			return indice;
		
		return firstEven(n.getSuccessivo(), indice + 1 );

	}

	// esercizio appello fatto con pugliese

	// esercizio tutoraggio 

	/* Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo
	verificaLista() che restituisce True se e solo se tutti i numeri negativi della lista 
	(denominati di controllo) indicano in valore assoluto quanti numeri pari li succedono,
	ad esempio se la lista è [-5, 20, -4, 10, 62, 1, -2, 13, 36, 6, 1] e allora la funzione
	restituisce True. Il metodo dovrà essere ricorsivo o invocare un opportuno metodo
	ricorsivo sulla classe NodoInt. */

	public boolean verificaLista() {
		return verificaListaDa(testa);
	}

	private boolean verificaLista( NodoInt n )
	{
		if ( n == null )
			return 0;

		int successivi = verificaLista(n.getSuccessivo());

		if (successivi < 0)
			return -1; 
		
		if ( n.getInfo() < 0 )
			if ( -1 * n.getInfo() != successivi )
				return -1;
			return successivi;

		if ( n.getInfo()%2 == 0 )
			return successivi + 1;
		return successivi;

		//return successivi + 1 - n.getInfo()%2;
	}

	public int picchi( ){
		return picchiDa(testa);
	}

	private int picchiDa(NodoInt n ){
		if ( n.getSuccessivo().getSuccessivo() == null ){
			return 0;
		}

		int succ =  n.getSuccessivo().getInfo();
		int corr = n.getInfo();
		int succ2 = n.getSuccessivo().getSuccessivo().getInfo();

		if ( corr < succ/2 )
			if ( succ2 < succ/2 )
				return 1 + picchiDa(n.getSuccessivo());
			return picchiDa(n.getSuccessivo());
	}


	public static void main(String[] args) {
		int[] l = { 4 , 9, 12, 36, 16, 23, 87, 34, 18, 64, 33};
		ListaConcatenataInt l1 = new ListaConcatenataInt(l);

		Terminale.stampa(l1.picchi());
	}
}