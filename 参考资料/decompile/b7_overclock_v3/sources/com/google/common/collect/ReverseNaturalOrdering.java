package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e10, E e11) {
        return (E) NaturalOrdering.INSTANCE.min(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e10, E e11) {
        return (E) NaturalOrdering.INSTANCE.max(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e10, E e11, E e12, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e10, E e11, E e12, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it2) {
        return (E) NaturalOrdering.INSTANCE.min(it2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it2) {
        return (E) NaturalOrdering.INSTANCE.max(it2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
