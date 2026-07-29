package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class h1<T> extends io.reactivex.internal.operators.flowable.a<T, lj.d<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.h0 f33611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33612d;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super lj.d<T>> f33613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimeUnit f33614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.h0 f33615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f33616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f33617e;

        public a(bu.d<? super lj.d<T>> dVar, TimeUnit timeUnit, xi.h0 h0Var) {
            this.f33613a = dVar;
            this.f33615c = h0Var;
            this.f33614b = timeUnit;
        }

        @Override // bu.e
        public void cancel() {
            this.f33616d.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33613a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33613a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            long jE = this.f33615c.e(this.f33614b);
            long j10 = this.f33617e;
            this.f33617e = jE;
            this.f33613a.onNext(new lj.d(t10, jE - j10, this.f33614b));
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33616d, eVar)) {
                this.f33617e = this.f33615c.e(this.f33614b);
                this.f33616d = eVar;
                this.f33613a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33616d.request(j10);
        }
    }

    public h1(xi.j<T> jVar, TimeUnit timeUnit, xi.h0 h0Var) {
        super(jVar);
        this.f33611c = h0Var;
        this.f33612d = timeUnit;
    }

    @Override // xi.j
    public void k6(bu.d<? super lj.d<T>> dVar) {
        this.f33524b.j6(new a(dVar, this.f33612d, this.f33611c));
    }
}
