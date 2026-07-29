package io.reactivex.internal.operators.completable;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class s extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g[] f33116a;

    public static final class a implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f33117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f33118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicThrowable f33119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f33120d;

        public a(xi.d dVar, io.reactivex.disposables.a aVar, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f33117a = dVar;
            this.f33118b = aVar;
            this.f33119c = atomicThrowable;
            this.f33120d = atomicInteger;
        }

        public void a() {
            if (this.f33120d.decrementAndGet() == 0) {
                Throwable thC = this.f33119c.c();
                if (thC == null) {
                    this.f33117a.onComplete();
                } else {
                    this.f33117a.onError(thC);
                }
            }
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            a();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (this.f33119c.a(th2)) {
                a();
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33118b.b(bVar);
        }
    }

    public s(xi.g[] gVarArr) {
        this.f33116a = gVarArr;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        AtomicInteger atomicInteger = new AtomicInteger(this.f33116a.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        dVar.onSubscribe(aVar);
        for (xi.g gVar : this.f33116a) {
            if (aVar.isDisposed()) {
                return;
            }
            if (gVar == null) {
                atomicThrowable.a(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                gVar.a(new a(dVar, aVar, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable thC = atomicThrowable.c();
            if (thC == null) {
                dVar.onComplete();
            } else {
                dVar.onError(thC);
            }
        }
    }
}
