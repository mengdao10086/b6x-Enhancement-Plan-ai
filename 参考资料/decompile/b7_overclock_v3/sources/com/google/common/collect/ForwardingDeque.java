package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    @Override // java.util.Deque
    public void addFirst(E e10) {
        delegate().addFirst(e10);
    }

    @Override // java.util.Deque
    public void addLast(E e10) {
        delegate().addLast(e10);
    }

    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Deque<E> delegate();

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    public E getLast() {
        return delegate().getLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerFirst(E e10) {
        return delegate().offerFirst(e10);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean offerLast(E e10) {
        return delegate().offerLast(e10);
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(E e10) {
        delegate().push(e10);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
