package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p implements Iterator<Byte>, jk.a {
    @yt.k
    public final Byte a() {
        return Byte.valueOf(b());
    }

    public abstract byte b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
