package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class d extends y.d {

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final int f3413g2 = 8;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final boolean f3414h2 = false;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final boolean f3415i2 = false;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final boolean f3416j2 = false;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static int f3417k2;
    public androidx.constraintlayout.core.widgets.analyzer.b B1;
    public androidx.constraintlayout.core.widgets.analyzer.e C1;
    public int D1;
    public b.InterfaceC0036b E1;
    public boolean F1;
    public s.b G1;
    public androidx.constraintlayout.core.d H1;
    public int I1;
    public int J1;
    public int K1;
    public int L1;
    public int M1;
    public int N1;
    public c[] O1;
    public c[] P1;
    public boolean Q1;
    public boolean R1;
    public boolean S1;
    public int T1;
    public int U1;
    public int V1;
    public boolean W1;
    public boolean X1;
    public boolean Y1;
    public int Z1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f3418a2;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f3419b2;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f3420c2;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f3421d2;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public HashSet<ConstraintWidget> f3422e2;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public b.a f3423f2;

    public d() {
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.d();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3418a2 = null;
        this.f3419b2 = null;
        this.f3420c2 = null;
        this.f3421d2 = null;
        this.f3422e2 = new HashSet<>();
        this.f3423f2 = new b.a();
    }

    public static boolean R2(int i10, ConstraintWidget constraintWidget, b.InterfaceC0036b interfaceC0036b, b.a aVar, int i11) {
        int i12;
        int i13;
        if (interfaceC0036b == null) {
            return false;
        }
        if (constraintWidget.l0() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f3330e = 0;
            aVar.f3331f = 0;
            return false;
        }
        aVar.f3326a = constraintWidget.H();
        aVar.f3327b = constraintWidget.j0();
        aVar.f3328c = constraintWidget.m0();
        aVar.f3329d = constraintWidget.D();
        aVar.f3334i = false;
        aVar.f3335j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f3326a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f3327b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f3246f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f3246f0 > 0.0f;
        if (z10 && constraintWidget.r0(0) && constraintWidget.f3279w == 0 && !z12) {
            aVar.f3326a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f3281x == 0) {
                aVar.f3326a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.r0(1) && constraintWidget.f3281x == 0 && !z13) {
            aVar.f3327b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f3279w == 0) {
                aVar.f3327b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.G0()) {
            aVar.f3326a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.H0()) {
            aVar.f3327b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f3283y[0] == 4) {
                aVar.f3326a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f3327b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i13 = aVar.f3329d;
                } else {
                    aVar.f3326a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0036b.b(constraintWidget, aVar);
                    i13 = aVar.f3331f;
                }
                aVar.f3326a = dimensionBehaviour4;
                aVar.f3328c = (int) (constraintWidget.A() * i13);
            }
        }
        if (z13) {
            if (constraintWidget.f3283y[1] == 4) {
                aVar.f3327b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f3326a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i12 = aVar.f3328c;
                } else {
                    aVar.f3327b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0036b.b(constraintWidget, aVar);
                    i12 = aVar.f3330e;
                }
                aVar.f3327b = dimensionBehaviour6;
                if (constraintWidget.B() == -1) {
                    aVar.f3329d = (int) (i12 / constraintWidget.A());
                } else {
                    aVar.f3329d = (int) (constraintWidget.A() * i12);
                }
            }
        }
        interfaceC0036b.b(constraintWidget, aVar);
        constraintWidget.c2(aVar.f3330e);
        constraintWidget.y1(aVar.f3331f);
        constraintWidget.x1(aVar.f3333h);
        constraintWidget.g1(aVar.f3332g);
        aVar.f3335j = b.a.f3323k;
        return aVar.f3334i;
    }

    public void A2() {
        this.C1.f(H(), j0());
    }

    public boolean B2(boolean z10) {
        return this.C1.g(z10);
    }

    public boolean C2(boolean z10) {
        return this.C1.h(z10);
    }

    public boolean D2(boolean z10, int i10) {
        return this.C1.i(z10, i10);
    }

    public void E2(s.b bVar) {
        this.G1 = bVar;
        this.H1.F(bVar);
    }

    public ArrayList<f> F2() {
        ArrayList<f> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.A1.get(i10);
            if (constraintWidget instanceof f) {
                f fVar = (f) constraintWidget;
                if (fVar.m2() == 0) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public b.InterfaceC0036b G2() {
        return this.E1;
    }

    public int H2() {
        return this.V1;
    }

    public androidx.constraintlayout.core.d I2() {
        return this.H1;
    }

    public ArrayList<f> J2() {
        ArrayList<f> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.A1.get(i10);
            if (constraintWidget instanceof f) {
                f fVar = (f) constraintWidget;
                if (fVar.m2() == 1) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public boolean K2() {
        return false;
    }

    public void L2() {
        this.C1.o();
    }

    public void M2() {
        this.C1.p();
    }

    public boolean N2() {
        return this.Y1;
    }

    public boolean O2() {
        return this.F1;
    }

    public boolean P2() {
        return this.X1;
    }

    public long Q2(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.I1 = i17;
        this.J1 = i18;
        return this.B1.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    @Override // y.d, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void R0() {
        this.H1.Y();
        this.I1 = 0;
        this.K1 = 0;
        this.J1 = 0;
        this.L1 = 0;
        this.W1 = false;
        super.R0();
    }

    public boolean S2(int i10) {
        return (this.V1 & i10) == i10;
    }

    public final void T2() {
        this.M1 = 0;
        this.N1 = 0;
    }

    public void U2(b.InterfaceC0036b interfaceC0036b) {
        this.E1 = interfaceC0036b;
        this.C1.u(interfaceC0036b);
    }

    public void V2(int i10) {
        this.V1 = i10;
        androidx.constraintlayout.core.d.f2977v = S2(512);
    }

    public void W2(int i10, int i11, int i12, int i13) {
        this.I1 = i10;
        this.J1 = i11;
        this.K1 = i12;
        this.L1 = i13;
    }

    public void X2(int i10) {
        this.D1 = i10;
    }

    public void Y2(boolean z10) {
        this.F1 = z10;
    }

    public boolean Z2(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zS2 = S2(64);
        j2(dVar, zS2);
        int size = this.A1.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.A1.get(i10);
            constraintWidget.j2(dVar, zS2);
            if (constraintWidget.t0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void a3() {
        this.B1.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void b0(StringBuilder sb2) {
        sb2.append(this.f3263o + ":{\n");
        sb2.append("  actualWidth:" + this.f3242d0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f3244e0);
        sb2.append("\n");
        Iterator<ConstraintWidget> it2 = l2().iterator();
        while (it2.hasNext()) {
            it2.next().b0(sb2);
            sb2.append(",\n");
        }
        sb2.append(zc.a.f58317e);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String f0() {
        return ConstraintLayout.A;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void i2(boolean z10, boolean z11) {
        super.i2(z10, z11);
        int size = this.A1.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.A1.get(i10).i2(z10, z11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0314 A[PHI: r2 r16
  0x0314: PHI (r2v14 boolean) = (r2v13 boolean), (r2v18 boolean), (r2v18 boolean), (r2v18 boolean) binds: [B:142:0x02d5, B:150:0x02fa, B:151:0x02fc, B:153:0x0302] A[DONT_GENERATE, DONT_INLINE]
  0x0314: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:142:0x02d5, B:150:0x02fa, B:151:0x02fc, B:153:0x0302] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // y.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n2() {
        /*
            Method dump skipped, instruction units count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.n2():void");
    }

    public void q2(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            s2(constraintWidget);
        } else if (i10 == 1) {
            x2(constraintWidget);
        }
    }

    public boolean r2(androidx.constraintlayout.core.d dVar) {
        boolean zS2 = S2(64);
        g(dVar, zS2);
        int size = this.A1.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.A1.get(i10);
            constraintWidget.G1(0, false);
            constraintWidget.G1(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.A1.get(i11);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).s2();
                }
            }
        }
        this.f3422e2.clear();
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget3 = this.A1.get(i12);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof i) {
                    this.f3422e2.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, zS2);
                }
            }
        }
        while (this.f3422e2.size() > 0) {
            int size2 = this.f3422e2.size();
            Iterator<ConstraintWidget> it2 = this.f3422e2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                i iVar = (i) it2.next();
                if (iVar.o2(this.f3422e2)) {
                    iVar.g(dVar, zS2);
                    this.f3422e2.remove(iVar);
                    break;
                }
            }
            if (size2 == this.f3422e2.size()) {
                Iterator<ConstraintWidget> it3 = this.f3422e2.iterator();
                while (it3.hasNext()) {
                    it3.next().g(dVar, zS2);
                }
                this.f3422e2.clear();
            }
        }
        if (androidx.constraintlayout.core.d.f2977v) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget4 = this.A1.get(i13);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, dVar, hashSet, H() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            for (ConstraintWidget constraintWidget5 : hashSet) {
                g.a(this, dVar, constraintWidget5);
                constraintWidget5.g(dVar, zS2);
            }
        } else {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget6 = this.A1.get(i14);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f3238b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(dVar, zS2);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.D1(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.Y1(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(dVar, zS2);
                    }
                }
            }
        }
        if (this.M1 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.N1 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public final void s2(ConstraintWidget constraintWidget) {
        int i10 = this.M1 + 1;
        c[] cVarArr = this.P1;
        if (i10 >= cVarArr.length) {
            this.P1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.P1[this.M1] = new c(constraintWidget, 0, O2());
        this.M1++;
    }

    public void t2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3421d2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.f3421d2.get().f()) {
            this.f3421d2 = new WeakReference<>(constraintAnchor);
        }
    }

    public void u2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3419b2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.f3419b2.get().f()) {
            this.f3419b2 = new WeakReference<>(constraintAnchor);
        }
    }

    public final void v2(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.H1.i(solverVariable, this.H1.u(constraintAnchor), 0, 5);
    }

    public final void w2(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.H1.i(this.H1.u(constraintAnchor), solverVariable, 0, 5);
    }

    public final void x2(ConstraintWidget constraintWidget) {
        int i10 = this.N1 + 1;
        c[] cVarArr = this.O1;
        if (i10 >= cVarArr.length) {
            this.O1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.O1[this.N1] = new c(constraintWidget, 1, O2());
        this.N1++;
    }

    public void y2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3420c2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.f3420c2.get().f()) {
            this.f3420c2 = new WeakReference<>(constraintAnchor);
        }
    }

    public void z2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3418a2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.f3418a2.get().f()) {
            this.f3418a2 = new WeakReference<>(constraintAnchor);
        }
    }

    public d(int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.d();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3418a2 = null;
        this.f3419b2 = null;
        this.f3420c2 = null;
        this.f3421d2 = null;
        this.f3422e2 = new HashSet<>();
        this.f3423f2 = new b.a();
    }

    public d(int i10, int i11) {
        super(i10, i11);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.d();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3418a2 = null;
        this.f3419b2 = null;
        this.f3420c2 = null;
        this.f3421d2 = null;
        this.f3422e2 = new HashSet<>();
        this.f3423f2 = new b.a();
    }

    public d(String str, int i10, int i11) {
        super(i10, i11);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.d();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3418a2 = null;
        this.f3419b2 = null;
        this.f3420c2 = null;
        this.f3421d2 = null;
        this.f3422e2 = new HashSet<>();
        this.f3423f2 = new b.a();
        j1(str);
    }
}
