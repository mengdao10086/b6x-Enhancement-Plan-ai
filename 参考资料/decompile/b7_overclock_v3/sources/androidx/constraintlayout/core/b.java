package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f2961g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f2962h = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f2967e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SolverVariable f2963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2964b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2965c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<SolverVariable> f2966d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2968f = false;

    public interface a {
        void clear();

        int e();

        void f();

        int g(SolverVariable solverVariable);

        void h();

        boolean i(SolverVariable solverVariable);

        float j(b bVar, boolean z10);

        void k(SolverVariable solverVariable, float f10);

        SolverVariable l(int i10);

        void m(SolverVariable solverVariable, float f10, boolean z10);

        float n(int i10);

        float o(SolverVariable solverVariable, boolean z10);

        float p(SolverVariable solverVariable);

        int q();

        void r(float f10);
    }

    public b() {
    }

    public SolverVariable A(SolverVariable solverVariable) {
        return B(null, solverVariable);
    }

    public final SolverVariable B(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int iE = this.f2967e.e();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < iE; i10++) {
            float fN = this.f2967e.n(i10);
            if (fN < 0.0f) {
                SolverVariable solverVariableL = this.f2967e.l(i10);
                if ((zArr == null || !zArr[solverVariableL.f2930c]) && solverVariableL != solverVariable && (((type = solverVariableL.f2937j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && fN < f10)) {
                    f10 = fN;
                    solverVariable2 = solverVariableL;
                }
            }
        }
        return solverVariable2;
    }

    public void C(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f2963a;
        if (solverVariable2 != null) {
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2963a.f2931d = -1;
            this.f2963a = null;
        }
        float fO = this.f2967e.o(solverVariable, true) * (-1.0f);
        this.f2963a = solverVariable;
        if (fO == 1.0f) {
            return;
        }
        this.f2964b /= fO;
        this.f2967e.r(fO);
    }

    public void D() {
        this.f2963a = null;
        this.f2967e.clear();
        this.f2964b = 0.0f;
        this.f2968f = false;
    }

    public int E() {
        return (this.f2963a != null ? 4 : 0) + 4 + 4 + this.f2967e.q();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String F() {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.F():java.lang.String");
    }

    public void G(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f2941n) {
            return;
        }
        float fP = this.f2967e.p(solverVariable);
        this.f2964b += solverVariable.f2943p * fP;
        this.f2967e.o(solverVariable, z10);
        if (z10) {
            solverVariable.i(this);
        }
        this.f2967e.m(dVar.f2995n.f2972d[solverVariable.f2942o], fP, z10);
        if (d.f2979x && this.f2967e.e() == 0) {
            this.f2968f = true;
            dVar.f2982a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void a(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable == null || !solverVariable.f2934g) {
            return;
        }
        this.f2964b += solverVariable.f2933f * this.f2967e.p(solverVariable);
        this.f2967e.o(solverVariable, z10);
        if (z10) {
            solverVariable.i(this);
        }
        if (d.f2979x && this.f2967e.e() == 0) {
            this.f2968f = true;
            dVar.f2982a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void b(d dVar) {
        if (dVar.f2988g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int iE = this.f2967e.e();
            for (int i10 = 0; i10 < iE; i10++) {
                SolverVariable solverVariableL = this.f2967e.l(i10);
                if (solverVariableL.f2931d != -1 || solverVariableL.f2934g || solverVariableL.f2941n) {
                    this.f2966d.add(solverVariableL);
                }
            }
            int size = this.f2966d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    SolverVariable solverVariable = this.f2966d.get(i11);
                    if (solverVariable.f2934g) {
                        a(dVar, solverVariable, true);
                    } else if (solverVariable.f2941n) {
                        G(dVar, solverVariable, true);
                    } else {
                        c(dVar, dVar.f2988g[solverVariable.f2931d], true);
                    }
                }
                this.f2966d.clear();
            } else {
                z10 = true;
            }
        }
        if (d.f2979x && this.f2963a != null && this.f2967e.e() == 0) {
            this.f2968f = true;
            dVar.f2982a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void c(d dVar, b bVar, boolean z10) {
        this.f2964b += bVar.f2964b * this.f2967e.j(bVar, z10);
        if (z10) {
            bVar.f2963a.i(this);
        }
        if (d.f2979x && this.f2963a != null && this.f2967e.e() == 0) {
            this.f2968f = true;
            dVar.f2982a = true;
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void clear() {
        this.f2967e.clear();
        this.f2963a = null;
        this.f2964b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.d.a
    public void d(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f2963a = null;
            this.f2967e.clear();
            for (int i10 = 0; i10 < bVar.f2967e.e(); i10++) {
                this.f2967e.m(bVar.f2967e.l(i10), bVar.f2967e.n(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable e(d dVar, boolean[] zArr) {
        return B(zArr, null);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void f(SolverVariable solverVariable) {
        int i10 = solverVariable.f2932e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f2967e.k(solverVariable, f10);
    }

    public b g(d dVar, int i10) {
        this.f2967e.k(dVar.s(i10, "ep"), 1.0f);
        this.f2967e.k(dVar.s(i10, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable getKey() {
        return this.f2963a;
    }

    public b h(SolverVariable solverVariable, int i10) {
        this.f2967e.k(solverVariable, i10);
        return this;
    }

    public boolean i(d dVar) {
        boolean z10;
        SolverVariable solverVariableJ = j(dVar);
        if (solverVariableJ == null) {
            z10 = true;
        } else {
            C(solverVariableJ);
            z10 = false;
        }
        if (this.f2967e.e() == 0) {
            this.f2968f = true;
        }
        return z10;
    }

    @Override // androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f2963a == null && this.f2964b == 0.0f && this.f2967e.e() == 0;
    }

    public SolverVariable j(d dVar) {
        int iE = this.f2967e.e();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < iE; i10++) {
            float fN = this.f2967e.n(i10);
            SolverVariable solverVariableL = this.f2967e.l(i10);
            if (solverVariableL.f2937j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f10 > fN) {
                    boolean z12 = z(solverVariableL, dVar);
                    z10 = z12;
                    f10 = fN;
                    solverVariable = solverVariableL;
                } else if (!z10 && z(solverVariableL, dVar)) {
                    f10 = fN;
                    solverVariable = solverVariableL;
                    z10 = true;
                }
            } else if (solverVariable == null && fN < 0.0f) {
                if (solverVariable2 == null || f11 > fN) {
                    boolean z13 = z(solverVariableL, dVar);
                    z11 = z13;
                    f11 = fN;
                    solverVariable2 = solverVariableL;
                } else if (!z11 && z(solverVariableL, dVar)) {
                    f11 = fN;
                    solverVariable2 = solverVariableL;
                    z11 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable4, 1.0f);
            this.f2967e.k(solverVariable2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable3, -1.0f);
            this.f2967e.k(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f2964b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            this.f2967e.k(solverVariable, -1.0f);
            this.f2967e.k(solverVariable2, 1.0f);
            this.f2964b = i10;
        } else if (f10 >= 1.0f) {
            this.f2967e.k(solverVariable4, -1.0f);
            this.f2967e.k(solverVariable3, 1.0f);
            this.f2964b = -i11;
        } else {
            float f11 = 1.0f - f10;
            this.f2967e.k(solverVariable, f11 * 1.0f);
            this.f2967e.k(solverVariable2, f11 * (-1.0f));
            this.f2967e.k(solverVariable3, (-1.0f) * f10);
            this.f2967e.k(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f2964b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    public b l(SolverVariable solverVariable, int i10) {
        this.f2963a = solverVariable;
        float f10 = i10;
        solverVariable.f2933f = f10;
        this.f2964b = f10;
        this.f2968f = true;
        return this;
    }

    public b m(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.f2967e.k(solverVariable, -1.0f);
        this.f2967e.k(solverVariable2, f10);
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f2967e.k(solverVariable, -1.0f);
        this.f2967e.k(solverVariable2, 1.0f);
        this.f2967e.k(solverVariable3, f10);
        this.f2967e.k(solverVariable4, -f10);
        return this;
    }

    public b o(float f10, float f11, float f12, SolverVariable solverVariable, int i10, SolverVariable solverVariable2, int i11, SolverVariable solverVariable3, int i12, SolverVariable solverVariable4, int i13) {
        if (f11 == 0.0f || f10 == f12) {
            this.f2964b = ((-i10) - i11) + i12 + i13;
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable4, 1.0f);
            this.f2967e.k(solverVariable3, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f2964b = ((-i10) - i11) + (i12 * f13) + (i13 * f13);
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable4, f13);
            this.f2967e.k(solverVariable3, -f13);
        }
        return this;
    }

    public b p(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f2964b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable4, 1.0f);
            this.f2967e.k(solverVariable3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f2967e.k(solverVariable3, 1.0f);
            this.f2967e.k(solverVariable4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable4, f13);
            this.f2967e.k(solverVariable3, -f13);
        }
        return this;
    }

    public b q(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f2964b = i10 * (-1);
            this.f2967e.k(solverVariable, 1.0f);
        } else {
            this.f2964b = i10;
            this.f2967e.k(solverVariable, -1.0f);
        }
        return this;
    }

    public b r(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f2964b = i10;
        }
        if (z10) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
        } else {
            this.f2967e.k(solverVariable, -1.0f);
            this.f2967e.k(solverVariable2, 1.0f);
        }
        return this;
    }

    public b s(SolverVariable solverVariable, int i10, SolverVariable solverVariable2) {
        this.f2964b = i10;
        this.f2967e.k(solverVariable, -1.0f);
        return this;
    }

    public b t(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f2964b = i10;
        }
        if (z10) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable3, -1.0f);
        } else {
            this.f2967e.k(solverVariable, -1.0f);
            this.f2967e.k(solverVariable2, 1.0f);
            this.f2967e.k(solverVariable3, 1.0f);
        }
        return this;
    }

    public String toString() {
        return F();
    }

    public b u(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f2964b = i10;
        }
        if (z10) {
            this.f2967e.k(solverVariable, 1.0f);
            this.f2967e.k(solverVariable2, -1.0f);
            this.f2967e.k(solverVariable3, 1.0f);
        } else {
            this.f2967e.k(solverVariable, -1.0f);
            this.f2967e.k(solverVariable2, 1.0f);
            this.f2967e.k(solverVariable3, -1.0f);
        }
        return this;
    }

    public b v(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f2967e.k(solverVariable3, 0.5f);
        this.f2967e.k(solverVariable4, 0.5f);
        this.f2967e.k(solverVariable, -0.5f);
        this.f2967e.k(solverVariable2, -0.5f);
        this.f2964b = -f10;
        return this;
    }

    public void w() {
        float f10 = this.f2964b;
        if (f10 < 0.0f) {
            this.f2964b = f10 * (-1.0f);
            this.f2967e.f();
        }
    }

    public boolean x() {
        SolverVariable solverVariable = this.f2963a;
        return solverVariable != null && (solverVariable.f2937j == SolverVariable.Type.UNRESTRICTED || this.f2964b >= 0.0f);
    }

    public boolean y(SolverVariable solverVariable) {
        return this.f2967e.i(solverVariable);
    }

    public final boolean z(SolverVariable solverVariable, d dVar) {
        return solverVariable.f2940m <= 1;
    }

    public b(c cVar) {
        this.f2967e = new androidx.constraintlayout.core.a(this, cVar);
    }
}
