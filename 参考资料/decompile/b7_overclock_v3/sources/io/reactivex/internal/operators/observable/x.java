package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class x<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, K> f34765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f34766c;

    public static final class a<T, K> extends gj.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Collection<? super K> f34767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final dj.o<? super T, K> f34768g;

        public a(xi.g0<? super T> g0Var, dj.o<? super T, K> oVar, Collection<? super K> collection) {
            super(g0Var);
            this.f34768g = oVar;
            this.f34767f = collection;
        }

        @Override // gj.a, fj.o
        public void clear() {
            this.f34767f.clear();
            super.clear();
        }

        @Override // gj.a, xi.g0
        public void onComplete() {
            if (this.f29563d) {
                return;
            }
            this.f29563d = true;
            this.f34767f.clear();
            this.f29560a.onComplete();
        }

        @Override // gj.a, xi.g0
        public void onError(Throwable th2) {
            if (this.f29563d) {
                kj.a.Y(th2);
                return;
            }
            this.f29563d = true;
            this.f34767f.clear();
            this.f29560a.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f29563d) {
                return;
            }
            if (this.f29564e != 0) {
                this.f29560a.onNext(null);
                return;
            }
            try {
                if (this.f34767f.add(io.reactivex.internal.functions.a.g(this.f34768g.apply(t10), "The keySelector returned a null key"))) {
                    this.f29560a.onNext((Object) t10);
                }
            } catch (Throwable th2) {
                c(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f29562c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f34767f.add((Object) io.reactivex.internal.functions.a.g(this.f34768g.apply(tPoll), "The keySelector returned a null key")));
            return tPoll;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public x(xi.e0<T> e0Var, dj.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(e0Var);
        this.f34765b = oVar;
        this.f34766c = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            this.f34421a.c(new a(g0Var, this.f34765b, (Collection) io.reactivex.internal.functions.a.g(this.f34766c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
