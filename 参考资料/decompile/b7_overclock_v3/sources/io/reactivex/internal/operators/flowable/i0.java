package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class i0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33623b;

        public a(bu.d<? super T> dVar) {
            this.f33622a = dVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33623b.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33622a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33622a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33622a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33623b, eVar)) {
                this.f33623b = eVar;
                this.f33622a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33623b.request(j10);
        }
    }

    public i0(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar));
    }
}
