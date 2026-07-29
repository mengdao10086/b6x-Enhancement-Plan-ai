package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    @CanIgnoreReturnValue
    public boolean offer(E e10) {
        return delegate().offer(e10);
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(E e10) {
        try {
            return add(e10);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
