package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRepeatUntil<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.e f34281b;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements xi.g0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final xi.g0<? super T> downstream;
        public final xi.e0<? extends T> source;
        public final dj.e stop;
        public final SequentialDisposable upstream;

        public RepeatUntilObserver(xi.g0<? super T> g0Var, dj.e eVar, SequentialDisposable sequentialDisposable, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.upstream = sequentialDisposable;
            this.source = e0Var;
            this.stop = eVar;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.source.c(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }

        @Override // xi.g0
        public void onComplete() {
            try {
                if (this.stop.a()) {
                    this.downstream.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
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
            this.upstream.a(bVar);
        }
    }

    public ObservableRepeatUntil(xi.z<T> zVar, dj.e eVar) {
        super(zVar);
        this.f34281b = eVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g0Var.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(g0Var, this.f34281b, sequentialDisposable, this.f34421a).a();
    }
}
