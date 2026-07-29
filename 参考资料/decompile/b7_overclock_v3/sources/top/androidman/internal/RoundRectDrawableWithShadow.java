package top.androidman.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import top.androidman.internal.RoundRectDrawableWithShadow;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
@t0({"SMAP\nRoundRectDrawableWithShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoundRectDrawableWithShadow.kt\ntop/androidman/internal/RoundRectDrawableWithShadow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,461:1\n1#2:462\n*E\n"})
public final class RoundRectDrawableWithShadow extends Drawable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f51438t = 1.5f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f51442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final Paint f51443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final Paint f51444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final Paint f51445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final RectF f51446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f51447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public Path f51448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f51449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f51450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f51451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public ColorStateList f51452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f51453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f51454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f51455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f51456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @k
    public static final a f51436r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final double f51437s = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @k
    public static final z<b> f51439u = b0.a(new ik.a<b>() { // from class: top.androidman.internal.RoundRectDrawableWithShadow$Companion$sRoundRectHelper$2

        public static final class a implements RoundRectDrawableWithShadow.b {
            @Override // top.androidman.internal.RoundRectDrawableWithShadow.b
            public void a(@l Canvas canvas, @l RectF rectF, float f10, @k Paint paint) {
                f0.p(paint, "paint");
                f0.m(canvas);
                f0.m(rectF);
                canvas.drawRoundRect(rectF, f10, f10, paint);
            }
        }

        public static final class b implements RoundRectDrawableWithShadow.b {
            @Override // top.androidman.internal.RoundRectDrawableWithShadow.b
            public void a(@l Canvas canvas, @l RectF rectF, float f10, @k Paint paint) {
                f0.p(paint, "paint");
                RectF rectF2 = new RectF();
                float f11 = 2 * f10;
                f0.m(rectF);
                float f12 = 1;
                float fWidth = (rectF.width() - f11) - f12;
                float fHeight = (rectF.height() - f11) - f12;
                if (f10 >= 1.0f) {
                    float f13 = f10 + 0.5f;
                    float f14 = -f13;
                    rectF2.set(f14, f14, f13, f13);
                    f0.m(canvas);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f13, rectF.top + f13);
                    canvas.drawArc(rectF2, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(rectF2, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(rectF2, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(rectF2, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    float f15 = (rectF.left + f13) - 1.0f;
                    float f16 = rectF.top;
                    canvas.drawRect(f15, f16, (rectF.right - f13) + 1.0f, f16 + f13, paint);
                    float f17 = (rectF.left + f13) - 1.0f;
                    float f18 = rectF.bottom;
                    canvas.drawRect(f17, f18 - f13, (rectF.right - f13) + 1.0f, f18, paint);
                }
                f0.m(canvas);
                canvas.drawRect(rectF.left, rectF.top + f10, rectF.right, rectF.bottom - f10, paint);
            }
        }

        @Override // ik.a
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RoundRectDrawableWithShadow.b o() {
            return new a();
        }
    });

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final float c(float f10, float f11, boolean z10) {
            return z10 ? (float) (((double) f10) + ((((double) 1) - RoundRectDrawableWithShadow.f51437s) * ((double) f11))) : f10;
        }

        public final float d(float f10, float f11, boolean z10) {
            return z10 ? (float) (((double) (f10 * 1.5f)) + ((((double) 1) - RoundRectDrawableWithShadow.f51437s) * ((double) f11))) : f10 * 1.5f;
        }

        @k
        public final b e() {
            return (b) RoundRectDrawableWithShadow.f51439u.getValue();
        }
    }

    public interface b {
        void a(@l Canvas canvas, @l RectF rectF, float f10, @k Paint paint);
    }

    public RoundRectDrawableWithShadow(@k ColorStateList backgroundColor, float f10, int i10, int i11, float f11) {
        f0.p(backgroundColor, "backgroundColor");
        this.f51440a = i10;
        this.f51441b = i11;
        this.f51443d = new Paint(5);
        this.f51448i = new Path();
        this.f51453n = true;
        this.f51454o = true;
        this.f51455p = true;
        n(backgroundColor);
        Paint paint = new Paint(5);
        this.f51444e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f51447h = f10 + 0.5f;
        this.f51446g = new RectF();
        Paint paint2 = new Paint(paint);
        this.f51445f = paint2;
        paint2.setAntiAlias(false);
        s(f11, f11);
    }

    public final void c(Rect rect) {
        float f10 = this.f51449j;
        float f11 = 1.5f * f10;
        this.f51446g.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        d();
    }

    public final void d() {
        float f10 = this.f51447h;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f51450k;
        rectF2.inset(-f11, -f11);
        this.f51448i.reset();
        this.f51448i.setFillType(Path.FillType.EVEN_ODD);
        this.f51448i.moveTo(-this.f51447h, 0.0f);
        this.f51448i.rLineTo(-this.f51450k, 0.0f);
        this.f51448i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f51448i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f51448i.close();
        float f12 = this.f51447h;
        float f13 = f12 / (this.f51450k + f12);
        Paint paint = this.f51444e;
        float f14 = this.f51447h + this.f51450k;
        int i10 = this.f51440a;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f51441b}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f51445f;
        float f15 = this.f51447h;
        float f16 = this.f51450k;
        int i11 = this.f51440a;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, (-f15) - f16, new int[]{i11, i11, this.f51441b}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f51445f.setAntiAlias(false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@k Canvas canvas) {
        f0.p(canvas, "canvas");
        if (this.f51453n) {
            Rect bounds = getBounds();
            f0.o(bounds, "bounds");
            c(bounds);
            this.f51453n = false;
        }
        float f10 = 2;
        canvas.translate(0.0f, this.f51451l / f10);
        e(canvas);
        canvas.translate(0.0f, (-this.f51451l) / f10);
        f51436r.e().a(canvas, this.f51446g, this.f51447h, this.f51443d);
    }

    public final void e(Canvas canvas) {
        float f10 = this.f51447h;
        float f11 = (-f10) - this.f51450k;
        int iT = t(f10 + this.f51442c + (this.f51451l / 2));
        float f12 = iT * 2;
        boolean z10 = this.f51446g.width() - f12 > 0.0f;
        boolean z11 = this.f51446g.height() - f12 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f51446g;
        float f13 = iT;
        canvas.translate(rectF.left + f13, rectF.top + f13);
        canvas.drawPath(this.f51448i, this.f51444e);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f51446g.width() - f12, -this.f51447h, this.f51445f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f51446g;
        canvas.translate(rectF2.right - f13, rectF2.bottom - f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f51448i, this.f51444e);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f51446g.width() - f12, (-this.f51447h) + this.f51450k, this.f51445f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f51446g;
        canvas.translate(rectF3.left + f13, rectF3.bottom - f13);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f51448i, this.f51444e);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f51446g.height() - f12, -this.f51447h, this.f51445f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f51446g;
        canvas.translate(rectF4.right - f13, rectF4.top + f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f51448i, this.f51444e);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f51446g.height() - f12, -this.f51447h, this.f51445f);
        }
        canvas.restoreToCount(iSave4);
    }

    @l
    public final ColorStateList f() {
        return this.f51452m;
    }

    public final float g() {
        return this.f51447h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@k Rect padding) {
        f0.p(padding, "padding");
        a aVar = f51436r;
        int iCeil = (int) Math.ceil(aVar.d(this.f51449j, this.f51447h, this.f51454o));
        int iCeil2 = (int) Math.ceil(aVar.c(this.f51449j, this.f51447h, this.f51454o));
        padding.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public final void h(@k Rect into) {
        f0.p(into, "into");
        getPadding(into);
    }

    public final float i() {
        return this.f51449j;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f51452m
            if (r0 == 0) goto Ld
            kotlin.jvm.internal.f0.m(r0)
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L13
        Ld:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L15
        L13:
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.androidman.internal.RoundRectDrawableWithShadow.isStateful():boolean");
    }

    public final float j() {
        float f10 = 2;
        float f11 = this.f51449j;
        return (Math.max(f11, this.f51447h + this.f51442c + ((f11 * 1.5f) / f10)) * f10) + (((this.f51449j * 1.5f) + this.f51442c) * f10);
    }

    public final float k() {
        float f10 = 2;
        float f11 = this.f51449j;
        return (Math.max(f11, this.f51447h + this.f51442c + (f11 / f10)) * f10) + ((this.f51449j + this.f51442c) * f10);
    }

    public final float l() {
        return this.f51451l;
    }

    public final void m(boolean z10) {
        this.f51454o = z10;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f51452m = colorStateList;
        Paint paint = this.f51443d;
        f0.m(colorStateList);
        int[] state = getState();
        ColorStateList colorStateList2 = this.f51452m;
        f0.m(colorStateList2);
        paint.setColor(colorStateList.getColorForState(state, colorStateList2.getDefaultColor()));
    }

    public final void o(@l ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@k Rect bounds) {
        f0.p(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.f51453n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@k int[] stateSet) {
        f0.p(stateSet, "stateSet");
        ColorStateList colorStateList = this.f51452m;
        f0.m(colorStateList);
        ColorStateList colorStateList2 = this.f51452m;
        f0.m(colorStateList2);
        int colorForState = colorStateList.getColorForState(stateSet, colorStateList2.getDefaultColor());
        if (this.f51443d.getColor() == colorForState) {
            return false;
        }
        this.f51443d.setColor(colorForState);
        this.f51453n = true;
        invalidateSelf();
        return true;
    }

    public final void p(float f10) {
        this.f51456q = f10;
        if (!(f10 >= 0.0f)) {
            throw new IllegalArgumentException(("Invalid radius " + this.f51456q + ". Must be >= 0").toString());
        }
        float f11 = f10 + 0.5f;
        this.f51456q = f11;
        if (this.f51447h - f11 == 0.0f) {
            return;
        }
        this.f51447h = f11;
        this.f51453n = true;
        invalidateSelf();
    }

    public final void q(float f10) {
        s(this.f51451l, f10);
    }

    public final void r(float f10) {
        s(f10, this.f51449j);
    }

    public final void s(float f10, float f11) {
        if (!(f10 >= 0.0f)) {
            throw new IllegalArgumentException(("Invalid shadow size " + f10 + ". Must be >= 0").toString());
        }
        if (!(f11 >= 0.0f)) {
            throw new IllegalArgumentException(("Invalid max shadow size " + f11 + ". Must be >= 0").toString());
        }
        float fT = t(f10);
        float fT2 = t(f11);
        if (fT > fT2) {
            if (!this.f51455p) {
                this.f51455p = true;
            }
            fT = fT2;
        }
        if (this.f51451l - fT == 0.0f) {
            if (this.f51449j - fT2 == 0.0f) {
                return;
            }
        }
        this.f51451l = fT;
        this.f51449j = fT2;
        this.f51450k = (fT * 1.5f) + this.f51442c + 0.5f;
        this.f51453n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f51443d.setAlpha(i10);
        this.f51444e.setAlpha(i10);
        this.f51445f.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@l ColorFilter colorFilter) {
        this.f51443d.setColorFilter(colorFilter);
    }

    public final int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }
}
