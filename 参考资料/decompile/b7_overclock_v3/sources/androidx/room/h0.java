package androidx.room;

import c2.e;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final e.c f7390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final a f7391b;

    public h0(@g.n0 e.c cVar, @g.n0 a aVar) {
        this.f7390a = cVar;
        this.f7391b = aVar;
    }

    @Override // c2.e.c
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a0 a(@g.n0 e.b bVar) {
        return new a0(this.f7390a.a(bVar), this.f7391b);
    }
}
