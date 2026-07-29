package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDoOnDispose<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f34945b;

    public static final class DoOnDisposeObserver<T> extends AtomicReference<dj.a> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8583764624474935784L;
        public final l0<? super T> downstream;
        public io.reactivex.disposables.b upstream;

        public DoOnDisposeObserver(l0<? super T> l0Var, dj.a aVar) {
            this.downstream = l0Var;
            lazySet(aVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            dj.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
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
        }
    }

    public SingleDoOnDispose(o0<T> o0Var, dj.a aVar) {
        this.f34944a = o0Var;
        this.f34945b = aVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34944a.a(new DoOnDisposeObserver(l0Var, this.f34945b));
    }
}
