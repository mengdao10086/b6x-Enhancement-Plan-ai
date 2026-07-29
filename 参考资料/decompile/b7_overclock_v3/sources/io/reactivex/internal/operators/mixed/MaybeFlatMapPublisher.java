package io.reactivex.internal.operators.mixed;

import bu.c;
import bu.d;
import bu.e;
import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.t;
import xi.w;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapPublisher<T, R> extends j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w<T> f34064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o<? super T, ? extends c<? extends R>> f34065c;

    public MaybeFlatMapPublisher(w<T> wVar, o<? super T, ? extends c<? extends R>> oVar) {
        this.f34064b = wVar;
        this.f34065c = oVar;
    }

    @Override // xi.j
    public void k6(d<? super R> dVar) {
        this.f34064b.a(new FlatMapPublisherSubscriber(dVar, this.f34065c));
    }

    public static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<e> implements xi.o<R>, t<T>, e {
        private static final long serialVersionUID = -8948264376121066672L;
        public final d<? super R> downstream;
        public final o<? super T, ? extends c<? extends R>> mapper;
        public final AtomicLong requested = new AtomicLong();
        public io.reactivex.disposables.b upstream;

        public FlatMapPublisherSubscriber(d<? super R> dVar, o<? super T, ? extends c<? extends R>> oVar) {
            this.downstream = dVar;
            this.mapper = oVar;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
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
        public void onNext(R r10) {
            this.downstream.onNext(r10);
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
            try {
                ((c) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null Publisher")).d(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
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
