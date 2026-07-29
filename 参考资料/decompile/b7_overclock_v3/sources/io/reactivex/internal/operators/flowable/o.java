package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T> extends xi.i0<Long> implements fj.b<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33709a;

    public static final class a implements xi.o<Object>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Long> f33710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f33712c;

        public a(xi.l0<? super Long> l0Var) {
            this.f33710a = l0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33711b.cancel();
            this.f33711b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33711b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33711b = SubscriptionHelper.CANCELLED;
            this.f33710a.onSuccess(Long.valueOf(this.f33712c));
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33711b = SubscriptionHelper.CANCELLED;
            this.f33710a.onError(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            this.f33712c++;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33711b, eVar)) {
                this.f33711b = eVar;
                this.f33710a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public o(xi.j<T> jVar) {
        this.f33709a = jVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Long> l0Var) {
        this.f33709a.j6(new a(l0Var));
    }

    @Override // fj.b
    public xi.j<Long> d() {
        return kj.a.S(new FlowableCount(this.f33709a));
    }
}
