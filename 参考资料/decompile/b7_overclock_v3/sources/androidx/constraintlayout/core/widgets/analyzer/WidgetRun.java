package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetRun implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintWidget f3302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f3303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f3304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f3305e = new f(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3306f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3307g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DependencyNode f3308h = new DependencyNode(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DependencyNode f3309i = new DependencyNode(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RunType f3310j = RunType.NONE;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3311a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f3311a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3311a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3311a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3311a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3311a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f3302b = constraintWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f3300l.add(dependencyNode2);
        dependencyNode.f3294f = i10;
        dependencyNode2.f3299k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, f fVar) {
        dependencyNode.f3300l.add(dependencyNode2);
        dependencyNode.f3300l.add(this.f3305e);
        dependencyNode.f3296h = i10;
        dependencyNode.f3297i = fVar;
        dependencyNode2.f3299k.add(dependencyNode);
        fVar.f3299k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        int iMax;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f3302b;
            int i12 = constraintWidget.A;
            iMax = Math.max(constraintWidget.f3285z, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f3302b;
            int i13 = constraintWidget2.D;
            iMax = Math.max(constraintWidget2.C, i10);
            if (i13 > 0) {
                iMax = Math.min(i13, i10);
            }
            if (iMax == i10) {
                return i10;
            }
        }
        return iMax;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3204f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f3202d;
        int i10 = a.f3311a[constraintAnchor2.f3203e.ordinal()];
        if (i10 == 1) {
            return constraintWidget.f3243e.f3308h;
        }
        if (i10 == 2) {
            return constraintWidget.f3243e.f3309i;
        }
        if (i10 == 3) {
            return constraintWidget.f3245f.f3308h;
        }
        if (i10 == 4) {
            return constraintWidget.f3245f.f3370k;
        }
        if (i10 != 5) {
            return null;
        }
        return constraintWidget.f3245f.f3309i;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3204f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f3202d;
        WidgetRun widgetRun = i10 == 0 ? constraintWidget.f3243e : constraintWidget.f3245f;
        int i11 = a.f3311a[constraintAnchor2.f3203e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f3309i;
        }
        return widgetRun.f3308h;
    }

    public long j() {
        if (this.f3305e.f3298j) {
            return r0.f3295g;
        }
        return 0L;
    }

    public boolean k() {
        int size = this.f3308h.f3300l.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f3308h.f3300l.get(i11).f3292d != this) {
                i10++;
            }
        }
        int size2 = this.f3309i.f3300l.size();
        for (int i12 = 0; i12 < size2; i12++) {
            if (this.f3309i.f3300l.get(i12).f3292d != this) {
                i10++;
            }
        }
        return i10 >= 2;
    }

    public boolean l() {
        return this.f3305e.f3298j;
    }

    public boolean m() {
        return this.f3307g;
    }

    public abstract void n();

    public final void o(int i10, int i11) {
        int i12 = this.f3301a;
        if (i12 == 0) {
            this.f3305e.e(g(i11, i10));
            return;
        }
        if (i12 == 1) {
            this.f3305e.e(Math.min(g(this.f3305e.f3348m, i10), i11));
            return;
        }
        if (i12 == 2) {
            ConstraintWidget constraintWidgetU = this.f3302b.U();
            if (constraintWidgetU != null) {
                if ((i10 == 0 ? constraintWidgetU.f3243e : constraintWidgetU.f3245f).f3305e.f3298j) {
                    ConstraintWidget constraintWidget = this.f3302b;
                    this.f3305e.e(g((int) ((r9.f3295g * (i10 == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f), i10));
                    return;
                }
                return;
            }
            return;
        }
        if (i12 != 3) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.f3302b;
        WidgetRun widgetRun = constraintWidget2.f3243e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f3304d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f3301a == 3) {
            m mVar = constraintWidget2.f3245f;
            if (mVar.f3304d == dimensionBehaviour2 && mVar.f3301a == 3) {
                return;
            }
        }
        if (i10 == 0) {
            widgetRun = constraintWidget2.f3245f;
        }
        if (widgetRun.f3305e.f3298j) {
            float fA = constraintWidget2.A();
            this.f3305e.e(i10 == 1 ? (int) ((widgetRun.f3305e.f3295g / fA) + 0.5f) : (int) ((fA * widgetRun.f3305e.f3295g) + 0.5f));
        }
    }

    public abstract boolean p();

    public void q(d dVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        DependencyNode dependencyNodeH = h(constraintAnchor);
        DependencyNode dependencyNodeH2 = h(constraintAnchor2);
        if (dependencyNodeH.f3298j && dependencyNodeH2.f3298j) {
            int iG = dependencyNodeH.f3295g + constraintAnchor.g();
            int iG2 = dependencyNodeH2.f3295g - constraintAnchor2.g();
            int i11 = iG2 - iG;
            if (!this.f3305e.f3298j && this.f3304d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                o(i10, i11);
            }
            f fVar = this.f3305e;
            if (fVar.f3298j) {
                if (fVar.f3295g == i11) {
                    this.f3308h.e(iG);
                    this.f3309i.e(iG2);
                    return;
                }
                ConstraintWidget constraintWidget = this.f3302b;
                float fE = i10 == 0 ? constraintWidget.E() : constraintWidget.g0();
                if (dependencyNodeH == dependencyNodeH2) {
                    iG = dependencyNodeH.f3295g;
                    iG2 = dependencyNodeH2.f3295g;
                    fE = 0.5f;
                }
                this.f3308h.e((int) (iG + 0.5f + (((iG2 - iG) - this.f3305e.f3295g) * fE)));
                this.f3309i.e(this.f3308h.f3295g + this.f3305e.f3295g);
            }
        }
    }

    public void r(d dVar) {
    }

    public void s(d dVar) {
    }

    public long t(int i10) {
        int i11;
        f fVar = this.f3305e;
        if (!fVar.f3298j) {
            return 0L;
        }
        long j10 = fVar.f3295g;
        if (k()) {
            i11 = this.f3308h.f3294f - this.f3309i.f3294f;
        } else {
            if (i10 != 0) {
                return j10 - ((long) this.f3309i.f3294f);
            }
            i11 = this.f3308h.f3294f;
        }
        return j10 + ((long) i11);
    }
}
