package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {

    private class IntNode{
        public IntNode prev;
        public IntNode next;
        public T item;
        public IntNode(T i, int x, IntNode n){
            item = i;
            if(x==1)next = n;
            else if(x==0)prev=n;
        }
    }
    private IntNode sentinel ;
    private int _size;
    public LinkedListDeque(){
        sentinel=new IntNode(null,0,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        _size = 0;
    }
    @Override
    public void addFirst(T item) {
        _size+=1;
        sentinel.next = new IntNode(item,1,sentinel.next);
        sentinel.next.prev=sentinel;
        sentinel.next.next.prev=sentinel.next;
    }

    @Override
    public void addLast(T item) {
        _size+=1;
        sentinel.prev= new IntNode(item,0,sentinel.prev);
        sentinel.prev.next=sentinel;
        sentinel.prev.prev.next=sentinel.prev;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void printDeque() {
        IntNode p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.next.item+" ");
            p=p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if(_size == 0) return null;
        _size-=1;
        T L = sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        return L;
//        return null;
    }

    @Override
    public T removeLast() {
        if(_size == 0) return null;
        _size-=1;
        T L = sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        return L;
        //return null;
    }
    @Override
    public void set(int index,T toSet){
        IntNode p=sentinel;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        p.next.item=toSet;
    }
    @Override
    public T get(int index) {
        IntNode p=sentinel;
        for(int i=0;i<index;i++){
            p=p.next;
        }
        return p.next.item;
//        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
