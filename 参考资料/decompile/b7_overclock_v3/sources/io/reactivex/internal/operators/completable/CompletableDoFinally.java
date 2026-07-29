package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableDoFinally extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f33050b;

    public static final class DoFinallyObserver extends AtomicInteger implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4109457741734051389L;
        public final xi.d downstream;
        public final dj.a onFinally;
        public io.reactivex.disposables.b upstream;

        public DoFinallyObserver(xi.d dVar, dj.a aVar) {
            this.downstream = dVar;
            this.onFinally = aVar;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.downstream.onComplete();
            a();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            a();
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public CompletableDoFinally(xi.g gVar, dj.a aVar) {
        this.f33049a = gVar;
        this.f33050b = aVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33049a.a(new DoFinallyObserver(dVar, this.f33050b));
    }
}
