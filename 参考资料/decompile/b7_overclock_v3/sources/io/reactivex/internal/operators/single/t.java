package io.reactivex.internal.operators.single;

import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class t<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f35076a;

    public t(T t10) {
        this.f35076a = t10;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        l0Var.onSubscribe(io.reactivex.disposables.c.a());
        l0Var.onSuccess(this.f35076a);
    }
}
