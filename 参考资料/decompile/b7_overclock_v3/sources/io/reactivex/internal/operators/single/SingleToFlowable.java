package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleToFlowable<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0<? extends T> f34982b;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements l0<T> {
        private static final long serialVersionUID = 187782011903685568L;
        public io.reactivex.disposables.b upstream;

        public SingleToFlowableObserver(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.upstream.dispose();
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
            c(t10);
        }
    }

    public SingleToFlowable(o0<? extends T> o0Var) {
        this.f34982b = o0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f34982b.a(new SingleToFlowableObserver(dVar));
    }
}
