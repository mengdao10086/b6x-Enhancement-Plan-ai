package g2;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class b0 extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f28939i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f28940j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f28941k = true;

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void e(@n0 View view, @p0 Matrix matrix) {
        if (f28939i) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f28939i = false;
            }
        }
    }

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void i(@n0 View view, @n0 Matrix matrix) {
        if (f28940j) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f28940j = false;
            }
        }
    }

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void j(@n0 View view, @n0 Matrix matrix) {
        if (f28941k) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f28941k = false;
            }
        }
    }
}
