package ricorsione;

public class Ric {
    //Si scriva una funzione ricorsiva che dato un numero positivo X controlla se X è un numero primo
    public static boolean primo(int x){
        return x != 1 && primo(x, 2);
    }

    private static boolean primo(int x, int i) {
        if(i > x/2)
            return true;
        return x%i != 0 && primo(x, i+1);
    }

    /*Si scriva una funzione ricorsiva 2 parametri X ed Y interi positivi,
	che calcola la divisione intera di X ed Y senza usare l’operatore /,
	ma usando solo le operazioni di somma, sottrazione e gli operatori relazionali
	 */
    public static int divisione(int x, int y){
        if(x<y)
            return 0;
        return 1 + divisione(x-y, y);
    }

    /*Scrivere una funzione ricorsiva che (senza usare cicli) ricevuti due numeri interi
	  calcoli la somma di tutti i numeri dell’intervallo tra i due numeri, compresi i numeri stessi.
	 */
    private static int sommaNumeri(int da, int a) {
        if(da == a)
            return a;
        return da + sommaNumeri(da+1, a);
    }

    //Si scriva una funzione ricorsiva 2 parametri X ed Y interi positivi trova l'mcd
    public static int mcd(int x, int y){
        if(x%y==0)
            return y;
        return mcd(y, x%y);
    }

    /*Dati due numeri interi X > 0 e N>=2, scrivere in una funzione ricorsiva
     *che calcoli la seguente sommatoria con i che va da 2 a N
     *(x+i)/(2*i-1)
     */
    public static int sommatoria(int x, int n){
        if(n < 2)
            return 0;
        return (x+n)/(2*n-1) + sommatoria(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(sommaNumeri(1,5));
        System.out.println(divisione(13, 3));
        System.out.println(primo(1));
        System.out.println(mcd(16, 12));
        System.out.println(sommatoria(7, 10));
    }
}
