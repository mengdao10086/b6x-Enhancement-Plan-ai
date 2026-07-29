package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class c extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f1811a;

    public c(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.f1811a;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.f1811a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1811a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1811a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f1811a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1811a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1811a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1811a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1811a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1811a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1811a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1811a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1811a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1811a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return n0.c.h(this.f1811a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1811a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1811a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f1811a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        return this.f1811a.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1811a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        n0.c.j(this.f1811a, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f1811a.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1811a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f1811a.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f1811a.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        n0.c.k(this.f1811a, f10, f11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        n0.c.l(this.f1811a, i10, i11, i12, i13);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f1811a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        n0.c.n(this.f1811a, i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        n0.c.o(this.f1811a, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        n0.c.p(this.f1811a, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f1811a.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
