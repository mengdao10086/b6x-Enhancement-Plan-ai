package le;

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
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.d1;
import g.f0;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;
import le.o;
import le.p;
import le.q;

/* JADX INFO: loaded from: classes3.dex */
public class j extends Drawable implements n0.i, s {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final Paint D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f39609x = j.class.getSimpleName();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f39610y = 0.75f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f39611z = 0.25f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f39612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q.j[] f39613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.j[] f39614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f39615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f39616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f39617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f39618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f39619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f39620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f39621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Region f39622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Region f39623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f39624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f39625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f39626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ke.b f39627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final p.b f39628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final p f39629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public PorterDuffColorFilter f39630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public PorterDuffColorFilter f39631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f39632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @n0
    public final RectF f39633v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f39634w;

    public class a implements p.b {
        public a() {
        }

        @Override // le.p.b
        public void a(@n0 q qVar, Matrix matrix, int i10) {
            j.this.f39615d.set(i10, qVar.e());
            j.this.f39613b[i10] = qVar.f(matrix);
        }

        @Override // le.p.b
        public void b(@n0 q qVar, Matrix matrix, int i10) {
            j.this.f39615d.set(i10 + 4, qVar.e());
            j.this.f39614c[i10] = qVar.f(matrix);
        }
    }

    public class b implements o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f39636a;

        public b(float f10) {
            this.f39636a = f10;
        }

