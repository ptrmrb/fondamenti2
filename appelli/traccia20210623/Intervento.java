package traccia20210623;

import java.util.*;

public class Intervento {
	private String Codice;
	private int Data;
	private int Durata;
	private LinkedList<String> ListaOperai;
	
	
	public Intervento(String Codice,int Data,int Durata,LinkedList<String> ListaOperai) {
		this.Codice = Codice;
		this.Data = Data;
		this.Durata = Durata;
		this.ListaOperai = ListaOperai;
	}
	
	public String getCodice() {
		return Codice;
	}
	
	public int getData() {
		return Data;
	}
	
	public int getDurata() {
		return Durata;
	}
	
	public LinkedList<String> getListaOperai() {
		return ListaOperai;
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o == this) return true;
		if (!(o instanceof Squadra)) return false;
		Intervento s = (Intervento) o;
		return Codice.equals(s.Codice);
	}
	
	public String toString() {
		return Codice;
	}
}
