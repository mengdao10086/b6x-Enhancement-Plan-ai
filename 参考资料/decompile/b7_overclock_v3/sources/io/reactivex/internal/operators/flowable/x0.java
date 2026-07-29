package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class x0<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<T, T, T> f33799c;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<T, T, T> f33801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f33802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f33803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33804e;

        public a(bu.d<? super T> dVar, dj.c<T, T, T> cVar) {
            this.f33800a = dVar;
            this.f33801b = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f33802c.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33804e) {
                return;
            }
            this.f33804e = true;
            this.f33800a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33804e) {
                kj.a.Y(th2);
            } else {
                this.f33804e = true;
                this.f33800a.onError(th2);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33804e) {
                return;
            }
            bu.d<? super T> dVar = this.f33800a;
            T t11 = this.f33803d;
            if (t11 == null) {
                this.f33803d = t10;
                dVar.onNext(t10);
                return;
            }
            try {
                ?? r42 = (T) io.reactivex.internal.functions.a.g(this.f33801b.apply(t11, t10), "The value returned by the accumulator is null");
                this.f33803d = r42;
                dVar.onNext(r42);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f33802c.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33802c, eVar)) {
                this.f33802c = eVar;
                this.f33800a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33802c.request(j10);
        }
    }

    public x0(xi.j<T> jVar, dj.c<T, T, T> cVar) {
        super(jVar);
        this.f33799c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(dVar, this.f33799c));
    }
}
