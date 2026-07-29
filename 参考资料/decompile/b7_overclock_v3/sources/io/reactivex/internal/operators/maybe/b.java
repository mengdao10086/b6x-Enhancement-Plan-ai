package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.w<? extends T>[] f33916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.w<? extends T>> f33917b;

    public static final class a<T> implements xi.t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.t<? super T> f33918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f33919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final io.reactivex.disposables.a f33920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f33921d;

        public a(xi.t<? super T> tVar, io.reactivex.disposables.a aVar, AtomicBoolean atomicBoolean) {
            this.f33918a = tVar;
            this.f33920c = aVar;
            this.f33919b = atomicBoolean;
        }

        @Override // xi.t
        public void onComplete() {
            if (this.f33919b.compareAndSet(false, true)) {
                this.f33920c.c(this.f33921d);
                this.f33920c.dispose();
                this.f33918a.onComplete();
            }
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            if (!this.f33919b.compareAndSet(false, true)) {
                kj.a.Y(th2);
                return;
            }
            this.f33920c.c(this.f33921d);
            this.f33920c.dispose();
            this.f33918a.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33921d = bVar;
            this.f33920c.b(bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            if (this.f33919b.compareAndSet(false, true)) {
                this.f33920c.c(this.f33921d);
                this.f33920c.dispose();
                this.f33918a.onSuccess(t10);
            }
        }
    }

    public b(xi.w<? extends T>[] wVarArr, Iterable<? extends xi.w<? extends T>> iterable) {
        this.f33916a = wVarArr;
        this.f33917b = iterable;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        int length;
        xi.w<? extends T>[] wVarArr = this.f33916a;
        if (wVarArr == null) {
            wVarArr = new xi.w[8];
            try {
                length = 0;
                for (xi.w<? extends T> wVar : this.f33917b) {
                    if (wVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), tVar);
                        return;
                    }
                    if (length == wVarArr.length) {
                        xi.w<? extends T>[] wVarArr2 = new xi.w[(length >> 2) + length];
                        System.arraycopy(wVarArr, 0, wVarArr2, 0, length);
                        wVarArr = wVarArr2;
                    }
                    int i10 = length + 1;
                    wVarArr[length] = wVar;
                    length = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, tVar);
                return;
            }
        } else {
            length = wVarArr.length;
        }
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        tVar.onSubscribe(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i11 = 0; i11 < length; i11++) {
            xi.w<? extends T> wVar2 = wVarArr[i11];
            if (aVar.isDisposed()) {
                return;
            }
            if (wVar2 == null) {
                aVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the MaybeSources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    tVar.onError(nullPointerException);
                    return;
                } else {
                    kj.a.Y(nullPointerException);
                    return;
                }
            }
            wVar2.a(new a(tVar, aVar, atomicBoolean));
        }
        if (length == 0) {
            tVar.onComplete();
        }
    }
}
