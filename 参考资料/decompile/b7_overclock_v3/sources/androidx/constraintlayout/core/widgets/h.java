package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* JADX INFO: loaded from: classes2.dex */
public class h extends i {
    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        super.g(dVar, z10);
        if (this.B1 > 0) {
            ConstraintWidget constraintWidget = this.A1[0];
            constraintWidget.S0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.i
    public void v2(int i10, int i11, int i12, int i13) {
        int iS2 = s2() + t2() + 0;
        int iU2 = u2() + r2() + 0;
        if (this.B1 > 0) {
            iS2 += this.A1[0].m0();
            iU2 += this.A1[0].D();
        }
        int iMax = Math.max(Q(), iS2);
        int iMax2 = Math.max(P(), iU2);
        if (i10 != 1073741824) {
            i11 = i10 == Integer.MIN_VALUE ? Math.min(iMax, i11) : i10 == 0 ? iMax : 0;
        }
        if (i12 != 1073741824) {
            i13 = i12 == Integer.MIN_VALUE ? Math.min(iMax2, i13) : i12 == 0 ? iMax2 : 0;
        }
        A2(i11, i13);
        c2(i11);
        y1(i13);
        z2(this.B1 > 0);
    }
}
