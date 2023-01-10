package deque;

import java.util.Iterator;

public interface Deque<T> {

    public void addFirst(T item);

    public void addLast(T item);

    default public boolean isEmpty() {
        return size() == 0;
    }

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public void set(int index, T toSet);

    public Iterator<T> iterator();

    public boolean equals(Object o);


}

