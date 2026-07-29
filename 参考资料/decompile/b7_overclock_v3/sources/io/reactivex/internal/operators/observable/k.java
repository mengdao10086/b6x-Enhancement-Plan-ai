package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends xi.e0<B>> f34563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f34564c;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.d<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f34565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f34566c;

        public a(b<T, U, B> bVar) {
            this.f34565b = bVar;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34566c) {
                return;
            }
            this.f34566c = true;
            this.f34565b.l();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34566c) {
                kj.a.Y(th2);
            } else {
                this.f34566c = true;
                this.f34565b.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(B b10) {
            if (this.f34566c) {
                return;
            }
            this.f34566c = true;
            dispose();
            this.f34565b.l();
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends gj.k<T, U, U> implements xi.g0<T>, io.reactivex.disposables.b {
        public final Callable<? extends xi.e0<B>> C2;
        public final AtomicReference<io.reactivex.disposables.b> E7;
        public U F7;
        public io.reactivex.disposables.b K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final Callable<U> f34567v2;

        public b(xi.g0<? super U> g0Var, Callable<U> callable, Callable<? extends xi.e0<B>> callable2) {
            super(g0Var, new MpscLinkedQueue());
            this.E7 = new AtomicReference<>();
            this.f34567v2 = callable;
            this.C2 = callable2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f29584v1) {
                return;
            }
            this.f29584v1 = true;
            this.K2.dispose();
            k();
            if (a()) {
                this.f29583k1.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // gj.k, io.reactivex.internal.util.j
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(xi.g0<? super U> g0Var, U u6) {
            this.K0.onNext((Object) u6);
        }

        public void k() {
            DisposableHelper.dispose(this.E7);
        }

        public void l() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.f34567v2.call(), "The buffer supplied is null");
                try {
                    xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.C2.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.E7, aVar)) {
                        synchronized (this) {
                            U u10 = this.F7;
                            if (u10 == null) {
                                return;
                            }
                            this.F7 = u6;
                            e0Var.c(aVar);
                            h(u10, false, this);
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f29584v1 = true;
                    this.K2.dispose();
                    this.K0.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                dispose();
                this.K0.onError(th3);
            }
        }

        @Override // xi.g0
        public void onComplete() {
            synchronized (this) {
                U u6 = this.F7;
                if (u6 == null) {
                    return;
                }
                this.F7 = null;
                this.f29583k1.offer(u6);
                this.C1 = true;
                if (a()) {
                    io.reactivex.internal.util.n.d(this.f29583k1, this.K0, false, this, this);
                }
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            dispose();
            this.K0.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.F7;
                if (u6 == null) {
                    return;
                }
                u6.add(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.K2, bVar)) {
                this.K2 = bVar;
                xi.g0<? super V> g0Var = this.K0;
                try {
                    this.F7 = (U) io.reactivex.internal.functions.a.g(this.f34567v2.call(), "The buffer supplied is null");
                    try {
                        xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.C2.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.E7.set(aVar);
                        g0Var.onSubscribe(this);
                        if (this.f29584v1) {
                            return;
                        }
                        e0Var.c(aVar);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.f29584v1 = true;
                        bVar.dispose();
                        EmptyDisposable.error(th2, g0Var);
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.f29584v1 = true;
                    bVar.dispose();
                    EmptyDisposable.error(th3, g0Var);
                }
            }
        }
    }

    public k(xi.e0<T> e0Var, Callable<? extends xi.e0<B>> callable, Callable<U> callable2) {
        super(e0Var);
        this.f34563b = callable;
        this.f34564c = callable2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        this.f34421a.c(new b(new io.reactivex.observers.l(g0Var), this.f34564c, this.f34563b));
    }
}
