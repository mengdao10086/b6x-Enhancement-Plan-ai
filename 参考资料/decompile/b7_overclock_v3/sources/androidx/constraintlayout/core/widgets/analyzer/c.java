package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<WidgetRun> f3336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3337l;

    public c(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.f3336k = new ArrayList<>();
        this.f3306f = i10;
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(androidx.constraintlayout.core.widgets.analyzer.d r27) {
        /*
            Method dump skipped, instruction units count: 1066
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.a(androidx.constraintlayout.core.widgets.analyzer.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Iterator<WidgetRun> it2 = this.f3336k.iterator();
        while (it2.hasNext()) {
            it2.next().d();
        }
        int size = this.f3336k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f3336k.get(0).f3302b;
        ConstraintWidget constraintWidget2 = this.f3336k.get(size - 1).f3302b;
        if (this.f3306f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.S;
            DependencyNode dependencyNodeI = i(constraintAnchor, 0);
            int iG = constraintAnchor.g();
            ConstraintWidget constraintWidgetV = v();
            if (constraintWidgetV != null) {
                iG = constraintWidgetV.Q.g();
            }
            if (dependencyNodeI != null) {
                b(this.f3308h, dependencyNodeI, iG);
            }
            DependencyNode dependencyNodeI2 = i(constraintAnchor2, 0);
            int iG2 = constraintAnchor2.g();
            ConstraintWidget constraintWidgetW = w();
            if (constraintWidgetW != null) {
                iG2 = constraintWidgetW.S.g();
            }
            if (dependencyNodeI2 != null) {
                b(this.f3309i, dependencyNodeI2, -iG2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.T;
            DependencyNode dependencyNodeI3 = i(constraintAnchor3, 1);
            int iG3 = constraintAnchor3.g();
            ConstraintWidget constraintWidgetV2 = v();
            if (constraintWidgetV2 != null) {
                iG3 = constraintWidgetV2.R.g();
            }
            if (dependencyNodeI3 != null) {
                b(this.f3308h, dependencyNodeI3, iG3);
            }
            DependencyNode dependencyNodeI4 = i(constraintAnchor4, 1);
            int iG4 = constraintAnchor4.g();
            ConstraintWidget constraintWidgetW2 = w();
            if (constraintWidgetW2 != null) {
                iG4 = constraintWidgetW2.T.g();
            }
            if (dependencyNodeI4 != null) {
                b(this.f3309i, dependencyNodeI4, -iG4);
            }
        }
        this.f3308h.f3289a = this;
        this.f3309i.f3289a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i10 = 0; i10 < this.f3336k.size(); i10++) {
            this.f3336k.get(i10).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f3303c = null;
        Iterator<WidgetRun> it2 = this.f3336k.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f3336k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            WidgetRun widgetRun = this.f3336k.get(i10);
            j10 = j10 + ((long) widgetRun.f3308h.f3294f) + widgetRun.j() + ((long) widgetRun.f3309i.f3294f);
        }
        return j10;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void n() {
        this.f3308h.f3298j = false;
        this.f3309i.f3298j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean p() {
        int size = this.f3336k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f3336k.get(i10).p()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f3306f == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.f3336k) {
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }

    public final void u() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f3302b;
        ConstraintWidget constraintWidgetV = constraintWidget2.V(this.f3306f);
        while (true) {
            ConstraintWidget constraintWidget3 = constraintWidgetV;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                constraintWidgetV = constraintWidget2.V(this.f3306f);
            }
        }
        this.f3302b = constraintWidget;
        this.f3336k.add(constraintWidget.a0(this.f3306f));
        ConstraintWidget constraintWidgetR = constraintWidget.R(this.f3306f);
        while (constraintWidgetR != null) {
            this.f3336k.add(constraintWidgetR.a0(this.f3306f));
            constraintWidgetR = constraintWidgetR.R(this.f3306f);
        }
        for (WidgetRun widgetRun : this.f3336k) {
            int i10 = this.f3306f;
            if (i10 == 0) {
                widgetRun.f3302b.f3239c = this;
            } else if (i10 == 1) {
                widgetRun.f3302b.f3241d = this;
            }
        }
        if ((this.f3306f == 0 && ((androidx.constraintlayout.core.widgets.d) this.f3302b.U()).O2()) && this.f3336k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f3336k;
            this.f3302b = arrayList.get(arrayList.size() - 1).f3302b;
        }
        this.f3337l = this.f3306f == 0 ? this.f3302b.G() : this.f3302b.i0();
    }

    public final ConstraintWidget v() {
        for (int i10 = 0; i10 < this.f3336k.size(); i10++) {
            WidgetRun widgetRun = this.f3336k.get(i10);
            if (widgetRun.f3302b.l0() != 8) {
                return widgetRun.f3302b;
            }
        }
        return null;
    }

    public final ConstraintWidget w() {
        for (int size = this.f3336k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f3336k.get(size);
            if (widgetRun.f3302b.l0() != 8) {
                return widgetRun.f3302b;
            }
        }
        return null;
    }
}
