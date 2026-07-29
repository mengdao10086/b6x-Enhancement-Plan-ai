package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends xi.z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ij.a<? extends T> f34542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f34544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f34545d = new AtomicInteger();

    public i(ij.a<? extends T> aVar, int i10, dj.g<? super io.reactivex.disposables.b> gVar) {
        this.f34542a = aVar;
        this.f34543b = i10;
        this.f34544c = gVar;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34542a.c(g0Var);
        if (this.f34545d.incrementAndGet() == this.f34543b) {
            this.f34542a.m8(this.f34544c);
        }
    }
}
