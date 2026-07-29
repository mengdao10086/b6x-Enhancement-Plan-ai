package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3312d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3313e = 30;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3314f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3315g = 1073741824;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3316h = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3317i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3318j = -2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3319k = -3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f3320a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3321b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f3322c;

    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f3323k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f3324l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f3325m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f3326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f3327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3332g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f3333h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3334i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3335j;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0036b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f3322c = dVar;
    }

    public final boolean a(InterfaceC0036b interfaceC0036b, ConstraintWidget constraintWidget, int i10) {
        this.f3321b.f3326a = constraintWidget.H();
        this.f3321b.f3327b = constraintWidget.j0();
        this.f3321b.f3328c = constraintWidget.m0();
        this.f3321b.f3329d = constraintWidget.D();
        a aVar = this.f3321b;
        aVar.f3334i = false;
        aVar.f3335j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f3326a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f3327b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f3246f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f3246f0 > 0.0f;
        if (z12 && constraintWidget.f3283y[0] == 4) {
            aVar.f3326a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f3283y[1] == 4) {
            aVar.f3327b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0036b.b(constraintWidget, aVar);
        constraintWidget.c2(this.f3321b.f3330e);
        constraintWidget.y1(this.f3321b.f3331f);
        constraintWidget.x1(this.f3321b.f3333h);
        constraintWidget.g1(this.f3321b.f3332g);
        a aVar2 = this.f3321b;
        aVar2.f3335j = a.f3323k;
        return aVar2.f3334i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0098 A[PHI: r10
  0x0098: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0062, B:34:0x0068, B:36:0x006c, B:54:0x0095, B:52:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ac A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.constraintlayout.core.widgets.d r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.A1
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.S2(r1)
            androidx.constraintlayout.core.widgets.analyzer.b$b r2 = r13.G2()
            r3 = 0
            r4 = 0
        L12:
            if (r4 >= r0) goto Lb0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.A1
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.f
            if (r6 == 0) goto L22
            goto Lac
        L22:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 == 0) goto L28
            goto Lac
        L28:
            boolean r6 = r5.E0()
            if (r6 == 0) goto L30
            goto Lac
        L30:
            if (r1 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.k r6 = r5.f3243e
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.m r7 = r5.f3245f
            if (r7 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.f r6 = r6.f3305e
            boolean r6 = r6.f3298j
            if (r6 == 0) goto L48
            androidx.constraintlayout.core.widgets.analyzer.f r6 = r7.f3305e
            boolean r6 = r6.f3298j
            if (r6 == 0) goto L48
            goto Lac
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.z(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.z(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L61
            int r10 = r5.f3279w
            if (r10 == r7) goto L61
            if (r8 != r9) goto L61
            int r10 = r5.f3281x
            if (r10 == r7) goto L61
            r10 = 1
            goto L62
        L61:
            r10 = 0
        L62:
            if (r10 != 0) goto L98
            boolean r11 = r13.S2(r7)
            if (r11 == 0) goto L98
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.i
            if (r11 != 0) goto L98
            if (r6 != r9) goto L7d
            int r11 = r5.f3279w
            if (r11 != 0) goto L7d
            if (r8 == r9) goto L7d
            boolean r11 = r5.B0()
            if (r11 != 0) goto L7d
            r10 = 1
        L7d:
            if (r8 != r9) goto L8c
            int r11 = r5.f3281x
            if (r11 != 0) goto L8c
            if (r6 == r9) goto L8c
            boolean r11 = r5.B0()
            if (r11 != 0) goto L8c
            r10 = 1
        L8c:
            if (r6 == r9) goto L90
            if (r8 != r9) goto L98
        L90:
            float r6 = r5.f3246f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L98
            goto L99
        L98:
            r7 = r10
        L99:
            if (r7 == 0) goto L9c
            goto Lac
        L9c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.b.a.f3323k
            r12.a(r2, r5, r6)
            s.b r5 = r13.G1
            if (r5 == 0) goto Lac
            long r6 = r5.f49248c
            r8 = 1
            long r6 = r6 + r8
            r5.f49248c = r6
        Lac:
            int r4 = r4 + 1
            goto L12
        Lb0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.b.b(androidx.constraintlayout.core.widgets.d):void");
    }

    public final void c(androidx.constraintlayout.core.widgets.d dVar, String str, int i10, int i11, int i12) {
        int iQ = dVar.Q();
        int iP = dVar.P();
        dVar.P1(0);
        dVar.O1(0);
        dVar.c2(i11);
        dVar.y1(i12);
        dVar.P1(iQ);
        dVar.O1(iP);
        this.f3322c.X2(i10);
        this.f3322c.n2();
    }

    public long d(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zD2;
        int i19;
        int i20;
        boolean z10;
        int i21;
        InterfaceC0036b interfaceC0036b;
        int i22;
        int i23;
        int i24;
        boolean z11;
        s.b bVar;
        InterfaceC0036b interfaceC0036bG2 = dVar.G2();
        int size = dVar.A1.size();
        int iM0 = dVar.m0();
        int iD = dVar.D();
        boolean zB = androidx.constraintlayout.core.widgets.g.b(i10, 128);
        boolean z12 = zB || androidx.constraintlayout.core.widgets.g.b(i10, 64);
        if (z12) {
            for (int i25 = 0; i25 < size; i25++) {
                ConstraintWidget constraintWidget = dVar.A1.get(i25);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourH = constraintWidget.H();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z13 = (dimensionBehaviourH == dimensionBehaviour) && (constraintWidget.j0() == dimensionBehaviour) && constraintWidget.A() > 0.0f;
                if ((constraintWidget.B0() && z13) || ((constraintWidget.D0() && z13) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.i) || constraintWidget.B0() || constraintWidget.D0())) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12 && (bVar = androidx.constraintlayout.core.d.C) != null) {
            bVar.f49250e++;
        }
        boolean z14 = z12 & ((i13 == 1073741824 && i15 == 1073741824) || zB);
        if (z14) {
            int iMin = Math.min(dVar.O(), i14);
            int iMin2 = Math.min(dVar.N(), i16);
            if (i13 == 1073741824 && dVar.m0() != iMin) {
                dVar.c2(iMin);
                dVar.L2();
            }
            if (i15 == 1073741824 && dVar.D() != iMin2) {
                dVar.y1(iMin2);
                dVar.L2();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                zD2 = dVar.B2(zB);
                i19 = 2;
            } else {
                boolean zC2 = dVar.C2(zB);
                if (i13 == 1073741824) {
                    zC2 &= dVar.D2(zB, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    zD2 = dVar.D2(zB, 1) & zC2;
                    i19++;
                } else {
                    zD2 = zC2;
                }
            }
            if (zD2) {
                dVar.i2(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            zD2 = false;
            i19 = 0;
        }
        if (zD2 && i19 == 2) {
            return 0L;
        }
        int iH2 = dVar.H2();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = this.f3320a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, iM0, iD);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourH2 = dVar.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z15 = dimensionBehaviourH2 == dimensionBehaviour2;
            boolean z16 = dVar.j0() == dimensionBehaviour2;
            int iMax = Math.max(dVar.m0(), this.f3322c.Q());
            int iMax2 = Math.max(dVar.D(), this.f3322c.P());
            int i26 = 0;
            boolean zY2 = false;
            while (i26 < size2) {
                ConstraintWidget constraintWidget2 = this.f3320a.get(i26);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.i) {
                    int iM02 = constraintWidget2.m0();
                    i22 = iH2;
                    int iD2 = constraintWidget2.D();
                    i23 = iD;
                    boolean zA = a(interfaceC0036bG2, constraintWidget2, a.f3324l) | zY2;
                    s.b bVar2 = dVar.G1;
                    i24 = iM0;
                    if (bVar2 != null) {
                        bVar2.f49249d++;
                    }
                    int iM03 = constraintWidget2.m0();
                    int iD3 = constraintWidget2.D();
                    if (iM03 != iM02) {
                        constraintWidget2.c2(iM03);
                        if (z15 && constraintWidget2.X() > iMax) {
                            iMax = Math.max(iMax, constraintWidget2.X() + constraintWidget2.r(ConstraintAnchor.Type.RIGHT).g());
                        }
                        z11 = true;
                    } else {
                        z11 = zA;
                    }
                    if (iD3 != iD2) {
                        constraintWidget2.y1(iD3);
                        if (z16 && constraintWidget2.v() > iMax2) {
                            iMax2 = Math.max(iMax2, constraintWidget2.v() + constraintWidget2.r(ConstraintAnchor.Type.BOTTOM).g());
                        }
                        z11 = true;
                    }
                    zY2 = z11 | ((androidx.constraintlayout.core.widgets.i) constraintWidget2).y2();
                } else {
                    i22 = iH2;
                    i24 = iM0;
                    i23 = iD;
                }
                i26++;
                iH2 = i22;
                iD = i23;
                iM0 = i24;
            }
            int i27 = iH2;
            int i28 = iM0;
            int i29 = iD;
            int i30 = 0;
            int i31 = 2;
            while (i30 < i31) {
                int i32 = 0;
                while (i32 < size2) {
                    ConstraintWidget constraintWidget3 = this.f3320a.get(i32);
                    if (((constraintWidget3 instanceof y.a) && !(constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i)) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.f) || constraintWidget3.l0() == 8 || ((z14 && constraintWidget3.f3243e.f3305e.f3298j && constraintWidget3.f3245f.f3305e.f3298j) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i))) {
                        z10 = z14;
                        i21 = size2;
                        interfaceC0036b = interfaceC0036bG2;
                    } else {
                        int iM04 = constraintWidget3.m0();
                        int iD4 = constraintWidget3.D();
                        int iT = constraintWidget3.t();
                        int i33 = a.f3324l;
                        z10 = z14;
                        if (i30 == 1) {
                            i33 = a.f3325m;
                        }
                        boolean zA2 = a(interfaceC0036bG2, constraintWidget3, i33) | zY2;
                        s.b bVar3 = dVar.G1;
                        i21 = size2;
                        interfaceC0036b = interfaceC0036bG2;
                        if (bVar3 != null) {
                            bVar3.f49249d++;
                        }
                        int iM05 = constraintWidget3.m0();
                        int iD5 = constraintWidget3.D();
                        if (iM05 != iM04) {
                            constraintWidget3.c2(iM05);
                            if (z15 && constraintWidget3.X() > iMax) {
                                iMax = Math.max(iMax, constraintWidget3.X() + constraintWidget3.r(ConstraintAnchor.Type.RIGHT).g());
                            }
                            zA2 = true;
                        }
                        if (iD5 != iD4) {
                            constraintWidget3.y1(iD5);
                            if (z16 && constraintWidget3.v() > iMax2) {
                                iMax2 = Math.max(iMax2, constraintWidget3.v() + constraintWidget3.r(ConstraintAnchor.Type.BOTTOM).g());
                            }
                            zA2 = true;
                        }
                        zY2 = (!constraintWidget3.q0() || iT == constraintWidget3.t()) ? zA2 : true;
                    }
                    i32++;
                    interfaceC0036bG2 = interfaceC0036b;
                    z14 = z10;
                    size2 = i21;
                }
                boolean z17 = z14;
                int i34 = size2;
                InterfaceC0036b interfaceC0036b2 = interfaceC0036bG2;
                if (!zY2) {
                    break;
                }
                i30++;
                c(dVar, "intermediate pass", i30, i28, i29);
                interfaceC0036bG2 = interfaceC0036b2;
                z14 = z17;
                size2 = i34;
                i31 = 2;
                zY2 = false;
            }
            i20 = i27;
        } else {
            i20 = iH2;
        }
        dVar.V2(i20);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f3320a.clear();
        int size = dVar.A1.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.A1.get(i10);
            ConstraintWidget.DimensionBehaviour dimensionBehaviourH = constraintWidget.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviourH == dimensionBehaviour || constraintWidget.j0() == dimensionBehaviour) {
                this.f3320a.add(constraintWidget);
            }
        }
        dVar.L2();
    }
}
