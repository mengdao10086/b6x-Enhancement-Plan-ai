package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t0 f29729f = new a(l.class, 8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f29730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f29731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f29732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c0 f29734e;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return f0Var.O();
        }
    }

    public l(f0 f0Var) {
        int i10 = 0;
        c0 c0VarR = R(f0Var, 0);
        if (c0VarR instanceof y) {
            this.f29730a = (y) c0VarR;
            c0VarR = R(f0Var, 1);
            i10 = 1;
        }
        if (c0VarR instanceof t) {
            this.f29731b = (t) c0VarR;
            i10++;
            c0VarR = R(f0Var, i10);
        }
        if (!(c0VarR instanceof n0)) {
            this.f29732c = c0VarR;
            i10++;
            c0VarR = R(f0Var, i10);
        }
        if (f0Var.size() != i10 + 1) {
            throw new IllegalArgumentException("input sequence too large");
        }
        if (!(c0VarR instanceof n0)) {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
        n0 n0Var = (n0) c0VarR;
        this.f29733d = H(n0Var.q());
        this.f29734e = N(n0Var);
    }

    public l(y yVar, t tVar, c0 c0Var, int i10, c0 c0Var2) {
        this.f29730a = yVar;
        this.f29731b = tVar;
        this.f29732c = c0Var;
        this.f29733d = H(i10);
        this.f29734e = I(i10, c0Var2);
    }

    public l(y yVar, t tVar, c0 c0Var, n2 n2Var) {
        this.f29730a = yVar;
        this.f29731b = tVar;
        this.f29732c = c0Var;
        this.f29733d = H(n2Var.q());
        this.f29734e = N(n2Var);
    }

    public static int H(int i10) {
        if (i10 >= 0 && i10 <= 2) {
            return i10;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i10);
    }

    public static c0 I(int i10, c0 c0Var) {
        t0 t0Var;
        if (i10 == 1) {
            t0Var = z.f29834b;
        } else {
            if (i10 != 2) {
                return c0Var;
            }
            t0Var = d.f29649b;
        }
        return t0Var.b(c0Var);
    }

    public static c0 N(n0 n0Var) {
        int iR = n0Var.r();
        int iQ = n0Var.q();
        if (128 != iR) {
            throw new IllegalArgumentException("invalid tag: " + v0.k(iR, iQ));
        }
        if (iQ == 0) {
            return n0Var.P().b();
        }
        if (iQ == 1) {
            return z.H(n0Var, false);
        }
        if (iQ == 2) {
            return d.J(n0Var, false);
        }
        throw new IllegalArgumentException("invalid tag: " + v0.k(iR, iQ));
    }

    public static l P(n0 n0Var, boolean z10) {
        return (l) f29729f.f(n0Var, z10);
    }

    public static l Q(Object obj) {
        if (obj == null || (obj instanceof l)) {
            return (l) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof l) {
                return (l) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (l) f29729f.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct external from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static c0 R(f0 f0Var, int i10) {
        if (f0Var.size() > i10) {
            return f0Var.K(i10).b();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }

    @Override // gm.c0
    public int A(boolean z10) throws IOException {
        return G().A(z10);
    }

    @Override // gm.c0
    public c0 E() {
        return new v1(this.f29730a, this.f29731b, this.f29732c, this.f29733d, this.f29734e);
    }

    @Override // gm.c0
    public c0 F() {
        return new w2(this.f29730a, this.f29731b, this.f29732c, this.f29733d, this.f29734e);
    }

    public abstract f0 G();

    public c0 J() {
        return this.f29732c;
    }

    public y K() {
        return this.f29730a;
    }

    public int L() {
        return this.f29733d;
    }

    public c0 M() {
        return this.f29734e;
    }

    public t O() {
        return this.f29731b;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return (((org.bouncycastle.util.n.b(this.f29730a) ^ org.bouncycastle.util.n.b(this.f29731b)) ^ org.bouncycastle.util.n.b(this.f29732c)) ^ this.f29733d) ^ this.f29734e.hashCode();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (this == c0Var) {
            return true;
        }
        if (!(c0Var instanceof l)) {
            return false;
        }
        l lVar = (l) c0Var;
        return org.bouncycastle.util.n.a(this.f29730a, lVar.f29730a) && org.bouncycastle.util.n.a(this.f29731b, lVar.f29731b) && org.bouncycastle.util.n.a(this.f29732c, lVar.f29732c) && this.f29733d == lVar.f29733d && this.f29734e.C(lVar.f29734e);
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 40);
        G().y(b0Var, false);
    }

    @Override // gm.c0
    public boolean z() {
        return true;
    }
}
