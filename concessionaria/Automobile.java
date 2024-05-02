/*
 * Progettare e implementare una classe Automobile che ne rappresenti modello,
 * colore, casa produttrice, cilindrata, prezzo e numero di telaio.
 * Il numero di telaio identifica un'automobile. 
 * 
 */

 package concessionaria;

 public class Automobile // La classe genera oggetti immutabili 
 {	private String modello; // es. "Punto"
     private String colore; // es. "Nero"
     private String casaProduttrice; // es. "Fiat"
     private int cilindrata; // es. 1300
     private float prezzo; // es. 12000
     private String numTelaio; // es. "ABC123456789"
     
     // costruttore 
     public Automobile(String modello, String colore, String casaProduttrice, int cilindrata, float prezzo, String numTelaio) {
         this.modello = modello;
         this.colore = colore;
         this.casaProduttrice = casaProduttrice;
         this.cilindrata = cilindrata;
         this.prezzo = prezzo;
         this.numTelaio = numTelaio;
     }
 
     public String getModello() 
     {	return modello;
     }
 
     public String getColore() 
     {	return colore;
     }
 
     public String getCasaProduttrice() 
     {	return casaProduttrice;
     }
 
     public int getCilindrata() 
     {	return cilindrata;
     }
 
     public float getPrezzo() 
     {	return prezzo;
     }
 
     public String getNumTelaio() 
     {	return numTelaio;
     }
     
 
     public String toString()
     {	return casaProduttrice + " " + modello + ", telaio " + numTelaio;
     }
     
     public boolean equals(Object x) 
     {	if(x == null) 
             return false;
         if(this == x) 
             return true;
         if(!(x instanceof Automobile)) 
             return false;
         Automobile a = (Automobile) x;
         return numTelaio.equals(a.numTelaio);
     }

   

}