package traccia20190909;

import listeconcatenate.EccezioneIndiceNonValido;
import listeconcatenate.EccezioneListaVuota;

import java.util.ArrayList;

class NodoInt
{	private int info;
	private NodoInt successivo;
	
	public NodoInt(int info, NodoInt successivo)
	{	this.info = info;
		this.successivo = successivo;		
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
	
	public boolean haInfo(int info)
	{	return this.info == info;		
	}
	
	public String toString()
	{	return ""+info;		
	}
}

public class ListaConcatenataInt 
{	private NodoInt testa;
	private NodoInt coda;
	private int lunghezza;
	
	private void inizializza()
	{	testa = null;
		coda = null;
		lunghezza = 0;		
	}
	
	public ListaConcatenataInt()
	{	inizializza();		
	}
	
	public ListaConcatenataInt(ListaConcatenataInt l)
	{	inizializza();
		for(NodoInt n = l.testa; n != null; n = n.getSuccessivo())
			aggiungiInCoda(n.getInfo());
	}
	
	public ListaConcatenataInt(ArrayList<Integer> a)
	{	inizializza();
		for(int v : a)
			aggiungiInCoda(v);		
	}
	
	public ListaConcatenataInt(int[] a)
	{	inizializza();
		for(int v : a)
			aggiungiInCoda(v);		
	}
		
	public int getLunghezza()
	{	return lunghezza;		
	}
	
	public boolean eVuota()
	{	return lunghezza == 0;		
	}
	
	public void svuota()
	{	inizializza();		
	}
	
	public void aggiungiInCoda(int info)
	{	NodoInt nuovoNodo = new NodoInt(info,null);
		if(eVuota())
		{	testa = nuovoNodo;
			coda = nuovoNodo;			
		}
		else
		{	coda.setSuccessivo(nuovoNodo);
			coda = nuovoNodo;			
		}
		lunghezza++;
	}
	
	public void aggiungiInTesta(int info)
	{	NodoInt nuovoNodo = new NodoInt(info,testa);
		testa = nuovoNodo;
		if(coda == null)
			coda = nuovoNodo;
		lunghezza++;		
	}
	
	public void rimuoviTesta()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		if(lunghezza == 1)
		{	svuota();
			return;			
		}
		testa = testa.getSuccessivo();
		lunghezza--;
		if(testa == null)
			coda = null;		
	}
	
