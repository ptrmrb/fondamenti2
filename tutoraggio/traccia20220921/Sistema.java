package traccia20220921;

import java.util.*;

public class Sistema {
    private LinkedList<Film> film;
    private LinkedList<Cliente> clienti;

    public Sistema(LinkedList<Film> film, LinkedList<Cliente> clienti) {
        this.film = new LinkedList<>(film);
        this.clienti = new LinkedList<>(clienti);
    }

    /**
     * @return Il metodo restituisce il nome del cliente che ha speso la massima cifra totale.
     * La cifra totale spesa da un cliente deve ovviamente essere calcolata considerando,
     * per ogni film che il cliente ha acquistato o noleggiato,
     * il relativo prezzo. Se più di un cliente soddisfa la condizione,
     * il metodo restituisce uno qualsiasi tra di essi.
     */
    public String clienteMax() {
        Cliente maxC = null;
        int max = 0;
        for(Cliente c : clienti) {
            int spesa = spesaTot(c);
            if(spesa > max) {
                max = spesa;
                maxC = c;
            }
        }
        return maxC.getNome();
    }

    private int spesaTot(Cliente c) {
        int ret = 0;
        ListIterator<String> filmLt = c.getTitoli().listIterator();
        ListIterator<String> modLt = c.getModalita().listIterator();
        while(filmLt.hasNext()) {
            String fcurr = filmLt.next();
            for(Film f : film)
                if(f.getTitolo().equals(fcurr)) {
                    if(modLt.next().equals("acquisto"))
                        ret += f.getPrezzoAcquisto();
                    else
                        ret += f.getPrezzoNoleggio();
                    break;
                }
        }
        return ret;
    }

    private class Nodo{
        private String nome;
        private LinkedList<Integer> date;

        public Nodo(String nome, LinkedList<Integer> date) {
            this.nome = nome;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Nodo nodo = (Nodo) o;
            return Objects.equals(nome, nodo.nome);
        }
    }

    public boolean verificaDati(String c){
        Cliente cliente = null;
        for(Cliente c1: clienti)
            if(c1.getNome().equals(c)){
                cliente = c1;
                break;
            }
        LinkedList<Nodo> f = new LinkedList<>();
        ListIterator<String> titoli = cliente.getTitoli().listIterator();
        ListIterator<String> mod = cliente.getModalita().listIterator();
        ListIterator<Integer> date = cliente.getDate().listIterator();
        while(titoli.hasNext()){
            String titoloCurr = titoli.next();
            Integer data = date.next();
            if(mod.next().equals("acquisto")){
                if(f.contains(new Nodo(titoloCurr, null)))
                    return false;
                f.add(new Nodo(titoloCurr, new LinkedList<>(List.of(-1))));
            } else {
                boolean trovato = false;
                for(Nodo n : f)
                    if(n.nome.equals(titoloCurr)){
                        if(n.date.contains(data))
                            return false;
                        n.date.add(data);
                        trovato = true;
                        break;
                    }
                if(!trovato)
                    f.add(new Nodo(titoloCurr, new LinkedList<>(List.of(data))));
            }
        }
        return true;
    }

    public boolean dateTutteDiverse(Cliente c){
        for(Film f: film) {
            ListIterator<String> titoli = c.getTitoli().listIterator();
            ListIterator<String> mod = c.getModalita().listIterator();
            ListIterator<Integer> dateIt = c.getDate().listIterator();
            LinkedList<Integer> date = new LinkedList<>();
            while(titoli.hasNext())
                if(titoli.next().equals(f.getTitolo()) && mod.next().equals("noleggio")){
                    int data = dateIt.next();
                    if(date.contains(data))
                        return false;
                    date.add(data);
                }
        }
        return true;
    }

    public String registaApprezzato(int d1, int d2){
        int max = 0;
        String ret = "";
        LinkedList<String> registi = estraiRegisti();
        for(String r: registi){
            int c = conta(r, d1, d2);
            if(c > max){
                max = c;
                ret = r;
            }
        }
        return ret;
    }

    /**
     *
     * @param r
     * @param d1
     * @param d2
     * @return il numero di acquisti o noleggi compresi tra d1 e d2 dei film del regista r
     */
    private int conta(String r, int d1, int d2) {
        int ret =0;
        LinkedList<String> fReg = estraiFilm(r);
        for(Cliente c: clienti){
            ListIterator<String> titoli = c.getTitoli().listIterator();
            ListIterator<Integer> dateIt = c.getDate().listIterator();
            while(titoli.hasNext()){
                int data = dateIt.next();
                if(fReg.contains(titoli.next()) && data <= d2 && data >= d1) {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }

    private LinkedList<String> estraiFilm(String r) {
        LinkedList<String> ret = new LinkedList<>();
        for(Film f : film)
            if(f.getRegista().equals(r))
                ret.add(f.getTitolo());
        return ret;
    }

    private LinkedList<String> estraiRegisti() {
        LinkedList<String> ret = new LinkedList<>();
        for(Film f : film)
            if(!ret.contains(f.getRegista()))
                ret.add(f.getRegista());
        return ret;
    }

    public static void main(String[] args) {
        LinkedList<Film> f = new LinkedList<>();
        f.add(new Film("Film A", "Rossi", 10, 5));
        f.add(new Film("Film B", "Verdi", 8, 4));
        f.add(new Film("Film C", "Rossi", 10, 5));
        f.add(new Film("Film D", "Verdi", 12, 6));

        LinkedList<Cliente> c = new LinkedList<>();
        c.add(new Cliente("Mario", new LinkedList<>(List.of("Film B","Film D")), new LinkedList<>(List.of("acquisto","acquisto")), new LinkedList<>(List.of(10,20))));
        c.add(new Cliente("Luigi", new LinkedList<>(List.of("Film B","Film A")), new LinkedList<>(List.of("noleggio","acquisto")), new LinkedList<>(List.of(10,20))));
        c.add(new Cliente("Anna", new LinkedList<>(List.of("Film B","Film A")), new LinkedList<>(List.of("acquisto","noleggio")), new LinkedList<>(List.of(15,30))));
        c.add(new Cliente("Lucia", new LinkedList<>(List.of("Film C","Film C")), new LinkedList<>(List.of("noleggio","noleggio")), new LinkedList<>(List.of(5,25))));
        c.add(new Cliente("LuciaEvil", new LinkedList<>(List.of("Film C","Film C")), new LinkedList<>(List.of("noleggio","noleggio")), new LinkedList<>(List.of(5,5))));
//        c.add(new Cliente("LuciaEvil", new LinkedList<>(List.of("Film C","Film C")), new LinkedList<>(List.of("acquisto","acquisto")), new LinkedList<>(List.of(5,25))));

        Sistema s = new Sistema(f, c);
        System.out.println(s.clienteMax()); //restituisce "Mario"
        System.out.println(s.verificaDati("Lucia"));  //restituisce true
        System.out.println(s.verificaDati("LuciaEvil"));  //restituisce false
        System.out.println(s.registaApprezzato(10, 20)); //restituisce "Verdi"
    }

}