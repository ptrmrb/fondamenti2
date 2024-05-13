package listeconcatenate;

class Nodo<E>
{	private E info;
	private Nodo<E> successivo;
	
	public Nodo(E info, Nodo<E> successivo)
	{	this.info = info;
		this.successivo = successivo;		
	}
	
	public Nodo(E info)
	{	this.info = info;
		successivo = null;		
	}
	
	public E getInfo()
	{	return info;		
	}
	
	public Nodo<E> getSuccessivo()
	{	return successivo;		
	}
	
	public void setInfo(E info)
	{	this.info = info;		
	}
	
	public void setSuccessivo(Nodo<E> successivo)
	{	this.successivo = successivo;		
	}
	
	public String toString()
	{	return info.toString();		
	}
	
	public boolean haInfo(E info)
	{	return this.info.equals(info);
	}
}

public class ListaConcatenata<E>
{	private Nodo<E> testa;
	private Nodo<E> coda;
	private int lunghezza;
	
	private void inizializza()
	{	testa = null;
		coda = null;
		lunghezza = 0;
	}
	
	public ListaConcatenata()
	{	inizializza();
	}
	
	public void aggiungiInCoda(E valore)
	{	Nodo<E> nuovo = new Nodo<E>(valore);
		if(eVuota())
			testa = nuovo;
		else
			coda.setSuccessivo(nuovo);
		coda = nuovo;
		lunghezza++;
	}
	
	public boolean eVuota()
	{	return lunghezza == 0;
	}
	
	public String toString()
	{	String ret = "[";
		for(Nodo<E> corrente = testa; corrente != null;
				corrente = corrente.getSuccessivo())
		{	ret += corrente;
			if(corrente.getSuccessivo() != null)
				ret += ", ";
		}
		ret += "]";
		return ret;
	}

	public boolean contiene(E valore)
	{	return indiceDi(valore) != -1;
	}
	
	
	public void svuota()
	{	inizializza();		
	}
		
	public int getLunghezza()
	{	return lunghezza;		
	}

	public int indiceDi(E valore)
	{	int i = 0;
		for(Nodo<E> corrente = testa; corrente != null; 
			corrente = corrente.getSuccessivo())
		{	if(corrente.haInfo(valore))
				return i;
			i++;
		}
		return -1;
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof ListaConcatenata<?>))
			return false;
		ListaConcatenata<E> l = (ListaConcatenata<E>)o;
		if(lunghezza != l.lunghezza)
			return false;
		Nodo<E> corrente = testa;
		Nodo<E> correnteL = l.testa;
		while(corrente != null)
		{	if(!(corrente.getInfo().equals(correnteL.getInfo())))
				return false;
			corrente = corrente.getSuccessivo();
			correnteL = correnteL.getSuccessivo();
		}
		return true;
	}
	
	public ListaConcatenata<E> listaInvertita()
	{	ListaConcatenata<E> ret = new ListaConcatenata<>();
		for(Nodo<E> corrente = testa; corrente != null; 
				corrente = corrente.getSuccessivo())
			ret.aggiungiInTesta(corrente.getInfo());
		return ret;
	}
	
	public E get(int i)
	{	if(i < 0 || i >= lunghezza)
			throw new EccezioneIndiceNonValido();
		Nodo<E> corrente = testa;
		for(int k = 1; k <= i; k++)
			corrente = corrente.getSuccessivo();
		return corrente.getInfo();		
	}
	
	public void aggiungiInTesta(E valore)
	{	Nodo<E> nuovo = new Nodo<>(valore,testa);
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
		{	for(Nodo<E> corrente = testa; corrente != null;
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
		Nodo<E> corrente = testa;
		for(int i = 1; i < indice; i++)
			corrente = corrente.getSuccessivo();
		corrente.setSuccessivo(corrente.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
	public boolean rimuoviPrimo(E valore)
	{	// ALTERNATIVA:
		//rimuovi(indiceDi(valore));
		if(eVuota())
			return false;
		if(testa.haInfo(valore))
		{	rimuoviTesta();
			return true;
		}
		for(Nodo<E> corrente = testa; corrente != null;
					corrente = corrente.getSuccessivo())
		{	Nodo<E> successivo = corrente.getSuccessivo();
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
	
	private int contaDa(Nodo<E> n, E valore)
	{	if(n == null)
			return 0;
		if(n.haInfo(valore))
			return 1 + contaDa(n.getSuccessivo(),valore);
		return contaDa(n.getSuccessivo(),valore);
		// ALTERNATIVA DAL SECONDO IF IN POI:
		// return (n.haInfo(valore) ? 1 : 0) + contaDa(n.getSuccessivo(),valore);
	}
	
	public int conta(E valore)
	{	return contaDa(testa,valore);		
	}
}
