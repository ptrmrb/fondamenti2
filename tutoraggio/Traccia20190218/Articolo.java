package Traccia20190218;

import java.util.ArrayList;
import java.util.Objects;

public class Articolo {
    private String codice;
    private ArrayList<Cliente> clienti;
    private int data;

    public Articolo(String codice, ArrayList<Cliente> clienti, int data) {
        this.codice = codice;
        this.clienti = clienti;
        this.data = data;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public ArrayList<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(ArrayList<Cliente> clienti) {
        this.clienti = clienti;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Articolo articolo = (Articolo) o;
        return codice.equals(articolo.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
