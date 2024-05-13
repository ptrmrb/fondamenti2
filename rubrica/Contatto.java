package rubrica;

// La classe genera oggetti mutabili
public class Contatto 
{	private String nome, cognome, email;
	private NumeroTelefonico[] numeri;
	private int numeriMemorizzati;

	public Contatto(String nome, String cognome) 
	{	this.nome = nome;
		this.cognome = cognome;
		email = null;
		numeri = new NumeroTelefonico[5];
		numeriMemorizzati = 0;
	}

	public Contatto(String nome, String cognome, NumeroTelefonico nt) 
	{	this.nome = nome;
		this.cognome = cognome;
		email = null;
		numeri = new NumeroTelefonico[5];
		numeriMemorizzati = 1;
		numeri[0] = nt;
	}
	
	public Contatto(Contatto c) 
	{	nome = c.nome;
		cognome = c.cognome;
		email = c.email;
		numeriMemorizzati = c.numeriMemorizzati;
		numeri = new NumeroTelefonico[c.numeri.length]; //PROTECTIVE COPY
		for(int i=0; i<c.numeriMemorizzati; i++)
			numeri[i] = c.numeri[i];
	}

	public String getNome() 
	{ 	return nome; 
	}

	public String getCognome() 
	{ 	return cognome; 
	}

	public String getEmail() 
	{	return email==null? "" : email; 
	}

	public void setNome(String nome) 
	{	this.nome = nome;
	}

	public void setCognome(String cognome) 
	{ 	this.cognome = cognome; 
	}

	public void setEmail(String email) 
	{ 	this.email = email; 
	}

	public NumeroTelefonico estraiNumero(String tipo) 
	{	NumeroTelefonico ris = null;
		for(int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].getTipo().equals(tipo)) 
			{	ris = numeri[i];
				break;
			}
		return ris;
	}

	public void aggiungiNumero(NumeroTelefonico n) 
	{	if(numeriMemorizzati < numeri.length) 
			numeri[numeriMemorizzati] = n;
		else // array numeri "saturo" (numeriMemorizzati==numeri.length) 
		{	NumeroTelefonico[] nuovo = new NumeroTelefonico[numeriMemorizzati * 2];
			for(int i=0; i<numeriMemorizzati; i++)
				nuovo[i] = numeri[i];
			nuovo[numeriMemorizzati] = n;
			numeri = nuovo;
		}
		numeriMemorizzati++;
	}

	private void eliminaNumero(int indice) 
	{	NumeroTelefonico[] nuovo = new NumeroTelefonico[numeri.length];
		for(int i=0; i<indice; i++)
			nuovo[i] = numeri[i];
		for(int i=indice+1; i<numeriMemorizzati; i++)
			nuovo[i-1] = numeri[i];
		numeriMemorizzati--;
		numeri = nuovo;

	}

	private void eliminaNumero2(int indice) // versione alternativa di eliminaNumero(int indice) 
	{	for(int i=indice+1; i<numeriMemorizzati; i++)
			numeri[i-1] = numeri[i];
		numeri[numeriMemorizzati-1] = null;// OPZIONALE
		numeriMemorizzati--;
	}

	public void eliminaNumero(NumeroTelefonico n) 
	{	int indice = -1;
		for(int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].equals(n)) 
			{	indice = i;
				break;
			}
		if(indice!=-1)
			eliminaNumero(indice);
	}

	public void eliminaNumero(String tipo) 
	{	int indice = -1;
		for(int i=0; i<numeriMemorizzati; i++)
			if(numeri[i].getTipo().equals(tipo)) 
			{	indice = i;
				break;
			}
		if(indice!=-1)
			eliminaNumero(indice);
	}

	public String toString() 
	{	String ret = "=================================\n";
		ret += nome + " " + cognome + "\n";
		if(email!=null)
			ret += "Email: " + email + "\n";
		for(int i=0; i<numeriMemorizzati; i++)
			ret += numeri[i] + "\n";// ret += numeri[i].toString() + "\n";
		ret += "=================================\n";
		return ret;
	}

	public boolean equals(Object o) 
	{	if(o==null) 
			return false;
		if(this==o) 
			return true;
		if(!(o instanceof Contatto)) 
			return false;
		Contatto c = (Contatto) o;
		if(!nome.equals(c.nome) || !cognome.equals(c.cognome) || !getEmail().equals(c.getEmail()) || numeriMemorizzati!=c.numeriMemorizzati)
			return false;
		for(int i=0; i<numeriMemorizzati; i++)
			if(!numeri[i].equals(c.numeri[i]))
				return false;
		return true;
	}
}