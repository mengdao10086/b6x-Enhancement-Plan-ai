package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T, U> extends xi.i0<U> implements fj.b<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends U> f33675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.b<? super U, ? super T> f33676c;

    public static final class a<T, U> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super U> f33677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.b<? super U, ? super T> f33678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final U f33679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33681e;

        public a(xi.l0<? super U> l0Var, U u6, dj.b<? super U, ? super T> bVar) {
            this.f33677a = l0Var;
            this.f33678b = bVar;
            this.f33679c = u6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33680d.cancel();
            this.f33680d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33680d == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33681e) {
                return;
            }
            this.f33681e = true;
            this.f33680d = SubscriptionHelper.CANCELLED;
            this.f33677a.onSuccess(this.f33679c);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33681e) {
                kj.a.Y(th2);
                return;
            }
            this.f33681e = true;
            this.f33680d = SubscriptionHelper.CANCELLED;
            this.f33677a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33681e) {
                return;
            }
            try {
                this.f33678b.a(this.f33679c, t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33680d.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33680d, eVar)) {
                this.f33680d = eVar;
                this.f33677a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public l(xi.j<T> jVar, Callable<? extends U> callable, dj.b<? super U, ? super T> bVar) {
        this.f33674a = jVar;
        this.f33675b = callable;
        this.f33676c = bVar;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super U> l0Var) {
        try {
            this.f33674a.j6(new a(l0Var, io.reactivex.internal.functions.a.g(this.f33675b.call(), "The initialSupplier returned a null value"), this.f33676c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, l0Var);
        }
    }

    @Override // fj.b
    public xi.j<U> d() {
        return kj.a.S(new FlowableCollect(this.f33674a, this.f33675b, this.f33676c));
    }
}
