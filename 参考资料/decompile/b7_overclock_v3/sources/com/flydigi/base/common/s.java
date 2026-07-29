package com.flydigi.base.common;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.flydigi.base.R;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static Drawable a(@n0 Context context, @g.v int i10) {
        return context.getDrawable(i10);
    }

    public static void b(@n0 View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static Drawable c(@n0 Context context, @g.l int i10) {
        return d(a(context, R.drawable.bg_toast), i10);
    }

    public static Drawable d(@n0 Drawable drawable, @g.l int i10) {
        drawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}
