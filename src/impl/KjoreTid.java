package impl;

public class KjoreTid {
    public static void main(String[] args) {
        JavaSetToMengde<Integer> hashSet = new JavaSetToMengde<>();
        TabellMengde<Integer> tabell = new TabellMengde<>();


        //LenketMengde<Integer> lenketMengde2 = new LenketMengde<>();
        LenketMengde<Integer> lenketMengde = new LenketMengde<>();
        for (int i = 0; i < 100000; i++) {
            hashSet.leggTil(i);
            tabell.leggTil(i);
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
    public static <T extends Comparable<T>> boolean binaerSok_R(T[] a, T element, int min, int maks) {
        if (min > maks) {
            return false;
        }
        int midtpunkt = (min + maks) / 2;
        int resultat = element.compareTo(a[midtpunkt]);

        if (resultat == 0) {
            return true;
        }
        if (resultat < 0) {
            return binaerSok_R(a, element, min, midtpunkt - 1);
        } else {
            return binaerSok_R(a, element, midtpunkt + 1, maks);

        }
    }
    public static <T extends Comparable<T>> int binaerSok_I(T[] a, T element, int min, int maks) {
        int forste = min;
        int siste = maks;
        int index = -1;
        boolean funnet = false;
        int resultat = 0;

        while (!funnet && forste <= siste) {
            int midtpunkt = (forste + siste) /2;
            resultat = element.compareTo(a[midtpunkt]);

            if (resultat == 0) {
                funnet = true;
                index = midtpunkt;
            } else if (resultat < 0) {
                siste = midtpunkt - 1;
            } else {
                forste = midtpunkt + 1;
            }
        }
        return index;
    }
}
