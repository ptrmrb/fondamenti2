package traccia20220617;
import java.util.*;

import java.util.LinkedList;

public class Prenotazione {
    private LinkedList<String> percorso;
    private String nomeCliente;
    private String classe;

    public Prenotazione(LinkedList<String> percorso, String nomeCliente, String classe) {
        this.percorso = percorso;
        this.nomeCliente = nomeCliente;
        this.classe = classe;
    }

    public LinkedList<String> getPercorso() {
        return percorso;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return percorso.equals(that.percorso) &&
               nomeCliente.equals(that.nomeCliente) &&
               classe.equals(that.classe);
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "percorso=" + percorso +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }
}
