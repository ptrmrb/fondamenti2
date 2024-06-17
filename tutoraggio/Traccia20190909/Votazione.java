package traccia20190909;

public class Votazione {
	private int codice;
	private String parlamentare;
	private int disegnoDiLegge;
	private boolean voto;
	
	public Votazione(int codice, String parlamentare, int disegnoDiLegge, boolean voto)
	{	this.codice=codice;
		this.parlamentare=parlamentare;
		this.disegnoDiLegge=disegnoDiLegge;
		this.voto=voto;
	}
	
	public int getCodice()
	{	return codice;
	}
	
	public String getParlamentare()
	{	return parlamentare;
	}

	public int getDisegnoDiLegge()
	{	return disegnoDiLegge;
	}
	
	public boolean getVoto()
	{	return voto;
	}
	
	public boolean equals(Object o)
	{	if(o==null)
			return false;
		if(o==this)
			return true;
		if(!(o instanceof Votazione))
			return false;
		Votazione v=(Votazione) o;
		return v.getCodice()==this.codice;
	}
	
	public String toString()
	{	return "" + codice + "," + parlamentare + "," + disegnoDiLegge + "," + voto;
	}
	
	public void setCodice(int codice)
	{	this.codice=codice;
	}
	
	public void setParlamentare(String parlamentare)
	{	this.parlamentare=parlamentare;
	}
	
	public void setDisegnoDiLegge(int ddl)
	{	this.disegnoDiLegge=ddl;
	}
	
	public void setVoto(boolean voto)
	{	this.voto=voto;
	}
	
}
