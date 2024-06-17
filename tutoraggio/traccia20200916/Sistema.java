package traccia20200916;

import java.util.LinkedList;

import terminale.Terminale;

public class Sistema {
    private LinkedList<Utente> utenti;
    private LinkedList<Messaggio> messaggi;

    public Sistema(LinkedList<Utente> utenti, LinkedList<Messaggio> messaggi) {
        this.utenti = utenti;
        this.messaggi = messaggi;
    }

    /**
     * 
     * @param destinatario
     * @return la lista dei nomi degli utenti che hanno inviato qualche messaggio all’utente destinatario,
     * ma nessuno di questi messaggi è stato letto.
     */
    public LinkedList<String> nessunaLettura(String destinatario){
        return null;
    }

    /**
     *
     * @param dataInizio
     * @param dataFine
     * @return la lista dei nomi degli utenti per ciascuno dei quali l’insieme dei messaggi inviati
     * nel periodo compreso tra il giorno dataInizio e il giorno dataFine (estremi inclusi)
     * ha cardinalità maggiore o uguale a 2 e non contiene alcuna coppia di messaggi inviati
     * a destinatari che risiedono in città diverse.
     */
    public LinkedList<String> cittaUnica(int dataInizio, int dataFine){

        LinkedList<String> ret = new LinkedList<>();
        int cardinalità = 0;

        LinkedList<String> cittàDestinatari = new LinkedList<>();

        for ( Utente u : utenti )
        {   
            cardinalità = 0; 
            for ( Messaggio m : messaggi )
            {   //se trovo l'utente che mi interessa e la data è valida incremento la cardinalità
                if ( m.getNomeMittente().equals(u.getNome()) && m.getData()>= dataInizio && m.getData() <= dataFine )
                cardinalità++;
            }
    
            if ( cardinalità >= 2 )
            {
                cittàDestinatari = trovaCittaDestinatari(u); // lista che contiene la città dei destinatari
                if ( !tuttiUguali(cittàDestinatari) ) break; // se le citta di provenienza dei destinatari non è tutta la stessa interrompi
                ret.add(u.getNome());
            }   
        }

        return ret;
    }

    private Utente trovaUtente( String nome )
    {
        for ( Utente u : utenti)
            if ( u.getNome() == nome )
                return u; 
    
        return null; 
    }

    private LinkedList<String> trovaCittaDestinatari ( Utente u )
    {   
        LinkedList<String> ret = new LinkedList<>();
        for ( Messaggio m : messaggi )
            if ( m.getNomeMittente().equals(u.getNome()) )

                ret.add( trovaUtente(m.getNomeDestinatario()).getCitta() );

        return ret; 
    }

    private boolean tuttiUguali ( LinkedList<String> lista )
    {
        String primo = lista.getFirst(); 

        for (String elemento : lista) 
            if (!primo.equals(elemento)) 
                return false;

        return true; 
    }

    /**
     *
     * @param data
     * @param citta
     * @return la lista dei nomi degli utenti che hanno inviato il maggior numero di messaggi
     * nel giorno data a destinatari che risiedono nella città citta.
     */
    public LinkedList<String> mittentiFrequenti(int data, String citta){

        LinkedList<String> ret = new LinkedList<>();
        int nMessaggi = 0;
        int nMessaggiMax = 0;

        for ( Utente u : utenti )
        {
            nMessaggi = 0; // RICORDA 
            for (Messaggio m : messaggi)
            {
                if ( m.getNomeMittente().equals(u.getNome())
                    && m.getData() == data
                    && trovaUtente( m.getNomeDestinatario() ).getCitta() == citta )
                    {
                        nMessaggi ++; 
                    }
            }

            if ( nMessaggi > nMessaggiMax )
            {
                ret.clear();
                ret.add(u.getNome());
                nMessaggiMax = nMessaggi;
            }

            else if ( nMessaggi == nMessaggiMax )
                ret.add(u.getNome()); 
        }

        return ret;
    }

    

    public static void main(String[] args) {
        LinkedList<Utente> utenti = new LinkedList<>();
        utenti.add(new Utente("Utente A", "Roma"));
        utenti.add(new Utente("Utente B", "Roma"));
        utenti.add(new Utente("Utente C", "Milano"));
        utenti.add(new Utente("Utente D", "Milano"));

        LinkedList<Messaggio> messaggi = new LinkedList<>();
        messaggi.add(new Messaggio("Utente A", "Utente B", 10, false));
        messaggi.add(new Messaggio("Utente A", "Utente B", 11, false));
        messaggi.add(new Messaggio("Utente B", "Utente C", 15, true));
        messaggi.add(new Messaggio("Utente B", "Utente D", 16, false));
        messaggi.add(new Messaggio("Utente C", "Utente A", 15, true));
        messaggi.add(new Messaggio("Utente C", "Utente D", 16, false));
        messaggi.add(new Messaggio("Utente D", "Utente C", 16, true));

        Sistema s = new Sistema(utenti, messaggi);
        //System.out.println(s.nessunaLettura("Utente B")); //restituisce la lista ["Utente A"].
        //System.out.println(s.cittaUnica(14, 16)); //restituisce la lista ["Utente B"].
        System.out.println(s.mittentiFrequenti(15,"Roma")); //restituisce la lista ["Utente C"].
    }
}
