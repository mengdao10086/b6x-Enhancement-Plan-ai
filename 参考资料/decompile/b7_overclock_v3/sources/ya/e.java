package ya;

import java.util.Collections;
import java.util.List;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements j1 {
    public final x1.c O = new x1.c();

    @Override // ya.j1
    public void D0(v0 v0Var) {
        F1(Collections.singletonList(v0Var));
    }

    @Override // ya.j1
    public void D1(v0 v0Var, long j10) {
        v0(Collections.singletonList(v0Var), 0, j10);
    }

    @Override // ya.j1
    public final int F0() {
        x1 x1VarN1 = n1();
        if (x1VarN1.r()) {
            return -1;
        }
        return x1VarN1.l(r0(), L1(), u1());
    }

    @Override // ya.j1
    public void F1(List<v0> list) {
        b0(list, true);
    }

    @Override // ya.j1
    @g.p0
    public final v0 G() {
        x1 x1VarN1 = n1();
        if (x1VarN1.r()) {
            return null;
        }
        return x1VarN1.n(r0(), this.O).f57242c;
    }

    @Override // ya.j1
    public void G0(v0 v0Var) {
        k1(Collections.singletonList(v0Var));
    }

    @Override // ya.j1
    @g.p0
    public final Object H0() {
        x1 x1VarN1 = n1();
        if (x1VarN1.r()) {
            return null;
        }
        return x1VarN1.n(r0(), this.O).f57243d;
    }

    @Override // ya.j1
    public void J1(int i10, v0 v0Var) {
        E0(i10, Collections.singletonList(v0Var));
    }

    public final int L1() {
        int iK = k();
        if (iK == 1) {
            return 0;
        }
        return iK;
    }

    @Override // ya.j1
    public final int N() {
        long jI0 = I0();
        long jM1 = m1();
        if (jI0 == g.f56663b || jM1 == g.f56663b) {
            return 0;
        }
        if (jM1 == 0) {
            return 100;
        }
        return hd.u0.t((int) ((jI0 * 100) / jM1), 0, 100);
    }

    @Override // ya.j1
    public final boolean N0() {
        return d() == 3 && D() && j1() == 0;
    }

    @Override // ya.j1
    public v0 Q(int i10) {
        return n1().n(i10, this.O).f57242c;
    }

    @Override // ya.j1
    public final long T() {
        x1 x1VarN1 = n1();
        return x1VarN1.r() ? g.f56663b : x1VarN1.n(r0(), this.O).d();
    }

    @Override // ya.j1
    public final boolean V() {
        x1 x1VarN1 = n1();
        return !x1VarN1.r() && x1VarN1.n(r0(), this.O).f57247h;
    }

    @Override // ya.j1
    public final int X0() {
        x1 x1VarN1 = n1();
        if (x1VarN1.r()) {
            return -1;
        }
        return x1VarN1.e(r0(), L1(), u1());
    }

    @Override // ya.j1
    public void Y0(v0 v0Var, boolean z10) {
        b0(Collections.singletonList(v0Var), z10);
    }

    @Override // ya.j1
    public final void Z() {
        z0(r0());
    }

    @Override // ya.j1
    public void f1(int i10, int i11) {
        if (i10 != i11) {
            h1(i10, i10 + 1, i11);
        }
    }

    @Override // ya.j1
    public final void g(long j10) {
        B(r0(), j10);
    }

    @Override // ya.j1
    public final boolean g1() {
        x1 x1VarN1 = n1();
        return !x1VarN1.r() && x1VarN1.n(r0(), this.O).h();
    }

    @Override // ya.j1
    public final boolean hasNext() {
        return X0() != -1;
    }

    @Override // ya.j1
    public final boolean hasPrevious() {
        return F0() != -1;
    }

    @Override // ya.j1
    public final void i() {
        x0(true);
    }

    @Override // ya.j1
    public final boolean j0() {
        x1 x1VarN1 = n1();
        return !x1VarN1.r() && x1VarN1.n(r0(), this.O).f57248i;
    }

    @Override // ya.j1
    @g.p0
    @Deprecated
    public final Object k0() {
        v0.g gVar;
        x1 x1VarN1 = n1();
        if (x1VarN1.r() || (gVar = x1VarN1.n(r0(), this.O).f57242c.f57132b) == null) {
            return null;
        }
        return gVar.f57190h;
    }

    @Override // ya.j1
    public void m0(int i10) {
        p0(i10, i10 + 1);
    }

    @Override // ya.j1
    public int n0() {
        return n1().q();
    }

    @Override // ya.j1
    public final void next() {
        int iX0 = X0();
        if (iX0 != -1) {
            z0(iX0);
        }
    }

    @Override // ya.j1
    public final void pause() {
        x0(false);
    }

    @Override // ya.j1
    public final void previous() {
        int iF0 = F0();
        if (iF0 != -1) {
            z0(iF0);
        }
    }

    @Override // ya.j1
    public final void stop() {
        J(false);
    }

    @Override // ya.j1
    public final long x() {
        x1 x1VarN1 = n1();
        return (x1VarN1.r() || x1VarN1.n(r0(), this.O).f57245f == g.f56663b) ? g.f56663b : (this.O.a() - this.O.f57245f) - C0();
    }

    @Override // ya.j1
    public final void z0(int i10) {
        B(i10, g.f56663b);
    }
}
