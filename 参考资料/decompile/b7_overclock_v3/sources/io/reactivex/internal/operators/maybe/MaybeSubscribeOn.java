package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33884b;

    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.t<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8571289934935992137L;
        public final xi.t<? super T> downstream;
        public final SequentialDisposable task = new SequentialDisposable();

        public SubscribeOnMaybeObserver(xi.t<? super T> tVar) {
            this.downstream = tVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.downstream.onSuccess(t10);
        }
    }

    public static final class a<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.w<T> f33886b;

        public a(xi.t<? super T> tVar, xi.w<T> wVar) {
            this.f33885a = tVar;
            this.f33886b = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33886b.a(this.f33885a);
        }
    }

    public MaybeSubscribeOn(xi.w<T> wVar, xi.h0 h0Var) {
        super(wVar);
        this.f33884b = h0Var;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(tVar);
        tVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.a(this.f33884b.f(new a(subscribeOnMaybeObserver, this.f33914a)));
    }
}
