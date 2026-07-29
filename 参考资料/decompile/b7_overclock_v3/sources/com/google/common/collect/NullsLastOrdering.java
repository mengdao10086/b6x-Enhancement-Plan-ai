package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> ordering;

    public NullsLastOrdering(Ordering<? super T> ordering) {
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@NullableDecl T t10, @NullableDecl T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return 1;
        }
        if (t11 == null) {
            return -1;
        }
        return this.ordering.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.ordering.equals(((NullsLastOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
