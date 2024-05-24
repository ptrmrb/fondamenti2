package traccia20220711;

import java.util.*;
import terminale.*;

public class Sistema {
    private LinkedList<Merce> merci;
    private LinkedList<Ordine> ordini;

    public Sistema(ArrayList<Merce> merci, ArrayList<Ordine> ordini) {
        this.merci = new LinkedList<>(merci);
        this.ordini = new LinkedList<>(ordini);
    }

    /**
     *
     * @return  true se e solo se:
     * a.per ogni merce, il numero di fornitori è uguale al numero di prezzi di fornitura e
     * la marca non fa parte della lista dei suoi fornitori;
     * b.per ogni ordine, la merce indicata fa parte della lista delle merci e il fornitore al quale
     * l’ordine è indirizzato è riportato nella lista dei fornitori della merce.
     */
    public boolean verificaMerciEOrdini(){

        LinkedList<String> nomiMerci = new LinkedList<>(estraiMerci());

        for ( Merce m : merci )
            if (  m.getListaFornitori().size() != m.getListaPrezzi().size()
                || ( m.getListaFornitori().contains(m.getMarca())) )
                return false;
        
        for ( Ordine o : ordini )
            if  ( !nomiMerci.contains( o.getMerce() ) || 
                 !secondaVerificaPunto2( o.getFornitore(), o.getMerce()) )
                return false;

        return true; 
    }

    private LinkedList<String> estraiMerci()
    {
        LinkedList<String> ret = new LinkedList<>();
        for ( Merce m : merci )
            ret.add(m.getNome());
        return ret; 
    }

    private boolean secondaVerificaPunto2(String fornitore, String merce)
    {
        for ( Merce m : merci )
            if ( m.getNome().equals( merce ) )  
                if ( m.getListaFornitori().contains( fornitore ))
                    return true;
        return false; 
    }

    /**
     *
     * @param sogliaMinimo
     * @param sogliaMedio
     * @return la lista dei nomi delle merci fornite da almeno un fornitore e il cui prezzo minimo di fornitura supera
     * strettamente il valore sogliaMinimo e il prezzo medio di fornitura supera strettamente il valore sogliaMedio
     * (si restituisca una valore null se verificaMerciEOrdini() restituisce false).
     */

    public LinkedList<String> merciSopraSoglia(float sogliaMinimo, float sogliaMedio){

        LinkedList<String> ret = new LinkedList<>();

        if ( !verificaMerciEOrdini() )
            return null;

        for ( Merce m : merci ){

            if ( !m.getListaFornitori().isEmpty() )
            {
                LinkedList<Float> prezzi = m.getListaPrezzi();
                float minimo = trovaMinimo(prezzi); // TODO
                float medio = calcolaMedia(prezzi); // TODO
                if ( minimo > sogliaMinimo && medio > sogliaMedio )
                    ret.add(m.getNome());
            }
        }
        return ret; 
    }

    private float trovaMinimo(LinkedList<Float> lista)
    {
        ListIterator<Float> lil = lista.listIterator();
        float minimo = lil.next();

        while ( lil.hasNext() )
        {
            float corrente = lil.next();
            if ( corrente < minimo )
                minimo = corrente;
        }
        return minimo;
    } 

    public float calcolaMedia(LinkedList<Float> lista)
    {
        float somma = 0;
        int valori = 0;
 
        ListIterator<Float> lim = lista.listIterator();
        
        while ( lim.hasNext() )
        {
            somma += lim.next();
            valori += 1;            
        }
        return somma / valori;
    }
    
