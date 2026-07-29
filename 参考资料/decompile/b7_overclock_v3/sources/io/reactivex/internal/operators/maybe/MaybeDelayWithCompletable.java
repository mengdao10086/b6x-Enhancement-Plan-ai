package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeDelayWithCompletable<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<T> f33847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.g f33848b;

    public static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = 703409937383992161L;
        public final xi.t<? super T> downstream;
        public final xi.w<T> source;

        public OtherObserver(xi.t<? super T> tVar, xi.w<T> wVar) {
            this.downstream = tVar;
            this.source = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.source.a(new a(this, this.downstream));
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class a<T> implements xi.t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f33849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.t<? super T> f33850b;

        public a(AtomicReference<io.reactivex.disposables.b> atomicReference, xi.t<? super T> tVar) {
            this.f33849a = atomicReference;
            this.f33850b = tVar;
        }

        @Override // xi.t
        public void onComplete() {
            this.f33850b.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.f33850b.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f33849a, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.f33850b.onSuccess(t10);
        }
    }

    public MaybeDelayWithCompletable(xi.w<T> wVar, xi.g gVar) {
        this.f33847a = wVar;
        this.f33848b = gVar;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        this.f33848b.a(new OtherObserver(tVar, this.f33847a));
    }
}
