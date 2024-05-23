/*
 * Progettare e implementare una classe Concessionaria tenendo conto delle seguenti
 * specifiche:
 * 		-	La concessionaria contiene un magazzino (cioè una lista di automobili).
 * 		-	La classe deve contenere metodi per:
 * 				
 * 				-	trovare la casa produttrice più ricorrente;
 * 				-	trovare l'auto con la cilindrata più bassa tra quelle con un prezzo
 * 					inferiore a 10.000 euro;
 * 				-	trovare l'auto con la cilindrata più alta tra quelle con un prezzo
 * 					superiore alla media dei prezzi delle auto;
 * 				-	trovare le case produttrici che producono solo auto con un prezzo
 * 					inferiore alla media dei prezzi delle auto;
 * 				-	trovare le case produttrici che producono solo auto con la stessa
 * 					cilindrata.
 */

package esercizi_casa.myConcessionaria;

import java.util.*;
import terminale.*;

public class MyConcessionaria {

    private ArrayList<MyAutomobile> magazzino;

    //costruttore

    public MyConcessionaria() 
     { 	magazzino = new ArrayList<>(); 
     }

    // aggiungere un'auto al magazzino;
    public void aggiungiAuto( MyAutomobile a )
    {   magazzino.add(a);    
    }

    // rimuovere un'auto dal magazzino;
    public void rimuoviAuto ( MyAutomobile a )
    {   magazzino.remove(a);
    }
    
    // stampare tutte le auto 
    public void stampaAll()
    {   for( MyAutomobile a: magazzino )
            Terminale.stampa(a);
    }

    // calcolare la somma dei prezzi di tutte le auto;
    public float sommaPrezziAuto()
    {
        float somma = 0;
        for( MyAutomobile a : magazzino)
        {   somma += a.getPrezzo(); 
        }
        return somma;
    }  

    // trovare la casa produttrice più ricorrente;
    public String casaRicorrente()
    {
        ArrayList<String> caseProduttrici = estraiCase();
        String casaPiuRicorrente = caseProduttrici.get(0);
        int maxOccorrenze = occorrenzeCasa(casaPiuRicorrente);

        for(int i=1; i<caseProduttrici.size(); i++) // scorre le case
         {	String casa = caseProduttrici.get(i); // prende la casa produttrice in indice "i"
            int numOcc = occorrenzeCasa(casa); // salva le occorrenze della casa 

            if(numOcc > maxOccorrenze) // scambio
            {	casaPiuRicorrente = casa;
                maxOccorrenze = numOcc;
            }
         }
         return casaPiuRicorrente;
    }

    private ArrayList<String> estraiCase()
    {
        ArrayList<String> ris = new ArrayList<>(); 
        for( MyAutomobile a: magazzino)
        {
            String casa = a.getCasaProduttrice();
            if(!ris.contains(casa))
                ris.add(casa);
        }
        return ris;
    }

    private int occorrenzeCasa(String casa)
    {
        int occorrenze = 0;
        for( MyAutomobile a: magazzino)
            if(a.getCasaProduttrice().equals(casa))
                occorrenze++;
        return occorrenze; 

    }

    // trovare l'auto con la cilindrata più bassa tra quelle con un prezzo
    // inferiore a 10.000 euro 




            


    }

