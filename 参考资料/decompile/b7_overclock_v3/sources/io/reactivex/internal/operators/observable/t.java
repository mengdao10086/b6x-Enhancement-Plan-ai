package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class t<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34706e;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f34709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0.c f34710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f34711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public io.reactivex.disposables.b f34712f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t$a$a, reason: collision with other inner class name */
        public final class RunnableC0389a implements Runnable {
            public RunnableC0389a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f34707a.onComplete();
                } finally {
                    a.this.f34710d.dispose();
                }
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f34714a;

            public b(Throwable th2) {
                this.f34714a = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f34707a.onError(this.f34714a);
                } finally {
                    a.this.f34710d.dispose();
                }
            }
        }

        public final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f34716a;

            public c(T t10) {
                this.f34716a = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f34707a.onNext(this.f34716a);
            }
        }

        public a(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.f34707a = g0Var;
            this.f34708b = j10;
            this.f34709c = timeUnit;
            this.f34710d = cVar;
            this.f34711e = z10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34712f.dispose();
            this.f34710d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34710d.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34710d.c(new RunnableC0389a(), this.f34708b, this.f34709c);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34710d.c(new b(th2), this.f34711e ? this.f34708b : 0L, this.f34709c);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34710d.c(new c(t10), this.f34708b, this.f34709c);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34712f, bVar)) {
                this.f34712f = bVar;
                this.f34707a.onSubscribe(this);
            }
        }
    }

    public t(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(e0Var);
        this.f34703b = j10;
        this.f34704c = timeUnit;
        this.f34705d = h0Var;
        this.f34706e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(this.f34706e ? g0Var : new io.reactivex.observers.l(g0Var), this.f34703b, this.f34704c, this.f34705d.d(), this.f34706e));
    }
}
