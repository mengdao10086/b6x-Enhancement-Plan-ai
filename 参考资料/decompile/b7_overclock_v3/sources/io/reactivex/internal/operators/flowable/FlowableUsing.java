package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableUsing<T, D> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<? extends D> f33493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super D, ? extends bu.c<? extends T>> f33494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super D> f33495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33496e;

    public static final class UsingSubscriber<T, D> extends AtomicBoolean implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 5904473792286235046L;
        public final dj.g<? super D> disposer;
        public final bu.d<? super T> downstream;
        public final boolean eager;
        public final D resource;
        public bu.e upstream;

        public UsingSubscriber(bu.d<? super T> dVar, D d10, dj.g<? super D> gVar, boolean z10) {
            this.downstream = dVar;
            this.resource = d10;
            this.disposer = gVar;
            this.eager = z10;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            a();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.cancel();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.eager) {
                this.downstream.onError(th2);
                this.upstream.cancel();
                a();
                return;
            }
            Throwable th3 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th4) {
                    th3 = th4;
                    io.reactivex.exceptions.a.b(th3);
                }
            }
            this.upstream.cancel();
            if (th3 != null) {
                this.downstream.onError(new CompositeException(th2, th3));
            } else {
                this.downstream.onError(th2);
            }
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
    }

    public FlowableUsing(Callable<? extends D> callable, dj.o<? super D, ? extends bu.c<? extends T>> oVar, dj.g<? super D> gVar, boolean z10) {
        this.f33493b = callable;
        this.f33494c = oVar;
        this.f33495d = gVar;
        this.f33496e = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            D dCall = this.f33493b.call();
            try {
                ((bu.c) io.reactivex.internal.functions.a.g(this.f33494c.apply(dCall), "The sourceSupplier returned a null Publisher")).d(new UsingSubscriber(dVar, dCall, this.f33495d, this.f33496e));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.f33495d.accept(dCall);
                    EmptySubscription.error(th2, dVar);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    EmptySubscription.error(new CompositeException(th2, th3), dVar);
                }
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            EmptySubscription.error(th4, dVar);
        }
    }
}
