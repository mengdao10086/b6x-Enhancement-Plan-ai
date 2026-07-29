package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20494b = "Theme.AppCompat";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20496d = "Theme.MaterialComponents";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f20493a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f20495c = {R.attr.colorPrimaryVariant};

    public static void a(@n0 Context context) {
        e(context, f20493a, f20494b);
    }

    public static void b(@n0 Context context, AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i10, i11);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z10) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@n0 Context context) {
        e(context, f20495c, f20496d);
    }

    public static void d(@n0 Context context, AttributeSet attributeSet, @e1 @n0 int[] iArr, @g.f int i10, @d1 int i11, @e1 @p0 int... iArr2) {
        boolean zG;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i10, i11);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zG = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zG = g(context, attributeSet, iArr, i10, i11, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zG) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void e(@n0 Context context, @n0 int[] iArr, String str) {
        if (j(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean f(@n0 Context context) {
        return j(context, f20493a);
    }

    public static boolean g(@n0 Context context, AttributeSet attributeSet, @e1 @n0 int[] iArr, @g.f int i10, @d1 int i11, @e1 @n0 int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        for (int i12 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i12, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean h(@n0 Context context) {
        return ie.b.b(context, R.attr.isMaterial3Theme, false);
    }

    public static boolean i(@n0 Context context) {
        return j(context, f20495c);
    }

    public static boolean j(@n0 Context context, @n0 int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    @n0
    public static TypedArray k(@n0 Context context, AttributeSet attributeSet, @e1 @n0 int[] iArr, @g.f int i10, @d1 int i11, @e1 int... iArr2) {
        b(context, attributeSet, i10, i11);
        d(context, attributeSet, iArr, i10, i11, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
    }

    public static y0 l(@n0 Context context, AttributeSet attributeSet, @e1 @n0 int[] iArr, @g.f int i10, @d1 int i11, @e1 int... iArr2) {
        b(context, attributeSet, i10, i11);
        d(context, attributeSet, iArr, i10, i11, iArr2);
        return y0.G(context, attributeSet, iArr, i10, i11);
    }
}
