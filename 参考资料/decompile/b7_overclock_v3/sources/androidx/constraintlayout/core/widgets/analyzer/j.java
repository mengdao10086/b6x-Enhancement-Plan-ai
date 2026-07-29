package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class j extends WidgetRun {
    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f3302b;
        int iP2 = aVar.p2();
        Iterator<DependencyNode> it2 = this.f3308h.f3300l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it2.hasNext()) {
            int i12 = it2.next().f3295g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (iP2 == 0 || iP2 == 2) {
            this.f3308h.e(i11 + aVar.q2());
        } else {
            this.f3308h.e(i10 + aVar.q2());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f3302b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.f3308h.f3290b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int iP2 = aVar.p2();
            boolean zO2 = aVar.o2();
            int i10 = 0;
            if (iP2 == 0) {
                this.f3308h.f3293e = DependencyNode.Type.LEFT;
                while (i10 < aVar.B1) {
                    ConstraintWidget constraintWidget2 = aVar.A1[i10];
                    if (zO2 || constraintWidget2.l0() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f3243e.f3308h;
                        dependencyNode.f3299k.add(this.f3308h);
                        this.f3308h.f3300l.add(dependencyNode);
                    }
                    i10++;
                }
                u(this.f3302b.f3243e.f3308h);
                u(this.f3302b.f3243e.f3309i);
                return;
            }
            if (iP2 == 1) {
                this.f3308h.f3293e = DependencyNode.Type.RIGHT;
                while (i10 < aVar.B1) {
                    ConstraintWidget constraintWidget3 = aVar.A1[i10];
                    if (zO2 || constraintWidget3.l0() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f3243e.f3309i;
                        dependencyNode2.f3299k.add(this.f3308h);
                        this.f3308h.f3300l.add(dependencyNode2);
                    }
                    i10++;
                }
                u(this.f3302b.f3243e.f3308h);
                u(this.f3302b.f3243e.f3309i);
                return;
            }
            if (iP2 == 2) {
                this.f3308h.f3293e = DependencyNode.Type.TOP;
                while (i10 < aVar.B1) {
                    ConstraintWidget constraintWidget4 = aVar.A1[i10];
                    if (zO2 || constraintWidget4.l0() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f3245f.f3308h;
                        dependencyNode3.f3299k.add(this.f3308h);
                        this.f3308h.f3300l.add(dependencyNode3);
                    }
                    i10++;
                }
                u(this.f3302b.f3245f.f3308h);
                u(this.f3302b.f3245f.f3309i);
                return;
            }
            if (iP2 != 3) {
                return;
            }
            this.f3308h.f3293e = DependencyNode.Type.BOTTOM;
            while (i10 < aVar.B1) {
                ConstraintWidget constraintWidget5 = aVar.A1[i10];
                if (zO2 || constraintWidget5.l0() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f3245f.f3309i;
                    dependencyNode4.f3299k.add(this.f3308h);
                    this.f3308h.f3300l.add(dependencyNode4);
                }
                i10++;
            }
            u(this.f3302b.f3245f.f3308h);
            u(this.f3302b.f3245f.f3309i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f3302b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int iP2 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).p2();
            if (iP2 == 0 || iP2 == 1) {
                this.f3302b.f2(this.f3308h.f3295g);
            } else {
                this.f3302b.g2(this.f3308h.f3295g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f3303c = null;
        this.f3308h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void n() {
        this.f3308h.f3298j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean p() {
        return false;
    }

    public final void u(DependencyNode dependencyNode) {
        this.f3308h.f3299k.add(dependencyNode);
        dependencyNode.f3300l.add(this.f3308h);
    }
}
