package traccia20230215;

import java.util.*;

public class Vendita {
    private String id;
    private String opera;
    private LinkedList<Integer> offerte;
    private LinkedList<String> offerenti;

    public Vendita(String id, String opera, LinkedList<Integer> offerte, LinkedList<String> offerenti) {
        this.id = id;
        this.opera = opera;
        this.offerte = offerte;
        this.offerenti = offerenti;
    }

    public String getID() {
        return id;
    }

    public String getOpera() {
        return opera;
    }

    public LinkedList<Integer> getOfferte() {
        return offerte;
    }

    public LinkedList<String> getOfferenti() {
        return offerenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendita vendita = (Vendita) o;
        return Objects.equals(id, vendita.id) &&
                Objects.equals(opera, vendita.opera) &&
                Objects.equals(offerte, vendita.offerte) &&
                Objects.equals(offerenti, vendita.offerenti);
    }

    @Override
    public String toString() {
        return "Vendita{" +
                "id='" + id + '\'' +
                ", opera='" + opera + '\'' +
                ", offerte=" + offerte +
                ", offerenti=" + offerenti +
                '}';
    }
}
