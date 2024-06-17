package traccia20200703;
import java.util.Objects;

public class Negozio {
    private String nome, citta;

    public Negozio(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Negozio negozio = (Negozio) o;
        return nome.equals(negozio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Negozio{" +
                "nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
