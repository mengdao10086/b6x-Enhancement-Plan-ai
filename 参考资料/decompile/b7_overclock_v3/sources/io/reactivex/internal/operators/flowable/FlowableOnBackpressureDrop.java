package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements dj.g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super T> f33341c;

    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -6246093802440953054L;
        public boolean done;
        public final bu.d<? super T> downstream;
        public final dj.g<? super T> onDrop;
        public bu.e upstream;

        public BackpressureDropSubscriber(bu.d<? super T> dVar, dj.g<? super T> gVar) {
            this.downstream = dVar;
            this.onDrop = gVar;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t10);
                io.reactivex.internal.util.b.e(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public FlowableOnBackpressureDrop(xi.j<T> jVar) {
        super(jVar);
        this.f33341c = this;
    }

    @Override // dj.g
    public void accept(T t10) {
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new BackpressureDropSubscriber(dVar, this.f33341c));
    }

    public FlowableOnBackpressureDrop(xi.j<T> jVar, dj.g<? super T> gVar) {
        super(jVar);
        this.f33341c = gVar;
    }
}
