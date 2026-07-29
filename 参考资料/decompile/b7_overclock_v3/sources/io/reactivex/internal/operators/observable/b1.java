package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class b1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends xi.e0<? extends T>> f34440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34441c;

    public static final class a<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super Throwable, ? extends xi.e0<? extends T>> f34443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f34444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SequentialDisposable f34445d = new SequentialDisposable();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f34447f;

        public a(xi.g0<? super T> g0Var, dj.o<? super Throwable, ? extends xi.e0<? extends T>> oVar, boolean z10) {
            this.f34442a = g0Var;
            this.f34443b = oVar;
            this.f34444c = z10;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34447f) {
                return;
            }
            this.f34447f = true;
            this.f34446e = true;
            this.f34442a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34446e) {
                if (this.f34447f) {
                    kj.a.Y(th2);
                    return;
                } else {
                    this.f34442a.onError(th2);
                    return;
                }
            }
            this.f34446e = true;
            if (this.f34444c && !(th2 instanceof Exception)) {
                this.f34442a.onError(th2);
                return;
            }
            try {
                xi.e0<? extends T> e0VarApply = this.f34443b.apply(th2);
                if (e0VarApply != null) {
                    e0VarApply.c(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th2);
                this.f34442a.onError(nullPointerException);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f34442a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34447f) {
                return;
            }
            this.f34442a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34445d.a(bVar);
        }
    }

    public b1(xi.e0<T> e0Var, dj.o<? super Throwable, ? extends xi.e0<? extends T>> oVar, boolean z10) {
        super(e0Var);
        this.f34440b = oVar;
        this.f34441c = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        a aVar = new a(g0Var, this.f34440b, this.f34441c);
        g0Var.onSubscribe(aVar.f34445d);
        this.f34421a.c(aVar);
    }
}
