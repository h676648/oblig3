package impl;

public class KjoreTid {
    public static void main(String[] args) {

        TabellMengde<Integer> tabellMengde = new TabellMengde<>();
        LenketMengde<Integer> lenketMengde = new LenketMengde<>();
        for (int i = 0; i < 1000; i++) {
            tabellMengde.leggTil(i);
            lenketMengde.leggTil(i);
        }
        long startTid = System.nanoTime();
        tabellMengde.inneholder(999);




        long sluttTid = System.nanoTime();
        long resultat = sluttTid - startTid;
        System.out.println("Worst case " + resultat + " Nanosekund");
    }
}
