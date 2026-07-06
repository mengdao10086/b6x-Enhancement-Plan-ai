package com.google.android.material.textview;

import a.jv;
import a.my;
import a.ny;
import a.r20;
import a.w6;
import a.zu;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MaterialTextView extends w6 {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        int iH;
        super(r20.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (j(context2, theme, attributeSet, i, i2) || (iH = h(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            f(theme, iH);
        }
    }

    public static boolean g(Context context) {
        return my.b(context, zu.textAppearanceLineHeightEnabled, true);
    }

    public static int h(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, jv.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(jv.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int i(Context context, TypedArray typedArray, int... iArr) {
        int iC = -1;
        for (int i = 0; i < iArr.length && iC < 0; i++) {
            iC = ny.c(context, typedArray, iArr[i], -1);
        }
        return iC;
    }

    public static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, jv.MaterialTextView, i, i2);
        int i3 = i(context, typedArrayObtainStyledAttributes, jv.MaterialTextView_android_lineHeight, jv.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return i3 != -1;
    }

    public final void f(Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, jv.MaterialTextAppearance);
        int i2 = i(getContext(), typedArrayObtainStyledAttributes, jv.MaterialTextAppearance_android_lineHeight, jv.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (i2 >= 0) {
            setLineHeight(i2);
        }
    }

    @Override // a.w6, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (g(context)) {
            f(context.getTheme(), i);
        }
    }
}
