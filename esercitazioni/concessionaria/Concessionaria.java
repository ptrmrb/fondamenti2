package concessionaria;

import java.util.ArrayList;
import terminale.*;

public class Concessionaria{

    private ArrayList<Automobile> magazzino;

    // costr. default
    public Concessionaria(Concessionaria c)
    {
        magazzino = new ArrayList<>();
        for (Automobile a: c.magazzino){
            Automobile a1 = new Automobile(a1.getModello ... );

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
        for ( int i = 1; i < caseProd.size(); i++ )
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
        for ( Automobile a: magazzino){
            if (a.getCasaProduttrice().equals(casa))
                cont ++;
        }
        return cont;
    }
    
    // trovare l'auto con cilindrata più bassa con il prezzo inferiore a 10.000 euri

    public Automobile cilindrataMinima()
    {
        int cilindrataMin = Integer.MAX_VALUE;
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

    //trovare le case produttrici che producono solo auto con un prezzo inferiore alla media dei prezzi 
    //delle auto

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

    // ret true sse tutte le automoibili di quella casaProd hanno prezzo ok
    private boolean soloPrezzoInferiore(String casa, float mediaPrezzi)
    {
        for ( Automobile a: magazzino )
            if ( a.getCasaProduttrice().equals(casa) && a.getPrezzo >= mediaPrezzi )
                return false;
        return true;
    }

    public ArrayList<String> caseStessaCilindrata() 
    {
        ArrayList<String> tutteCase = estraiCaseProduttrici();
        ArrayList<String> ris = new ArrayList(); 
        for ( String casa: tutteCase )
        {
            if ( stessaCilindrata(casa) )
                ris.add(casa);
        }
    }

    private boolean stessaCilindrata(String casa)
    {
        ArrayList<Automobile> autoCasa = new ArrayList<>();
        for  (Automobile a: magazzino)
            if ( a.getCasaProduttrice().equals(casa))
                autoCasa.add(a);
        int cilindrata = autoCasa.get(0);
        for ( int i = 1; i < autoCasa.size(); i++ )
            if ( ! ( autoCasa.get(i).getCilindrata() != cilindrata ))
                return false;
        return true; 
    }

    private boolean stessaCilindrata2(String casa)
    {
        ArrayList<Integer> cilindrateCasa = new ArrayList<>();
        for  (Automobile a: magazzino)
            if ( a.getCasaProduttrice().equals(casa))
                cilindrateCasa.add(a.getCilindrata());

        int cilindrata = autoCasa.get(0);
        for ( int i = 1; i < autoCasa.size(); i++ )
            if ( cilindrateCasa.get(i) != cilindrata )
                return false;
        return true; 
    }
}