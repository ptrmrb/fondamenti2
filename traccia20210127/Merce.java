package traccia20210127;

import java.util.*;

public class Merce {
    private String nome;
    private String marca;
    private LinkedList<String> fornitori;

    public Merce(String nome, String marca, LinkedList<String> fornitori) {
        this.nome = nome;
        this.marca = marca;
        this.fornitori = fornitori;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public LinkedList<String> getFornitori() {
        return fornitori;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merce merce = (Merce) o;
        return Objects.equals(nome, merce.nome) &&
               Objects.equals(marca, merce.marca) &&
               Objects.equals(fornitori, merce.fornitori);
    }

    @Override
    public String toString() {
        return "Merce{" +
               "nome='" + nome + '\'' +
               ", marca='" + marca + '\'' +
               ", fornitori=" + fornitori +
               '}';
    }
}

