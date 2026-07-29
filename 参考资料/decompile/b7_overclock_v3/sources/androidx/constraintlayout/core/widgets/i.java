package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class i extends y.b {
    public int C1 = 0;
    public int D1 = 0;
    public int E1 = 0;
    public int F1 = 0;
    public int G1 = 0;
    public int H1 = 0;
    public int I1 = 0;
    public int J1 = 0;
    public boolean K1 = false;
    public int L1 = 0;
    public int M1 = 0;
    public b.a N1 = new b.a();
    public b.InterfaceC0036b O1 = null;

    public void A2(int i10, int i11) {
        this.L1 = i10;
        this.M1 = i11;
    }

    public void B2(int i10) {
        this.E1 = i10;
        this.C1 = i10;
        this.F1 = i10;
        this.D1 = i10;
        this.G1 = i10;
        this.H1 = i10;
    }

    public void C2(int i10) {
        this.D1 = i10;
    }

    public void D2(int i10) {
        this.H1 = i10;
    }

    public void E2(int i10) {
        this.E1 = i10;
        this.I1 = i10;
    }

    public void F2(int i10) {
        this.F1 = i10;
        this.J1 = i10;
    }

    public void G2(int i10) {
        this.G1 = i10;
        this.I1 = i10;
        this.J1 = i10;
    }

    public void H2(int i10) {
        this.C1 = i10;
    }

    @Override // y.b, y.a
    public void c(d dVar) {
        n2();
    }

    public void m2(boolean z10) {
        int i10 = this.G1;
        if (i10 > 0 || this.H1 > 0) {
            if (z10) {
                this.I1 = this.H1;
                this.J1 = i10;
            } else {
                this.I1 = i10;
                this.J1 = this.H1;
            }
        }
    }

    public void n2() {
        for (int i10 = 0; i10 < this.B1; i10++) {
            ConstraintWidget constraintWidget = this.A1[i10];
            if (constraintWidget != null) {
                constraintWidget.I1(true);
            }
        }
    }

    public boolean o2(HashSet<ConstraintWidget> hashSet) {
        for (int i10 = 0; i10 < this.B1; i10++) {
            if (hashSet.contains(this.A1[i10])) {
                return true;
            }
        }
        return false;
    }

    public int p2() {
        return this.M1;
    }

    public int q2() {
        return this.L1;
    }

    public int r2() {
        return this.D1;
    }

    public int s2() {
        return this.I1;
    }

    public int t2() {
        return this.J1;
    }

    public int u2() {
        return this.C1;
    }

    public void v2(int i10, int i11, int i12, int i13) {
    }

    public void w2(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.O1 == null && U() != null) {
            this.O1 = ((d) U()).G2();
        }
        b.a aVar = this.N1;
        aVar.f3326a = dimensionBehaviour;
        aVar.f3327b = dimensionBehaviour2;
        aVar.f3328c = i10;
        aVar.f3329d = i11;
        this.O1.b(constraintWidget, aVar);
        constraintWidget.c2(this.N1.f3330e);
        constraintWidget.y1(this.N1.f3331f);
        constraintWidget.x1(this.N1.f3333h);
        constraintWidget.g1(this.N1.f3332g);
    }

    public boolean x2() {
        ConstraintWidget constraintWidget = this.f3240c0;
        b.InterfaceC0036b interfaceC0036bG2 = constraintWidget != null ? ((d) constraintWidget).G2() : null;
        if (interfaceC0036bG2 == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.B1) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.A1[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourZ = constraintWidget2.z(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourZ2 = constraintWidget2.z(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (!(dimensionBehaviourZ == dimensionBehaviour && constraintWidget2.f3279w != 1 && dimensionBehaviourZ2 == dimensionBehaviour && constraintWidget2.f3281x != 1)) {
                    if (dimensionBehaviourZ == dimensionBehaviour) {
                        dimensionBehaviourZ = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviourZ2 == dimensionBehaviour) {
                        dimensionBehaviourZ2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    b.a aVar = this.N1;
                    aVar.f3326a = dimensionBehaviourZ;
                    aVar.f3327b = dimensionBehaviourZ2;
                    aVar.f3328c = constraintWidget2.m0();
                    this.N1.f3329d = constraintWidget2.D();
                    interfaceC0036bG2.b(constraintWidget2, this.N1);
                    constraintWidget2.c2(this.N1.f3330e);
                    constraintWidget2.y1(this.N1.f3331f);
                    constraintWidget2.g1(this.N1.f3332g);
                }
            }
            i10++;
        }
    }

    public boolean y2() {
        return this.K1;
    }

    public void z2(boolean z10) {
        this.K1 = z10;
    }
}
