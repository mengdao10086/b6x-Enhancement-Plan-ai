package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends xi.i0<Boolean> implements fj.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f33576b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Boolean> f33577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33580d;

        public a(xi.l0<? super Boolean> l0Var, dj.r<? super T> rVar) {
            this.f33577a = l0Var;
            this.f33578b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33579c.cancel();
            this.f33579c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33579c == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33580d) {
                return;
            }
            this.f33580d = true;
            this.f33579c = SubscriptionHelper.CANCELLED;
            this.f33577a.onSuccess(Boolean.TRUE);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33580d) {
                kj.a.Y(th2);
                return;
            }
            this.f33580d = true;
            this.f33579c = SubscriptionHelper.CANCELLED;
            this.f33577a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33580d) {
                return;
            }
            try {
                if (this.f33578b.a(t10)) {
                    return;
                }
                this.f33580d = true;
                this.f33579c.cancel();
                this.f33579c = SubscriptionHelper.CANCELLED;
                this.f33577a.onSuccess(Boolean.FALSE);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33579c.cancel();
                this.f33579c = SubscriptionHelper.CANCELLED;
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33579c, eVar)) {
                this.f33579c = eVar;
                this.f33577a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public e(xi.j<T> jVar, dj.r<? super T> rVar) {
        this.f33575a = jVar;
        this.f33576b = rVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        this.f33575a.j6(new a(l0Var, this.f33576b));
    }

    @Override // fj.b
    public xi.j<Boolean> d() {
        return kj.a.S(new FlowableAll(this.f33575a, this.f33576b));
    }
}
