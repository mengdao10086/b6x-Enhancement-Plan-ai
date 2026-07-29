package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class z0<T> extends xi.q<T> implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33821a;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f33825d;

        public a(xi.t<? super T> tVar) {
            this.f33822a = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33823b.cancel();
            this.f33823b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33823b == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33824c) {
                return;
            }
            this.f33824c = true;
            this.f33823b = SubscriptionHelper.CANCELLED;
            T t10 = this.f33825d;
            this.f33825d = null;
            if (t10 == null) {
                this.f33822a.onComplete();
            } else {
                this.f33822a.onSuccess(t10);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33824c) {
                kj.a.Y(th2);
                return;
            }
            this.f33824c = true;
            this.f33823b = SubscriptionHelper.CANCELLED;
            this.f33822a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33824c) {
                return;
            }
            if (this.f33825d == null) {
                this.f33825d = t10;
                return;
            }
            this.f33824c = true;
            this.f33823b.cancel();
            this.f33823b = SubscriptionHelper.CANCELLED;
            this.f33822a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33823b, eVar)) {
                this.f33823b = eVar;
                this.f33822a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public z0(xi.j<T> jVar) {
        this.f33821a = jVar;
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableSingle(this.f33821a, null, false));
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33821a.j6(new a(tVar));
    }
}
