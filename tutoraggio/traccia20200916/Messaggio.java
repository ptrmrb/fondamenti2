package traccia20200916;

import java.util.Objects;

public class Messaggio {
    private String nomeMittente, nomeDestinatario;
    private int data;
    private boolean letto;

    public Messaggio(String nomeMittente, String nomeDestinatario, int data, boolean letto) {
        this.nomeMittente = nomeMittente;
        this.nomeDestinatario = nomeDestinatario;
        this.data = data;
        this.letto = letto;
    }

    public String getNomeMittente() {
        return nomeMittente;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public int getData() {
        return data;
    }

    public boolean isLetto() {
        return letto;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Messaggio messaggio = (Messaggio) o;
        return data == messaggio.data && Objects.equals(nomeMittente, messaggio.nomeMittente) && Objects.equals(nomeDestinatario, messaggio.nomeDestinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMittente, nomeDestinatario, data);
    }

    @Override
    public String toString() {
        return "Messaggio{" +
                "nomeMittente='" + nomeMittente + '\'' +
                ", nomeDestinatario='" + nomeDestinatario + '\'' +
                ", data=" + data +
                '}';
    }
}
