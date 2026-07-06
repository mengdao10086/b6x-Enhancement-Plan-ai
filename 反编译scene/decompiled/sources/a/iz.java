package a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class iz extends Drawable implements ld, a00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6454a = iz.class.getSimpleName();
    public static final Paint c = new Paint(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hz f1447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f1448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pz f1449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rz f1450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xy f1451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f1452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f1453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f1454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuffColorFilter f1455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f1456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Region f1457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BitSet f1458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yz[] f1459a;
    public final Paint b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f1460b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PorterDuffColorFilter f1461b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f1462b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Region f1463b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1464b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final yz[] f1465b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final RectF f1466c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1467c;

    public iz() {
        this(new nz());
    }

    public iz(hz hzVar) {
        this.f1459a = new yz[4];
        this.f1465b = new yz[4];
        this.f1458a = new BitSet(8);
        this.f1452a = new Matrix();
        this.f1454a = new Path();
        this.f1460b = new Path();
        this.f1456a = new RectF();
        this.f1462b = new RectF();
        this.f1457a = new Region();
        this.f1463b = new Region();
        this.f1453a = new Paint(1);
        this.b = new Paint(1);
        this.f1451a = new xy();
        this.f1450a = new rz();
        this.f1466c = new RectF();
        this.f1467c = true;
        this.f1447a = hzVar;
        this.b.setStyle(Paint.Style.STROKE);
        this.f1453a.setStyle(Paint.Style.FILL);
        c.setColor(-1);
        c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f0();
        e0(getState());
        this.f1449a = new fz(this);
    }

    public /* synthetic */ iz(hz hzVar, fz fzVar) {
        this(hzVar);
    }

    public iz(nz nzVar) {
        this(new hz(nzVar, null));
    }

    public iz(Context context, AttributeSet attributeSet, int i, int i2) {
        this(nz.c(context, attributeSet, i, i2).m());
    }

    public static int P(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    public static iz m(Context context, float f) {
        int iB = iw.b(context, zu.colorSurface, iz.class.getSimpleName());
        iz izVar = new iz();
        izVar.K(context);
        izVar.U(ColorStateList.valueOf(iB));
        izVar.T(f);
        return izVar;
    }

    public int A() {
        return (int) (((double) this.f1447a.f1279d) * Math.cos(Math.toRadians(r0.f1281e)));
    }

    public nz B() {
        return this.f1447a.f1267a;
    }

    public final float C() {
        if (J()) {
            return this.b.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float D() {
        return this.f1447a.f1267a.p().a(u());
    }

    public float E() {
        return this.f1447a.f1267a.r().a(u());
    }

    public float F() {
        return this.f1447a.f;
    }

    public float G() {
        return w() + F();
    }

    public final boolean H() {
        hz hzVar = this.f1447a;
        int i = hzVar.f1275b;
        return i != 1 && hzVar.f1277c > 0 && (i == 2 || R());
    }

    public final boolean I() {
        Paint.Style style = this.f1447a.f1271a;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean J() {
        Paint.Style style = this.f1447a.f1271a;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.b.getStrokeWidth() > 0.0f;
    }

    public void K(Context context) {
        this.f1447a.f1268a = new sw(context);
        g0();
    }

    public final void L() {
        super.invalidateSelf();
    }

    public boolean M() {
        sw swVar = this.f1447a.f1268a;
        return swVar != null && swVar.d();
    }

    public boolean N() {
        return this.f1447a.f1267a.s(u());
    }

    public final void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (this.f1467c) {
                int iWidth = (int) (this.f1466c.width() - getBounds().width());
                int iHeight = (int) (this.f1466c.height() - getBounds().height());
                if (iWidth < 0 || iHeight < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f1466c.width()) + (this.f1447a.f1277c * 2) + iWidth, ((int) this.f1466c.height()) + (this.f1447a.f1277c * 2) + iHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f = (getBounds().left - this.f1447a.f1277c) - iWidth;
                float f2 = (getBounds().top - this.f1447a.f1277c) - iHeight;
                canvas2.translate(-f, -f2);
                n(canvas2);
                canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
                bitmapCreateBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    public final void Q(Canvas canvas) {
        int iZ = z();
        int iA = A();
        if (Build.VERSION.SDK_INT < 21 && this.f1467c) {
            Rect clipBounds = canvas.getClipBounds();
            int i = this.f1447a.f1277c;
            clipBounds.inset(-i, -i);
            clipBounds.offset(iZ, iA);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(iZ, iA);
    }

    public boolean R() {
        return Build.VERSION.SDK_INT < 21 || !(N() || this.f1454a.isConvex() || Build.VERSION.SDK_INT >= 29);
    }

    public void S(float f) {
        setShapeAppearanceModel(this.f1447a.f1267a.u(f));
    }

    public void T(float f) {
        hz hzVar = this.f1447a;
        if (hzVar.e != f) {
            hzVar.e = f;
            g0();
        }
    }

    public void U(ColorStateList colorStateList) {
        hz hzVar = this.f1447a;
        if (hzVar.f1269a != colorStateList) {
            hzVar.f1269a = colorStateList;
            onStateChange(getState());
        }
    }

    public void V(float f) {
        hz hzVar = this.f1447a;
        if (hzVar.b != f) {
            hzVar.b = f;
            this.f1464b = true;
            invalidateSelf();
        }
    }

    public void W(int i, int i2, int i3, int i4) {
        hz hzVar = this.f1447a;
        if (hzVar.f1273a == null) {
            hzVar.f1273a = new Rect();
        }
        this.f1447a.f1273a.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void X(float f) {
        hz hzVar = this.f1447a;
        if (hzVar.d != f) {
            hzVar.d = f;
            g0();
        }
    }

    public void Y(int i) {
        this.f1451a.d(i);
        this.f1447a.f1274a = false;
        L();
    }

    public void Z(int i) {
        hz hzVar = this.f1447a;
        if (hzVar.f1281e != i) {
            hzVar.f1281e = i;
            L();
        }
    }

    public void a0(float f, int i) {
        d0(f);
        c0(ColorStateList.valueOf(i));
    }

    public void b0(float f, ColorStateList colorStateList) {
        d0(f);
        c0(colorStateList);
    }

    public void c0(ColorStateList colorStateList) {
        hz hzVar = this.f1447a;
        if (hzVar.f1276b != colorStateList) {
            hzVar.f1276b = colorStateList;
            onStateChange(getState());
        }
    }

    public void d0(float f) {
        this.f1447a.c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1453a.setColorFilter(this.f1455a);
        int alpha = this.f1453a.getAlpha();
        this.f1453a.setAlpha(P(alpha, this.f1447a.f1266a));
        this.b.setColorFilter(this.f1461b);
        this.b.setStrokeWidth(this.f1447a.c);
        int alpha2 = this.b.getAlpha();
        this.b.setAlpha(P(alpha2, this.f1447a.f1266a));
        if (this.f1464b) {
            i();
            g(u(), this.f1454a);
            this.f1464b = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f1453a.setAlpha(alpha);
        this.b.setAlpha(alpha2);
    }

    public final boolean e0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f1447a.f1269a == null || color2 == (colorForState2 = this.f1447a.f1269a.getColorForState(iArr, (color2 = this.f1453a.getColor())))) {
            z = false;
        } else {
            this.f1453a.setColor(colorForState2);
            z = true;
        }
        if (this.f1447a.f1276b == null || color == (colorForState = this.f1447a.f1276b.getColorForState(iArr, (color = this.b.getColor())))) {
            return z;
        }
        this.b.setColor(colorForState);
        return true;
    }

    public final PorterDuffColorFilter f(Paint paint, boolean z) {
        int color;
        int iL;
        if (!z || (iL = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
    }

    public final boolean f0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f1455a;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f1461b;
        hz hzVar = this.f1447a;
        this.f1455a = k(hzVar.f1280d, hzVar.f1272a, this.f1453a, true);
        hz hzVar2 = this.f1447a;
        this.f1461b = k(hzVar2.f1278c, hzVar2.f1272a, this.b, false);
        hz hzVar3 = this.f1447a;
        if (hzVar3.f1274a) {
            this.f1451a.d(hzVar3.f1280d.getColorForState(getState(), 0));
        }
        return (kf.a(porterDuffColorFilter, this.f1455a) && kf.a(porterDuffColorFilter2, this.f1461b)) ? false : true;
    }

    public final void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f1447a.f6356a != 1.0f) {
            this.f1452a.reset();
            Matrix matrix = this.f1452a;
            float f = this.f1447a.f6356a;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f1452a);
        }
        path.computeBounds(this.f1466c, true);
    }

    public final void g0() {
        float fG = G();
        this.f1447a.f1277c = (int) Math.ceil(0.75f * fG);
        this.f1447a.f1279d = (int) Math.ceil(fG * 0.25f);
        f0();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f1447a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f1447a.f1275b == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f1447a.b);
            return;
        }
        g(u(), this.f1454a);
        if (this.f1454a.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f1454a);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f1447a.f1273a;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f1457a.set(getBounds());
        g(u(), this.f1454a);
        this.f1463b.setPath(this.f1454a, this.f1457a);
        this.f1457a.op(this.f1463b, Region.Op.DIFFERENCE);
        return this.f1457a;
    }

    public final void h(RectF rectF, Path path) {
        rz rzVar = this.f1450a;
        hz hzVar = this.f1447a;
        rzVar.e(hzVar.f1267a, hzVar.b, rectF, this.f1449a, path);
    }

    public final void i() {
        nz nzVarV = B().v(new gz(this, -C()));
        this.f1448a = nzVarV;
        this.f1450a.d(nzVarV, this.f1447a.b, v(), this.f1460b);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f1464b = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f1447a.f1280d) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f1447a.f1278c) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f1447a.f1276b) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f1447a.f1269a) != null && colorStateList4.isStateful())));
    }

    public final PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    public final int l(int i) {
        float fG = G() + y();
        sw swVar = this.f1447a.f1268a;
        return swVar != null ? swVar.c(i, fG) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f1447a = new hz(this.f1447a);
        return this;
    }

    public final void n(Canvas canvas) {
        if (this.f1458a.cardinality() > 0) {
            Log.w(f6454a, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f1447a.f1279d != 0) {
            canvas.drawPath(this.f1454a, this.f1451a.c());
        }
        for (int i = 0; i < 4; i++) {
            this.f1459a[i].b(this.f1451a, this.f1447a.f1277c, canvas);
            this.f1465b[i].b(this.f1451a, this.f1447a.f1277c, canvas);
        }
        if (this.f1467c) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f1454a, c);
            canvas.translate(iZ, iA);
        }
    }

    public final void o(Canvas canvas) {
        q(canvas, this.f1453a, this.f1454a, this.f1447a.f1267a, u());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f1464b = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, a.by
    public boolean onStateChange(int[] iArr) {
        boolean z = e0(iArr) || f0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f1447a.f1267a, rectF);
    }

    public final void q(Canvas canvas, Paint paint, Path path, nz nzVar, RectF rectF) {
        if (!nzVar.s(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = nzVar.r().a(rectF) * this.f1447a.b;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public final void r(Canvas canvas) {
        q(canvas, this.b, this.f1460b, this.f1448a, v());
    }

    public float s() {
        return this.f1447a.f1267a.h().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        hz hzVar = this.f1447a;
        if (hzVar.f1266a != i) {
            hzVar.f1266a = i;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1447a.f1270a = colorFilter;
        L();
    }

    @Override // a.a00
    public void setShapeAppearanceModel(nz nzVar) {
        this.f1447a.f1267a = nzVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        this.f1447a.f1280d = colorStateList;
        f0();
        L();
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        hz hzVar = this.f1447a;
        if (hzVar.f1272a != mode) {
            hzVar.f1272a = mode;
            f0();
            L();
        }
    }

    public float t() {
        return this.f1447a.f1267a.j().a(u());
    }

    public RectF u() {
        this.f1456a.set(getBounds());
        return this.f1456a;
    }

    public final RectF v() {
        this.f1462b.set(u());
        float fC = C();
        this.f1462b.inset(fC, fC);
        return this.f1462b;
    }

    public float w() {
        return this.f1447a.e;
    }

    public ColorStateList x() {
        return this.f1447a.f1269a;
    }

    public float y() {
        return this.f1447a.d;
    }

    public int z() {
        return (int) (((double) this.f1447a.f1279d) * Math.sin(Math.toRadians(r0.f1281e)));
    }
}
