package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class eq {
    public static int a(RecyclerView.a0 a0Var, wp wpVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.T() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1;
        }
        return Math.min(wpVar.n(), wpVar.d(view2) - wpVar.g(view));
    }

    public static int b(RecyclerView.a0 a0Var, wp wpVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.T() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.m0(view), oVar.m0(view2))) - 1) : Math.max(0, Math.min(oVar.m0(view), oVar.m0(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(wpVar.d(view2) - wpVar.g(view)) / (Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1))) + (wpVar.m() - wpVar.g(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.a0 a0Var, wp wpVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.T() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.b();
        }
        return (int) (((wpVar.d(view2) - wpVar.g(view)) / (Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1)) * a0Var.b());
    }
}
