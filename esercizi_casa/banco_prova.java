package esercizi_casa;

import java.util.ArrayList;

import esercizi_casa.myConcessionaria.MyAutomobile;
import esercizi_casa.myConcessionaria.MyConcessionaria;
import terminale.*;
import listeconcatenate.*;

public class banco_prova
{
    public static void main(String[] args){
        
        /*
        
        MyAutomobile a = new MyAutomobile("fiesta", "nero", "Ford", 1400, 20000, "hsv3");
        MyAutomobile b = new MyAutomobile("500", "bianco", "Fiat", 1600, 10000, "ada2");
        MyAutomobile c = new MyAutomobile("A5", "Blu", "Audi", 1800, 20000, "dl25");
        //Terminale.stampa(a);
        
        MyConcessionaria magazzino = new MyConcessionaria();
        //magazzino.aggiungiAuto(a);
        //magazzino.aggiungiAuto(b); 
        //magazzino.aggiungiAuto(c);

        //magazzino.stampaAll();

        Terminale.stampa(magazzino.sommaPrezziAuto());

         */

         ListaConcatenataInt lista = new ListaConcatenataInt();
         
         lista.aggiungiInCoda(1);
         lista.aggiungiInCoda(2);
        lista.aggiungiInCoda(1);
        lista.aggiungiInCoda(3);


        Terminale.stampa(lista.firstEven());

        
         
         

    }
    
}
