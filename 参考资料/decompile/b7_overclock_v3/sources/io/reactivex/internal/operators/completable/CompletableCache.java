package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableCache extends xi.a implements xi.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final InnerCompletableCache[] f33031e = new InnerCompletableCache[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InnerCompletableCache[] f33032f = new InnerCompletableCache[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<InnerCompletableCache[]> f33034b = new AtomicReference<>(f33031e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f33035c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f33036d;

    public final class InnerCompletableCache extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8943152917179642732L;
        public final xi.d downstream;

        public InnerCompletableCache(xi.d dVar) {
            this.downstream = dVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.i1(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }

    public CompletableCache(xi.g gVar) {
        this.f33033a = gVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(dVar);
        dVar.onSubscribe(innerCompletableCache);
        if (h1(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                i1(innerCompletableCache);
            }
            if (this.f33035c.compareAndSet(false, true)) {
                this.f33033a.a(this);
                return;
            }
            return;
        }
        Throwable th2 = this.f33036d;
        if (th2 != null) {
            dVar.onError(th2);
        } else {
            dVar.onComplete();
        }
    }

    public boolean h1(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f33034b.get();
            if (innerCompletableCacheArr == f33032f) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.f33034b.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    public void i1(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f33034b.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (innerCompletableCacheArr[i11] == innerCompletableCache) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            if (i10 < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = f33031e;
            } else {
                InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i10);
                System.arraycopy(innerCompletableCacheArr, i10 + 1, innerCompletableCacheArr3, i10, (length - i10) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!this.f33034b.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    @Override // xi.d, xi.t
    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.f33034b.getAndSet(f33032f)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    @Override // xi.d
    public void onError(Throwable th2) {
        this.f33036d = th2;
        for (InnerCompletableCache innerCompletableCache : this.f33034b.getAndSet(f33032f)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th2);
            }
        }
    }

    @Override // xi.d
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
