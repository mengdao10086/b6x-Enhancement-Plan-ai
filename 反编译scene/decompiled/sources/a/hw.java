package a;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hw extends iz implements ld, Drawable.Callback, by {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f1212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cy f1214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pv f1215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f1217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f1218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint.FontMetrics f1219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PointF f1220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f1221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextUtils.TruncateAt f1223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<a> f1225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f1226a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f1227b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1228b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public pv f1229b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f1230b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f1231b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f1232b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f1233c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f1234c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Path f1235c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public PorterDuffColorFilter f1236c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f1237c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f1238d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ColorStateList f1239d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Paint f1240d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final RectF f1241d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public Drawable f1242d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1243d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f1244e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public ColorStateList f1245e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final Paint f1246e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1247e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f1248f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public ColorStateList f1249f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f1250f;
    public float g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f1251g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public ColorStateList f1252g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f1253g;
    public float h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public int f1254h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public ColorStateList f1255h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f1256h;
    public float i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public int f1257i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public ColorStateList f1258i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f1259i;
    public float j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f1260j;
    public float k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f1261k;
    public float l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f1262l;
    public float m;
    public static final int[] b = {R.attr.state_enabled};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShapeDrawable f6348a = new ShapeDrawable(new OvalShape());

    public interface a {
        void a();
    }

    public hw(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1227b = -1.0f;
        this.f1240d = new Paint(1);
        this.f1219a = new Paint.FontMetrics();
        this.f1241d = new RectF();
        this.f1220a = new PointF();
        this.f1235c = new Path();
        this.f1254h = 255;
        this.f1221a = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.f1225a = new WeakReference<>(null);
        K(context);
        this.f1216a = context;
        cy cyVar = new cy(this);
        this.f1214a = cyVar;
        this.f1224a = "";
        cyVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f1246e = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(b);
        g2(b);
        this.f1261k = true;
        if (wy.f3492a) {
            f6348a.setTint(-1);
        }
    }

    public static boolean i1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean m1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean n1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean o1(qy qyVar) {
        ColorStateList colorStateList;
        return (qyVar == null || (colorStateList = qyVar.f2653a) == null || !colorStateList.isStateful()) ? false : true;
    }

    public static hw s0(Context context, AttributeSet attributeSet, int i, int i2) {
        hw hwVar = new hw(context, attributeSet, i, i2);
        hwVar.p1(attributeSet, i, i2);
        return hwVar;
    }

    public final void A0(Canvas canvas, Rect rect) {
        Paint paint = this.f1246e;
        if (paint != null) {
            paint.setColor(tc.d(-16777216, 127));
            canvas.drawRect(rect, this.f1246e);
            if (I2() || H2()) {
                i0(rect, this.f1241d);
                canvas.drawRect(this.f1241d, this.f1246e);
            }
            if (this.f1224a != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f1246e);
            }
            if (J2()) {
                l0(rect, this.f1241d);
                canvas.drawRect(this.f1241d, this.f1246e);
            }
            this.f1246e.setColor(tc.d(-65536, 127));
            k0(rect, this.f1241d);
            canvas.drawRect(this.f1241d, this.f1246e);
            this.f1246e.setColor(tc.d(-16711936, 127));
            m0(rect, this.f1241d);
            canvas.drawRect(this.f1241d, this.f1246e);
        }
    }

    public void A1(ColorStateList colorStateList) {
        if (this.f1230b != colorStateList) {
            this.f1230b = colorStateList;
            onStateChange(getState());
        }
    }

    public void A2(int i) {
        z2(new qy(this.f1216a, i));
    }

    public final void B0(Canvas canvas, Rect rect) {
        if (this.f1224a != null) {
            Paint.Align alignQ0 = q0(rect, this.f1220a);
            o0(rect, this.f1241d);
            if (this.f1214a.d() != null) {
                this.f1214a.e().drawableState = getState();
                this.f1214a.j(this.f1216a);
            }
            this.f1214a.e().setTextAlign(alignQ0);
            int iSave = 0;
            boolean z = Math.round(this.f1214a.f(c1().toString())) > Math.round(this.f1241d.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.f1241d);
            }
            CharSequence charSequenceEllipsize = this.f1224a;
            if (z && this.f1223a != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f1214a.e(), this.f1241d.width(), this.f1223a);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f1220a;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f1214a.e());
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void B1(int i) {
        A1(r2.c(this.f1216a, i));
    }

    public void B2(float f) {
        if (this.j != f) {
            this.j = f;
            invalidateSelf();
            q1();
        }
    }

    public Drawable C0() {
        return this.f1242d;
    }

    @Deprecated
    public void C1(float f) {
        if (this.f1227b != f) {
            this.f1227b = f;
            setShapeAppearanceModel(B().u(f));
        }
    }

    public void C2(int i) {
        B2(this.f1216a.getResources().getDimension(i));
    }

    public ColorStateList D0() {
        return this.f1252g;
    }

    @Deprecated
    public void D1(int i) {
        C1(this.f1216a.getResources().getDimension(i));
    }

    public void D2(float f) {
        if (this.i != f) {
            this.i = f;
            invalidateSelf();
            q1();
        }
    }

    public ColorStateList E0() {
        return this.f1230b;
    }

    public void E1(float f) {
        if (this.m != f) {
            this.m = f;
            invalidateSelf();
            q1();
        }
    }

    public void E2(int i) {
        D2(this.f1216a.getResources().getDimension(i));
    }

    public float F0() {
        return this.f1262l ? D() : this.f1227b;
    }

    public void F1(int i) {
        E1(this.f1216a.getResources().getDimension(i));
    }

    public void F2(boolean z) {
        if (this.f1260j != z) {
            this.f1260j = z;
            L2();
            onStateChange(getState());
        }
    }

    public float G0() {
        return this.m;
    }

    public void G1(Drawable drawable) {
        Drawable drawableH0 = H0();
        if (drawableH0 != drawable) {
            float fJ0 = j0();
            this.f1222a = drawable != null ? kd.r(drawable).mutate() : null;
            float fJ02 = j0();
            K2(drawableH0);
            if (I2()) {
                h0(this.f1222a);
            }
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    public boolean G2() {
        return this.f1261k;
    }

    public Drawable H0() {
        Drawable drawable = this.f1222a;
        if (drawable != null) {
            return kd.q(drawable);
        }
        return null;
    }

    public void H1(int i) {
        G1(r2.d(this.f1216a, i));
    }

    public final boolean H2() {
        return this.f1256h && this.f1242d != null && this.f1259i;
    }

    public float I0() {
        return this.d;
    }

    public void I1(float f) {
        if (this.d != f) {
            float fJ0 = j0();
            this.d = f;
            float fJ02 = j0();
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    public final boolean I2() {
        return this.f1243d && this.f1222a != null;
    }

    public ColorStateList J0() {
        return this.f1245e;
    }

    public void J1(int i) {
        I1(this.f1216a.getResources().getDimension(i));
    }

    public final boolean J2() {
        return this.f1250f && this.f1231b != null;
    }

    public float K0() {
        return this.f1212a;
    }

    public void K1(ColorStateList colorStateList) {
        this.f1247e = true;
        if (this.f1245e != colorStateList) {
            this.f1245e = colorStateList;
            if (I2()) {
                kd.o(this.f1222a, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public float L0() {
        return this.f;
    }

    public void L1(int i) {
        K1(r2.c(this.f1216a, i));
    }

    public final void L2() {
        this.f1258i = this.f1260j ? wy.d(this.f1239d) : null;
    }

    public ColorStateList M0() {
        return this.f1234c;
    }

    public void M1(int i) {
        N1(this.f1216a.getResources().getBoolean(i));
    }

    @TargetApi(21)
    public final void M2() {
        this.f1237c = new RippleDrawable(wy.d(a1()), this.f1231b, f6348a);
    }

    public float N0() {
        return this.c;
    }

    public void N1(boolean z) {
        if (this.f1243d != z) {
            boolean zI2 = I2();
            this.f1243d = z;
            boolean zI22 = I2();
            if (zI2 != zI22) {
                if (zI22) {
                    h0(this.f1222a);
                } else {
                    K2(this.f1222a);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public Drawable O0() {
        Drawable drawable = this.f1231b;
        if (drawable != null) {
            return kd.q(drawable);
        }
        return null;
    }

    public void O1(float f) {
        if (this.f1212a != f) {
            this.f1212a = f;
            invalidateSelf();
            q1();
        }
    }

    public CharSequence P0() {
        return this.f1232b;
    }

    public void P1(int i) {
        O1(this.f1216a.getResources().getDimension(i));
    }

    public float Q0() {
        return this.l;
    }

    public void Q1(float f) {
        if (this.f != f) {
            this.f = f;
            invalidateSelf();
            q1();
        }
    }

    public float R0() {
        return this.e;
    }

    public void R1(int i) {
        Q1(this.f1216a.getResources().getDimension(i));
    }

    public float S0() {
        return this.k;
    }

    public void S1(ColorStateList colorStateList) {
        if (this.f1234c != colorStateList) {
            this.f1234c = colorStateList;
            if (this.f1262l) {
                c0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public int[] T0() {
        return this.f1226a;
    }

    public void T1(int i) {
        S1(r2.c(this.f1216a, i));
    }

    public ColorStateList U0() {
        return this.f1249f;
    }

    public void U1(float f) {
        if (this.c != f) {
            this.c = f;
            this.f1240d.setStrokeWidth(f);
            if (this.f1262l) {
                super.d0(f);
            }
            invalidateSelf();
        }
    }

    public void V0(RectF rectF) {
        m0(getBounds(), rectF);
    }

    public void V1(int i) {
        U1(this.f1216a.getResources().getDimension(i));
    }

    public TextUtils.TruncateAt W0() {
        return this.f1223a;
    }

    public final void W1(ColorStateList colorStateList) {
        if (this.f1217a != colorStateList) {
            this.f1217a = colorStateList;
            onStateChange(getState());
        }
    }

    public pv X0() {
        return this.f1229b;
    }

    public void X1(Drawable drawable) {
        Drawable drawableO0 = O0();
        if (drawableO0 != drawable) {
            float fN0 = n0();
            this.f1231b = drawable != null ? kd.r(drawable).mutate() : null;
            if (wy.f3492a) {
                M2();
            }
            float fN02 = n0();
            K2(drawableO0);
            if (J2()) {
                h0(this.f1231b);
            }
            invalidateSelf();
            if (fN0 != fN02) {
                q1();
            }
        }
    }

    public float Y0() {
        return this.h;
    }

    public void Y1(CharSequence charSequence) {
        if (this.f1232b != charSequence) {
            this.f1232b = te.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float Z0() {
        return this.g;
    }

    public void Z1(float f) {
        if (this.l != f) {
            this.l = f;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    @Override // a.by
    public void a() {
        q1();
        invalidateSelf();
    }

    public ColorStateList a1() {
        return this.f1239d;
    }

    public void a2(int i) {
        Z1(this.f1216a.getResources().getDimension(i));
    }

    public pv b1() {
        return this.f1215a;
    }

    public void b2(int i) {
        X1(r2.d(this.f1216a, i));
    }

    public CharSequence c1() {
        return this.f1224a;
    }

    public void c2(float f) {
        if (this.e != f) {
            this.e = f;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public qy d1() {
        return this.f1214a.d();
    }

    public void d2(int i) {
        c2(this.f1216a.getResources().getDimension(i));
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.f1254h;
        int iA = i < 255 ? fw.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        x0(canvas, bounds);
        u0(canvas, bounds);
        if (this.f1262l) {
            super.draw(canvas);
        }
        w0(canvas, bounds);
        z0(canvas, bounds);
        v0(canvas, bounds);
        t0(canvas, bounds);
        if (this.f1261k) {
            B0(canvas, bounds);
        }
        y0(canvas, bounds);
        A0(canvas, bounds);
        if (this.f1254h < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public float e1() {
        return this.j;
    }

    public void e2(float f) {
        if (this.k != f) {
            this.k = f;
            invalidateSelf();
            if (J2()) {
                q1();
            }
        }
    }

    public float f1() {
        return this.i;
    }

    public void f2(int i) {
        e2(this.f1216a.getResources().getDimension(i));
    }

    public final ColorFilter g1() {
        ColorFilter colorFilter = this.f1218a;
        return colorFilter != null ? colorFilter : this.f1236c;
    }

    public boolean g2(int[] iArr) {
        if (Arrays.equals(this.f1226a, iArr)) {
            return false;
        }
        this.f1226a = iArr;
        if (J2()) {
            return r1(getState(), iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1254h;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1218a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f1212a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f + j0() + this.i + this.f1214a.f(c1().toString()) + this.j + n0() + this.m), this.f1257i);
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f1262l) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f1227b);
        } else {
            outline.setRoundRect(bounds, this.f1227b);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final void h0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        kd.m(drawable, kd.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f1231b) {
            if (drawable.isStateful()) {
                drawable.setState(T0());
            }
            kd.o(drawable, this.f1249f);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.f1222a;
        if (drawable == drawable2 && this.f1247e) {
            kd.o(drawable2, this.f1245e);
        }
    }

    public boolean h1() {
        return this.f1260j;
    }

    public void h2(ColorStateList colorStateList) {
        if (this.f1249f != colorStateList) {
            this.f1249f = colorStateList;
            if (J2()) {
                kd.o(this.f1231b, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void i0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (I2() || H2()) {
            float f = this.f + this.g;
            if (kd.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + this.d;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - this.d;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.d;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public void i2(int i) {
        h2(r2.c(this.f1216a, i));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m1(this.f1217a) || m1(this.f1230b) || m1(this.f1234c) || (this.f1260j && m1(this.f1258i)) || o1(this.f1214a.d()) || r0() || n1(this.f1222a) || n1(this.f1242d) || m1(this.f1255h);
    }

    public float j0() {
        if (I2() || H2()) {
            return this.g + this.d + this.h;
        }
        return 0.0f;
    }

    public boolean j1() {
        return this.f1253g;
    }

    public void j2(boolean z) {
        if (this.f1250f != z) {
            boolean zJ2 = J2();
            this.f1250f = z;
            boolean zJ22 = J2();
            if (zJ2 != zJ22) {
                if (zJ22) {
                    h0(this.f1231b);
                } else {
                    K2(this.f1231b);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public final void k0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (J2()) {
            float f = this.m + this.l + this.e + this.k + this.j;
            if (kd.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    public boolean k1() {
        return n1(this.f1231b);
    }

    public void k2(a aVar) {
        this.f1225a = new WeakReference<>(aVar);
    }

    public final void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2()) {
            float f = this.m + this.l;
            if (kd.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.e;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.e;
            }
            float fExactCenterY = rect.exactCenterY();
            float f4 = this.e;
            float f5 = fExactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public boolean l1() {
        return this.f1250f;
    }

    public void l2(TextUtils.TruncateAt truncateAt) {
        this.f1223a = truncateAt;
    }

    public final void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2()) {
            float f = this.m + this.l + this.e + this.k + this.j;
            if (kd.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void m2(pv pvVar) {
        this.f1229b = pvVar;
    }

    public float n0() {
        if (J2()) {
            return this.k + this.e + this.l;
        }
        return 0.0f;
    }

    public void n2(int i) {
        m2(pv.c(this.f1216a, i));
    }

    public final void o0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f1224a != null) {
            float fJ0 = this.f + j0() + this.i;
            float fN0 = this.m + n0() + this.j;
            if (kd.f(this) == 0) {
                rectF.left = rect.left + fJ0;
                rectF.right = rect.right - fN0;
            } else {
                rectF.left = rect.left + fN0;
                rectF.right = rect.right - fJ0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void o2(float f) {
        if (this.h != f) {
            float fJ0 = j0();
            this.h = f;
            float fJ02 = j0();
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (I2()) {
            zOnLayoutDirectionChanged |= kd.m(this.f1222a, i);
        }
        if (H2()) {
            zOnLayoutDirectionChanged |= kd.m(this.f1242d, i);
        }
        if (J2()) {
            zOnLayoutDirectionChanged |= kd.m(this.f1231b, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (I2()) {
            zOnLevelChange |= this.f1222a.setLevel(i);
        }
        if (H2()) {
            zOnLevelChange |= this.f1242d.setLevel(i);
        }
        if (J2()) {
            zOnLevelChange |= this.f1231b.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // a.iz, android.graphics.drawable.Drawable, a.by
    public boolean onStateChange(int[] iArr) {
        if (this.f1262l) {
            super.onStateChange(iArr);
        }
        return r1(iArr, T0());
    }

    public final float p0() {
        this.f1214a.e().getFontMetrics(this.f1219a);
        Paint.FontMetrics fontMetrics = this.f1219a;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p1(android.util.AttributeSet r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.hw.p1(android.util.AttributeSet, int, int):void");
    }

    public void p2(int i) {
        o2(this.f1216a.getResources().getDimension(i));
    }

    public Paint.Align q0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f1224a != null) {
            float fJ0 = this.f + j0() + this.i;
            if (kd.f(this) == 0) {
                pointF.x = rect.left + fJ0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fJ0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - p0();
        }
        return align;
    }

    public void q1() {
        a aVar = this.f1225a.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void q2(float f) {
        if (this.g != f) {
            float fJ0 = j0();
            this.g = f;
            float fJ02 = j0();
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    public final boolean r0() {
        return this.f1256h && this.f1242d != null && this.f1253g;
    }

    public final boolean r1(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f1217a;
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, this.f1213a) : 0;
        boolean state = true;
        if (this.f1213a != colorForState) {
            this.f1213a = colorForState;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f1230b;
        int colorForState2 = colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f1228b) : 0;
        if (this.f1228b != colorForState2) {
            this.f1228b = colorForState2;
            zOnStateChange = true;
        }
        int iE = iw.e(colorForState, colorForState2);
        if ((this.f1233c != iE) | (x() == null)) {
            this.f1233c = iE;
            U(ColorStateList.valueOf(iE));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f1234c;
        int colorForState3 = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f1238d) : 0;
        if (this.f1238d != colorForState3) {
            this.f1238d = colorForState3;
            zOnStateChange = true;
        }
        int colorForState4 = (this.f1258i == null || !wy.e(iArr)) ? 0 : this.f1258i.getColorForState(iArr, this.f1244e);
        if (this.f1244e != colorForState4) {
            this.f1244e = colorForState4;
            if (this.f1260j) {
                zOnStateChange = true;
            }
        }
        int colorForState5 = (this.f1214a.d() == null || this.f1214a.d().f2653a == null) ? 0 : this.f1214a.d().f2653a.getColorForState(iArr, this.f1248f);
        if (this.f1248f != colorForState5) {
            this.f1248f = colorForState5;
            zOnStateChange = true;
        }
        boolean z2 = i1(getState(), R.attr.state_checked) && this.f1253g;
        if (this.f1259i == z2 || this.f1242d == null) {
            z = false;
        } else {
            float fJ0 = j0();
            this.f1259i = z2;
            if (fJ0 != j0()) {
                zOnStateChange = true;
                z = true;
            } else {
                z = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f1255h;
        int colorForState6 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f1251g) : 0;
        if (this.f1251g != colorForState6) {
            this.f1251g = colorForState6;
            this.f1236c = rw.a(this, this.f1255h, this.f1221a);
        } else {
            state = zOnStateChange;
        }
        if (n1(this.f1222a)) {
            state |= this.f1222a.setState(iArr);
        }
        if (n1(this.f1242d)) {
            state |= this.f1242d.setState(iArr);
        }
        if (n1(this.f1231b)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f1231b.setState(iArr3);
        }
        if (wy.f3492a && n1(this.f1237c)) {
            state |= this.f1237c.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z) {
            q1();
        }
        return state;
    }

    public void r2(int i) {
        q2(this.f1216a.getResources().getDimension(i));
    }

    public void s1(boolean z) {
        if (this.f1253g != z) {
            this.f1253g = z;
            float fJ0 = j0();
            if (!z && this.f1259i) {
                this.f1259i = false;
            }
            float fJ02 = j0();
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    public void s2(int i) {
        this.f1257i = i;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f1254h != i) {
            this.f1254h = i;
            invalidateSelf();
        }
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f1218a != colorFilter) {
            this.f1218a = colorFilter;
            invalidateSelf();
        }
    }

    @Override // a.iz, android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        if (this.f1255h != colorStateList) {
            this.f1255h = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // a.iz, android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f1221a != mode) {
            this.f1221a = mode;
            this.f1236c = rw.a(this, this.f1255h, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (I2()) {
            visible |= this.f1222a.setVisible(z, z2);
        }
        if (H2()) {
            visible |= this.f1242d.setVisible(z, z2);
        }
        if (J2()) {
            visible |= this.f1231b.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t0(Canvas canvas, Rect rect) {
        if (H2()) {
            i0(rect, this.f1241d);
            RectF rectF = this.f1241d;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f1242d.setBounds(0, 0, (int) this.f1241d.width(), (int) this.f1241d.height());
            this.f1242d.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void t1(int i) {
        s1(this.f1216a.getResources().getBoolean(i));
    }

    public void t2(ColorStateList colorStateList) {
        if (this.f1239d != colorStateList) {
            this.f1239d = colorStateList;
            L2();
            onStateChange(getState());
        }
    }

    public final void u0(Canvas canvas, Rect rect) {
        if (this.f1262l) {
            return;
        }
        this.f1240d.setColor(this.f1228b);
        this.f1240d.setStyle(Paint.Style.FILL);
        this.f1240d.setColorFilter(g1());
        this.f1241d.set(rect);
        canvas.drawRoundRect(this.f1241d, F0(), F0(), this.f1240d);
    }

    public void u1(Drawable drawable) {
        if (this.f1242d != drawable) {
            float fJ0 = j0();
            this.f1242d = drawable;
            float fJ02 = j0();
            K2(this.f1242d);
            h0(this.f1242d);
            invalidateSelf();
            if (fJ0 != fJ02) {
                q1();
            }
        }
    }

    public void u2(int i) {
        t2(r2.c(this.f1216a, i));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v0(Canvas canvas, Rect rect) {
        if (I2()) {
            i0(rect, this.f1241d);
            RectF rectF = this.f1241d;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f1222a.setBounds(0, 0, (int) this.f1241d.width(), (int) this.f1241d.height());
            this.f1222a.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void v1(int i) {
        u1(r2.d(this.f1216a, i));
    }

    public void v2(boolean z) {
        this.f1261k = z;
    }

    public final void w0(Canvas canvas, Rect rect) {
        if (this.c <= 0.0f || this.f1262l) {
            return;
        }
        this.f1240d.setColor(this.f1238d);
        this.f1240d.setStyle(Paint.Style.STROKE);
        if (!this.f1262l) {
            this.f1240d.setColorFilter(g1());
        }
        RectF rectF = this.f1241d;
        float f = rect.left;
        float f2 = this.c;
        rectF.set(f + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.f1227b - (this.c / 2.0f);
        canvas.drawRoundRect(this.f1241d, f3, f3, this.f1240d);
    }

    public void w1(ColorStateList colorStateList) {
        if (this.f1252g != colorStateList) {
            this.f1252g = colorStateList;
            if (r0()) {
                kd.o(this.f1242d, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void w2(pv pvVar) {
        this.f1215a = pvVar;
    }

    public final void x0(Canvas canvas, Rect rect) {
        if (this.f1262l) {
            return;
        }
        this.f1240d.setColor(this.f1213a);
        this.f1240d.setStyle(Paint.Style.FILL);
        this.f1241d.set(rect);
        canvas.drawRoundRect(this.f1241d, F0(), F0(), this.f1240d);
    }

    public void x1(int i) {
        w1(r2.c(this.f1216a, i));
    }

    public void x2(int i) {
        w2(pv.c(this.f1216a, i));
    }

    public final void y0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (J2()) {
            l0(rect, this.f1241d);
            RectF rectF = this.f1241d;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.f1231b.setBounds(0, 0, (int) this.f1241d.width(), (int) this.f1241d.height());
            if (wy.f3492a) {
                this.f1237c.setBounds(this.f1231b.getBounds());
                this.f1237c.jumpToCurrentState();
                drawable = this.f1237c;
            } else {
                drawable = this.f1231b;
            }
            drawable.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    public void y1(int i) {
        z1(this.f1216a.getResources().getBoolean(i));
    }

    public void y2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f1224a, charSequence)) {
            return;
        }
        this.f1224a = charSequence;
        this.f1214a.i(true);
        invalidateSelf();
        q1();
    }

    public final void z0(Canvas canvas, Rect rect) {
        this.f1240d.setColor(this.f1244e);
        this.f1240d.setStyle(Paint.Style.FILL);
        this.f1241d.set(rect);
        if (!this.f1262l) {
            canvas.drawRoundRect(this.f1241d, F0(), F0(), this.f1240d);
        } else {
            h(new RectF(rect), this.f1235c);
            super.p(canvas, this.f1240d, this.f1235c, u());
        }
    }

    public void z1(boolean z) {
        if (this.f1256h != z) {
            boolean zH2 = H2();
            this.f1256h = z;
            boolean zH22 = H2();
            if (zH2 != zH22) {
                if (zH22) {
                    h0(this.f1242d);
                } else {
                    K2(this.f1242d);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public void z2(qy qyVar) {
        this.f1214a.h(qyVar, this.f1216a);
    }
}
