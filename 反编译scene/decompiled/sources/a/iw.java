package a;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class iw {
    public static int a(Context context, int i, int i2) {
        TypedValue typedValueA = my.a(context, i);
        return typedValueA != null ? typedValueA.data : i2;
    }

    public static int b(Context context, int i, String str) {
        return my.c(context, i, str);
    }

    public static int c(View view, int i) {
        return my.d(view, i);
    }

    public static int d(View view, int i, int i2) {
        return a(view.getContext(), i, i2);
    }

    public static int e(int i, int i2) {
        return tc.b(i2, i);
    }

    public static int f(int i, int i2, float f) {
        return e(i, tc.d(i2, Math.round(Color.alpha(i2) * f)));
    }

    public static int g(View view, int i, int i2, float f) {
        return f(c(view, i), c(view, i2), f);
    }
}
