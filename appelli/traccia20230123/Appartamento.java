package traccia20230123;

public class Appartamento {
    private String codice;
    private String scala;

    public Appartamento(String codice, String scala) {
        this.codice = codice;
        this.scala = scala;
    }

    public String getCodice() {
        return codice;
    }

    public String getScala() {
        return scala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appartamento that = (Appartamento) o;
        return codice.equals(that.codice);
    }

    @Override
    public String toString() {
        return "Appartamento{" +
                "codice='" + codice + '\'' +
                ", scala='" + scala + '\'' +
                '}';
    }
}
