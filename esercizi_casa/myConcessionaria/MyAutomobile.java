/*
 * Progettare e implementare una classe Automobile che ne rappresenti modello,
 * colore, casa produttrice, cilindrata, prezzo e numero di telaio.
 * Il numero di telaio identifica un'automobile. 
 * 
 */

package esercizi_casa.myConcessionaria;

public class MyAutomobile 
{
    private String modello;
    private String colore;
    private String casaProduttrice;
    private int cilindrata;
    private float prezzo; 
    private String numTelaio;
 
    public MyAutomobile(String modello, String colore, String casaProduttrice, int cilindrata, float prezzo, String numTelaio)
    {   
        this.modello = modello;
        this.colore = colore;
        this.casaProduttrice = casaProduttrice;
        this.cilindrata = cilindrata;
        this.prezzo = prezzo;
        this.numTelaio = numTelaio;
    }

    // Getter methods
    public String getModello() {
        return modello;
    }

    public String getColore() {
        return colore;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getNumTelaio() {
        return numTelaio;
    }

    // Setter methods
    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setNumTelaio(String numTelaio) {
        this.numTelaio = numTelaio;
    }
    
    public String toString(){
        return casaProduttrice + " " + modello + ", telaio " + numTelaio;
    }

    public boolean equals(Object o)
    {
        if ( o == null ) // se l'oggetto non esiste allora non possono essere uguali
            return false;
        if ( this == o ) 
            return true;
        if(!(o instanceof MyAutomobile))
            return false;
        MyAutomobile a = (MyAutomobile) o;
        return numTelaio.equals(a.numTelaio);
    }

}

