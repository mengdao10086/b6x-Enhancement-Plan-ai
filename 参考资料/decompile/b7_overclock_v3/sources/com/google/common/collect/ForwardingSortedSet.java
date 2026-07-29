package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    private int unsafeCompare(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Comparator<? super E> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e10) {
        return delegate().headSet(e10);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardContains(@NullableDecl Object obj) {
        try {
            return unsafeCompare(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardRemove(@NullableDecl Object obj) {
        try {
            Iterator<E> it2 = tailSet(obj).iterator();
            if (it2.hasNext() && unsafeCompare(it2.next(), obj) == 0) {
                it2.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Beta
    public SortedSet<E> standardSubSet(E e10, E e11) {
        return tailSet(e10).headSet(e11);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e10, E e11) {
        return delegate().subSet(e10, e11);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e10) {
        return delegate().tailSet(e10);
    }
}
