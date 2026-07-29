package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.forwardOrder.compare(t11, t10);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e10, E e11) {
        return (E) this.forwardOrder.min(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e10, E e11) {
        return (E) this.forwardOrder.max(e10, e11);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e10, E e11, E e12, E... eArr) {
        return (E) this.forwardOrder.min(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e10, E e11, E e12, E... eArr) {
        return (E) this.forwardOrder.max(e10, e11, e12, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it2) {
        return (E) this.forwardOrder.min(it2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it2) {
        return (E) this.forwardOrder.max(it2);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
