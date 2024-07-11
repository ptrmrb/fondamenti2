public class Prodotto {
    private String nome;
    private String marca;
    private float prezzoUnitario;

    public Prodotto(String nome, String marca, float prezzoUnitario) {
        this.nome = nome;
        this.marca = marca;
        this.prezzoUnitario = prezzoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrezzoUnitario() {
        return prezzoUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return nome.equals(prodotto.nome);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", prezzoUnitario=" + prezzoUnitario +
                '}';
    }
}
