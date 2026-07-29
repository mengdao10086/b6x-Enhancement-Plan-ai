package n0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class k extends Drawable implements Drawable.Callback, j, i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PorterDuff.Mode f41735g = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f41737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f41739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f41741f;

    public k(@n0 m mVar, @p0 Resources resources) {
        this.f41739d = mVar;
        e(resources);
    }

    @Override // n0.j
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f41741f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f41741f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            m mVar = this.f41739d;
            if (mVar != null) {
                mVar.f41745b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // n0.j
    public final Drawable b() {
        return this.f41741f;
    }

    public boolean c() {
        return true;
    }

    @n0
    public final m d() {
        return new m(this.f41739d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        this.f41741f.draw(canvas);
    }

    public final void e(@p0 Resources resources) {
        Drawable.ConstantState constantState;
        m mVar = this.f41739d;
        if (mVar == null || (constantState = mVar.f41745b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    public final boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        m mVar = this.f41739d;
        ColorStateList colorStateList = mVar.f41746c;
        PorterDuff.Mode mode = mVar.f41747d;
        if (colorStateList == null || mode == null) {
            this.f41738c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f41738c || colorForState != this.f41736a || mode != this.f41737b) {
                setColorFilter(colorForState, mode);
                this.f41736a = colorForState;
                this.f41737b = mode;
                this.f41738c = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        m mVar = this.f41739d;
        return changingConfigurations | (mVar != null ? mVar.getChangingConfigurations() : 0) | this.f41741f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @p0
    public Drawable.ConstantState getConstantState() {
        m mVar = this.f41739d;
        if (mVar == null || !mVar.a()) {
            return null;
        }
        this.f41739d.f41744a = getChangingConfigurations();
        return this.f41739d;
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable getCurrent() {
        return this.f41741f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f41741f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f41741f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    @v0(23)
    public int getLayoutDirection() {
        return c.f(this.f41741f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f41741f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f41741f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f41741f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        return this.f41741f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public int[] getState() {
        return this.f41741f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f41741f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@n0 Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @v0(19)
    public boolean isAutoMirrored() {
        return c.h(this.f41741f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        m mVar;
        ColorStateList colorStateList = (!c() || (mVar = this.f41739d) == null) ? null : mVar.f41746c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f41741f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f41741f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable mutate() {
        if (!this.f41740e && super.mutate() == this) {
            this.f41739d = d();
            Drawable drawable = this.f41741f;
            if (drawable != null) {
                drawable.mutate();
            }
            m mVar = this.f41739d;
            if (mVar != null) {
                Drawable drawable2 = this.f41741f;
                mVar.f41745b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f41740e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f41741f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @v0(23)
    public boolean onLayoutDirectionChanged(int i10) {
        return c.m(this.f41741f, i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        return this.f41741f.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f41741f.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    @v0(19)
    public void setAutoMirrored(boolean z10) {
        c.j(this.f41741f, z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f41741f.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f41741f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f41741f.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f41741f.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@n0 int[] iArr) {
        return f(iArr) || this.f41741f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(ColorStateList colorStateList) {
        this.f41739d.f41746c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@n0 PorterDuff.Mode mode) {
        this.f41739d.f41747d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f41741f.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public k(@p0 Drawable drawable) {
        this.f41739d = d();
        a(drawable);
    }
}
