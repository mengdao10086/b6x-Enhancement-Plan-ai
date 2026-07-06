package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ny {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int color;
        int resourceId;
        ColorStateList colorStateListC;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListC = r2.c(context, resourceId)) == null) ? (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i, -1)) == -1) ? typedArray.getColorStateList(i) : ColorStateList.valueOf(color) : colorStateListC;
    }

    public static ColorStateList b(Context context, o8 o8Var, int i) {
        int iB;
        int iN;
        ColorStateList colorStateListC;
        return (!o8Var.s(i) || (iN = o8Var.n(i, 0)) == 0 || (colorStateListC = r2.c(context, iN)) == null) ? (Build.VERSION.SDK_INT > 15 || (iB = o8Var.b(i, -1)) == -1) ? o8Var.c(i) : ColorStateList.valueOf(iB) : colorStateListC;
    }

    public static int c(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableD;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableD = r2.d(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableD;
    }

    public static int e(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    public static qy f(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new qy(context, resourceId);
    }
}
