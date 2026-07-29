package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidget f3391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f3392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintWidget f3393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget f3394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintWidget f3395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintWidget f3396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintWidget f3397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f3398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3401k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3412v;

    public c(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f3391a = constraintWidget;
        this.f3406p = i10;
        this.f3407q = z10;
    }

    public static boolean k(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget.l0() != 8 && constraintWidget.f3238b0[i10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.f3283y;
            if (iArr[i10] == 0 || iArr[i10] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.f3412v) {
            b();
        }
        this.f3412v = true;
    }

    public final void b() {
        int i10 = this.f3406p * 2;
        ConstraintWidget constraintWidget = this.f3391a;
        this.f3405o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z10 = false;
        while (!z10) {
            this.f3399i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i11 = this.f3406p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i11] = null;
            constraintWidget.O0[i11] = null;
            if (constraintWidget.l0() != 8) {
                this.f3402l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourZ = constraintWidget.z(this.f3406p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourZ != dimensionBehaviour) {
                    this.f3403m += constraintWidget.M(this.f3406p);
                }
                int iG = this.f3403m + constraintWidget.Y[i10].g();
                this.f3403m = iG;
                int i12 = i10 + 1;
                this.f3403m = iG + constraintWidget.Y[i12].g();
                int iG2 = this.f3404n + constraintWidget.Y[i10].g();
                this.f3404n = iG2;
                this.f3404n = iG2 + constraintWidget.Y[i12].g();
                if (this.f3392b == null) {
                    this.f3392b = constraintWidget;
                }
                this.f3394d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f3238b0;
                int i13 = this.f3406p;
                if (dimensionBehaviourArr[i13] == dimensionBehaviour) {
                    int[] iArr = constraintWidget.f3283y;
                    if (iArr[i13] == 0 || iArr[i13] == 3 || iArr[i13] == 2) {
                        this.f3400j++;
                        float[] fArr = constraintWidget.N0;
                        float f10 = fArr[i13];
                        if (f10 > 0.0f) {
                            this.f3401k += fArr[i13];
                        }
                        if (k(constraintWidget, i13)) {
                            if (f10 < 0.0f) {
                                this.f3408r = true;
                            } else {
                                this.f3409s = true;
                            }
                            if (this.f3398h == null) {
                                this.f3398h = new ArrayList<>();
                            }
                            this.f3398h.add(constraintWidget);
                        }
                        if (this.f3396f == null) {
                            this.f3396f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f3397g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.f3406p] = constraintWidget;
                        }
                        this.f3397g = constraintWidget;
                    }
                    if (this.f3406p == 0) {
                        if (constraintWidget.f3279w != 0 || constraintWidget.f3285z != 0 || constraintWidget.A != 0) {
                            this.f3405o = false;
                        }
                    } else if (constraintWidget.f3281x != 0 || constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.f3405o = false;
                    }
                    if (constraintWidget.f3246f0 != 0.0f) {
                        this.f3405o = false;
                        this.f3411u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.f3406p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i10 + 1].f3204f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f3202d;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.Y;
                if (constraintAnchorArr[i10].f3204f != null && constraintAnchorArr[i10].f3204f.f3202d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z10 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f3392b;
        if (constraintWidget6 != null) {
            this.f3403m -= constraintWidget6.Y[i10].g();
        }
        ConstraintWidget constraintWidget7 = this.f3394d;
        if (constraintWidget7 != null) {
            this.f3403m -= constraintWidget7.Y[i10 + 1].g();
        }
        this.f3393c = constraintWidget;
        if (this.f3406p == 0 && this.f3407q) {
            this.f3395e = constraintWidget;
        } else {
            this.f3395e = this.f3391a;
        }
        this.f3410t = this.f3409s && this.f3408r;
    }

    public ConstraintWidget c() {
        return this.f3391a;
    }

    public ConstraintWidget d() {
        return this.f3396f;
    }

    public ConstraintWidget e() {
        return this.f3392b;
    }

    public ConstraintWidget f() {
        return this.f3395e;
    }

    public ConstraintWidget g() {
        return this.f3393c;
    }

    public ConstraintWidget h() {
        return this.f3397g;
    }

    public ConstraintWidget i() {
        return this.f3394d;
    }

    public float j() {
        return this.f3401k;
    }
}
