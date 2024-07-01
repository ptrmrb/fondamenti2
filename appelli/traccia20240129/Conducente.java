package traccia20240129;

import java.util.LinkedList;

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
        Conducente conducente = (Conducente) o;
        return nome.equals(conducente.nome);
    }

    @Override
    public String toString() {
        return "Conducente{" +
                "nome='" + nome + '\'' +
                ", viaggi=" + viaggi +
                '}';
    }
}
