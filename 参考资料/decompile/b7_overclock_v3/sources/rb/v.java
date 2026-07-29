package rb;

import com.google.android.exoplayer2.Format;
import hd.p0;
import hd.u0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Format f48371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p0 f48372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public hb.d0 f48373c;

    public v(String str) {
        this.f48371a = new Format.b().e0(str).E();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    public final void a() {
        hd.a.k(this.f48372b);
        u0.k(this.f48373c);
    }

    @Override // rb.b0
    public void b(p0 p0Var, hb.m mVar, i0.e eVar) {
        this.f48372b = p0Var;
        eVar.a();
        hb.d0 d0VarD = mVar.d(eVar.c(), 5);
        this.f48373c = d0VarD;
        d0VarD.f(this.f48371a);
    }

    @Override // rb.b0
    public void c(hd.c0 c0Var) {
        a();
        long jE = this.f48372b.e();
        if (jE == ya.g.f56663b) {
            return;
        }
        Format format = this.f48371a;
        if (jE != format.f16703p) {
            Format formatE = format.a().i0(jE).E();
            this.f48371a = formatE;
            this.f48373c.f(formatE);
        }
        int iA = c0Var.a();
        this.f48373c.d(c0Var, iA);
        this.f48373c.a(this.f48372b.d(), 1, iA, 0, null);
    }
}
