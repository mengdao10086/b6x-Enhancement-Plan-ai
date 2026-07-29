package rb;

import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i0.a> f48145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hb.d0[] f48146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f48149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f48150f;

    public l(List<i0.a> list) {
        this.f48145a = list;
        this.f48146b = new hb.d0[list.size()];
    }

    @Override // rb.m
    public void a() {
        this.f48147c = false;
    }

    public final boolean b(hd.c0 c0Var, int i10) {
        if (c0Var.a() == 0) {
            return false;
        }
        if (c0Var.G() != i10) {
            this.f48147c = false;
        }
        this.f48148d--;
        return this.f48147c;
    }

    @Override // rb.m
    public void c(hd.c0 c0Var) {
        if (this.f48147c) {
            if (this.f48148d != 2 || b(c0Var, 32)) {
                if (this.f48148d != 1 || b(c0Var, 0)) {
                    int iE = c0Var.e();
                    int iA = c0Var.a();
                    for (hb.d0 d0Var : this.f48146b) {
                        c0Var.S(iE);
                        d0Var.d(c0Var, iA);
                    }
                    this.f48149e += iA;
                }
            }
        }
    }

    @Override // rb.m
    public void d() {
        if (this.f48147c) {
            for (hb.d0 d0Var : this.f48146b) {
                d0Var.a(this.f48150f, 1, this.f48149e, 0, null);
            }
            this.f48147c = false;
        }
    }

    @Override // rb.m
    public void e(hb.m mVar, i0.e eVar) {
        for (int i10 = 0; i10 < this.f48146b.length; i10++) {
            i0.a aVar = this.f48145a.get(i10);
            eVar.a();
            hb.d0 d0VarD = mVar.d(eVar.c(), 3);
            d0VarD.f(new Format.b().S(eVar.b()).e0(hd.w.f31221y0).T(Collections.singletonList(aVar.f48106c)).V(aVar.f48104a).E());
            this.f48146b[i10] = d0VarD;
        }
    }

    @Override // rb.m
    public void f(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f48147c = true;
        this.f48150f = j10;
        this.f48149e = 0;
        this.f48148d = 2;
    }
}
