package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class i0<T> implements Iterable<h0<? extends T>>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ik.a<Iterator<T>> f37725a;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(@yt.k ik.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.f0.p(iteratorFactory, "iteratorFactory");
        this.f37725a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @yt.k
    public Iterator<h0<T>> iterator() {
        return new j0(this.f37725a.o());
    }
}
