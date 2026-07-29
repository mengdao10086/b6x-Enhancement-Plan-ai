package gc;

import com.google.android.exoplayer2.Format;
import ed.x;
import g.p0;
import gc.f;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f29212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f.a f29213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f29214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f29215m;

    public l(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, f fVar) {
        super(aVar, bVar, 2, format, i10, obj, ya.g.f56663b, ya.g.f56663b);
        this.f29212j = fVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() throws IOException {
        if (this.f29214l == 0) {
            this.f29212j.c(this.f29213k, ya.g.f56663b, ya.g.f56663b);
        }
        try {
            com.google.android.exoplayer2.upstream.b bVarE = this.f29164b.e(this.f29214l);
            x xVar = this.f29171i;
            hb.g gVar = new hb.g(xVar, bVarE.f19098g, xVar.a(bVarE));
            while (!this.f29215m && this.f29212j.a(gVar)) {
                try {
                } finally {
                    this.f29214l = gVar.getPosition() - this.f29164b.f19098g;
                }
            }
        } finally {
            u0.p(this.f29171i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
        this.f29215m = true;
    }

    public void g(f.a aVar) {
        this.f29213k = aVar;
    }
}
