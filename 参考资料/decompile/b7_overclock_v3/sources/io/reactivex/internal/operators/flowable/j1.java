package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class j1<T, B, V> extends io.reactivex.internal.operators.flowable.a<T, xi.j<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<B> f33634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super B, ? extends bu.c<V>> f33635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33636e;

    public static final class a<T, V> extends io.reactivex.subscribers.b<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c<T, ?, V> f33637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UnicastProcessor<T> f33638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33639d;

        public a(c<T, ?, V> cVar, UnicastProcessor<T> unicastProcessor) {
            this.f33637b = cVar;
            this.f33638c = unicastProcessor;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f33639d) {
                return;
            }
            this.f33639d = true;
            this.f33637b.n(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f33639d) {
                kj.a.Y(th2);
            } else {
                this.f33639d = true;
                this.f33637b.p(th2);
            }
        }

        @Override // bu.d
        public void onNext(V v10) {
            a();
            onComplete();
        }
    }

    public static final class b<T, B> extends io.reactivex.subscribers.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c<T, B, ?> f33640b;

        public b(c<T, B, ?> cVar) {
            this.f33640b = cVar;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33640b.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33640b.p(th2);
        }

        @Override // bu.d
        public void onNext(B b10) {
            this.f33640b.q(b10);
        }
    }

    public static final class c<T, B, V> extends hj.h<T, Object, xi.j<T>> implements bu.e {
        public final bu.c<B> R7;
        public final dj.o<? super B, ? extends bu.c<V>> S7;
        public final int T7;
        public final io.reactivex.disposables.a U7;
        public bu.e V7;
        public final AtomicReference<io.reactivex.disposables.b> W7;
        public final List<UnicastProcessor<T>> X7;
        public final AtomicLong Y7;
        public final AtomicBoolean Z7;

        public c(bu.d<? super xi.j<T>> dVar, bu.c<B> cVar, dj.o<? super B, ? extends bu.c<V>> oVar, int i10) {
            super(dVar, new MpscLinkedQueue());
            this.W7 = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.Y7 = atomicLong;
            this.Z7 = new AtomicBoolean();
            this.R7 = cVar;
            this.S7 = oVar;
            this.T7 = i10;
            this.U7 = new io.reactivex.disposables.a();
            this.X7 = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // bu.e
        public void cancel() {
            if (this.Z7.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.W7);
                if (this.Y7.decrementAndGet() == 0) {
                    this.V7.cancel();
                }
            }
        }

        public void dispose() {
            this.U7.dispose();
            DisposableHelper.dispose(this.W7);
        }

        @Override // hj.h, io.reactivex.internal.util.m
        public boolean h(bu.d<? super xi.j<T>> dVar, Object obj) {
            return false;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void n(a<T, V> aVar) {
            this.U7.c(aVar);
            this.N7.offer((U) new d(aVar.f33638c, null));
            if (a()) {
                o();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void o() {
            fj.o oVar = this.N7;
            bu.d<? super V> dVar = this.M7;
            List<UnicastProcessor<T>> list = this.X7;
            int iF = 1;
            while (true) {
                boolean z10 = this.P7;
                Object objPoll = oVar.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    dispose();
                    Throwable th2 = this.Q7;
                    if (th2 != null) {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th2);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z11) {
                    iF = f(-iF);
                    if (iF == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar2 = (d) objPoll;
                    UnicastProcessor<T> unicastProcessor = dVar2.f33641a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            dVar2.f33641a.onComplete();
                            if (this.Y7.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.Z7.get()) {
                        UnicastProcessor<T> unicastProcessorT8 = UnicastProcessor.T8(this.T7);
                        long jD = d();
                        if (jD != 0) {
                            list.add(unicastProcessorT8);
                            dVar.onNext(unicastProcessorT8);
                            if (jD != Long.MAX_VALUE) {
                                g(1L);
                            }
                            try {
                                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.S7.apply(dVar2.f33642b), "The publisher supplied is null");
                                a aVar = new a(this, unicastProcessorT8);
                                if (this.U7.b(aVar)) {
                                    this.Y7.getAndIncrement();
                                    cVar.d(aVar);
                                }
                            } catch (Throwable th3) {
                                cancel();
                                dVar.onError(th3);
                            }
                        } else {
                            cancel();
                            dVar.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it4 = list.iterator();
                    while (it4.hasNext()) {
                        it4.next().onNext(NotificationLite.getValue(objPoll));
                    }
                }
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.P7) {
                return;
            }
            this.P7 = true;
            if (a()) {
                o();
            }
            if (this.Y7.decrementAndGet() == 0) {
                this.U7.dispose();
            }
            this.M7.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.P7) {
                kj.a.Y(th2);
                return;
            }
            this.Q7 = th2;
            this.P7 = true;
            if (a()) {
                o();
            }
            if (this.Y7.decrementAndGet() == 0) {
                this.U7.dispose();
            }
            this.M7.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.P7) {
                return;
            }
            if (i()) {
                Iterator<UnicastProcessor<T>> it2 = this.X7.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t10);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.N7.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            o();
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.V7, eVar)) {
                this.V7 = eVar;
                this.M7.onSubscribe(this);
                if (this.Z7.get()) {
                    return;
                }
                b bVar = new b(this);
                if (this.W7.compareAndSet(null, bVar)) {
                    eVar.request(Long.MAX_VALUE);
                    this.R7.d(bVar);
                }
            }
        }

        public void p(Throwable th2) {
            this.V7.cancel();
            this.U7.dispose();
            DisposableHelper.dispose(this.W7);
            this.M7.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void q(B b10) {
            this.N7.offer((U) new d(null, b10));
            if (a()) {
                o();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }
    }

    public static final class d<T, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UnicastProcessor<T> f33641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B f33642b;

        public d(UnicastProcessor<T> unicastProcessor, B b10) {
            this.f33641a = unicastProcessor;
            this.f33642b = b10;
        }
    }

    public j1(xi.j<T> jVar, bu.c<B> cVar, dj.o<? super B, ? extends bu.c<V>> oVar, int i10) {
        super(jVar);
        this.f33634c = cVar;
        this.f33635d = oVar;
        this.f33636e = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.j<T>> dVar) {
        this.f33524b.j6(new c(new io.reactivex.subscribers.e(dVar), this.f33634c, this.f33635d, this.f33636e));
    }
}
