package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T, R, E> implements m<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, R> f38084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ik.l<R, Iterator<E>> f38085c;

    public static final class a implements Iterator<E>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<T> f38086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public Iterator<? extends E> f38087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i<T, R, E> f38088c;

        public a(i<T, R, E> iVar) {
            this.f38088c = iVar;
            this.f38086a = iVar.f38083a.iterator();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a() {
            /*
                r5 = this;
                java.util.Iterator<? extends E> r0 = r5.f38087b
                r1 = 1
                r2 = 0
                if (r0 == 0) goto Le
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                if (r0 == 0) goto L14
                r0 = 0
                r5.f38087b = r0
            L14:
                java.util.Iterator<? extends E> r0 = r5.f38087b
                if (r0 != 0) goto L45
                java.util.Iterator<T> r0 = r5.f38086a
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L21
                return r2
            L21:
                java.util.Iterator<T> r0 = r5.f38086a
                java.lang.Object r0 = r0.next()
                kotlin.sequences.i<T, R, E> r3 = r5.f38088c
                ik.l r3 = kotlin.sequences.i.c(r3)
                kotlin.sequences.i<T, R, E> r4 = r5.f38088c
                ik.l r4 = kotlin.sequences.i.e(r4)
                java.lang.Object r0 = r4.i(r0)
                java.lang.Object r0 = r3.i(r0)
                java.util.Iterator r0 = (java.util.Iterator) r0
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L14
                r5.f38087b = r0
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.i.a.a():boolean");
        }

        @yt.l
        public final Iterator<E> b() {
            return this.f38087b;
        }

        @yt.k
        public final Iterator<T> d() {
            return this.f38086a;
        }

        public final void e(@yt.l Iterator<? extends E> it2) {
            this.f38087b = it2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it2 = this.f38087b;
            f0.m(it2);
            return it2.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@yt.k m<? extends T> sequence, @yt.k ik.l<? super T, ? extends R> transformer, @yt.k ik.l<? super R, ? extends Iterator<? extends E>> iterator) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        f0.p(iterator, "iterator");
        this.f38083a = sequence;
        this.f38084b = transformer;
        this.f38085c = iterator;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<E> iterator() {
        return new a(this);
    }
}
