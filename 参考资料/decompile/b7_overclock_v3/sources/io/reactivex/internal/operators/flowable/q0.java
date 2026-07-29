package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.p0;

/* JADX INFO: loaded from: classes5.dex */
public final class q0<T, U> extends xi.j<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends U> f33734c;

    public q0(bu.c<T> cVar, dj.o<? super T, ? extends U> oVar) {
        this.f33733b = cVar;
        this.f33734c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        this.f33733b.d(new p0.b(dVar, this.f33734c));
    }
}
