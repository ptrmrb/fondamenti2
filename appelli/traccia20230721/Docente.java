package traccia20230721;

import java.util.LinkedList;
import java.util.Objects;

public class Docente {
    private String nome;
    private LinkedList<String> corsi;

    public Docente(String nome, LinkedList<String> corsi) {
        this.nome = nome;
        this.corsi = corsi;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<String> getCorsi() {
        return corsi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(nome, docente.nome);
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nome='" + nome + '\'' +
                ", corsi=" + corsi +
                '}';
    }
}
