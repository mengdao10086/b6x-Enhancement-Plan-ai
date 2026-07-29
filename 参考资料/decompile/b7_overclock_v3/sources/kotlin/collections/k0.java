package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k0 implements Iterator<Integer>, jk.a {
    @yt.k
    public final Integer a() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
