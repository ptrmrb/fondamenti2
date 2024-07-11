package traccia20230123;

import java.util.LinkedList;

public class Impianto {
    private String appartamento;
    private int prezzoInstallazione;
    private int dataInstallazione;
    private String tipo;
    private LinkedList<String> tecnici;

    public Impianto(String appartamento, int prezzoInstallazione, int dataInstallazione, String tipo, LinkedList<String> tecnici) {
        this.appartamento = appartamento;
        this.prezzoInstallazione = prezzoInstallazione;
        this.dataInstallazione = dataInstallazione;
        this.tipo = tipo;
        this.tecnici = tecnici;
    }

    public String getAppartamento() {
        return appartamento;
    }

    public int getPrezzoInstallazione() {
        return prezzoInstallazione;
    }

    public int getDataInstallazione() {
        return dataInstallazione;
    }

    public String getTipo() {
        return tipo;
    }

    public LinkedList<String> getTecnici() {
        return tecnici;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impianto impianto = (Impianto) o;
        return appartamento.equals(impianto.appartamento);
    }

    @Override
    public String toString() {
        return "Impianto{" +
                "appartamento='" + appartamento + '\'' +
                ", prezzoInstallazione=" + prezzoInstallazione +
                ", dataInstallazione=" + dataInstallazione +
                ", tipo='" + tipo + '\'' +
                ", tecnici=" + tecnici +
                '}';
    }
}
