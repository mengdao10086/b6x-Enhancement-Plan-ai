package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, K> f34781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super K, ? super K> f34782c;

    public static final class a<T, K> extends gj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, K> f34783f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.d<? super K, ? super K> f34784g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public K f34785h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f34786i;

        public a(xi.g0<? super T> g0Var, dj.o<? super T, K> oVar, dj.d<? super K, ? super K> dVar) {
            super(g0Var);
            this.f34783f = oVar;
            this.f34784g = dVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f29563d) {
                return;
            }
            if (this.f29564e != 0) {
                this.f29560a.onNext((Object) t10);
                return;
            }
            try {
                K kApply = this.f34783f.apply(t10);
                if (this.f34786i) {
                    boolean zA = this.f34784g.a(this.f34785h, kApply);
                    this.f34785h = kApply;
                    if (zA) {
                        return;
                    }
                } else {
                    this.f34786i = true;
                    this.f34785h = kApply;
                }
                this.f29560a.onNext((Object) t10);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f29562c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f34783f.apply(tPoll);
                if (!this.f34786i) {
                    this.f34786i = true;
                    this.f34785h = kApply;
                    return tPoll;
                }
                if (!this.f34784g.a(this.f34785h, kApply)) {
                    this.f34785h = kApply;
                    return tPoll;
                }
                this.f34785h = kApply;
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public y(xi.e0<T> e0Var, dj.o<? super T, K> oVar, dj.d<? super K, ? super K> dVar) {
        super(e0Var);
        this.f34781b = oVar;
        this.f34782c = dVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34781b, this.f34782c));
    }
}
