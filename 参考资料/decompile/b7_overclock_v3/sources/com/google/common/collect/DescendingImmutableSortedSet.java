package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    public DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e10) {
        return this.forward.floor(e10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return this.forward.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e10) {
        return this.forward.ceiling(e10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e10, boolean z10) {
        return this.forward.tailSet((Object) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e10) {
        return this.forward.lower(e10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@NullableDecl Object obj) {
        int iIndexOf = this.forward.indexOf(obj);
        return iIndexOf == -1 ? iIndexOf : (size() - 1) - iIndexOf;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e10) {
        return this.forward.higher(e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E e10, boolean z10, E e11, boolean z11) {
        return this.forward.subSet((Object) e11, z11, (Object) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E e10, boolean z10) {
        return this.forward.headSet((Object) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }
}
