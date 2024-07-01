package traccia20190218;

import java.util.*;

public class Sistema {
    private ArrayList<Cliente> clienti;
    private ArrayList<Articolo> articoli;

    public Sistema(ArrayList<Cliente> clienti, ArrayList<Articolo> articoli) {
        this.clienti = clienti;
        this.articoli = articoli;
    }

    /**
     *
     * @param c
     * @return  la lista dei codici degli articoli acquistati da tutti i clienti residenti nella città c.
     */
    public ArrayList<String> articoliCittà(String c){
        ArrayList<String> ret = new ArrayList<>();
        ArrayList<Cliente> clientiCitta = clientiCitta(c);
        for(Articolo art : articoli)
            if(art.getClienti().containsAll(clientiCitta))
                ret .add(art.getCodice());
        return ret ;
    }

    public ArrayList<Cliente> clientiCitta(String c){
        ArrayList<Cliente> ret = new ArrayList<>();
        for(Cliente cli: clienti)
            if(cli.getCitta().equals(c))
                ret.add(cli);
        return ret;
    }

    /**
     *
     * @param d1
     * @param d2
     * @return la lista dei clienti che hanno la caratteristica di essere
     * gli unici acquirenti di almeno un articolo
     * messo in vendita nel periodo compreso tra la data d1 e la data d2.
     */
    public ArrayList<Cliente> acquirentiUnici(int d1, int d2){
        ArrayList<Cliente> ret = new ArrayList<>();
        for(Articolo a: articoli)
            if(a.getData() >= d1 && a.getData() <=d2 && a.getClienti().size()==1 
                && !ret.contains(a.getClienti().get(0)))
                ret.add(a.getClienti().get(0));
        return ret;
    }

    /**
     *
     * @param a
     * @param b
     * @return la lista degli acquisti effettuati sia dal cliente a che dal cliente b 
     * (eventualmente insieme ad altri), ordinata (in senso decrescente) secondo la data
     * di messa in vendita degli articoli.
     * 
     **/
    public ArrayList<Articolo> acquirentiComuni(Cliente a, Cliente b){
        ArrayList<Articolo> ret = new ArrayList<>();
        for (Articolo art : articoli) 
            if (art.getClienti().contains(a) && art.getClienti().contains(b))
                ret.add(art);
        
            Collections.reverse(ret);
    	return ret;
    }


    public static void main(String[] args) {

        Cliente c1 = new Cliente("Rossi", "Cosenza");
        Cliente c2 = new Cliente("Bianchi", "Torino");
        Cliente c3 = new Cliente("Verdi", "Cosenza");
        Cliente c4 = new Cliente("Neri", "Roma");
        Cliente c5 = new Cliente("Marroni", "Milano");
        Cliente c6 = new Cliente("Gialli", "Milano");
        ArrayList<Cliente> clienti = new ArrayList<>(List.of(c1, c2, c3, c4, c5, c6));

        ArrayList<Articolo> articoli = new ArrayList<>();
        articoli.add(new Articolo("art1",new ArrayList<>(List.of(c1, c2, c3, c4, c6)), 1));
        articoli.add(new Articolo("art2",new ArrayList<>(List.of(c1, c3)), 2));
        articoli.add(new Articolo("art3",new ArrayList<>(List.of(c2, c3, c4)), 2));
        articoli.add(new Articolo("art4",new ArrayList<>(List.of(c5)), 3));
        articoli.add(new Articolo("art5",new ArrayList<>(List.of(c2, c4, c5)), 3));
        articoli.add(new Articolo("art6",new ArrayList<>(List.of(c1, c4)), 4));
        articoli.add(new Articolo("art7",new ArrayList<>(List.of(c3, c5, c6)), 4));
        articoli.add(new Articolo("art8",new ArrayList<>(List.of(c6)), 5));

        Sistema s = new Sistema(clienti, articoli);

        System.out.println(s.articoliCittà("Cosenza")); //["a1", "a2"]
        System.out.println(s.acquirentiUnici(2, 3));    //[c5]
        System.out.println(s.acquirentiComuni(c3, c6)); //[a7, a1]
    }
}
