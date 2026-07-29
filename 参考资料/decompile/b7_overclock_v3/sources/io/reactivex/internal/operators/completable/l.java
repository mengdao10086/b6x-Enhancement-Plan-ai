package io.reactivex.internal.operators.completable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T> f33103a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33105b;

        public a(xi.d dVar) {
            this.f33104a = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33105b.cancel();
            this.f33105b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33105b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33104a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33104a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33105b, eVar)) {
                this.f33105b = eVar;
                this.f33104a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public l(bu.c<T> cVar) {
        this.f33103a = cVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33103a.d(new a(dVar));
    }
}
