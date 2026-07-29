package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class c1<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.r<? super T> f33550c;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.r<? super T> f33552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33554d;

        public a(bu.d<? super T> dVar, dj.r<? super T> rVar) {
            this.f33551a = dVar;
            this.f33552b = rVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33553c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33551a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33551a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33554d) {
                this.f33551a.onNext(t10);
                return;
            }
            try {
                if (this.f33552b.a(t10)) {
                    this.f33553c.request(1L);
                } else {
                    this.f33554d = true;
                    this.f33551a.onNext(t10);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33553c.cancel();
                this.f33551a.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33553c, eVar)) {
                this.f33553c = eVar;
                this.f33551a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33553c.request(j10);
        }
    }

    public c1(xi.j<T> jVar, dj.r<? super T> rVar) {
        super(jVar);
        this.f33550c = rVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar, this.f33550c));
    }
}
