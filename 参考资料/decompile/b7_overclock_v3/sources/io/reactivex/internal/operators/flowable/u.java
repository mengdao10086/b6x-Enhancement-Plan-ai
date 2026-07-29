package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class u<T, K> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, K> f33754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.d<? super K, ? super K> f33755d;

    public static final class a<T, K> extends hj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, K> f33756f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.d<? super K, ? super K> f33757g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public K f33758h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f33759i;

        public a(fj.a<? super T> aVar, dj.o<? super T, K> oVar, dj.d<? super K, ? super K> dVar) {
            super(aVar);
            this.f33756f = oVar;
            this.f33757g = dVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31300d) {
                return false;
            }
            if (this.f31301e != 0) {
                return this.f31297a.m((Object) t10);
            }
            try {
                K kApply = this.f33756f.apply(t10);
                if (this.f33759i) {
                    boolean zA = this.f33757g.a(this.f33758h, kApply);
                    this.f33758h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f33759i = true;
                    this.f33758h = kApply;
                }
                this.f31297a.onNext((Object) t10);
                return true;
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
            while (true) {
                T tPoll = this.f31299c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f33756f.apply(tPoll);
                if (!this.f33759i) {
                    this.f33759i = true;
                    this.f33758h = kApply;
                    return tPoll;
                }
                if (!this.f33757g.a(this.f33758h, kApply)) {
                    this.f33758h = kApply;
                    return tPoll;
                }
                this.f33758h = kApply;
                if (this.f31301e != 1) {
                    this.f31298b.request(1L);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public static final class b<T, K> extends hj.b<T, T> implements fj.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final dj.o<? super T, K> f33760f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.d<? super K, ? super K> f33761g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public K f33762h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f33763i;

        public b(bu.d<? super T> dVar, dj.o<? super T, K> oVar, dj.d<? super K, ? super K> dVar2) {
            super(dVar);
            this.f33760f = oVar;
            this.f33761g = dVar2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // fj.a
        public boolean m(T t10) {
            if (this.f31305d) {
                return false;
            }
            if (this.f31306e != 0) {
                this.f31302a.onNext((Object) t10);
                return true;
            }
            try {
                K kApply = this.f33760f.apply(t10);
                if (this.f33763i) {
                    boolean zA = this.f33761g.a(this.f33762h, kApply);
                    this.f33762h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f33763i = true;
                    this.f33762h = kApply;
                }
                this.f31302a.onNext((Object) t10);
                return true;
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
            while (true) {
                T tPoll = this.f31304c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f33760f.apply(tPoll);
                if (!this.f33763i) {
                    this.f33763i = true;
                    this.f33762h = kApply;
                    return tPoll;
                }
                if (!this.f33761g.a(this.f33762h, kApply)) {
                    this.f33762h = kApply;
                    return tPoll;
                }
                this.f33762h = kApply;
                if (this.f31306e != 1) {
                    this.f31303b.request(1L);
                }
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public u(xi.j<T> jVar, dj.o<? super T, K> oVar, dj.d<? super K, ? super K> dVar) {
        super(jVar);
        this.f33754c = oVar;
        this.f33755d = dVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new a((fj.a) dVar, this.f33754c, this.f33755d));
        } else {
            this.f33524b.j6(new b(dVar, this.f33754c, this.f33755d));
        }
    }
}
