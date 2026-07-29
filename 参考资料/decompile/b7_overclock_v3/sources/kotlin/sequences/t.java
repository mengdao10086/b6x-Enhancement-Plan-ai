package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class t<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38121b;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f38122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38123b;

        public a(t<T> tVar) {
            this.f38122a = tVar.f38121b;
            this.f38123b = tVar.f38120a.iterator();
        }

        @yt.k
        public final Iterator<T> a() {
            return this.f38123b;
        }

        public final int b() {
            return this.f38122a;
        }

        public final void d(int i10) {
            this.f38122a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38122a > 0 && this.f38123b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i10 = this.f38122a;
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            this.f38122a = i10 - 1;
            return this.f38123b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(@yt.k m<? extends T> sequence, int i10) {
        f0.p(sequence, "sequence");
        this.f38120a = sequence;
        this.f38121b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> a(int i10) {
        return i10 >= this.f38121b ? this : new t(this.f38120a, i10);
    }

    @Override // kotlin.sequences.e
    @yt.k
    public m<T> b(int i10) {
        int i11 = this.f38121b;
        return i10 >= i11 ? SequencesKt__SequencesKt.g() : new s(this.f38120a, i10, i11);
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
