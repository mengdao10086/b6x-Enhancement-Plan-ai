package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* JADX INFO: loaded from: classes2.dex */
public class m extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DependencyNode f3370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f3371l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3372a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f3372a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3372a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3372a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public m(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f3370k = dependencyNode;
        this.f3371l = null;
        this.f3308h.f3293e = DependencyNode.Type.TOP;
        this.f3309i.f3293e = DependencyNode.Type.BOTTOM;
        dependencyNode.f3293e = DependencyNode.Type.BASELINE;
        this.f3306f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        float f10;
        float fA;
        float fA2;
        int i10;
        int i11 = a.f3372a[this.f3310j.ordinal()];
        if (i11 == 1) {
            s(dVar);
        } else if (i11 == 2) {
            r(dVar);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget = this.f3302b;
            q(dVar, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        f fVar = this.f3305e;
        if (fVar.f3291c && !fVar.f3298j && this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f3302b;
            int i12 = constraintWidget2.f3281x;
            if (i12 == 2) {
                ConstraintWidget constraintWidgetU = constraintWidget2.U();
                if (constraintWidgetU != null) {
                    if (constraintWidgetU.f3245f.f3305e.f3298j) {
                        this.f3305e.e((int) ((r7.f3295g * this.f3302b.E) + 0.5f));
                    }
                }
            } else if (i12 == 3 && constraintWidget2.f3243e.f3305e.f3298j) {
                int iB = constraintWidget2.B();
                if (iB == -1) {
                    ConstraintWidget constraintWidget3 = this.f3302b;
                    f10 = constraintWidget3.f3243e.f3305e.f3295g;
                    fA = constraintWidget3.A();
                } else if (iB == 0) {
                    fA2 = r7.f3243e.f3305e.f3295g * this.f3302b.A();
                    i10 = (int) (fA2 + 0.5f);
                    this.f3305e.e(i10);
                } else if (iB != 1) {
                    i10 = 0;
                    this.f3305e.e(i10);
                } else {
                    ConstraintWidget constraintWidget4 = this.f3302b;
                    f10 = constraintWidget4.f3243e.f3305e.f3295g;
                    fA = constraintWidget4.A();
                }
                fA2 = f10 / fA;
                i10 = (int) (fA2 + 0.5f);
                this.f3305e.e(i10);
            }
        }
        DependencyNode dependencyNode = this.f3308h;
        if (dependencyNode.f3291c) {
            DependencyNode dependencyNode2 = this.f3309i;
            if (dependencyNode2.f3291c) {
                if (dependencyNode.f3298j && dependencyNode2.f3298j && this.f3305e.f3298j) {
                    return;
                }
                if (!this.f3305e.f3298j && this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f3302b;
                    if (constraintWidget5.f3279w == 0 && !constraintWidget5.D0()) {
                        DependencyNode dependencyNode3 = this.f3308h.f3300l.get(0);
                        DependencyNode dependencyNode4 = this.f3309i.f3300l.get(0);
                        int i13 = dependencyNode3.f3295g;
                        DependencyNode dependencyNode5 = this.f3308h;
                        int i14 = i13 + dependencyNode5.f3294f;
                        int i15 = dependencyNode4.f3295g + this.f3309i.f3294f;
                        dependencyNode5.e(i14);
                        this.f3309i.e(i15);
                        this.f3305e.e(i15 - i14);
                        return;
                    }
                }
                if (!this.f3305e.f3298j && this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f3301a == 1 && this.f3308h.f3300l.size() > 0 && this.f3309i.f3300l.size() > 0) {
                    DependencyNode dependencyNode6 = this.f3308h.f3300l.get(0);
                    int i16 = (this.f3309i.f3300l.get(0).f3295g + this.f3309i.f3294f) - (dependencyNode6.f3295g + this.f3308h.f3294f);
                    f fVar2 = this.f3305e;
                    int i17 = fVar2.f3348m;
                    if (i16 < i17) {
                        fVar2.e(i16);
                    } else {
                        fVar2.e(i17);
                    }
                }
                if (this.f3305e.f3298j && this.f3308h.f3300l.size() > 0 && this.f3309i.f3300l.size() > 0) {
                    DependencyNode dependencyNode7 = this.f3308h.f3300l.get(0);
                    DependencyNode dependencyNode8 = this.f3309i.f3300l.get(0);
                    int i18 = dependencyNode7.f3295g + this.f3308h.f3294f;
                    int i19 = dependencyNode8.f3295g + this.f3309i.f3294f;
                    float fG0 = this.f3302b.g0();
                    if (dependencyNode7 == dependencyNode8) {
                        i18 = dependencyNode7.f3295g;
                        i19 = dependencyNode8.f3295g;
                        fG0 = 0.5f;
                    }
                    this.f3308h.e((int) (i18 + 0.5f + (((i19 - i18) - this.f3305e.f3295g) * fG0)));
                    this.f3309i.e(this.f3308h.f3295g + this.f3305e.f3295g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidgetU;
        ConstraintWidget constraintWidgetU2;
        ConstraintWidget constraintWidget = this.f3302b;
        if (constraintWidget.f3235a) {
            this.f3305e.e(constraintWidget.D());
        }
        if (!this.f3305e.f3298j) {
            this.f3304d = this.f3302b.j0();
            if (this.f3302b.q0()) {
                this.f3371l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f3304d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetU2 = this.f3302b.U()) != null && constraintWidgetU2.j0() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int iD = (constraintWidgetU2.D() - this.f3302b.R.g()) - this.f3302b.T.g();
                    b(this.f3308h, constraintWidgetU2.f3245f.f3308h, this.f3302b.R.g());
                    b(this.f3309i, constraintWidgetU2.f3245f.f3309i, -this.f3302b.T.g());
                    this.f3305e.e(iD);
                    return;
                }
                if (this.f3304d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f3305e.e(this.f3302b.D());
                }
            }
        } else if (this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetU = this.f3302b.U()) != null && constraintWidgetU.j0() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f3308h, constraintWidgetU.f3245f.f3308h, this.f3302b.R.g());
            b(this.f3309i, constraintWidgetU.f3245f.f3309i, -this.f3302b.T.g());
            return;
        }
        f fVar = this.f3305e;
        boolean z10 = fVar.f3298j;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.f3302b;
            if (constraintWidget2.f3235a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                if (constraintAnchorArr[2].f3204f != null && constraintAnchorArr[3].f3204f != null) {
                    if (constraintWidget2.D0()) {
                        this.f3308h.f3294f = this.f3302b.Y[2].g();
                        this.f3309i.f3294f = -this.f3302b.Y[3].g();
                    } else {
                        DependencyNode dependencyNodeH = h(this.f3302b.Y[2]);
                        if (dependencyNodeH != null) {
                            b(this.f3308h, dependencyNodeH, this.f3302b.Y[2].g());
                        }
                        DependencyNode dependencyNodeH2 = h(this.f3302b.Y[3]);
                        if (dependencyNodeH2 != null) {
                            b(this.f3309i, dependencyNodeH2, -this.f3302b.Y[3].g());
                        }
                        this.f3308h.f3290b = true;
                        this.f3309i.f3290b = true;
                    }
                    if (this.f3302b.q0()) {
                        b(this.f3370k, this.f3308h, this.f3302b.t());
                        return;
                    }
                    return;
                }
                if (constraintAnchorArr[2].f3204f != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchorArr[2]);
                    if (dependencyNodeH3 != null) {
                        b(this.f3308h, dependencyNodeH3, this.f3302b.Y[2].g());
                        b(this.f3309i, this.f3308h, this.f3305e.f3295g);
                        if (this.f3302b.q0()) {
                            b(this.f3370k, this.f3308h, this.f3302b.t());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (constraintAnchorArr[3].f3204f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchorArr[3]);
                    if (dependencyNodeH4 != null) {
                        b(this.f3309i, dependencyNodeH4, -this.f3302b.Y[3].g());
                        b(this.f3308h, this.f3309i, -this.f3305e.f3295g);
                    }
                    if (this.f3302b.q0()) {
                        b(this.f3370k, this.f3308h, this.f3302b.t());
                        return;
                    }
                    return;
                }
                if (constraintAnchorArr[4].f3204f != null) {
                    DependencyNode dependencyNodeH5 = h(constraintAnchorArr[4]);
                    if (dependencyNodeH5 != null) {
                        b(this.f3370k, dependencyNodeH5, 0);
                        b(this.f3308h, this.f3370k, -this.f3302b.t());
                        b(this.f3309i, this.f3308h, this.f3305e.f3295g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof y.a) || constraintWidget2.U() == null || this.f3302b.r(ConstraintAnchor.Type.CENTER).f3204f != null) {
                    return;
                }
                b(this.f3308h, this.f3302b.U().f3245f.f3308h, this.f3302b.p0());
                b(this.f3309i, this.f3308h, this.f3305e.f3295g);
                if (this.f3302b.q0()) {
                    b(this.f3370k, this.f3308h, this.f3302b.t());
                    return;
                }
                return;
            }
        }
        if (z10 || this.f3304d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            fVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f3302b;
            int i10 = constraintWidget3.f3281x;
            if (i10 == 2) {
                ConstraintWidget constraintWidgetU3 = constraintWidget3.U();
                if (constraintWidgetU3 != null) {
                    f fVar2 = constraintWidgetU3.f3245f.f3305e;
                    this.f3305e.f3300l.add(fVar2);
                    fVar2.f3299k.add(this.f3305e);
                    f fVar3 = this.f3305e;
                    fVar3.f3290b = true;
                    fVar3.f3299k.add(this.f3308h);
                    this.f3305e.f3299k.add(this.f3309i);
                }
            } else if (i10 == 3 && !constraintWidget3.D0()) {
                ConstraintWidget constraintWidget4 = this.f3302b;
                if (constraintWidget4.f3279w != 3) {
                    f fVar4 = constraintWidget4.f3243e.f3305e;
                    this.f3305e.f3300l.add(fVar4);
                    fVar4.f3299k.add(this.f3305e);
                    f fVar5 = this.f3305e;
                    fVar5.f3290b = true;
                    fVar5.f3299k.add(this.f3308h);
                    this.f3305e.f3299k.add(this.f3309i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f3302b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        if (constraintAnchorArr2[2].f3204f != null && constraintAnchorArr2[3].f3204f != null) {
            if (constraintWidget5.D0()) {
                this.f3308h.f3294f = this.f3302b.Y[2].g();
                this.f3309i.f3294f = -this.f3302b.Y[3].g();
            } else {
                DependencyNode dependencyNodeH6 = h(this.f3302b.Y[2]);
                DependencyNode dependencyNodeH7 = h(this.f3302b.Y[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f3310j = WidgetRun.RunType.CENTER;
            }
            if (this.f3302b.q0()) {
                c(this.f3370k, this.f3308h, 1, this.f3371l);
            }
        } else if (constraintAnchorArr2[2].f3204f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchorArr2[2]);
            if (dependencyNodeH8 != null) {
                b(this.f3308h, dependencyNodeH8, this.f3302b.Y[2].g());
                c(this.f3309i, this.f3308h, 1, this.f3305e);
                if (this.f3302b.q0()) {
                    c(this.f3370k, this.f3308h, 1, this.f3371l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f3304d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f3302b.A() > 0.0f) {
                    k kVar = this.f3302b.f3243e;
                    if (kVar.f3304d == dimensionBehaviour3) {
                        kVar.f3305e.f3299k.add(this.f3305e);
                        this.f3305e.f3300l.add(this.f3302b.f3243e.f3305e);
                        this.f3305e.f3289a = this;
                    }
                }
            }
        } else if (constraintAnchorArr2[3].f3204f != null) {
            DependencyNode dependencyNodeH9 = h(constraintAnchorArr2[3]);
            if (dependencyNodeH9 != null) {
                b(this.f3309i, dependencyNodeH9, -this.f3302b.Y[3].g());
                c(this.f3308h, this.f3309i, -1, this.f3305e);
                if (this.f3302b.q0()) {
                    c(this.f3370k, this.f3308h, 1, this.f3371l);
                }
            }
        } else if (constraintAnchorArr2[4].f3204f != null) {
            DependencyNode dependencyNodeH10 = h(constraintAnchorArr2[4]);
            if (dependencyNodeH10 != null) {
                b(this.f3370k, dependencyNodeH10, 0);
                c(this.f3308h, this.f3370k, -1, this.f3371l);
                c(this.f3309i, this.f3308h, 1, this.f3305e);
            }
        } else if (!(constraintWidget5 instanceof y.a) && constraintWidget5.U() != null) {
            b(this.f3308h, this.f3302b.U().f3245f.f3308h, this.f3302b.p0());
            c(this.f3309i, this.f3308h, 1, this.f3305e);
            if (this.f3302b.q0()) {
                c(this.f3370k, this.f3308h, 1, this.f3371l);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f3304d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour4 == dimensionBehaviour5 && this.f3302b.A() > 0.0f) {
                k kVar2 = this.f3302b.f3243e;
                if (kVar2.f3304d == dimensionBehaviour5) {
                    kVar2.f3305e.f3299k.add(this.f3305e);
                    this.f3305e.f3300l.add(this.f3302b.f3243e.f3305e);
                    this.f3305e.f3289a = this;
                }
            }
        }
        if (this.f3305e.f3300l.size() == 0) {
            this.f3305e.f3291c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f3308h;
        if (dependencyNode.f3298j) {
            this.f3302b.g2(dependencyNode.f3295g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f3303c = null;
        this.f3308h.c();
        this.f3309i.c();
        this.f3370k.c();
        this.f3305e.c();
        this.f3307g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void n() {
        this.f3307g = false;
        this.f3308h.c();
        this.f3308h.f3298j = false;
        this.f3309i.c();
        this.f3309i.f3298j = false;
        this.f3370k.c();
        this.f3370k.f3298j = false;
        this.f3305e.f3298j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean p() {
        return this.f3304d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f3302b.f3281x == 0;
    }

    public String toString() {
        return "VerticalRun " + this.f3302b.y();
    }
}
