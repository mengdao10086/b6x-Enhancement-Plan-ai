package a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class tx extends m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f7542a;
    public final Rect b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f3089b;
    public boolean d;
    public boolean e;
    public int j;

    public tx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7542a = new Rect();
        this.b = new Rect();
        this.j = 119;
        this.d = true;
        this.e = false;
        TypedArray typedArrayH = dy.h(context, attributeSet, jv.ForegroundLinearLayout, i, 0, new int[0]);
        this.j = typedArrayH.getInt(jv.ForegroundLinearLayout_android_foregroundGravity, this.j);
        Drawable drawable = typedArrayH.getDrawable(jv.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.d = typedArrayH.getBoolean(jv.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayH.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f3089b;
        if (drawable != null) {
            if (this.e) {
                this.e = false;
                Rect rect = this.f7542a;
                Rect rect2 = this.b;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.d) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.j, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.f3089b;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3089b;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f3089b.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f3089b;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3089b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // a.m7, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e = z | this.e;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f3089b;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f3089b);
            }
            this.f3089b = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.j == 119) {
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
    public void setForegroundGravity(int i) {
        if (this.j != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.j = i;
            if (i == 119 && this.f3089b != null) {
                this.f3089b.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3089b;
    }
}
