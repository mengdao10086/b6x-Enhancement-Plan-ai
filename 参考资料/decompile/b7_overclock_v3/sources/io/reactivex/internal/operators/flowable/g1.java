package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class g1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.r<? super T> f33605c;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33609d;

        public a(bu.d<? super T> dVar, dj.r<? super T> rVar) {
            this.f33606a = dVar;
            this.f33607b = rVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33608c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33609d) {
                return;
            }
            this.f33609d = true;
            this.f33606a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33609d) {
                kj.a.Y(th2);
            } else {
                this.f33609d = true;
                this.f33606a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33609d) {
                return;
            }
            try {
                if (this.f33607b.a(t10)) {
                    this.f33606a.onNext(t10);
                    return;
                }
                this.f33609d = true;
                this.f33608c.cancel();
                this.f33606a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33608c.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33608c, eVar)) {
                this.f33608c = eVar;
                this.f33606a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33608c.request(j10);
        }
    }

    public g1(xi.j<T> jVar, dj.r<? super T> rVar) {
        super(jVar);
        this.f33605c = rVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar, this.f33605c));
    }
}
