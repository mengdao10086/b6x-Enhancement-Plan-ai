package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSkipLast<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33445c;

    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -3807491841935125653L;
        public final bu.d<? super T> downstream;
        public final int skip;
        public bu.e upstream;

        public SkipLastSubscriber(bu.d<? super T> dVar, int i10) {
            super(i10);
            this.downstream = dVar;
            this.skip = i10;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            } else {
                this.upstream.request(1L);
            }
            offer(t10);
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
    }

    public FlowableSkipLast(xi.j<T> jVar, int i10) {
        super(jVar);
        this.f33445c = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new SkipLastSubscriber(dVar, this.f33445c));
    }
}
