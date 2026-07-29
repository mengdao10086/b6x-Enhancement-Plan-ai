package com.blankj.utilcode.util;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12025a = -16;

    public static class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f12026i = 1140850688;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f12027j = l1.w(8.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f12028a = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f12029b = -1.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f12030c = -1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f12031d = -1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f12032e = -1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12033f = f12026i;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12034g = f12026i;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12035h = false;

        public Drawable a(Drawable drawable) {
            if (drawable == null) {
                drawable = new ColorDrawable(0);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = drawable;
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, new c(drawable2, d(), e(), b(), this.f12034g, this.f12035h));
            stateListDrawable.addState(StateSet.WILD_CARD, new c(drawable2, d(), f(), c(), this.f12033f, this.f12035h));
            return stateListDrawable;
        }

        public final float b() {
            if (this.f12031d == -1.0f) {
                this.f12031d = e();
            }
            return this.f12031d;
        }

        public final float c() {
            if (this.f12032e == -1.0f) {
                this.f12032e = f();
            }
            return this.f12032e;
        }

        public final float d() {
            if (this.f12028a < 0.0f) {
                this.f12028a = 0.0f;
            }
            return this.f12028a;
        }

        public final float e() {
            if (this.f12029b == -1.0f) {
                this.f12029b = f12027j;
            }
            return this.f12029b;
        }

        public final float f() {
            if (this.f12030c == -1.0f) {
                this.f12030c = e();
            }
            return this.f12030c;
        }

        public a g() {
            this.f12035h = true;
            if (this.f12028a == -1.0f) {
                return this;
            }
            throw new IllegalArgumentException("Set circle needn't set radius.");
        }

        public a h(int i10) {
            return i(i10, i10);
        }

        public a i(int i10, int i11) {
            this.f12033f = i10;
            this.f12034g = i11;
            return this;
        }

        public a j(int i10) {
            return k(i10, i10);
        }

        public a k(int i10, int i11) {
            this.f12031d = i10;
            this.f12032e = i11;
            return this;
        }

        public a l(float f10) {
            this.f12028a = f10;
            if (this.f12035h) {
                throw new IllegalArgumentException("Set circle needn't set radius.");
            }
            return this;
        }

        public a m(int i10) {
            return n(i10, i10);
        }

        public a n(int i10, int i11) {
            this.f12029b = i10;
            this.f12030c = i11;
            return this;
        }
    }

    public static class b extends Drawable implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f12036a;

        public b(Drawable drawable) {
            b(drawable);
        }

        public Drawable a() {
            return this.f12036a;
        }

        public void b(Drawable drawable) {
            Drawable drawable2 = this.f12036a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f12036a = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.f12036a.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public int getChangingConfigurations() {
            return this.f12036a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable getCurrent() {
            return this.f12036a.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.f12036a.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.f12036a.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.f12036a.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.f12036a.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.f12036a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return this.f12036a.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public int[] getState() {
            return this.f12036a.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public Region getTransparentRegion() {
            return this.f12036a.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isAutoMirrored() {
            return n0.c.h(this.f12036a);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return this.f12036a.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public void jumpToCurrentState() {
            n0.c.i(this.f12036a);
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            this.f12036a.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean onLevelChange(int i10) {
            return this.f12036a.setLevel(i10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            this.f12036a.setAlpha(i10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAutoMirrored(boolean z10) {
            n0.c.j(this.f12036a, z10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setChangingConfigurations(int i10) {
            this.f12036a.setChangingConfigurations(i10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f12036a.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z10) {
            this.f12036a.setDither(z10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z10) {
            this.f12036a.setFilterBitmap(z10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            n0.c.k(this.f12036a, f10, f11);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            n0.c.l(this.f12036a, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            return this.f12036a.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTint(int i10) {
            n0.c.n(this.f12036a, i10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(ColorStateList colorStateList) {
            n0.c.o(this.f12036a, colorStateList);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintMode(PorterDuff.Mode mode) {
            n0.c.p(this.f12036a, mode);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            return super.setVisible(z10, z11) || this.f12036a.setVisible(z10, z11);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final double f12037u = Math.cos(Math.toRadians(45.0d));

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f12038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f12039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f12040d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f12041e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Paint f12042f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Paint f12043g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public RectF f12044h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f12045i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Path f12046j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f12047k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f12048l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f12049m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f12050n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f12051o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f12052p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f12053q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f12054r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f12055s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f12056t;

        public c(Drawable drawable, float f10, float f11, float f12, int i10, boolean z10) {
            super(drawable);
            this.f12038b = 1.0f;
            this.f12039c = 1.0f;
            this.f12040d = 1.0f;
            this.f12041e = 1.0f;
            this.f12051o = true;
            this.f12054r = false;
            this.f12052p = i10;
            this.f12053q = i10 & 16777215;
            this.f12056t = z10;
            if (z10) {
                this.f12038b = 1.0f;
                this.f12039c = 1.0f;
                this.f12040d = 1.0f;
                this.f12041e = 1.0f;
            }
            Paint paint = new Paint(5);
            this.f12042f = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f12045i = Math.round(f10);
            this.f12044h = new RectF();
            Paint paint2 = new Paint(this.f12042f);
            this.f12043g = paint2;
            paint2.setAntiAlias(false);
            r(f11, f12);
        }

        public static float e(float f10, float f11, boolean z10) {
            return z10 ? (float) (((double) f10) + ((1.0d - f12037u) * ((double) f11))) : f10;
        }

        public static int s(float f10) {
            int iRound = Math.round(f10);
            return iRound % 2 == 1 ? iRound - 1 : iRound;
        }

        @Override // com.blankj.utilcode.util.z0.b
        public /* bridge */ /* synthetic */ Drawable a() {
            return super.a();
        }

        @Override // com.blankj.utilcode.util.z0.b
        public /* bridge */ /* synthetic */ void b(Drawable drawable) {
            super.b(drawable);
        }

        public final void c(Rect rect) {
            if (this.f12056t) {
                this.f12045i = rect.width() / 2;
            }
            float f10 = this.f12048l;
            float f11 = this.f12038b * f10;
            this.f12044h.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
            Drawable drawableA = a();
            RectF rectF = this.f12044h;
            drawableA.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            d();
        }

        public final void d() {
            if (!this.f12056t) {
                float f10 = this.f12045i;
                RectF rectF = new RectF(-f10, -f10, f10, f10);
                RectF rectF2 = new RectF(rectF);
                float f11 = this.f12049m;
                rectF2.inset(-f11, -f11);
                Path path = this.f12046j;
                if (path == null) {
                    this.f12046j = new Path();
                } else {
                    path.reset();
                }
                this.f12046j.setFillType(Path.FillType.EVEN_ODD);
                this.f12046j.moveTo(-this.f12045i, 0.0f);
                this.f12046j.rLineTo(-this.f12049m, 0.0f);
                this.f12046j.arcTo(rectF2, 180.0f, 90.0f, false);
                this.f12046j.arcTo(rectF, 270.0f, -90.0f, false);
                this.f12046j.close();
                float f12 = -rectF2.top;
                if (f12 > 0.0f) {
                    this.f12042f.setShader(new RadialGradient(0.0f, 0.0f, f12, new int[]{0, this.f12052p, this.f12053q}, new float[]{0.0f, this.f12045i / f12, 1.0f}, Shader.TileMode.CLAMP));
                }
                this.f12043g.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, this.f12052p, this.f12053q, Shader.TileMode.CLAMP));
                this.f12043g.setAntiAlias(false);
                return;
            }
            float fWidth = (this.f12044h.width() / 2.0f) - 1.0f;
            float f13 = -fWidth;
            RectF rectF3 = new RectF(f13, f13, fWidth, fWidth);
            RectF rectF4 = new RectF(rectF3);
            float f14 = this.f12049m;
            rectF4.inset(-f14, -f14);
            Path path2 = this.f12046j;
            if (path2 == null) {
                this.f12046j = new Path();
            } else {
                path2.reset();
            }
            this.f12046j.setFillType(Path.FillType.EVEN_ODD);
            this.f12046j.moveTo(f13, 0.0f);
            this.f12046j.rLineTo(-this.f12049m, 0.0f);
            this.f12046j.arcTo(rectF4, 180.0f, 180.0f, false);
            this.f12046j.arcTo(rectF4, 0.0f, 180.0f, false);
            this.f12046j.arcTo(rectF3, 180.0f, 180.0f, false);
            this.f12046j.arcTo(rectF3, 0.0f, 180.0f, false);
            this.f12046j.close();
            float f15 = -rectF4.top;
            if (f15 > 0.0f) {
                this.f12042f.setShader(new RadialGradient(0.0f, 0.0f, f15, new int[]{0, this.f12052p, this.f12053q}, new float[]{0.0f, fWidth / f15, 1.0f}, Shader.TileMode.CLAMP));
            }
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f12051o) {
                c(getBounds());
                this.f12051o = false;
            }
            g(canvas);
            super.draw(canvas);
        }

        public final float f(float f10, float f11, boolean z10) {
            return z10 ? (float) (((double) (f10 * this.f12038b)) + ((1.0d - f12037u) * ((double) f11))) : f10 * this.f12038b;
        }

        public final void g(Canvas canvas) {
            int i10;
            float f10;
            int i11;
            float f11;
            float f12;
            float f13;
            if (this.f12056t) {
                int iSave = canvas.save();
                canvas.translate(this.f12044h.centerX(), this.f12044h.centerY());
                canvas.drawPath(this.f12046j, this.f12042f);
                canvas.restoreToCount(iSave);
                return;
            }
            int iSave2 = canvas.save();
            canvas.rotate(this.f12055s, this.f12044h.centerX(), this.f12044h.centerY());
            float f14 = this.f12045i;
            float f15 = (-f14) - this.f12049m;
            float f16 = f14 * 2.0f;
            boolean z10 = this.f12044h.width() - f16 > 0.0f;
            boolean z11 = this.f12044h.height() - f16 > 0.0f;
            float f17 = this.f12050n;
            float f18 = f17 - (this.f12039c * f17);
            float f19 = f17 - (this.f12040d * f17);
            float f20 = f17 - (this.f12041e * f17);
            float f21 = f14 == 0.0f ? 1.0f : f14 / (f19 + f14);
            float f22 = f14 == 0.0f ? 1.0f : f14 / (f18 + f14);
            float f23 = f14 == 0.0f ? 1.0f : f14 / (f20 + f14);
            int iSave3 = canvas.save();
            RectF rectF = this.f12044h;
            canvas.translate(rectF.left + f14, rectF.top + f14);
            canvas.scale(f21, f22);
            canvas.drawPath(this.f12046j, this.f12042f);
            if (z10) {
                canvas.scale(1.0f / f21, 1.0f);
                i10 = iSave3;
                f10 = f23;
                i11 = iSave2;
                f11 = f22;
                canvas.drawRect(0.0f, f15, this.f12044h.width() - f16, -this.f12045i, this.f12043g);
            } else {
                i10 = iSave3;
                f10 = f23;
                i11 = iSave2;
                f11 = f22;
            }
            canvas.restoreToCount(i10);
            int iSave4 = canvas.save();
            RectF rectF2 = this.f12044h;
            canvas.translate(rectF2.right - f14, rectF2.bottom - f14);
            float f24 = f10;
            canvas.scale(f21, f24);
            canvas.rotate(180.0f);
            canvas.drawPath(this.f12046j, this.f12042f);
            if (z10) {
                canvas.scale(1.0f / f21, 1.0f);
                f12 = f11;
                f13 = f24;
                canvas.drawRect(0.0f, f15, this.f12044h.width() - f16, -this.f12045i, this.f12043g);
            } else {
                f12 = f11;
                f13 = f24;
            }
            canvas.restoreToCount(iSave4);
            int iSave5 = canvas.save();
            RectF rectF3 = this.f12044h;
            canvas.translate(rectF3.left + f14, rectF3.bottom - f14);
            canvas.scale(f21, f13);
            canvas.rotate(270.0f);
            canvas.drawPath(this.f12046j, this.f12042f);
            if (z11) {
                canvas.scale(1.0f / f13, 1.0f);
                canvas.drawRect(0.0f, f15, this.f12044h.height() - f16, -this.f12045i, this.f12043g);
            }
            canvas.restoreToCount(iSave5);
            int iSave6 = canvas.save();
            RectF rectF4 = this.f12044h;
            canvas.translate(rectF4.right - f14, rectF4.top + f14);
            float f25 = f12;
            canvas.scale(f21, f25);
            canvas.rotate(90.0f);
            canvas.drawPath(this.f12046j, this.f12042f);
            if (z11) {
                canvas.scale(1.0f / f25, 1.0f);
                canvas.drawRect(0.0f, f15, this.f12044h.height() - f16, -this.f12045i, this.f12043g);
            }
            canvas.restoreToCount(iSave6);
            canvas.restoreToCount(i11);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getChangingConfigurations() {
            return super.getChangingConfigurations();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Drawable getCurrent() {
            return super.getCurrent();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
            return super.getIntrinsicHeight();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
            return super.getIntrinsicWidth();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumHeight() {
            return super.getMinimumHeight();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumWidth() {
            return super.getMinimumWidth();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            int iCeil = (int) Math.ceil(f(this.f12048l, this.f12045i, this.f12054r));
            int iCeil2 = (int) Math.ceil(e(this.f12048l, this.f12045i, this.f12054r));
            rect.set(iCeil2, iCeil, iCeil2, iCeil);
            return true;
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int[] getState() {
            return super.getState();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Region getTransparentRegion() {
            return super.getTransparentRegion();
        }

        public float h() {
            return this.f12045i;
        }

        public float i() {
            return this.f12048l;
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
            return super.isAutoMirrored();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isStateful() {
            return super.isStateful();
        }

        public float j() {
            float f10 = this.f12048l;
            return (Math.max(f10, this.f12045i + ((this.f12038b * f10) / 2.0f)) * 2.0f) + (this.f12048l * this.f12038b * 2.0f);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void jumpToCurrentState() {
            super.jumpToCurrentState();
        }

        public float k() {
            float f10 = this.f12048l;
            return (Math.max(f10, this.f12045i + (f10 / 2.0f)) * 2.0f) + (this.f12048l * 2.0f);
        }

        public float l() {
            return this.f12050n;
        }

        public void m(boolean z10) {
            this.f12054r = z10;
            invalidateSelf();
        }

        public void n(float f10) {
            float fRound = Math.round(f10);
            if (this.f12045i == fRound) {
                return;
            }
            this.f12045i = fRound;
            this.f12051o = true;
            invalidateSelf();
        }

        public void o(float f10) {
            r(this.f12050n, f10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            this.f12051o = true;
        }

        public final void p(float f10) {
            if (this.f12055s != f10) {
                this.f12055s = f10;
                invalidateSelf();
            }
        }

        public void q(float f10) {
            r(f10, this.f12048l);
        }

        public void r(float f10, float f11) {
            if (f10 < 0.0f || f11 < 0.0f) {
                throw new IllegalArgumentException("invalid shadow size");
            }
            float fS = s(f10);
            float fS2 = s(f11);
            if (fS > fS2) {
                fS = fS2;
            }
            if (this.f12050n == fS && this.f12048l == fS2) {
                return;
            }
            this.f12050n = fS;
            this.f12048l = fS2;
            this.f12049m = Math.round(fS * this.f12038b);
            this.f12047k = fS2;
            this.f12051o = true;
            invalidateSelf();
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            super.scheduleDrawable(drawable, runnable, j10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            super.setAlpha(i10);
            this.f12042f.setAlpha(i10);
            this.f12043g.setAlpha(i10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z10) {
            super.setAutoMirrored(z10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
            super.setChangingConfigurations(i10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setDither(boolean z10) {
            super.setDither(z10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
            super.setFilterBitmap(z10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
            super.setHotspot(f10, f11);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
            super.setHotspotBounds(i10, i11, i12, i13);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
            return super.setState(iArr);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTint(int i10) {
            super.setTint(i10);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
            super.setTintList(colorStateList);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
            super.setTintMode(mode);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
            return super.setVisible(z10, z11);
        }

        @Override // com.blankj.utilcode.util.z0.b, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            super.unscheduleDrawable(drawable, runnable);
        }
    }

    public static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        Drawable background = view.getBackground();
        Object tag = view.getTag(-16);
        if (tag instanceof Drawable) {
            androidx.core.view.u0.I1(view, (Drawable) tag);
            return;
        }
        Drawable drawableA = aVar.a(background);
        androidx.core.view.u0.I1(view, drawableA);
        view.setTag(-16, drawableA);
    }

    public static void b(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            a(view, new a());
        }
    }
}
