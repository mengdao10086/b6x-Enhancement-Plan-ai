package kotlin.collections;

import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.1")
public abstract class c<E> extends java.util.AbstractCollection<E> implements Collection<E>, jk.b {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e10);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
