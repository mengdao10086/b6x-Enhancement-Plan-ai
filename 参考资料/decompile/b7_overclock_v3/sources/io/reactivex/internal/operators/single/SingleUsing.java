package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleUsing<T, U> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<U> f34987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super U, ? extends o0<? extends T>> f34988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super U> f34989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34990d;

    public static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5331524057054083935L;
        public final dj.g<? super U> disposer;
        public final l0<? super T> downstream;
        public final boolean eager;
        public io.reactivex.disposables.b upstream;

        public UsingSingleObserver(l0<? super T> l0Var, U u6, boolean z10, dj.g<? super U> gVar) {
            super(u6);
            this.downstream = l0Var;
            this.eager = z10;
            this.disposer = gVar;
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

        @Override // xi.l0
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

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
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

    public SingleUsing(Callable<U> callable, dj.o<? super U, ? extends o0<? extends T>> oVar, dj.g<? super U> gVar, boolean z10) {
        this.f34987a = callable;
        this.f34988b = oVar;
        this.f34989c = gVar;
        this.f34990d = z10;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        try {
            U uCall = this.f34987a.call();
            try {
                ((o0) io.reactivex.internal.functions.a.g(this.f34988b.apply(uCall), "The singleFunction returned a null SingleSource")).a(new UsingSingleObserver(l0Var, uCall, this.f34990d, this.f34989c));
            } catch (Throwable th2) {
                th = th2;
                io.reactivex.exceptions.a.b(th);
                if (this.f34990d) {
                    try {
                        this.f34989c.accept(uCall);
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        th = new CompositeException(th, th3);
                    }
                }
                EmptyDisposable.error(th, l0Var);
                if (this.f34990d) {
                    return;
                }
                try {
                    this.f34989c.accept(uCall);
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    kj.a.Y(th4);
                }
            }
        } catch (Throwable th5) {
            io.reactivex.exceptions.a.b(th5);
            EmptyDisposable.error(th5, l0Var);
        }
    }
}
