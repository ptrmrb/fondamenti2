package traccia20220617;
import java.util.*;


import java.util.LinkedList;

import terminale.Terminale;

public class Sistema {
    private LinkedList<Volo> listaVoli;
    private LinkedList<Prenotazione> listaPrenotazioni;

    public Sistema(LinkedList<Volo> listaVoli, LinkedList<Prenotazione> listaPrenotazioni) {
        this.listaVoli = listaVoli;
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public boolean verificaPrenotazioni() {
        for ( Prenotazione p : listaPrenotazioni )
			if ( !isCorretta(p))
				return false;

        return true;
    }

	private boolean isCorretta(Prenotazione p)
	{	
		LinkedList<String> percorso = p.getPercorso();
		ListIterator<String> lip = percorso.listIterator();
		ListIterator<String> lia = percorso.listIterator();
		lia.next();						// imposto il listIterator per l'arrivo una posizione avanti in modo che prenda sempre gli aereoporti di arrivo

		while ( lia.hasNext() )			// se l'aereoporto di arrivo ha un successivo vuol dire che il percorso non è terminato 
		{
			String partenza = lip.next();
			String arrivo = lia.next();

			for (Volo v : listaVoli)
				if ( v.getPartenza().equals(partenza) && v.getArrivo().equals(arrivo) )
					return true;
		}
		return false; 
	}

    public Volo voloMax() {
        float incassoMax = 0;
		Volo voloMax = null;
		float incassoCorrente;

		for (Volo v : listaVoli){

			incassoCorrente = v.getPrezzoBusiness()*numeroClassiBusiness(v) + v.getPrezzoEconomica()*numeroClassiEconomica(v); ;

			if ( incassoCorrente >= incassoMax ){
				incassoMax = incassoCorrente;
				voloMax = v;
			}
		}
        return voloMax;
    }

	private int numeroClassiBusiness ( Volo v )
	{
		int ret = 0;

		for ( Prenotazione p : listaPrenotazioni )
		{	
			if ( p.getClass().equals("business") )
			{
				LinkedList<String> percorso = p.getPercorso();
				ListIterator<String> lip = percorso.listIterator();
				ListIterator<String> lia = percorso.listIterator();

				lia.next();

				while ( lia.hasNext() )		
				{
					String partenza = lip.next();
					String arrivo = lia.next();

					if ( v.getPartenza().equals(partenza) && v.getArrivo().equals(arrivo) )
						ret += 1;
				}
			}
		}
		return ret;
	}

	private int numeroClassiEconomica ( Volo v )
	{
		int ret = 0;

		for ( Prenotazione p : listaPrenotazioni )
		{	
			if ( p.getClass().equals("economica") )
			{
				LinkedList<String> percorso = p.getPercorso();
				ListIterator<String> lip = percorso.listIterator();
				ListIterator<String> lia = percorso.listIterator();

				lia.next();

				while ( lia.hasNext() )		
				{
					String partenza = lip.next();
					String arrivo = lia.next();

					if ( v.getPartenza().equals(partenza) && v.getArrivo().equals(arrivo) )
						ret += 1;
				}
			}
		}
		return ret;
	}


    public LinkedList<String> destinazioneComune(String cliente) {
        LinkedList<String> ret = new LinkedList<>(); 
		LinkedList<String> destinazioniCliente = estraiDestinazioniCliente(cliente); //['Londra' , 'Parigi']

		for ( Prenotazione p : listaPrenotazioni )	// esaminiamo tutti i clienti che non sono cliente
			if ( destinazioniCliente.contains(p.getPercorso().getLast())
				&& !p.getNomeCliente().equals(cliente)
				&& !ret.contains(p.getNomeCliente()))
				ret.add(p.getNomeCliente());

        return ret;
    }

	private LinkedList<String> estraiDestinazioniCliente(String cliente)
	{
		LinkedList<String> ret = new LinkedList<>(); 
		for ( Prenotazione p : listaPrenotazioni )
			if ( p.getNomeCliente().equals(cliente))
				ret.add(p.getPercorso().getLast()); 
		return ret; 
	}

    public static void main(String[] args) {
        // Creazione dei voli
        Volo volo1 = new Volo("Roma", "Milano", 300, 150);
        Volo volo2 = new Volo("Lamezia", "Roma", 200, 120);
        Volo volo3 = new Volo("Lamezia", "Milano", 240, 130);
        Volo volo4 = new Volo("Roma", "Londra", 450, 250);
        Volo volo5 = new Volo("Milano", "Parigi", 350, 200);

        LinkedList<Volo> listaVoli = new LinkedList<>();
        listaVoli.add(volo1);
        listaVoli.add(volo2);
        listaVoli.add(volo3);
        listaVoli.add(volo4);
        listaVoli.add(volo5);

        // Creazione delle prenotazioni
        LinkedList<String> percorso1 = new LinkedList<>();
        percorso1.add("Lamezia");
        percorso1.add("Roma");
        percorso1.add("Londra");
        Prenotazione prenotazione1 = new Prenotazione(percorso1, "Rossi", "business");

        LinkedList<String> percorso2 = new LinkedList<>();
        percorso2.add("Roma");
        percorso2.add("Milano");
        percorso2.add("Parigi");
        Prenotazione prenotazione2 = new Prenotazione(percorso2, "Rossi", "business");

        LinkedList<String> percorso3 = new LinkedList<>();
        percorso3.add("Milano");
        percorso3.add("Parigi");
        Prenotazione prenotazione3 = new Prenotazione(percorso3, "Bianchi", "economica");

        LinkedList<String> percorso4 = new LinkedList<>();
        percorso4.add("Lamezia");
        percorso4.add("Milano");
        percorso4.add("Parigi");
        Prenotazione prenotazione4 = new Prenotazione(percorso4, "Bianchi", "economica");

        LinkedList<String> percorso5 = new LinkedList<>();
        percorso5.add("Lamezia");
        percorso5.add("Roma");
        Prenotazione prenotazione5 = new Prenotazione(percorso5, "Verdi", "economica");

        LinkedList<Prenotazione> listaPrenotazioni = new LinkedList<>();
        listaPrenotazioni.add(prenotazione1);
        listaPrenotazioni.add(prenotazione2);
        listaPrenotazioni.add(prenotazione3);
        listaPrenotazioni.add(prenotazione4);
        listaPrenotazioni.add(prenotazione5);

        // Creazione del sistema con i voli e le prenotazioni
        Sistema sistema = new Sistema(listaVoli, listaPrenotazioni);

        // Esempio di chiamate ai metodi
        boolean prenotazioniCorrette = sistema.verificaPrenotazioni();
        //System.out.println("Prenotazioni corrette: " + prenotazioniCorrette);

        Volo voloMassimo = sistema.voloMax();
        //System.out.println("Volo con incasso massimo: " + voloMassimo);

        LinkedList<String> clientiDestinazioneComune = sistema.destinazioneComune("Rossi");
        System.out.println("Clienti con destinazione comune a Rossi: " + clientiDestinazioneComune);
    }
}