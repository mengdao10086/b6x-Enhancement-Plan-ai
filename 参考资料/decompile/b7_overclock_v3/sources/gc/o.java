package gc;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import com.google.android.exoplayer2.Format;
import g.p0;
import g.v0;
import gc.f;
import hb.a0;
import hb.d0;
import hd.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@v0(30)
public final class o implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mc.c f29218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mc.a f29219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaParser f29220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f29221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hb.j f29222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f29223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public f.a f29224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Format[] f29225h;

    public class b implements hb.m {
        public b() {
        }

        @Override // hb.m
        public d0 d(int i10, int i11) {
            return o.this.f29224g != null ? o.this.f29224g.d(i10, i11) : o.this.f29222e;
        }

        @Override // hb.m
        public void k() {
            o oVar = o.this;
            oVar.f29225h = oVar.f29218a.j();
        }

        @Override // hb.m
        public void o(a0 a0Var) {
        }
    }

    @SuppressLint({"WrongConstant"})
    public o(int i10, Format format, List<Format> list) {
        mc.c cVar = new mc.c(format, i10, true);
        this.f29218a = cVar;
        this.f29219b = new mc.a();
        String str = w.q((String) hd.a.g(format.f16697k)) ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        cVar.r(str);
        MediaParser mediaParserCreateByName = MediaParser.createByName(str, cVar);
        this.f29220c = mediaParserCreateByName;
        Boolean bool = Boolean.TRUE;
        mediaParserCreateByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", bool);
        mediaParserCreateByName.setParameter(mc.b.f41162a, bool);
        mediaParserCreateByName.setParameter(mc.b.f41163b, bool);
        mediaParserCreateByName.setParameter(mc.b.f41164c, bool);
        mediaParserCreateByName.setParameter(mc.b.f41165d, bool);
        mediaParserCreateByName.setParameter(mc.b.f41166e, bool);
        mediaParserCreateByName.setParameter(mc.b.f41167f, bool);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(mc.b.a(list.get(i11)));
        }
        this.f29220c.setParameter(mc.b.f41168g, arrayList);
        this.f29218a.p(list);
        this.f29221d = new b();
        this.f29222e = new hb.j();
        this.f29223f = ya.g.f56663b;
    }

    @Override // gc.f
    public boolean a(hb.l lVar) throws IOException {
        i();
        this.f29219b.c(lVar, lVar.getLength());
        return this.f29220c.advance(this.f29219b);
    }

    @Override // gc.f
    @p0
    public Format[] b() {
        return this.f29225h;
    }

    @Override // gc.f
    public void c(@p0 f.a aVar, long j10, long j11) {
        this.f29224g = aVar;
        this.f29218a.q(j11);
        this.f29218a.o(this.f29221d);
        this.f29223f = j10;
    }

    @Override // gc.f
    @p0
    public hb.e e() {
        return this.f29218a.d();
    }

    public final void i() {
        MediaParser.SeekMap seekMapF = this.f29218a.f();
        long j10 = this.f29223f;
        if (j10 == ya.g.f56663b || seekMapF == null) {
            return;
        }
        this.f29220c.seek((MediaParser.SeekPoint) seekMapF.getSeekPoints(j10).first);
        this.f29223f = ya.g.f56663b;
    }

    @Override // gc.f
    public void release() {
        this.f29220c.release();
    }
}
