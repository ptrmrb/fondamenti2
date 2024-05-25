package traccia280623; 

import java.util.*;

public class Sistema(){

    // definiamo le liste con cui andremo a lavorare
    private LikedList<Pilota> piloti;
    private LinkedList<Scuderia> squderie;
    private LinkedList<Gara> gare;     

    // costruttore copia deep...

    // true sse p MAI gare con scuderia di citta c 
    public boolean verificaCittaPilota(String c, String p){

        for ( Gara g : gare )
        {
            LinkedList<String> pilotiG = g.getPiloti(); // piloti gara
            ListIterator<String> lip = pilotiG.listIterator();
            LinkedList<String> scuderieG = g.getScuderie(); // scuderie gara
            ListIterator<String> lis = scuderieG.listIterator();

            while ( lip.hasNext() ) // dato che le liste ganno la stessa lunghezza 
            {
                String pil = lip.next(); // prendiamo il pilota
                String sc = lis.next(); // prendiamo la scuderia
                // il pilota è il pilota che ci interessa ? 

                if ( pil.equals(p) )
                {
                    Scuderia scuderia = trovaScuderia(sc); //  dato il nome della scuderia mi prendo l'oggetto scuderia

                    if ( scuderia.getCitta().equals(c) )
                    {
                        return false;
                    }
                    break;
                }

            }
        }
        return true;
    }

    private Scuderia trovaScuderia(String s)
    {
        for ( Scuderia sc : scuderie )
            if ( sc.getNome().equals(s) )
                return sc;
        return null;
    }

    // num piloti diversi che hanno partecipato a una gara in citta c1 per conto
    // di una scuderia con sede nella citta c2

    public int numeroPiloti( String c1, String c2 )
    {
        int ret = 0; 
        for ( Pilota p: piloti )
        {   
            booalean trovato = false;
            for ( Gara g : gare )
            {   
                if ( !trovato &&  g.getLuogo().equals(c1) )
                {
                    LinkedList<String> pilotiG = g.getPiloti(); // piloti gara
                    ListIterator<String> lip = pilotiG.listIterator();
                    LinkedList<String> scuderieG = g.getScuderie(); // scuderie gara
                    ListIterator<String> lis = scuderieG.listIterator();

                    while ( lip.hasNext() )
                    {
                        String pil = lip.next();
                        String sc = lis.next();

                        if ( pil.equals(p.getNome()))
                        {
                            Scuderia scuderia = trovaScuderia(sc);

                            if ( scuderia.getCitta().equals(c2) )
                            {
                                ret ++;
                                trovato = true; 
                            }
                            break; // a prescindere dalla valutazione altra gara 
                        }
                    }
                    if ( trovato ) // inutile valutare altre gare
                        break; 
                }
            }
        }
        return ret; 
    }

    public float compensoTotaleScuderia(String s)
    {
        Scuderia scuderia = trovaScuderia(s);
        float compVittoria = scuderia.getCompensoExtra();
        float ret = 0.0;
        for ( Gara g: gare )
        {
            LinkedList<String> pilotiG = g.getPiloti(); // piloti gara
            ListIterator<String> lip = pilotiG.listIterator();
            LinkedList<String> scuderieG = g.getScuderie(); // scuderie gara
            ListIterator<String> lis = scuderieG.listIterator();

            while ( lip.hasNext() )
            {
                String pil = lip.next();
                String sc = lis.next();

                if ( sc.equals(s) )
                {
                    Pilota pilota = trovaPilota(pil);
                    ret += pilota.getCompensoPerGara();
                }
            }

            if ( scuderieG.getFirst().equals(s) )   // se colui che ha vinto la gara si trova nella scuderia allora sommiamo anche il compenso extra
                ret += compVittoria;

        }
        return ret;
    }

    private Pilota trovaPilota(String pil)
    {
        for ( Pilota p : piloti )
        {   
            if ( p.getNome().equals(p) )
            return p;
        }
        return null; 
    }
}

