package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleSubscribeOn<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f34971b;

    public static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        public final l0<? super T> downstream;
        public final o0<? extends T> source;
        public final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(l0<? super T> l0Var, o0<? extends T> o0Var) {
            this.downstream = l0Var;
            this.source = o0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
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

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public SingleSubscribeOn(o0<? extends T> o0Var, h0 h0Var) {
        this.f34970a = o0Var;
        this.f34971b = h0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(l0Var, this.f34970a);
        l0Var.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.a(this.f34971b.f(subscribeOnObserver));
    }
}
