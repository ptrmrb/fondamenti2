package traccia20210623;

import java.util.*;

public class Sistema { // {} []

    private LinkedList<Intervento> interventi;
    private LinkedList<Operaio> operai;

    public Sistema ( LinkedList<Intervento> Interventi, LinkedList<Operaio> Operai ){ 
        this.interventi = interventi;
        this.operai = operai;
    }
    
    //Il metodo restituisce il codice dell’intervento più costoso tra quelli svolti nell’intervallo di date [data_inizio..data_fine].
    
    public String interventoPiuCostoso(int data_inizio, int data_fine)
    {
        String ret = null;
        int costoMassimo = 0;
        int costoCorrente = 0;

        for ( Intervento i : interventi )
        { 
            if ( i.getData()>= data_inizio && i.getData()<= data_fine )
                costoCorrente = calcolaCostoIntervento(i.getDurata(), i.getListaOperai());
                if ( costoCorrente >= costoMassimo )
                    costoMassimo = costoCorrente;
                    ret = i.getCodice();
        }
        return ret; 
    }

    private int calcolaCostoIntervento( int durata, LinkedList<String> nomiOperai ){
        int ret = 0;
        for ( String s : nomiOperai){
            for ( Operaio operaio : operai )
            {
                if ( operaio.getNome() == s )
                {
                    ret += durata * operaio.getCostoOraio();
                }
            }
        }
        return ret; 
    }

}


