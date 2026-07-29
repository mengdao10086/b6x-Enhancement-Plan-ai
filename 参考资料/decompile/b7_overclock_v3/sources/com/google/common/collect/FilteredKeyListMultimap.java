package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    public FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public List<V> get(K k10) {
        return (List) super.get((Object) k10);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.Multimap
    public List<V> removeAll(@NullableDecl Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((Object) k10, (Iterable) iterable);
    }

    @Override // com.google.common.collect.FilteredKeyMultimap, com.google.common.collect.FilteredMultimap
    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap) super.unfiltered();
    }
}
