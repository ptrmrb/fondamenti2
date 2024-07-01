package traccia20240129;

public class Viaggio {
    private String codice;
    private String destinazione;
    private int durata;
    private int numPasseggeri;

    public Viaggio(String codice, String destinazione, int durata, int numPasseggeri) {
        this.codice = codice;
        this.destinazione = destinazione;
        this.durata = durata;
        this.numPasseggeri = numPasseggeri;
    }

    public String getCodice() {
        return codice;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getDurata() {
        return durata;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viaggio viaggio = (Viaggio) o;
        return codice.equals(viaggio.codice);
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "codice='" + codice + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", durata=" + durata +
                ", numPasseggeri=" + numPasseggeri +
                '}';
    }
}
