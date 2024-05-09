

public class Cliente {
    private String nome, citta;

    public Cliente(String nome, String citta){
        this.nome = nome;
        this.citta = citta;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCitta(){
        return citta;
    }

    public void setCitta(String nome){
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Cliente c = (Cliente) o;
        return nome.equals(c.nome);
    }

    @Override
    public String toString(){
        return nome;
    }

}
