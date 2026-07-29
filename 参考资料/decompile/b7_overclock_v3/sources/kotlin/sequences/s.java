package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class s<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38116c;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s<T> f38119c;

        public a(s<T> sVar) {
            this.f38119c = sVar;
            this.f38117a = sVar.f38114a.iterator();
        }

        public final void a() {
            while (this.f38118b < this.f38119c.f38115b && this.f38117a.hasNext()) {
                this.f38117a.next();
                this.f38118b++;
            }
        }

        @yt.k
        public final Iterator<T> b() {
            return this.f38117a;
        }

        public final int d() {
            return this.f38118b;
        }

        public final void e(int i10) {
            this.f38118b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f38118b < this.f38119c.f38116c && this.f38117a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f38118b >= this.f38119c.f38116c) {
                throw new NoSuchElementException();
            }
            this.f38118b++;
            return this.f38117a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(@yt.k m<? extends T> sequence, int i10, int i11) {
        f0.p(sequence, "sequence");
        this.f38114a = sequence;
        this.f38115b = i10;
        this.f38116c = i11;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i10).toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i11).toString());
        }
        if (i11 >= i10) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i11 + " < " + i10).toString());
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> a(int i10) {
        if (i10 >= f()) {
            return this;
        }
        m<T> mVar = this.f38114a;
        int i11 = this.f38115b;
        return new s(mVar, i11, i10 + i11);
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> b(int i10) {
        return i10 >= f() ? SequencesKt__SequencesKt.g() : new s(this.f38114a, this.f38115b + i10, this.f38116c);
    }

    public final int f() {
        return this.f38116c - this.f38115b;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
