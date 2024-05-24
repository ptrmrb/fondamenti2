package traccia20220711;

import java.util.LinkedList;
import java.util.Objects;

public class Merce {
    private String nome, marca;
    private LinkedList<String> listaFornitori;
    private LinkedList<Float> listaPrezzi;

    public Merce(String nome, String marca, LinkedList<String> listaFornitori, LinkedList<Float> listaPrezzi) {
        this.nome = nome;
        this.marca = marca;
        this.listaFornitori = new LinkedList<>(listaFornitori);
        this.listaPrezzi = new LinkedList<>(listaPrezzi);
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public LinkedList<String> getListaFornitori() {
        return listaFornitori;
    }

    public LinkedList<Float> getListaPrezzi() {
        return listaPrezzi;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Merce merce = (Merce) o;
        return nome.equals(merce.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Merce{" +
                "nome='" + nome + '\'' +
                '}';
    }

    /*
publicString getNome(), che restituisce il nome della merce (che si suppone essere identificativo della merce stessa).•publicString getMarca(), che restituisce il nome della marca produttrice della merce.•public LinkedList<String>getListaFornitori(), che restituisce la lista dei nomi dei fornitori della merce.•public LinkedList<Float> getListaPrezzi(), che restituisce la lista dei prezzi a cui viene fornita la merce (il prezzo presente nella posizione i-esima di tale lista è il prezzo UNITARIO a cui la merce viene fornita dal fornitore che si trova nella stessa posizione nella lista restituita da getListaFornitori() ).
     */
}
