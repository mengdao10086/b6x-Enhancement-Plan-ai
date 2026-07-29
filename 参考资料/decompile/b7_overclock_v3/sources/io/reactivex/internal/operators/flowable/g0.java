package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class g0<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.z<T> f33602b;

    public static final class a<T> implements xi.g0<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public io.reactivex.disposables.b f33604b;

        public a(bu.d<? super T> dVar) {
            this.f33603a = dVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33604b.dispose();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f33603a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f33603a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f33603a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33604b = bVar;
            this.f33603a.onSubscribe(this);
        }

        @Override // bu.e
        public void request(long j10) {
        }
    }

    public g0(xi.z<T> zVar) {
        this.f33602b = zVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33602b.c(new a(dVar));
    }
}
