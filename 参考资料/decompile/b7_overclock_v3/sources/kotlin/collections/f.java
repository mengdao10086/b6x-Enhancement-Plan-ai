package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.1")
public abstract class f<E> extends AbstractSet<E> implements Set<E>, jk.h {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
