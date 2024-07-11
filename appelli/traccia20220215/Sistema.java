import java.util.*;

import javax.naming.LinkLoopException;

public class Sistema {
    private LinkedList<Prodotto> listaProdotti;
    private LinkedList<Fattura> listaFatture;

    public Sistema(LinkedList<Prodotto> listaProdotti, LinkedList<Fattura> listaFatture) {
        this.listaProdotti = listaProdotti;
        this.listaFatture = listaFatture;
    }

    public int numeroEsemplariMarca(String m) {
        int ret = 0;

        LinkedList<String> prodottiDiMarca = trovaProdottiDiMarca(m);

        for ( Fattura f : listaFatture )
        {
            ListIterator<String> lip = f.getProdotti().listIterator(); 
            ListIterator<Integer> liq = f.getQuantita().listIterator();

            while ( lip.hasNext() )
            {
                String prodotto = lip.next();
                int quantita = liq.next();

                if ( prodottiDiMarca.contains(prodotto) )
                    ret += quantita;
            }
        }

        return ret;
    }

    private LinkedList<String> trovaProdottiDiMarca ( String m ) // data una marca restituisce i prodotti
    {
        LinkedList<String> ret = new LinkedList<>();
        
        for ( Prodotto p : listaProdotti )
            if ( p.getMarca().equals(m) )
                ret.add(p.getNome());

        return ret;
    }

    public LinkedList<String> marcheInComune(String nomeCliente) {
        LinkedList<String> ret = new LinkedList<>();

        LinkedList<String> marcheProdottiAcquistatiCliente = trovaMarcheProdottiAcquistatiCliente(nomeCliente);
        LinkedList<String> marcheProdottiAcquistatiClienteCorr = new LinkedList<>(); 

        for ( Fattura f : listaFatture ){
            if ( !f.getCliente().equals( nomeCliente ) ) // in modo da evitare di controllare il cliente 'nomeCliente'
                marcheProdottiAcquistatiClienteCorr = trovaMarcheProdottiAcquistatiCliente(f.getCliente());

            for ( String s : marcheProdottiAcquistatiClienteCorr )
                if ( marcheProdottiAcquistatiCliente.contains(s) )
                {
                    ret.add(f.getCliente());
                    break; // PUOI INTERROMPERE PERCHE SE HA PRESO DUE PRODOTTI UGUALI LO AGGIUNGE DUE VOLTE
                }
        }

        return ret;
    }

    private LinkedList<String> trovaMarcheProdottiAcquistatiCliente ( String cliente )
    {
        LinkedList<String> ret = new LinkedList<>();

        for ( Fattura f : listaFatture )
            if ( f.getCliente().equals(cliente) )
                for ( String s : f.getProdotti() )
                    ret.add( trovaProdotto(s).getMarca() );

        return ret; 
    }

    private Prodotto trovaProdotto ( String nome )
    {
        for ( Prodotto p : listaProdotti) 
            if ( nome.equals( p.getNome() ))
                return p;
    
        return null;
    }

    public float maxCostoFattura(int d) {
        float maxCostoFattura = 0;
        float costoFatturaCorr;

        for ( Fattura f : listaFatture )
            if ( f.getData() == d )
            {
                costoFatturaCorr = calcolaCosto(f);
                if ( costoFatturaCorr > maxCostoFattura )
                    maxCostoFattura = costoFatturaCorr;
            }
        
        return maxCostoFattura;
    }

    private float calcolaCosto ( Fattura f )
    {
        float ret = 0; 

        ListIterator<String> lip = f.getProdotti().listIterator();
        ListIterator<Integer> liq = f.getQuantita().listIterator();

        while ( lip.hasNext() )
        {
            float prezzoUnitario = trovaProdotto(lip.next()).getPrezzoUnitario();
            float quantita = liq.next();

            ret += prezzoUnitario*quantita; 
        }
        return ret; 
    }

    public static void main(String[] args) {
        // Creazione dei prodotti
        Prodotto prodotto1 = new Prodotto("P1", "nomeMarca1", 1.00f);
        Prodotto prodotto2 = new Prodotto("P2", "nomeMarca2", 1.50f);
        Prodotto prodotto3 = new Prodotto("P3", "nomeMarca2", 2.00f);

        LinkedList<Prodotto> listaProdotti = new LinkedList<>();
        listaProdotti.add(prodotto1);
        listaProdotti.add(prodotto2);
        listaProdotti.add(prodotto3);

        // Creazione delle fatture
        LinkedList<String> prodottiF1 = new LinkedList<>();
        prodottiF1.add("P1");
        prodottiF1.add("P2");

        LinkedList<Integer> quantitaF1 = new LinkedList<>();
        quantitaF1.add(10);
        quantitaF1.add(20);

        Fattura fattura1 = new Fattura(1, "Cliente1", 1, prodottiF1, quantitaF1);

        LinkedList<String> prodottiF2 = new LinkedList<>();
        prodottiF2.add("P3");

        LinkedList<Integer> quantitaF2 = new LinkedList<>();
        quantitaF2.add(40);

        Fattura fattura2 = new Fattura(2, "Cliente2", 1, prodottiF2, quantitaF2);

        LinkedList<String> prodottiF3 = new LinkedList<>();
        prodottiF3.add("P1");

        LinkedList<Integer> quantitaF3 = new LinkedList<>();
        quantitaF3.add(5);

        Fattura fattura3 = new Fattura(3, "Cliente3", 1, prodottiF3, quantitaF3);

        LinkedList<Fattura> listaFatture = new LinkedList<>();
        listaFatture.add(fattura1);
        listaFatture.add(fattura2);
        listaFatture.add(fattura3);

        // Creazione del sistema con i prodotti e le fatture
        Sistema sistema = new Sistema(listaProdotti, listaFatture);

        // Esempio di chiamate ai metodi
        int numeroEsemplari = sistema.numeroEsemplariMarca("nomeMarca2");
        System.out.println("Numero esemplari marca 'nomeMarca2': " + numeroEsemplari);

        LinkedList<String> marcheComune = sistema.marcheInComune("Cliente1");
        System.out.println("Marche in comune con 'Cliente1': " + marcheComune);

        float maxCosto = sistema.maxCostoFattura(1);
        System.out.println("Max costo fattura per la data 1: " + maxCosto);
    }
}
