package adt;

import java.util.Iterator;

public class LinearNode<T> implements Iterable<T> {
    private T data;
    private LinearNode<T> first;
    private LinearNode<T> neste;

    transient int size = 0;

    LinearNode<T> head;

    public LinearNode(T data) {
        this.data = data;
        this.neste = neste;
    }

    public LinearNode() {

    }

    public T getData() {
        return data;
    }

    public LinearNode<T> getNeste() {
        return neste;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(LinearNode<T> nesteData) {
        neste = nesteData;
    }

    public void add(T nyFilm) {
        LinearNode<T> newNode = new LinearNode<>();
        newNode.data = nyFilm;
        newNode.neste = head;
        head = newNode;
        size++;
    }

    public void remove(T element) {
        if (head == null) {
            return;
        }
        if (head.getData().equals(element)) {
            head = head.getNeste();
            size--;
            return;
        }

        LinearNode<T> current = (LinearNode<T>) head;
        LinearNode<T> previous = null;

        while (current != null && !current.getData().equals(element)) {
            previous = current;
            current = current.getNeste();
        }

        if (current == null) {
            System.out.println("Node ikke funnet");
            return;
        }
        try {
            assert previous != null;
            previous.setNext(current.getNeste());
        } catch (NullPointerException e) {
            return;
        }

        size--;
    }

    public void insert(int pos, T data) {
        if (pos < 0 || pos > size) {
            System.out.println("Feil posisjon");
            return;
        }

        LinearNode<T> newNode = new LinearNode<>(data);

        if (pos == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }

        LinearNode<T> current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.getNeste();
        }

        newNode.setNext(current.getNeste());
        current.setNext(newNode);
        size++;
    }

    public int find(int n) {
        LinearNode<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(n)) {
                return index;
            }
            current = current.getNeste();
            index++;
        }
        return -1; //Om ikke funnet
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        String result = "[";
        LinearNode<T> current = head;

        while (current != null) {
            result += current.getData();

            if (current.getNeste() != null) {
                result += ", ";
            }
            current = current.getNeste();
        }
        result += "]";
        return result;
    }

    public Iterator<T> iterator() { //For å iterate enhanced for loops til bruk i Filmarkiv2
        return new Iterator<>() {
            private LinearNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.getData();
                current = current.getNeste();
                return data;
            }
        };
    }
}