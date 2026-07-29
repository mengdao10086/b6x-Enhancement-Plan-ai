package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class i0<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends Iterable<? extends R>> f34546b;

    public static final class a<T, R> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super R> f34547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends Iterable<? extends R>> f34548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public io.reactivex.disposables.b f34549c;

        public a(xi.g0<? super R> g0Var, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f34547a = g0Var;
            this.f34548b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34549c.dispose();
            this.f34549c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34549c.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            io.reactivex.disposables.b bVar = this.f34549c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                return;
            }
            this.f34549c = disposableHelper;
            this.f34547a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            io.reactivex.disposables.b bVar = this.f34549c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                kj.a.Y(th2);
            } else {
                this.f34549c = disposableHelper;
                this.f34547a.onError(th2);
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.f34549c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it2 = this.f34548b.apply(t10).iterator();
                xi.g0<? super R> g0Var = this.f34547a;
                while (it2.hasNext()) {
                    try {
                        try {
                            g0Var.onNext((Object) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value"));
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.f34549c.dispose();
                            onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        this.f34549c.dispose();
                        onError(th3);
                        return;
                    }
                }
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                this.f34549c.dispose();
                onError(th4);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34549c, bVar)) {
                this.f34549c = bVar;
                this.f34547a.onSubscribe(this);
            }
        }
    }

    public i0(xi.e0<T> e0Var, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
        super(e0Var);
        this.f34546b = oVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        this.f34421a.c(new a(g0Var, this.f34546b));
    }
}