	public void rimuoviCoda()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		if(lunghezza == 1)
		{	svuota();
			return;			
		}
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
			if(n.getSuccessivo() == coda)
			{	n.setSuccessivo(null);
				coda = n;				
			}
		lunghezza--;
	}
	
	public ListaConcatenataInt listaInvertita()
	{	ListaConcatenataInt ret = new ListaConcatenataInt();
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
			ret.aggiungiInTesta(n.getInfo());
		return ret;
	}
	
	public int get(int pos)
	{	if(pos < 0 || pos >= lunghezza)
			throw new EccezioneIndiceNonValido();
		NodoInt n = testa;
		for(int i = 0; i < pos; i++)
			n = n.getSuccessivo();
		return n.getInfo();		
	}
	
	public void rimuovi(int pos)
	{	if(pos < 0 || pos >= lunghezza)
			throw new EccezioneIndiceNonValido();
		if(pos == 0)
		{	rimuoviTesta();
			return;			
		}
		if(pos == lunghezza - 1)
		{	rimuoviCoda();
			return;			
		}
		NodoInt n = testa;
		for(int i = 0; i < pos - 1; i++)
			n = n.getSuccessivo();
		n.setSuccessivo(n.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
	public void rimuoviPrimo(int info)
	{	if(eVuota())
			return;
		if(testa.haInfo(info))
		{	rimuoviTesta();
			return;			
		}
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
		{	NodoInt successivoAdN = n.getSuccessivo();
			if(successivoAdN != null && successivoAdN.haInfo(info))
			{	n.setSuccessivo(successivoAdN.getSuccessivo());
				if(successivoAdN == coda)
					coda = n;
				lunghezza--;
				return;				
			}
		}
	}
	
	public void rimuoviTutti(int info)
	{	if(eVuota())
			return;
		while(testa != null && testa.haInfo(info))
			rimuoviTesta();
		NodoInt n = testa;
		while(n != null)
		{	NodoInt successivoAdN = n.getSuccessivo();
			if(successivoAdN != null && successivoAdN.haInfo(info))
			{	n.setSuccessivo(successivoAdN.getSuccessivo());
				if(successivoAdN == coda)
					coda = n;
				lunghezza--;
			}
			else
				n = successivoAdN;
		}
	}
	
	public int indiceDi(int info)
	{	int pos = 0;
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
		{	if(n.haInfo(info))
				return pos;
			pos++;			
		}
		return -1;
	}
	
	public int[] indiceDiTutti(int info)
	{	int cnt = conta(info);
		if(cnt == 0)
			return null;
		int[] ret = new int[cnt];
		int posLibera = 0;
		int indiceLista = 0;
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
		{	if(n.haInfo(info))
			{	ret[posLibera] = indiceLista;
				posLibera++;
			}
			indiceLista++;
		}
		return ret;
	}
	
	public boolean contiene(int info)
	{	return indiceDi(info) != -1;
	}
	
	public ArrayList<Integer> adArrayList()
	{	ArrayList<Integer> ret = new ArrayList<>();
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
			ret.add(n.getInfo());
		return ret;		
	}
	
	public int[] adArray()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		int[] ret = new int[lunghezza];
		int posLibera = 0;
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
		{	ret[posLibera] = n.getInfo();
			posLibera++;			
		}
		return ret;		
	}
	
	public String toString()
	{	String s = "[";
		for(NodoInt n = testa; n != null; n = n.getSuccessivo())
		{	s += n;
			if(n.getSuccessivo() != null)
				s += ", ";			
		}
		s += "]";
		return s;
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
		NodoInt n = testa;
		NodoInt nL = l.testa;
		boolean uguali = true;
		while(n != null && uguali)
		{	if(n.getInfo() != nL.getInfo())
				uguali = false;
			n = n.getSuccessivo();
			nL = nL.getSuccessivo();			
		}
		return uguali;		
	}
	
	private int sommaDa(NodoInt n)
	{	if(n == null)
			return 0;
		return n.getInfo() + sommaDa(n.getSuccessivo());		
	}
	
	public int somma()
	{	return sommaDa(testa);		
	}
	
	private int contaDa(NodoInt n, int info)
	{	if(n == null)
			return 0;
		return (n.haInfo(info)? 1 : 0) + contaDa(n.getSuccessivo(),info);		
	}
	
	public int conta(int info)
	{	return contaDa(testa,info);
	}
	
	private int minimoDa(NodoInt n)
	{	NodoInt successivoAdN = n.getSuccessivo();
		if(successivoAdN == null)
			return n.getInfo();
		return Math.min(n.getInfo(), minimoDa(successivoAdN));		
	}
	
	public int minimo()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		return minimoDa(testa);		
	}
	
	private int massimoDa(NodoInt n)
	{	NodoInt successivoAdN = n.getSuccessivo();
		if(successivoAdN == null)
			return n.getInfo();
		return Math.max(n.getInfo(), massimoDa(successivoAdN));		
	}
	
	public int massimo()
	{	if(eVuota())
			throw new EccezioneListaVuota();
		return massimoDa(testa);		
	}

	public int picchi(){
		return picchiDa(testa.getInfo(), testa.getSuccessivo());
	}

	private int picchiDa(int prec, NodoInt corrente) {
		if(corrente == null || corrente.getSuccessivo() == null)
			return 0;
		if(prec< corrente.getInfo()/2 && corrente.getSuccessivo().getInfo() <  corrente.getInfo()/2)
			return 1+ picchiDa(corrente.getInfo(), corrente.getSuccessivo());
		return picchiDa(corrente.getInfo(), corrente.getSuccessivo());

	}
}
