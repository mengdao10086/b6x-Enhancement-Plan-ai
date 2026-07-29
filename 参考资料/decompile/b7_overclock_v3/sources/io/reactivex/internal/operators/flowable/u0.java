package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class u0<T, R> extends xi.i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T> f33764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R f33765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f33766c;

    public static final class a<T, R> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super R> f33767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<R, ? super T, R> f33768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public R f33769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33770d;

        public a(xi.l0<? super R> l0Var, dj.c<R, ? super T, R> cVar, R r10) {
            this.f33767a = l0Var;
            this.f33769c = r10;
            this.f33768b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33770d.cancel();
            this.f33770d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33770d == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            R r10 = this.f33769c;
            if (r10 != null) {
                this.f33769c = null;
                this.f33770d = SubscriptionHelper.CANCELLED;
                this.f33767a.onSuccess(r10);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33769c == null) {
                kj.a.Y(th2);
                return;
            }
            this.f33769c = null;
            this.f33770d = SubscriptionHelper.CANCELLED;
            this.f33767a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            R r10 = this.f33769c;
            if (r10 != null) {
                try {
                    this.f33769c = (R) io.reactivex.internal.functions.a.g(this.f33768b.apply(r10, t10), "The reducer returned a null value");
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f33770d.cancel();
                    onError(th2);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33770d, eVar)) {
                this.f33770d = eVar;
                this.f33767a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public u0(bu.c<T> cVar, R r10, dj.c<R, ? super T, R> cVar2) {
        this.f33764a = cVar;
        this.f33765b = r10;
        this.f33766c = cVar2;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super R> l0Var) {
        this.f33764a.d(new a(l0Var, this.f33766c, this.f33765b));
    }
}
