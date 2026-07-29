package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class t<T, K> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, K> f33743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f33744d;

    public static final class a<T, K> extends hj.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Collection<? super K> f33745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.o<? super T, K> f33746g;

        public a(bu.d<? super T> dVar, dj.o<? super T, K> oVar, Collection<? super K> collection) {
            super(dVar);
            this.f33746g = oVar;
            this.f33745f = collection;
        }

        @Override // hj.b, fj.o
        public void clear() {
            this.f33745f.clear();
            super.clear();
        }

        @Override // hj.b, bu.d
        public void onComplete() {
            if (this.f31305d) {
                return;
            }
            this.f31305d = true;
            this.f33745f.clear();
            this.f31302a.onComplete();
        }

        @Override // hj.b, bu.d
        public void onError(Throwable th2) {
            if (this.f31305d) {
                kj.a.Y(th2);
                return;
            }
            this.f31305d = true;
            this.f33745f.clear();
            this.f31302a.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f31305d) {
                return;
            }
            if (this.f31306e != 0) {
                this.f31302a.onNext(null);
                return;
            }
            try {
                if (this.f33745f.add(io.reactivex.internal.functions.a.g(this.f33746g.apply(t10), "The keySelector returned a null key"))) {
                    this.f31302a.onNext((Object) t10);
                } else {
                    this.f31303b.request(1L);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll;
            while (true) {
                tPoll = this.f31304c.poll();
                if (tPoll == null || this.f33745f.add((Object) io.reactivex.internal.functions.a.g(this.f33746g.apply(tPoll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f31306e == 2) {
                    this.f31303b.request(1L);
                }
            }
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public t(xi.j<T> jVar, dj.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(jVar);
        this.f33743c = oVar;
        this.f33744d = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            this.f33524b.j6(new a(dVar, this.f33743c, (Collection) io.reactivex.internal.functions.a.g(this.f33744d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
