package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3349a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3350b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3352d = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b.a f3351c = new b.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f3353e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f3354f = 0;

    public static boolean a(int i10, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = constraintWidget.H();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourJ0 = constraintWidget.j0();
        androidx.constraintlayout.core.widgets.d dVar = constraintWidget.U() != null ? (androidx.constraintlayout.core.widgets.d) constraintWidget.U() : null;
        if (dVar != null) {
            dVar.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            dVar.j0();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z10 = dimensionBehaviourH == dimensionBehaviour5 || constraintWidget.G0() || dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourH == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f3279w == 0 && constraintWidget.f3246f0 == 0.0f && constraintWidget.r0(0)) || (dimensionBehaviourH == dimensionBehaviour2 && constraintWidget.f3279w == 1 && constraintWidget.u0(0, constraintWidget.m0()));
        boolean z11 = dimensionBehaviourJ0 == dimensionBehaviour5 || constraintWidget.H0() || dimensionBehaviourJ0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviourJ0 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f3281x == 0 && constraintWidget.f3246f0 == 0.0f && constraintWidget.r0(1)) || (dimensionBehaviourJ0 == dimensionBehaviour && constraintWidget.f3281x == 1 && constraintWidget.u0(1, constraintWidget.D()));
        if (constraintWidget.f3246f0 <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    public static void b(int i10, ConstraintWidget constraintWidget, b.InterfaceC0036b interfaceC0036b, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.z0()) {
            return;
        }
        f3353e++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.F0()) {
            int i11 = i10 + 1;
            if (a(i11, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.R2(i11, constraintWidget, interfaceC0036b, new b.a(), b.a.f3323k);
            }
        }
        ConstraintAnchor constraintAnchorR = constraintWidget.r(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchorR2 = constraintWidget.r(ConstraintAnchor.Type.RIGHT);
        int iF = constraintAnchorR.f();
        int iF2 = constraintAnchorR2.f();
        if (constraintAnchorR.e() != null && constraintAnchorR.o()) {
            Iterator<ConstraintAnchor> it2 = constraintAnchorR.e().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next = it2.next();
                ConstraintWidget constraintWidget2 = next.f3202d;
                int i12 = i10 + 1;
                boolean zA = a(i12, constraintWidget2);
                if (constraintWidget2.F0() && zA) {
                    androidx.constraintlayout.core.widgets.d.R2(i12, constraintWidget2, interfaceC0036b, new b.a(), b.a.f3323k);
                }
                boolean z11 = (next == constraintWidget2.Q && (constraintAnchor4 = constraintWidget2.S.f3204f) != null && constraintAnchor4.o()) || (next == constraintWidget2.S && (constraintAnchor3 = constraintWidget2.Q.f3204f) != null && constraintAnchor3.o());
                ConstraintWidget.DimensionBehaviour dimensionBehaviourH = constraintWidget2.H();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourH != dimensionBehaviour || zA) {
                    if (!constraintWidget2.F0()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.Q;
                        if (next == constraintAnchor5 && constraintWidget2.S.f3204f == null) {
                            int iG = constraintAnchor5.g() + iF;
                            constraintWidget2.q1(iG, constraintWidget2.m0() + iG);
                            b(i12, constraintWidget2, interfaceC0036b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.S;
                            if (next == constraintAnchor6 && constraintAnchor5.f3204f == null) {
                                int iG2 = iF - constraintAnchor6.g();
                                constraintWidget2.q1(iG2 - constraintWidget2.m0(), iG2);
                                b(i12, constraintWidget2, interfaceC0036b, z10);
                            } else if (z11 && !constraintWidget2.B0()) {
                                f(i12, interfaceC0036b, constraintWidget2, z10);
                            }
                        }
                    }
                } else if (constraintWidget2.H() == dimensionBehaviour && constraintWidget2.A >= 0 && constraintWidget2.f3285z >= 0 && ((constraintWidget2.l0() == 8 || (constraintWidget2.f3279w == 0 && constraintWidget2.A() == 0.0f)) && !constraintWidget2.B0() && !constraintWidget2.E0() && z11 && !constraintWidget2.B0())) {
                    g(i12, constraintWidget, interfaceC0036b, constraintWidget2, z10);
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (constraintAnchorR2.e() != null && constraintAnchorR2.o()) {
            Iterator<ConstraintAnchor> it3 = constraintAnchorR2.e().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next2 = it3.next();
                ConstraintWidget constraintWidget3 = next2.f3202d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, constraintWidget3);
                if (constraintWidget3.F0() && zA2) {
                    androidx.constraintlayout.core.widgets.d.R2(i13, constraintWidget3, interfaceC0036b, new b.a(), b.a.f3323k);
                }
                boolean z12 = (next2 == constraintWidget3.Q && (constraintAnchor2 = constraintWidget3.S.f3204f) != null && constraintAnchor2.o()) || (next2 == constraintWidget3.S && (constraintAnchor = constraintWidget3.Q.f3204f) != null && constraintAnchor.o());
                ConstraintWidget.DimensionBehaviour dimensionBehaviourH2 = constraintWidget3.H();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourH2 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.F0()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.Q;
                        if (next2 == constraintAnchor7 && constraintWidget3.S.f3204f == null) {
                            int iG3 = constraintAnchor7.g() + iF2;
                            constraintWidget3.q1(iG3, constraintWidget3.m0() + iG3);
                            b(i13, constraintWidget3, interfaceC0036b, z10);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.S;
                            if (next2 == constraintAnchor8 && constraintAnchor7.f3204f == null) {
                                int iG4 = iF2 - constraintAnchor8.g();
                                constraintWidget3.q1(iG4 - constraintWidget3.m0(), iG4);
                                b(i13, constraintWidget3, interfaceC0036b, z10);
                            } else if (z12 && !constraintWidget3.B0()) {
                                f(i13, interfaceC0036b, constraintWidget3, z10);
                            }
                        }
                    }
                } else if (constraintWidget3.H() == dimensionBehaviour2 && constraintWidget3.A >= 0 && constraintWidget3.f3285z >= 0 && (constraintWidget3.l0() == 8 || (constraintWidget3.f3279w == 0 && constraintWidget3.A() == 0.0f))) {
                    if (!constraintWidget3.B0() && !constraintWidget3.E0() && z12 && !constraintWidget3.B0()) {
                        g(i13, constraintWidget, interfaceC0036b, constraintWidget3, z10);
                    }
                }
            }
        }
        constraintWidget.N0();
    }

    public static String c(int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(GlideException.a.f12263d);
        }
        sb2.append("+-(" + i10 + ") ");
        return sb2.toString();
    }

    public static void d(int i10, androidx.constraintlayout.core.widgets.a aVar, b.InterfaceC0036b interfaceC0036b, int i11, boolean z10) {
        if (aVar.m2()) {
            if (i11 == 0) {
                b(i10 + 1, aVar, interfaceC0036b, z10);
            } else {
                k(i10 + 1, aVar, interfaceC0036b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0155  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(androidx.constraintlayout.core.widgets.d r20, androidx.constraintlayout.core.d r21, int r22, int r23, androidx.constraintlayout.core.widgets.c r24, boolean r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.g.e(androidx.constraintlayout.core.widgets.d, androidx.constraintlayout.core.d, int, int, androidx.constraintlayout.core.widgets.c, boolean, boolean, boolean):boolean");
    }

    public static void f(int i10, b.InterfaceC0036b interfaceC0036b, ConstraintWidget constraintWidget, boolean z10) {
        float fE = constraintWidget.E();
        int iF = constraintWidget.Q.f3204f.f();
        int iF2 = constraintWidget.S.f3204f.f();
        int iG = constraintWidget.Q.g() + iF;
        int iG2 = iF2 - constraintWidget.S.g();
        if (iF == iF2) {
            fE = 0.5f;
        } else {
            iF = iG;
            iF2 = iG2;
        }
        int iM0 = constraintWidget.m0();
        int i11 = (iF2 - iF) - iM0;
        if (iF > iF2) {
            i11 = (iF - iF2) - iM0;
        }
        int i12 = ((int) (i11 > 0 ? (fE * i11) + 0.5f : fE * i11)) + iF;
        int i13 = i12 + iM0;
        if (iF > iF2) {
            i13 = i12 - iM0;
        }
        constraintWidget.q1(i12, i13);
        b(i10 + 1, constraintWidget, interfaceC0036b, z10);
    }

    public static void g(int i10, ConstraintWidget constraintWidget, b.InterfaceC0036b interfaceC0036b, ConstraintWidget constraintWidget2, boolean z10) {
        float fE = constraintWidget2.E();
        int iF = constraintWidget2.Q.f3204f.f() + constraintWidget2.Q.g();
        int iF2 = constraintWidget2.S.f3204f.f() - constraintWidget2.S.g();
        if (iF2 >= iF) {
            int iM0 = constraintWidget2.m0();
            if (constraintWidget2.l0() != 8) {
                int i11 = constraintWidget2.f3279w;
                if (i11 == 2) {
                    iM0 = (int) (constraintWidget2.E() * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.m0() : constraintWidget.U().m0()));
                } else if (i11 == 0) {
                    iM0 = iF2 - iF;
                }
                iM0 = Math.max(constraintWidget2.f3285z, iM0);
                int i12 = constraintWidget2.A;
                if (i12 > 0) {
                    iM0 = Math.min(i12, iM0);
                }
            }
            int i13 = iF + ((int) ((fE * ((iF2 - iF) - iM0)) + 0.5f));
            constraintWidget2.q1(i13, iM0 + i13);
            b(i10 + 1, constraintWidget2, interfaceC0036b, z10);
        }
    }

    public static void h(int i10, b.InterfaceC0036b interfaceC0036b, ConstraintWidget constraintWidget) {
        float fG0 = constraintWidget.g0();
        int iF = constraintWidget.R.f3204f.f();
        int iF2 = constraintWidget.T.f3204f.f();
        int iG = constraintWidget.R.g() + iF;
        int iG2 = iF2 - constraintWidget.T.g();
        if (iF == iF2) {
            fG0 = 0.5f;
        } else {
            iF = iG;
            iF2 = iG2;
        }
        int iD = constraintWidget.D();
        int i11 = (iF2 - iF) - iD;
        if (iF > iF2) {
            i11 = (iF - iF2) - iD;
        }
        int i12 = (int) (i11 > 0 ? (fG0 * i11) + 0.5f : fG0 * i11);
        int i13 = iF + i12;
        int i14 = i13 + iD;
        if (iF > iF2) {
            i13 = iF - i12;
            i14 = i13 - iD;
        }
        constraintWidget.t1(i13, i14);
        k(i10 + 1, constraintWidget, interfaceC0036b);
    }

    public static void i(int i10, ConstraintWidget constraintWidget, b.InterfaceC0036b interfaceC0036b, ConstraintWidget constraintWidget2) {
        float fG0 = constraintWidget2.g0();
        int iF = constraintWidget2.R.f3204f.f() + constraintWidget2.R.g();
        int iF2 = constraintWidget2.T.f3204f.f() - constraintWidget2.T.g();
        if (iF2 >= iF) {
            int iD = constraintWidget2.D();
            if (constraintWidget2.l0() != 8) {
                int i11 = constraintWidget2.f3281x;
                if (i11 == 2) {
                    iD = (int) (fG0 * 0.5f * (constraintWidget instanceof androidx.constraintlayout.core.widgets.d ? constraintWidget.D() : constraintWidget.U().D()));
                } else if (i11 == 0) {
                    iD = iF2 - iF;
                }
                iD = Math.max(constraintWidget2.C, iD);
                int i12 = constraintWidget2.D;
                if (i12 > 0) {
                    iD = Math.min(i12, iD);
                }
            }
            int i13 = iF + ((int) ((fG0 * ((iF2 - iF) - iD)) + 0.5f));
            constraintWidget2.t1(i13, iD + i13);
            k(i10 + 1, constraintWidget2, interfaceC0036b);
        }
    }

    public static void j(androidx.constraintlayout.core.widgets.d dVar, b.InterfaceC0036b interfaceC0036b) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = dVar.H();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourJ0 = dVar.j0();
        f3353e = 0;
        f3354f = 0;
        dVar.V0();
        ArrayList<ConstraintWidget> arrayListL2 = dVar.l2();
        int size = arrayListL2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayListL2.get(i10).V0();
        }
        boolean zO2 = dVar.O2();
        if (dimensionBehaviourH == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.q1(0, dVar.m0());
        } else {
            dVar.r1(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = arrayListL2.get(i11);
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                if (fVar.m2() == 1) {
                    if (fVar.n2() != -1) {
                        fVar.v2(fVar.n2());
                    } else if (fVar.p2() != -1 && dVar.G0()) {
                        fVar.v2(dVar.m0() - fVar.p2());
                    } else if (dVar.G0()) {
                        fVar.v2((int) ((fVar.q2() * dVar.m0()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget).r2() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = arrayListL2.get(i12);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar2 = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                    if (fVar2.m2() == 1) {
                        b(0, fVar2, interfaceC0036b, zO2);
                    }
                }
            }
        }
        b(0, dVar, interfaceC0036b, zO2);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = arrayListL2.get(i13);
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget3;
                    if (aVar.r2() == 0) {
                        d(0, aVar, interfaceC0036b, 0, zO2);
                    }
                }
            }
        }
        if (dimensionBehaviourJ0 == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.t1(0, dVar.D());
        } else {
            dVar.s1(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = arrayListL2.get(i14);
            if (constraintWidget4 instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar3 = (androidx.constraintlayout.core.widgets.f) constraintWidget4;
                if (fVar3.m2() == 0) {
                    if (fVar3.n2() != -1) {
                        fVar3.v2(fVar3.n2());
                    } else if (fVar3.p2() != -1 && dVar.H0()) {
                        fVar3.v2(dVar.D() - fVar3.p2());
                    } else if (dVar.H0()) {
                        fVar3.v2((int) ((fVar3.q2() * dVar.D()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) constraintWidget4).r2() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = arrayListL2.get(i15);
                if (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar4 = (androidx.constraintlayout.core.widgets.f) constraintWidget5;
                    if (fVar4.m2() == 0) {
                        k(1, fVar4, interfaceC0036b);
                    }
                }
            }
        }
        k(0, dVar, interfaceC0036b);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = arrayListL2.get(i16);
                if (constraintWidget6 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) constraintWidget6;
                    if (aVar2.r2() == 1) {
                        d(0, aVar2, interfaceC0036b, 1, zO2);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = arrayListL2.get(i17);
            if (constraintWidget7.F0() && a(0, constraintWidget7)) {
                androidx.constraintlayout.core.widgets.d.R2(0, constraintWidget7, interfaceC0036b, f3351c, b.a.f3323k);
                if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.f)) {
                    b(0, constraintWidget7, interfaceC0036b, zO2);
                    k(0, constraintWidget7, interfaceC0036b);
                } else if (((androidx.constraintlayout.core.widgets.f) constraintWidget7).m2() == 0) {
                    k(0, constraintWidget7, interfaceC0036b);
                } else {
                    b(0, constraintWidget7, interfaceC0036b, zO2);
                }
            }
        }
    }

    public static void k(int i10, ConstraintWidget constraintWidget, b.InterfaceC0036b interfaceC0036b) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.L0()) {
            return;
        }
        f3354f++;
        if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.d) && constraintWidget.F0()) {
            int i11 = i10 + 1;
            if (a(i11, constraintWidget)) {
                androidx.constraintlayout.core.widgets.d.R2(i11, constraintWidget, interfaceC0036b, new b.a(), b.a.f3323k);
            }
        }
        ConstraintAnchor constraintAnchorR = constraintWidget.r(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchorR2 = constraintWidget.r(ConstraintAnchor.Type.BOTTOM);
        int iF = constraintAnchorR.f();
        int iF2 = constraintAnchorR2.f();
        if (constraintAnchorR.e() != null && constraintAnchorR.o()) {
            Iterator<ConstraintAnchor> it2 = constraintAnchorR.e().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next = it2.next();
                ConstraintWidget constraintWidget2 = next.f3202d;
                int i12 = i10 + 1;
                boolean zA = a(i12, constraintWidget2);
                if (constraintWidget2.F0() && zA) {
                    androidx.constraintlayout.core.widgets.d.R2(i12, constraintWidget2, interfaceC0036b, new b.a(), b.a.f3323k);
                }
                boolean z10 = (next == constraintWidget2.R && (constraintAnchor4 = constraintWidget2.T.f3204f) != null && constraintAnchor4.o()) || (next == constraintWidget2.T && (constraintAnchor3 = constraintWidget2.R.f3204f) != null && constraintAnchor3.o());
                ConstraintWidget.DimensionBehaviour dimensionBehaviourJ0 = constraintWidget2.j0();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourJ0 != dimensionBehaviour || zA) {
                    if (!constraintWidget2.F0()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.R;
                        if (next == constraintAnchor5 && constraintWidget2.T.f3204f == null) {
                            int iG = constraintAnchor5.g() + iF;
                            constraintWidget2.t1(iG, constraintWidget2.D() + iG);
                            k(i12, constraintWidget2, interfaceC0036b);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.T;
                            if (next == constraintAnchor6 && constraintAnchor5.f3204f == null) {
                                int iG2 = iF - constraintAnchor6.g();
                                constraintWidget2.t1(iG2 - constraintWidget2.D(), iG2);
                                k(i12, constraintWidget2, interfaceC0036b);
                            } else if (z10 && !constraintWidget2.D0()) {
                                h(i12, interfaceC0036b, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.j0() == dimensionBehaviour && constraintWidget2.D >= 0 && constraintWidget2.C >= 0 && (constraintWidget2.l0() == 8 || (constraintWidget2.f3281x == 0 && constraintWidget2.A() == 0.0f))) {
                    if (!constraintWidget2.D0() && !constraintWidget2.E0() && z10 && !constraintWidget2.D0()) {
                        i(i12, constraintWidget, interfaceC0036b, constraintWidget2);
                    }
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
            return;
        }
        if (constraintAnchorR2.e() != null && constraintAnchorR2.o()) {
            Iterator<ConstraintAnchor> it3 = constraintAnchorR2.e().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next2 = it3.next();
                ConstraintWidget constraintWidget3 = next2.f3202d;
                int i13 = i10 + 1;
                boolean zA2 = a(i13, constraintWidget3);
                if (constraintWidget3.F0() && zA2) {
                    androidx.constraintlayout.core.widgets.d.R2(i13, constraintWidget3, interfaceC0036b, new b.a(), b.a.f3323k);
                }
                boolean z11 = (next2 == constraintWidget3.R && (constraintAnchor2 = constraintWidget3.T.f3204f) != null && constraintAnchor2.o()) || (next2 == constraintWidget3.T && (constraintAnchor = constraintWidget3.R.f3204f) != null && constraintAnchor.o());
                ConstraintWidget.DimensionBehaviour dimensionBehaviourJ02 = constraintWidget3.j0();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourJ02 != dimensionBehaviour2 || zA2) {
                    if (!constraintWidget3.F0()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.R;
                        if (next2 == constraintAnchor7 && constraintWidget3.T.f3204f == null) {
                            int iG3 = constraintAnchor7.g() + iF2;
                            constraintWidget3.t1(iG3, constraintWidget3.D() + iG3);
                            k(i13, constraintWidget3, interfaceC0036b);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.T;
                            if (next2 == constraintAnchor8 && constraintAnchor7.f3204f == null) {
                                int iG4 = iF2 - constraintAnchor8.g();
                                constraintWidget3.t1(iG4 - constraintWidget3.D(), iG4);
                                k(i13, constraintWidget3, interfaceC0036b);
                            } else if (z11 && !constraintWidget3.D0()) {
                                h(i13, interfaceC0036b, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.j0() == dimensionBehaviour2 && constraintWidget3.D >= 0 && constraintWidget3.C >= 0 && (constraintWidget3.l0() == 8 || (constraintWidget3.f3281x == 0 && constraintWidget3.A() == 0.0f))) {
                    if (!constraintWidget3.D0() && !constraintWidget3.E0() && z11 && !constraintWidget3.D0()) {
                        i(i13, constraintWidget, interfaceC0036b, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor constraintAnchorR3 = constraintWidget.r(ConstraintAnchor.Type.BASELINE);
        if (constraintAnchorR3.e() != null && constraintAnchorR3.o()) {
            int iF3 = constraintAnchorR3.f();
            for (ConstraintAnchor constraintAnchor9 : constraintAnchorR3.e()) {
                ConstraintWidget constraintWidget4 = constraintAnchor9.f3202d;
                int i14 = i10 + 1;
                boolean zA3 = a(i14, constraintWidget4);
                if (constraintWidget4.F0() && zA3) {
                    androidx.constraintlayout.core.widgets.d.R2(i14, constraintWidget4, interfaceC0036b, new b.a(), b.a.f3323k);
                }
                if (constraintWidget4.j0() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || zA3) {
                    if (!constraintWidget4.F0() && constraintAnchor9 == constraintWidget4.U) {
                        constraintWidget4.o1(constraintAnchor9.g() + iF3);
                        k(i14, constraintWidget4, interfaceC0036b);
                    }
                }
            }
        }
        constraintWidget.O0();
    }
}
