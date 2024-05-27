package traccia20220617;

public class Volo {
	private String partenza, arrivo;
	private int prezzobusiness, prezzoEconomico;
	
	public String getPartenza() {
		return partenza;
	}
	public String getArrivo() {
		return arrivo;
	}
	public int getPrezzobusiness() {
		return prezzobusiness;
	}
	public int getPrezzoEconomico() {
		return prezzoEconomico;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}
	public void setPrezzobusiness(int prezzobusiness) {
		this.prezzobusiness = prezzobusiness;
	}
	public void setPrezzoEconomico(int prezzoEconomico) {
		this.prezzoEconomico = prezzoEconomico;
	}
	@Override
	public String toString() {
		return "Volo [partenza=" + partenza + ", arrivo=" + arrivo + ", prezzobusiness=" + prezzobusiness
				+ ", prezzoEconomico=" + prezzoEconomico + "]";
	}

}