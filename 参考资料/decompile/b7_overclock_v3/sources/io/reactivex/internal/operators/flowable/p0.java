package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class p0<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends U> f33715c;

    public static final class a<T, U> extends hj.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, ? extends U> f33716f;

        public a(fj.a<? super U> aVar, dj.o<? super T, ? extends U> oVar) {
            super(aVar);
            this.f33716f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31300d) {
                return false;
            }
            try {
                return this.f31297a.m((Object) io.reactivex.internal.functions.a.g(this.f33716f.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31300d) {
                return;
            }
            if (this.f31301e != 0) {
                this.f31297a.onNext(null);
                return;
            }
            try {
                this.f31297a.onNext((Object) io.reactivex.internal.functions.a.g(this.f33716f.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public U poll() throws Exception {
            T tPoll = this.f31299c.poll();
            if (tPoll != null) {
                return (U) io.reactivex.internal.functions.a.g(this.f33716f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public static final class b<T, U> extends hj.b<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, ? extends U> f33717f;

        public b(bu.d<? super U> dVar, dj.o<? super T, ? extends U> oVar) {
            super(dVar);
            this.f33717f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31305d) {
                return;
            }
            if (this.f31306e != 0) {
                this.f31302a.onNext(null);
                return;
            }
            try {
                this.f31302a.onNext((Object) io.reactivex.internal.functions.a.g(this.f33717f.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public U poll() throws Exception {
            T tPoll = this.f31304c.poll();
            if (tPoll != null) {
                return (U) io.reactivex.internal.functions.a.g(this.f33717f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public p0(xi.j<T> jVar, dj.o<? super T, ? extends U> oVar) {
        super(jVar);
        this.f33715c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new a((fj.a) dVar, this.f33715c));
        } else {
            this.f33524b.j6(new b(dVar, this.f33715c));
        }
    }
}
