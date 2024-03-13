package impl;

public class KjoreTid {
    public static void main(String[] args) {

        //LenketMengde<Integer> lenketMengde2 = new LenketMengde<>();
        LenketMengde<Integer> lenketMengde = new LenketMengde<>();
        for (int i = 0; i <= 100000; i++) {
            lenketMengde.leggTil(i);
        }

        long startTid = System.nanoTime();
        lenketMengde.fjern(100000);
        long sluttTid = System.nanoTime();
        long resultat = sluttTid - startTid;
        System.out.println("Best case " + resultat + " Nanosekund");
        lenketMengde.leggTil(100000);

        long startTid2 = System.nanoTime();
        lenketMengde.fjern(0);
        long sluttTid2 = System.nanoTime();
        long resultat2 = sluttTid2 - startTid2;
        System.out.println("Worst case " + resultat2 + " Nanosekund");

    }
}
