package ie;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.y0;
import com.google.android.material.R;
import g.d1;
import g.e1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f32312a = 1.3f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f32313b = 2.0f;

    @p0
    public static ColorStateList a(@n0 Context context, @n0 TypedArray typedArray, @e1 int i10) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateListA = i.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i10) : colorStateListA;
    }

    @p0
    public static ColorStateList b(@n0 Context context, @n0 y0 y0Var, @e1 int i10) {
        int iU;
        ColorStateList colorStateListA;
        return (!y0Var.C(i10) || (iU = y0Var.u(i10, 0)) == 0 || (colorStateListA = i.a.a(context, iU)) == null) ? y0Var.d(i10) : colorStateListA;
    }

    public static int c(TypedValue typedValue) {
        return Build.VERSION.SDK_INT >= 22 ? typedValue.getComplexUnit() : (typedValue.data >> 0) & 15;
    }

    public static int d(@n0 Context context, @n0 TypedArray typedArray, @e1 int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i11);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @p0
    public static Drawable e(@n0 Context context, @n0 TypedArray typedArray, @e1 int i10) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (drawableB = i.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i10) : drawableB;
    }

    @e1
    public static int f(@n0 TypedArray typedArray, @e1 int i10, @e1 int i11) {
        return typedArray.hasValue(i10) ? i10 : i11;
    }

    @p0
    public static d g(@n0 Context context, @n0 TypedArray typedArray, @e1 int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static int h(@n0 Context context, @d1 int i10, int i11) {
        if (i10 == 0) {
            return i11;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.TextAppearance);
        TypedValue typedValue = new TypedValue();
        boolean value = typedArrayObtainStyledAttributes.getValue(R.styleable.TextAppearance_android_textSize, typedValue);
        typedArrayObtainStyledAttributes.recycle();
        return !value ? i11 : c(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean i(@n0 Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean j(@n0 Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
