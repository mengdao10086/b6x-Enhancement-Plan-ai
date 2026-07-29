package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class c0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.r<? super T> f33547c;

    public static final class a<T> extends hj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.r<? super T> f33548f;

        public a(fj.a<? super T> aVar, dj.r<? super T> rVar) {
            super(aVar);
            this.f33548f = rVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31300d) {
                return false;
            }
            if (this.f31301e != 0) {
                return this.f31297a.m(null);
            }
            try {
                return this.f33548f.a(t10) && this.f31297a.m((Object) t10);
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10)) {
                return;
            }
            this.f31298b.request(1L);
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            fj.l<T> lVar = this.f31299c;
            dj.r<? super T> rVar = this.f33548f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.a(tPoll)) {
                    return tPoll;
                }
                if (this.f31301e == 2) {
                    lVar.request(1L);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public static final class b<T> extends hj.b<T, T> implements fj.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.r<? super T> f33549f;

        public b(bu.d<? super T> dVar, dj.r<? super T> rVar) {
            super(dVar);
            this.f33549f = rVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31305d) {
                return false;
            }
            if (this.f31306e != 0) {
                this.f31302a.onNext(null);
                return true;
            }
            try {
                boolean zA = this.f33549f.a(t10);
                if (zA) {
                    this.f31302a.onNext((Object) t10);
                }
                return zA;
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10)) {
                return;
            }
            this.f31303b.request(1L);
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            fj.l<T> lVar = this.f31304c;
            dj.r<? super T> rVar = this.f33549f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.a(tPoll)) {
                    return tPoll;
                }
                if (this.f31306e == 2) {
                    lVar.request(1L);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public c0(xi.j<T> jVar, dj.r<? super T> rVar) {
        super(jVar);
        this.f33547c = rVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new a((fj.a) dVar, this.f33547c));
        } else {
            this.f33524b.j6(new b(dVar, this.f33547c));
        }
    }
}
