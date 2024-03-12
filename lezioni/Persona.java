package lezioni;

public class Persona 
    {

    private String nome;
    private String cognome; 
    private int annoNascita;


    public String toString()
    {   return nome + " " + cognome + " nato nel " + annoNascita;
    }

    // mutator method 

    public void setNome(String nome)
        {   this.nome = nome; // quindi nel main scriveremo pi.setNome(“Mario”)
        }
    public void setCognome(String cognome)
        {   this.cognome = cognome;
        }
    public void setAnnoNascita(int annoNascita)
        {   this.annoNascita = annoNascita;
        }
    
    // accessor method 
    public String getNome()
        {   return nome; 
        }
    public String getCognome()
        {   return cognome; 
        }

    public int getAnnoNascita(){
        return annoNascita;
    }


    // constructor method

    public Persona ( String nome, String cognome, int annoNascita ) {
        setNome(nome);
        setCognome(cognome);
        setAnnoNascita(annoNascita); // sempre con l’iniziale minuscola. 
        }

    public boolean eGiovane(){
        return this.annoNascita > 1984; // oppure this.getAnnoNascita() > 
    }
    
    // COPY CONSTRUCTOR --> crea la copia di un oggetto 
    public Persona(Persona p){
        nome = p.nome;
        cognome = p.cognome;
        annoNascita = p.annoNascita;
    }

    public boolean equals()
    {
        if ( o == null )
            return false;
        if (!(o instanceof Persona))
            return false;
        else 
        
    }

    Object 



    }
