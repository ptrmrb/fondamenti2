package traccia20230123;

import java.util.LinkedList;

public class Sistema {
    private LinkedList<Appartamento> listaAppartamenti;
    private LinkedList<Impianto> listaImpianti;

    public Sistema(LinkedList<Appartamento> listaAppartamenti, LinkedList<Impianto> listaImpianti) {
        this.listaAppartamenti = listaAppartamenti;
        this.listaImpianti = listaImpianti;
    }

    public LinkedList<String> scaleUnicoTipo() {
        // Implementazione da aggiungere
        return null;
    }

    public String tecnicoMax() {
        // Implementazione da aggiungere
        return null;
    }

    public String scalaSimile(String cod, int d1, int d2) {
        // Implementazione da aggiungere
        return null;
    }

    public static void main(String[] args) {
        // Creazione degli appartamenti
        Appartamento appartamento1 = new Appartamento("A1", "S1");
        Appartamento appartamento2 = new Appartamento("A2", "S1");
        Appartamento appartamento3 = new Appartamento("A3", "S2");
        Appartamento appartamento4 = new Appartamento("A4", "S2");
        Appartamento appartamento5 = new Appartamento("A5", "S3");
        Appartamento appartamento6 = new Appartamento("A6", "S3");

        LinkedList<Appartamento> listaAppartamenti = new LinkedList<>();
        listaAppartamenti.add(appartamento1);
        listaAppartamenti.add(appartamento2);
        listaAppartamenti.add(appartamento3);
        listaAppartamenti.add(appartamento4);
        listaAppartamenti.add(appartamento5);
        listaAppartamenti.add(appartamento6);

        // Creazione degli impianti
        LinkedList<String> tecnici1 = new LinkedList<>();
        tecnici1.add("Verdi");
        tecnici1.add("Bianchi");
        Impianto impianto1 = new Impianto("A1", 120, 10, "fotovoltaico", tecnici1);

        LinkedList<String> tecnici2 = new LinkedList<>();
        tecnici2.add("Verdi");
        tecnici2.add("Rossi");
        Impianto impianto2 = new Impianto("A1", 100, 20, "solare termico", tecnici2);

        LinkedList<String> tecnici3 = new LinkedList<>();
        tecnici3.add("Rossi");
        tecnici3.add("Bianchi");
        Impianto impianto3 = new Impianto("A2", 120, 30, "solare termico", tecnici3);

        LinkedList<String> tecnici4 = new LinkedList<>();
        tecnici4.add("Verdi");
        tecnici4.add("Rossi");
        Impianto impianto4 = new Impianto("A3", 100, 15, "fotovoltaico", tecnici4);

        LinkedList<String> tecnici5 = new LinkedList<>();
        tecnici5.add("Verdi");
        Impianto impianto5 = new Impianto("A4", 120, 20, "fotovoltaico", tecnici5);

        LinkedList<String> tecnici6 = new LinkedList<>();
        tecnici6.add("Bianchi");
        Impianto impianto6 = new Impianto("A5", 100, 25, "fotovoltaico", tecnici6);

        LinkedList<String> tecnici7 = new LinkedList<>();
        tecnici7.add("Rossi");
        tecnici7.add("Bianchi");
        Impianto impianto7 = new Impianto("A6", 110, 35, "solare termico", tecnici7);

        LinkedList<Impianto> listaImpianti = new LinkedList<>();
        listaImpianti.add(impianto1);
        listaImpianti.add(impianto2);
        listaImpianti.add(impianto3);
        listaImpianti.add(impianto4);
        listaImpianti.add(impianto5);
        listaImpianti.add(impianto6);
        listaImpianti.add(impianto7);

        // Creazione del sistema con gli appartamenti e gli impianti
        Sistema sistema = new Sistema(listaAppartamenti, listaImpianti);

        // Esempio di chiamate ai metodi
        LinkedList<String> scale = sistema.scaleUnicoTipo();
        System.out.println("Scale con unico tipo di impianto: " + scale);

        String tecnico = sistema.tecnicoMax();
        System.out.println("Tecnico con massimo incasso: " + tecnico);

        String scalaSimile = sistema.scalaSimile("S1", 10, 20);
        System.out.println("Scala simile a S1 tra 10 e 20: " + scalaSimile);
    }
}
