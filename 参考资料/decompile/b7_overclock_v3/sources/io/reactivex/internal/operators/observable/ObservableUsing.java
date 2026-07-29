package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableUsing<T, D> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends D> f34385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super D, ? extends xi.e0<? extends T>> f34386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super D> f34387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34388d;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 5904473792286235046L;
        public final dj.g<? super D> disposer;
        public final xi.g0<? super T> downstream;
        public final boolean eager;
        public final D resource;
        public io.reactivex.disposables.b upstream;

        public UsingObserver(xi.g0<? super T> g0Var, D d10, dj.g<? super D> gVar, boolean z10) {
            this.downstream = g0Var;
            this.resource = d10;
            this.disposer = gVar;
            this.eager = z10;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // xi.g0
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.dispose();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.upstream.dispose();
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.eager) {
                this.downstream.onError(th2);
                this.upstream.dispose();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    th2 = new CompositeException(th2, th3);
                }
            }
            this.upstream.dispose();
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, dj.o<? super D, ? extends xi.e0<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        this.f34385a = callable;
        this.f34386b = oVar;
        this.f34387c = gVar;
        this.f34388d = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        try {
            D dCall = this.f34385a.call();
            try {
                ((xi.e0) io.reactivex.internal.functions.a.g(this.f34386b.apply(dCall), "The sourceSupplier returned a null ObservableSource")).c(new UsingObserver(g0Var, dCall, this.f34387c, this.f34388d));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f34387c.accept(dCall);
                    EmptyDisposable.error(th2, g0Var);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    EmptyDisposable.error(new CompositeException(th2, th3), g0Var);
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptyDisposable.error(th4, g0Var);
        }
    }
}
