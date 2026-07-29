package g2;

import android.graphics.Matrix;
import android.view.View;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(29)
public class e0 extends d0 {
    @Override // g2.a0, androidx.transition.z
    public float c(@n0 View view) {
        return view.getTransitionAlpha();
    }

    @Override // g2.b0, androidx.transition.z
    public void e(@n0 View view, @p0 Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // g2.c0, androidx.transition.z
    public void f(@n0 View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // g2.a0, androidx.transition.z
    public void g(@n0 View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // g2.d0, androidx.transition.z
    public void h(@n0 View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // g2.b0, androidx.transition.z
    public void i(@n0 View view, @n0 Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // g2.b0, androidx.transition.z
    public void j(@n0 View view, @n0 Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
