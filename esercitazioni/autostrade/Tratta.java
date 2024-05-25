package autostrade;

public class Tratta 
{	private String codice;
	private String nome;
	private Citta cittaPartenza;
	private Citta cittaDestinazione;
	private double distanza;
	
	public Tratta(String codice, String nome, Citta cittaPartenza, Citta cittaDestinazione, double distanza) 
	{	this.codice = codice;
		this.nome = nome;
		this.cittaPartenza = cittaPartenza;
		this.cittaDestinazione = cittaDestinazione;
		this.distanza = distanza;
	}

	public String getCodice() 
	{	return codice;
	}

	public String getNome() 
	{	return nome;
	}

	public Citta getCittaPartenza() 
	{	return cittaPartenza;
	}

	public Citta getCittaDestinazione() 
	{	return cittaDestinazione;
	}

	public double getDistanza() 
	{	return distanza;
	}
	
	public String toString()
	{	return "Tratta con codice "+codice+", nome "+nome+" dalla città "+cittaPartenza+
			" alla città "+cittaDestinazione+", distanza "+distanza;
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Tratta))
			return false;
		Tratta t = (Tratta)o;
		return codice.equals(t.codice);
	}
}
