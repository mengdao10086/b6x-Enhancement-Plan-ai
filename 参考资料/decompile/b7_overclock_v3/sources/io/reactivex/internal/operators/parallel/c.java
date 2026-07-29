package io.reactivex.internal.operators.parallel;

import dj.r;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r<? super T> f34867b;

    public static abstract class a<T> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r<? super T> f34868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f34869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34870c;

        public a(r<? super T> rVar) {
            this.f34868a = rVar;
        }

        @Override // bu.e
        public final void cancel() {
            this.f34869b.cancel();
        }

        @Override // bu.d
        public final void onNext(T t10) {
            if (m(t10) || this.f34870c) {
                return;
            }
            this.f34869b.request(1L);
        }

        @Override // bu.e
        public final void request(long j10) {
            this.f34869b.request(j10);
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final fj.a<? super T> f34871d;

        public b(fj.a<? super T> aVar, r<? super T> rVar) {
            super(rVar);
            this.f34871d = aVar;
        }

        @Override // fj.a
        public boolean m(T t10) {
            if (!this.f34870c) {
                try {
                    if (this.f34868a.a(t10)) {
                        return this.f34871d.m(t10);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                }
            }
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34870c) {
                return;
            }
            this.f34870c = true;
            this.f34871d.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34870c) {
                kj.a.Y(th2);
            } else {
                this.f34870c = true;
                this.f34871d.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34869b, eVar)) {
                this.f34869b = eVar;
                this.f34871d.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.c$c, reason: collision with other inner class name */
    public static final class C0393c<T> extends a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final bu.d<? super T> f34872d;

        public C0393c(bu.d<? super T> dVar, r<? super T> rVar) {
            super(rVar);
            this.f34872d = dVar;
        }

        @Override // fj.a
        public boolean m(T t10) {
            if (!this.f34870c) {
                try {
                    if (this.f34868a.a(t10)) {
                        this.f34872d.onNext(t10);
                        return true;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                }
            }
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34870c) {
                return;
            }
            this.f34870c = true;
            this.f34872d.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34870c) {
                kj.a.Y(th2);
            } else {
                this.f34870c = true;
                this.f34872d.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34869b, eVar)) {
                this.f34869b = eVar;
                this.f34872d.onSubscribe(this);
            }
        }
    }

    public c(jj.a<T> aVar, r<? super T> rVar) {
        this.f34866a = aVar;
        this.f34867b = rVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34866a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                bu.d<? super T> dVar = dVarArr[i10];
                if (dVar instanceof fj.a) {
                    dVarArr2[i10] = new b((fj.a) dVar, this.f34867b);
                } else {
                    dVarArr2[i10] = new C0393c(dVar, this.f34867b);
                }
            }
            this.f34866a.Q(dVarArr2);
        }
    }
}
