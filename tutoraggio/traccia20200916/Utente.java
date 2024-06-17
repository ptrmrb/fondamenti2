package traccia20200916;

import java.util.Objects;

public class Utente {
    private String nome, Citta;

    public Utente(String nome, String citta) {
        this.nome = nome;
        Citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return Citta;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(nome, utente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
