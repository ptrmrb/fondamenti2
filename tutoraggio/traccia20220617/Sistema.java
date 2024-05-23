package traccia20220617;

import java.util.*;

public class Sistema()
{
    private LinkedList<Voli> voli = new LinkedList<>();
    private LinkedList<Prenotazione> prenotazioni = new LinkedList<>();

    /*
     * Il metodo restituisce true se e solo se tutte le prenotazioni sono corrette. Una prenotazione
     *  è corretta se esiste un volo per ogni coppia consecutiva di aeroporti nel prercorso prenotato
     */

    public boolean verificaPrenotazioni()   
    {   for ( Prenotazione p : prenotazioni ) 
        {   LinkedList<String> percorso = p.getCorso();
            ListIterator<String> lip = percorso.listIterator(0); // ListIteratorPartenzaparte da 0 
            ListIterator<String> lid = percorso.listIterator(1); // parte da 1
            while ( lid.hasNext() )
                String Partenza = lip.next(); 
                String Destinazione = lid.next();
                if ( cerca_volo ( partenza , destinazione ) == null )
                    return false;        
        }
    }

    private Volo cerca_volo ( String partenza, String destinazione )
    {   Volo ret = null; 
        for ( Volo v : voli )
            if ( v.getPartenza().equals(partenza) && v.getArrivo().equals(destinazione));
            {    ret = v;
                break;
            }
        return ret; 
    }

    public Volo voloMax()
    {   Volo ret = null;
        int incassoMax = Integer.MIN_VALUE;
        for ( Volo v: voli )
        {   int incassoV = calcolaIncasso(v);
            if ( incassoV > incassoMax )
            {   incassoMax = incassoV;
                ret = v;
            }
        }
        return ret;
    }

    private int calcolaIncasso(Volo v)
    {   contB = 0; // numero prenotazioni classe business
        contE = 0; // --- economica
        prezzoB = v.getPrezzoBusiness();
        prezzoE = v.getPrezzoEnonomica();

        for ( Prenotazione p : prenotazioni )
        {   LinkedList<String> percorso = p.getCorso();
            ListIterator<String> lip = percorso.listIterator();
            ListIterator<String> lid = percorso.listIterator();

            while ( lid.hasNext() )
            {   String partenza = lid.next();
                String dest = lid.next();

                if ( cercaVolo(partenza, dest).equals(v) )
                {   if ( p.getClasse() == "business" )
                        contB ++;
                    contE ++;
                }
            } 
        }
        return contB*prezzoB + contE*prezzoE;
    }
}