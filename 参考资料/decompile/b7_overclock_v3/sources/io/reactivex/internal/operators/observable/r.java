package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class r<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.e0<U>> f34677b;

    public static final class a<T, U> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends xi.e0<U>> f34679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34681d = new AtomicReference<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f34682e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f34683f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.r$a$a, reason: collision with other inner class name */
        public static final class C0388a<T, U> extends io.reactivex.observers.d<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a<T, U> f34684b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f34685c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final T f34686d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f34687e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final AtomicBoolean f34688f = new AtomicBoolean();

            public C0388a(a<T, U> aVar, long j10, T t10) {
                this.f34684b = aVar;
                this.f34685c = j10;
                this.f34686d = t10;
            }

            public void b() {
                if (this.f34688f.compareAndSet(false, true)) {
                    this.f34684b.a(this.f34685c, this.f34686d);
                }
            }

            @Override // xi.g0
            public void onComplete() {
                if (this.f34687e) {
                    return;
                }
                this.f34687e = true;
                b();
            }

            @Override // xi.g0
            public void onError(Throwable th2) {
                if (this.f34687e) {
                    kj.a.Y(th2);
                } else {
                    this.f34687e = true;
                    this.f34684b.onError(th2);
                }
            }

            @Override // xi.g0
            public void onNext(U u6) {
                if (this.f34687e) {
                    return;
                }
                this.f34687e = true;
                dispose();
                b();
            }
        }

        public a(xi.g0<? super T> g0Var, dj.o<? super T, ? extends xi.e0<U>> oVar) {
            this.f34678a = g0Var;
            this.f34679b = oVar;
        }

        public void a(long j10, T t10) {
            if (j10 == this.f34682e) {
                this.f34678a.onNext(t10);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34680c.dispose();
            DisposableHelper.dispose(this.f34681d);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34680c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34683f) {
                return;
            }
            this.f34683f = true;
            io.reactivex.disposables.b bVar = this.f34681d.get();
            if (bVar != DisposableHelper.DISPOSED) {
                C0388a c0388a = (C0388a) bVar;
                if (c0388a != null) {
                    c0388a.b();
                }
                DisposableHelper.dispose(this.f34681d);
                this.f34678a.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f34681d);
            this.f34678a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34683f) {
                return;
            }
            long j10 = this.f34682e + 1;
            this.f34682e = j10;
            io.reactivex.disposables.b bVar = this.f34681d.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.f34679b.apply(t10), "The ObservableSource supplied is null");
                C0388a c0388a = new C0388a(this, j10, t10);
                if (this.f34681d.compareAndSet(bVar, c0388a)) {
                    e0Var.c(c0388a);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.f34678a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34680c, bVar)) {
                this.f34680c = bVar;
                this.f34678a.onSubscribe(this);
            }
        }
    }

    public r(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.e0<U>> oVar) {
        super(e0Var);
        this.f34677b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(new io.reactivex.observers.l(g0Var), this.f34677b));
    }
}
