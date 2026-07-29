package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class j0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    public static final class a<T> implements xi.o<T>, fj.l<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bu.e f33633b;

        public a(bu.d<? super T> dVar) {
            this.f33632a = dVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33633b.cancel();
        }

        @Override // fj.o
        public void clear() {
        }

        @Override // fj.o
        public boolean isEmpty() {
            return true;
        }

        @Override // fj.o
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // bu.d
        public void onComplete() {
            this.f33632a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33632a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33633b, eVar)) {
                this.f33633b = eVar;
                this.f33632a.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() {
            return null;
        }

        @Override // bu.e
        public void request(long j10) {
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return i10 & 2;
        }

        @Override // fj.o
        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public j0(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar));
    }
}
