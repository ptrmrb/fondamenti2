package traccia20190130;

import java.util.ArrayList;
import java.util.Objects;

public class Pubblicazione {
    private String codice, titolo;
    private ArrayList<String> autori, keywords;
    private int data;

    public Pubblicazione(String codice, String titolo, ArrayList<String> autori, ArrayList<String> keywords, int data) {
        this.codice = codice;
        this.titolo = titolo;
        this.autori = autori;
        this.keywords = keywords;
        this.data = data;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public ArrayList<String> getAutori() {
        return autori;
    }

    public void setAutori(ArrayList<String> autori) {
        this.autori = autori;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
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
        Pubblicazione that = (Pubblicazione) o;
        return codice.equals(that.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "codice='" + codice + '\'' +
                '}';
    }
}
