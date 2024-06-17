package traccia20230628;

import java.util.LinkedList;
import java.util.List;

// Classe Pilota
class Pilota {
    private String nome;
    private int eta;
    private float compensoPerGara;

    public Pilota(String nome, int eta, float compensoPerGara) {
        this.nome = nome;
        this.eta = eta;
        this.compensoPerGara = compensoPerGara;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public float getCompensoPerGara() {
        return compensoPerGara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pilota pilota = (Pilota) o;

        return nome.equals(pilota.nome);
    }

    @Override
    public String toString() {
        return "Pilota{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                ", compensoPerGara=" + compensoPerGara +
                '}';
    }
}