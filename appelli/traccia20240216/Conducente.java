package traccia20240216;

import java.util.*;

public class Conducente {
    private String nome;
    private LinkedList<String> viaggi;

    public Conducente(String nome, LinkedList<String> viaggi) {
        this.nome = nome;
        this.viaggi = viaggi;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<String> getViaggi() {
        return viaggi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conducente that = (Conducente) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public String toString() {
        return "Conducente{" +
                "nome='" + nome + '\'' +
                ", viaggi=" + viaggi +
                '}';
    }
}
