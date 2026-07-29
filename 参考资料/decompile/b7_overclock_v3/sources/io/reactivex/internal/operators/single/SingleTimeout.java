package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleTimeout<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f34977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0<? extends T> f34978e;

    public static final class TimeoutMainObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 37497744973048446L;
        public final l0<? super T> downstream;
        public final TimeoutFallbackObserver<T> fallback;
        public o0<? extends T> other;
        public final AtomicReference<io.reactivex.disposables.b> task = new AtomicReference<>();
        public final long timeout;
        public final TimeUnit unit;

        public static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            public final l0<? super T> downstream;

            public TimeoutFallbackObserver(l0<? super T> l0Var) {
                this.downstream = l0Var;
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.downstream.onError(th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.l0
            public void onSuccess(T t10) {
                this.downstream.onSuccess(t10);
            }
        }

        public TimeoutMainObserver(l0<? super T> l0Var, o0<? extends T> o0Var, long j10, TimeUnit timeUnit) {
            this.downstream = l0Var;
            this.other = o0Var;
            this.timeout = j10;
            this.unit = timeUnit;
            if (o0Var != null) {
                this.fallback = new TimeoutFallbackObserver<>(l0Var);
            } else {
                this.fallback = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(th2);
            }
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
                return;
            }
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t10);
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
                return;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            o0<? extends T> o0Var = this.other;
            if (o0Var == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.e(this.timeout, this.unit)));
            } else {
                this.other = null;
                o0Var.a(this.fallback);
            }
        }
    }

    public SingleTimeout(o0<T> o0Var, long j10, TimeUnit timeUnit, h0 h0Var, o0<? extends T> o0Var2) {
        this.f34974a = o0Var;
        this.f34975b = j10;
        this.f34976c = timeUnit;
        this.f34977d = h0Var;
        this.f34978e = o0Var2;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(l0Var, this.f34978e, this.f34975b, this.f34976c);
        l0Var.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.f34977d.g(timeoutMainObserver, this.f34975b, this.f34976c));
        this.f34974a.a(timeoutMainObserver);
    }
}
