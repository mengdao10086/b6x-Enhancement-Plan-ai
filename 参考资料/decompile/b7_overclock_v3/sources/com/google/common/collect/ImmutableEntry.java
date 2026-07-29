package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(serializable = true)
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    public final K key;

    @NullableDecl
    public final V value;

    public ImmutableEntry(@NullableDecl K k10, @NullableDecl V v10) {
        this.key = k10;
        this.value = v10;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V setValue(V v10) {
        throw new UnsupportedOperationException();
    }
}
