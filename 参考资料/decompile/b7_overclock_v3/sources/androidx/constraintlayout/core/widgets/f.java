package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class f extends ConstraintWidget {
    public static final int I1 = 0;
    public static final int J1 = 1;
    public static final int K1 = 0;
    public static final int L1 = 1;
    public static final int M1 = 2;
    public static final int N1 = -1;
    public float A1 = -1.0f;
    public int B1 = -1;
    public int C1 = -1;
    public boolean D1 = true;
    public ConstraintAnchor E1 = this.R;
    public int F1 = 0;
    public int G1 = 0;
    public boolean H1;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3467a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f3467a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3467a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3467a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3467a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3467a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3467a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3467a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3467a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3467a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public f() {
        this.Z.clear();
        this.Z.add(this.E1);
        int length = this.Y.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.Y[i10] = this.E1;
        }
    }

    public void A2(int i10) {
        this.G1 = i10;
    }

    public void B2(int i10) {
        if (this.F1 == i10) {
            return;
        }
        this.F1 = i10;
        this.Z.clear();
        if (this.F1 == 1) {
            this.E1 = this.Q;
        } else {
            this.E1 = this.R;
        }
        this.Z.add(this.E1);
        int length = this.Y.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.Y[i11] = this.E1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean G0() {
        return this.H1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean H0() {
        return this.H1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String f0() {
        return "Guideline";
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        d dVar2 = (d) U();
        if (dVar2 == null) {
            return;
        }
        ConstraintAnchor constraintAnchorR = dVar2.r(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorR2 = dVar2.r(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f3240c0;
        boolean z11 = constraintWidget != null && constraintWidget.f3238b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.F1 == 0) {
            constraintAnchorR = dVar2.r(ConstraintAnchor.Type.TOP);
            constraintAnchorR2 = dVar2.r(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f3240c0;
            z11 = constraintWidget2 != null && constraintWidget2.f3238b0[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.H1 && this.E1.o()) {
            SolverVariable solverVariableU = dVar.u(this.E1);
            dVar.f(solverVariableU, this.E1.f());
            if (this.B1 != -1) {
                if (z11) {
                    dVar.i(dVar.u(constraintAnchorR2), solverVariableU, 0, 5);
                }
            } else if (this.C1 != -1 && z11) {
                SolverVariable solverVariableU2 = dVar.u(constraintAnchorR2);
                dVar.i(solverVariableU, dVar.u(constraintAnchorR), 0, 5);
                dVar.i(solverVariableU2, solverVariableU, 0, 5);
            }
            this.H1 = false;
            return;
        }
        if (this.B1 != -1) {
            SolverVariable solverVariableU3 = dVar.u(this.E1);
            dVar.e(solverVariableU3, dVar.u(constraintAnchorR), this.B1, 8);
            if (z11) {
                dVar.i(dVar.u(constraintAnchorR2), solverVariableU3, 0, 5);
                return;
            }
            return;
        }
        if (this.C1 == -1) {
            if (this.A1 != -1.0f) {
                dVar.d(androidx.constraintlayout.core.d.w(dVar, dVar.u(this.E1), dVar.u(constraintAnchorR2), this.A1));
                return;
            }
            return;
        }
        SolverVariable solverVariableU4 = dVar.u(this.E1);
        SolverVariable solverVariableU5 = dVar.u(constraintAnchorR2);
        dVar.e(solverVariableU4, solverVariableU5, -this.C1, 8);
        if (z11) {
            dVar.i(solverVariableU4, dVar.u(constraintAnchorR), 0, 5);
            dVar.i(solverVariableU5, solverVariableU4, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void j2(androidx.constraintlayout.core.d dVar, boolean z10) {
        if (U() == null) {
            return;
        }
        int iO = dVar.O(this.E1);
        if (this.F1 == 1) {
            f2(iO);
            g2(0);
            y1(U().D());
            c2(0);
            return;
        }
        f2(0);
        g2(iO);
        c2(U().m0());
        y1(0);
    }

    public void k2() {
        if (this.B1 != -1) {
            t2();
        } else if (this.A1 != -1.0f) {
            s2();
        } else if (this.C1 != -1) {
            r2();
        }
    }

    public ConstraintAnchor l2() {
        return this.E1;
    }

    public int m2() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        f fVar = (f) constraintWidget;
        this.A1 = fVar.A1;
        this.B1 = fVar.B1;
        this.C1 = fVar.C1;
        this.D1 = fVar.D1;
        B2(fVar.F1);
    }

    public int n2() {
        return this.B1;
    }

    public int o2() {
        if (this.A1 != -1.0f) {
            return 0;
        }
        if (this.B1 != -1) {
            return 1;
        }
        return this.C1 != -1 ? 2 : -1;
    }

    public int p2() {
        return this.C1;
    }

    public float q2() {
        return this.A1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor r(ConstraintAnchor.Type type) {
        int i10 = a.f3467a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.F1 == 1) {
                return this.E1;
            }
            return null;
        }
        if ((i10 == 3 || i10 == 4) && this.F1 == 0) {
            return this.E1;
        }
        return null;
    }

    public void r2() {
        int iO0 = o0();
        if (this.F1 == 0) {
            iO0 = p0();
        }
        w2(iO0);
    }

    public void s2() {
        int iM0 = U().m0() - o0();
        if (this.F1 == 0) {
            iM0 = U().D() - p0();
        }
        x2(iM0);
    }

    public void t2() {
        float fO0 = o0() / U().m0();
        if (this.F1 == 0) {
            fO0 = p0() / U().D();
        }
        y2(fO0);
    }

    public boolean u2() {
        return this.A1 != -1.0f && this.B1 == -1 && this.C1 == -1;
    }

    public void v2(int i10) {
        this.E1.A(i10);
        this.H1 = true;
    }

    public void w2(int i10) {
        if (i10 > -1) {
            this.A1 = -1.0f;
            this.B1 = i10;
            this.C1 = -1;
        }
    }

    public void x2(int i10) {
        if (i10 > -1) {
            this.A1 = -1.0f;
            this.B1 = -1;
            this.C1 = i10;
        }
    }

    public void y2(float f10) {
        if (f10 > -1.0f) {
            this.A1 = f10;
            this.B1 = -1;
            this.C1 = -1;
        }
    }

    public void z2(int i10) {
        y2(i10 / 100.0f);
    }
}
