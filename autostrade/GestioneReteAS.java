package autostrade;

public class GestioneReteAS {

private ArrayList<Citta> citta = new ArrayList<>;
private ArrayList<Tratta> tratte = new ArrayList<>;
private ArrayList<Autoveicolo> autoveicoli = new ArrayList<>; 
private ArrayList<Percorrenza> percorrenze = new ArrayList<>;

// costruttore oppure metodi per aggiungere elem alle risp liste

public void addCitta ( Citta c ){
    citta.add(c);
}

public void addTratta ( Tratta t ){
    tratte.add(t);
}

public void addAutoveicolo ( Autoveicolo a ){
    autoveicoli.add(a);
}

public addPercorrenza ( Percorrenza p ){
    percorrenze.add(p);
}

// primo metodo
// restituisce il numero di partecipanti
// che hannoa avuto come destinazione la città c

public int accesi(Citta c)
{
    int cont = 0 ;
    for ( Percorrenza p : percorrenze )
        if ( p.getTratta().getCittaDestinazione().equals(c) )
            cont ++;
    return cont;
}

// secondo metodo 
// restituisce gli autoveicolo che non hanno mai percorso tratte autostadrali piu lunghe di x chilometri

public ArrayList<Autoveicolo> trovaAutoveicoli ( int x )
{
    ArrayList<Autoveicolo> ret = new ArrayList<>();
    for ( Autoveicolo a: autoveicoli )
        if ( ! trattaPiuLunga(a,x))
            ret.add(a);
    return ret; 
}

private boolean trattaPiuLunga( Autoveicolo a , int x){
    for ( Percorrenza p: percorrenze )
        if ( p.getAutoveicolo().equals(a) && getTratta().getDistanza() > x )
            return true;
    return false;
}

// terzo metodo 
// restituisce l'autoveicolo che ha percorso maggior numero di tratte
public Autoveicolo trovaAutoFrequente(int d1, int d2){
    Autoveicolo ret = null;
    int maxTratte = Integer.MIN_VALUE; 

    for ( Autoveicolo a: autoveicoli){
        int numTratte = contaTratte(a, d1, d2);
        if ( numTratte > maxTratte ){
            ret = a; 
            maxTratte = numTratte; 
        }
    }
    return ret;
}

private contaTratte ( Autoveicolo a, int d1, int d2 ){
    int cont = 0; 
    for ( Percorrenza p: percorrenze )
        if ( p.getAutoveicolo().equals(a) && p.getData() >= d1 && p.getData() <= d2 )
            cont ++;
    return cont; 
}

// quarto metodo 

public ArrayList<Citta> cittaGettonate( ){
    ArrayList<Citta> cittaOrdinate = new ArrayList<>(citta);
    Collections.sort(cittaOrdinate);
    Collections.reverse(cittaOrdinate);
    return cittaOrdinate;

}


}
