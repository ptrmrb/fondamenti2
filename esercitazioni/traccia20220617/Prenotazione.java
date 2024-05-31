package traccia20220617;
import java.util.*;

public class Prenotazione {
	private LinkedList<String> Percorso;
	private String cliente, classe;
	
	public LinkedList<String> getPercorso() {
		return Percorso;
	}
	public String getNomeCliente() {
		return cliente;
	}
	public String getClasse() {
		return classe;
	}
	public void setPercorso(LinkedList<String> percorso) {
		Percorso = percorso;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Percorso, classe, cliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(Percorso, other.Percorso) && Objects.equals(classe, other.classe)
				&& Objects.equals(cliente, other.cliente);
	}
	
	
	
}