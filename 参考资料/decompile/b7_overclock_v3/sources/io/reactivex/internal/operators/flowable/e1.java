package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableTake;

/* JADX INFO: loaded from: classes5.dex */
public final class e1<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33583c;

    public e1(bu.c<T> cVar, long j10) {
        this.f33582b = cVar;
        this.f33583c = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33582b.d(new FlowableTake.TakeSubscriber(dVar, this.f33583c));
    }
}
