package traccia20180717;

public class Attore {
    private String nome;
    private int eta;

    public Attore(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Attore{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }
}
