package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class a0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f34422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super Throwable> f34423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.a f34424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.a f34425e;

    public static final class a<T> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super T> f34427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.g<? super Throwable> f34428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final dj.a f34429d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final dj.a f34430e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public io.reactivex.disposables.b f34431f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f34432g;

        public a(xi.g0<? super T> g0Var, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
            this.f34426a = g0Var;
            this.f34427b = gVar;
            this.f34428c = gVar2;
            this.f34429d = aVar;
            this.f34430e = aVar2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34431f.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34431f.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34432g) {
                return;
            }
            try {
                this.f34429d.run();
                this.f34432g = true;
                this.f34426a.onComplete();
                try {
                    this.f34430e.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                onError(th3);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34432g) {
                kj.a.Y(th2);
                return;
            }
            this.f34432g = true;
            try {
                this.f34428c.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f34426a.onError(th2);
            try {
                this.f34430e.run();
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                kj.a.Y(th4);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34432g) {
                return;
            }
            try {
                this.f34427b.accept(t10);
                this.f34426a.onNext(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34431f.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34431f, bVar)) {
                this.f34431f = bVar;
                this.f34426a.onSubscribe(this);
            }
        }
    }

    public a0(xi.e0<T> e0Var, dj.g<? super T> gVar, dj.g<? super Throwable> gVar2, dj.a aVar, dj.a aVar2) {
        super(e0Var);
        this.f34422b = gVar;
        this.f34423c = gVar2;
        this.f34424d = aVar;
        this.f34425e = aVar2;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34422b, this.f34423c, this.f34424d, this.f34425e));
    }
}
