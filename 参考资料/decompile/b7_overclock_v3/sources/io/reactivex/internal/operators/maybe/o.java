package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T, R> extends xi.z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends Iterable<? extends R>> f33990b;

    public static final class a<T, R> extends gj.b<R> implements xi.t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super R> f33991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends Iterable<? extends R>> f33992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f33993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile Iterator<? extends R> f33994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f33995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f33996f;

        public a(xi.g0<? super R> g0Var, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f33991a = g0Var;
            this.f33992b = oVar;
        }

        @Override // fj.o
        public void clear() {
            this.f33994d = null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f33995e = true;
            this.f33993c.dispose();
            this.f33993c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f33995e;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f33994d == null;
        }

        @Override // xi.t
        public void onComplete() {
            this.f33991a.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33993c = DisposableHelper.DISPOSED;
            this.f33991a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f33993c, bVar)) {
                this.f33993c = bVar;
                this.f33991a.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            xi.g0<? super R> g0Var = this.f33991a;
            try {
                Iterator<? extends R> it2 = this.f33992b.apply(t10).iterator();
                if (!it2.hasNext()) {
                    g0Var.onComplete();
                    return;
                }
                this.f33994d = it2;
                if (this.f33996f) {
                    g0Var.onNext(null);
                    g0Var.onComplete();
                    return;
                }
                while (!this.f33995e) {
                    try {
                        g0Var.onNext(it2.next());
                        if (this.f33995e) {
                            return;
                        }
                        try {
                            if (!it2.hasNext()) {
                                g0Var.onComplete();
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            g0Var.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        g0Var.onError(th3);
                        return;
                    }
                }
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                g0Var.onError(th4);
            }
        }

        @Override // fj.o
        @bj.f
        public R poll() throws Exception {
            Iterator<? extends R> it2 = this.f33994d;
            if (it2 == null) {
                return null;
            }
            R r10 = (R) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.f33994d = null;
            }
            return r10;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f33996f = true;
            return 2;
        }
    }

    public o(xi.w<T> wVar, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f33989a = wVar;
        this.f33990b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        this.f33989a.a(new a(g0Var, this.f33990b));
    }
}
