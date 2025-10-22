package traccia20230215;

import java.util.*;

import terminale.Terminale;

public class Sistema {

    private List<Opera> listaOpere;
    private List<Vendita> listaVendite;

    public Sistema(List<Opera> listaOpere, List<Vendita> listaVendite) {
        this.listaOpere = listaOpere;
        this.listaVendite = listaVendite;
    }

    public LinkedList<String> acquirentiSimili(String nomeAcquirente) 
    {
        LinkedList<String> ret = new LinkedList<>();
        LinkedList<String> autoriOpereNomeAcquirente = trovaAutoreOperaNomeAcquirente(nomeAcquirente);
        LinkedList<String> offerenti = estraiOfferenti(); 
        LinkedList<String> autoriOpereS;

        for ( String s : offerenti )

            if ( s == nomeAcquirente ){

                autoriOpereS = trovaAutoreOperaNomeAcquirente(s);
                if ( !autoriOpereS.isEmpty() )      // cosi mi evito qualche iterazione a vuoto

                    for ( String a : autoriOpereNomeAcquirente )
                        for ( String b : autoriOpereS )
                                if ( a == b && !ret.contains(s))
                                    ret.add(s);
            }

        return ret; 
    }

    private LinkedList<String> trovaAutoreOperaNomeAcquirente(String nomeAcquirente)
    {
        LinkedList<String> ret = new LinkedList<>(); 

        for ( Vendita v : listaVendite )
            if ( v.getOfferenti().getLast().equals(nomeAcquirente) )
                ret.add(trovaOpera(v.getOpera()).getAutore());

        return ret; 
    }

    private Opera trovaOpera(String nome)
    {
        for ( Opera o : listaOpere )
            if ( o.getNome().equals(nome) )
                return o;
        return null;
    }

    private LinkedList<String> estraiOfferenti() 
    {
        LinkedList<String> ret = new LinkedList<>();

        for ( Vendita v : listaVendite )
            for ( String o : v.getOfferenti() )
                if ( !ret.contains(o) )
                    ret.add(o);

        return ret; 
    }

    public int maxRilancio ( String autore )
    {
        int rilancioMax = 0;
        int rilancioCorr = 0;
        int previous;
        int current;
        

        for ( Vendita v : listaVendite )
            if ( trovaAutore(v.getOpera()).equals(autore) ){                // se l'opera è stata fatta dall'autore
                ListIterator<Integer> lio = v.getOfferte().listIterator();

                previous = lio.next();

                while ( lio.hasNext() ){
                    current = lio.next();
                    rilancioCorr = current - previous;

                    if ( rilancioCorr > rilancioMax )
                        rilancioMax = rilancioCorr;

                    previous = current;
                }
            }

        return rilancioMax;
    }

    private String trovaAutore ( String nomeOpera )
    {
        for ( Opera o : listaOpere )
            if ( nomeOpera.equals(o.getNome()) )
                return o.getAutore(); 
        return null;
    }

    public static void main(String[] args) {
        // Creazione delle opere d'arte
        Opera opera1 = new Opera("Il sole", "Mutandari", 2000);
        Opera opera2 = new Opera("La luna", "Fragolari", 2001);
        Opera opera3 = new Opera("Inquietudine", "Fragolari", 2001);

        // Aggiunta delle opere alla lista delle opere
        List<Opera> listaOpere = new ArrayList<>();
        listaOpere.add(opera1);
        listaOpere.add(opera2);
        listaOpere.add(opera3);

        // Creazione delle vendite
        LinkedList<Integer> offerte1 = new LinkedList<>(Arrays.asList(1000, 1100, 1200));
        LinkedList<String> offerenti1 = new LinkedList<>(Arrays.asList("Lino", "Anna", "Lino"));
        Vendita vendita1 = new Vendita("V1", "Il sole", offerte1, offerenti1);

        LinkedList<Integer> offerte2 = new LinkedList<>(Arrays.asList(600, 1100, 1300, 1350, 1400));
        LinkedList<String> offerenti2 = new LinkedList<>(Arrays.asList("Lino", "Anna", "Lino", "Giorgia", "Lino"));
        Vendita vendita2 = new Vendita("V2", "La luna", offerte2, offerenti2);

        LinkedList<Integer> offerte3 = new LinkedList<>(Arrays.asList(800));
        LinkedList<String> offerenti3 = new LinkedList<>(Collections.singletonList("Giorgia"));
        Vendita vendita3 = new Vendita("V3", "Inquietudine", offerte3, offerenti3);

        // Aggiunta delle vendite alla lista delle vendite
        List<Vendita> listaVendite = new ArrayList<>();
        listaVendite.add(vendita1);
        listaVendite.add(vendita2);
        listaVendite.add(vendita3);

        // Creazione del sistema
        Sistema sistema = new Sistema(listaOpere, listaVendite);

        // Test dei metodi
        //System.out.println("Test consistente(4): " + sistema.consistente(4)); // true
        //System.out.println("Test consistente(2): " + sistema.consistente(2)); // false

        //System.out.println("Test acquirentiSimili('Lino'): " + sistema.acquirentiSimili("Lino")); // [Giorgia]
        //System.out.println("Test acquirentiSimili('Giorgia'): " + sistema.acquirentiSimili("Giorgia")); // [Lino]

        System.out.println("Test maxRilancio('Fragolari'): " + sistema.maxRilancio("Fragolari")); // 500
        //System.out.println("Test maxRilancio('Mutandari'): " + sistema.maxRilancio("Mutandari")); // 100
    }
}

