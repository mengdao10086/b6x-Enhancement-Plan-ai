package a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final et f8007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Property<View, Float> f3769a;

    static {
        int i = Build.VERSION.SDK_INT;
        f8007a = i >= 29 ? new dt() : i >= 23 ? new ct() : i >= 22 ? new bt() : i >= 21 ? new at() : i >= 19 ? new zs() : new et();
        f3769a = new ws(Float.class, "translationAlpha");
        new xs(Rect.class, "clipBounds");
    }

    public static void a(View view) {
        f8007a.a(view);
    }

    public static vs b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new us(view) : ts.e(view);
    }

    public static float c(View view) {
        return f8007a.c(view);
    }

    public static lt d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new kt(view) : new jt(view.getWindowToken());
    }

    public static void e(View view) {
        f8007a.d(view);
    }

    public static void f(View view, int i, int i2, int i3, int i4) {
        f8007a.e(view, i, i2, i3, i4);
    }

    public static void g(View view, float f) {
        f8007a.f(view, f);
    }

    public static void h(View view, int i) {
        f8007a.g(view, i);
    }

    public static void i(View view, Matrix matrix) {
        f8007a.h(view, matrix);
    }

    public static void j(View view, Matrix matrix) {
        f8007a.i(view, matrix);
    }
}
