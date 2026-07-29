package g2;

import android.annotation.SuppressLint;
import android.view.View;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(22)
public class c0 extends b0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f28943l = true;

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void f(@n0 View view, int i10, int i11, int i12, int i13) {
        if (f28943l) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f28943l = false;
            }
        }
    }
}
