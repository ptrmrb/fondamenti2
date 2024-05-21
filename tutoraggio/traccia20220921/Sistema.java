package traccia20220921;

import java.util.*;

public class Sistema
{      
    /*Il metodo restituisce  il  nome  del  cliente  che  ha speso la massima
    cifra totale. La cifra totale spesa da un cliente deve ovviamente essere
    calcolata considerando, per ogni film che il cliente ha acquistato o noleggiato,
    il relativo prezzo. Se più di un cliente soddisfa la condizione, il metodo 
    restituisce uno qualsiasi tra di essi. */

    private List<Film> films;
    private List<Cliente> clienti;

    public Sistema(List<Film> films, List<Cliente> clienti)
    {   this.films = films;
        this.clienti = clienti;
    }

    public String clienteMax(){
        String maxCliente = null; 
        int maxSpesa = 0;

        for( Cliente cliente: clienti ) // controllo i clienti
        {
            int spesaTot = 0; 
            LinkedList<String> titoli = cliente.getTitoli(); // titoli per cliente
            LinkedList<String> modalità = cliente.getModalita(); // modalita per titolo
            
            for ( int i = 0; i < titoli.size(); i++ ) // scorri i titoli
            {
                String titolo = titoli.get(i);
                String modalitaAcquisto = modalità.get(i);

                for ( Film film : films ) // scorri i film 
                {
                    if ( film.getTitolo().equals(titolo) ) // se trova il film del cliente
                        if ( modalitaAcquisto.equals("acquisto")) // riconosce la modalità
                            spesaTot += film.getPrezzoAcquisto(); // inc
                        else if ( modalitaAcquisto.equals("noleggio"))
                            spesaTot += film.getPrezzoNoleggio(); // inc
                }
            }

            if ( spesaTot > maxSpesa ) // controllo max 
            {
                maxSpesa = spesaTot;
                maxCliente = cliente.getNome();
            }
        }
        return maxCliente;
    }
    
    /*  Il metodo restituisce true se e solo se l’insieme delle operazioni fatte dal cliente con
    *   nome c soddisfa le seguenti condizioni: 
            • c non ha acquistato più di una volta uno stesso film; 
            • per ogni film f noleggiato da c più di una volta, le date in cui c ha
              noleggiato f sono tutte diverse; 
    */

    public boolean verificaDati(String c){
        
        for ( Cliente cliente : clienti ){
            if ( cliente.equals(c) )
                


        }


    }


    public String registaAprezzato(){


    }

    public static void main(String[] args) {
        
        Film film1 = new Film("Film A","Rossi",10,5);
		Film film2 = new Film("Film B","Verdi",8,4);
		Film film3 = new Film("Film C","Rossi",10,5);
		Film film4 = new Film("Film D","Verdi",12,6);
		
		Cliente c1 = new Cliente("Mario",new LinkedList<String>(List.of("Film B","Film D")), new LinkedList<>(List.of("acquisto","acquisto")),new LinkedList<>(List.of(10,20)));
		Cliente c2 = new Cliente("Luigi",new LinkedList<String>(List.of("Film B","Film A")), new LinkedList<>(List.of("noleggio","acquisto")),new LinkedList<>(List.of(10,20)));
		Cliente c3 = new Cliente("Anna",new LinkedList<String>(List.of("Film B","Film A")), new LinkedList<>(List.of("acquisto","noleggio")),new LinkedList<>(List.of(15,30)));
		Cliente c4 = new Cliente("Lucia",new LinkedList<String>(List.of("Film C","Film C")), new LinkedList<>(List.of("noleggio","noleggio")),new LinkedList<>(List.of(5,25)));
		
		ArrayList<Film> films = new ArrayList<>(List.of(film1,film2,film3,film4));
		ArrayList<Cliente> clienti = new ArrayList<>(List.of(c1,c2,c3,c4));
		
		Sistema sis = new Sistema(films,clienti);

        System.out.println(sis.clienteMax());
    }
}