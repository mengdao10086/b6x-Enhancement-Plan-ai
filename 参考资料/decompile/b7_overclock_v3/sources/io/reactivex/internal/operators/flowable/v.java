package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class v<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super T> f33771c;

    public static final class a<T> extends hj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.g<? super T> f33772f;

        public a(fj.a<? super T> aVar, dj.g<? super T> gVar) {
            super(aVar);
            this.f33772f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            boolean zM = this.f31297a.m((Object) t10);
            try {
                this.f33772f.accept(t10);
            } catch (Throwable th2) {
                c(th2);
            }
            return zM;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            this.f31297a.onNext((Object) t10);
            if (this.f31301e == 0) {
                try {
                    this.f33772f.accept(t10);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f31299c.poll();
            if (tPoll != null) {
                this.f33772f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public static final class b<T> extends hj.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.g<? super T> f33773f;

        public b(bu.d<? super T> dVar, dj.g<? super T> gVar) {
            super(dVar);
            this.f33773f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31305d) {
                return;
            }
            this.f31302a.onNext((Object) t10);
            if (this.f31306e == 0) {
                try {
                    this.f33773f.accept(t10);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f31304c.poll();
            if (tPoll != null) {
                this.f33773f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public v(xi.j<T> jVar, dj.g<? super T> gVar) {
        super(jVar);
        this.f33771c = gVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new a((fj.a) dVar, this.f33771c));
        } else {
            this.f33524b.j6(new b(dVar, this.f33771c));
        }
    }
}
