package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes2.dex */
public class i extends WidgetRun {
    public i(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f3243e.f();
        constraintWidget.f3245f.f();
        this.f3306f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).m2();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        DependencyNode dependencyNode = this.f3308h;
        if (dependencyNode.f3291c && !dependencyNode.f3298j) {
            this.f3308h.e((int) ((dependencyNode.f3300l.get(0).f3295g * ((androidx.constraintlayout.core.widgets.f) this.f3302b).q2()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.f3302b;
        int iN2 = fVar.n2();
        int iP2 = fVar.p2();
        fVar.q2();
        if (fVar.m2() == 1) {
            if (iN2 != -1) {
                this.f3308h.f3300l.add(this.f3302b.f3240c0.f3243e.f3308h);
                this.f3302b.f3240c0.f3243e.f3308h.f3299k.add(this.f3308h);
                this.f3308h.f3294f = iN2;
            } else if (iP2 != -1) {
                this.f3308h.f3300l.add(this.f3302b.f3240c0.f3243e.f3309i);
                this.f3302b.f3240c0.f3243e.f3309i.f3299k.add(this.f3308h);
                this.f3308h.f3294f = -iP2;
            } else {
                DependencyNode dependencyNode = this.f3308h;
                dependencyNode.f3290b = true;
                dependencyNode.f3300l.add(this.f3302b.f3240c0.f3243e.f3309i);
                this.f3302b.f3240c0.f3243e.f3309i.f3299k.add(this.f3308h);
            }
            u(this.f3302b.f3243e.f3308h);
            u(this.f3302b.f3243e.f3309i);
            return;
        }
        if (iN2 != -1) {
            this.f3308h.f3300l.add(this.f3302b.f3240c0.f3245f.f3308h);
            this.f3302b.f3240c0.f3245f.f3308h.f3299k.add(this.f3308h);
            this.f3308h.f3294f = iN2;
        } else if (iP2 != -1) {
            this.f3308h.f3300l.add(this.f3302b.f3240c0.f3245f.f3309i);
            this.f3302b.f3240c0.f3245f.f3309i.f3299k.add(this.f3308h);
            this.f3308h.f3294f = -iP2;
        } else {
            DependencyNode dependencyNode2 = this.f3308h;
            dependencyNode2.f3290b = true;
            dependencyNode2.f3300l.add(this.f3302b.f3240c0.f3245f.f3309i);
            this.f3302b.f3240c0.f3245f.f3309i.f3299k.add(this.f3308h);
        }
        u(this.f3302b.f3245f.f3308h);
        u(this.f3302b.f3245f.f3309i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.core.widgets.f) this.f3302b).m2() == 1) {
            this.f3302b.f2(this.f3308h.f3295g);
        } else {
            this.f3302b.g2(this.f3308h.f3295g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f3308h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void n() {
        this.f3308h.f3298j = false;
        this.f3309i.f3298j = false;
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
