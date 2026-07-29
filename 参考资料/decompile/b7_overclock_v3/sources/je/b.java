package je;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.StateSet;
import androidx.annotation.RestrictTo;
import g.i1;
import g.k;
import g.l;
import g.n0;
import g.p0;
import g.t0;
import g.u;
import g.v0;
import m0.g;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k(api = 21)
    public static final boolean f36351a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f36352b = {R.attr.state_pressed};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f36353c = {R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f36354d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f36355e = {R.attr.state_hovered};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f36356f = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f36357g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f36358h = {R.attr.state_selected, R.attr.state_focused};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f36359i = {R.attr.state_selected, R.attr.state_hovered};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f36360j = {R.attr.state_selected};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f36361k = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @i1
    public static final String f36362l = b.class.getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @i1
    public static final String f36363m = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    @v0(21)
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        @u
        public static Drawable b(@n0 Context context, @t0 int i10) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(m.i(context, com.google.android.material.R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i10, i10, i10, i10));
        }
    }

    @n0
    public static ColorStateList a(@p0 ColorStateList colorStateList) {
        if (f36351a) {
            int[] iArr = f36354d;
            return new ColorStateList(new int[][]{f36360j, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f36356f), d(colorStateList, iArr), d(colorStateList, f36352b)});
        }
        int[] iArr2 = f36356f;
        int[] iArr3 = f36357g;
        int[] iArr4 = f36358h;
        int[] iArr5 = f36359i;
        int[] iArr6 = f36352b;
        int[] iArr7 = f36353c;
        int[] iArr8 = f36354d;
        int[] iArr9 = f36355e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f36360j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{d(colorStateList, iArr2), d(colorStateList, iArr3), d(colorStateList, iArr4), d(colorStateList, iArr5), 0, d(colorStateList, iArr6), d(colorStateList, iArr7), d(colorStateList, iArr8), d(colorStateList, iArr9), 0});
    }

    @n0
    @v0(21)
    public static Drawable b(@n0 Context context, @t0 int i10) {
        return a.b(context, i10);
    }

    @l
    @TargetApi(21)
    public static int c(@l int i10) {
        return g.B(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    @l
    public static int d(@p0 ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f36351a ? c(colorForState) : colorForState;
    }

    @n0
    public static ColorStateList e(@p0 ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 22 && i10 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(f36361k, 0));
        }
        return colorStateList;
    }

    public static boolean f(@n0 int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
