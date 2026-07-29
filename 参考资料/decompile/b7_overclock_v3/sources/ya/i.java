package ya;

import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class i implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56788d = 15000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56789e = 5000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56790f = 3000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.c f56791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f56792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f56793c;

    public i() {
        this(15000L, 5000L);
    }

    public static void p(j1 j1Var, long j10) {
        long jH1 = j1Var.H1() + j10;
        long jM1 = j1Var.m1();
        if (jM1 != g.f56663b) {
            jH1 = Math.min(jH1, jM1);
        }
        j1Var.B(j1Var.r0(), Math.max(jH1, 0L));
    }

    @Override // ya.h
    public boolean a(j1 j1Var) {
        if (!m() || !j1Var.V()) {
            return true;
        }
        p(j1Var, this.f56793c);
        return true;
    }

    @Override // ya.h
    public boolean b(j1 j1Var, int i10, long j10) {
        j1Var.B(i10, j10);
        return true;
    }

    @Override // ya.h
    public boolean c(j1 j1Var, boolean z10) {
        j1Var.J(z10);
        return true;
    }

    @Override // ya.h
    public boolean d(j1 j1Var, int i10) {
        j1Var.j(i10);
        return true;
    }

    @Override // ya.h
    public boolean e() {
        return this.f56792b > 0;
    }

    @Override // ya.h
    public boolean f(j1 j1Var) {
        x1 x1VarN1 = j1Var.n1();
        if (!x1VarN1.r() && !j1Var.r()) {
            int iR0 = j1Var.r0();
            x1VarN1.n(iR0, this.f56791a);
            int iX0 = j1Var.X0();
            if (iX0 != -1) {
                j1Var.B(iX0, g.f56663b);
            } else if (this.f56791a.h() && this.f56791a.f57248i) {
                j1Var.B(iR0, g.f56663b);
            }
        }
        return true;
    }

    @Override // ya.h
    public boolean g(j1 j1Var) {
        j1Var.f();
        return true;
    }

    @Override // ya.h
    public boolean h(j1 j1Var, boolean z10) {
        j1Var.x0(z10);
        return true;
    }

    @Override // ya.h
    public boolean i(j1 j1Var, h1 h1Var) {
        j1Var.c(h1Var);
        return true;
    }

    @Override // ya.h
    public boolean j(j1 j1Var, boolean z10) {
        j1Var.H(z10);
        return true;
    }

    @Override // ya.h
    public boolean k(j1 j1Var) {
        if (!e() || !j1Var.V()) {
            return true;
        }
        p(j1Var, -this.f56792b);
        return true;
    }

    @Override // ya.h
    public boolean l(j1 j1Var) {
        x1 x1VarN1 = j1Var.n1();
        if (!x1VarN1.r() && !j1Var.r()) {
            int iR0 = j1Var.r0();
            x1VarN1.n(iR0, this.f56791a);
            int iF0 = j1Var.F0();
            boolean z10 = this.f56791a.h() && !this.f56791a.f57247h;
            if (iF0 != -1 && (j1Var.H1() <= 3000 || z10)) {
                j1Var.B(iF0, g.f56663b);
            } else if (!z10) {
                j1Var.B(iR0, 0L);
            }
        }
        return true;
    }

    @Override // ya.h
    public boolean m() {
        return this.f56793c > 0;
    }

    public long n() {
        return this.f56793c;
    }

    public long o() {
        return this.f56792b;
    }

    @Deprecated
    public void q(long j10) {
        this.f56793c = j10;
    }

    @Deprecated
    public void r(long j10) {
        this.f56792b = j10;
    }

    public i(long j10, long j11) {
        this.f56793c = j10;
        this.f56792b = j11;
        this.f56791a = new x1.c();
    }
}
