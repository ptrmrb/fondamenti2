package traccia20230215;

import java.util.*;

public class Opera {
    private String nome;
    private String autore;
    private int anno;

    public Opera(String nome, String autore, int anno) {
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
    }

    public String getNome() {
        return nome;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opera opera = (Opera) o;
        return anno == opera.anno &&
                Objects.equals(nome, opera.nome) &&
                Objects.equals(autore, opera.autore);
    }

    @Override
    public String toString() {
        return "Opera{" +
                "nome='" + nome + '\'' +
                ", autore='" + autore + '\'' +
                ", anno=" + anno +
                '}';
    }
}