    /**
     *
     * @param d1
     * @param d2
     * @return restituisce la lista delle marche delle merci presenti negli ordini che,
     * tra gli ordini effettuati tra la data d1 e la data d2 (incluse), hanno importo massimo.
     * L’importo di un ordine è dato dal prodotto della quantità di merce ordinata per il prezzo al quale il fornitore
     * indicato fornisce la merce (si restituisca una valore null se verificaMerciEOrdini() restituisce false).
     * La lista restituita deve contenere una stessa marca al più una volta.
     */
    public LinkedList<String> marcheOrdiniMassimi(int d1, int d2){

        if ( !verificaMerciEOrdini() ) return null; 

        LinkedList<String> ret = new LinkedList<>();
        Float importoMassimo = 0f; 
        
        for ( Ordine o : ordini ){

            Terminale.stampa("massimo "+ importoMassimo);

            float importoOrdine = 0f; 

            if ( o.getData() >= d1 && o.getData() <= d2 ) // trovo la data corretta
            { 
                for ( Merce m : merci ) // scorro le merci alla ricerca di quella contenuta nell'ordine 
                {
                    if ( m.getNome().equals(o.getMerce()) ) // trovo la merce fornita nell'ordine
                    {  
                        importoOrdine = o.getQuantita() * prezzoFornitore(o.getFornitore(), m); // calcolo l'importo dell'ordine
                        
                        Terminale.stampa("corrente " + importoOrdine);

                        if ( importoOrdine != importoMassimo ) // se sono diversi 
                        {
                            if ( importoOrdine > importoMassimo ) // se è maggiore pulisci la lista delle marche massime e aggiungi la nuova massima
                            {
                                importoMassimo = importoOrdine;
                                ret.clear();
                                ret.add(m.getMarca());
                                break;
                            }
                            else // se è minore non fai niente
                                break;        
                        }
                        else // se sono uguali e non è già nella lista, aggiungi la marca
                        {
                            if ( !ret.contains(m.getMarca()) ){
                                ret.add(m.getMarca());
                                break;
                            }
                        }
                    }
                }   
            }
        }

        Terminale.stampa("massimo finale "+ importoMassimo);
        return ret;
    }

    private float prezzoFornitore( String fornitore, Merce m)
    {
        Float ret = 0f;

        LinkedList<String> fornitori = m.getListaFornitori(); // lista dei fornitori
        ListIterator<String> lif = fornitori.listIterator();
        LinkedList<Float> prezzi = m.getListaPrezzi();  // lista dei prezzi dei fornitori
        ListIterator<Float> lip = prezzi.listIterator(); 

        while ( lif.hasNext() ){
            String fornitoreCorr = lif.next();
            Float prezzoCorr = lip.next();
            
            if ( fornitoreCorr == fornitore )
            {
                ret = prezzoCorr; 
                return ret;
            }
        } 
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Merce> merci = new ArrayList<>();
        merci.add(new Merce("M1",  "X", new LinkedList<>(List.of("F1", "F2")), new LinkedList<>(List.of (1.1f, 1.3f))));
        merci.add(new Merce("M2",  "Y", new LinkedList<>(List.of("F1")), new LinkedList<>(List.of (2f))));
        merci.add(new Merce("M3",  "X", new LinkedList<>(List.of("F1", "F2")), new LinkedList<>(List.of (1.4f, 2f))));

        ArrayList<Ordine> ordini = new ArrayList<>();
        ordini.add(new Ordine("ORD1",  "M1", 10, "F1", 66));
        ordini.add(new Ordine("ORD2", "M3", 5, "F1", 100));
        ordini.add(new Ordine("ORD3", "M3", 8, "F2", 70));

        Sistema s = new Sistema(merci, ordini);
        
        Terminale.stampa(" ");
        //System.out.println(s.verificaMerciEOrdini());// restituisce true. Avrebbe restituito false, ad esempio, se la lista di fornitori di M1 fosse stata ["F1","F2","F3"] e quella dei prezzi [1.1, 1.3], o se la lista di fornitori di M2 avesse contenuto Y (ossia, la marca di M2), o se l’ordine ORD1 avesse riguardato la merce M4 (non presente nella lista delle merci), o se nell’ordine ORD1 fosse stato specificato il fornitore F3, che non fa parte dei fornitori di M1.
        //System.out.println(s.merciSopraSoglia(1.3f, 1.5f)); //restituisce la lista [“M2”, “M3”] perchè M2 ha come prezzi minimo e medio di fornitura il valore 2 (che è strettamente maggiore sia si 1.3 che di 1.5), ed M3 ha come prezzo minimo di fornitura il valore 1.4, che è maggiore di 1.3, e prezzo medio 1.7 (dato da (1.4+2)/2), che è maggiore di 1.5. La merce M1 non soddisfa invece nè il requisito sul prezzo minimo che sul prezzo medio.
        System.out.println(s.marcheOrdiniMassimi(50,80) );//restituisce la lista ["X"] perché è la marca della merce associata all’unico ordine di importo massimo. Gli unici ordini che ricadono nella finestra temporale [50..80] sono ORD1 e ORD3, e l’importo di ORD1 è 1.1×10=11 mentre quello di ORD3 è 8×2=16.
        

        //LinkedList<Float> list = new LinkedList<>(Arrays.asList(1.1f, 2.2f, 3.3f, 5.5f));
        //Terminale.stampa(s.calcolaMedia(list));
    }
}
