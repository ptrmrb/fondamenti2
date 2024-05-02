package rubrica;

// La classe genera oggetti immutabili
public class NumeroTelefonico 
{	private String tipo; // casa, lavoro, ...
	private String numero; // +39 340 123 456

	public NumeroTelefonico(String tipo, String numero) 
	{	this.tipo = tipo;
		this.numero = numero;
	}

	public String getTipo() 
	{	return tipo;
	}

	public String getNumero() 
	{	return numero;
	}

	public String toString() 
	{	return tipo + ": " + numero;
	}

	public boolean equals(Object o) 
	{	if(o==null)
			return false;
		if(this==o)
			return true;
		if(!(o instanceof NumeroTelefonico))
			return false;
		NumeroTelefonico n = (NumeroTelefonico) o;
		return tipo.equals(n.tipo) && numero.equals(n.numero);
	}
}
