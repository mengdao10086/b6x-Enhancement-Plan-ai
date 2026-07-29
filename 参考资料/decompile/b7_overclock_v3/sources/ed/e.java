package ed;

import g.p0;
import hd.u0;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f26897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<z> f26898c = new ArrayList<>(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.b f26900e;

    public e(boolean z10) {
        this.f26897b = z10;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map c() {
        return k.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void d(z zVar) {
        hd.a.g(zVar);
        if (this.f26898c.contains(zVar)) {
            return;
        }
        this.f26898c.add(zVar);
        this.f26899d++;
    }

    public final void u(int i10) {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) u0.k(this.f26900e);
        for (int i11 = 0; i11 < this.f26899d; i11++) {
            this.f26898c.get(i11).g(this, bVar, this.f26897b, i10);
        }
    }

    public final void v() {
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) u0.k(this.f26900e);
        for (int i10 = 0; i10 < this.f26899d; i10++) {
            this.f26898c.get(i10).a(this, bVar, this.f26897b);
        }
        this.f26900e = null;
    }

    public final void w(com.google.android.exoplayer2.upstream.b bVar) {
        for (int i10 = 0; i10 < this.f26899d; i10++) {
            this.f26898c.get(i10).h(this, bVar, this.f26897b);
        }
    }

    public final void x(com.google.android.exoplayer2.upstream.b bVar) {
        this.f26900e = bVar;
        for (int i10 = 0; i10 < this.f26899d; i10++) {
            this.f26898c.get(i10).b(this, bVar, this.f26897b);
        }
    }
}
