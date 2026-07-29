package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final a f20111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final a f20112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final a f20113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final a f20114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final a f20115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final a f20116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final a f20117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final Paint f20118h;

    public b(@n0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ie.b.g(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f20111a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f20117g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f20112b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f20113c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = ie.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f20114d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f20115e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f20116f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f20118h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
