package traccia20220921;

import java.util.LinkedList;
import java.util.Objects;

public class Cliente {
    private String nome;
    private LinkedList<String> titoli, modalita;
    private LinkedList<Integer> date;

    public Cliente(String nome, LinkedList<String> titoli, LinkedList<String> modalita, LinkedList<Integer> date) {
        this.nome = nome;
        this.titoli = new LinkedList<>(titoli);
        this.modalita = new LinkedList<>(modalita);
        this.date = new LinkedList<>(date);
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<String> getTitoli() {
        return titoli;
    }

    public LinkedList<String> getModalita() {
        return modalita;
    }

    public LinkedList<Integer> getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
