package autostrade;

public class Autoveicolo 
{	private String targa;
	private String marca;
	private int cilindrata;
	
	public Autoveicolo(String targa, String marca, int cilindrata) 
	{	this.targa = targa;
		this.marca = marca;
		this.cilindrata = cilindrata;
	}

	public String getTarga() 
	{	return targa;
	}

	public String getMarca() 
	{	return marca;
	}

	public int getCilindrata() 
	{	return cilindrata;
	}
	
	public String toString()
	{	return "Autoveicolo targato "+targa+" di marca "+marca+" e cilindrata "+cilindrata;		
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Autoveicolo))
			return false;
		Autoveicolo a = (Autoveicolo)o;
		return targa.equals(a.targa);
	}
}
