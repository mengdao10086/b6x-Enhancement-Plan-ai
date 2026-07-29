package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnErrorReturn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends T> f33344c;

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        public final dj.o<? super Throwable, ? extends T> valueSupplier;

        public OnErrorReturnSubscriber(bu.d<? super T> dVar, dj.o<? super Throwable, ? extends T> oVar) {
            super(dVar);
            this.valueSupplier = oVar;
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            try {
                a(io.reactivex.internal.functions.a.g(this.valueSupplier.apply(th2), "The valueSupplier returned a null value"));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext((Object) t10);
        }
    }

    public FlowableOnErrorReturn(xi.j<T> jVar, dj.o<? super Throwable, ? extends T> oVar) {
        super(jVar);
        this.f33344c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new OnErrorReturnSubscriber(dVar, this.f33344c));
    }
}
