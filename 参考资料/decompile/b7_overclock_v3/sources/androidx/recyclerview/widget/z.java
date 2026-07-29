package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static int a(RecyclerView.b0 b0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.Y() == 0 || b0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(oVar.u0(view) - oVar.u0(view2)) + 1;
        }
        return Math.min(wVar.o(), wVar.d(view2) - wVar.g(view));
    }

    public static int b(RecyclerView.b0 b0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        if (oVar.Y() == 0 || b0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z11 ? Math.max(0, (b0Var.d() - Math.max(oVar.u0(view), oVar.u0(view2))) - 1) : Math.max(0, Math.min(oVar.u0(view), oVar.u0(view2)));
        if (z10) {
            return Math.round((iMax * (Math.abs(wVar.d(view2) - wVar.g(view)) / (Math.abs(oVar.u0(view) - oVar.u0(view2)) + 1))) + (wVar.n() - wVar.g(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.b0 b0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.Y() == 0 || b0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return b0Var.d();
        }
        return (int) (((wVar.d(view2) - wVar.g(view)) / (Math.abs(oVar.u0(view) - oVar.u0(view2)) + 1)) * b0Var.d());
    }
}
