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
            accesa = false;
        else
            accesa = true;
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

    public boolean equals(Object o)
    {
        if ( o == null )
            return false;
        if ( o == this )
            return false;
        if (!(o instanceof Lampadina))
            return false;

        Lampadina l = (Lampadina)o;

        return accesa == l.accesa;
    }


}
