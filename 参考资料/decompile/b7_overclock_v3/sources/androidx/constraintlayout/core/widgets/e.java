package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e extends i {

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final int f3424o2 = 0;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final int f3425p2 = 1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final int f3426q2 = 2;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final int f3427r2 = 0;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final int f3428s2 = 1;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final int f3429t2 = 2;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final int f3430u2 = 3;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f3431v2 = 0;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final int f3432w2 = 1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final int f3433x2 = 2;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final int f3434y2 = 3;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public ConstraintWidget[] f3447m2;
    public int P1 = -1;
    public int Q1 = -1;
    public int R1 = -1;
    public int S1 = -1;
    public int T1 = -1;
    public int U1 = -1;
    public float V1 = 0.5f;
    public float W1 = 0.5f;
    public float X1 = 0.5f;
    public float Y1 = 0.5f;
    public float Z1 = 0.5f;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public float f3435a2 = 0.5f;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public int f3436b2 = 0;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public int f3437c2 = 0;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public int f3438d2 = 2;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public int f3439e2 = 2;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public int f3440f2 = 0;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public int f3441g2 = -1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public int f3442h2 = 0;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public ArrayList<a> f3443i2 = new ArrayList<>();

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public ConstraintWidget[] f3444j2 = null;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public ConstraintWidget[] f3445k2 = null;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public int[] f3446l2 = null;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public int f3448n2 = 0;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3449a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f3452d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f3453e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f3454f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f3455g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3456h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3457i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3458j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3459k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3465q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget f3450b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3451c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3460l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3461m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f3462n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f3463o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3464p = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f3456h = 0;
            this.f3457i = 0;
            this.f3458j = 0;
            this.f3459k = 0;
            this.f3465q = 0;
            this.f3449a = i10;
            this.f3452d = constraintAnchor;
            this.f3453e = constraintAnchor2;
            this.f3454f = constraintAnchor3;
            this.f3455g = constraintAnchor4;
            this.f3456h = e.this.s2();
            this.f3457i = e.this.u2();
            this.f3458j = e.this.t2();
            this.f3459k = e.this.r2();
            this.f3465q = i11;
        }

        public void b(ConstraintWidget constraintWidget) {
            if (this.f3449a == 0) {
                int iF3 = e.this.f3(constraintWidget, this.f3465q);
                if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f3464p++;
                    iF3 = 0;
                }
                this.f3460l += iF3 + (constraintWidget.l0() != 8 ? e.this.f3436b2 : 0);
                int iE3 = e.this.e3(constraintWidget, this.f3465q);
                if (this.f3450b == null || this.f3451c < iE3) {
                    this.f3450b = constraintWidget;
                    this.f3451c = iE3;
                    this.f3461m = iE3;
                }
            } else {
                int iF32 = e.this.f3(constraintWidget, this.f3465q);
                int iE32 = e.this.e3(constraintWidget, this.f3465q);
                if (constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f3464p++;
                    iE32 = 0;
                }
                this.f3461m += iE32 + (constraintWidget.l0() != 8 ? e.this.f3437c2 : 0);
                if (this.f3450b == null || this.f3451c < iF32) {
                    this.f3450b = constraintWidget;
                    this.f3451c = iF32;
                    this.f3460l = iF32;
                }
            }
            this.f3463o++;
        }

        public void c() {
            this.f3451c = 0;
            this.f3450b = null;
            this.f3460l = 0;
            this.f3461m = 0;
            this.f3462n = 0;
            this.f3463o = 0;
            this.f3464p = 0;
        }

        public void d(boolean z10, int i10, boolean z11) {
            ConstraintWidget constraintWidget;
            float f10;
            float f11;
            int i11 = this.f3463o;
            for (int i12 = 0; i12 < i11 && this.f3462n + i12 < e.this.f3448n2; i12++) {
                ConstraintWidget constraintWidget2 = e.this.f3447m2[this.f3462n + i12];
                if (constraintWidget2 != null) {
                    constraintWidget2.U0();
                }
            }
            if (i11 == 0 || this.f3450b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i13 = -1;
            int i14 = -1;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = z10 ? (i11 - 1) - i15 : i15;
                if (this.f3462n + i16 >= e.this.f3448n2) {
                    break;
                }
                ConstraintWidget constraintWidget3 = e.this.f3447m2[this.f3462n + i16];
                if (constraintWidget3 != null && constraintWidget3.l0() == 0) {
                    if (i13 == -1) {
                        i13 = i15;
                    }
                    i14 = i15;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.f3449a != 0) {
                ConstraintWidget constraintWidget5 = this.f3450b;
                constraintWidget5.B1(e.this.P1);
                int i17 = this.f3456h;
                if (i10 > 0) {
                    i17 += e.this.f3436b2;
                }
                if (z10) {
                    constraintWidget5.S.a(this.f3454f, i17);
                    if (z11) {
                        constraintWidget5.Q.a(this.f3452d, this.f3458j);
                    }
                    if (i10 > 0) {
                        this.f3454f.f3202d.Q.a(constraintWidget5.S, 0);
                    }
                } else {
                    constraintWidget5.Q.a(this.f3452d, i17);
                    if (z11) {
                        constraintWidget5.S.a(this.f3454f, this.f3458j);
                    }
                    if (i10 > 0) {
                        this.f3452d.f3202d.S.a(constraintWidget5.Q, 0);
                    }
                }
                for (int i18 = 0; i18 < i11 && this.f3462n + i18 < e.this.f3448n2; i18++) {
                    ConstraintWidget constraintWidget6 = e.this.f3447m2[this.f3462n + i18];
                    if (constraintWidget6 != null) {
                        if (i18 == 0) {
                            constraintWidget6.l(constraintWidget6.R, this.f3453e, this.f3457i);
                            int i19 = e.this.Q1;
                            float f12 = e.this.W1;
                            if (this.f3462n == 0 && e.this.S1 != -1) {
                                i19 = e.this.S1;
                                f12 = e.this.Y1;
                            } else if (z11 && e.this.U1 != -1) {
                                i19 = e.this.U1;
                                f12 = e.this.f3435a2;
                            }
                            constraintWidget6.W1(i19);
                            constraintWidget6.V1(f12);
                        }
                        if (i18 == i11 - 1) {
                            constraintWidget6.l(constraintWidget6.T, this.f3455g, this.f3459k);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.R.a(constraintWidget4.T, e.this.f3437c2);
                            if (i18 == i13) {
                                constraintWidget6.R.B(this.f3457i);
                            }
                            constraintWidget4.T.a(constraintWidget6.R, 0);
                            if (i18 == i14 + 1) {
                                constraintWidget4.T.B(this.f3459k);
                            }
                        }
                        if (constraintWidget6 == constraintWidget5) {
                            constraintWidget4 = constraintWidget6;
                        } else if (z10) {
                            int i20 = e.this.f3438d2;
                            if (i20 == 0) {
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            } else if (i20 == 1) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                            } else if (i20 == 2) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            }
                            constraintWidget4 = constraintWidget6;
                        } else {
                            int i21 = e.this.f3438d2;
                            if (i21 == 0) {
                                constraintWidget6.Q.a(constraintWidget5.Q, 0);
                            } else if (i21 == 1) {
                                constraintWidget6.S.a(constraintWidget5.S, 0);
                            } else if (i21 == 2) {
                                if (z12) {
                                    constraintWidget6.Q.a(this.f3452d, this.f3456h);
                                    constraintWidget6.S.a(this.f3454f, this.f3458j);
                                } else {
                                    constraintWidget6.Q.a(constraintWidget5.Q, 0);
                                    constraintWidget6.S.a(constraintWidget5.S, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f3450b;
            constraintWidget7.W1(e.this.Q1);
            int i22 = this.f3457i;
            if (i10 > 0) {
                i22 += e.this.f3437c2;
            }
            constraintWidget7.R.a(this.f3453e, i22);
            if (z11) {
                constraintWidget7.T.a(this.f3455g, this.f3459k);
            }
            if (i10 > 0) {
                this.f3453e.f3202d.T.a(constraintWidget7.R, 0);
            }
            if (e.this.f3439e2 != 3 || constraintWidget7.q0()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i23 = 0; i23 < i11; i23++) {
                    int i24 = z10 ? (i11 - 1) - i23 : i23;
                    if (this.f3462n + i24 >= e.this.f3448n2) {
                        break;
                    }
                    constraintWidget = e.this.f3447m2[this.f3462n + i24];
                    if (constraintWidget.q0()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i25 = 0;
            while (i25 < i11) {
                int i26 = z10 ? (i11 - 1) - i25 : i25;
                if (this.f3462n + i26 >= e.this.f3448n2) {
                    return;
                }
                ConstraintWidget constraintWidget8 = e.this.f3447m2[this.f3462n + i26];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                } else {
                    if (i25 == 0) {
                        constraintWidget8.l(constraintWidget8.Q, this.f3452d, this.f3456h);
                    }
                    if (i26 == 0) {
                        int i27 = e.this.P1;
                        float f13 = e.this.V1;
                        if (z10) {
                            f13 = 1.0f - f13;
                        }
                        if (this.f3462n != 0 || e.this.R1 == -1) {
                            if (z11 && e.this.T1 != -1) {
                                i27 = e.this.T1;
                                if (z10) {
                                    f11 = e.this.Z1;
                                    f10 = 1.0f - f11;
                                    f13 = f10;
                                } else {
                                    f10 = e.this.Z1;
                                    f13 = f10;
                                }
                            }
                            constraintWidget8.B1(i27);
                            constraintWidget8.A1(f13);
                        } else {
                            i27 = e.this.R1;
                            if (z10) {
                                f11 = e.this.X1;
                                f10 = 1.0f - f11;
                                f13 = f10;
                                constraintWidget8.B1(i27);
                                constraintWidget8.A1(f13);
                            } else {
                                f10 = e.this.X1;
                                f13 = f10;
                                constraintWidget8.B1(i27);
                                constraintWidget8.A1(f13);
                            }
                        }
                        i25++;
                        constraintWidget4 = constraintWidget8;
                    }
                    if (i25 == i11 - 1) {
                        constraintWidget8.l(constraintWidget8.S, this.f3454f, this.f3458j);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.Q.a(constraintWidget4.S, e.this.f3436b2);
                        if (i25 == i13) {
                            constraintWidget8.Q.B(this.f3456h);
                        }
                        constraintWidget4.S.a(constraintWidget8.Q, 0);
                        if (i25 == i14 + 1) {
                            constraintWidget4.S.B(this.f3458j);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        if (e.this.f3439e2 == 3 && constraintWidget.q0() && constraintWidget8 != constraintWidget && constraintWidget8.q0()) {
                            constraintWidget8.U.a(constraintWidget.U, 0);
                        } else {
                            int i28 = e.this.f3439e2;
                            if (i28 == 0) {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                            } else if (i28 == 1) {
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            } else if (z12) {
                                constraintWidget8.R.a(this.f3453e, this.f3457i);
                                constraintWidget8.T.a(this.f3455g, this.f3459k);
                            } else {
                                constraintWidget8.R.a(constraintWidget7.R, 0);
                                constraintWidget8.T.a(constraintWidget7.T, 0);
                            }
                        }
                    }
                    i25++;
                    constraintWidget4 = constraintWidget8;
                }
                i25++;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int e() {
            return this.f3449a == 1 ? this.f3461m - e.this.f3437c2 : this.f3461m;
        }

        public int f() {
            return this.f3449a == 0 ? this.f3460l - e.this.f3436b2 : this.f3460l;
        }

        public void g(int i10) {
            int i11 = this.f3464p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f3463o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f3462n + i14 < e.this.f3448n2; i14++) {
                ConstraintWidget constraintWidget = e.this.f3447m2[this.f3462n + i14];
                if (this.f3449a == 0) {
                    if (constraintWidget != null && constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f3279w == 0) {
                        e.this.w2(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.j0(), constraintWidget.D());
                    }
                } else if (constraintWidget != null && constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f3281x == 0) {
                    e.this.w2(constraintWidget, constraintWidget.H(), constraintWidget.m0(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                }
            }
            h();
        }

        public final void h() {
            this.f3460l = 0;
            this.f3461m = 0;
            this.f3450b = null;
            this.f3451c = 0;
            int i10 = this.f3463o;
            for (int i11 = 0; i11 < i10 && this.f3462n + i11 < e.this.f3448n2; i11++) {
                ConstraintWidget constraintWidget = e.this.f3447m2[this.f3462n + i11];
                if (this.f3449a == 0) {
                    int iM0 = constraintWidget.m0();
                    int i12 = e.this.f3436b2;
                    if (constraintWidget.l0() == 8) {
                        i12 = 0;
                    }
                    this.f3460l += iM0 + i12;
                    int iE3 = e.this.e3(constraintWidget, this.f3465q);
                    if (this.f3450b == null || this.f3451c < iE3) {
                        this.f3450b = constraintWidget;
                        this.f3451c = iE3;
                        this.f3461m = iE3;
                    }
                } else {
                    int iF3 = e.this.f3(constraintWidget, this.f3465q);
                    int iE32 = e.this.e3(constraintWidget, this.f3465q);
                    int i13 = e.this.f3437c2;
                    if (constraintWidget.l0() == 8) {
                        i13 = 0;
                    }
                    this.f3461m += iE32 + i13;
                    if (this.f3450b == null || this.f3451c < iF3) {
                        this.f3450b = constraintWidget;
                        this.f3451c = iF3;
                        this.f3460l = iF3;
                    }
                }
            }
        }

        public void i(int i10) {
            this.f3462n = i10;
        }

        public void j(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f3449a = i10;
            this.f3452d = constraintAnchor;
            this.f3453e = constraintAnchor2;
            this.f3454f = constraintAnchor3;
            this.f3455g = constraintAnchor4;
            this.f3456h = i11;
            this.f3457i = i12;
            this.f3458j = i13;
            this.f3459k = i14;
            this.f3465q = i15;
        }
    }

    public void A3(int i10) {
        this.f3437c2 = i10;
    }

    public void B3(int i10) {
        this.Q1 = i10;
    }

    public void C3(int i10) {
        this.f3440f2 = i10;
    }

    public final void c3(boolean z10) {
        ConstraintWidget constraintWidget;
        float f10;
        int i10;
        if (this.f3446l2 == null || this.f3445k2 == null || this.f3444j2 == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f3448n2; i11++) {
            this.f3447m2[i11].U0();
        }
        int[] iArr = this.f3446l2;
        int i12 = iArr[0];
        int i13 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        float f11 = this.V1;
        int i14 = 0;
        while (i14 < i12) {
            if (z10) {
                i10 = (i12 - i14) - 1;
                f10 = 1.0f - this.V1;
            } else {
                f10 = f11;
                i10 = i14;
            }
            ConstraintWidget constraintWidget3 = this.f3445k2[i10];
            if (constraintWidget3 != null && constraintWidget3.l0() != 8) {
                if (i14 == 0) {
                    constraintWidget3.l(constraintWidget3.Q, this.Q, s2());
                    constraintWidget3.B1(this.P1);
                    constraintWidget3.A1(f10);
                }
                if (i14 == i12 - 1) {
                    constraintWidget3.l(constraintWidget3.S, this.S, t2());
                }
                if (i14 > 0 && constraintWidget2 != null) {
                    constraintWidget3.l(constraintWidget3.Q, constraintWidget2.S, this.f3436b2);
                    constraintWidget2.l(constraintWidget2.S, constraintWidget3.Q, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i14++;
            f11 = f10;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            ConstraintWidget constraintWidget4 = this.f3444j2[i15];
            if (constraintWidget4 != null && constraintWidget4.l0() != 8) {
                if (i15 == 0) {
                    constraintWidget4.l(constraintWidget4.R, this.R, u2());
                    constraintWidget4.W1(this.Q1);
                    constraintWidget4.V1(this.W1);
                }
                if (i15 == i13 - 1) {
                    constraintWidget4.l(constraintWidget4.T, this.T, r2());
                }
                if (i15 > 0 && constraintWidget2 != null) {
                    constraintWidget4.l(constraintWidget4.R, constraintWidget2.T, this.f3437c2);
                    constraintWidget2.l(constraintWidget2.T, constraintWidget4.R, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i16 = 0; i16 < i12; i16++) {
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = (i17 * i12) + i16;
                if (this.f3442h2 == 1) {
                    i18 = (i16 * i13) + i17;
                }
                ConstraintWidget[] constraintWidgetArr = this.f3447m2;
                if (i18 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i18]) != null && constraintWidget.l0() != 8) {
                    ConstraintWidget constraintWidget5 = this.f3445k2[i16];
                    ConstraintWidget constraintWidget6 = this.f3444j2[i17];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.l(constraintWidget.Q, constraintWidget5.Q, 0);
                        constraintWidget.l(constraintWidget.S, constraintWidget5.S, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.l(constraintWidget.R, constraintWidget6.R, 0);
                        constraintWidget.l(constraintWidget.T, constraintWidget6.T, 0);
                    }
                }
            }
        }
    }

    public float d3() {
        return this.f3441g2;
    }

    public final int e3(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f3281x;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.E * i10);
                if (i12 != constraintWidget.D()) {
                    constraintWidget.N1(true);
                    w2(constraintWidget, constraintWidget.H(), constraintWidget.m0(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.D();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.m0() * constraintWidget.f3246f0) + 0.5f);
            }
        }
        return constraintWidget.D();
    }

    public final int f3(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f3279w;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.B * i10);
                if (i12 != constraintWidget.m0()) {
                    constraintWidget.N1(true);
                    w2(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.j0(), constraintWidget.D());
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.m0();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.D() * constraintWidget.f3246f0) + 0.5f);
            }
        }
        return constraintWidget.m0();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z10) {
        super.g(dVar, z10);
        boolean z11 = U() != null && ((d) U()).O2();
        int i10 = this.f3440f2;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.f3443i2.size();
                int i11 = 0;
                while (i11 < size) {
                    this.f3443i2.get(i11).d(z11, i11, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 == 2) {
                c3(z11);
            } else if (i10 == 3) {
                int size2 = this.f3443i2.size();
                int i12 = 0;
                while (i12 < size2) {
                    this.f3443i2.get(i12).d(z11, i12, i12 == size2 + (-1));
                    i12++;
                }
            }
        } else if (this.f3443i2.size() > 0) {
            this.f3443i2.get(0).d(z11, 0, true);
        }
        z2(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x011b -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x011d -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0123 -> B:42:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0125 -> B:42:0x0063). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g3(androidx.constraintlayout.core.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.g3(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void h3(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        int i15;
        ConstraintAnchor constraintAnchor;
        int iT2;
        ConstraintAnchor constraintAnchor2;
        int iR2;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.f3443i2.clear();
        a aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
        this.f3443i2.add(aVar);
        if (i11 == 0) {
            i13 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i10) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i18];
                int iF3 = f3(constraintWidget, i12);
                if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i19 = i13;
                boolean z10 = (i17 == i12 || (this.f3436b2 + i17) + iF3 > i12) && aVar.f3450b != null;
                if (!z10 && i18 > 0 && (i16 = this.f3441g2) > 0 && i18 % i16 == 0) {
                    z10 = true;
                }
                if (z10) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i18);
                    this.f3443i2.add(aVar);
                } else {
                    if (i18 > 0) {
                        i17 += this.f3436b2 + iF3;
                    }
                    aVar.b(constraintWidget);
                    i18++;
                    i13 = i19;
                }
                i17 = iF3;
                aVar.b(constraintWidget);
                i18++;
                i13 = i19;
            }
        } else {
            i13 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i10) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int iE3 = e3(constraintWidget2, i12);
                if (constraintWidget2.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i22 = i13;
                boolean z11 = (i20 == i12 || (this.f3437c2 + i20) + iE3 > i12) && aVar.f3450b != null;
                if (!z11 && i21 > 0 && (i14 = this.f3441g2) > 0 && i21 % i14 == 0) {
                    z11 = true;
                }
                if (z11) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i21);
                    this.f3443i2.add(aVar);
                } else {
                    if (i21 > 0) {
                        i20 += this.f3437c2 + iE3;
                    }
                    aVar.b(constraintWidget2);
                    i21++;
                    i13 = i22;
                }
                i20 = iE3;
                aVar.b(constraintWidget2);
                i21++;
                i13 = i22;
            }
        }
        int size = this.f3443i2.size();
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = this.R;
        ConstraintAnchor constraintAnchor5 = this.S;
        ConstraintAnchor constraintAnchor6 = this.T;
        int iS2 = s2();
        int iU2 = u2();
        int iT22 = t2();
        int iR22 = r2();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = H();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z12 = dimensionBehaviourH == dimensionBehaviour || j0() == dimensionBehaviour;
        if (i13 > 0 && z12) {
            for (int i23 = 0; i23 < size; i23++) {
                a aVar2 = this.f3443i2.get(i23);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        int i24 = iU2;
        int i25 = iT22;
        int iE = 0;
        int iF = 0;
        int i26 = 0;
        int i27 = iS2;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i28 = iR22;
        while (i26 < size) {
            a aVar3 = this.f3443i2.get(i26);
            if (i11 == 0) {
                if (i26 < size - 1) {
                    constraintAnchor2 = this.f3443i2.get(i26 + 1).f3450b.R;
                    iR2 = 0;
                } else {
                    constraintAnchor2 = this.T;
                    iR2 = r2();
                }
                ConstraintAnchor constraintAnchor9 = aVar3.f3450b.T;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i29 = iE;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i30 = iF;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i15 = i26;
                aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i27, i24, i25, iR2, i12);
                int iMax = Math.max(i30, aVar3.f());
                iE = i29 + aVar3.e();
                if (i15 > 0) {
                    iE += this.f3437c2;
                }
                constraintAnchor8 = constraintAnchor11;
                iF = iMax;
                constraintAnchor7 = constraintAnchor9;
                i24 = 0;
                constraintAnchor = constraintAnchor14;
                int i31 = iR2;
                constraintAnchor6 = constraintAnchor2;
                i28 = i31;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i32 = iE;
                int i33 = iF;
                i15 = i26;
                if (i15 < size - 1) {
                    constraintAnchor = this.f3443i2.get(i15 + 1).f3450b.Q;
                    iT2 = 0;
                } else {
                    constraintAnchor = this.S;
                    iT2 = t2();
                }
                ConstraintAnchor constraintAnchor16 = aVar3.f3450b.S;
                aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i27, i24, iT2, i28, i12);
                iF = i33 + aVar3.f();
                int iMax2 = Math.max(i32, aVar3.e());
                if (i15 > 0) {
                    iF += this.f3436b2;
                }
                iE = iMax2;
                i25 = iT2;
                constraintAnchor8 = constraintAnchor16;
                i27 = 0;
            }
            i26 = i15 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    public final void i3(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        int i15;
        ConstraintAnchor constraintAnchor;
        int iT2;
        ConstraintAnchor constraintAnchor2;
        int iR2;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.f3443i2.clear();
        a aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
        this.f3443i2.add(aVar);
        if (i11 == 0) {
            int i17 = 0;
            i13 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                int i20 = i17 + 1;
                ConstraintWidget constraintWidget = constraintWidgetArr[i19];
                int iF3 = f3(constraintWidget, i12);
                if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i21 = i13;
                boolean z10 = (i18 == i12 || (this.f3436b2 + i18) + iF3 > i12) && aVar.f3450b != null;
                if (!z10 && i19 > 0 && (i16 = this.f3441g2) > 0 && i20 > i16) {
                    z10 = true;
                }
                if (z10) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i19);
                    this.f3443i2.add(aVar);
                    i17 = i20;
                    i18 = iF3;
                } else {
                    i18 = i19 > 0 ? i18 + this.f3436b2 + iF3 : iF3;
                    i17 = 0;
                }
                aVar.b(constraintWidget);
                i19++;
                i13 = i21;
            }
        } else {
            int i22 = 0;
            i13 = 0;
            int i23 = 0;
            while (i23 < i10) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i23];
                int iE3 = e3(constraintWidget2, i12);
                if (constraintWidget2.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i24 = i13;
                boolean z11 = (i22 == i12 || (this.f3437c2 + i22) + iE3 > i12) && aVar.f3450b != null;
                if (!z11 && i23 > 0 && (i14 = this.f3441g2) > 0 && i14 < 0) {
                    z11 = true;
                }
                if (z11) {
                    aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
                    aVar.i(i23);
                    this.f3443i2.add(aVar);
                } else {
                    if (i23 > 0) {
                        i22 += this.f3437c2 + iE3;
                    }
                    aVar.b(constraintWidget2);
                    i23++;
                    i13 = i24;
                }
                i22 = iE3;
                aVar.b(constraintWidget2);
                i23++;
                i13 = i24;
            }
        }
        int size = this.f3443i2.size();
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = this.R;
        ConstraintAnchor constraintAnchor5 = this.S;
        ConstraintAnchor constraintAnchor6 = this.T;
        int iS2 = s2();
        int iU2 = u2();
        int iT22 = t2();
        int iR22 = r2();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = H();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z12 = dimensionBehaviourH == dimensionBehaviour || j0() == dimensionBehaviour;
        if (i13 > 0 && z12) {
            for (int i25 = 0; i25 < size; i25++) {
                a aVar2 = this.f3443i2.get(i25);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        int i26 = iU2;
        int i27 = iT22;
        int iE = 0;
        int iF = 0;
        int i28 = 0;
        int i29 = iS2;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i30 = iR22;
        while (i28 < size) {
            a aVar3 = this.f3443i2.get(i28);
            if (i11 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor2 = this.f3443i2.get(i28 + 1).f3450b.R;
                    iR2 = 0;
                } else {
                    constraintAnchor2 = this.T;
                    iR2 = r2();
                }
                ConstraintAnchor constraintAnchor9 = aVar3.f3450b.T;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i31 = iE;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i32 = iF;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i15 = i28;
                aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i29, i26, i27, iR2, i12);
                int iMax = Math.max(i32, aVar3.f());
                iE = i31 + aVar3.e();
                if (i15 > 0) {
                    iE += this.f3437c2;
                }
                constraintAnchor8 = constraintAnchor11;
                iF = iMax;
                constraintAnchor7 = constraintAnchor9;
                i26 = 0;
                constraintAnchor = constraintAnchor14;
                int i33 = iR2;
                constraintAnchor6 = constraintAnchor2;
                i30 = i33;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i34 = iE;
                int i35 = iF;
                i15 = i28;
                if (i15 < size - 1) {
                    constraintAnchor = this.f3443i2.get(i15 + 1).f3450b.Q;
                    iT2 = 0;
                } else {
                    constraintAnchor = this.S;
                    iT2 = t2();
                }
                ConstraintAnchor constraintAnchor16 = aVar3.f3450b.S;
                aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i29, i26, iT2, i30, i12);
                iF = i35 + aVar3.f();
                int iMax2 = Math.max(i34, aVar3.e());
                if (i15 > 0) {
                    iF += this.f3436b2;
                }
                iE = iMax2;
                i27 = iT2;
                constraintAnchor8 = constraintAnchor16;
                i29 = 0;
            }
            i28 = i15 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    public final void j3(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.f3443i2.size() == 0) {
            aVar = new a(i11, this.Q, this.R, this.S, this.T, i12);
            this.f3443i2.add(aVar);
        } else {
            a aVar2 = this.f3443i2.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i11, this.Q, this.R, this.S, this.T, s2(), u2(), t2(), r2(), i12);
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.b(constraintWidgetArr[i13]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void k3(float f10) {
        this.X1 = f10;
    }

    public void l3(int i10) {
        this.R1 = i10;
    }

    public void m3(float f10) {
        this.Y1 = f10;
    }

    @Override // y.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        e eVar = (e) constraintWidget;
        this.P1 = eVar.P1;
        this.Q1 = eVar.Q1;
        this.R1 = eVar.R1;
        this.S1 = eVar.S1;
        this.T1 = eVar.T1;
        this.U1 = eVar.U1;
        this.V1 = eVar.V1;
        this.W1 = eVar.W1;
        this.X1 = eVar.X1;
        this.Y1 = eVar.Y1;
        this.Z1 = eVar.Z1;
        this.f3435a2 = eVar.f3435a2;
        this.f3436b2 = eVar.f3436b2;
        this.f3437c2 = eVar.f3437c2;
        this.f3438d2 = eVar.f3438d2;
        this.f3439e2 = eVar.f3439e2;
        this.f3440f2 = eVar.f3440f2;
        this.f3441g2 = eVar.f3441g2;
        this.f3442h2 = eVar.f3442h2;
    }

    public void n3(int i10) {
        this.S1 = i10;
    }

    public void o3(int i10) {
        this.f3438d2 = i10;
    }

    public void p3(float f10) {
        this.V1 = f10;
    }

    public void q3(int i10) {
        this.f3436b2 = i10;
    }

    public void r3(int i10) {
        this.P1 = i10;
    }

    public void s3(float f10) {
        this.Z1 = f10;
    }

    public void t3(int i10) {
        this.T1 = i10;
    }

    public void u3(float f10) {
        this.f3435a2 = f10;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    @Override // androidx.constraintlayout.core.widgets.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v2(int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.v2(int, int, int, int):void");
    }

    public void v3(int i10) {
        this.U1 = i10;
    }

    public void w3(int i10) {
        this.f3441g2 = i10;
    }

    public void x3(int i10) {
        this.f3442h2 = i10;
    }

    public void y3(int i10) {
        this.f3439e2 = i10;
    }

    public void z3(float f10) {
        this.W1 = f10;
    }
}
