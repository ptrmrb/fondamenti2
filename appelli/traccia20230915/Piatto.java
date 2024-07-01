package traccia20230915;

import java.util.LinkedList;

public class Piatto {
    private String codice;
    private String nome;
    private LinkedList<String> ingredienti;
    private LinkedList<Integer> dosi;

    public Piatto(String codice, String nome, LinkedList<String> ingredienti, LinkedList<Integer> dosi) {
        this.codice = codice;
        this.nome = nome;
        this.ingredienti = ingredienti;
        this.dosi = dosi;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<String> getIngredienti() {
        return ingredienti;
    }

    public LinkedList<Integer> getDosi() {
        return dosi;
    }

    @Override
    public boolean equals(Object o) {
        // Da implementare
        return false;
    }

    @Override
    public String toString() {
        // Da implementare
        return "";
    }
}

