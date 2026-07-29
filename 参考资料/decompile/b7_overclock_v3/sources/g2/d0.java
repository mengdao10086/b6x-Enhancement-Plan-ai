package g2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(23)
public class d0 extends c0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f28945m = true;

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void h(@n0 View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i10);
        } else if (f28945m) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f28945m = false;
            }
        }
    }
}
