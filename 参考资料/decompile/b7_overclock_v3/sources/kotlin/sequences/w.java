package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class w<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, R> f38136b;

    public static final class a implements Iterator<R>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w<T, R> f38138b;

        public a(w<T, R> wVar) {
            this.f38138b = wVar;
            this.f38137a = wVar.f38135a.iterator();
        }

        @yt.k
        public final Iterator<T> a() {
            return this.f38137a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38137a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f38138b.f38136b.i(this.f38137a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(@yt.k m<? extends T> sequence, @yt.k ik.l<? super T, ? extends R> transformer) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        this.f38135a = sequence;
        this.f38136b = transformer;
    }

    @yt.k
    public final <E> m<E> e(@yt.k ik.l<? super R, ? extends Iterator<? extends E>> iterator) {
        f0.p(iterator, "iterator");
        return new i(this.f38135a, this.f38136b, iterator);
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<R> iterator() {
        return new a(this);
    }
}
