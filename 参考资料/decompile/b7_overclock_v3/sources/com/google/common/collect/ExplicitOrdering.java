package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import ee.a;
import java.io.Serializable;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final ImmutableMap<T, Integer> rankMap;

    public ExplicitOrdering(List<T> list) {
        this(Maps.indexMap(list));
    }

    private int rank(T t10) {
        Integer num = this.rankMap.get(t10);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t10);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t10, T t11) {
        return rank(t10) - rank(t11);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + a.f26979d;
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }
}
