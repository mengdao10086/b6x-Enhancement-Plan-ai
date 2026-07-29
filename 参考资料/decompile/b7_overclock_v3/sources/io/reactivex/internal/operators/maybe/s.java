package io.reactivex.internal.operators.maybe;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class s<T> extends xi.q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Future<? extends T> f34002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34004c;

    public s(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        this.f34002a = future;
        this.f34003b = j10;
        this.f34004c = timeUnit;
    }

    @Override // xi.q
    public void q1(xi.t<? super T> tVar) {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        tVar.onSubscribe(bVarB);
        if (bVarB.isDisposed()) {
            return;
        }
        try {
            long j10 = this.f34003b;
            T t10 = j10 <= 0 ? this.f34002a.get() : this.f34002a.get(j10, this.f34004c);
            if (bVarB.isDisposed()) {
                return;
            }
            if (t10 == null) {
                tVar.onComplete();
            } else {
                tVar.onSuccess(t10);
            }
        } catch (Throwable th2) {
            th = th2;
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            io.reactivex.exceptions.a.b(th);
            if (bVarB.isDisposed()) {
                return;
            }
            tVar.onError(th);
        }
    }
}
