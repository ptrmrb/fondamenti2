package lezioni;

public class Persona 
    {

    public String nome;
    public String cognome; 
    public int annoNascita;


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


    // constructor method

    public void persona ( String nome, String cognome, int annoNascita ) {
        setNome(nome);
        setCognome(cognome);
        setAnnoNascita(annoNascita); // sempre con l’iniziale minuscola. 
        }
    
    }
