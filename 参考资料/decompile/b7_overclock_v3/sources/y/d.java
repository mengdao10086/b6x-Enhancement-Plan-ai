package y;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ConstraintWidget {
    public ArrayList<ConstraintWidget> A1;

    public d() {
        this.A1 = new ArrayList<>();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void Q1(int i10, int i11) {
        super.Q1(i10, i11);
        int size = this.A1.size();
        for (int i12 = 0; i12 < size; i12++) {
            this.A1.get(i12).Q1(Y(), Z());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void R0() {
        this.A1.clear();
        super.R0();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void W0(androidx.constraintlayout.core.c cVar) {
        super.W0(cVar);
        int size = this.A1.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.A1.get(i10).W0(cVar);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.A1.add(constraintWidget);
        if (constraintWidget.U() != null) {
            ((d) constraintWidget.U()).o2(constraintWidget);
        }
        constraintWidget.S1(this);
    }

    public void k2(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            b(constraintWidget);
        }
    }

    public ArrayList<ConstraintWidget> l2() {
        return this.A1;
    }

    public androidx.constraintlayout.core.widgets.d m2() {
        ConstraintWidget constraintWidgetU = U();
        androidx.constraintlayout.core.widgets.d dVar = this instanceof androidx.constraintlayout.core.widgets.d ? (androidx.constraintlayout.core.widgets.d) this : null;
        while (constraintWidgetU != null) {
            ConstraintWidget constraintWidgetU2 = constraintWidgetU.U();
            if (constraintWidgetU instanceof androidx.constraintlayout.core.widgets.d) {
                dVar = (androidx.constraintlayout.core.widgets.d) constraintWidgetU;
            }
            constraintWidgetU = constraintWidgetU2;
        }
        return dVar;
    }

    public void n2() {
        ArrayList<ConstraintWidget> arrayList = this.A1;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.A1.get(i10);
            if (constraintWidget instanceof d) {
                ((d) constraintWidget).n2();
            }
        }
    }

    public void o2(ConstraintWidget constraintWidget) {
        this.A1.remove(constraintWidget);
        constraintWidget.R0();
    }

    public void p2() {
        this.A1.clear();
    }

    public d(int i10, int i11, int i12, int i13) {
        super(i10, i11, i12, i13);
        this.A1 = new ArrayList<>();
    }

    public d(int i10, int i11) {
        super(i10, i11);
        this.A1 = new ArrayList<>();
    }
}
