package appelloSettembre;
import java.util.*;

public class DisegnoDiLegge implements Comparable<DisegnoDiLegge>{
	private int id;
	private String nome;
	private ArrayList<String> parlamentari;
	private int data;
	private boolean esito;
	
	public DisegnoDiLegge(int id, String nome, ArrayList<String> parlamentari, int data, boolean esito)
	{	this.id=id;
		this.nome=nome;
		this.parlamentari=parlamentari;
		this.parlamentari=parlamentari;
		this.data=data;
		this.esito=esito;
	}
	
	public int getId()
	{	return id;
	}
	
	public String getNome()
	{	return nome;
	}
	
	public ArrayList<String> getParlamentari()
	{	return this.parlamentari;
	}
	
	public int getData()
	{	return data;
	}
	
	public boolean getEsito()
	{	return esito;
	}
	
	public boolean equals(Object o)
	{	if(o==null)
			return false;
		if(o==this)
			return true;
		if(!(o instanceof DisegnoDiLegge))
			return false;
		DisegnoDiLegge ddl=(DisegnoDiLegge) o;
		return this.id==ddl.getId();
	}
	
	
	public String toString()
	{	return this.nome;
	}
	
	public void setId(int id)
	{	this.id=id;
	}
	
	public void setNome(String nome)
	{	this.nome=nome;
	}
	
	public void setParlamentari(ArrayList<String> p)
	{	this.parlamentari=p;
	}

	public void setData(int data)
	{	this.data=data;
	}
	
	public void setEsito(boolean esito)
	{	this.esito=esito;
	}
	
	public int compareTo(DisegnoDiLegge ddl)
	{	if(this.data>ddl.data)
			return 1;
		if(this.data==ddl.data)
			return 0;
		return -1;
	}
}
