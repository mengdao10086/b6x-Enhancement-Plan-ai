package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2700a = "ThemeUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f2701b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f2702c = {-16842910};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f2703d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f2704e = {R.attr.state_activated};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f2705f = {R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f2706g = {R.attr.state_checked};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f2707h = {R.attr.state_selected};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f2708i = {-16842919, -16842908};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f2709j = new int[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f2710k = new int[1];

    public static void a(@g.n0 View view, @g.n0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("View ");
                sb2.append(view.getClass());
                sb2.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @g.n0
    public static ColorStateList b(int i10, int i11) {
        return new ColorStateList(new int[][]{f2702c, f2709j}, new int[]{i11, i10});
    }

    public static int c(@g.n0 Context context, int i10) {
        ColorStateList colorStateListF = f(context, i10);
        if (colorStateListF != null && colorStateListF.isStateful()) {
            return colorStateListF.getColorForState(f2702c, colorStateListF.getDefaultColor());
        }
        TypedValue typedValueG = g();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueG, true);
        return e(context, i10, typedValueG.getFloat());
    }

    public static int d(@g.n0 Context context, int i10) {
        int[] iArr = f2710k;
        iArr[0] = i10;
        y0 y0VarF = y0.F(context, null, iArr);
        try {
            return y0VarF.c(0, 0);
        } finally {
            y0VarF.I();
        }
    }

    public static int e(@g.n0 Context context, int i10, float f10) {
        return m0.g.B(d(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    @g.p0
    public static ColorStateList f(@g.n0 Context context, int i10) {
        int[] iArr = f2710k;
        iArr[0] = i10;
        y0 y0VarF = y0.F(context, null, iArr);
        try {
            return y0VarF.d(0);
        } finally {
            y0VarF.I();
        }
    }

    public static TypedValue g() {
        ThreadLocal<TypedValue> threadLocal = f2701b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
