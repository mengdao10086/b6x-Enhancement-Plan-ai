package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f33700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ErrorMode f33702e;

    public n(bu.c<T> cVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, ErrorMode errorMode) {
        this.f33699b = cVar;
        this.f33700c = oVar;
        this.f33701d = i10;
        this.f33702e = errorMode;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        if (w0.b(this.f33699b, dVar, this.f33700c)) {
            return;
        }
        this.f33699b.d(FlowableConcatMap.M8(dVar, this.f33700c, this.f33701d, this.f33702e));
    }
}
