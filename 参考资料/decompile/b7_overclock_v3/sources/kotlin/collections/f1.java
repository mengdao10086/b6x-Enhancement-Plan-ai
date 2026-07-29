package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f1 implements Iterator<Short>, jk.a {
    @yt.k
    public final Short a() {
        return Short.valueOf(b());
    }

    public abstract short b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
