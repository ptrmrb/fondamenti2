package traccia20210127;

import java.util.*;

public class Fornitore {
    private String nome;
    private String citta;

    public Fornitore(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornitore fornitore = (Fornitore) o;
        return Objects.equals(nome, fornitore.nome) &&
               Objects.equals(citta, fornitore.citta);
    }

    @Override
    public String toString() {
        return "Fornitore{" +
               "nome='" + nome + '\'' +
               ", citta='" + citta + '\'' +
               '}';
    }
}
