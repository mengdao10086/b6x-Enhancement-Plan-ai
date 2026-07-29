package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.r;
import le.m;

/* JADX INFO: loaded from: classes7.dex */
public class d extends ConstraintLayout {
    public static final String C2 = "skip";
    public final Runnable C1;
    public int K1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public le.j f21123v2;

    public d(@n0 Context context) {
        this(context, null);
    }

    public static boolean Q(View view) {
        return C2.equals(view.getTag());
    }

    public final Drawable N() {
        le.j jVar = new le.j();
        this.f21123v2 = jVar;
        jVar.l0(new m(0.5f));
        this.f21123v2.o0(ColorStateList.valueOf(-1));
        return this.f21123v2;
    }

    @r
    public int O() {
        return this.K1;
    }

    public void P(@r int i10) {
        this.K1 = i10;
        R();
    }

    public void R() {
        int childCount = getChildCount();
        int i10 = 1;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (Q(getChildAt(i11))) {
                i10++;
            }
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.H(this);
        float f10 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            int i13 = R.id.circle_center;
            if (id2 != i13 && !Q(childAt)) {
                dVar.M(childAt.getId(), i13, this.K1, f10);
                f10 += 360.0f / (childCount - i10);
            }
        }
        dVar.r(this);
    }

    public final void S() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.C1);
            handler.post(this.C1);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(u0.D());
        }
        S();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        R();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        S();
    }

    @Override // android.view.View
    public void setBackgroundColor(@g.l int i10) {
        this.f21123v2.o0(ColorStateList.valueOf(i10));
    }

    public d(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        u0.I1(this, N());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i10, 0);
        this.K1 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.C1 = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f21122a.R();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }
}
