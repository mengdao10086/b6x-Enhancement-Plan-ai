package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import xi.g0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMapIterableObservable<T, R> extends xi.z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends Iterable<? extends R>> f34956b;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements l0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public volatile boolean cancelled;
        public final g0<? super R> downstream;

        /* JADX INFO: renamed from: it, reason: collision with root package name */
        public volatile Iterator<? extends R> f34957it;
        public final dj.o<? super T, ? extends Iterable<? extends R>> mapper;
        public boolean outputFused;
        public io.reactivex.disposables.b upstream;

        public FlatMapIterableObserver(g0<? super R> g0Var, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.downstream = g0Var;
            this.mapper = oVar;
        }

        @Override // fj.o
        public void clear() {
            this.f34957it = null;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f34957it == null;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            g0<? super R> g0Var = this.downstream;
            try {
                Iterator<? extends R> it2 = this.mapper.apply(t10).iterator();
                if (!it2.hasNext()) {
                    g0Var.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.f34957it = it2;
                    g0Var.onNext(null);
                    g0Var.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        g0Var.onNext(it2.next());
                        if (this.cancelled) {
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
                this.downstream.onError(th4);
            }
        }

        @Override // fj.o
        @bj.f
        public R poll() throws Exception {
            Iterator<? extends R> it2 = this.f34957it;
            if (it2 == null) {
                return null;
            }
            R r10 = (R) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.f34957it = null;
            }
            return r10;
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(o0<T> o0Var, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f34955a = o0Var;
        this.f34956b = oVar;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        this.f34955a.a(new FlatMapIterableObserver(g0Var, this.f34956b));
    }
}
