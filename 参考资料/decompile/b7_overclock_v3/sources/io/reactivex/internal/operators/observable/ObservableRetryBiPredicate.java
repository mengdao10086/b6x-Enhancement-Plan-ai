package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryBiPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.d<? super Integer, ? super Throwable> f34302b;

    public static final class RetryBiObserver<T> extends AtomicInteger implements xi.g0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final xi.g0<? super T> downstream;
        public final dj.d<? super Integer, ? super Throwable> predicate;
        public int retries;
        public final xi.e0<? extends T> source;
        public final SequentialDisposable upstream;

        public RetryBiObserver(xi.g0<? super T> g0Var, dj.d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.upstream = sequentialDisposable;
            this.source = e0Var;
            this.predicate = dVar;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.c(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // xi.g0
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            try {
                dj.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i10 = this.retries + 1;
                this.retries = i10;
                if (dVar.a(Integer.valueOf(i10), th2)) {
                    a();
                } else {
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.upstream.a(bVar);
        }
    }

    public ObservableRetryBiPredicate(xi.z<T> zVar, dj.d<? super Integer, ? super Throwable> dVar) {
        super(zVar);
        this.f34302b = dVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g0Var.onSubscribe(sequentialDisposable);
        new RetryBiObserver(g0Var, this.f34302b, sequentialDisposable, this.f34421a).a();
    }
}
