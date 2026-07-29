package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cj.a<? extends T> f33598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f33600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f33601e = new AtomicInteger();

    public g(cj.a<? extends T> aVar, int i10, dj.g<? super io.reactivex.disposables.b> gVar) {
        this.f33598b = aVar;
        this.f33599c = i10;
        this.f33600d = gVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33598b.d(dVar);
        if (this.f33601e.incrementAndGet() == this.f33599c) {
            this.f33598b.Q8(this.f33600d);
        }
    }
}
