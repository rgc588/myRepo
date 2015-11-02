package com.chengong.algorithm;

import java.util.Iterator;

/**
 * Created by chengong on 9/22/15.
 */
public class PeekingIterator<T> implements Iterator<T> {

    T next;
    Iterator<T> i;

    public PeekingIterator (Iterator<T> iterator) {
        // initialize any member here.
        this.i = iterator;
        if(iterator.hasNext()) next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        T r = next;
        if(i.hasNext()) {
            next = i.next();
        } else {
            next = null;
        }
        return r;
    }

    @Override
    public void remove() {
        if(i.hasNext()) {
            next = i.next();
        } else {
            next = null;
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}
