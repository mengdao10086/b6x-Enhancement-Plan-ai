package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l0 implements Iterator<Long>, jk.a {
    @yt.k
    public final Long a() {
        return Long.valueOf(b());
    }

    public abstract long b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
