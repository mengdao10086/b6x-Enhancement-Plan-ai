package io.reactivex.internal.operators.observable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class n0<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f34620a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f34622b;

        public a(xi.g0<? super T> g0Var) {
            this.f34621a = g0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34622b.cancel();
            this.f34622b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34622b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f34621a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f34621a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f34621a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34622b, eVar)) {
                this.f34622b = eVar;
                this.f34621a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public n0(bu.c<? extends T> cVar) {
        this.f34620a = cVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34620a.d(new a(g0Var));
    }
}
