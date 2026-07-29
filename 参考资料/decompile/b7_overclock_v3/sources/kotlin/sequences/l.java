package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T1, T2, V> implements m<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T1> f38097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final m<T2> f38098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ik.p<T1, T2, V> f38099c;

    public static final class a implements Iterator<V>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T1> f38100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final Iterator<T2> f38101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l<T1, T2, V> f38102c;

        public a(l<T1, T2, V> lVar) {
            this.f38102c = lVar;
            this.f38100a = lVar.f38097a.iterator();
            this.f38101b = lVar.f38098b.iterator();
        }

        @yt.k
        public final Iterator<T1> a() {
            return this.f38100a;
        }

        @yt.k
        public final Iterator<T2> b() {
            return this.f38101b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38100a.hasNext() && this.f38101b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) this.f38102c.f38099c.r0(this.f38100a.next(), this.f38101b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@yt.k m<? extends T1> sequence1, @yt.k m<? extends T2> sequence2, @yt.k ik.p<? super T1, ? super T2, ? extends V> transform) {
        f0.p(sequence1, "sequence1");
        f0.p(sequence2, "sequence2");
        f0.p(transform, "transform");
        this.f38097a = sequence1;
        this.f38098b = sequence2;
        this.f38099c = transform;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<V> iterator() {
        return new a(this);
    }
}
