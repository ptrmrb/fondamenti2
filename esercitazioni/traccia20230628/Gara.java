package traccia20230628;

import java.util.LinkedList;
import java.util.List;

class Gara {
    private String id;
    private String luogo;
    private LinkedList<String> piloti;
    private LinkedList<String> scuderie;

    public Gara(String id, String luogo, LinkedList<String> piloti, LinkedList<String> scuderie) {
        this.id = id;
        this.luogo = luogo;
        this.piloti = piloti;
        this.scuderie = scuderie;
    }

    public String getID() {
        return id;
    }

    public String getLuogo() {
        return luogo;
    }

    public LinkedList<String> getPiloti() {
        return piloti;
    }

    public LinkedList<String> getScuderie() {
        return scuderie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gara gara = (Gara) o;

        return id.equals(gara.id);
    }

    @Override
    public String toString() {
        return "Gara{" +
                "id='" + id + '\'' +
                ", luogo='" + luogo + '\'' +
                ", piloti=" + piloti +
                ", scuderie=" + scuderie +
                '}';
    }
}