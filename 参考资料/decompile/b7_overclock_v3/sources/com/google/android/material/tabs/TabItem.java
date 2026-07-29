package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.y0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f20767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f20768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20769c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y0 y0VarF = y0.F(context, attributeSet, R.styleable.TabItem);
        this.f20767a = y0VarF.x(R.styleable.TabItem_android_text);
        this.f20768b = y0VarF.h(R.styleable.TabItem_android_icon);
        this.f20769c = y0VarF.u(R.styleable.TabItem_android_layout, 0);
        y0VarF.I();
    }
}
