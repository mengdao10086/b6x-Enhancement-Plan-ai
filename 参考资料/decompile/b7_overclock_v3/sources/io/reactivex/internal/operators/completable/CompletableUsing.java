package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableUsing<R> extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<R> f33067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super R, ? extends xi.g> f33068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super R> f33069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33070d;

    public static final class UsingObserver<R> extends AtomicReference<Object> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = -674404550052917487L;
        public final dj.g<? super R> disposer;
        public final xi.d downstream;
        public final boolean eager;
        public io.reactivex.disposables.b upstream;

        public UsingObserver(xi.d dVar, R r10, dj.g<? super R> gVar, boolean z10) {
            super(r10);
            this.downstream = dVar;
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

        @Override // xi.d, xi.t
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

        @Override // xi.d
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

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Callable<R> callable, dj.o<? super R, ? extends xi.g> oVar, dj.g<? super R> gVar, boolean z10) {
        this.f33067a = callable;
        this.f33068b = oVar;
        this.f33069c = gVar;
        this.f33070d = z10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        try {
            R rCall = this.f33067a.call();
            try {
                ((xi.g) io.reactivex.internal.functions.a.g(this.f33068b.apply(rCall), "The completableFunction returned a null CompletableSource")).a(new UsingObserver(dVar, rCall, this.f33069c, this.f33070d));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                if (this.f33070d) {
                    try {
                        this.f33069c.accept(rCall);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        EmptyDisposable.error(new CompositeException(th2, th3), dVar);
                        return;
                    }
                }
                EmptyDisposable.error(th2, dVar);
                if (this.f33070d) {
                    return;
                }
                try {
                    this.f33069c.accept(rCall);
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    kj.a.Y(th4);
                }
            }
        } catch (Throwable th5) {
            io.reactivex.exceptions.a.b(th5);
            EmptyDisposable.error(th5, dVar);
        }
    }
}
