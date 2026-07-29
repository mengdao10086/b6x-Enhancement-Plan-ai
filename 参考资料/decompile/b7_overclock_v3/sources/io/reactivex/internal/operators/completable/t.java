package io.reactivex.internal.operators.completable;

import io.reactivex.internal.operators.completable.s;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class t extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends xi.g> f33121a;

    public t(Iterable<? extends xi.g> iterable) {
        this.f33121a = iterable;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        dVar.onSubscribe(aVar);
        try {
            Iterator it2 = (Iterator) io.reactivex.internal.functions.a.g(this.f33121a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!aVar.isDisposed()) {
                try {
                    if (it2.hasNext()) {
                        if (aVar.isDisposed()) {
                            return;
                        }
                        try {
                            xi.g gVar = (xi.g) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null CompletableSource");
                            if (aVar.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            gVar.a(new s.a(dVar, aVar, atomicThrowable, atomicInteger));
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            atomicThrowable.a(th2);
                        }
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    atomicThrowable.a(th3);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable thC = atomicThrowable.c();
                    if (thC == null) {
                        dVar.onComplete();
                        return;
                    } else {
                        dVar.onError(thC);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            dVar.onError(th4);
        }
    }
}
