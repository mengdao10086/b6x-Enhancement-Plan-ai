package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatWithSingle<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.o0<? extends T> f33210c;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements xi.l0<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        public xi.o0<? extends T> other;
        public final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        public ConcatWithSubscriber(bu.d<? super T> dVar, xi.o0<? extends T> o0Var) {
            super(dVar);
            this.other = o0Var;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, bu.e
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // bu.d
        public void onComplete() {
            this.upstream = SubscriptionHelper.CANCELLED;
            xi.o0<? extends T> o0Var = this.other;
            this.other = null;
            o0Var.a(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext((Object) t10);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.otherDisposable, bVar);
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            a(t10);
        }
    }

    public FlowableConcatWithSingle(xi.j<T> jVar, xi.o0<? extends T> o0Var) {
        super(jVar);
        this.f33210c = o0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ConcatWithSubscriber(dVar, this.f33210c));
    }
}
