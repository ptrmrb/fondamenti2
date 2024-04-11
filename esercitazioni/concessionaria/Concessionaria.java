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
    

}