package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.core.view.u0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.b0;
import g.n0;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class t {
    public static void a(@n0 TextInputLayout textInputLayout, @n0 CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = n0.c.r(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                n0.c.o(drawable, colorStateList);
            } else {
                n0.c.o(drawable, ColorStateList.valueOf(colorStateList.getColorForState(b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                n0.c.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static int[] b(@n0 TextInputLayout textInputLayout, @n0 CheckableImageButton checkableImageButton) {
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    public static void c(@n0 TextInputLayout textInputLayout, @n0 CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(b(textInputLayout, checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = n0.c.r(drawable).mutate();
        n0.c.o(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void d(@n0 CheckableImageButton checkableImageButton) {
        if (Build.VERSION.SDK_INT <= 22) {
            checkableImageButton.setBackground(je.b.b(checkableImageButton.getContext(), (int) b0.e(checkableImageButton.getContext(), 4)));
        }
    }

    public static void e(@n0 CheckableImageButton checkableImageButton, @p0 View.OnLongClickListener onLongClickListener) {
        boolean zK0 = u0.K0(checkableImageButton);
        boolean z10 = onLongClickListener != null;
        boolean z11 = zK0 || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(zK0);
        checkableImageButton.setPressable(zK0);
        checkableImageButton.setLongClickable(z10);
        u0.R1(checkableImageButton, z11 ? 1 : 2);
    }

    public static void f(@n0 CheckableImageButton checkableImageButton, @p0 View.OnClickListener onClickListener, @p0 View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        e(checkableImageButton, onLongClickListener);
    }

    public static void g(@n0 CheckableImageButton checkableImageButton, @p0 View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        e(checkableImageButton, onLongClickListener);
    }
}
