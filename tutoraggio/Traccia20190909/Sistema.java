package traccia20190909;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private ArrayList<Parlamentare> parlamentari;
    private ArrayList<DisegnoDiLegge> ddl;
    private ArrayList<Votazione> votazioni;

    public Sistema(ArrayList<Parlamentare> parlamentari, ArrayList<DisegnoDiLegge> ddl, ArrayList<Votazione> votazioni) {
        this.parlamentari = parlamentari;
        this.ddl = ddl;
        this.votazioni = votazioni;
    }

    /**
     *
     * @param r
     * @return  i disegni di legge approvati soltanto con voti favorevoli espressi 
     *          da parlamentari eletti in collegi
     *          della regione r.
     */
    public ArrayList<DisegnoDiLegge> m1(String r){
        return null;
    }

    /**
     *
     * @param p
     * @return  l’elenco dei parlamentari del partito politico p che hanno 
     *          espresso voto contrario su qualche disegno
     *          di legge proposto da almeno un parlamentare dello stesso partito p.
     */
    public ArrayList<Parlamentare> m2(String p){
        return null;
    }

    /**
     *
     * @param p
     * @return  l’elenco dei parlamentari che hanno espresso 
     *          lo stesso voto di p per
     *          ogni disegno di legge.
     */
    public ArrayList<Parlamentare> m3(Parlamentare p){
        return null;
    }

    public static void main(String[] args) {

        ArrayList<Parlamentare> parlamentari= new ArrayList<>();
        parlamentari.add(new Parlamentare("RSS", "Calabria", "partito1"));
        parlamentari.add(new Parlamentare("BNC", "Lombardia", "partito2"));
        Parlamentare g = new Parlamentare("GIA", "Lombardia", "partito2");
        parlamentari.add(g);
        parlamentari.add(new Parlamentare("VRD", "Calabria", "partito3"));
        parlamentari.add(new Parlamentare("MAR", "Calabria", "partito1"));

        ArrayList<DisegnoDiLegge> ddl= new ArrayList<>();
        ddl.add(new DisegnoDiLegge(1, "DDL1", new ArrayList<>(List.of("RSS", "BNC", "MAR")), 1, true));
        ddl.add(new DisegnoDiLegge(2, "DDL2", new ArrayList<>(List.of("VRD", "MAR")), 2, false));
        DisegnoDiLegge ddl3 = new DisegnoDiLegge(3, "DDL3", new ArrayList<>(List.of("BNC", "GIA", "VRD")), 3, true);
        ddl.add(ddl3);

        ArrayList<Votazione> votazioni= new ArrayList<>();
        votazioni.add(new Votazione(1, "RSS", 1, true));
        votazioni.add(new Votazione(2, "BNC", 1, false));
        votazioni.add(new Votazione(3, "MAR", 1, true));
        votazioni.add(new Votazione(4, "VRD", 1, true));
        votazioni.add(new Votazione(5, "GIA", 1, false));
        votazioni.add(new Votazione(6, "RSS", 2, false));
        votazioni.add(new Votazione(7, "BNC", 2, false));
        votazioni.add(new Votazione(8, "MAR", 2, true));
        votazioni.add(new Votazione(9, " VRD", 2, true));
        votazioni.add(new Votazione(10, "GIA", 2, false));
        votazioni.add(new Votazione(11, "RSS", 3, false));
        votazioni.add(new Votazione(12, "BNC", 3, true));
        votazioni.add(new Votazione(13, "MAR", 3, false));
        votazioni.add(new Votazione(14, "VRD", 3, true));
        votazioni.add(new Votazione(15, "GIA", 3, true));

        Sistema s = new Sistema(parlamentari, ddl, votazioni);
        System.out.println(s.m1("Calabria")); //[ddl1]
        System.out.println(s.m2("partito1")); //[p1]
        System.out.println(s.m3(g)); //["BNC"]
    }
}
