package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes5.dex */
public final class m<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f33691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ErrorMode f33694f;

    public m(bu.c<T> cVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, int i11, ErrorMode errorMode) {
        this.f33690b = cVar;
        this.f33691c = oVar;
        this.f33692d = i10;
        this.f33693e = i11;
        this.f33694f = errorMode;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33690b.d(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(dVar, this.f33691c, this.f33692d, this.f33693e, this.f33694f));
    }
}
