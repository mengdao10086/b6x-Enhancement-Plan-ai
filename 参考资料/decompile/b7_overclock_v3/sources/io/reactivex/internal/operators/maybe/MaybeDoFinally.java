package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.a f33851b;

    public static final class DoFinallyObserver<T> extends AtomicInteger implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 4109457741734051389L;
        public final xi.t<? super T> downstream;
        public final dj.a onFinally;
        public io.reactivex.disposables.b upstream;

        public DoFinallyObserver(xi.t<? super T> tVar, dj.a aVar) {
            this.downstream = tVar;
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

        @Override // xi.t
        public void onComplete() {
            this.downstream.onComplete();
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            a();
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
            a();
        }
    }

    public MaybeDoFinally(xi.w<T> wVar, dj.a aVar) {
        super(wVar);
        this.f33851b = aVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33914a.a(new DoFinallyObserver(tVar, this.f33851b));
    }
}
