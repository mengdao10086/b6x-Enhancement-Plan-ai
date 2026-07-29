package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class m0<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T> f33695a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f33698c;

        public a(xi.t<? super T> tVar) {
            this.f33696a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33697b.cancel();
            this.f33697b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33697b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33697b = SubscriptionHelper.CANCELLED;
            T t10 = this.f33698c;
            if (t10 == null) {
                this.f33696a.onComplete();
            } else {
                this.f33698c = null;
                this.f33696a.onSuccess(t10);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33697b = SubscriptionHelper.CANCELLED;
            this.f33698c = null;
            this.f33696a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33698c = t10;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33697b, eVar)) {
                this.f33697b = eVar;
                this.f33696a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public m0(bu.c<T> cVar) {
        this.f33695a = cVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33695a.d(new a(tVar));
    }
}
