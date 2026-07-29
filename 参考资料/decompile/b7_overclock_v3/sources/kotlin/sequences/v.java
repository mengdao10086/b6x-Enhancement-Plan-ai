package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class v<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.p<Integer, T, R> f38131b;

    public static final class a implements Iterator<R>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v<T, R> f38134c;

        public a(v<T, R> vVar) {
            this.f38134c = vVar;
            this.f38132a = vVar.f38130a.iterator();
        }

        public final int a() {
            return this.f38133b;
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38132a;
        }

        public final void d(int i10) {
            this.f38133b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38132a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            ik.p pVar = this.f38134c.f38131b;
            int i10 = this.f38133b;
            this.f38133b = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            return (R) pVar.r0(Integer.valueOf(i10), this.f38132a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@yt.k m<? extends T> sequence, @yt.k ik.p<? super Integer, ? super T, ? extends R> transformer) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        this.f38130a = sequence;
        this.f38131b = transformer;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<R> iterator() {
        return new a(this);
    }
}
