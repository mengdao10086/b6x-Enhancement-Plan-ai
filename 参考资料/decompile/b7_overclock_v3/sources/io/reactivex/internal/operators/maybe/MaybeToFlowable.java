package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeToFlowable<T> extends xi.j<T> implements fj.f<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<T> f33903b;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements xi.t<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        public io.reactivex.disposables.b upstream;

        public MaybeToFlowableSubscriber(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
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
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            c(t10);
        }
    }

    public MaybeToFlowable(xi.w<T> wVar) {
        this.f33903b = wVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33903b.a(new MaybeToFlowableSubscriber(dVar));
    }

    @Override // fj.f
    public xi.w<T> source() {
        return this.f33903b;
    }
}
