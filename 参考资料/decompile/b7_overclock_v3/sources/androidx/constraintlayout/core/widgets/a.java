package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends y.b {
    public static final int G1 = 0;
    public static final int H1 = 1;
    public static final int I1 = 2;
    public static final int J1 = 3;
    public static final boolean K1 = true;
    public static final boolean L1 = false;
    public int C1 = 0;
    public boolean D1 = true;
    public int E1 = 0;
    public boolean F1 = false;

    public a() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean G0() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean H0() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z11;
        int i10;
        int i11;
        int i12;
        ConstraintAnchor[] constraintAnchorArr2 = this.Y;
        constraintAnchorArr2[0] = this.Q;
        constraintAnchorArr2[2] = this.R;
        constraintAnchorArr2[1] = this.S;
        constraintAnchorArr2[3] = this.T;
        int i13 = 0;
        while (true) {
            constraintAnchorArr = this.Y;
            if (i13 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i13].f3207i = dVar.u(constraintAnchorArr[i13]);
            i13++;
        }
        int i14 = this.C1;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i14];
        if (!this.F1) {
            m2();
        }
        if (this.F1) {
            this.F1 = false;
            int i15 = this.C1;
            if (i15 == 0 || i15 == 1) {
                dVar.f(this.Q.f3207i, this.f3250h0);
                dVar.f(this.S.f3207i, this.f3250h0);
                return;
            } else {
                if (i15 == 2 || i15 == 3) {
                    dVar.f(this.R.f3207i, this.f3252i0);
                    dVar.f(this.T.f3207i, this.f3252i0);
                    return;
                }
                return;
            }
        }
        for (int i16 = 0; i16 < this.B1; i16++) {
            ConstraintWidget constraintWidget = this.A1[i16];
            if ((this.D1 || constraintWidget.h()) && ((((i11 = this.C1) == 0 || i11 == 1) && constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.Q.f3204f != null && constraintWidget.S.f3204f != null) || (((i12 = this.C1) == 2 || i12 == 3) && constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.R.f3204f != null && constraintWidget.T.f3204f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.Q.m() || this.S.m();
        boolean z13 = this.R.m() || this.T.m();
        int i17 = !z11 && (((i10 = this.C1) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13)))) ? 5 : 4;
        for (int i18 = 0; i18 < this.B1; i18++) {
            ConstraintWidget constraintWidget2 = this.A1[i18];
            if (this.D1 || constraintWidget2.h()) {
                SolverVariable solverVariableU = dVar.u(constraintWidget2.Y[this.C1]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.Y;
                int i19 = this.C1;
                constraintAnchorArr3[i19].f3207i = solverVariableU;
                int i20 = (constraintAnchorArr3[i19].f3204f == null || constraintAnchorArr3[i19].f3204f.f3202d != this) ? 0 : constraintAnchorArr3[i19].f3205g + 0;
                if (i19 == 0 || i19 == 2) {
                    dVar.j(constraintAnchor.f3207i, solverVariableU, this.E1 - i20, z11);
                } else {
                    dVar.h(constraintAnchor.f3207i, solverVariableU, this.E1 + i20, z11);
                }
                dVar.e(constraintAnchor.f3207i, solverVariableU, this.E1 + i20, i17);
            }
        }
        int i21 = this.C1;
        if (i21 == 0) {
            dVar.e(this.S.f3207i, this.Q.f3207i, 0, 8);
            dVar.e(this.Q.f3207i, this.f3240c0.S.f3207i, 0, 4);
            dVar.e(this.Q.f3207i, this.f3240c0.Q.f3207i, 0, 0);
            return;
        }
        if (i21 == 1) {
            dVar.e(this.Q.f3207i, this.S.f3207i, 0, 8);
            dVar.e(this.Q.f3207i, this.f3240c0.Q.f3207i, 0, 4);
            dVar.e(this.Q.f3207i, this.f3240c0.S.f3207i, 0, 0);
        } else if (i21 == 2) {
            dVar.e(this.T.f3207i, this.R.f3207i, 0, 8);
            dVar.e(this.R.f3207i, this.f3240c0.T.f3207i, 0, 4);
            dVar.e(this.R.f3207i, this.f3240c0.R.f3207i, 0, 0);
        } else if (i21 == 3) {
            dVar.e(this.R.f3207i, this.T.f3207i, 0, 8);
            dVar.e(this.R.f3207i, this.f3240c0.R.f3207i, 0, 4);
            dVar.e(this.R.f3207i, this.f3240c0.T.f3207i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    public boolean m2() {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.B1;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.A1[i13];
            if ((this.D1 || constraintWidget.h()) && ((((i11 = this.C1) == 0 || i11 == 1) && !constraintWidget.G0()) || (((i12 = this.C1) == 2 || i12 == 3) && !constraintWidget.H0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i14 = 0; i14 < this.B1; i14++) {
            ConstraintWidget constraintWidget2 = this.A1[i14];
            if (this.D1 || constraintWidget2.h()) {
                if (!z11) {
                    int i15 = this.C1;
                    if (i15 == 0) {
                        iMax = constraintWidget2.r(ConstraintAnchor.Type.LEFT).f();
                    } else if (i15 == 1) {
                        iMax = constraintWidget2.r(ConstraintAnchor.Type.RIGHT).f();
                    } else if (i15 == 2) {
                        iMax = constraintWidget2.r(ConstraintAnchor.Type.TOP).f();
                    } else if (i15 == 3) {
                        iMax = constraintWidget2.r(ConstraintAnchor.Type.BOTTOM).f();
                    }
                    z11 = true;
                }
                int i16 = this.C1;
                if (i16 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.r(ConstraintAnchor.Type.LEFT).f());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.r(ConstraintAnchor.Type.RIGHT).f());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.r(ConstraintAnchor.Type.TOP).f());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.r(ConstraintAnchor.Type.BOTTOM).f());
                }
            }
        }
        int i17 = iMax + this.E1;
        int i18 = this.C1;
        if (i18 == 0 || i18 == 1) {
            q1(i17, i17);
        } else {
            t1(i17, i17);
        }
        this.F1 = true;
        return true;
    }

    @Override // y.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        a aVar = (a) constraintWidget;
        this.C1 = aVar.C1;
        this.D1 = aVar.D1;
        this.E1 = aVar.E1;
    }

    @Deprecated
    public boolean n2() {
        return this.D1;
    }

    public boolean o2() {
        return this.D1;
    }

    public int p2() {
        return this.C1;
    }

    public int q2() {
        return this.E1;
    }

    public int r2() {
        int i10 = this.C1;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    public void s2() {
        for (int i10 = 0; i10 < this.B1; i10++) {
            ConstraintWidget constraintWidget = this.A1[i10];
            if (this.D1 || constraintWidget.h()) {
                int i11 = this.C1;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.G1(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.G1(1, true);
                }
            }
        }
    }

    public void t2(boolean z10) {
        this.D1 = z10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + y() + " {";
        for (int i10 = 0; i10 < this.B1; i10++) {
            ConstraintWidget constraintWidget = this.A1[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.y();
        }
        return str + zc.a.f58317e;
    }

    public void u2(int i10) {
        this.C1 = i10;
    }

    public void v2(int i10) {
        this.E1 = i10;
    }

    public a(String str) {
        j1(str);
    }
}
