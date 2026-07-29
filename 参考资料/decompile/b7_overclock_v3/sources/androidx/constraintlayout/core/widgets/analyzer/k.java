package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* JADX INFO: loaded from: classes2.dex */
public class k extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f3357k = new int[2];

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3358a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f3358a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3358a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3358a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public k(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f3308h.f3293e = DependencyNode.Type.LEFT;
        this.f3309i.f3293e = DependencyNode.Type.RIGHT;
        this.f3306f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02e2  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.d r17) {
        /*
            Method dump skipped, instruction units count: 1095
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.k.a(androidx.constraintlayout.core.widgets.analyzer.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidgetU;
        ConstraintWidget constraintWidgetU2;
        ConstraintWidget constraintWidget = this.f3302b;
        if (constraintWidget.f3235a) {
            this.f3305e.e(constraintWidget.m0());
        }
        if (this.f3305e.f3298j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f3304d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (constraintWidgetU = this.f3302b.U()) != null && (constraintWidgetU.H() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetU.H() == dimensionBehaviour2)) {
                b(this.f3308h, constraintWidgetU.f3243e.f3308h, this.f3302b.Q.g());
                b(this.f3309i, constraintWidgetU.f3243e.f3309i, -this.f3302b.S.g());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourH = this.f3302b.H();
            this.f3304d = dimensionBehaviourH;
            if (dimensionBehaviourH != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviourH == dimensionBehaviour3 && (constraintWidgetU2 = this.f3302b.U()) != null && (constraintWidgetU2.H() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetU2.H() == dimensionBehaviour3)) {
                    int iM0 = (constraintWidgetU2.m0() - this.f3302b.Q.g()) - this.f3302b.S.g();
                    b(this.f3308h, constraintWidgetU2.f3243e.f3308h, this.f3302b.Q.g());
                    b(this.f3309i, constraintWidgetU2.f3243e.f3309i, -this.f3302b.S.g());
                    this.f3305e.e(iM0);
                    return;
                }
                if (this.f3304d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f3305e.e(this.f3302b.m0());
                }
            }
        }
        f fVar = this.f3305e;
        if (fVar.f3298j) {
            ConstraintWidget constraintWidget2 = this.f3302b;
            if (constraintWidget2.f3235a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                if (constraintAnchorArr[0].f3204f != null && constraintAnchorArr[1].f3204f != null) {
                    if (constraintWidget2.B0()) {
                        this.f3308h.f3294f = this.f3302b.Y[0].g();
                        this.f3309i.f3294f = -this.f3302b.Y[1].g();
                        return;
                    }
                    DependencyNode dependencyNodeH = h(this.f3302b.Y[0]);
                    if (dependencyNodeH != null) {
                        b(this.f3308h, dependencyNodeH, this.f3302b.Y[0].g());
                    }
                    DependencyNode dependencyNodeH2 = h(this.f3302b.Y[1]);
                    if (dependencyNodeH2 != null) {
                        b(this.f3309i, dependencyNodeH2, -this.f3302b.Y[1].g());
                    }
                    this.f3308h.f3290b = true;
                    this.f3309i.f3290b = true;
                    return;
                }
                if (constraintAnchorArr[0].f3204f != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchorArr[0]);
                    if (dependencyNodeH3 != null) {
                        b(this.f3308h, dependencyNodeH3, this.f3302b.Y[0].g());
                        b(this.f3309i, this.f3308h, this.f3305e.f3295g);
                        return;
                    }
                    return;
                }
                if (constraintAnchorArr[1].f3204f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchorArr[1]);
                    if (dependencyNodeH4 != null) {
                        b(this.f3309i, dependencyNodeH4, -this.f3302b.Y[1].g());
                        b(this.f3308h, this.f3309i, -this.f3305e.f3295g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof y.a) || constraintWidget2.U() == null || this.f3302b.r(ConstraintAnchor.Type.CENTER).f3204f != null) {
                    return;
                }
                b(this.f3308h, this.f3302b.U().f3243e.f3308h, this.f3302b.o0());
                b(this.f3309i, this.f3308h, this.f3305e.f3295g);
                return;
            }
        }
        if (this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f3302b;
            int i10 = constraintWidget3.f3279w;
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
            } else if (i10 == 3) {
                if (constraintWidget3.f3281x == 3) {
                    this.f3308h.f3289a = this;
                    this.f3309i.f3289a = this;
                    m mVar = constraintWidget3.f3245f;
                    mVar.f3308h.f3289a = this;
                    mVar.f3309i.f3289a = this;
                    fVar.f3289a = this;
                    if (constraintWidget3.D0()) {
                        this.f3305e.f3300l.add(this.f3302b.f3245f.f3305e);
                        this.f3302b.f3245f.f3305e.f3299k.add(this.f3305e);
                        m mVar2 = this.f3302b.f3245f;
                        mVar2.f3305e.f3289a = this;
                        this.f3305e.f3300l.add(mVar2.f3308h);
                        this.f3305e.f3300l.add(this.f3302b.f3245f.f3309i);
                        this.f3302b.f3245f.f3308h.f3299k.add(this.f3305e);
                        this.f3302b.f3245f.f3309i.f3299k.add(this.f3305e);
                    } else if (this.f3302b.B0()) {
                        this.f3302b.f3245f.f3305e.f3300l.add(this.f3305e);
                        this.f3305e.f3299k.add(this.f3302b.f3245f.f3305e);
                    } else {
                        this.f3302b.f3245f.f3305e.f3300l.add(this.f3305e);
                    }
                } else {
                    f fVar4 = constraintWidget3.f3245f.f3305e;
                    fVar.f3300l.add(fVar4);
                    fVar4.f3299k.add(this.f3305e);
                    this.f3302b.f3245f.f3308h.f3299k.add(this.f3305e);
                    this.f3302b.f3245f.f3309i.f3299k.add(this.f3305e);
                    f fVar5 = this.f3305e;
                    fVar5.f3290b = true;
                    fVar5.f3299k.add(this.f3308h);
                    this.f3305e.f3299k.add(this.f3309i);
                    this.f3308h.f3300l.add(this.f3305e);
                    this.f3309i.f3300l.add(this.f3305e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f3302b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        if (constraintAnchorArr2[0].f3204f != null && constraintAnchorArr2[1].f3204f != null) {
            if (constraintWidget4.B0()) {
                this.f3308h.f3294f = this.f3302b.Y[0].g();
                this.f3309i.f3294f = -this.f3302b.Y[1].g();
                return;
            }
            DependencyNode dependencyNodeH5 = h(this.f3302b.Y[0]);
            DependencyNode dependencyNodeH6 = h(this.f3302b.Y[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f3310j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchorArr2[0].f3204f != null) {
            DependencyNode dependencyNodeH7 = h(constraintAnchorArr2[0]);
            if (dependencyNodeH7 != null) {
                b(this.f3308h, dependencyNodeH7, this.f3302b.Y[0].g());
                c(this.f3309i, this.f3308h, 1, this.f3305e);
                return;
            }
            return;
        }
        if (constraintAnchorArr2[1].f3204f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchorArr2[1]);
            if (dependencyNodeH8 != null) {
                b(this.f3309i, dependencyNodeH8, -this.f3302b.Y[1].g());
                c(this.f3308h, this.f3309i, -1, this.f3305e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof y.a) || constraintWidget4.U() == null) {
            return;
        }
        b(this.f3308h, this.f3302b.U().f3243e.f3308h, this.f3302b.o0());
        c(this.f3309i, this.f3308h, 1, this.f3305e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f3308h;
        if (dependencyNode.f3298j) {
            this.f3302b.f2(dependencyNode.f3295g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f3303c = null;
        this.f3308h.c();
        this.f3309i.c();
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
        this.f3305e.f3298j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean p() {
        return this.f3304d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f3302b.f3279w == 0;
    }

    public String toString() {
        return "HorizontalRun " + this.f3302b.y();
    }

    public final void u(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }
}
