package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* JADX INFO: loaded from: classes5.dex */
public final class d1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<? extends T> f33570c;

    public static final class a<T> implements xi.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bu.c<? extends T> f33572b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33574d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SubscriptionArbiter f33573c = new SubscriptionArbiter(false);

        public a(bu.d<? super T> dVar, bu.c<? extends T> cVar) {
            this.f33571a = dVar;
            this.f33572b = cVar;
        }

        @Override // bu.d
        public void onComplete() {
            if (!this.f33574d) {
                this.f33571a.onComplete();
            } else {
                this.f33574d = false;
                this.f33572b.d(this);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33571a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33574d) {
                this.f33574d = false;
            }
            this.f33571a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            this.f33573c.k(eVar);
        }
    }

    public d1(xi.j<T> jVar, bu.c<? extends T> cVar) {
        super(jVar);
        this.f33570c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        a aVar = new a(dVar, this.f33570c);
        dVar.onSubscribe(aVar.f33573c);
        this.f33524b.j6(aVar);
    }
}
