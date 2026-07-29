package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class h0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f34534b;

    public static final class a<T> extends gj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.r<? super T> f34535f;

        public a(xi.g0<? super T> g0Var, dj.r<? super T> rVar) {
            super(g0Var);
            this.f34535f = rVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f29564e != 0) {
                this.f29560a.onNext(null);
                return;
            }
            try {
                if (this.f34535f.a(t10)) {
                    this.f29560a.onNext((Object) t10);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f29562c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f34535f.a(tPoll));
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public h0(xi.e0<T> e0Var, dj.r<? super T> rVar) {
        super(e0Var);
        this.f34534b = rVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34534b));
    }
}
