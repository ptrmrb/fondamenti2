package lezioni;

import terminale.*;

public class Lezione0703 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Mario", "Vizza", 2004);
        Persona p2 = new Persona("Luigi", "Senatore", 2005);

        Persona[] comitiva = new Persona[5];
        comitiva[0] = p1;
        comitiva[1] = p2;

        String s1 = p1.toString();
        String s2 = p2.toString();

        Terminale.stampa(s1);
        Terminale.stampa(s2);
    }
}
