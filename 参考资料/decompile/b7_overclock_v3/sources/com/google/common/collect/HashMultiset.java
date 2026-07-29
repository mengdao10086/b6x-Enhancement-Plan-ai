package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true, serializable = true)
public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    public HashMultiset(int i10) {
        super(i10);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public void init(int i10) {
        this.backingMap = new ObjectCountHashMap<>(i10);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E> HashMultiset<E> create(int i10) {
        return new HashMultiset<>(i10);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> hashMultisetCreate = create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(hashMultisetCreate, iterable);
        return hashMultisetCreate;
    }
}
