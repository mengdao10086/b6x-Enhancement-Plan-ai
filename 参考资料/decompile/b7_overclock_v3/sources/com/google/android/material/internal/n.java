package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class n extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public Drawable f20471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f20472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f20473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20475e;

    public class a implements k0 {
        public a() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, @n0 j1 j1Var) {
            n nVar = n.this;
            if (nVar.f20472b == null) {
                nVar.f20472b = new Rect();
            }
            n.this.f20472b.set(j1Var.p(), j1Var.r(), j1Var.q(), j1Var.o());
            n.this.a(j1Var);
            n.this.setWillNotDraw(!j1Var.w() || n.this.f20471a == null);
            u0.n1(n.this);
            return j1Var.c();
        }
    }

    public n(@n0 Context context) {
        this(context, null);
    }

    public void a(j1 j1Var) {
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f20472b == null || this.f20471a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f20474d) {
            this.f20473c.set(0, 0, width, this.f20472b.top);
            this.f20471a.setBounds(this.f20473c);
            this.f20471a.draw(canvas);
        }
        if (this.f20475e) {
            this.f20473c.set(0, height - this.f20472b.bottom, width, height);
            this.f20471a.setBounds(this.f20473c);
            this.f20471a.draw(canvas);
        }
        Rect rect = this.f20473c;
        Rect rect2 = this.f20472b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f20471a.setBounds(this.f20473c);
        this.f20471a.draw(canvas);
        Rect rect3 = this.f20473c;
        Rect rect4 = this.f20472b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f20471a.setBounds(this.f20473c);
        this.f20471a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f20471a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f20471a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f20475e = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f20474d = z10;
    }

    public void setScrimInsetForeground(@p0 Drawable drawable) {
        this.f20471a = drawable;
    }

    public n(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20473c = new Rect();
        this.f20474d = true;
        this.f20475e = true;
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i10, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f20471a = typedArrayK.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayK.recycle();
        setWillNotDraw(true);
        u0.a2(this, new a());
    }
}
