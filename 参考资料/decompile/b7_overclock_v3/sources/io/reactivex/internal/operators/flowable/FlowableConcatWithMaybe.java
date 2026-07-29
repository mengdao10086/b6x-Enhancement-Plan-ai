package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatWithMaybe<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.w<? extends T> f33209c;

    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements xi.t<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        public boolean inMaybe;
        public xi.w<? extends T> other;
        public final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        public ConcatWithSubscriber(bu.d<? super T> dVar, xi.w<? extends T> wVar) {
            super(dVar);
            this.other = wVar;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, bu.e
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            xi.w<? extends T> wVar = this.other;
            this.other = null;
            wVar.a(this);
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

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.otherDisposable, bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            a(t10);
        }
    }

    public FlowableConcatWithMaybe(xi.j<T> jVar, xi.w<? extends T> wVar) {
        super(jVar);
        this.f33209c = wVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ConcatWithSubscriber(dVar, this.f33209c));
    }
}
