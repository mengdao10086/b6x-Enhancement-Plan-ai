package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.t0;
import h0.d;
import ie.c;
import le.j;
import pe.a;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20166f = R.style.Widget_MaterialComponents_MaterialDivider;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final j f20167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public int f20169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20171e;

    public MaterialDivider(@n0 Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f20169c;
    }

    @t0
    public int getDividerInsetEnd() {
        return this.f20171e;
    }

    @t0
    public int getDividerInsetStart() {
        return this.f20170d;
    }

    public int getDividerThickness() {
        return this.f20168b;
    }

    @Override // android.view.View
    public void onDraw(@n0 Canvas canvas) {
        int width;
        int i10;
        super.onDraw(canvas);
        boolean z10 = u0.Z(this) == 1;
        int i11 = z10 ? this.f20171e : this.f20170d;
        if (z10) {
            width = getWidth();
            i10 = this.f20170d;
        } else {
            width = getWidth();
            i10 = this.f20171e;
        }
        this.f20167a.setBounds(i11, 0, width - i10, getBottom() - getTop());
        this.f20167a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f20168b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@l int i10) {
        if (this.f20169c != i10) {
            this.f20169c = i10;
            this.f20167a.o0(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(@n int i10) {
        setDividerColor(d.f(getContext(), i10));
    }

    public void setDividerInsetEnd(@t0 int i10) {
        this.f20171e = i10;
    }

    public void setDividerInsetEndResource(@q int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(@t0 int i10) {
        this.f20170d = i10;
    }

    public void setDividerInsetStartResource(@q int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(@t0 int i10) {
        if (this.f20168b != i10) {
            this.f20168b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@q int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    public MaterialDivider(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f20166f;
        super(a.c(context, attributeSet, i10, i11), attributeSet, i10);
        Context context2 = getContext();
        this.f20167a = new j();
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.MaterialDivider, i10, i11, new int[0]);
        this.f20168b = typedArrayK.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.f20170d = typedArrayK.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.f20171e = typedArrayK.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(c.a(context2, typedArrayK, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayK.recycle();
    }
}
