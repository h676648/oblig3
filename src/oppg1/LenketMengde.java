package oppg1;

import adt.MengdeADT;
import adt.LinearNode;
public class LenketMengde<T> implements MengdeADT<T> {

    private LinearNode<T> forste;
    private int size;

    public LenketMengde() {
        forste = null;
        size = 0;
    }



    @Override
    public boolean erTom() {
        return size == 0;
    }

    @Override
    public boolean inneholder(T element) {
       LinearNode<T> temp = forste;
       while (temp != null) {
           if (temp.getData().equals(element)) {
               return true;
           }
           temp = temp.getNeste();
       }
       return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : tilTabell()) {
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (size != annenMengde.antallElementer()) {
            return false;
        }
        for (T element : tilTabell()) {
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> snitt = new TabellMengde<>();
        for (T element : tilTabell()) {
            if (annenMengde.inneholder(element)) {
                snitt.leggTil(element);
            }
        }
        return snitt;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
       MengdeADT<T> union = new LenketMengde<>();
       union.leggTilAlleFra(this);
       union.leggTilAlleFra(annenMengde);
       return union;
    }

    @Override
    public MengdeADT<T> differanse(MengdeADT<T> annenMengde) {
       MengdeADT<T> differanse = new LenketMengde<>();
       for (T element : tilTabell()) {
           if (!annenMengde.inneholder(element)) {
               differanse.leggTil(element);
           }
       }
       return differanse;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            LinearNode<T> nyNode = new LinearNode<>(element);
            nyNode.setNext(forste);
            forste = nyNode;
            size++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
       LinearNode<T> temp = forste;
       LinearNode<T> forrige = null;
       while (temp != null) {
           if (temp.getData().equals(element)) {
               if (forrige == null) {
                   forste = temp.getNeste();
               } else {
                   forrige.setNext(temp.getNeste());
               }
               size--;
               return temp.getData();
           }
           forrige = temp;
           temp = temp.getNeste();
       }
       return null;
    }

    @Override
    public T[] tilTabell() {
       T[] tabell = (T[]) new Object[size];
       LinearNode<T> temp = forste;
       int index = 0;
       while (temp != null) {
           tabell[index] = temp.getData();
           index++;
           temp = temp.getNeste();
       }
       return tabell;
    }

    @Override
    public int antallElementer() {
        return size;
    }
}
