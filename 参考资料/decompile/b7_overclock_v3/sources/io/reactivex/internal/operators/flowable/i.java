package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<? extends bu.c<B>> f33618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<U> f33619d;

    public static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.subscribers.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T, U, B> f33620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33621c;

        public a(b<T, U, B> bVar) {
            this.f33620b = bVar;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33621c) {
                return;
            }
            this.f33621c = true;
            this.f33620b.p();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33621c) {
                kj.a.Y(th2);
            } else {
                this.f33621c = true;
                this.f33620b.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(B b10) {
            if (this.f33621c) {
                return;
            }
            this.f33621c = true;
            a();
            this.f33620b.p();
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends hj.h<T, U, U> implements xi.o<T>, bu.e, io.reactivex.disposables.b {
        public final Callable<U> R7;
        public final Callable<? extends bu.c<B>> S7;
        public bu.e T7;
        public final AtomicReference<io.reactivex.disposables.b> U7;
        public U V7;

        public b(bu.d<? super U> dVar, Callable<U> callable, Callable<? extends bu.c<B>> callable2) {
            super(dVar, new MpscLinkedQueue());
            this.U7 = new AtomicReference<>();
            this.R7 = callable;
            this.S7 = callable2;
        }

        @Override // bu.e
        public void cancel() {
            if (this.O7) {
                return;
            }
            this.O7 = true;
            this.T7.cancel();
            o();
            if (a()) {
                this.N7.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.T7.cancel();
            o();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.U7.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // hj.h, io.reactivex.internal.util.m
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean h(bu.d<? super U> dVar, U u6) {
            this.M7.onNext((Object) u6);
            return true;
        }

        public void o() {
            DisposableHelper.dispose(this.U7);
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
                bu.d<? super V> dVar = this.M7;
                try {
                    this.V7 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The buffer supplied is null");
                    try {
                        bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.S7.call(), "The boundary publisher supplied is null");
                        a aVar = new a(this);
                        this.U7.set(aVar);
                        dVar.onSubscribe(this);
                        if (this.O7) {
                            return;
                        }
                        eVar.request(Long.MAX_VALUE);
                        cVar.d(aVar);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.O7 = true;
                        eVar.cancel();
                        EmptySubscription.error(th2, dVar);
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.O7 = true;
                    eVar.cancel();
                    EmptySubscription.error(th3, dVar);
                }
            }
        }

        public void p() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The buffer supplied is null");
                try {
                    bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.S7.call(), "The boundary publisher supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.U7, aVar)) {
                        synchronized (this) {
                            U u10 = this.V7;
                            if (u10 == null) {
                                return;
                            }
                            this.V7 = u6;
                            cVar.d(aVar);
                            j(u10, false, this);
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.O7 = true;
                    this.T7.cancel();
                    this.M7.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                cancel();
                this.M7.onError(th3);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }
    }

    public i(xi.j<T> jVar, Callable<? extends bu.c<B>> callable, Callable<U> callable2) {
        super(jVar);
        this.f33618c = callable;
        this.f33619d = callable2;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        this.f33524b.j6(new b(new io.reactivex.subscribers.e(dVar), this.f33619d, this.f33618c));
    }
}
