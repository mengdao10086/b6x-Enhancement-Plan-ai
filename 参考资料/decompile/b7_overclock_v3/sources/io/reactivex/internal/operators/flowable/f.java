package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends xi.i0<Boolean> implements fj.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super T> f33585b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super Boolean> f33586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33589d;

        public a(xi.l0<? super Boolean> l0Var, dj.r<? super T> rVar) {
            this.f33586a = l0Var;
            this.f33587b = rVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33588c.cancel();
            this.f33588c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33588c == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33589d) {
                return;
            }
            this.f33589d = true;
            this.f33588c = SubscriptionHelper.CANCELLED;
            this.f33586a.onSuccess(Boolean.FALSE);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33589d) {
                kj.a.Y(th2);
                return;
            }
            this.f33589d = true;
            this.f33588c = SubscriptionHelper.CANCELLED;
            this.f33586a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33589d) {
                return;
            }
            try {
                if (this.f33587b.a(t10)) {
                    this.f33589d = true;
                    this.f33588c.cancel();
                    this.f33588c = SubscriptionHelper.CANCELLED;
                    this.f33586a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33588c.cancel();
                this.f33588c = SubscriptionHelper.CANCELLED;
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33588c, eVar)) {
                this.f33588c = eVar;
                this.f33586a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public f(xi.j<T> jVar, dj.r<? super T> rVar) {
        this.f33584a = jVar;
        this.f33585b = rVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        this.f33584a.j6(new a(l0Var, this.f33585b));
    }

    @Override // fj.b
    public xi.j<Boolean> d() {
        return kj.a.S(new FlowableAny(this.f33584a, this.f33585b));
    }
}
