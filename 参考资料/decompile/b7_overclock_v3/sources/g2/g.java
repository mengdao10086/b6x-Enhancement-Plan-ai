package g2;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    @p0
    public static e a(@n0 View view, @n0 ViewGroup viewGroup, @p0 Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? f.b(view, viewGroup, matrix) : androidx.transition.l.b(view, viewGroup, matrix);
    }

    public static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            f.f(view);
        } else {
            androidx.transition.l.f(view);
        }
    }
}
