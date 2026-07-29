package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableConcatIterable extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends xi.g> f33041a;

    public static final class ConcatInnerObserver extends AtomicInteger implements xi.d {
        private static final long serialVersionUID = -7965400327305809232L;
        public final xi.d downstream;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        public final SequentialDisposable f33042sd = new SequentialDisposable();
        public final Iterator<? extends xi.g> sources;

        public ConcatInnerObserver(xi.d dVar, Iterator<? extends xi.g> it2) {
            this.downstream = dVar;
            this.sources = it2;
        }

        public void a() {
            if (!this.f33042sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends xi.g> it2 = this.sources;
                while (!this.f33042sd.isDisposed()) {
                    try {
                        if (!it2.hasNext()) {
                            this.downstream.onComplete();
                            return;
                        }
                        try {
                            ((xi.g) io.reactivex.internal.functions.a.g(it2.next(), "The CompletableSource returned is null")).a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.downstream.onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        this.downstream.onError(th3);
                        return;
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
            this.f33042sd.a(bVar);
        }
    }

    public CompletableConcatIterable(Iterable<? extends xi.g> iterable) {
        this.f33041a = iterable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(dVar, (Iterator) io.reactivex.internal.functions.a.g(this.f33041a.iterator(), "The iterator returned is null"));
            dVar.onSubscribe(concatInnerObserver.f33042sd);
            concatInnerObserver.a();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, dVar);
        }
    }
}
