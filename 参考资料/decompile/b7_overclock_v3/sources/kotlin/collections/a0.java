package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a0 implements Iterator<Double>, jk.a {
    @yt.k
    public final Double a() {
        return Double.valueOf(b());
    }

    public abstract double b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Double next() {
        return Double.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
