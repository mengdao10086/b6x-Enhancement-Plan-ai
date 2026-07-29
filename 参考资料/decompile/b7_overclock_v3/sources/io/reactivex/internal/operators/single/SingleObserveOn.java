package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleObserveOn<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f34967b;

    public static final class ObserveOnSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        public final l0<? super T> downstream;
        public Throwable error;
        public final h0 scheduler;
        public T value;

        public ObserveOnSingleObserver(l0<? super T> l0Var, h0 h0Var) {
            this.downstream = l0Var;
            this.scheduler = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.error = th2;
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.value = t10;
            DisposableHelper.replace(this, this.scheduler.f(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.downstream.onError(th2);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }
    }

    public SingleObserveOn(o0<T> o0Var, h0 h0Var) {
        this.f34966a = o0Var;
        this.f34967b = h0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34966a.a(new ObserveOnSingleObserver(l0Var, this.f34967b));
    }
}
