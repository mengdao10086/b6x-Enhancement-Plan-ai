package g2;

import android.annotation.SuppressLint;
import android.view.View;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public class a0 extends androidx.transition.z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f28935h = true;

    @Override // androidx.transition.z
    public void a(@n0 View view) {
    }

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public float c(@n0 View view) {
        if (f28935h) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f28935h = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.z
    public void d(@n0 View view) {
    }

    @Override // androidx.transition.z
    @SuppressLint({"NewApi"})
    public void g(@n0 View view, float f10) {
        if (f28935h) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f28935h = false;
            }
        }
        view.setAlpha(f10);
    }
}
