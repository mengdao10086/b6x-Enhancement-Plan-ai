package ku;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import g.l;
import g.n0;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static int a(int i10, int i11) {
        float f10 = 1.0f - (i11 / 255.0f);
        return ((int) (((double) ((i10 & 255) * f10)) + 0.5d)) | (((int) (((double) (((i10 >> 16) & 255) * f10)) + 0.5d)) << 16) | (-16777216) | (((int) (((double) (((i10 >> 8) & 255) * f10)) + 0.5d)) << 8);
    }

    public static void b(@n0 Activity activity) {
        Window window;
        View decorView;
        if (Build.VERSION.SDK_INT < 23 || activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
    }

    public static void c(@n0 Activity activity) {
        Window window;
        View decorView;
        if (Build.VERSION.SDK_INT < 23 || activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
    }

    public static void d(@n0 Activity activity, @l int i10) {
        d.c(activity, i10);
    }

    public static void e(@n0 Activity activity, @l int i10, int i11) {
        d(activity, a(i10, i11));
    }

    public static void f(@n0 Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, @l int i10) {
        d.d(activity, appBarLayout, collapsingToolbarLayout, toolbar, i10);
    }

    public static void g(@n0 Activity activity) {
        h(activity, false);
    }

    public static void h(@n0 Activity activity, boolean z10) {
        d.f(activity, z10);
    }
}
