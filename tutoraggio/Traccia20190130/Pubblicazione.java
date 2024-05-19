package traccia20190130; 

public class Pubblicazione{
    private String codice, titolo;
    private int data;
    ArrayList<String> autori;
    ArrayList<String> keywords;

    public String getCodice()
    {    return codice;
    }

    public String getTitolo()
    {    return titolo;
    }

    public int getData()
    {   return data;
    }

    public ArrayList<String> getAutori()
    {   return autori;
    }

    public ArrayList<String> getKeywords()
    {    return keywords;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Pubblicazione pubblicazione = (Pubblicazione)o;
        return codice.equals(pubblicazione.getCodice());
    }

    


}