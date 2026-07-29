package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3355a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3356b = false;

    public static n a(ConstraintWidget constraintWidget, int i10, ArrayList<n> arrayList, n nVar) {
        int iL2;
        int i11 = i10 == 0 ? constraintWidget.S0 : constraintWidget.T0;
        if (i11 != -1 && (nVar == null || i11 != nVar.f3376b)) {
            int i12 = 0;
            while (true) {
                if (i12 >= arrayList.size()) {
                    break;
                }
                n nVar2 = arrayList.get(i12);
                if (nVar2.f() == i11) {
                    if (nVar != null) {
                        nVar.m(i10, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i12++;
                }
            }
        } else if (i11 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if ((constraintWidget instanceof y.b) && (iL2 = ((y.b) constraintWidget).l2(i10)) != -1) {
                int i13 = 0;
                while (true) {
                    if (i13 >= arrayList.size()) {
                        break;
                    }
                    n nVar3 = arrayList.get(i13);
                    if (nVar3.f() == iL2) {
                        nVar = nVar3;
                        break;
                    }
                    i13++;
                }
            }
            if (nVar == null) {
                nVar = new n(i10);
            }
            arrayList.add(nVar);
        }
        if (nVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.l2().d(fVar.m2() == 0 ? 1 : 0, arrayList, nVar);
            }
            if (i10 == 0) {
                constraintWidget.S0 = nVar.f();
                constraintWidget.Q.d(i10, arrayList, nVar);
                constraintWidget.S.d(i10, arrayList, nVar);
            } else {
                constraintWidget.T0 = nVar.f();
                constraintWidget.R.d(i10, arrayList, nVar);
                constraintWidget.U.d(i10, arrayList, nVar);
                constraintWidget.T.d(i10, arrayList, nVar);
            }
            constraintWidget.X.d(i10, arrayList, nVar);
        }
        return nVar;
    }

    public static n b(ArrayList<n> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            n nVar = arrayList.get(i11);
            if (i10 == nVar.f3376b) {
                return nVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0356  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(androidx.constraintlayout.core.widgets.d r16, androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0036b r17) {
        /*
            Method dump skipped, instruction units count: 935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.h.c(androidx.constraintlayout.core.widgets.d, androidx.constraintlayout.core.widgets.analyzer.b$b):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
