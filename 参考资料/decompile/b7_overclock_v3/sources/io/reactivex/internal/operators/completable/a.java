package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g[] f33071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.g> f33072b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.completable.a$a, reason: collision with other inner class name */
    public static final class C0382a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f33073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f33074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.d f33075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public io.reactivex.disposables.b f33076d;

        public C0382a(AtomicBoolean atomicBoolean, io.reactivex.disposables.a aVar, xi.d dVar) {
            this.f33073a = atomicBoolean;
            this.f33074b = aVar;
            this.f33075c = dVar;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.f33073a.compareAndSet(false, true)) {
                this.f33074b.c(this.f33076d);
                this.f33074b.dispose();
                this.f33075c.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (!this.f33073a.compareAndSet(false, true)) {
                kj.a.Y(th2);
                return;
            }
            this.f33074b.c(this.f33076d);
            this.f33074b.dispose();
            this.f33075c.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33076d = bVar;
            this.f33074b.b(bVar);
        }
    }

    public a(xi.g[] gVarArr, Iterable<? extends xi.g> iterable) {
        this.f33071a = gVarArr;
        this.f33072b = iterable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        int length;
        xi.g[] gVarArr = this.f33071a;
        if (gVarArr == null) {
            gVarArr = new xi.g[8];
            try {
                length = 0;
                for (xi.g gVar : this.f33072b) {
                    if (gVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), dVar);
                        return;
                    }
                    if (length == gVarArr.length) {
                        xi.g[] gVarArr2 = new xi.g[(length >> 2) + length];
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                        gVarArr = gVarArr2;
                    }
                    int i10 = length + 1;
                    gVarArr[length] = gVar;
                    length = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, dVar);
                return;
            }
        } else {
            length = gVarArr.length;
        }
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        dVar.onSubscribe(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i11 = 0; i11 < length; i11++) {
            xi.g gVar2 = gVarArr[i11];
            if (aVar.isDisposed()) {
                return;
            }
            if (gVar2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    kj.a.Y(nullPointerException);
                    return;
                } else {
                    aVar.dispose();
                    dVar.onError(nullPointerException);
                    return;
                }
            }
            gVar2.a(new C0382a(atomicBoolean, aVar, dVar));
        }
        if (length == 0) {
            dVar.onComplete();
        }
    }
}
