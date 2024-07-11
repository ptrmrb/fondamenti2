package traccia20220617;

import java.util.LinkedList;

public class Volo {
    private String partenza;
    private String arrivo;
    private int prezzoBusiness;
    private int prezzoEconomica;


    public Volo(String partenza, String arrivo, int prezzoBusiness, int prezzoEconomica) {
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.prezzoBusiness = prezzoBusiness;
        this.prezzoEconomica = prezzoEconomica;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public int getPrezzoBusiness() {
        return prezzoBusiness;
    }

    public int getPrezzoEconomica() {
        return prezzoEconomica;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volo volo = (Volo) o;
        return partenza.equals(volo.partenza) && arrivo.equals(volo.arrivo);
    }

    public String toString() {
        return "Volo{" +
                "partenza='" + partenza + '\'' +
                ", arrivo='" + arrivo + '\'' +
                ", prezzoBusiness=" + prezzoBusiness +
                ", prezzoEconomica=" + prezzoEconomica;
    }

}