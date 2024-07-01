package traccia20230915;

import java.util.LinkedList;

public class Ingrediente {
    private String codice;
    private String nome;
    private float costoUnitario;
    private boolean adattoVegetariani;

    public Ingrediente(String codice, String nome, float costoUnitario, boolean adattoVegetariani) {
        this.codice = codice;
        this.nome = nome;
        this.costoUnitario = costoUnitario;
        this.adattoVegetariani = adattoVegetariani;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public boolean adattoVegetariani() {
        return adattoVegetariani;
    }

    @Override
    public boolean equals(Object o) {
        // Da implementare
        return false;
    }

    @Override
    public String toString() {
        // Da implementare
        return "";
    }
}
