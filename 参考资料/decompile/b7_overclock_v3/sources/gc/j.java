package gc;

import com.google.android.exoplayer2.Format;
import ed.x;
import g.p0;
import gc.f;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class j extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f29203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f29204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f29205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f29206r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f29207s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f29208t;

    public j(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, long j10, long j11, long j12, long j13, long j14, int i11, long j15, f fVar) {
        super(aVar, bVar, format, i10, obj, j10, j11, j12, j13, j14);
        this.f29203o = i11;
        this.f29204p = j15;
        this.f29205q = fVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() throws IOException {
        if (this.f29206r == 0) {
            c cVarJ = j();
            cVarJ.b(this.f29204p);
            f fVar = this.f29205q;
            f.a aVarL = l(cVarJ);
            long j10 = this.f29136k;
            long j11 = j10 == ya.g.f56663b ? -9223372036854775807L : j10 - this.f29204p;
            long j12 = this.f29137l;
            fVar.c(aVarL, j11, j12 == ya.g.f56663b ? -9223372036854775807L : j12 - this.f29204p);
        }
        try {
            com.google.android.exoplayer2.upstream.b bVarE = this.f29164b.e(this.f29206r);
            x xVar = this.f29171i;
            hb.g gVar = new hb.g(xVar, bVarE.f19098g, xVar.a(bVarE));
            do {
                try {
                    if (this.f29207s) {
                        break;
                    }
                } finally {
                    this.f29206r = gVar.getPosition() - this.f29164b.f19098g;
                }
            } while (this.f29205q.a(gVar));
            u0.p(this.f29171i);
            this.f29208t = !this.f29207s;
        } catch (Throwable th2) {
            u0.p(this.f29171i);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
        this.f29207s = true;
    }

    @Override // gc.m
    public long g() {
        return this.f29216j + ((long) this.f29203o);
    }

    @Override // gc.m
    public boolean h() {
        return this.f29208t;
    }

    public f.a l(c cVar) {
        return cVar;
    }
}
