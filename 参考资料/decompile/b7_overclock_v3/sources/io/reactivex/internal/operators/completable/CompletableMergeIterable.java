package io.reactivex.internal.operators.completable;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableMergeIterable extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends xi.g> f33055a;

    public static final class MergeCompletableObserver extends AtomicBoolean implements xi.d {
        private static final long serialVersionUID = -7730517613164279224L;
        public final xi.d downstream;
        public final io.reactivex.disposables.a set;
        public final AtomicInteger wip;

        public MergeCompletableObserver(xi.d dVar, io.reactivex.disposables.a aVar, AtomicInteger atomicInteger) {
            this.downstream = dVar;
            this.set = aVar;
            this.wip = atomicInteger;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.downstream.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
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

    public CompletableMergeIterable(Iterable<? extends xi.g> iterable) {
        this.f33055a = iterable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        dVar.onSubscribe(aVar);
        try {
            Iterator it2 = (Iterator) io.reactivex.internal.functions.a.g(this.f33055a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(dVar, aVar, atomicInteger);
            while (!aVar.isDisposed()) {
                try {
                    if (!it2.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    }
                    if (aVar.isDisposed()) {
                        return;
                    }
                    try {
                        xi.g gVar = (xi.g) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null CompletableSource");
                        if (aVar.isDisposed()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        gVar.a(mergeCompletableObserver);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        aVar.dispose();
                        mergeCompletableObserver.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    aVar.dispose();
                    mergeCompletableObserver.onError(th3);
                    return;
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            dVar.onError(th4);
        }
    }
}
