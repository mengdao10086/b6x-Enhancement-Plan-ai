package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import j0.i;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f2759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f2760c;

    @g.v0(21)
    public static class a {
        @g.u
        public static int a(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @g.u
        public static int b(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    public y0(Context context, TypedArray typedArray) {
        this.f2758a = context;
        this.f2759b = typedArray;
    }

    public static y0 E(Context context, int i10, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static y0 F(Context context, AttributeSet attributeSet, int[] iArr) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static y0 G(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new y0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean A(int i10, TypedValue typedValue) {
        return this.f2759b.getValue(i10, typedValue);
    }

    public TypedArray B() {
        return this.f2759b;
    }

    public boolean C(int i10) {
        return this.f2759b.hasValue(i10);
    }

    public int D() {
        return this.f2759b.length();
    }

    public TypedValue H(int i10) {
        return this.f2759b.peekValue(i10);
    }

    public void I() {
        this.f2759b.recycle();
    }

    public boolean a(int i10, boolean z10) {
        return this.f2759b.getBoolean(i10, z10);
    }

    @g.v0(21)
    public int b() {
        return a.a(this.f2759b);
    }

    public int c(int i10, int i11) {
        return this.f2759b.getColor(i10, i11);
    }

    public ColorStateList d(int i10) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f2759b.hasValue(i10) || (resourceId = this.f2759b.getResourceId(i10, 0)) == 0 || (colorStateListA = i.a.a(this.f2758a, resourceId)) == null) ? this.f2759b.getColorStateList(i10) : colorStateListA;
    }

    public float e(int i10, float f10) {
        return this.f2759b.getDimension(i10, f10);
    }

    public int f(int i10, int i11) {
        return this.f2759b.getDimensionPixelOffset(i10, i11);
    }

    public int g(int i10, int i11) {
        return this.f2759b.getDimensionPixelSize(i10, i11);
    }

    public Drawable h(int i10) {
        int resourceId;
        return (!this.f2759b.hasValue(i10) || (resourceId = this.f2759b.getResourceId(i10, 0)) == 0) ? this.f2759b.getDrawable(i10) : i.a.b(this.f2758a, resourceId);
    }

    public Drawable i(int i10) {
        int resourceId;
        if (!this.f2759b.hasValue(i10) || (resourceId = this.f2759b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return i.b().d(this.f2758a, resourceId, true);
    }

    public float j(int i10, float f10) {
        return this.f2759b.getFloat(i10, f10);
    }

    @g.p0
    public Typeface k(@g.e1 int i10, int i11, @g.p0 i.g gVar) {
        int resourceId = this.f2759b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2760c == null) {
            this.f2760c = new TypedValue();
        }
        return j0.i.k(this.f2758a, resourceId, this.f2760c, i11, gVar);
    }

    public float l(int i10, int i11, int i12, float f10) {
        return this.f2759b.getFraction(i10, i11, i12, f10);
    }

    public int m(int i10) {
        return this.f2759b.getIndex(i10);
    }

    public int n() {
        return this.f2759b.getIndexCount();
    }

    public int o(int i10, int i11) {
        return this.f2759b.getInt(i10, i11);
    }

    public int p(int i10, int i11) {
        return this.f2759b.getInteger(i10, i11);
    }

    public int q(int i10, int i11) {
        return this.f2759b.getLayoutDimension(i10, i11);
    }

    public int r(int i10, String str) {
        return this.f2759b.getLayoutDimension(i10, str);
    }

    public String s(int i10) {
        return this.f2759b.getNonResourceString(i10);
    }

    public String t() {
        return this.f2759b.getPositionDescription();
    }

    public int u(int i10, int i11) {
        return this.f2759b.getResourceId(i10, i11);
    }

    public Resources v() {
        return this.f2759b.getResources();
    }

    public String w(int i10) {
        return this.f2759b.getString(i10);
    }

    public CharSequence x(int i10) {
        return this.f2759b.getText(i10);
    }

    public CharSequence[] y(int i10) {
        return this.f2759b.getTextArray(i10);
    }

    public int z(int i10) {
        return a.b(this.f2759b, i10);
    }
}
