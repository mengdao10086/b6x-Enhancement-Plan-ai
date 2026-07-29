package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableMergeArray extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g[] f33054a;

    public static final class InnerCompletableObserver extends AtomicInteger implements xi.d {
        private static final long serialVersionUID = -8360547806504310570L;
        public final xi.d downstream;
        public final AtomicBoolean once;
        public final io.reactivex.disposables.a set;

        public InnerCompletableObserver(xi.d dVar, AtomicBoolean atomicBoolean, io.reactivex.disposables.a aVar, int i10) {
            this.downstream = dVar;
            this.once = atomicBoolean;
            this.set = aVar;
            lazySet(i10);
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.downstream.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.downstream.onError(th2);
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.set.b(bVar);
        }
    }

    public CompletableMergeArray(xi.g[] gVarArr) {
        this.f33054a = gVarArr;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(dVar, new AtomicBoolean(), aVar, this.f33054a.length + 1);
        dVar.onSubscribe(aVar);
        for (xi.g gVar : this.f33054a) {
            if (aVar.isDisposed()) {
                return;
            }
            if (gVar == null) {
                aVar.dispose();
                innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                return;
            }
            gVar.a(innerCompletableObserver);
        }
        innerCompletableObserver.onComplete();
    }
}
