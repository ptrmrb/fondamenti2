package autostrade;

import terminale.*;

public class Test 
{	public static void main(String[] args)
	{	Autoveicolo a0 = new Autoveicolo("XXX","ALF",2400);
		Autoveicolo a1 = new Autoveicolo("YYY","MER",1600);
		Autoveicolo a2 = new Autoveicolo("ZZZ","VOL",1900);
		Autoveicolo a3 = new Autoveicolo("WWW","REN",1600);
		GestioneReteAS.aggiungiAutoveicolo(a0);
		GestioneReteAS.aggiungiAutoveicolo(a1);
		GestioneReteAS.aggiungiAutoveicolo(a2);
		GestioneReteAS.aggiungiAutoveicolo(a3);

		Citta c0 = new Citta("Lamezia Terme", "CZ", "Calabria");
		Citta c1 = new Citta("Rende", "CS", "Calabria");
		Citta c2 = new Citta("Milano", "MI", "Lombardia");
		Citta c3 = new Citta("Roma", "RM", "Lazio");
		Citta c4 = new Citta("Firenze", "FI", "Toscana");
		Citta c5 = new Citta("Torino", "TO", "Piemonte");
		GestioneReteAS.aggiungiCitta(c0);
		GestioneReteAS.aggiungiCitta(c1);
		GestioneReteAS.aggiungiCitta(c2);
		GestioneReteAS.aggiungiCitta(c3);
		GestioneReteAS.aggiungiCitta(c4);
		GestioneReteAS.aggiungiCitta(c5);
		
		Tratta t0 = new Tratta("cod00", "tratta0", c0, c1, 80.5);
		Tratta t1 = new Tratta("cod01", "tratta1", c3, c1, 516.5);
		Tratta t2 = new Tratta("cod02", "tratta2", c3, c4, 277.0);
		Tratta t3 = new Tratta("cod03", "tratta3", c4, c2, 302.0);
		Tratta t4 = new Tratta("cod04", "tratta4", c5, c2, 141.0);
		GestioneReteAS.aggiungiTratta(t0);
		GestioneReteAS.aggiungiTratta(t1);
		GestioneReteAS.aggiungiTratta(t2);
		GestioneReteAS.aggiungiTratta(t3);
		GestioneReteAS.aggiungiTratta(t4);
		
		Percorrenza p0 = new Percorrenza(t0, a0, 1);
		Percorrenza p1 = new Percorrenza(t0, a1, 1);
		Percorrenza p2 = new Percorrenza(t1, a1, 2);
		Percorrenza p3 = new Percorrenza(t2, a2, 2);
		Percorrenza p4 = new Percorrenza(t3, a3, 2);
		Percorrenza p5 = new Percorrenza(t4, a0, 2);
		Percorrenza p6 = new Percorrenza(t2, a2, 3);
		Percorrenza p7 = new Percorrenza(t3, a3, 3);
		Percorrenza p8 = new Percorrenza(t4, a3, 4);
		GestioneReteAS.aggiungiPercorrenza(p0);
		GestioneReteAS.aggiungiPercorrenza(p1);
		GestioneReteAS.aggiungiPercorrenza(p2);
		GestioneReteAS.aggiungiPercorrenza(p3);
		GestioneReteAS.aggiungiPercorrenza(p4);
		GestioneReteAS.aggiungiPercorrenza(p5);
		GestioneReteAS.aggiungiPercorrenza(p6);
		GestioneReteAS.aggiungiPercorrenza(p7);
		GestioneReteAS.aggiungiPercorrenza(p8);
		
		Terminale.stampa(GestioneReteAS.trovaAutoveicoli(300));
		Terminale.stampa(GestioneReteAS.accessi(c1));
		Terminale.stampa(GestioneReteAS.trovaAutoFrequente(2,4));
		Terminale.stampa(GestioneReteAS.cittaGettonate());
	}

}
