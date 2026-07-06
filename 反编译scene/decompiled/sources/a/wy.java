package a;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class wy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final boolean f3492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f3493a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;

    static {
        f3492a = Build.VERSION.SDK_INT >= 21;
        f3493a = new int[]{R.attr.state_pressed};
        b = new int[]{R.attr.state_hovered, R.attr.state_focused};
        c = new int[]{R.attr.state_focused};
        d = new int[]{R.attr.state_hovered};
        e = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        g = new int[]{R.attr.state_selected, R.attr.state_focused};
        h = new int[]{R.attr.state_selected, R.attr.state_hovered};
        i = new int[]{R.attr.state_selected};
        j = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f7833a = wy.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f3492a) {
            return new ColorStateList(new int[][]{i, StateSet.NOTHING}, new int[]{c(colorStateList, e), c(colorStateList, f3493a)});
        }
        int[] iArr = e;
        int[] iArr2 = f;
        int[] iArr3 = g;
        int[] iArr4 = h;
        int[] iArr5 = f3493a;
        int[] iArr6 = b;
        int[] iArr7 = c;
        int[] iArr8 = d;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, i, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    public static int b(int i2) {
        return tc.d(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    public static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f3492a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(j, 0)) != 0) {
            Log.w(f7833a, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
