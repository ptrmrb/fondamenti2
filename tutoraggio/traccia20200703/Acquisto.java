package traccia20200703;
import java.util.Objects;

public class Acquisto {
    private String nomeNegozio, CFCliente, cittaCliente;
    private int data;

    public Acquisto(String nomeNegozio, String CFCliente, String cittaCliente, int data) {
        this.nomeNegozio = nomeNegozio;
        this.CFCliente = CFCliente;
        this.cittaCliente = cittaCliente;
        this.data = data;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public String getCFCliente() {
        return CFCliente;
    }

    public String getCittaCliente() {
        return cittaCliente;
    }

    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Acquisto acquisto = (Acquisto) o;
        return data == acquisto.data && nomeNegozio.equals(acquisto.nomeNegozio) && CFCliente.equals(acquisto.CFCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeNegozio, CFCliente, data);
    }

    @Override
    public String toString() {
        return "Acquisto{" +
                "nomeNegozio='" + nomeNegozio + '\'' +
                ", CFCliente='" + CFCliente + '\'' +
                ", cittaCliente='" + cittaCliente + '\'' +
                ", data=" + data +
                '}';
    }
}
