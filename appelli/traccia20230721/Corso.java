package traccia20230721;

import java.util.Objects;

public class Corso {
    private String codice;
    private String titolo;
    private int durata;
    private int numStudenti;

    public Corso(String codice, String titolo, int durata, int numStudenti) {
        this.codice = codice;
        this.titolo = titolo;
        this.durata = durata;
        this.numStudenti = numStudenti;
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getDurata() {
        return durata;
    }

    public int getNumStudenti() {
        return numStudenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corso corso = (Corso) o;
        return Objects.equals(codice, corso.codice);
    }

    @Override
    public String toString() {
        return "Corso{" +
                "codice='" + codice + '\'' +
                ", titolo='" + titolo + '\'' +
                ", durata=" + durata +
                ", numStudenti=" + numStudenti +
                '}';
    }
}
