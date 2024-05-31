package traccia20210623;

import java.util.*;

public class Operaio {
	private String nome;
	private float costoOraio;
	
	
	public Operaio(String nome, float costoOraio) {
		this.nome = nome;
		this.costoOraio = costoOraio;
	}


	public String getNome() {
		return nome;
	}


	public float getCostoOraio() {
		return costoOraio;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCostoOraio(float costoOraio) {
		this.costoOraio = costoOraio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operaio other = (Operaio) obj;
		return Float.floatToIntBits(costoOraio) == Float.floatToIntBits(other.costoOraio)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Operaio [nome=" + nome + ", costoOraio=" + costoOraio + "]";
	}
	
    public static void main(String[] args) {
		Operaio operaio1 = new Operaio("Alberto",10);
		Operaio operaio2 = new Operaio("Gianni",12);
		Operaio operaio3 = new Operaio("Eva",12);
		Operaio operaio4 = new Operaio("Filippo",8);
		
		LinkedList<Operaio> operai = new LinkedList<>(List.of(operaio1,operaio2,operaio3,operaio4));   
    }
}


