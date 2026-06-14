package com.google.android.material.appbar;

import a.eh;
import a.iv;
import a.iz;
import a.jz;
import a.r20;
import a.zu;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final int m = iv.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, m), attributeSet, i);
        P(getContext());
    }

    public final void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            iz izVar = new iz();
            izVar.U(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            izVar.K(context);
            izVar.T(eh.t(this));
            eh.m0(this, izVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        jz.e(this);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        jz.d(this, f);
    }
}
