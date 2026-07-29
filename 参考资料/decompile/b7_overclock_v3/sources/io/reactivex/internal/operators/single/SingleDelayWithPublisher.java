package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelayWithPublisher<T, U> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<U> f34939b;

    public static final class OtherSubscriber<T, U> extends AtomicReference<io.reactivex.disposables.b> implements xi.o<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8565274649390031272L;
        public boolean done;
        public final l0<? super T> downstream;
        public final o0<T> source;
        public bu.e upstream;

        public OtherSubscriber(l0<? super T> l0Var, o0<T> o0Var) {
            this.downstream = l0Var;
            this.source = o0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.a(new gj.o(this, this.downstream));
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
        public void onNext(U u6) {
            this.upstream.cancel();
            onComplete();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleDelayWithPublisher(o0<T> o0Var, bu.c<U> cVar) {
        this.f34938a = o0Var;
        this.f34939b = cVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34939b.d(new OtherSubscriber(l0Var, this.f34938a));
    }
}
