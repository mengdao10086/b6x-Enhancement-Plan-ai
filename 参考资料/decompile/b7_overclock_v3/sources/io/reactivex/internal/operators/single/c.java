package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends o0<? extends T>> f35005a;

    public c(Callable<? extends o0<? extends T>> callable) {
        this.f35005a = callable;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        try {
            ((o0) io.reactivex.internal.functions.a.g(this.f35005a.call(), "The singleSupplier returned a null SingleSource")).a(l0Var);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, l0Var);
        }
    }
}
