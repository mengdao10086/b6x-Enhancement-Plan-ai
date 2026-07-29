package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class b1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33538c;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f33540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33541c;

        public a(bu.d<? super T> dVar, long j10) {
            this.f33539a = dVar;
            this.f33540b = j10;
        }

        @Override // bu.e
        public void cancel() {
            this.f33541c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33539a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33539a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.f33540b;
            if (j10 != 0) {
                this.f33540b = j10 - 1;
            } else {
                this.f33539a.onNext(t10);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33541c, eVar)) {
                long j10 = this.f33540b;
                this.f33541c = eVar;
                this.f33539a.onSubscribe(this);
                eVar.request(j10);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33541c.request(j10);
        }
    }

    public b1(xi.j<T> jVar, long j10) {
        super(jVar);
        this.f33538c = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar, this.f33538c));
    }
}
