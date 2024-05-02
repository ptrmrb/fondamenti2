package lezioni; 

public class Biglietto {

    private int numero;
    private static int numeroBigliettiCreati = 0;

    public Biglietto()
    {
        //numero = numeroBigliettiCreati + 1;
        this.numero = Biglietto.numeroBigliettiCreati + 1;
        Biglietto.numeroBigliettiCreati ++;
    }

    // da un metodo statico non posso fare riferimento ad attribiti non statici

    public String toString(){
        return "Biglietto numero " + numero;
    }
    
    public static void reset(){
        numeroBigliettiCreati = 0;
    }
}
