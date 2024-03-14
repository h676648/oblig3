package sok;

import impl.JavaSetToMengde;
import impl.LenketMengde;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tid {
    public static void main(String[] args) {
        Random random = new Random();
        int[] tab1 = new int[10000];
        JavaSetToMengde<Integer> hashSet = new JavaSetToMengde<>();
        MengdeTabell<Integer> tabell = new MengdeTabell<>();


        //LenketMengde<Integer> lenketMengde2 = new LenketMengde<>();
        LenketMengde<Integer> lenketMengde = new LenketMengde<>();
        for (int i = 0; i < 100000; i++) {
            hashSet.leggTil(i);
            tabell.leggTil(i);
        }
        for (int i = 0; i < 10000; i++) {
            tab1[i] = random.nextInt(1000000);
        }
        long startTid = System.nanoTime();
        boolean e = binaerSok_R(tabell.elements, 78000, 0, 99999);
        long sluttTid = System.nanoTime();

        long resultat = sluttTid - startTid;
        System.out.println("Det tar " + resultat + " Nanosekunder for binaersok for en tabell.");

        long startTid2 = System.nanoTime();
        boolean h = hashSet.inneholder(78000);
        long sluttTid2 = System.nanoTime();

        long resultat2 = sluttTid2 - startTid2;
        System.out.println("Det tar " + resultat2 + " Nanosekunder for sok for et hashset.");

        int telling = 0;
        long startTid3 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            boolean f = binaerSok_R(tabell.elements, tab1[i], 0, 10000);
            if (f == true) {
                telling++;
            }
        }
        long sluttTid3 = System.nanoTime();
        long resultat3 = sluttTid3 - startTid3;
        System.out.println("Det er telt " + telling + " ganger.");
        System.out.println("Det tar " + resultat3 + " nanosekunder for 10000 sok i tabell.");


        int telling2 = 0;
        long startTid4 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            boolean g = hashSet.inneholder(tab1[i]);
            if (g == true) {
                telling2++;
            }
        }
        long sluttTid4 = System.nanoTime();
        long resultat4 = sluttTid4 - startTid4;
        System.out.println("Det er telt " + telling2 + " ganger.");
        System.out.println("Det tar " + resultat4 + " nanosekunder for 10000 sok i hashSet.");
    }

    public static void printArray(int[] tabell) {
        for(int i=0; i<tabell.length; i++){
            if(tabell[i]!=0){
                System.out.println(tabell[i]);
            }

        }
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
