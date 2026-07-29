package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class y<T> extends xi.q<T> implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33806b;

    public static final class a<T> implements xi.o<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f33810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33811e;

        public a(xi.t<? super T> tVar, long j10) {
            this.f33807a = tVar;
            this.f33808b = j10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33809c.cancel();
            this.f33809c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33809c == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33809c = SubscriptionHelper.CANCELLED;
            if (this.f33811e) {
                return;
            }
            this.f33811e = true;
            this.f33807a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33811e) {
                kj.a.Y(th2);
                return;
            }
            this.f33811e = true;
            this.f33809c = SubscriptionHelper.CANCELLED;
            this.f33807a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33811e) {
                return;
            }
            long j10 = this.f33810d;
            if (j10 != this.f33808b) {
                this.f33810d = j10 + 1;
                return;
            }
            this.f33811e = true;
            this.f33809c.cancel();
            this.f33809c = SubscriptionHelper.CANCELLED;
            this.f33807a.onSuccess(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33809c, eVar)) {
                this.f33809c = eVar;
                this.f33807a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public y(xi.j<T> jVar, long j10) {
        this.f33805a = jVar;
        this.f33806b = j10;
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableElementAt(this.f33805a, this.f33806b, null, false));
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33805a.j6(new a(tVar, this.f33806b));
    }
}
