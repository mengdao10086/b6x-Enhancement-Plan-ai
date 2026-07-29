package io.reactivex.internal.operators.single;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMapPublisher<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0<T> f34962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f34963c;

    public SingleFlatMapPublisher(o0<T> o0Var, dj.o<? super T, ? extends bu.c<? extends R>> oVar) {
        this.f34962b = o0Var;
        this.f34963c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f34962b.a(new SingleFlatMapPublisherObserver(dVar, this.f34963c));
    }

    public static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements l0<S>, xi.o<T>, bu.e {
        private static final long serialVersionUID = 7759721921468635667L;
        public io.reactivex.disposables.b disposable;
        public final bu.d<? super T> downstream;
        public final dj.o<? super S, ? extends bu.c<? extends T>> mapper;
        public final AtomicReference<bu.e> parent = new AtomicReference<>();

        public SingleFlatMapPublisherObserver(bu.d<? super T> dVar, dj.o<? super S, ? extends bu.c<? extends T>> oVar) {
            this.downstream = dVar;
            this.mapper = oVar;
        }

        @Override // bu.e
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.disposable = bVar;
            this.downstream.onSubscribe(this);
        }

        @Override // xi.l0
        public void onSuccess(S s10) {
            try {
                ((bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(s10), "the mapper returned a null Publisher")).d(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.parent, this, j10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, eVar);
        }
    }
}
