package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRetryPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.r<? super Throwable> f34303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34304c;

    public static final class RepeatObserver<T> extends AtomicInteger implements xi.g0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final xi.g0<? super T> downstream;
        public final dj.r<? super Throwable> predicate;
        public long remaining;
        public final xi.e0<? extends T> source;
        public final SequentialDisposable upstream;

        public RepeatObserver(xi.g0<? super T> g0Var, long j10, dj.r<? super Throwable> rVar, SequentialDisposable sequentialDisposable, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.upstream = sequentialDisposable;
            this.source = e0Var;
            this.predicate = rVar;
            this.remaining = j10;
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
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 == 0) {
                this.downstream.onError(th2);
                return;
            }
            try {
                if (this.predicate.a(th2)) {
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

    public ObservableRetryPredicate(xi.z<T> zVar, long j10, dj.r<? super Throwable> rVar) {
        super(zVar);
        this.f34303b = rVar;
        this.f34304c = j10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g0Var.onSubscribe(sequentialDisposable);
        new RepeatObserver(g0Var, this.f34304c, this.f34303b, sequentialDisposable, this.f34421a).a();
    }
}
