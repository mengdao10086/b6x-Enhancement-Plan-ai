package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TypedArray f2214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TypedValue f2215a;

    public o8(Context context, TypedArray typedArray) {
        this.f6993a = context;
        this.f2214a = typedArray;
    }

    public static o8 t(Context context, int i, int[] iArr) {
        return new o8(context, context.obtainStyledAttributes(i, iArr));
    }

    public static o8 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new o8(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static o8 v(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new o8(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f2214a.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f2214a.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList colorStateListC;
        return (!this.f2214a.hasValue(i) || (resourceId = this.f2214a.getResourceId(i, 0)) == 0 || (colorStateListC = r2.c(this.f6993a, resourceId)) == null) ? this.f2214a.getColorStateList(i) : colorStateListC;
    }

    public float d(int i, float f) {
        return this.f2214a.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f2214a.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f2214a.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f2214a.hasValue(i) || (resourceId = this.f2214a.getResourceId(i, 0)) == 0) ? this.f2214a.getDrawable(i) : r2.d(this.f6993a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        if (!this.f2214a.hasValue(i) || (resourceId = this.f2214a.getResourceId(i, 0)) == 0) {
            return null;
        }
        return v5.b().d(this.f6993a, resourceId, true);
    }

    public float i(int i, float f) {
        return this.f2214a.getFloat(i, f);
    }

    public Typeface j(int i, int i2, nc ncVar) {
        int resourceId = this.f2214a.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2215a == null) {
            this.f2215a = new TypedValue();
        }
        return rc.c(this.f6993a, resourceId, this.f2215a, i2, ncVar);
    }

    public int k(int i, int i2) {
        return this.f2214a.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.f2214a.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.f2214a.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.f2214a.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.f2214a.getString(i);
    }

    public CharSequence p(int i) {
        return this.f2214a.getText(i);
    }

    public CharSequence[] q(int i) {
        return this.f2214a.getTextArray(i);
    }

    public TypedArray r() {
        return this.f2214a;
    }

    public boolean s(int i) {
        return this.f2214a.hasValue(i);
    }

    public void w() {
        this.f2214a.recycle();
    }
}
