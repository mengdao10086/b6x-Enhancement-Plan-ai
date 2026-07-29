package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatWithCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.g f33208c;

    public FlowableConcatWithCompletable(xi.j<T> jVar, xi.g gVar) {
        super(jVar);
        this.f33208c = gVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ConcatWithSubscriber(dVar, this.f33208c));
    }

    public static final class ConcatWithSubscriber<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.o<T>, xi.d, bu.e {
        private static final long serialVersionUID = -7346385463600070225L;
        public final bu.d<? super T> downstream;
        public boolean inCompletable;
        public xi.g other;
        public bu.e upstream;

        public ConcatWithSubscriber(bu.d<? super T> dVar, xi.g gVar) {
            this.downstream = dVar;
            this.other = gVar;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            xi.g gVar = this.other;
            this.other = null;
            gVar.a(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.upstream.request(j10);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
