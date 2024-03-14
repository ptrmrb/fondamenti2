package lezioni;

import java.util.*;

public class Comitiva {
    private ArrayList<Persona> partecipanti; // questo è un oggetto privato ma MUTABILE
    
    public ArrayList<Persona> getPartecipanti()
    {
        //  SHALLOW PROTECTIVE COPY -> in modo tale che l'utente non possa modificare i dati contenuti nella classe
        return new ArrayList<Persona>(partecipanti); 
    } 

    public Comitiva()
    {
        partecipanti = new ArrayList<>(); 
    }

    public void aggiungiPartecipante(Persona p)
    {
        partecipanti.add(p);
    }

    public int dimensione()
    {
        return partecipanti.size();
    }

    public Persona getPartecipante(int i )
    {
        return partecipanti.get(i);
    }

    public void rimoviPartecipante(Persona p)
    {
        partecipanti.remove(p);
    }

    public void sostituisciPartecipante(int i, Persona p)
    {
        partecipanti.set(i, p);
    }

    public boolean contiene(Persona p)
    {
        return partecipanti.contains(p);
    }

}
