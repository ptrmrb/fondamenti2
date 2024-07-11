package traccia20230721;

import java.util.LinkedList;

import java.util.LinkedList;

public class Sistema {
    private LinkedList<Corso> listaCorsi;
    private LinkedList<Docente> listaDocenti;

    public Sistema() {
        this.listaCorsi = new LinkedList<>();
        this.listaDocenti = new LinkedList<>();
    }

    public boolean verifica(int caricoMin, int studentiMax) {
        // Implementazione richiesta
        return false;
    }

    public LinkedList<String> docentiSimili(String docente) {
        // Implementazione richiesta
        return new LinkedList<>();
    }

    public LinkedList<String> corsiCritici() {
        // Implementazione richiesta
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Esempi di creazione di corsi
        Corso c1 = new Corso("C1", "Fondamenti di informatica 1", 57, 140);
        Corso c2 = new Corso("C2", "Fondamenti di informatica 1", 57, 140);
        Corso c3 = new Corso("C3", "Fondamenti di informatica 2", 38, 140);
        Corso c4 = new Corso("C4", "Fondamenti di informatica 2", 38, 140);
        Corso c5 = new Corso("C5", "Analisi 1", 30, 100);
        Corso c6 = new Corso("C6", "Fondamenti di informatica 1", 30, 100);

        // Aggiunta dei corsi al sistema
        sistema.listaCorsi.add(c1);
        sistema.listaCorsi.add(c2);
        sistema.listaCorsi.add(c3);
        sistema.listaCorsi.add(c4);
        sistema.listaCorsi.add(c5);
        sistema.listaCorsi.add(c6);

        // Esempi di creazione di docenti
        LinkedList<String> corsiRossi = new LinkedList<>();
        corsiRossi.add("C1");
        corsiRossi.add("C3");
        corsiRossi.add("C6");
        Docente d1 = new Docente("Rossi", corsiRossi);

        LinkedList<String> corsiBianchi = new LinkedList<>();
        corsiBianchi.add("C2");
        Docente d2 = new Docente("Bianchi", corsiBianchi);

        LinkedList<String> corsiVerdi = new LinkedList<>();
        corsiVerdi.add("C4");
        corsiVerdi.add("C5");
        Docente d3 = new Docente("Verdi", corsiVerdi);

        // Aggiunta dei docenti al sistema
        sistema.listaDocenti.add(d1);
        sistema.listaDocenti.add(d2);
        sistema.listaDocenti.add(d3);

        // Esempio di chiamata ai metodi (senza implementazione)
        boolean risultatoVerifica = sistema.verifica(50, 140);
        LinkedList<String> docentiSimili = sistema.docentiSimili("Verdi");
        LinkedList<String> corsiCritici = sistema.corsiCritici();

        // Stampa dei risultati (per ora sarà vuota o predefinita, poiché i metodi non sono implementati)
        System.out.println("Risultato verifica: " + risultatoVerifica);
        System.out.println("Docenti simili a Verdi: " + docentiSimili);
        System.out.println("Corsi critici: " + corsiCritici);
    }
}
