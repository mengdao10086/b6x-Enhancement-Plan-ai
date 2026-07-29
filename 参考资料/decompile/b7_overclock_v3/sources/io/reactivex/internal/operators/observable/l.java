package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<B> f34574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<U> f34575c;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.d<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f34576b;

        public a(b<T, U, B> bVar) {
            this.f34576b = bVar;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34576b.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34576b.onError(th2);
        }

        @Override // xi.g0
        public void onNext(B b10) {
            this.f34576b.k();
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends gj.k<T, U, U> implements xi.g0<T>, io.reactivex.disposables.b {
        public final xi.e0<B> C2;
        public io.reactivex.disposables.b E7;
        public U F7;
        public io.reactivex.disposables.b K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final Callable<U> f34577v2;

        public b(xi.g0<? super U> g0Var, Callable<U> callable, xi.e0<B> e0Var) {
            super(g0Var, new MpscLinkedQueue());
            this.f34577v2 = callable;
            this.C2 = e0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f29584v1) {
                return;
            }
            this.f29584v1 = true;
            this.E7.dispose();
            this.K2.dispose();
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
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.f34577v2.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u10 = this.F7;
                    if (u10 == null) {
                        return;
                    }
                    this.F7 = u6;
                    h(u10, false, this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.K0.onError(th2);
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
                try {
                    this.F7 = (U) io.reactivex.internal.functions.a.g(this.f34577v2.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.E7 = aVar;
                    this.K0.onSubscribe(this);
                    if (this.f29584v1) {
                        return;
                    }
                    this.C2.c(aVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f29584v1 = true;
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.K0);
                }
            }
        }
    }

    public l(xi.e0<T> e0Var, xi.e0<B> e0Var2, Callable<U> callable) {
        super(e0Var);
        this.f34574b = e0Var2;
        this.f34575c = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        this.f34421a.c(new b(new io.reactivex.observers.l(g0Var), this.f34575c, this.f34574b));
    }
}
