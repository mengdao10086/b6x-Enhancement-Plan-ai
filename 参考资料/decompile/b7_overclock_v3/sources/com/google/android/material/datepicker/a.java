package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.d1;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Rect f20105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f20106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f20107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f20108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final le.o f20110f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, le.o oVar, @n0 Rect rect) {
        androidx.core.util.o.i(rect.left);
        androidx.core.util.o.i(rect.top);
        androidx.core.util.o.i(rect.right);
        androidx.core.util.o.i(rect.bottom);
        this.f20105a = rect;
        this.f20106b = colorStateList2;
        this.f20107c = colorStateList;
        this.f20108d = colorStateList3;
        this.f20109e = i10;
        this.f20110f = oVar;
    }

    @n0
    public static a a(@n0 Context context, @d1 int i10) {
        androidx.core.util.o.b(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        le.o oVarM = le.o.b(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, oVarM, rect);
    }

    public int b() {
        return this.f20105a.bottom;
    }

    public int c() {
        return this.f20105a.left;
    }

    public int d() {
        return this.f20105a.right;
    }

    public int e() {
        return this.f20105a.top;
    }

    public void f(@n0 TextView textView) {
        le.j jVar = new le.j();
        le.j jVar2 = new le.j();
        jVar.setShapeAppearanceModel(this.f20110f);
        jVar2.setShapeAppearanceModel(this.f20110f);
        jVar.o0(this.f20107c);
        jVar.E0(this.f20109e, this.f20108d);
        textView.setTextColor(this.f20106b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f20106b.withAlpha(30), jVar, jVar2);
        Rect rect = this.f20105a;
        u0.I1(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
