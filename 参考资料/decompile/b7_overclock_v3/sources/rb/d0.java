package rb;

import com.google.android.exoplayer2.Format;
import java.util.List;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Format> f47975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hb.d0[] f47976b;

    public d0(List<Format> list) {
        this.f47975a = list;
        this.f47976b = new hb.d0[list.size()];
    }

    public void a(long j10, hd.c0 c0Var) {
        hb.d.a(j10, c0Var, this.f47976b);
    }

    public void b(hb.m mVar, i0.e eVar) {
        for (int i10 = 0; i10 < this.f47976b.length; i10++) {
            eVar.a();
            hb.d0 d0VarD = mVar.d(eVar.c(), 3);
            Format format = this.f47975a.get(i10);
            String str = format.f16699l;
            hd.a.b(hd.w.f31195l0.equals(str) || hd.w.f31197m0.equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = format.f16687a;
            if (strB == null) {
                strB = eVar.b();
            }
            d0VarD.f(new Format.b().S(strB).e0(str).g0(format.f16690d).V(format.f16689c).F(format.D).T(format.f16701n).E());
            this.f47976b[i10] = d0VarD;
        }
    }
}
