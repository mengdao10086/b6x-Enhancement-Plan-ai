package a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f6582a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f1608a = {-16842910};
    public static final int[] b = {R.attr.state_focused};
    public static final int[] c = {R.attr.state_pressed};
    public static final int[] d = {R.attr.state_checked};
    public static final int[] e = new int[0];
    public static final int[] f = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c0.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList colorStateListE = e(context, i);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f1608a, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i, typedValueF.getFloat());
    }

    public static int c(Context context, int i) {
        int[] iArr = f;
        iArr[0] = i;
        o8 o8VarU = o8.u(context, null, iArr);
        try {
            return o8VarU.b(0, 0);
        } finally {
            o8VarU.w();
        }
    }

    public static int d(Context context, int i, float f2) {
        return tc.d(c(context, i), Math.round(Color.alpha(r0) * f2));
    }

    public static ColorStateList e(Context context, int i) {
        int[] iArr = f;
        iArr[0] = i;
        o8 o8VarU = o8.u(context, null, iArr);
        try {
            return o8VarU.c(0);
        } finally {
            o8VarU.w();
        }
    }

    public static TypedValue f() {
        TypedValue typedValue = f6582a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f6582a.set(typedValue2);
        return typedValue2;
    }
}
