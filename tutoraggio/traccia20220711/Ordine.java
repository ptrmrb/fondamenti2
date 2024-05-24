package traccia20220711;

import java.util.Objects;

public class Ordine {
    private String id, merce, fornitore;
    private int quantita, data;

    public Ordine(String id, String merce, int quantita, String fornitore, int data) {
        this.id = id;
        this.merce = merce;
        this.fornitore = fornitore;
        this.quantita = quantita;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getMerce() {
        return merce;
    }

    public String getFornitore() {
        return fornitore;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Ordine ordine = (Ordine) o;
        return id.equals(ordine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id='" + id + '\'' +
                '}';
    }
}
