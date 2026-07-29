package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final ik.a<T> f38089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, T> f38090b;

    public static final class a implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public T f38091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38092b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j<T> f38093c;

        public a(j<T> jVar) {
            this.f38093c = jVar;
        }

        public final void a() {
            T t10;
            if (this.f38092b == -2) {
                t10 = (T) this.f38093c.f38089a.o();
            } else {
                ik.l lVar = this.f38093c.f38090b;
                T t11 = this.f38091a;
                f0.m(t11);
                t10 = (T) lVar.i(t11);
            }
            this.f38091a = t10;
            this.f38092b = t10 == null ? 0 : 1;
        }

        @yt.l
        public final T b() {
            return this.f38091a;
        }

        public final int d() {
            return this.f38092b;
        }

        public final void e(@yt.l T t10) {
            this.f38091a = t10;
        }

        public final void g(int i10) {
            this.f38092b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38092b < 0) {
                a();
            }
            return this.f38092b == 1;
        }

        @Override // java.util.Iterator
        @yt.k
        public T next() {
            if (this.f38092b < 0) {
                a();
            }
            if (this.f38092b == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.f38091a;
            f0.n(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f38092b = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@yt.k ik.a<? extends T> getInitialValue, @yt.k ik.l<? super T, ? extends T> getNextValue) {
        f0.p(getInitialValue, "getInitialValue");
        f0.p(getNextValue, "getNextValue");
        this.f38089a = getInitialValue;
        this.f38090b = getNextValue;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }
}
