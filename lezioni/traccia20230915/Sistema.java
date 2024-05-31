package lezioni.traccia20230915;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.naming.LinkLoopException;

public class Sistema {
    private LinkedList<Piatto> listaPiatti;
    private LinkedList<Ingrediente> listaIngredienti;

    public Sistema( LinkedList<Piatto> listaPiatti, LinkedList<Ingrediente> listaIngredienti)
    {

    }

    public boolean verificaPiattiVegetariani(int n)
    {
        int c = 0; 
        for ( Piatto p : listaPiatti )
            if ( adattoVegetariani (p) )
                c ++; 
        return c >= n;
    }

    private boolean adattoVegetariani(Piatto p)
    {
        for ( String codiceIngrediente : p.getIngredienti() )
            if ( !cercaIngrediente(codiceIngrediente).adattoVegetariani() )
                return false;
            return true;
    }

    private Ingrediente cercaIngrediente(String codice)
    {
        for ( Ingrediente i : listaIngredienti )
            if ( i.getCodice().equals(codice) )
                return i;
        return null; 
    }

    public LinkedList<String> piattiConIngrediente(String nomeIng, int k)
    {   
        LinkedList<String> ret = new LinkedList<>(); 
        for ( Piatto p : listaPiatti )
            if ( contieneIngrediente(p, nomeIng, k) )
                ret.add(p.getNome());
        return ret;
    }

    private boolean contieneIngrediente(Piatto p , String nomeIng, int k)
    {
        ListIterator<String> itCodIngredienti = p.getIngredienti().listIterator();
        ListIterator<Integer> itDosi = p.getDosi().listIterator();

        while ( itCodIngredienti.hasNext() )
        {
            String i = itCodIngredienti.next();
            String nomeIngrediente = cercaIngrediente(i).getNome();
            int d = itDosi.next();
            if ( nomeIngrediente.equals(nomeIng) )
                return d >= k; // {}
        }
        return false;
    }

    public LinkedList<String> piattiCostosi ( float n )
    {   
        LinkedList<String> ret = new LinkedList<>();
        for ( Piatto p : listaPiatti )
            if ( costo(P) >= n )
                ret.add( p.getNome() );    
    } 

    private float costo(Piatto p)
    {   
        float ret = 0f; 
        ListIterator<String> itCodIngredienti = p.getIngredienti().listIterator();
        ListIterator<Integer> itDosi = p.getDosi().listIterator();
        
        while ( itCodIngredienti.hasNext() )
        {
            String codIngrediente = itCodIngredienti.next();
            int dose = itDosi.next();

            ret += cercaIngrediente(codIngrediente).getCostoUnitario() * dose;
        }
        return ret; 
    }
}

