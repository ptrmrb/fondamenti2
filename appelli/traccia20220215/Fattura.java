import java.util.LinkedList;

public class Fattura {
    private int id;
    private String cliente;
    private int data;
    private LinkedList<String> prodotti;
    private LinkedList<Integer> quantita;

    public Fattura(int id, String cliente, int data, LinkedList<String> prodotti, LinkedList<Integer> quantita) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.prodotti = prodotti;
        this.quantita = quantita;
    }

    public int getID() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public int getData() {
        return data;
    }

    public LinkedList<String> getProdotti() {
        return prodotti;
    }

    public LinkedList<Integer> getQuantita() {
        return quantita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fattura fattura = (Fattura) o;
        return id == fattura.id;
    }

    @Override
    public String toString() {
        return "Fattura{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", data=" + data +
                ", prodotti=" + prodotti +
                ", quantita=" + quantita +
                '}';
    }
}
