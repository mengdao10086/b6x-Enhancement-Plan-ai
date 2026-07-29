package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final V apply(K k10) {
        return getUnchecked(k10);
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap linkedHashMapNewLinkedHashMap = Maps.newLinkedHashMap();
        for (K k10 : iterable) {
            if (!linkedHashMapNewLinkedHashMap.containsKey(k10)) {
                linkedHashMapNewLinkedHashMap.put(k10, get(k10));
            }
        }
        return ImmutableMap.copyOf((Map) linkedHashMapNewLinkedHashMap);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k10) {
        try {
            return get(k10);
        } catch (ExecutionException e10) {
            throw new UncheckedExecutionException(e10.getCause());
        }
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k10) {
        throw new UnsupportedOperationException();
    }
}
