package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.h0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> implements m<h0<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38094a;

    public static final class a implements Iterator<h0<? extends T>>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38096b;

        public a(k<T> kVar) {
            this.f38095a = kVar.f38094a.iterator();
        }

        public final int a() {
            return this.f38096b;
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38095a;
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public h0<T> next() {
            int i10 = this.f38096b;
            this.f38096b = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            return new h0<>(i10, this.f38095a.next());
        }

        public final void e(int i10) {
            this.f38096b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38095a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@yt.k m<? extends T> sequence) {
        f0.p(sequence, "sequence");
        this.f38094a = sequence;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<h0<T>> iterator() {
        return new a(this);
    }
}
