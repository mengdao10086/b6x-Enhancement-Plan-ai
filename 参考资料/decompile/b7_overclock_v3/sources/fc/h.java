package fc;

import g.i1;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
@i1(otherwise = 3)
public final class h extends ec.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.ads.a f28033c;

    public h(x1 x1Var, com.google.android.exoplayer2.source.ads.a aVar) {
        super(x1Var);
        hd.a.i(x1Var.i() == 1);
        hd.a.i(x1Var.q() == 1);
        this.f28033c = aVar;
    }

    @Override // ec.i, ya.x1
    public x1.b g(int i10, x1.b bVar, boolean z10) {
        this.f26836b.g(i10, bVar, z10);
        long j10 = bVar.f57235d;
        if (j10 == ya.g.f56663b) {
            j10 = this.f28033c.f17550f;
        }
        bVar.q(bVar.f57232a, bVar.f57233b, bVar.f57234c, j10, bVar.n(), this.f28033c);
        return bVar;
    }
}
