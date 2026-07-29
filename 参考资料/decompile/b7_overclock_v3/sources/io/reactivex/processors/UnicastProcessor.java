package io.reactivex.processors;

import bj.c;
import bj.e;
import bj.f;
import bu.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;

/* JADX INFO: loaded from: classes5.dex */
public final class UnicastProcessor<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.a<T> f35366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Runnable> f35367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f35368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f35369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f35370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<d<? super T>> f35371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f35372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f35373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BasicIntQueueSubscription<T> f35374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f35375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f35376l;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // bu.e
        public void cancel() {
            if (UnicastProcessor.this.f35372h) {
                return;
            }
            UnicastProcessor.this.f35372h = true;
            UnicastProcessor.this.X8();
            UnicastProcessor.this.f35371g.lazySet(null);
            if (UnicastProcessor.this.f35374j.getAndIncrement() == 0) {
                UnicastProcessor.this.f35371g.lazySet(null);
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (unicastProcessor.f35376l) {
                    return;
                }
                unicastProcessor.f35366b.clear();
            }
        }

        @Override // fj.o
        public void clear() {
            UnicastProcessor.this.f35366b.clear();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return UnicastProcessor.this.f35366b.isEmpty();
        }

        @Override // fj.o
        @f
        public T poll() {
            return UnicastProcessor.this.f35366b.poll();
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(UnicastProcessor.this.f35375k, j10);
                UnicastProcessor.this.Y8();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f35376l = true;
            return 2;
        }
    }

    public UnicastProcessor(int i10) {
        this(i10, null, true);
    }

    @c
    @e
    public static <T> UnicastProcessor<T> S8() {
        return new UnicastProcessor<>(j.Y());
    }

    @c
    @e
    public static <T> UnicastProcessor<T> T8(int i10) {
        return new UnicastProcessor<>(i10);
    }

    @c
    @e
    public static <T> UnicastProcessor<T> U8(int i10, Runnable runnable) {
        io.reactivex.internal.functions.a.g(runnable, "onTerminate");
        return new UnicastProcessor<>(i10, runnable);
    }

    @c
    @e
    public static <T> UnicastProcessor<T> V8(int i10, Runnable runnable, boolean z10) {
        io.reactivex.internal.functions.a.g(runnable, "onTerminate");
        return new UnicastProcessor<>(i10, runnable, z10);
    }

    @c
    @e
    public static <T> UnicastProcessor<T> W8(boolean z10) {
        return new UnicastProcessor<>(j.Y(), null, z10);
    }

    @Override // io.reactivex.processors.a
    @f
    public Throwable M8() {
        if (this.f35369e) {
            return this.f35370f;
        }
        return null;
    }

    @Override // io.reactivex.processors.a
    public boolean N8() {
        return this.f35369e && this.f35370f == null;
    }

    @Override // io.reactivex.processors.a
    public boolean O8() {
        return this.f35371g.get() != null;
    }

    @Override // io.reactivex.processors.a
    public boolean P8() {
        return this.f35369e && this.f35370f != null;
    }

    public boolean R8(boolean z10, boolean z11, boolean z12, d<? super T> dVar, io.reactivex.internal.queue.a<T> aVar) {
        if (this.f35372h) {
            aVar.clear();
            this.f35371g.lazySet(null);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (z10 && this.f35370f != null) {
            aVar.clear();
            this.f35371g.lazySet(null);
            dVar.onError(this.f35370f);
            return true;
        }
        if (!z12) {
            return false;
        }
        Throwable th2 = this.f35370f;
        this.f35371g.lazySet(null);
        if (th2 != null) {
            dVar.onError(th2);
        } else {
            dVar.onComplete();
        }
        return true;
    }

    public void X8() {
        Runnable andSet = this.f35367c.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    public void Y8() {
        if (this.f35374j.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        d<? super T> dVar = this.f35371g.get();
        while (dVar == null) {
            iAddAndGet = this.f35374j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                dVar = this.f35371g.get();
            }
        }
        if (this.f35376l) {
            Z8(dVar);
        } else {
            a9(dVar);
        }
    }

    public void Z8(d<? super T> dVar) {
        io.reactivex.internal.queue.a<T> aVar = this.f35366b;
        int iAddAndGet = 1;
        boolean z10 = !this.f35368d;
        while (!this.f35372h) {
            boolean z11 = this.f35369e;
            if (z10 && z11 && this.f35370f != null) {
                aVar.clear();
                this.f35371g.lazySet(null);
                dVar.onError(this.f35370f);
                return;
            }
            dVar.onNext(null);
            if (z11) {
                this.f35371g.lazySet(null);
                Throwable th2 = this.f35370f;
                if (th2 != null) {
                    dVar.onError(th2);
                    return;
                } else {
                    dVar.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f35374j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        this.f35371g.lazySet(null);
    }

    public void a9(d<? super T> dVar) {
        long j10;
        io.reactivex.internal.queue.a<T> aVar = this.f35366b;
        boolean z10 = !this.f35368d;
        int iAddAndGet = 1;
        do {
            long j11 = this.f35375k.get();
            long j12 = 0;
            while (true) {
                if (j11 == j12) {
                    j10 = j12;
                    break;
                }
                boolean z11 = this.f35369e;
                T tPoll = aVar.poll();
                boolean z12 = tPoll == null;
                j10 = j12;
                if (R8(z10, z11, z12, dVar, aVar)) {
                    return;
                }
                if (z12) {
                    break;
                }
                dVar.onNext(tPoll);
                j12 = 1 + j10;
            }
            if (j11 == j12 && R8(z10, this.f35369e, aVar.isEmpty(), dVar, aVar)) {
                return;
            }
            if (j10 != 0 && j11 != Long.MAX_VALUE) {
                this.f35375k.addAndGet(-j10);
            }
            iAddAndGet = this.f35374j.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // xi.j
    public void k6(d<? super T> dVar) {
        if (this.f35373i.get() || !this.f35373i.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), dVar);
            return;
        }
        dVar.onSubscribe(this.f35374j);
        this.f35371g.set(dVar);
        if (this.f35372h) {
            this.f35371g.lazySet(null);
        } else {
            Y8();
        }
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f35369e || this.f35372h) {
            return;
        }
        this.f35369e = true;
        X8();
        Y8();
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35369e || this.f35372h) {
            kj.a.Y(th2);
            return;
        }
        this.f35370f = th2;
        this.f35369e = true;
        X8();
        Y8();
    }

    @Override // bu.d
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35369e || this.f35372h) {
            return;
        }
        this.f35366b.offer(t10);
        Y8();
    }

    @Override // bu.d
    public void onSubscribe(bu.e eVar) {
        if (this.f35369e || this.f35372h) {
            eVar.cancel();
        } else {
            eVar.request(Long.MAX_VALUE);
        }
    }

    public UnicastProcessor(int i10, Runnable runnable) {
        this(i10, runnable, true);
    }

    public UnicastProcessor(int i10, Runnable runnable, boolean z10) {
        this.f35366b = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.h(i10, "capacityHint"));
        this.f35367c = new AtomicReference<>(runnable);
        this.f35368d = z10;
        this.f35371g = new AtomicReference<>();
        this.f35373i = new AtomicBoolean();
        this.f35374j = new UnicastQueueSubscription();
        this.f35375k = new AtomicLong();
    }
}
