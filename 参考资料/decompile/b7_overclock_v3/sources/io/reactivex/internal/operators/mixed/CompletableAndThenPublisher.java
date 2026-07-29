package io.reactivex.internal.operators.mixed;

import bu.c;
import bu.d;
import bu.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.g;
import xi.j;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableAndThenPublisher<R> extends j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f34023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<? extends R> f34024c;

    public CompletableAndThenPublisher(g gVar, c<? extends R> cVar) {
        this.f34023b = gVar;
        this.f34024c = cVar;
    }

    @Override // xi.j
    public void k6(d<? super R> dVar) {
        this.f34023b.a(new AndThenPublisherSubscriber(dVar, this.f34024c));
    }

    public static final class AndThenPublisherSubscriber<R> extends AtomicReference<e> implements o<R>, xi.d, e {
        private static final long serialVersionUID = -8948264376121066672L;
        public final d<? super R> downstream;
        public c<? extends R> other;
        public final AtomicLong requested = new AtomicLong();
        public io.reactivex.disposables.b upstream;

        public AndThenPublisherSubscriber(d<? super R> dVar, c<? extends R> cVar) {
            this.downstream = dVar;
            this.other = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            c<? extends R> cVar = this.other;
            if (cVar == null) {
                this.downstream.onComplete();
            } else {
                this.other = null;
                cVar.d(this);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this, this.requested, j10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(e eVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, eVar);
        }
    }
}
