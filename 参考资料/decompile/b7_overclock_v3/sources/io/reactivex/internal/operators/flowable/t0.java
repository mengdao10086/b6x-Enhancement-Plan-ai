package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class t0<T> extends xi.q<T> implements fj.h<T>, fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<T, T, T> f33748b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<T, T, T> f33750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f33751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33753e;

        public a(xi.t<? super T> tVar, dj.c<T, T, T> cVar) {
            this.f33749a = tVar;
            this.f33750b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33752d.cancel();
            this.f33753e = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33753e;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33753e) {
                return;
            }
            this.f33753e = true;
            T t10 = this.f33751c;
            if (t10 != null) {
                this.f33749a.onSuccess(t10);
            } else {
                this.f33749a.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33753e) {
                kj.a.Y(th2);
            } else {
                this.f33753e = true;
                this.f33749a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33753e) {
                return;
            }
            T t11 = this.f33751c;
            if (t11 == null) {
                this.f33751c = t10;
                return;
            }
            try {
                this.f33751c = (T) io.reactivex.internal.functions.a.g(this.f33750b.apply(t11, t10), "The reducer returned a null value");
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33752d.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33752d, eVar)) {
                this.f33752d = eVar;
                this.f33749a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public t0(xi.j<T> jVar, dj.c<T, T, T> cVar) {
        this.f33747a = jVar;
        this.f33748b = cVar;
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableReduce(this.f33747a, this.f33748b));
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33747a.j6(new a(tVar, this.f33748b));
    }

    @Override // fj.h
    public bu.c<T> source() {
        return this.f33747a;
    }
}
