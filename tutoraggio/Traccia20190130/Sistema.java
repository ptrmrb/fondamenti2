package traccia20190130;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
    private ArrayList<Autore> autori;
    private ArrayList<Pubblicazione> pubblicazioni;

    public Sistema(ArrayList<Autore> autori, ArrayList<Pubblicazione> pubblicazioni) {
        this.autori = autori;
        this.pubblicazioni = pubblicazioni;
    }

    /**
     *
     * @param s
     * @return la lista dei codici delle pubblicazioni redatte solo da autori residenti nella città s.
     */
    public ArrayList<String> pubblicazioniCittà(String s){
        ArrayList<String> ret = new ArrayList<>();
        for(Pubblicazione p: pubblicazioni)
            if(soloCitta(p, s))
                ret.add(p.getCodice());
        return ret;
    }

    private boolean soloCitta(Pubblicazione p, String s) {
        for(String a: p.getAutori())
            if(!autori.get(autori.indexOf(new Autore(a, ""))).getCitta().equals(s))
                return false;
        return true;
    }

    /**
     *
     * @param d1
     * @param d2
     * @return la lista degli autori di pubblicazioni a singolo nome nel periodo compreso tra la data d1 e la data d2.
     */
    public ArrayList<Autore> individuali(int d1, int d2){
        ArrayList<Autore> ret = new ArrayList<>();
        for(Pubblicazione p : pubblicazioni)
            if(p.getData() >= d1 && p.getData() <= d2 && p.getAutori().size()==1)
                ret.add(autori.get(autori.indexOf(new Autore(p.getAutori().get(0), ""))));
        return ret;
    }

    /**
     *
     * @param a
     * @param b
     * @return la lista delle pubblicazioni scritte congiuntamente dagli autori a e b
     * (eventualmente insieme ad altri), ordinata secondo la data di pubblicazione dei lavori.
     */
    public ArrayList<Pubblicazione> coautori(Autore a, Autore b){
        ArrayList<Pubblicazione> ret = new ArrayList<>();
        for(Pubblicazione p: pubblicazioni)
            if(p.getAutori().containsAll(List.of(a.getNome(), b.getNome()))) {
                int i = 0;
                for(; i < ret.size(); i++)
                    if(ret.get(i).getData()>p.getData())
                        break;
                ret.add(i, p);
            }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Autore> autori = new ArrayList<>();
        autori.add(new Autore("Rossi", "Roma"));
        Autore a2 = new Autore("Bianchi", "Torino");
        autori.add(a2);
        autori.add(new Autore("Verdi", "Cosenza"));
        Autore a4 = new Autore("Neri", "Cosenza");
        autori.add(a4);
        autori.add(new Autore("Marroni", "Milano"));
        autori.add(new Autore("Gialli", "Milano"));

        ArrayList<Pubblicazione> pubblicazioni = new ArrayList<>();
        pubblicazioni.add(new Pubblicazione("pub1", "Titolo di p1",  new ArrayList<>(List.of("Rossi", "Bianchi", "Neri")), new ArrayList<>(List.of("kw1", "kw2")), 1));
        pubblicazioni.add(new Pubblicazione("pub2", "Titolo di p2",  new ArrayList<>(List.of("Bianchi", "Neri")), new ArrayList<>(List.of("kw3", "kw4")), 2));
        pubblicazioni.add(new Pubblicazione("pub3", "Titolo di p3",  new ArrayList<>(List.of("Gialli", "Marroni")), new ArrayList<>(List.of("kw1", "kw3")), 2));
        pubblicazioni.add(new Pubblicazione("pub4", "Titolo di p4",  new ArrayList<>(List.of("Gialli")), new ArrayList<>(List.of("kw1", "kw2", "kw4")), 2));
        pubblicazioni.add(new Pubblicazione("pub5", "Titolo di p5",  new ArrayList<>(List.of("Neri", "Verdi")), new ArrayList<>(List.of("kw3", "kw5")), 1));
        pubblicazioni.add(new Pubblicazione("pub6", "Titolo di p6",  new ArrayList<>(List.of("Bianchi")), new ArrayList<>(List.of("kw6")), 1));
        pubblicazioni.add(new Pubblicazione("pub7", "Titolo di p7",  new ArrayList<>(List.of("Gialli", "Rossi", "Bianchi", "Neri")), new ArrayList<>(List.of("kw1", "kw6")), 2));
        pubblicazioni.add(new Pubblicazione("pub8", "Titolo di p8",  new ArrayList<>(List.of("Verdi")), new ArrayList<>(List.of("kw2", "kw5")), 3));

        Sistema s = new Sistema(autori, pubblicazioni);
        System.out.println(s.pubblicazioniCittà("Milano")); //["pub3", "pub4"].
        System.out.println(s.individuali(2, 3)); //[a3, a6].
        System.out.println(s.coautori(a2, a4)); //[p1, p2, p7].
    }

}
