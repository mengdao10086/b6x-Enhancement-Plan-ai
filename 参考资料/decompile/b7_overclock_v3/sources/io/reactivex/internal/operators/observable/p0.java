package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class p0<T, S> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<S> f34651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.c<S, xi.i<T>, S> f34652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super S> f34653c;

    public static final class a<T, S> implements xi.i<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<S, ? super xi.i<T>, S> f34655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.g<? super S> f34656c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public S f34657d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f34658e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f34659f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f34660g;

        public a(xi.g0<? super T> g0Var, dj.c<S, ? super xi.i<T>, S> cVar, dj.g<? super S> gVar, S s10) {
            this.f34654a = g0Var;
            this.f34655b = cVar;
            this.f34656c = gVar;
            this.f34657d = s10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34658e = true;
        }

        public final void e(S s10) {
            try {
                this.f34656c.accept(s10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }

        public void f() {
            S sApply = this.f34657d;
            if (this.f34658e) {
                this.f34657d = null;
                e(sApply);
                return;
            }
            dj.c<S, ? super xi.i<T>, S> cVar = this.f34655b;
            while (!this.f34658e) {
                this.f34660g = false;
                try {
                    sApply = cVar.apply(sApply, this);
                    if (this.f34659f) {
                        this.f34658e = true;
                        this.f34657d = null;
                        e(sApply);
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f34657d = null;
                    this.f34658e = true;
                    onError(th2);
                    e(sApply);
                    return;
                }
            }
            this.f34657d = null;
            e(sApply);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34658e;
        }

        @Override // xi.i
        public void onComplete() {
            if (this.f34659f) {
                return;
            }
            this.f34659f = true;
            this.f34654a.onComplete();
        }

        @Override // xi.i
        public void onError(Throwable th2) {
            if (this.f34659f) {
                kj.a.Y(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f34659f = true;
            this.f34654a.onError(th2);
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.f34659f) {
                return;
            }
            if (this.f34660g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f34660g = true;
                this.f34654a.onNext(t10);
            }
        }
    }

    public p0(Callable<S> callable, dj.c<S, xi.i<T>, S> cVar, dj.g<? super S> gVar) {
        this.f34651a = callable;
        this.f34652b = cVar;
        this.f34653c = gVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            a aVar = new a(g0Var, this.f34652b, this.f34653c, this.f34651a.call());
            g0Var.onSubscribe(aVar);
            aVar.f();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, g0Var);
        }
    }
}
