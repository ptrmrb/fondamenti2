package traccia20220921;

import java.util.Objects;

public class Film {
    private String titolo, regista;
    private int prezzoAcquisto, prezzoNoleggio;

    public Film(String titolo, String regista, int prezzoAcquisto, int prezzoNoleggio) {
        this.titolo = titolo;
        this.regista = regista;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoNoleggio = prezzoNoleggio;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getRegista() {
        return regista;
    }

    public int getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public int getPrezzoNoleggio() {
        return prezzoNoleggio;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return titolo.equals(film.titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo);
    }

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                '}';
    }
}
