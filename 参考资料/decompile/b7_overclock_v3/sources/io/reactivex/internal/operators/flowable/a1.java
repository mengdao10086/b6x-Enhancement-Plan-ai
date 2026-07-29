package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class a1<T> extends xi.i0<T> implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f33527b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.l0<? super T> f33528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f33529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33531d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public T f33532e;

        public a(xi.l0<? super T> l0Var, T t10) {
            this.f33528a = l0Var;
            this.f33529b = t10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33530c.cancel();
            this.f33530c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33530c == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33531d) {
                return;
            }
            this.f33531d = true;
            this.f33530c = SubscriptionHelper.CANCELLED;
            T t10 = this.f33532e;
            this.f33532e = null;
            if (t10 == null) {
                t10 = this.f33529b;
            }
            if (t10 != null) {
                this.f33528a.onSuccess(t10);
            } else {
                this.f33528a.onError(new NoSuchElementException());
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33531d) {
                kj.a.Y(th2);
                return;
            }
            this.f33531d = true;
            this.f33530c = SubscriptionHelper.CANCELLED;
            this.f33528a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33531d) {
                return;
            }
            if (this.f33532e == null) {
                this.f33532e = t10;
                return;
            }
            this.f33531d = true;
            this.f33530c.cancel();
            this.f33530c = SubscriptionHelper.CANCELLED;
            this.f33528a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33530c, eVar)) {
                this.f33530c = eVar;
                this.f33528a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public a1(xi.j<T> jVar, T t10) {
        this.f33526a = jVar;
        this.f33527b = t10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super T> l0Var) {
        this.f33526a.j6(new a(l0Var, this.f33527b));
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableSingle(this.f33526a, this.f33527b, true));
    }
}
