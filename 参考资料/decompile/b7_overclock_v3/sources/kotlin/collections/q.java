package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q implements Iterator<Character>, jk.a {
    @yt.k
    public final Character a() {
        return Character.valueOf(b());
    }

    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
