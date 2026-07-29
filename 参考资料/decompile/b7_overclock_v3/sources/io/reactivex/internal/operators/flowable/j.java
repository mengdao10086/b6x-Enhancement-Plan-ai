package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<B> f33629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<U> f33630d;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.subscribers.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f33631b;

        public a(b<T, U, B> bVar) {
            this.f33631b = bVar;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33631b.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33631b.onError(th2);
        }

        @Override // bu.d
        public void onNext(B b10) {
            this.f33631b.o();
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends hj.h<T, U, U> implements xi.o<T>, bu.e, io.reactivex.disposables.b {
        public final Callable<U> R7;
        public final bu.c<B> S7;
        public bu.e T7;
        public io.reactivex.disposables.b U7;
        public U V7;

        public b(bu.d<? super U> dVar, Callable<U> callable, bu.c<B> cVar) {
            super(dVar, new MpscLinkedQueue());
            this.R7 = callable;
            this.S7 = cVar;
        }

        @Override // bu.e
        public void cancel() {
            if (this.O7) {
                return;
            }
            this.O7 = true;
            this.U7.dispose();
            this.T7.cancel();
            if (a()) {
                this.N7.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.O7;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // hj.h, io.reactivex.internal.util.m
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean h(bu.d<? super U> dVar, U u6) {
            this.M7.onNext((Object) u6);
            return true;
        }

        public void o() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u10 = this.V7;
                    if (u10 == null) {
                        return;
                    }
                    this.V7 = u6;
                    j(u10, false, this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.M7.onError(th2);
            }
        }

        @Override // bu.d
        public void onComplete() {
            synchronized (this) {
                U u6 = this.V7;
                if (u6 == null) {
                    return;
                }
                this.V7 = null;
                this.N7.offer(u6);
                this.P7 = true;
                if (a()) {
                    io.reactivex.internal.util.n.e(this.N7, this.M7, false, this, this);
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            cancel();
            this.M7.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.V7;
                if (u6 == null) {
                    return;
                }
                u6.add(t10);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.T7, eVar)) {
                this.T7 = eVar;
                try {
                    this.V7 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.U7 = aVar;
                    this.M7.onSubscribe(this);
                    if (this.O7) {
                        return;
                    }
                    eVar.request(Long.MAX_VALUE);
                    this.S7.d(aVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.O7 = true;
                    eVar.cancel();
                    EmptySubscription.error(th2, this.M7);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }
    }

    public j(xi.j<T> jVar, bu.c<B> cVar, Callable<U> callable) {
        super(jVar);
        this.f33629c = cVar;
        this.f33630d = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        this.f33524b.j6(new b(new io.reactivex.subscribers.e(dVar), this.f33630d, this.f33629c));
    }
}
