package traccia20240129;

import java.util.LinkedList;
import java.util.ListIterator;

import terminale.Terminale;

public class Sistema {
    private LinkedList<Viaggio> listaViaggi;
    private LinkedList<Conducente> listaConducenti;

    public Sistema(LinkedList<Viaggio> listaViaggi, LinkedList<Conducente> listaConducenti) {
        this.listaViaggi = listaViaggi;
        this.listaConducenti = listaConducenti;
    }

    /*che  restituisce  true  se  e  solo  se  sono  soddisfatte entrambe le seguenti condizioni: 
    • nessun conducente ha un numero complessivo di ore inferiore a oreMin (il numero complessivo di 
    ore di un conducente è la somma delle durate dei viaggi gestiti dal conducente stesso); 
    • nessun viaggio ha un numero di passeggeri maggiore di passeggeriMax */

public  boolean  verifica(int  oreMin,  int  passeggeriMax)
{
    for ( Conducente c : listaConducenti )
    {
        if ( oreConducente(c) < oreMin )
            return false;
    }

    for (Viaggio v : listaViaggi )
        if ( v.getNumPasseggeri() > passeggeriMax )
            return false; 

    return true;
}

private int oreConducente(Conducente c)
{   
    int ret = 0; 
    LinkedList<String> viaggiConducente =  c.getViaggi();
    ListIterator<String> liv = viaggiConducente.listIterator();

    while ( liv.hasNext() )
    {
        String viaggio = liv.next();
        for (  Viaggio v : listaViaggi )
            if ( viaggio.equals(v.getCodice()) )
                ret += v.getDurata();
    }

    Terminale.stampa(ret);
    
    return ret; 
}

/* Il metodo restituisce la lista delle destinazioni richieste:
una destinazione d è richiesta se soddisfa le seguenti condizioni: 
    • almeno 2 viaggi hanno destinazione d; 
    • il numero totale di passeggeri che partecipano a viaggi aventi destinazione d
è maggiore di passeggeriMin. */

public LinkedList<String> destinazioniRichieste(int passeggeriMin)
{
    LinkedList<String> ret = new LinkedList<>();
    int viaggiPerDestinazione;
    int passeggeriTotali;

    LinkedList<String> destinazioni = estraiDestinazioni(); 

    for ( String d : destinazioni )
    {
        viaggiPerDestinazione = 0; 
        passeggeriTotali = 0;

        for (Viaggio v : listaViaggi)
            if ( v.getDestinazione().equals(d) )
            {
                viaggiPerDestinazione += 1;
                passeggeriTotali += v.getNumPasseggeri();
            }
        
        if ( viaggiPerDestinazione >= 2 && passeggeriTotali > passeggeriMin )
            ret.add(d); 
    }
    return ret; 
}

private LinkedList<String> estraiDestinazioni ()
{   
    LinkedList<String> ret = new LinkedList<>(); 
    for (Viaggio v : listaViaggi)
    {
        if (!ret.contains(v.getDestinazione()) )
            ret.add(v.getDestinazione());
    }
    return ret; 
}

/*Il metodo restituisce la lista dei nomi distinti dei  conducenti  i  cui  viaggi  non  hanno 
destinazioni  in  comune  con  i  viaggi  gestiti  dal  conducente  con  nome conducente */
public LinkedList<String> conducentiDiversi(String conducente)
{
    LinkedList<String> ret = new LinkedList<>();
    LinkedList<String> destinazioniConducente = destinazioniPerConducente(trovaConducente(conducente)); 

    for ( Conducente c : listaConducenti )
        if ( tuttiDiversi(destinazioniPerConducente(c), destinazioniConducente) )
            ret.add(c.getNome());
    return ret; 
}


private Conducente trovaConducente ( String c )
{
    for (Conducente Cond :  listaConducenti )
    {   
        if ( Cond.getNome().equals(c) )
            return Cond; 
    }
    return null; 
}

private boolean tuttiDiversi ( LinkedList<String> lista1 , LinkedList<String> lista2 )
{
    for ( String a : lista1 )
        for ( String b : lista2 )
            if( a == b )
                return false;  
    return true; 
}

private LinkedList<String> destinazioniPerConducente ( Conducente c )
{   
    LinkedList<String> ret = new LinkedList<>(); 

    for ( Viaggio v : listaViaggi ) 
        if ( c.getViaggi().contains(v.getCodice()) )
            ret.add(v.getDestinazione());

    return ret; 
}


    public static void main(String[] args) {
        // Creazione dei viaggi
        LinkedList<Viaggio> listaViaggi = new LinkedList<>();
        listaViaggi.add(new Viaggio("V1", "Roma", 5, 70));
        listaViaggi.add(new Viaggio("V2", "Roma", 6, 40));
        listaViaggi.add(new Viaggio("V3", "Salerno", 4, 50));
        listaViaggi.add(new Viaggio("V4", "Salerno", 4, 70));
        listaViaggi.add(new Viaggio("V5", "Reggio Calabria", 3, 50));
        listaViaggi.add(new Viaggio("V6", "Roma", 5, 40));

        // Creazione dei conducenti
        LinkedList<Conducente> listaConducenti = new LinkedList<>();
        LinkedList<String> viaggiRossi = new LinkedList<>();
        viaggiRossi.add("V1");
        viaggiRossi.add("V3");
        viaggiRossi.add("V6");
        listaConducenti.add(new Conducente("Rossi", viaggiRossi));

        LinkedList<String> viaggiBianchi = new LinkedList<>();
        viaggiBianchi.add("V2");
        listaConducenti.add(new Conducente("Bianchi", viaggiBianchi));

        LinkedList<String> viaggiVerdi = new LinkedList<>();
        viaggiVerdi.add("V4");
        viaggiVerdi.add("V5");
        listaConducenti.add(new Conducente("Verdi", viaggiVerdi));

        // Creazione del sistema
        Sistema sistema = new Sistema(listaViaggi, listaConducenti);

        // Test dei metodi
        //System.out.println(sistema.verifica(6, 80)); // Output: true
        //System.out.println(sistema.destinazioniRichieste(130)); // Output: [Roma]
        System.out.println(sistema.conducentiDiversi("Bianchi")); // Output: [Verdi]
    }

}