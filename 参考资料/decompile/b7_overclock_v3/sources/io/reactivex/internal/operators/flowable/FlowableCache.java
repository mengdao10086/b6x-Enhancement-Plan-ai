package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCache<T> extends io.reactivex.internal.operators.flowable.a<T, T> implements xi.o<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CacheSubscription[] f33176l = new CacheSubscription[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CacheSubscription[] f33177m = new CacheSubscription[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f33178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<CacheSubscription<T>[]> f33180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f33181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a<T> f33182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a<T> f33183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f33184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f33185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f33186k;

    public static final class CacheSubscription<T> extends AtomicInteger implements bu.e {
        private static final long serialVersionUID = 6770240836423125754L;
        public final bu.d<? super T> downstream;
        public long index;
        public a<T> node;
        public int offset;
        public final FlowableCache<T> parent;
        public final AtomicLong requested = new AtomicLong();

        public CacheSubscription(bu.d<? super T> dVar, FlowableCache<T> flowableCache) {
            this.downstream = dVar;
            this.parent = flowableCache;
            this.node = flowableCache.f33182g;
        }

        @Override // bu.e
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.Q8(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.b(this.requested, j10);
                this.parent.R8(this);
            }
        }
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f33187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a<T> f33188b;

        public a(int i10) {
            this.f33187a = (T[]) new Object[i10];
        }
    }

    public FlowableCache(xi.j<T> jVar, int i10) {
        super(jVar);
        this.f33179d = i10;
        this.f33178c = new AtomicBoolean();
        a<T> aVar = new a<>(i10);
        this.f33182g = aVar;
        this.f33183h = aVar;
        this.f33180e = new AtomicReference<>(f33176l);
    }

    public void M8(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription<T>[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.f33180e.get();
            if (cacheSubscriptionArr == f33177m) {
                return;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new CacheSubscription[length + 1];
            System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!this.f33180e.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public long N8() {
        return this.f33181f;
    }

    public boolean O8() {
        return this.f33180e.get().length != 0;
    }

    public boolean P8() {
        return this.f33178c.get();
    }

    public void Q8(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription<T>[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.f33180e.get();
            int length = cacheSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (cacheSubscriptionArr[i11] == cacheSubscription) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                cacheSubscriptionArr2 = f33176l;
            } else {
                CacheSubscription<T>[] cacheSubscriptionArr3 = new CacheSubscription[length - 1];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i10);
                System.arraycopy(cacheSubscriptionArr, i10 + 1, cacheSubscriptionArr3, i10, (length - i10) - 1);
                cacheSubscriptionArr2 = cacheSubscriptionArr3;
            }
        } while (!this.f33180e.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    public void R8(CacheSubscription<T> cacheSubscription) {
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j10 = cacheSubscription.index;
        int i10 = cacheSubscription.offset;
        a<T> aVar = cacheSubscription.node;
        AtomicLong atomicLong = cacheSubscription.requested;
        bu.d<? super T> dVar = cacheSubscription.downstream;
        int i11 = this.f33179d;
        int iAddAndGet = 1;
        while (true) {
            boolean z10 = this.f33186k;
            boolean z11 = this.f33181f == j10;
            if (z10 && z11) {
                cacheSubscription.node = null;
                Throwable th2 = this.f33185j;
                if (th2 != null) {
                    dVar.onError(th2);
                    return;
                } else {
                    dVar.onComplete();
                    return;
                }
            }
            if (!z11) {
                long j11 = atomicLong.get();
                if (j11 == Long.MIN_VALUE) {
                    cacheSubscription.node = null;
                    return;
                } else if (j11 != j10) {
                    if (i10 == i11) {
                        aVar = aVar.f33188b;
                        i10 = 0;
                    }
                    dVar.onNext(aVar.f33187a[i10]);
                    i10++;
                    j10++;
                }
            }
            cacheSubscription.index = j10;
            cacheSubscription.offset = i10;
            cacheSubscription.node = aVar;
            iAddAndGet = cacheSubscription.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        CacheSubscription<T> cacheSubscription = new CacheSubscription<>(dVar, this);
        dVar.onSubscribe(cacheSubscription);
        M8(cacheSubscription);
        if (this.f33178c.get() || !this.f33178c.compareAndSet(false, true)) {
            R8(cacheSubscription);
        } else {
            this.f33524b.j6(this);
        }
    }

    @Override // bu.d
    public void onComplete() {
        this.f33186k = true;
        for (CacheSubscription<T> cacheSubscription : this.f33180e.getAndSet(f33177m)) {
            R8(cacheSubscription);
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f33186k) {
            kj.a.Y(th2);
            return;
        }
        this.f33185j = th2;
        this.f33186k = true;
        for (CacheSubscription<T> cacheSubscription : this.f33180e.getAndSet(f33177m)) {
            R8(cacheSubscription);
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        int i10 = this.f33184i;
        if (i10 == this.f33179d) {
            a<T> aVar = new a<>(i10);
            aVar.f33187a[0] = t10;
            this.f33184i = 1;
            this.f33183h.f33188b = aVar;
            this.f33183h = aVar;
        } else {
            this.f33183h.f33187a[i10] = t10;
            this.f33184i = i10 + 1;
        }
        this.f33181f++;
        for (CacheSubscription<T> cacheSubscription : this.f33180e.get()) {
            R8(cacheSubscription);
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        eVar.request(Long.MAX_VALUE);
    }
}
