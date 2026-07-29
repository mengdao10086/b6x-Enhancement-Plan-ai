package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.i0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class h extends i0 {

    @p0
    public Drawable B;
    public final Rect C;
    public final Rect D;
    public boolean K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f20419k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f20420k1;

    public h(@n0 Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.B;
        if (drawable != null) {
            if (this.f20420k1) {
                this.f20420k1 = false;
                Rect rect = this.C;
                Rect rect2 = this.D;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.K0) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f20419k0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    @v0(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.B;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.B.setState(getDrawableState());
    }

    @Override // android.view.View
    @p0
    public Drawable getForeground() {
        return this.B;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f20419k0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f20420k1 = z10 | this.f20420k1;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f20420k1 = true;
    }

    @Override // android.view.View
    public void setForeground(@p0 Drawable drawable) {
        Drawable drawable2 = this.B;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.B);
            }
            this.B = drawable;
            this.f20420k1 = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f20419k0 == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f20419k0 != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= androidx.core.view.m.f5025b;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f20419k0 = i10;
            if (i10 == 119 && this.B != null) {
                this.B.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }

    public h(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.C = new Rect();
        this.D = new Rect();
        this.f20419k0 = 119;
        this.K0 = true;
        this.f20420k1 = false;
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.ForegroundLinearLayout, i10, 0, new int[0]);
        this.f20419k0 = typedArrayK.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f20419k0);
        Drawable drawable = typedArrayK.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.K0 = typedArrayK.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayK.recycle();
    }
}
