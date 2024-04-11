package concessionaria; 

public class Automobile 
{
    private String modello; 
    private String colore; 
    private String casaProduttrice;
    private int cilindrata;
    private float prezzo;
    private String numeroTelaio; // ID

    /* 
    Progettare e implementare una classe automobile
    
    
    */ 

   public Automobile (String modello, String colore, String casaProduttrice, int cilindrata, float prezzo, String numeroTelaio) 
   {    
        this.modello = modello;
        this.colore = colore;
        this.casaProduttrice = casaProduttrice;
        this.cilindrata = cilindrata;
        this.prezzo = prezzo;
        this.numeroTelaio = numeroTelaio; 
   }

   public String getModello(){
    return modello;
   }

   public String getColore(){
    return colore;
   }

   public String getCasaProduttrice(){
    return casaProduttrice;
   }

   public String getCilindrata(){
    return cilindrata;
   }

   public String getPrezzo(){
    return prezzo;
   }

   public String getNumeroTelaio(){
    return numeroTelaio;
   }

    @Override
   public String equals(Object o)
   {    
        if ( o == null )
            return false; 
        if ( o == this )
            return true;
        if(!(o instanceof Automobile )) return false;
        Automobile a = ( Automobile ) o; 
        return a.numeroTelaio.equals(this.numeroTelaio);
   }

   

}