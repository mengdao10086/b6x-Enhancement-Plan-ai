package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.a<T, T> implements xi.g0<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CacheDisposable[] f34126k = new CacheDisposable[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CacheDisposable[] f34127l = new CacheDisposable[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f34128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f34130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f34131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a<T> f34132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a<T> f34133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f34134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f34135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f34136j;

    public static final class CacheDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 6770240836423125754L;
        public volatile boolean disposed;
        public final xi.g0<? super T> downstream;
        public long index;
        public a<T> node;
        public int offset;
        public final ObservableCache<T> parent;

        public CacheDisposable(xi.g0<? super T> g0Var, ObservableCache<T> observableCache) {
            this.downstream = g0Var;
            this.parent = observableCache;
            this.node = observableCache.f34132f;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.parent.m8(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f34137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a<T> f34138b;

        public a(int i10) {
            this.f34137a = (T[]) new Object[i10];
        }
    }

    public ObservableCache(xi.z<T> zVar, int i10) {
        super(zVar);
        this.f34129c = i10;
        this.f34128b = new AtomicBoolean();
        a<T> aVar = new a<>(i10);
        this.f34132f = aVar;
        this.f34133g = aVar;
        this.f34130d = new AtomicReference<>(f34126k);
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(g0Var, this);
        g0Var.onSubscribe(cacheDisposable);
        i8(cacheDisposable);
        if (this.f34128b.get() || !this.f34128b.compareAndSet(false, true)) {
            n8(cacheDisposable);
        } else {
            this.f34421a.c(this);
        }
    }

    public void i8(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f34130d.get();
            if (cacheDisposableArr == f34127l) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f34130d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public long j8() {
        return this.f34131e;
    }

    public boolean k8() {
        return this.f34130d.get().length != 0;
    }

    public boolean l8() {
        return this.f34128b.get();
    }

    public void m8(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f34130d.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (cacheDisposableArr[i11] == cacheDisposable) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f34126k;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i10);
                System.arraycopy(cacheDisposableArr, i10 + 1, cacheDisposableArr3, i10, (length - i10) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.f34130d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void n8(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j10 = cacheDisposable.index;
        int i10 = cacheDisposable.offset;
        a<T> aVar = cacheDisposable.node;
        xi.g0<? super T> g0Var = cacheDisposable.downstream;
        int i11 = this.f34129c;
        int iAddAndGet = 1;
        while (!cacheDisposable.disposed) {
            boolean z10 = this.f34136j;
            boolean z11 = this.f34131e == j10;
            if (z10 && z11) {
                cacheDisposable.node = null;
                Throwable th2 = this.f34135i;
                if (th2 != null) {
                    g0Var.onError(th2);
                    return;
                } else {
                    g0Var.onComplete();
                    return;
                }
            }
            if (z11) {
                cacheDisposable.index = j10;
                cacheDisposable.offset = i10;
                cacheDisposable.node = aVar;
                iAddAndGet = cacheDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i10 == i11) {
                    aVar = aVar.f34138b;
                    i10 = 0;
                }
                g0Var.onNext(aVar.f34137a[i10]);
                i10++;
                j10++;
            }
        }
        cacheDisposable.node = null;
    }

    @Override // xi.g0
    public void onComplete() {
        this.f34136j = true;
        for (CacheDisposable<T> cacheDisposable : this.f34130d.getAndSet(f34127l)) {
            n8(cacheDisposable);
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        this.f34135i = th2;
        this.f34136j = true;
        for (CacheDisposable<T> cacheDisposable : this.f34130d.getAndSet(f34127l)) {
            n8(cacheDisposable);
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        int i10 = this.f34134h;
        if (i10 == this.f34129c) {
            a<T> aVar = new a<>(i10);
            aVar.f34137a[0] = t10;
            this.f34134h = 1;
            this.f34133g.f34138b = aVar;
            this.f34133g = aVar;
        } else {
            this.f34133g.f34137a[i10] = t10;
            this.f34134h = i10 + 1;
        }
        this.f34131e++;
        for (CacheDisposable<T> cacheDisposable : this.f34130d.get()) {
            n8(cacheDisposable);
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
