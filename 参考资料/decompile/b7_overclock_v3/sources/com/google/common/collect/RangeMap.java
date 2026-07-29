package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtIncompatible
public interface RangeMap<K extends Comparable, V> {
    Map<Range<K>, V> asDescendingMapOfRanges();

    Map<Range<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@NullableDecl Object obj);

    @NullableDecl
    V get(K k10);

    @NullableDecl
    Map.Entry<Range<K>, V> getEntry(K k10);

    int hashCode();

    void put(Range<K> range, V v10);

    void putAll(RangeMap<K, V> rangeMap);

    void putCoalescing(Range<K> range, V v10);

    void remove(Range<K> range);

    Range<K> span();

    RangeMap<K, V> subRangeMap(Range<K> range);

    String toString();
}
