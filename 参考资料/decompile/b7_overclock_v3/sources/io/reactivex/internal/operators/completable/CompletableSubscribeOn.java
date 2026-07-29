package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableSubscribeOn extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f33061b;

    public static final class SubscribeOnObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        public final xi.d downstream;
        public final xi.g source;
        public final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnObserver(xi.d dVar, xi.g gVar) {
            this.downstream = dVar;
            this.source = gVar;
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

        @Override // xi.d, xi.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public CompletableSubscribeOn(xi.g gVar, h0 h0Var) {
        this.f33060a = gVar;
        this.f33061b = h0Var;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(dVar, this.f33060a);
        dVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.a(this.f33061b.f(subscribeOnObserver));
    }
}
