package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class n0<T> extends xi.i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<T> f33703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f33704b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f33705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f33706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f33708d;

        public a(xi.l0<? super T> l0Var, T t10) {
            this.f33705a = l0Var;
            this.f33706b = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33707c.cancel();
            this.f33707c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33707c == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33707c = SubscriptionHelper.CANCELLED;
            T t10 = this.f33708d;
            if (t10 != null) {
                this.f33708d = null;
                this.f33705a.onSuccess(t10);
                return;
            }
            T t11 = this.f33706b;
            if (t11 != null) {
                this.f33705a.onSuccess(t11);
            } else {
                this.f33705a.onError(new NoSuchElementException());
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33707c = SubscriptionHelper.CANCELLED;
            this.f33708d = null;
            this.f33705a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33708d = t10;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33707c, eVar)) {
                this.f33707c = eVar;
                this.f33705a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public n0(bu.c<T> cVar, T t10) {
        this.f33703a = cVar;
        this.f33704b = t10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f33703a.d(new a(l0Var, this.f33704b));
    }
}
