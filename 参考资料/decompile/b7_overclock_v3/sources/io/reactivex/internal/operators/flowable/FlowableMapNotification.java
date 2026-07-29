package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMapNotification<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends R> f33320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends R> f33321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Callable<? extends R> f33322e;

    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        public final Callable<? extends R> onCompleteSupplier;
        public final dj.o<? super Throwable, ? extends R> onErrorMapper;
        public final dj.o<? super T, ? extends R> onNextMapper;

        public MapNotificationSubscriber(bu.d<? super R> dVar, dj.o<? super T, ? extends R> oVar, dj.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
            super(dVar);
            this.onNextMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bu.d
        public void onComplete() {
            try {
                a(io.reactivex.internal.functions.a.g(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bu.d
        public void onError(Throwable th2) {
            try {
                a(io.reactivex.internal.functions.a.g(this.onErrorMapper.apply(th2), "The onError publisher returned is null"));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            try {
                Object objG = io.reactivex.internal.functions.a.g(this.onNextMapper.apply(t10), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(objG);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public FlowableMapNotification(xi.j<T> jVar, dj.o<? super T, ? extends R> oVar, dj.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
        super(jVar);
        this.f33320c = oVar;
        this.f33321d = oVar2;
        this.f33322e = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33524b.j6(new MapNotificationSubscriber(dVar, this.f33320c, this.f33321d, this.f33322e));
    }
}
