package rb;

import com.google.android.exoplayer2.Format;
import java.util.List;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f48142c = 434;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Format> f48143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hb.d0[] f48144b;

    public k0(List<Format> list) {
        this.f48143a = list;
        this.f48144b = new hb.d0[list.size()];
    }

    public void a(long j10, hd.c0 c0Var) {
        if (c0Var.a() < 9) {
            return;
        }
        int iO = c0Var.o();
        int iO2 = c0Var.o();
        int iG = c0Var.G();
        if (iO == 434 && iO2 == 1195456820 && iG == 3) {
            hb.d.b(j10, c0Var, this.f48144b);
        }
    }

    public void b(hb.m mVar, i0.e eVar) {
        for (int i10 = 0; i10 < this.f48144b.length; i10++) {
            eVar.a();
            hb.d0 d0VarD = mVar.d(eVar.c(), 3);
            Format format = this.f48143a.get(i10);
            String str = format.f16699l;
            hd.a.b(hd.w.f31195l0.equals(str) || hd.w.f31197m0.equals(str), "Invalid closed caption mime type provided: " + str);
            d0VarD.f(new Format.b().S(eVar.b()).e0(str).g0(format.f16690d).V(format.f16689c).F(format.D).T(format.f16701n).E());
            this.f48144b[i10] = d0VarD;
        }
    }
}