        @Override // le.o.c
        @n0
        public le.d a(@n0 le.d dVar) {
            return dVar instanceof m ? dVar : new le.b(this.f39636a, dVar);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    static {
        Paint paint = new Paint(1);
        D = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public /* synthetic */ j(d dVar, a aVar) {
        this(dVar);
    }

    public static int h0(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    @n0
    public static j m(Context context) {
        return n(context, 0.0f);
    }

    @n0
    public static j n(Context context, float f10) {
        int iC = vd.m.c(context, R.attr.colorSurface, j.class.getSimpleName());
        j jVar = new j();
        jVar.Z(context);
        jVar.o0(ColorStateList.valueOf(iC));
        jVar.n0(f10);
        return jVar;
    }

    public Paint.Style A() {
        return this.f39612a.f39659v;
    }

    @Deprecated
    public void A0(int i10) {
        this.f39612a.f39655r = i10;
    }

    public float B() {
        return this.f39612a.f39651n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void B0(int i10) {
        d dVar = this.f39612a;
        if (dVar.f39656s != i10) {
            dVar.f39656s = i10;
            a0();
        }
    }

    @Deprecated
    public void C(int i10, int i11, @n0 Path path) {
        h(new RectF(0.0f, 0.0f, i10, i11), path);
    }

    @Deprecated
    public void C0(@n0 r rVar) {
        setShapeAppearanceModel(rVar);
    }

    @g.l
    public int D() {
        return this.f39632u;
    }

    public void D0(float f10, @g.l int i10) {
        I0(f10);
        F0(ColorStateList.valueOf(i10));
    }

    public float E() {
        return this.f39612a.f39647j;
    }

    public void E0(float f10, @p0 ColorStateList colorStateList) {
        I0(f10);
        F0(colorStateList);
    }

    public int F() {
        return this.f39612a.f39657t;
    }

    public void F0(@p0 ColorStateList colorStateList) {
        d dVar = this.f39612a;
        if (dVar.f39642e != colorStateList) {
            dVar.f39642e = colorStateList;
            onStateChange(getState());
        }
    }

    public int G() {
        return this.f39612a.f39654q;
    }

    public void G0(@g.l int i10) {
        H0(ColorStateList.valueOf(i10));
    }

    @Deprecated
    public int H() {
        return (int) x();
    }

    public void H0(ColorStateList colorStateList) {
        this.f39612a.f39643f = colorStateList;
        N0();
        a0();
    }

    public int I() {
        return (int) (((double) this.f39612a.f39656s) * Math.sin(Math.toRadians(r0.f39657t)));
    }

    public void I0(float f10) {
        this.f39612a.f39649l = f10;
        invalidateSelf();
    }

    public int J() {
        return (int) (((double) this.f39612a.f39656s) * Math.cos(Math.toRadians(r0.f39657t)));
    }

    public void J0(float f10) {
        d dVar = this.f39612a;
        if (dVar.f39653p != f10) {
            dVar.f39653p = f10;
            O0();
        }
    }

    public int K() {
        return this.f39612a.f39655r;
    }

    public void K0(boolean z10) {
        d dVar = this.f39612a;
        if (dVar.f39658u != z10) {
            dVar.f39658u = z10;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int L() {
        return this.f39612a.f39656s;
    }

    public void L0(float f10) {
        J0(f10 - x());
    }

    @p0
    @Deprecated
    public r M() {
        o shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof r) {
            return (r) shapeAppearanceModel;
        }
        return null;
    }

    public final boolean M0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f39612a.f39641d == null || color2 == (colorForState2 = this.f39612a.f39641d.getColorForState(iArr, (color2 = this.f39625n.getColor())))) {
            z10 = false;
        } else {
            this.f39625n.setColor(colorForState2);
            z10 = true;
        }
        if (this.f39612a.f39642e == null || color == (colorForState = this.f39612a.f39642e.getColorForState(iArr, (color = this.f39626o.getColor())))) {
            return z10;
        }
        this.f39626o.setColor(colorForState);
        return true;
    }

    @p0
    public ColorStateList N() {
        return this.f39612a.f39642e;
    }

    public final boolean N0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f39630s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f39631t;
        d dVar = this.f39612a;
        this.f39630s = k(dVar.f39644g, dVar.f39645h, this.f39625n, true);
        d dVar2 = this.f39612a;
        this.f39631t = k(dVar2.f39643f, dVar2.f39645h, this.f39626o, false);
        d dVar3 = this.f39612a;
        if (dVar3.f39658u) {
            this.f39627p.e(dVar3.f39644g.getColorForState(getState(), 0));
        }
        return (androidx.core.util.j.a(porterDuffColorFilter, this.f39630s) && androidx.core.util.j.a(porterDuffColorFilter2, this.f39631t)) ? false : true;
    }

    public final float O() {
        if (Y()) {
            return this.f39626o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final void O0() {
        float fV = V();
        this.f39612a.f39655r = (int) Math.ceil(0.75f * fV);
        this.f39612a.f39656s = (int) Math.ceil(fV * 0.25f);
        N0();
        a0();
    }

    @p0
    public ColorStateList P() {
        return this.f39612a.f39643f;
    }

    public float Q() {
        return this.f39612a.f39649l;
    }

    @p0
    public ColorStateList R() {
        return this.f39612a.f39644g;
    }

    public float S() {
        return this.f39612a.f39638a.r().a(v());
    }

    public float T() {
        return this.f39612a.f39638a.t().a(v());
    }

    public float U() {
        return this.f39612a.f39653p;
    }

    public float V() {
        return x() + U();
    }

    public final boolean W() {
        d dVar = this.f39612a;
        int i10 = dVar.f39654q;
        return i10 != 1 && dVar.f39655r > 0 && (i10 == 2 || j0());
    }

    public final boolean X() {
        Paint.Style style = this.f39612a.f39659v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean Y() {
        Paint.Style style = this.f39612a.f39659v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f39626o.getStrokeWidth() > 0.0f;
    }

    public void Z(Context context) {
        this.f39612a.f39639b = new zd.a(context);
        O0();
    }

    public final void a0() {
        super.invalidateSelf();
    }

    public boolean b0() {
        zd.a aVar = this.f39612a.f39639b;
        return aVar != null && aVar.l();
    }

    public boolean c0() {
        return this.f39612a.f39639b != null;
    }

    public boolean d0(int i10, int i11) {
        return getTransparentRegion().contains(i10, i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        this.f39625n.setColorFilter(this.f39630s);
        int alpha = this.f39625n.getAlpha();
        this.f39625n.setAlpha(h0(alpha, this.f39612a.f39650m));
        this.f39626o.setColorFilter(this.f39631t);
        this.f39626o.setStrokeWidth(this.f39612a.f39649l);
        int alpha2 = this.f39626o.getAlpha();
        this.f39626o.setAlpha(h0(alpha2, this.f39612a.f39650m));
        if (this.f39616e) {
            i();
            g(v(), this.f39618g);
            this.f39616e = false;
        }
        g0(canvas);
        if (X()) {
            p(canvas);
        }
        if (Y()) {
            s(canvas);
        }
        this.f39625n.setAlpha(alpha);
        this.f39626o.setAlpha(alpha2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean e0() {
        return this.f39612a.f39638a.u(v());
    }

    @p0
    public final PorterDuffColorFilter f(@n0 Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f39632u = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    @Deprecated
    public boolean f0() {
        int i10 = this.f39612a.f39654q;
        return i10 == 0 || i10 == 2;
    }

    public final void g(@n0 RectF rectF, @n0 Path path) {
        h(rectF, path);
        if (this.f39612a.f39647j != 1.0f) {
            this.f39617f.reset();
            Matrix matrix = this.f39617f;
            float f10 = this.f39612a.f39647j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f39617f);
        }
        path.computeBounds(this.f39633v, true);
    }

    public final void g0(@n0 Canvas canvas) {
        if (W()) {
            canvas.save();
            i0(canvas);
            if (!this.f39634w) {
                o(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f39633v.width() - getBounds().width());
            int iHeight = (int) (this.f39633v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f39633v.width()) + (this.f39612a.f39655r * 2) + iWidth, ((int) this.f39633v.height()) + (this.f39612a.f39655r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f10 = (getBounds().left - this.f39612a.f39655r) - iWidth;
            float f11 = (getBounds().top - this.f39612a.f39655r) - iHeight;
            canvas2.translate(-f10, -f11);
            o(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f39612a.f39650m;
    }

    @Override // android.graphics.drawable.Drawable
    @p0
    public Drawable.ConstantState getConstantState() {
        return this.f39612a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@n0 Outline outline) {
        if (this.f39612a.f39654q == 2) {
            return;
        }
        if (e0()) {
            outline.setRoundRect(getBounds(), S() * this.f39612a.f39648k);
            return;
        }
        g(v(), this.f39618g);
        if (this.f39618g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f39618g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        Rect rect2 = this.f39612a.f39646i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        return this.f39612a.f39638a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f39622k.set(getBounds());
        g(v(), this.f39618g);
        this.f39623l.setPath(this.f39618g, this.f39622k);
        this.f39622k.op(this.f39623l, Region.Op.DIFFERENCE);
        return this.f39622k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void h(@n0 RectF rectF, @n0 Path path) {
        p pVar = this.f39629r;
        d dVar = this.f39612a;
        pVar.e(dVar.f39638a, dVar.f39648k, rectF, this.f39628q, path);
    }

    public final void i() {
        o oVarY = getShapeAppearanceModel().y(new b(-O()));
        this.f39624m = oVarY;
        this.f39629r.d(oVarY, this.f39612a.f39648k, w(), this.f39619h);
    }

    public final void i0(@n0 Canvas canvas) {
        canvas.translate(I(), J());
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f39616e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f39612a.f39644g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f39612a.f39643f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f39612a.f39642e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f39612a.f39641d) != null && colorStateList4.isStateful())));
    }

    @n0
    public final PorterDuffColorFilter j(@n0 ColorStateList colorStateList, @n0 PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.f39632u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public boolean j0() {
        return (e0() || this.f39618g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @n0
    public final PorterDuffColorFilter k(@p0 ColorStateList colorStateList, @p0 PorterDuff.Mode mode, @n0 Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? f(paint, z10) : j(colorStateList, mode, z10);
    }

    public void k0(float f10) {
        setShapeAppearanceModel(this.f39612a.f39638a.w(f10));
    }

    @g.l
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int l(@g.l int i10) {
        float fV = V() + B();
        zd.a aVar = this.f39612a.f39639b;
        return aVar != null ? aVar.e(i10, fV) : i10;
    }

    public void l0(@n0 le.d dVar) {
        setShapeAppearanceModel(this.f39612a.f39638a.x(dVar));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void m0(boolean z10) {
        this.f39629r.n(z10);
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable mutate() {
        this.f39612a = new d(this.f39612a);
        return this;
    }

    public void n0(float f10) {
        d dVar = this.f39612a;
        if (dVar.f39652o != f10) {
            dVar.f39652o = f10;
            O0();
        }
    }

    public final void o(@n0 Canvas canvas) {
        this.f39615d.cardinality();
        if (this.f39612a.f39656s != 0) {
            canvas.drawPath(this.f39618g, this.f39627p.d());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f39613b[i10].b(this.f39627p, this.f39612a.f39655r, canvas);
            this.f39614c[i10].b(this.f39627p, this.f39612a.f39655r, canvas);
        }
        if (this.f39634w) {
            int I = I();
            int iJ = J();
            canvas.translate(-I, -iJ);
            canvas.drawPath(this.f39618g, D);
            canvas.translate(I, iJ);
        }
    }

    public void o0(@p0 ColorStateList colorStateList) {
        d dVar = this.f39612a;
        if (dVar.f39641d != colorStateList) {
            dVar.f39641d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f39616e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.q.b
    public boolean onStateChange(int[] iArr) {
        boolean z10 = M0(iArr) || N0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public final void p(@n0 Canvas canvas) {
        r(canvas, this.f39625n, this.f39618g, this.f39612a.f39638a, v());
    }

    public void p0(float f10) {
        d dVar = this.f39612a;
        if (dVar.f39648k != f10) {
            dVar.f39648k = f10;
            this.f39616e = true;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void q(@n0 Canvas canvas, @n0 Paint paint, @n0 Path path, @n0 RectF rectF) {
        r(canvas, paint, path, this.f39612a.f39638a, rectF);
    }

    public void q0(int i10, int i11, int i12, int i13) {
        d dVar = this.f39612a;
        if (dVar.f39646i == null) {
            dVar.f39646i = new Rect();
        }
        this.f39612a.f39646i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public final void r(@n0 Canvas canvas, @n0 Paint paint, @n0 Path path, @n0 o oVar, @n0 RectF rectF) {
        if (!oVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = oVar.t().a(rectF) * this.f39612a.f39648k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void r0(Paint.Style style) {
        this.f39612a.f39659v = style;
        a0();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void s(@n0 Canvas canvas) {
        r(canvas, this.f39626o, this.f39619h, this.f39624m, w());
    }

    public void s0(float f10) {
        d dVar = this.f39612a;
        if (dVar.f39651n != f10) {
            dVar.f39651n = f10;
            O0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@f0(from = 0, to = or.a.f44396a) int i10) {
        d dVar = this.f39612a;
        if (dVar.f39650m != i10) {
            dVar.f39650m = i10;
            a0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@p0 ColorFilter colorFilter) {
        this.f39612a.f39640c = colorFilter;
        a0();
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        this.f39612a.f39638a = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(@g.l int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(@p0 ColorStateList colorStateList) {
        this.f39612a.f39644g = colorStateList;
        N0();
        a0();
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@p0 PorterDuff.Mode mode) {
        d dVar = this.f39612a;
        if (dVar.f39645h != mode) {
            dVar.f39645h = mode;
            N0();
            a0();
        }
    }

    public float t() {
        return this.f39612a.f39638a.j().a(v());
    }

    public void t0(float f10) {
        d dVar = this.f39612a;
        if (dVar.f39647j != f10) {
            dVar.f39647j = f10;
            invalidateSelf();
        }
    }

    public float u() {
        return this.f39612a.f39638a.l().a(v());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void u0(boolean z10) {
        this.f39634w = z10;
    }

    @n0
    public RectF v() {
        this.f39620i.set(getBounds());
        return this.f39620i;
    }

    public void v0(int i10) {
        this.f39627p.e(i10);
        this.f39612a.f39658u = false;
        a0();
    }

    @n0
    public final RectF w() {
        this.f39621j.set(v());
        float fO = O();
        this.f39621j.inset(fO, fO);
        return this.f39621j;
    }

    public void w0(int i10) {
        d dVar = this.f39612a;
        if (dVar.f39657t != i10) {
            dVar.f39657t = i10;
            a0();
        }
    }

    public float x() {
        return this.f39612a.f39652o;
    }

    public void x0(int i10) {
        d dVar = this.f39612a;
        if (dVar.f39654q != i10) {
            dVar.f39654q = i10;
            a0();
        }
    }

    @p0
    public ColorStateList y() {
        return this.f39612a.f39641d;
    }

    @Deprecated
    public void y0(int i10) {
        n0(i10);
    }

    public float z() {
        return this.f39612a.f39648k;
    }

    @Deprecated
    public void z0(boolean z10) {
        x0(!z10 ? 1 : 0);
    }

    public j() {
        this(new o());
    }

    public j(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        this(o.e(context, attributeSet, i10, i11).m());
    }

    @Deprecated
    public j(@n0 r rVar) {
        this((o) rVar);
    }

    public j(@n0 o oVar) {
        this(new d(oVar, null));
    }

    public j(@n0 d dVar) {
        p pVar;
        this.f39613b = new q.j[4];
        this.f39614c = new q.j[4];
        this.f39615d = new BitSet(8);
        this.f39617f = new Matrix();
        this.f39618g = new Path();
        this.f39619h = new Path();
        this.f39620i = new RectF();
        this.f39621j = new RectF();
        this.f39622k = new Region();
        this.f39623l = new Region();
        Paint paint = new Paint(1);
        this.f39625n = paint;
        Paint paint2 = new Paint(1);
        this.f39626o = paint2;
        this.f39627p = new ke.b();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = p.k();
        } else {
            pVar = new p();
        }
        this.f39629r = pVar;
        this.f39633v = new RectF();
        this.f39634w = true;
        this.f39612a = dVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        N0();
        M0(getState());
        this.f39628q = new a();
    }

    public static final class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public o f39638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public zd.a f39639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public ColorFilter f39640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public ColorStateList f39641d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public ColorStateList f39642e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public ColorStateList f39643f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public ColorStateList f39644g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public PorterDuff.Mode f39645h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public Rect f39646i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f39647j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f39648k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f39649l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f39650m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f39651n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f39652o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f39653p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f39654q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f39655r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f39656s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f39657t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f39658u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f39659v;

        public d(o oVar, zd.a aVar) {
            this.f39641d = null;
            this.f39642e = null;
            this.f39643f = null;
            this.f39644g = null;
            this.f39645h = PorterDuff.Mode.SRC_IN;
            this.f39646i = null;
            this.f39647j = 1.0f;
            this.f39648k = 1.0f;
            this.f39650m = 255;
            this.f39651n = 0.0f;
            this.f39652o = 0.0f;
            this.f39653p = 0.0f;
            this.f39654q = 0;
            this.f39655r = 0;
            this.f39656s = 0;
            this.f39657t = 0;
            this.f39658u = false;
            this.f39659v = Paint.Style.FILL_AND_STROKE;
            this.f39638a = oVar;
            this.f39639b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            j jVar = new j(this, null);
            jVar.f39616e = true;
            return jVar;
        }

        public d(@n0 d dVar) {
            this.f39641d = null;
            this.f39642e = null;
            this.f39643f = null;
            this.f39644g = null;
            this.f39645h = PorterDuff.Mode.SRC_IN;
            this.f39646i = null;
            this.f39647j = 1.0f;
            this.f39648k = 1.0f;
            this.f39650m = 255;
            this.f39651n = 0.0f;
            this.f39652o = 0.0f;
            this.f39653p = 0.0f;
            this.f39654q = 0;
            this.f39655r = 0;
            this.f39656s = 0;
            this.f39657t = 0;
            this.f39658u = false;
            this.f39659v = Paint.Style.FILL_AND_STROKE;
            this.f39638a = dVar.f39638a;
            this.f39639b = dVar.f39639b;
            this.f39649l = dVar.f39649l;
            this.f39640c = dVar.f39640c;
            this.f39641d = dVar.f39641d;
            this.f39642e = dVar.f39642e;
            this.f39645h = dVar.f39645h;
            this.f39644g = dVar.f39644g;
            this.f39650m = dVar.f39650m;
            this.f39647j = dVar.f39647j;
            this.f39656s = dVar.f39656s;
            this.f39654q = dVar.f39654q;
            this.f39658u = dVar.f39658u;
            this.f39648k = dVar.f39648k;
            this.f39651n = dVar.f39651n;
            this.f39652o = dVar.f39652o;
            this.f39653p = dVar.f39653p;
            this.f39655r = dVar.f39655r;
            this.f39657t = dVar.f39657t;
            this.f39643f = dVar.f39643f;
            this.f39659v = dVar.f39659v;
            if (dVar.f39646i != null) {
                this.f39646i = new Rect(dVar.f39646i);
            }
        }
    }
}
