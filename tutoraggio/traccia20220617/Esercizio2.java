public class Esercizio2
{
    public static int contaElementiSpeciali(int b){
        // ragioniamo sui casi limite
        // se la lista è vuota oppure la testa è null restituisce 0
        if ( testa == null ) return 0;
        return contaElementiSpecialiRic(b, testa, 0, 0);
    }

    private int contaElementiSpecialiRic(int b, NodoInt corrente, int sommaPrec , int cont){
        // caso di uscita ovvero quando il caso ricorsivo non richiama più se stesso
        if ( corr = null ) return cont; // se la lista è finita quanti elementi speciali ho contato fino ad ora
        //generico elemento della lista
        if ( corr.getInfo() > b - sommaPrec )
            cont ++; // altro elemento speciale
        return contaElementiSpecialiRic(b, corr.getSuccessivo(), sommaPrec+corr.getInfo(), cont);
    }


    // ALTERNATIVA: non passiamo il paramentro cont
    private int contaElementiSpecialiRic(int b, NodoInt corrente, int sommaPrec){
        // caso di uscita ovvero quando il caso ricorsivo non richiama più se stesso
        if ( corr = null ) return cont; // se la lista è finita quanti elementi speciali ho contato fino ad ora
        //generico elemento della lista
        if ( corr.getInfo() > b - sommaPrec )
            return 1 + contaElementiSpecialiRic(b, corr.getSuccessivo(), sommaPrec+corr.getInfo());
        return contaElementiSpecialiRic(b, corr.getSuccessivo(), sommaPrec+corr.getInfo());
    }
}