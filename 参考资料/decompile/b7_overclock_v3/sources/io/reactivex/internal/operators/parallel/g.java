package io.reactivex.internal.operators.parallel;

import dj.o;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T, R> extends jj.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends R> f34890b;

    public static final class a<T, R> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fj.a<? super R> f34891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends R> f34892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f34893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34894d;

        public a(fj.a<? super R> aVar, o<? super T, ? extends R> oVar) {
            this.f34891a = aVar;
            this.f34892b = oVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34893c.cancel();
        }

        @Override // fj.a
        public boolean m(T t10) {
            if (this.f34894d) {
                return false;
            }
            try {
                return this.f34891a.m(io.reactivex.internal.functions.a.g(this.f34892b.apply(t10), "The mapper returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
                return false;
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34894d) {
                return;
            }
            this.f34894d = true;
            this.f34891a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34894d) {
                kj.a.Y(th2);
            } else {
                this.f34894d = true;
                this.f34891a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f34894d) {
                return;
            }
            try {
                this.f34891a.onNext(io.reactivex.internal.functions.a.g(this.f34892b.apply(t10), "The mapper returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34893c, eVar)) {
                this.f34893c = eVar;
                this.f34891a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34893c.request(j10);
        }
    }

    public static final class b<T, R> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super R> f34895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends R> f34896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f34897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34898d;

        public b(bu.d<? super R> dVar, o<? super T, ? extends R> oVar) {
            this.f34895a = dVar;
            this.f34896b = oVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34897c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34898d) {
                return;
            }
            this.f34898d = true;
            this.f34895a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34898d) {
                kj.a.Y(th2);
            } else {
                this.f34898d = true;
                this.f34895a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f34898d) {
                return;
            }
            try {
                this.f34895a.onNext(io.reactivex.internal.functions.a.g(this.f34896b.apply(t10), "The mapper returned a null value"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34897c, eVar)) {
                this.f34897c = eVar;
                this.f34895a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34897c.request(j10);
        }
    }

    public g(jj.a<T> aVar, o<? super T, ? extends R> oVar) {
        this.f34889a = aVar;
        this.f34890b = oVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34889a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super R>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                bu.d<? super R> dVar = dVarArr[i10];
                if (dVar instanceof fj.a) {
                    dVarArr2[i10] = new a((fj.a) dVar, this.f34890b);
                } else {
                    dVarArr2[i10] = new b(dVar, this.f34890b);
                }
            }
            this.f34889a.Q(dVarArr2);
        }
    }
}
