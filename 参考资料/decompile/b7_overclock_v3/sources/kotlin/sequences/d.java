package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class d<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38066b;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38068b;

        public a(d<T> dVar) {
            this.f38067a = dVar.f38065a.iterator();
            this.f38068b = dVar.f38066b;
        }

        public final void a() {
            while (this.f38068b > 0 && this.f38067a.hasNext()) {
                this.f38067a.next();
                this.f38068b--;
            }
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38067a;
        }

        public final int d() {
            return this.f38068b;
        }

        public final void e(int i10) {
            this.f38068b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f38067a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f38067a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@yt.k m<? extends T> sequence, int i10) {
        f0.p(sequence, "sequence");
        this.f38065a = sequence;
        this.f38066b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> a(int i10) {
        int i11 = this.f38066b;
        int i12 = i11 + i10;
        return i12 < 0 ? new t(this, i10) : new s(this.f38065a, i11, i12);
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> b(int i10) {
        int i11 = this.f38066b + i10;
        return i11 < 0 ? new d(this, i10) : new d(this.f38065a, i11);
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
