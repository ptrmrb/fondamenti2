package autostrade;

public class Percorrenza 
{	private Tratta tratta;
	private Autoveicolo autoveicolo;
	private int data;
	
	public Percorrenza(Tratta tratta, Autoveicolo autoveicolo, int data) 
	{	this.tratta = tratta;
		this.autoveicolo = autoveicolo;
		this.data = data;
	}

	public Tratta getTratta() 
	{	return tratta;
	}

	public Autoveicolo getAutoveicolo() 
	{	return autoveicolo;
	}

	public int getData() 
	{	return data;
	}
	
	public String toString()
	{	return "Percorrenza della tratta "+tratta+" percorsa dall'autoveicolo "+autoveicolo+" in data "+data;		
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Percorrenza))
			return false;
		Percorrenza p = (Percorrenza)o;
		return tratta.equals(p.tratta) && autoveicolo.equals(p.autoveicolo) && data == p.data;
	}
}
