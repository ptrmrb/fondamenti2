package concessionaria;

import java.util.ArrayList;

public class Concessionaria{

    private ArrayList<Automobile> magazzino;

    // costr. default
    public Concessionaria(Concessionaria c)
    {
        magazzino = new ArrayList<>();
        for (Automobile a: c.magazzino){
            Autombile a1 = new Automobile(a1.getModello ... );

        }

    }

    public void stampaAutomobili()
    {
        for(Automobile a: magazzino)
            Terminale.stampa(a);

    }

    // trovare la casa produttrice più ricorrente
    public String casaRicorrente()
    {
        // estrazione di tutte le case produttrici
        ArrayList<String> caseProd = estraiCaseProduttrici();
        String casaRic = caseProd.get(0);
        int maxOccorreze = contaOccorrenze(casaRic);
        for ( int i = 1; i < casaProd.size(); i++ )
        {
            int occorrenze = contaOccorrenze(caseProd.get(i))
            if ( occorrenze > maxOccorreze )
            {
                casaRic = caseProd.get(i);
                maxOccorreze = occorrenze; 
            }
        }
    }

    private ArrayList<String> estraiCaseProduttrici(){
        ArrayList<String> caseProd = new ArrayList<>();
        String casa = a.getCasaProduttrice();
        for (Automobile a: magazzino){
            if ( !(caseProd.add(casa)) )
                caseProd.add(casa);   
        }
        return caseProd;
    }

    private int contaOccorrenze(String casa)
    {
        int cont = 0; 
        for ( Autombile a: magazzino){
            if (a.getCasaProduttrice().equals(casa))
                cont ++;
        }
        return cont;
    }
    
    // trovare l'auto con cilindrata più bassa con il prezzo inferiore a 10.000 euri

    public Automobile cilindrataMinima()
    {
        int cilindrataMin = Integer.max_value;
        Automobile aMin = null; 
        for ( Automobile a: magazzino ){
            if ( a.getPrezzo() < 10000 && (aMin == null || a.getCilindrata() < aMin.getCilindrata() ) )
                aMin = a;
                cilindrataMin = a.getCilindrata(); 
        } 
    return aMin; 
    }

    public Automobile cilindrataAlta()
    {
        float mediaPrezzi = sommaPrezzi()/magazzino.size(); 
        Automobile ris = null;
        for ( Automobile a: magazzino)
            if ( a.getPrezzo() > mediaPrezzi && ( ris == null || a.getCilindrata() > ris.getCilindrata()))
                ris = a; 
        return ris;
    }

    //trovare le case produttrici che producono solo auto con un prezzo inferiore alla media dei prezzi delle auto

    public ArrayList caseEconomiche()
    {
        ArrayList<String> tutteCase = estraiCaseProduttrici;
        float mediaPrezzi = sommaPrezzi()/magazzino.size();
        ArrayList<String> caseEc = new ArrayList<>();

        for ( String casa: tutteCase )
            if ( soloPrezzoInferiore(casa, mediaPrezzi) )
                ris.add(casa);
        return ris;  
    }
    private boolean soloPrezzoInferiore()
    {
        

    }
}