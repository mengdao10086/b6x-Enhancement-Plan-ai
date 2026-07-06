package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class d3 extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b3 f467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c3 f468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f471a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f472b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f473b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f474b;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5854a = 255;
    public int b = -1;

    public static int f(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    public void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.f474b = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable = this.f470a;
        if (drawable != null) {
            long j = this.f466a;
            if (j == 0) {
                z2 = false;
            } else if (j <= jUptimeMillis) {
                drawable.setAlpha(this.f5854a);
                this.f466a = 0L;
                z2 = false;
            } else {
                drawable.setAlpha(((255 - (((int) ((j - jUptimeMillis) * 255)) / this.f468a.k)) * this.f5854a) / 255);
                z2 = true;
            }
        } else {
            this.f466a = 0L;
            z2 = false;
        }
        Drawable drawable2 = this.f473b;
        if (drawable2 != null) {
            long j2 = this.f472b;
            if (j2 == 0) {
                z3 = z2;
            } else if (j2 <= jUptimeMillis) {
                drawable2.setVisible(false, false);
                this.f473b = null;
                this.f472b = 0L;
                z3 = z2;
            } else {
                drawable2.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.f468a.l) * this.f5854a) / 255);
            }
        } else {
            this.f472b = 0L;
            z3 = z2;
        }
        if (z && z3) {
            scheduleSelf(this.f471a, jUptimeMillis + 16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f468a.b(theme);
    }

    public abstract c3 b();

    public int c() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f468a.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.f467a == null) {
            this.f467a = new b3();
        }
        b3 b3Var = this.f467a;
        b3Var.b(drawable.getCallback());
        drawable.setCallback(b3Var);
        try {
            if (this.f468a.k <= 0 && this.f474b) {
                drawable.setAlpha(this.f5854a);
            }
            if (this.f468a.m) {
                drawable.setColorFilter(this.f468a.f329a);
            } else {
                if (this.f468a.n) {
                    kd.o(drawable, this.f468a.f327a);
                }
                if (this.f468a.o) {
                    kd.p(drawable, this.f468a.f330a);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f468a.f343j);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f468a.f345l);
            }
            Rect rect = this.f469a;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f467a.a());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f470a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f473b;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final boolean e() {
        return isAutoMirrored() && kd.f(this) == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.b
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            a.c3 r0 = r9.f468a
            int r0 = r0.l
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f473b
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f470a
            if (r0 == 0) goto L29
            r9.f473b = r0
            a.c3 r0 = r9.f468a
            int r0 = r0.l
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f472b = r0
            goto L35
        L29:
            r9.f473b = r4
            r9.f472b = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f470a
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            a.c3 r0 = r9.f468a
            int r1 = r0.d
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f470a = r0
            r9.b = r10
            if (r0 == 0) goto L5a
            a.c3 r10 = r9.f468a
            int r10 = r10.k
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f466a = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f470a = r4
            r10 = -1
            r9.b = r10
        L5a:
            long r0 = r9.f466a
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f472b
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L79
        L67:
            java.lang.Runnable r10 = r9.f471a
            if (r10 != 0) goto L73
            a.a3 r10 = new a.a3
            r10.<init>(r9)
            r9.f471a = r10
            goto L76
        L73:
            r9.unscheduleSelf(r10)
        L76:
            r9.a(r0)
        L79:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d3.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5854a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f468a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f468a.c()) {
            return null;
        }
        this.f468a.b = getChangingConfigurations();
        return this.f468a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f470a;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f469a;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f468a.q()) {
            return this.f468a.i();
        }
        Drawable drawable = this.f470a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f468a.q()) {
            return this.f468a.m();
        }
        Drawable drawable = this.f470a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f468a.q()) {
            return this.f468a.j();
        }
        Drawable drawable = this.f470a;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f468a.q()) {
            return this.f468a.k();
        }
        Drawable drawable = this.f470a;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f470a;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f468a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f470a;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f468a.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f470a;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    public void h(c3 c3Var) {
        this.f468a = c3Var;
        int i = this.b;
        if (i >= 0) {
            Drawable drawableG = c3Var.g(i);
            this.f470a = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f473b = null;
    }

    public final void i(Resources resources) {
        this.f468a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        c3 c3Var = this.f468a;
        if (c3Var != null) {
            c3Var.p();
        }
        if (drawable != this.f470a || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f468a.f345l;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f473b;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f473b = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f470a;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f474b) {
                this.f470a.setAlpha(this.f5854a);
            }
        }
        if (this.f472b != 0) {
            this.f472b = 0L;
            z = true;
        }
        if (this.f466a != 0) {
            this.f466a = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.c && super.mutate() == this) {
            c3 c3VarB = b();
            c3VarB.r();
            h(c3VarB);
            this.c = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f473b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f470a;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f468a.w(i, c());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f473b;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f470a;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f470a || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f474b && this.f5854a == i) {
            return;
        }
        this.f474b = true;
        this.f5854a = i;
        Drawable drawable = this.f470a;
        if (drawable != null) {
            if (this.f466a == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        c3 c3Var = this.f468a;
        if (c3Var.f345l != z) {
            c3Var.f345l = z;
            Drawable drawable = this.f470a;
            if (drawable != null) {
                kd.j(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c3 c3Var = this.f468a;
        c3Var.m = true;
        if (c3Var.f329a != colorFilter) {
            c3Var.f329a = colorFilter;
            Drawable drawable = this.f470a;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        c3 c3Var = this.f468a;
        if (c3Var.f343j != z) {
            c3Var.f343j = z;
            Drawable drawable = this.f470a;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f470a;
        if (drawable != null) {
            kd.k(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f469a;
        if (rect == null) {
            this.f469a = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f470a;
        if (drawable != null) {
            kd.l(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        c3 c3Var = this.f468a;
        c3Var.n = true;
        if (c3Var.f327a != colorStateList) {
            c3Var.f327a = colorStateList;
            kd.o(this.f470a, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c3 c3Var = this.f468a;
        c3Var.o = true;
        if (c3Var.f330a != mode) {
            c3Var.f330a = mode;
            kd.p(this.f470a, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f473b;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f470a;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f470a || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
