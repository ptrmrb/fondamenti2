package traccia20230628;

import java.util.*;
import terminale.*;


class Sistema {
    private List<Pilota> listaPiloti;
    private List<Scuderia> listaScuderie;
    private List<Gara> listaGare;

    public Sistema() {
        listaPiloti = new LinkedList<>();
        listaScuderie = new LinkedList<>();
        listaGare = new LinkedList<>();
    }

    // Metodo per aggiungere un pilota
    public void aggiungiPilota(Pilota p) {
        listaPiloti.add(p);
    }

    // Metodo per aggiungere una scuderia
    public void aggiungiScuderia(Scuderia s) {
        listaScuderie.add(s);
    }

    // Metodo per aggiungere una gara
    public void aggiungiGara(Gara g) {
        listaGare.add(g);
    }

    public boolean verificaCittaPilota(String  c, String p)
    {   
        LinkedList<String> scuderieCitta = new LinkedList<>();

        for (Scuderia s: listaScuderie )
            if ( s.getCitta().equals(c) )
                scuderieCitta.add(s.getNome());
        
        for (Gara g: listaGare)
        {
            ListIterator<String> lip = g.getPiloti().listIterator();
			ListIterator<String> lis = g.getScuderie().listIterator();

            while ( lip.hasNext() )
            {
                String pilota = lip.next();
                String scuderiaCorr = lis.next();

                if ( pilota == p && scuderieCitta.contains(scuderiaCorr) ){
                    Terminale.stampa(g.getID());
                    return false;
                }
            }
        }
        return true; 
    }

    public int numeroPiloti(String c1, String c2)
    {
        LinkedList<String> pilotiPrescelti = new LinkedList<>();
        for ( Gara g : listaGare )
        {
            if ( g.getLuogo().equals(c1) )
            {
                ListIterator<String> lip = g.getPiloti().listIterator();
			    ListIterator<String> lis = g.getScuderie().listIterator();

                while ( lis.hasNext() )
                {
                    String pilota = lip.next();
                    String scuderia = lis.next();

                    if (!pilotiPrescelti.contains(pilota) && trovaScuderia(scuderia).getCitta().equals(c2))
                        pilotiPrescelti.add(pilota);
                }
            }
        }
        return pilotiPrescelti.size();
    }

    private Scuderia trovaScuderia(String scuderia)
    {
        for (Scuderia s : listaScuderie)
            if (s.getNome().equals(scuderia))
                return s;
        return null; 
    }

    public float compensoTotaleScuderia(String s)
    {   
        float ret = 0; 
        float compensoExtraVincitore = 0; 

        for ( Gara g : listaGare )
        {
            ListIterator<String> lip = g.getPiloti().listIterator();
            ListIterator<String> lis = g.getScuderie().listIterator();

            if ( g.getScuderie().getFirst().equals(s) ){    // solo se la scuderia è arrivata prima bisogna calcolare l'extra
                compensoExtraVincitore = trovaScuderia(g.getScuderie().getFirst()).getCompensoExtra();
                ret += compensoExtraVincitore;
            }
            
            while ( lip.hasNext() )
            {
                String pilota = lip.next();
                String scuderiaCorr = lis.next();

                if ( scuderiaCorr.equals(s) )
                    ret += trovaPilota(pilota).getCompensoPerGara();
            }
        }
        return ret;
    }


    private Pilota trovaPilota (String pilota)
    {
        for ( Pilota p : listaPiloti )
            if ( p.getNome().equals(pilota) )
                return p;
        return null;
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Creazione e aggiunta dei piloti
        Pilota anna = new Pilota("Anna", 20, 100.0f);
        Pilota gino = new Pilota("Gino", 20, 150.0f);
        Pilota renata = new Pilota("Renata", 21, 200.0f);

        sistema.aggiungiPilota(anna);
        sistema.aggiungiPilota(gino);
        sistema.aggiungiPilota(renata);

        // Creazione e aggiunta delle scuderie
        Scuderia ferrari = new Scuderia("Ferrari", "Bologna", 10.0f);
        Scuderia lamborghini = new Scuderia("Lamborghini", "Bologna", 15.0f);
        Scuderia mercedes = new Scuderia("Mercedes", "Firenze", 12.0f);

        sistema.aggiungiScuderia(ferrari);
        sistema.aggiungiScuderia(lamborghini);
        sistema.aggiungiScuderia(mercedes);

        // Creazione e aggiunta delle gare
        LinkedList<String> pilotiG1 = new LinkedList<>();
        pilotiG1.add("Anna");
        pilotiG1.add("Renata");
        LinkedList<String> scuderieG1 = new LinkedList<>();
        scuderieG1.add("Ferrari");
        scuderieG1.add("Mercedes");
        Gara gara1 = new Gara("G1", "Milano", pilotiG1, scuderieG1);
        sistema.aggiungiGara(gara1);

        LinkedList<String> pilotiG2 = new LinkedList<>();
        pilotiG2.add("Gino");
        pilotiG2.add("Renata");
        LinkedList<String> scuderieG2 = new LinkedList<>();
        scuderieG2.add("Lamborghini");
        scuderieG2.add("Lamborghini");
        Gara gara2 = new Gara("G2", "Cosenza", pilotiG2, scuderieG2);
        sistema.aggiungiGara(gara2);

        LinkedList<String> pilotiG3 = new LinkedList<>();
        pilotiG3.add("Anna");
        pilotiG3.add("Gino");
        LinkedList<String> scuderieG3 = new LinkedList<>();
        scuderieG3.add("Ferrari");
        scuderieG3.add("Lamborghini");
        Gara gara3 = new Gara("G3", "Roma", pilotiG3, scuderieG3);
        sistema.aggiungiGara(gara3);

        LinkedList<String> pilotiG4 = new LinkedList<>();
        pilotiG4.add("Renata");
        pilotiG4.add("Gino");
        pilotiG4.add("Anna");
        LinkedList<String> scuderieG4 = new LinkedList<>();
        scuderieG4.add("Ferrari");
        scuderieG4.add("Lamborghini");
        scuderieG4.add("Mercedes");
        Gara gara4 = new Gara("G4", "Milano", pilotiG4, scuderieG4);
        sistema.aggiungiGara(gara4);

        // Esempi di utilizzo dei metodi della classe Sistema
        System.out.println(sistema.verificaCittaPilota("Bologna", "Anna"));
        //System.out.println(sistema.numeroPiloti("Milano", "Bologna"));
        //System.out.println(sistema.compensoTotaleScuderia("Mercedes"));
    }
}
