package sok;

import adt.MengdeADT;

import java.util.Arrays;

public class MengdeTabell<T> implements MengdeADT<T> {
    public T[] elements;
    private int size;

    public MengdeTabell() {
        this.elements = (T[]) new Integer[10];
        this.size = 0;
    }

    @Override
    public boolean erTom() {
        return size == 0;
    }

    @Override
    public boolean inneholder(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (int i = 0; i < size - 1; i++) {
            if (!annenMengde.inneholder(elements[i])) {
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
        for (int i = 0; i < size; i++) {
            if (!annenMengde.inneholder(elements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < size; i++) {
            if (annenMengde.inneholder(elements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> snitt = new MengdeTabell<>();
        for (int i = 0; i < size; i++) {
            if (annenMengde.inneholder(elements[i])) {
                snitt.leggTil(elements[i]);
            }
        }
        return snitt;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeTabell<T> union = new MengdeTabell<>();
        union.leggTilAlleFra(this);
        union.leggTilAlleFra(annenMengde);
        return union;
    }

    @Override
    public MengdeADT<T> differanse(MengdeADT<T> annenMengde) {
        MengdeADT<T> differanse = new MengdeTabell<>();
        for (int i = 0; i < size; i++) {
            if (!annenMengde.inneholder(elements[i])) {
                differanse.leggTil(elements[i]);
            }
        }
        return differanse;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) {
            if (size == elements.length) {
                utvidTabell();
            }
            elements[size++] = element;
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
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                T fjernetElement = elements[i];
                elements[i] = elements[size - 1];
                elements[size - 1] = null;
                size--;
                return fjernetElement;
            }
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public int antallElementer() {
        return size;
    }

    private void utvidTabell() { //Utvider tabell
        elements = Arrays.copyOf(elements, size*2);
    }


}
