package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDoFinally<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f34943b;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4109457741734051389L;
        public final l0<? super T> downstream;
        public final dj.a onFinally;
        public io.reactivex.disposables.b upstream;

        public DoFinallyObserver(l0<? super T> l0Var, dj.a aVar) {
            this.downstream = l0Var;
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

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            a();
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
            a();
        }
    }

    public SingleDoFinally(o0<T> o0Var, dj.a aVar) {
        this.f34942a = o0Var;
        this.f34943b = aVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34942a.a(new DoFinallyObserver(l0Var, this.f34943b));
    }
}
