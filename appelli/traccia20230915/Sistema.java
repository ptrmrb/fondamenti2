package traccia20230915;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.naming.LinkLoopException;

import terminale.*;

public class Sistema {
    private LinkedList<Piatto> listaPiatti;
    private LinkedList<Ingrediente> listaIngredienti;

    public Sistema() {
        listaPiatti = new LinkedList<>();
        listaIngredienti = new LinkedList<>();
    }
    /* Il metodo restituisce true se e solo se il numero di piatti adatti 
    ai vegetariani è almeno n. Un piatto è adatto ai vegetariani se tutti i suoi ingredienti lo sono. */

    public boolean verificaPiattiVegetariani(int n) {
        int npiatti = 0;

        for ( Piatto p : listaPiatti )
            if ( isPiattoVegetariano(p) )
                npiatti += 1; 

        if ( npiatti >= n )
            return true;
        return false;
    }

    private boolean isPiattoVegetariano ( Piatto p )
    {
        LinkedList<String> ingredienti = p.getIngredienti();
        ListIterator<String> lii = ingredienti.listIterator();

        while ( lii.hasNext() )
        {
            String ingrediente = lii.next();

            if ( !trovaIngrediente(ingrediente).adattoVegetariani() )
                return false;
        }
        
        return true;
    }

    private Ingrediente trovaIngrediente ( String ing )
    {
        for ( Ingrediente i : listaIngredienti )
            if ( i.getCodice().equals(ing) )
                return i;
        return null;
    }


    public LinkedList<String> piattiConIngrediente(String nomeIng, int k) {
        LinkedList<String> ret = new LinkedList<>();

        for ( Piatto p : listaPiatti )
        {
            LinkedList<String> ingredienti = p.getIngredienti();
            ListIterator<String> lii = ingredienti.listIterator();
            LinkedList<Integer> dosi = p.getDosi(); 
            ListIterator<Integer> lid = dosi.listIterator();

            while ( lii.hasNext() )
            {
                String ingrediente = lii.next();
                int dose = lid.next();

                if ( trovaIngrediente(ingrediente).getNome().equals(nomeIng) && dose >= k )
                    ret.add(p.getNome());
            }
        }
        return ret;
    }

    public LinkedList<String> piattiCostosi(float n) {
        LinkedList<String> ret = new LinkedList<>();

        for ( Piatto p : listaPiatti )
            if ( costoPiatto(p) >= n )
                ret.add(p.getNome());
        return ret;
    }
    /* Il  costo  di  un  piatto  è  pari alla  somma  dei  costi  pagati  per  ciascun  ingrediente, 
    dove  il costo  per ciascun ingrediente è uguale al prodotto tra la dose nel piatto e il costo
    unitario dell’ingrediente.  */

    private float costoPiatto ( Piatto p )
    {
        float costo = 0;

        LinkedList<String> ingredienti = p.getIngredienti();
            ListIterator<String> lii = ingredienti.listIterator();
            LinkedList<Integer> dosi = p.getDosi(); 
            ListIterator<Integer> lid = dosi.listIterator();

            while ( lii.hasNext() )
            {
                String ingrediente = lii.next();
                int dose = lid.next();
                
                costo += trovaIngrediente(ingrediente).getCostoUnitario() * dose; 
            }

        return costo;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo delle classi
        Sistema sistema = new Sistema();

        // Creazione di ingredienti
        Ingrediente uovo = new Ingrediente("I1", "Uovo", 0.5f, false);
        Ingrediente pancetta = new Ingrediente("I2", "Pancetta", 0.8f, false);
        Ingrediente fagioli = new Ingrediente("I3", "Fagioli", 0.3f, true);
        Ingrediente pomodoro = new Ingrediente("I4", "Pomodoro", 0.1f, true);

        sistema.listaIngredienti.add(uovo);
        sistema.listaIngredienti.add(pancetta);
        sistema.listaIngredienti.add(fagioli);
        sistema.listaIngredienti.add(pomodoro);

        // Creazione di piatti
        LinkedList<String> ingredientiCarbonara = new LinkedList<>();
        ingredientiCarbonara.add("I1");
        ingredientiCarbonara.add("I2");

        LinkedList<Integer> dosiCarbonara = new LinkedList<>();
        dosiCarbonara.add(20);
        dosiCarbonara.add(30);

        Piatto carbonara = new Piatto("P1", "Carbonara", ingredientiCarbonara, dosiCarbonara);

        LinkedList<String> ingredientiFagiolata = new LinkedList<>();
        ingredientiFagiolata.add("I3");
        ingredientiFagiolata.add("I4");

        LinkedList<Integer> dosiFagiolata = new LinkedList<>();
        dosiFagiolata.add(60);
        dosiFagiolata.add(50);

        Piatto fagiolata = new Piatto("P2", "Fagiolata", ingredientiFagiolata, dosiFagiolata);

        sistema.listaPiatti.add(carbonara);
        sistema.listaPiatti.add(fagiolata);

        // Esempio di chiamate ai metodi
        boolean vegetariani = sistema.verificaPiattiVegetariani(2);
        LinkedList<String> piattiConPancetta = sistema.piattiConIngrediente("Pancetta", 10);
        LinkedList<String> piattiCostosi = sistema.piattiCostosi(30.0f);

        Terminale.stampa(vegetariani); 
        Terminale.stampa(piattiConPancetta); 
        Terminale.stampa(piattiCostosi); 
    }
}
