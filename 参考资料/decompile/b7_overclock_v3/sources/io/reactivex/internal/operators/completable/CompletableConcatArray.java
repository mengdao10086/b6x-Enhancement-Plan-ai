package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableConcatArray extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g[] f33039a;

    public static final class ConcatInnerObserver extends AtomicInteger implements xi.d {
        private static final long serialVersionUID = -7965400327305809232L;
        public final xi.d downstream;
        public int index;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        public final SequentialDisposable f33040sd = new SequentialDisposable();
        public final xi.g[] sources;

        public ConcatInnerObserver(xi.d dVar, xi.g[] gVarArr) {
            this.downstream = dVar;
            this.sources = gVarArr;
        }

        public void a() {
            if (!this.f33040sd.isDisposed() && getAndIncrement() == 0) {
                xi.g[] gVarArr = this.sources;
                while (!this.f33040sd.isDisposed()) {
                    int i10 = this.index;
                    this.index = i10 + 1;
                    if (i10 == gVarArr.length) {
                        this.downstream.onComplete();
                        return;
                    } else {
                        gVarArr[i10].a(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            a();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33040sd.a(bVar);
        }
    }

    public CompletableConcatArray(xi.g[] gVarArr) {
        this.f33039a = gVarArr;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(dVar, this.f33039a);
        dVar.onSubscribe(concatInnerObserver.f33040sd);
        concatInnerObserver.a();
    }
}
