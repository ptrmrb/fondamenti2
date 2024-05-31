package traccia20180717;

import java.util.List;

public class Spettacolo {
    private int codice;
    private String tipologia;
    private List<String> attori;

    public Spettacolo(int codice, String tipologia, List<String> attori) {
        this.codice = codice;
        this.tipologia = tipologia;
        this.attori = attori;
    }

    public int getCodice() {
        return codice;
    }

    public String getTipologia() {
        return tipologia;
    }

    public List<String> getAttori() {
        return attori;
    }

    @Override
    public String toString() {
        return "Spettacolo {" +
                "codice=" + codice +
                ", tipologia='" + tipologia + '\'' +
                ", attori=" + attori +
                '}';
    }
}
