package traccia20190130;

import java.util.Objects;

public class Autore {
    private String nome, citta;

    public Autore(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Autore autore = (Autore) o;
        return nome.equals(autore.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Autore{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
