package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRepeat<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34279b;

    public static final class RepeatObserver<T> extends AtomicInteger implements xi.g0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final xi.g0<? super T> downstream;
        public long remaining;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        public final SequentialDisposable f34280sd;
        public final xi.e0<? extends T> source;

        public RepeatObserver(xi.g0<? super T> g0Var, long j10, SequentialDisposable sequentialDisposable, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.f34280sd = sequentialDisposable;
            this.source = e0Var;
            this.remaining = j10;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f34280sd.isDisposed()) {
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
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 != 0) {
                a();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34280sd.a(bVar);
        }
    }

    public ObservableRepeat(xi.z<T> zVar, long j10) {
        super(zVar);
        this.f34279b = j10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g0Var.onSubscribe(sequentialDisposable);
        long j10 = this.f34279b;
        new RepeatObserver(g0Var, j10 != Long.MAX_VALUE ? j10 - 1 : Long.MAX_VALUE, sequentialDisposable, this.f34421a).a();
    }
}
