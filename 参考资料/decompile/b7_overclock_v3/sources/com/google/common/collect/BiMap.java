package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    @NullableDecl
    V forcePut(@NullableDecl K k10, @NullableDecl V v10);

    BiMap<V, K> inverse();

    @CanIgnoreReturnValue
    @NullableDecl
    V put(@NullableDecl K k10, @NullableDecl V v10);

    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    Set<V> values();
}
