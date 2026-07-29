package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet() {
            super(ForwardingNavigableSet.this);
        }
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e10) {
        return delegate().ceiling(e10);
    }

    @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e10) {
        return delegate().floor(e10);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e10, boolean z10) {
        return delegate().headSet(e10, z10);
    }

    @Override // java.util.NavigableSet
    public E higher(E e10) {
        return delegate().higher(e10);
    }

    @Override // java.util.NavigableSet
    public E lower(E e10) {
        return delegate().lower(e10);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return delegate().pollLast();
    }

    public E standardCeiling(E e10) {
        return (E) Iterators.getNext(tailSet(e10, true).iterator(), null);
    }

    public E standardFirst() {
        return iterator().next();
    }

    public E standardFloor(E e10) {
        return (E) Iterators.getNext(headSet(e10, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(E e10) {
        return headSet(e10, false);
    }

    public E standardHigher(E e10) {
        return (E) Iterators.getNext(tailSet(e10, false).iterator(), null);
    }

    public E standardLast() {
        return descendingIterator().next();
    }

    public E standardLower(E e10) {
        return (E) Iterators.getNext(headSet(e10, false).descendingIterator(), null);
    }

    public E standardPollFirst() {
        return (E) Iterators.pollNext(iterator());
    }

    public E standardPollLast() {
        return (E) Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(E e10, boolean z10, E e11, boolean z11) {
        return tailSet(e10, z10).headSet(e11, z11);
    }

    public SortedSet<E> standardTailSet(E e10) {
        return tailSet(e10, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        return delegate().subSet(e10, z10, e11, z11);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e10, boolean z10) {
        return delegate().tailSet(e10, z10);
    }

    @Override // com.google.common.collect.ForwardingSortedSet
    public SortedSet<E> standardSubSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }
}
