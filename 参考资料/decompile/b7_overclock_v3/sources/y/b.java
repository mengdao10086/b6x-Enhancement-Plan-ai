package y;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.h;
import androidx.constraintlayout.core.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ConstraintWidget implements a {
    public ConstraintWidget[] A1 = new ConstraintWidget[4];
    public int B1 = 0;

    @Override // y.a
    public void a() {
        this.B1 = 0;
        Arrays.fill(this.A1, (Object) null);
    }

    @Override // y.a
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i10 = this.B1 + 1;
        ConstraintWidget[] constraintWidgetArr = this.A1;
        if (i10 > constraintWidgetArr.length) {
            this.A1 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.A1;
        int i11 = this.B1;
        constraintWidgetArr2[i11] = constraintWidget;
        this.B1 = i11 + 1;
    }

    public void c(androidx.constraintlayout.core.widgets.d dVar) {
    }

    public void k2(ArrayList<n> arrayList, int i10, n nVar) {
        for (int i11 = 0; i11 < this.B1; i11++) {
            nVar.a(this.A1[i11]);
        }
        for (int i12 = 0; i12 < this.B1; i12++) {
            h.a(this.A1[i12], i10, arrayList, nVar);
        }
    }

    public int l2(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.B1; i13++) {
            ConstraintWidget constraintWidget = this.A1[i13];
            if (i10 == 0 && (i12 = constraintWidget.S0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.T0) != -1) {
                return i11;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        b bVar = (b) constraintWidget;
        this.B1 = 0;
        int i10 = bVar.B1;
        for (int i11 = 0; i11 < i10; i11++) {
            b(map.get(bVar.A1[i11]));
        }
    }
}
