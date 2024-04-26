package autostrade;

public class Citta implements Comparable<Citta>
{	private String nome;
	private String provincia;
	private String regione;
	
	public Citta(String nome, String provincia, String regione)
	{	this.nome = nome;
		this.provincia = provincia;
		this.regione = regione;		
	}
	
	public String getNome()
	{	return nome;		
	}
	
	public String getProvincia()
	{	return provincia;		
	}
	
	public String getRegione()
	{	return regione;		
	}
	
	public String toString()
	{	return nome+" ("+provincia+") in "+regione;
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Citta))
			return false;
		Citta c = (Citta)o;
		return nome.equals(c.nome) && provincia.equals(c.provincia);
	}
	
	public int compareTo(Citta c)
	{	int mieiAccessi = GestioneReteAS.accessi(this);
		int accessiC = GestioneReteAS.accessi(c);
		if(mieiAccessi < accessiC)
			return -1;
		if(mieiAccessi == accessiC)
			return 0;
		return 1;	
	}
}
