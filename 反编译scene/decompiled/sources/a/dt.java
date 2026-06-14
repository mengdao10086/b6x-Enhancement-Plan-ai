package a;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dt extends ct {
    @Override // a.zs, a.et
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // a.bt, a.et
    public void e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // a.zs, a.et
    public void f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // a.ct, a.et
    public void g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // a.at, a.et
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // a.at, a.et
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
