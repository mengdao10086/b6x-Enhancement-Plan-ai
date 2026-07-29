package gc;

import com.google.android.exoplayer2.Format;
import g.p0;
import hb.d0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f29227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Format f29228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f29229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f29230r;

    public p(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, long j10, long j11, long j12, int i11, Format format2) {
        super(aVar, bVar, format, i10, obj, j10, j11, ya.g.f56663b, ya.g.f56663b, j12);
        this.f29227o = i11;
        this.f29228p = format2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() throws IOException {
        c cVarJ = j();
        cVarJ.b(0L);
        d0 d0VarD = cVarJ.d(0, this.f29227o);
        d0VarD.f(this.f29228p);
        try {
            long jA = this.f29171i.a(this.f29164b.e(this.f29229q));
            if (jA != -1) {
                jA += this.f29229q;
            }
            hb.g gVar = new hb.g(this.f29171i, this.f29229q, jA);
            for (int iE = 0; iE != -1; iE = d0VarD.e(gVar, Integer.MAX_VALUE, true)) {
                this.f29229q += (long) iE;
            }
            d0VarD.a(this.f29169g, 1, (int) this.f29229q, 0, null);
            u0.p(this.f29171i);
            this.f29230r = true;
        } catch (Throwable th2) {
            u0.p(this.f29171i);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
    }

    @Override // gc.m
    public boolean h() {
        return this.f29230r;
    }
}
