package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @Override // com.google.common.base.Function
    @Deprecated
    V apply(K k10);

    @Override // com.google.common.cache.Cache
    ConcurrentMap<K, V> asMap();

    V get(K k10) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k10);

    void refresh(K k10);
}
