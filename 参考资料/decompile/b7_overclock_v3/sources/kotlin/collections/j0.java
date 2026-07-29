package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class j0<T> implements Iterator<h0<? extends T>>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Iterator<T> f37726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37727b;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(@yt.k Iterator<? extends T> iterator) {
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        this.f37726a = iterator;
    }

    @Override // java.util.Iterator
    @yt.k
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final h0<T> next() {
        int i10 = this.f37727b;
        this.f37727b = i10 + 1;
        if (i10 < 0) {
            CollectionsKt__CollectionsKt.W();
        }
        return new h0<>(i10, this.f37726a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f37726a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
