package autostrade;

    private String nome, provincia, regione;

    public Citta(String nome, String provincia, String regione){
        this.nome = nome;
        this.provincia = provincia.
        this.regione = regione;
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public boolean ( Object o ){
        if ( o == null ) return false;
        if ( o = this ) return true; 
        if (! ( o instanceof Citta)) return false;

        Citta c = (Citta)o;
        return c.nome.equals(nome) && c.provincia.equals(provincia);
    }

    public int compareTo(Citta c){
        int accessi = GestioneReteAS.accessi(this);
        int accessiC = GestioneReteAS.accessi(this);

        if ( accessiC < accessi )
            return -1;
        if ( accessiC == accessi )
            return 0;
        return 1; 
    }
}
