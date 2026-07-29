package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class x0<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends U> f34769b;

    public static final class a<T, U> extends gj.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, ? extends U> f34770f;

        public a(xi.g0<? super U> g0Var, dj.o<? super T, ? extends U> oVar) {
            super(g0Var);
            this.f34770f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f29563d) {
                return;
            }
            if (this.f29564e != 0) {
                this.f29560a.onNext(null);
                return;
            }
            try {
                this.f29560a.onNext((Object) io.reactivex.internal.functions.a.g(this.f34770f.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public U poll() throws Exception {
            T tPoll = this.f29562c.poll();
            if (tPoll != null) {
                return (U) io.reactivex.internal.functions.a.g(this.f34770f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public x0(xi.e0<T> e0Var, dj.o<? super T, ? extends U> oVar) {
        super(e0Var);
        this.f34769b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34769b));
    }
}
