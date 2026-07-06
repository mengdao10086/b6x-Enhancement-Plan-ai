package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nd extends Drawable implements Drawable.Callback, md, ld {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pd f2075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f2076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f2077a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2078b;
    public boolean c;

    public nd(pd pdVar, Resources resources) {
        this.f2075a = pdVar;
        e(resources);
    }

    public nd(Drawable drawable) {
        this.f2075a = d();
        b(drawable);
    }

    @Override // a.md
    public final Drawable a() {
        return this.f2077a;
    }

    @Override // a.md
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f2077a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2077a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            pd pdVar = this.f2075a;
            if (pdVar != null) {
                pdVar.f2419a = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public boolean c() {
        return true;
    }

    public final pd d() {
        return new pd(this.f2075a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2077a.draw(canvas);
    }

    public final void e(Resources resources) {
        Drawable.ConstantState constantState;
        pd pdVar = this.f2075a;
        if (pdVar == null || (constantState = pdVar.f2419a) == null) {
            return;
        }
        b(constantState.newDrawable(resources));
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        pd pdVar = this.f2075a;
        ColorStateList colorStateList = pdVar.f2417a;
        PorterDuff.Mode mode = pdVar.f2418a;
        if (colorStateList == null || mode == null) {
            this.f2078b = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f2078b || colorForState != this.f6901a || mode != this.f2076a) {
                setColorFilter(colorForState, mode);
                this.f6901a = colorForState;
                this.f2076a = mode;
                this.f2078b = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        pd pdVar = this.f2075a;
        return changingConfigurations | (pdVar != null ? pdVar.getChangingConfigurations() : 0) | this.f2077a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        pd pdVar = this.f2075a;
        if (pdVar == null || !pdVar.a()) {
            return null;
        }
        this.f2075a.f7105a = getChangingConfigurations();
        return this.f2075a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2077a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2077a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2077a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return kd.f(this.f2077a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2077a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2077a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2077a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2077a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2077a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2077a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return kd.h(this.f2077a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        pd pdVar;
        ColorStateList colorStateList = (!c() || (pdVar = this.f2075a) == null) ? null : pdVar.f2417a;
        return (colorStateList != null && colorStateList.isStateful()) || this.f2077a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2077a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.c && super.mutate() == this) {
            this.f2075a = d();
            Drawable drawable = this.f2077a;
            if (drawable != null) {
                drawable.mutate();
            }
            pd pdVar = this.f2075a;
            if (pdVar != null) {
                Drawable drawable2 = this.f2077a;
                pdVar.f2419a = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2077a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return kd.m(this.f2077a, i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f2077a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2077a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        kd.j(this.f2077a, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f2077a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2077a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2077a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2077a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return f(iArr) || this.f2077a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        this.f2075a.f2417a = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2075a.f2418a = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2077a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
