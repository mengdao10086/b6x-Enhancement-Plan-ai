package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class k0<T> extends xi.a implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33654a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33656b;

        public a(xi.d dVar) {
            this.f33655a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33656b.cancel();
            this.f33656b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33656b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33656b = SubscriptionHelper.CANCELLED;
            this.f33655a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33656b = SubscriptionHelper.CANCELLED;
            this.f33655a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33656b, eVar)) {
                this.f33656b = eVar;
                this.f33655a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public k0(xi.j<T> jVar) {
        this.f33654a = jVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33654a.j6(new a(dVar));
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new j0(this.f33654a));
    }
}
