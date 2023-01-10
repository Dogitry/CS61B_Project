package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int _size;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        _size = 0;
    }
    private void insert(T item, int position){
        T[] newItems = (T[]) new Object[items.length+1];
        System.arraycopy(items,0,newItems,0,position);
        newItems[position]=item;

        System.arraycopy(items, position, newItems, position+1, items.length-position);
        items = newItems;
        _size++;
    }
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, _size);
        items = a;
    }
    @Override
    public void addFirst(T item) {
        insert(item,0);
    }

    @Override
    public void addLast(T item) {
        if (_size == items.length) {
            resize(_size + 1);
        }

        items[_size] = item;
        _size = _size + 1;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void printDeque() {
        for(T i:items){
            System.out.print(i+" ");
            System.out.println();
        }
    }
    private void decreaseResize(){
        if(items.length/_size>4){
            resize(_size*2);
        }
    }
    @Override
    public T removeFirst() {
        T[] newItems = (T[]) new Object[items.length-1];
        System.arraycopy(items,1,newItems,0,items.length-1);
        T removed = items[0];
        items = newItems;
        _size--;
        if(_size > 0) decreaseResize();
        return removed;
    }

    @Override
    public T removeLast() {
        T removed = items[items.length-1];
        _size--;
        if(_size > 0) decreaseResize();
        return removed;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
