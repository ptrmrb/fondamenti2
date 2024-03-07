package lezioni;

public class Lezione0703 {
    public static void main( String[] args )
    {
    Persona p1 = new Persona();
    p1.nome = "Mario";
    p1.cognome = "Vizza";
    p1.annoNascita = 2004;
    
    Persona p2 = new Persona();
    p2.nome = "Luigi";
    p2.cognome = "Senatore";
    p2.annoNascita = 2005;

    Persona[] comitiva = new Persona[5];
    comitiva[0]  = p1;
    comitiva[1] = p2;
    comitiva[2] = null;
    comitiva[3] = null;
    comitiva[4] = null;

    String s1 = p1.toString();
    String s2 = p2.toString();

    //Terminale.stampa(p1);
    System.out.println(s1);

    }
}
