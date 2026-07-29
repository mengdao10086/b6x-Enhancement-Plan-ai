package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeUsing<T, D> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends D> f33907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super D, ? extends xi.w<? extends T>> f33908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super D> f33909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33910d;

    public static final class UsingObserver<T, D> extends AtomicReference<Object> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -674404550052917487L;
        public final dj.g<? super D> disposer;
        public final xi.t<? super T> downstream;
        public final boolean eager;
        public io.reactivex.disposables.b upstream;

        public UsingObserver(xi.t<? super T> tVar, D d10, dj.g<? super D> gVar, boolean z10) {
            super(d10);
            this.downstream = tVar;
            this.disposer = gVar;
            this.eager = z10;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.t
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.downstream.onComplete();
            if (this.eager) {
                return;
            }
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    th2 = new CompositeException(th2, th3);
                }
            }
            this.downstream.onError(th2);
            if (this.eager) {
                return;
            }
            a();
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.downstream.onSuccess(t10);
            if (this.eager) {
                return;
            }
            a();
        }
    }

    public MaybeUsing(Callable<? extends D> callable, dj.o<? super D, ? extends xi.w<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        this.f33907a = callable;
        this.f33908b = oVar;
        this.f33909c = gVar;
        this.f33910d = z10;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        try {
            D dCall = this.f33907a.call();
            try {
                ((xi.w) io.reactivex.internal.functions.a.g(this.f33908b.apply(dCall), "The sourceSupplier returned a null MaybeSource")).a(new UsingObserver(tVar, dCall, this.f33909c, this.f33910d));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                if (this.f33910d) {
                    try {
                        this.f33909c.accept(dCall);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        EmptyDisposable.error(new CompositeException(th2, th3), tVar);
                        return;
                    }
                }
                EmptyDisposable.error(th2, tVar);
                if (this.f33910d) {
                    return;
                }
                try {
                    this.f33909c.accept(dCall);
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    kj.a.Y(th4);
                }
            }
        } catch (Throwable th5) {
            io.reactivex.exceptions.a.b(th5);
            EmptyDisposable.error(th5, tVar);
        }
    }
}
