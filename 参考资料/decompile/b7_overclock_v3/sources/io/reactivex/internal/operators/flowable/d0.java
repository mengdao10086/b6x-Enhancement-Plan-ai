package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class d0<T, U> extends xi.j<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<T> f33565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends U>> f33566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33569f;

    public d0(bu.c<T> cVar, dj.o<? super T, ? extends bu.c<? extends U>> oVar, boolean z10, int i10, int i11) {
        this.f33565b = cVar;
        this.f33566c = oVar;
        this.f33567d = z10;
        this.f33568e = i10;
        this.f33569f = i11;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        if (w0.b(this.f33565b, dVar, this.f33566c)) {
            return;
        }
        this.f33565b.d(FlowableFlatMap.M8(dVar, this.f33566c, this.f33567d, this.f33568e, this.f33569f));
    }
}
