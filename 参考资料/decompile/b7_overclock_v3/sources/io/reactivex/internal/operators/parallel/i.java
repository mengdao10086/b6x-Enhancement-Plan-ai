package io.reactivex.internal.operators.parallel;

import dj.q;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f34914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super T> f34915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super Throwable> f34916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f34917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.a f34918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final dj.g<? super bu.e> f34919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f34920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final dj.a f34921i;

    public static final class a<T> implements o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f34922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i<T> f34923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f34924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34925d;

        public a(bu.d<? super T> dVar, i<T> iVar) {
            this.f34922a = dVar;
            this.f34923b = iVar;
        }

        @Override // bu.e
        public void cancel() {
            try {
                this.f34923b.f34921i.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            this.f34924c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34925d) {
                return;
            }
            this.f34925d = true;
            try {
                this.f34923b.f34917e.run();
                this.f34922a.onComplete();
                try {
                    this.f34923b.f34918f.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f34922a.onError(th3);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34925d) {
                kj.a.Y(th2);
                return;
            }
            this.f34925d = true;
            try {
                this.f34923b.f34916d.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f34922a.onError(th2);
            try {
                this.f34923b.f34918f.run();
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(th4);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f34925d) {
                return;
            }
            try {
                this.f34923b.f34914b.accept(t10);
                this.f34922a.onNext(t10);
                try {
                    this.f34923b.f34915c.accept(t10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                onError(th3);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34924c, eVar)) {
                this.f34924c = eVar;
                try {
                    this.f34923b.f34919g.accept(eVar);
                    this.f34922a.onSubscribe(this);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    eVar.cancel();
                    this.f34922a.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th2);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            try {
                this.f34923b.f34920h.a(j10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
            this.f34924c.request(j10);
        }
    }

    public i(jj.a<T> aVar, dj.g<? super T> gVar, dj.g<? super T> gVar2, dj.g<? super Throwable> gVar3, dj.a aVar2, dj.a aVar3, dj.g<? super bu.e> gVar4, q qVar, dj.a aVar4) {
        this.f34913a = aVar;
        this.f34914b = (dj.g) io.reactivex.internal.functions.a.g(gVar, "onNext is null");
        this.f34915c = (dj.g) io.reactivex.internal.functions.a.g(gVar2, "onAfterNext is null");
        this.f34916d = (dj.g) io.reactivex.internal.functions.a.g(gVar3, "onError is null");
        this.f34917e = (dj.a) io.reactivex.internal.functions.a.g(aVar2, "onComplete is null");
        this.f34918f = (dj.a) io.reactivex.internal.functions.a.g(aVar3, "onAfterTerminated is null");
        this.f34919g = (dj.g) io.reactivex.internal.functions.a.g(gVar4, "onSubscribe is null");
        this.f34920h = (q) io.reactivex.internal.functions.a.g(qVar, "onRequest is null");
        this.f34921i = (dj.a) io.reactivex.internal.functions.a.g(aVar4, "onCancel is null");
    }

    @Override // jj.a
    public int F() {
        return this.f34913a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                dVarArr2[i10] = new a(dVarArr[i10], this);
            }
            this.f34913a.Q(dVarArr2);
        }
    }
}
