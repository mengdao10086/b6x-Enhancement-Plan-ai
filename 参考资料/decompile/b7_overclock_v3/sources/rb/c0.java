package rb;

import hd.p0;
import hd.u0;
import rb.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements i0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f47965j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f47966k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47967l = 4098;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f47968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.c0 f47969e = new hd.c0(32);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47973i;

    public c0(b0 b0Var) {
        this.f47968d = b0Var;
    }

    @Override // rb.i0
    public void a() {
        this.f47973i = true;
    }

    @Override // rb.i0
    public void b(p0 p0Var, hb.m mVar, i0.e eVar) {
        this.f47968d.b(p0Var, mVar, eVar);
        this.f47973i = true;
    }

    @Override // rb.i0
    public void c(hd.c0 c0Var, int i10) {
        boolean z10 = (i10 & 1) != 0;
        int iE = z10 ? c0Var.e() + c0Var.G() : -1;
        if (this.f47973i) {
            if (!z10) {
                return;
            }
            this.f47973i = false;
            c0Var.S(iE);
            this.f47971g = 0;
        }
        while (c0Var.a() > 0) {
            int i11 = this.f47971g;
            if (i11 < 3) {
                if (i11 == 0) {
                    int iG = c0Var.G();
                    c0Var.S(c0Var.e() - 1);
                    if (iG == 255) {
                        this.f47973i = true;
                        return;
                    }
                }
                int iMin = Math.min(c0Var.a(), 3 - this.f47971g);
                c0Var.k(this.f47969e.d(), this.f47971g, iMin);
                int i12 = this.f47971g + iMin;
                this.f47971g = i12;
                if (i12 == 3) {
                    this.f47969e.S(0);
                    this.f47969e.R(3);
                    this.f47969e.T(1);
                    int iG2 = this.f47969e.G();
                    int iG3 = this.f47969e.G();
                    this.f47972h = (iG2 & 128) != 0;
                    this.f47970f = (((iG2 & 15) << 8) | iG3) + 3;
                    int iB = this.f47969e.b();
                    int i13 = this.f47970f;
                    if (iB < i13) {
                        this.f47969e.c(Math.min(4098, Math.max(i13, this.f47969e.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(c0Var.a(), this.f47970f - this.f47971g);
                c0Var.k(this.f47969e.d(), this.f47971g, iMin2);
                int i14 = this.f47971g + iMin2;
                this.f47971g = i14;
                int i15 = this.f47970f;
                if (i14 != i15) {
                    continue;
                } else {
                    if (!this.f47972h) {
                        this.f47969e.R(i15);
                    } else {
                        if (u0.w(this.f47969e.d(), 0, this.f47970f, -1) != 0) {
                            this.f47973i = true;
                            return;
                        }
                        this.f47969e.R(this.f47970f - 4);
                    }
                    this.f47969e.S(0);
                    this.f47968d.c(this.f47969e);
                    this.f47971g = 0;
                }
            }
        }
    }
}
