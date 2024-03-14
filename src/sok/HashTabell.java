package sok;

import adt.MengdeADT;

import java.util.HashSet;
import java.util.Set;

public class HashTabell<T> implements MengdeADT<T> {

    public Set<T> set;

    public HashTabell(){
        this.set = new HashSet<>();
    }




    @Override
    public boolean erTom() {

        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : set){
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (set.size() == annenMengde.antallElementer()) {
            return erDelmengdeAv(annenMengde);
        }
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : set) {
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> mengde = new HashTabell<>();
        for (T element : set) {
            if (annenMengde.inneholder(element)) {
                mengde.leggTil(element);
            }
        }

        return mengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> mengde = new HashTabell<>();
        mengde.leggTilAlleFra(annenMengde);
        mengde.leggTilAlleFra(this);
        return mengde;
    }

    @Override
    public MengdeADT<T> differanse(MengdeADT<T> annenMengde) {
        MengdeADT<T> mengde = new HashTabell<>();
        for (T element : set) {
            if (!annenMengde.inneholder(element)) {
                mengde.leggTil(element);
            }
        }
        return mengde;
    }

    @Override
    public void leggTil(T element) {
        set.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for (T element : annenMengde.tilTabell()) {
            leggTil(element);
        }
    }

    @Override
    public T fjern(T element) {
        if(set.contains(element)) {
            set.remove(element);
            return element;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] tabell = (T[]) new Integer[set.size()];

        return set.toArray(tabell);
    }

    @Override
    public int antallElementer() {
        return set.size();
    }


}
