package io.reactivex.internal.operators.single;

import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
@bj.d
public final class w<T> extends i0<xi.y<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0<T> f35083a;

    public w(i0<T> i0Var) {
        this.f35083a = i0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super xi.y<T>> l0Var) {
        this.f35083a.a(new io.reactivex.internal.operators.mixed.a(l0Var));
    }
}
