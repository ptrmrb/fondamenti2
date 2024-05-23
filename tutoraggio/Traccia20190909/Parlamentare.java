package appelloSettembre;

public class Parlamentare {
	private String cf;
	private String regione;
	private String partito;
	
	public Parlamentare(String cf, String regione, String partito)
	{	this.cf=cf;
		this.regione=regione;
		this.partito=partito;
	}
	
	public String getCf()
	{	return cf;
	}
	
	public String getRegione()
	{	return regione;
	}
	
	public String getPartito()
	{	return partito;
	}
	
	public boolean equals(Object o)
	{	if(o==null)
			return false;
		if(o==this)
			return true;
		if(!(o instanceof Parlamentare))
			return false;
		Parlamentare p=(Parlamentare) o;
		return p.getCf().equals(this.cf);
	}
	
	public String toString()
	{	return cf;
	}
	
	public void setCf(String cf)
	{	this.cf=cf;
	}
	
	public void setRegione(String regione)
	{	this.regione=regione;
	}
	
	public void setPartito(String partito)
	{	this.partito=partito;
	}

}
