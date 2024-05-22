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

    public String clienteMax() {
        String maxCliente = null;
        int maxSpesa = 0;
    
        for (Cliente cliente : clienti) {
            int spesaTotale = 0;
            ListIterator<String> lit = cliente.getTitoli().listIterator();
            ListIterator<String> lim = cliente.getModalita().listIterator();
    
            while (lit.hasNext() && lim.hasNext()) {
                String titolo = lit.next();
                String modalita = lim.next();
    
                for (Film film : films) {
                    if (film.getTitolo().equals(titolo)) {
                        if (modalita.equals("acquisto")) {
                            spesaTotale += film.getPrezzoAcquisto();
                        } else if (modalita.equals("noleggio")) {
                            spesaTotale += film.getPrezzoNoleggio();
                        }
                    }
                }
            }
    
            if (spesaTotale > maxSpesa) {
                maxSpesa = spesaTotale;
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

    public boolean verificaDati(String c) {
        Cliente cliente = null;
        for (Cliente cl : clienti) {
            if (cl.getNome().equals(c)) {
                cliente = cl;
                break;
            }
        }
        if (cliente == null)
            return false;
        LinkedList<String> titoli = cliente.getTitoli();
        LinkedList<String> modalita = cliente.getModalita();
        LinkedList<Integer> date = cliente.getDate();
    
        // Verifica che ogni film acquistato non sia acquistato più di una volta
        ListIterator<String> lit1 = titoli.listIterator();
        ListIterator<String> lim1 = modalita.listIterator();

        while (lit1.hasNext() && lim1.hasNext()) {
            String titolo1 = lit1.next();
            String mod1 = lim1.next();

            if (mod1.equals("acquisto")) {
                ListIterator<String> lit2 = titoli.listIterator(lit1.nextIndex());
                ListIterator<String> lim2 = modalita.listIterator(lim1.nextIndex());
                while (lit2.hasNext() && lim2.hasNext()) {
                    if (titolo1.equals(lit2.next()) && lim2.next().equals("acquisto")) {
                        return false;
                    }
                }
            }
        }
    
        // Verifica che le date di noleggio per ogni film siano tutte diverse
        lit1 = titoli.listIterator();
        lim1 = modalita.listIterator();
        ListIterator<Integer> lid1 = date.listIterator();

        while (lit1.hasNext() && lim1.hasNext() && lid1.hasNext()) {
            String titolo1 = lit1.next();
            String mod1 = lim1.next();
            int data1 = lid1.next();

            if (mod1.equals("noleggio")) {
                ListIterator<String> lit2 = titoli.listIterator(lit1.previousIndex() + 1);
                ListIterator<String> lim2 = modalita.listIterator(lim1.previousIndex() + 1);
                ListIterator<Integer> lid2 = date.listIterator(lid1.previousIndex() + 1);

                while (lit2.hasNext() && lim2.hasNext() && lid2.hasNext()) {

                    if (titolo1.equals(lit2.next()) && lim2.next().equals("noleggio")) {

                        if (data1 == lid2.next()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public String registaApprezzato(int d1, int d2) {
        List<String> registi = new ArrayList<>();
        List<Integer> conteggi = new ArrayList<>();
    
        for (Cliente cliente : clienti) {
            ListIterator<String> lit = cliente.getTitoli().listIterator();
            ListIterator<Integer> lid = cliente.getDate().listIterator();
            List<String> clientiConsiderati = new ArrayList<>();
    
            while (lit.hasNext() && lid.hasNext()) {
                String titolo = lit.next();
                int data = lid.next();
    
                if (data >= d1 && data <= d2) {
                    for (Film film : films) {

                        if (film.getTitolo().equals(titolo)) {
                            String regista = film.getRegista();

                            if (!clientiConsiderati.contains(cliente.getNome())) {
                                int index = registi.indexOf(regista);

                                if (index == -1) {
                                    registi.add(regista);
                                    conteggi.add(1);
                                } else {
                                    conteggi.set(index, conteggi.get(index) + 1);
                                }
                                clientiConsiderati.add(cliente.getNome());
                            }
                        }
                    }
                }
            }
        }
    
        String registaMax = null;
        int maxClienti = 0;
    
        for (int i = 0; i < registi.size(); i++) {
            if (conteggi.get(i) > maxClienti) {
                maxClienti = conteggi.get(i);
                registaMax = registi.get(i);
            }
        }
    
        return registaMax;
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
        //System.out.println(sis.verificaDati(c4));
        //System.out.println(sis.registaApprezzato(10,20));
    }
}