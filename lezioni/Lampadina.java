package lezioni;

public class Lampadina {
    private boolean accesa;

    public Lampadina() // finche esiste un solo costruttore privato non si possono dichiarare oggetti 
    {   
        accesa = false;
    }

    //ACCESSOR
    public boolean eAccesa(){
        return accesa;
    }

    //MUTATOR
    public void premiBottone()
    {
        if(accesa)
            accesa = true;
        else
            accesa = false;
    }

    public void premiBottone1(){
        accesa = !accesa;
    }

    public String toString(){
        if (accesa)
            return "Lampadina accesa";
        else
            return "Lampadina spenta";
    }



}
