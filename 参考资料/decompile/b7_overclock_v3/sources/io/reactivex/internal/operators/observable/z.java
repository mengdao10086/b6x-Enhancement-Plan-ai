package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class z<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f34811b;

    public static final class a<T> extends gj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.g<? super T> f34812f;

        public a(xi.g0<? super T> g0Var, dj.g<? super T> gVar) {
            super(g0Var);
            this.f34812f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            this.f29560a.onNext((Object) t10);
            if (this.f29564e == 0) {
                try {
                    this.f34812f.accept(t10);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f29562c.poll();
            if (tPoll != null) {
                this.f34812f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public z(xi.e0<T> e0Var, dj.g<? super T> gVar) {
        super(e0Var);
        this.f34811b = gVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34811b));
    }
}
