package traccia20230628;

class Scuderia {
    private String nome;
    private String citta;
    private float compensoExtra;

    public Scuderia(String nome, String citta, float compensoExtra) {
        this.nome = nome;
        this.citta = citta;
        this.compensoExtra = compensoExtra;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public float getCompensoExtra() {
        return compensoExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scuderia scuderia = (Scuderia) o;

        return nome.equals(scuderia.nome);
    }

    @Override
    public String toString() {
        return "Scuderia{" +
                "nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", compensoExtra=" + compensoExtra +
                '}';
    }
}