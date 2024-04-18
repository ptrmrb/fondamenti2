package razionali;

public class Razionale 
{	// Denominatore sempre positivo
	// Sempre ridotto ai minimi termini
	private int numeratore;
	private int denominatore;
	
	public Razionale(int numeratore, int denominatore)
	{	this.numeratore = numeratore;
		this.denominatore = denominatore;
		if(denominatore < 0)
		{	this.numeratore *= -1;
			this.denominatore *= -1;
		}
		semplifica();
	}
	
	public Razionale(int n)
	{	numeratore = n;
		denominatore = 1;
		//ALTERNATIVA:
		//this(n,1);
	}
	
	public Razionale(Razionale r)
	{	numeratore = r.numeratore;
		denominatore = r.denominatore;
		//ALTERNATIVA:
		//this(r.numeratore, r.denominatore);
	}
	
	public Razionale()
	{	numeratore = 0;
		denominatore = 1;
		//ALTERNATIVA 1:
		//this(0,1);
		//ALTERNATIVA 1:
		//this(0);
	}
	
	public int getNumeratore()
	{	return numeratore;		
	}
	
	public int getDenominatore()
	{	return denominatore;		
	}

	public void moltiplica(Razionale r)
	{	numeratore *= r.numeratore;
		denominatore *= r.denominatore;
		semplifica();		
	}
	
	public void moltiplica(int n)
	{	moltiplica(new Razionale(n));
		//ALTERNATIVA:
		//numeratore *= n;
		//semplifica();
	}
	
	public Razionale reciproco()
	{	return new Razionale(denominatore, numeratore);		
	}
	
	public void dividi(Razionale r)
	{	moltiplica(r.reciproco());		
	}
	
	public void dividi(int n)
	{	dividi(new Razionale(n));
	}
	
	public void aggiungi(Razionale r)
	{	numeratore = numeratore * r.denominatore +
						r.numeratore * denominatore;
		denominatore *= r.denominatore;
		semplifica();
	}
	
	public void sottrai(Razionale r)
	{	aggiungi(new Razionale(-r.numeratore,r.denominatore));
	}
	
	public boolean equals(Object o)
	{	if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof Razionale))
			return false;
		Razionale r = (Razionale)o;
		return numeratore == r.numeratore &&
				denominatore == r.denominatore;
	}
	
	private void semplifica()
	{	if(numeratore == 0)
			denominatore = 1;
		else
		{	int m = mcd();
			numeratore /= m;
			denominatore /= m;
		}
	}
	
	private int mcd()
	{	int x = Math.abs(numeratore);
		int y = denominatore;
		for(int n = Math.min(x, y); n > 1 ; n--)
			if(x % n == 0 && y % n == 0)
				return n;
		return 1;
	}
	
	public String toString()
	{	String ret = "" + numeratore;
		if(denominatore != 1)
			ret += "/" + denominatore;
		return ret;
	}
	
	public static Razionale prodotto( Razionale x, Razionale y)
	{
		Razionale r = new Razionale(x);
		ret.moltiplica()

	}

}
