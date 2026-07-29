package it.sephiroth.android.library.imagezoom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ImageViewTouchBase extends ImageView implements pj.a {
    public static final String A = "ImageViewTouchBase";
    public static final boolean B = false;
    public static final float C = -1.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f35892z = "1.0.4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nj.e f35893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f35894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f35895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Matrix f35896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f35897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f35898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f35899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f35900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f35901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f35903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f35904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f35905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f35906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f35907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f35908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DisplayType f35909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f35910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f35911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f35912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RectF f35913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public RectF f35914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f35915w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f35916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f35917y;

    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f35918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Matrix f35919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f35920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f35921d;

        public a(Drawable drawable, Matrix matrix, float f10, float f11) {
            this.f35918a = drawable;
            this.f35919b = matrix;
            this.f35920c = f10;
            this.f35921d = f11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.E(this.f35918a, this.f35919b, this.f35920c, this.f35921d);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f35923a = 0.0d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f35924b = 0.0d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ double f35925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f35926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ double f35927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ double f35928f;

        public b(double d10, long j10, double d11, double d12) {
            this.f35925c = d10;
            this.f35926d = j10;
            this.f35927e = d11;
            this.f35928f = d12;
        }

        @Override // java.lang.Runnable
        public void run() {
            double dMin = Math.min(this.f35925c, System.currentTimeMillis() - this.f35926d);
            double dB = ImageViewTouchBase.this.f35893a.b(dMin, 0.0d, this.f35927e, this.f35925c);
            double dB2 = ImageViewTouchBase.this.f35893a.b(dMin, 0.0d, this.f35928f, this.f35925c);
            ImageViewTouchBase.this.v(dB - this.f35923a, dB2 - this.f35924b);
            this.f35923a = dB;
            this.f35924b = dB2;
            if (dMin < this.f35925c) {
                ImageViewTouchBase.this.f35897e.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            RectF rectFI = imageViewTouchBase.i(imageViewTouchBase.f35895c, true, true);
            float f10 = rectFI.left;
            if (f10 == 0.0f && rectFI.top == 0.0f) {
                return;
            }
            ImageViewTouchBase.this.B(f10, rectFI.top);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f35930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f35931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f35932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f35933d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f35934e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f35935f;

        public c(float f10, long j10, float f11, float f12, float f13, float f14) {
            this.f35930a = f10;
            this.f35931b = j10;
            this.f35932c = f11;
            this.f35933d = f12;
            this.f35934e = f13;
            this.f35935f = f14;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(this.f35930a, System.currentTimeMillis() - this.f35931b);
            ImageViewTouchBase.this.I(this.f35933d + ((float) ImageViewTouchBase.this.f35893a.a(fMin, 0.0d, this.f35932c, this.f35930a)), this.f35934e, this.f35935f);
            if (fMin < this.f35930a) {
                ImageViewTouchBase.this.f35897e.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            imageViewTouchBase.u(imageViewTouchBase.getScale());
            ImageViewTouchBase.this.b(true, true);
        }
    }

    public interface d {
        void a(Drawable drawable);
    }

    public interface e {
        void a(boolean z10, int i10, int i11, int i12, int i13);
    }

    public ImageViewTouchBase(Context context) {
        this(context, null);
    }

    public void A() {
        this.f35895c = new Matrix();
        float fJ = j(this.f35909q);
        setImageMatrix(getImageViewMatrix());
        if (fJ != getScale()) {
            G(fJ);
        }
        postInvalidate();
    }

    public void B(float f10, float f11) {
        v(f10, f11);
    }

    public void C(float f10, float f11, double d10) {
        this.f35897e.post(new b(d10, System.currentTimeMillis(), f10, f11));
    }

    public void D(Bitmap bitmap, Matrix matrix, float f10, float f11) {
        if (bitmap != null) {
            E(new oj.a(bitmap), matrix, f10, f11);
        } else {
            E(null, matrix, f10, f11);
        }
    }

    public void E(Drawable drawable, Matrix matrix, float f10, float f11) {
        if (getWidth() <= 0) {
            this.f35898f = new a(drawable, matrix, f10, f11);
        } else {
            a(drawable, matrix, f10, f11);
        }
    }

    public void F(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.f35907o) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.f35906n) {
            rectF2.left = 0.0f;
        }
        if (rectF2.top + rectF.top >= 0.0f && rectF.bottom > this.f35907o) {
            rectF2.top = (int) (0.0f - r0);
        }
        float f10 = rectF2.top + rectF.bottom;
        int i10 = this.f35907o;
        if (f10 <= i10 + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i10 + 0) - r0);
        }
        if (rectF2.left + rectF.left >= 0.0f) {
            rectF2.left = (int) (0.0f - r0);
        }
        float f11 = rectF2.left + rectF.right;
        int i11 = this.f35906n;
        if (f11 <= i11 + 0) {
            rectF2.left = (int) ((i11 + 0) - r6);
        }
    }

    public void G(float f10) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        if (f10 < getMinScale()) {
            f10 = getMinScale();
        }
        PointF center = getCenter();
        I(f10, center.x, center.y);
    }

    public void H(float f10, float f11) {
        PointF center = getCenter();
        J(f10, center.x, center.y, f11);
    }

    public void I(float f10, float f11, float f12) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        w(f10 / getScale(), f11, f12);
        t(getScale());
        b(true, true);
    }

    public void J(float f10, float f11, float f12, float f13) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        Matrix matrix = new Matrix(this.f35895c);
        matrix.postScale(f10, f10, f11, f12);
        RectF rectFI = i(matrix, true, true);
        this.f35897e.post(new c(f13, jCurrentTimeMillis, f10 - scale, scale, f11 + (rectFI.left * f10), f12 + (rectFI.top * f10)));
    }

    public void a(Drawable drawable, Matrix matrix, float f10, float f11) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.f35894b.reset();
            super.setImageDrawable(null);
        }
        if (f10 == -1.0f || f11 == -1.0f) {
            this.f35901i = -1.0f;
            this.f35900h = -1.0f;
            this.f35903k = false;
            this.f35902j = false;
        } else {
            float fMin = Math.min(f10, f11);
            float fMax = Math.max(fMin, f11);
            this.f35901i = fMin;
            this.f35900h = fMax;
            this.f35903k = true;
            this.f35902j = true;
            DisplayType displayType = this.f35909q;
            if (displayType == DisplayType.FIT_TO_SCREEN || displayType == DisplayType.FIT_IF_BIGGER) {
                if (fMin >= 1.0f) {
                    this.f35903k = false;
                    this.f35901i = -1.0f;
                }
                if (fMax <= 1.0f) {
                    this.f35902j = true;
                    this.f35900h = -1.0f;
                }
            }
        }
        if (matrix != null) {
            this.f35896d = new Matrix(matrix);
        }
        this.f35911s = true;
        requestLayout();
    }

    public void b(boolean z10, boolean z11) {
        if (getDrawable() == null) {
            return;
        }
        RectF rectFI = i(this.f35895c, z10, z11);
        float f10 = rectFI.left;
        if (f10 == 0.0f && rectFI.top == 0.0f) {
            return;
        }
        x(f10, rectFI.top);
    }

    public void c() {
        setImageBitmap(null);
    }

    public float d() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.max(r0.getIntrinsicWidth() / this.f35906n, r0.getIntrinsicHeight() / this.f35907o) * 8.0f;
    }

    @Override // pj.a
    public void dispose() {
        c();
    }

    public float e() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / n(this.f35894b));
    }

    public void f(Drawable drawable) {
        d dVar = this.f35916x;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    public void g(int i10, int i11, int i12, int i13) {
        e eVar = this.f35917y;
        if (eVar != null) {
            eVar.a(true, i10, i11, i12, i13);
        }
    }

    public float getBaseScale() {
        return n(this.f35894b);
    }

    public RectF getBitmapRect() {
        return h(this.f35895c);
    }

    public PointF getCenter() {
        return this.f35908p;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.f35895c);
    }

    public DisplayType getDisplayType() {
        return this.f35909q;
    }

    public Matrix getImageViewMatrix() {
        return k(this.f35895c);
    }

    public float getMaxScale() {
        if (this.f35900h == -1.0f) {
            this.f35900h = d();
        }
        return this.f35900h;
    }

    public float getMinScale() {
        if (this.f35901i == -1.0f) {
            this.f35901i = e();
        }
        return this.f35901i;
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public float getRotation() {
        return 0.0f;
    }

    public float getScale() {
        return n(this.f35895c);
    }

    public RectF h(Matrix matrix) {
        if (getDrawable() == null) {
            return null;
        }
        Matrix matrixK = k(matrix);
        this.f35913u.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrixK.mapRect(this.f35913u);
        return this.f35913u;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.RectF i(android.graphics.Matrix r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.getDrawable()
            r1 = 0
            if (r0 != 0) goto Ld
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>(r1, r1, r1, r1)
            return r7
        Ld:
            android.graphics.RectF r0 = r6.f35914v
            r0.set(r1, r1, r1, r1)
            android.graphics.RectF r7 = r6.h(r7)
            float r0 = r7.height()
            float r2 = r7.width()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r9 == 0) goto L41
            int r9 = r6.f35907o
            float r4 = (float) r9
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 >= 0) goto L2f
            float r4 = r4 - r0
            float r4 = r4 / r3
            float r9 = r7.top
            float r4 = r4 - r9
            goto L42
        L2f:
            float r0 = r7.top
            int r5 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r5 <= 0) goto L37
            float r4 = -r0
            goto L42
        L37:
            float r0 = r7.bottom
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L41
            float r9 = (float) r9
            float r4 = r9 - r0
            goto L42
        L41:
            r4 = 0
        L42:
            if (r8 == 0) goto L60
            int r8 = r6.f35906n
            float r8 = (float) r8
            int r9 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r9 >= 0) goto L51
            float r8 = r8 - r2
            float r8 = r8 / r3
            float r7 = r7.left
        L4f:
            float r8 = r8 - r7
            goto L61
        L51:
            float r9 = r7.left
            int r0 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r0 <= 0) goto L59
            float r8 = -r9
            goto L61
        L59:
            float r7 = r7.right
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 >= 0) goto L60
            goto L4f
        L60:
            r8 = 0
        L61:
            android.graphics.RectF r7 = r6.f35914v
            r7.set(r8, r4, r1, r1)
            android.graphics.RectF r7 = r6.f35914v
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.imagezoom.ImageViewTouchBase.i(android.graphics.Matrix, boolean, boolean):android.graphics.RectF");
    }

    public float j(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        return displayType == DisplayType.FIT_IF_BIGGER ? Math.min(1.0f, 1.0f / n(this.f35894b)) : 1.0f / n(this.f35894b);
    }

    public Matrix k(Matrix matrix) {
        this.f35904l.set(this.f35894b);
        this.f35904l.postConcat(matrix);
        return this.f35904l;
    }

    public void l(Drawable drawable, Matrix matrix) {
        float f10 = this.f35906n;
        float f11 = this.f35907o;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth > f10 || intrinsicHeight > f11) {
            float fMin = Math.min(f10 / intrinsicWidth, f11 / intrinsicHeight);
            matrix.postScale(fMin, fMin);
            matrix.postTranslate((f10 - (intrinsicWidth * fMin)) / 2.0f, (f11 - (intrinsicHeight * fMin)) / 2.0f);
        } else {
            float fMin2 = Math.min(f10 / intrinsicWidth, f11 / intrinsicHeight);
            matrix.postScale(fMin2, fMin2);
            matrix.postTranslate((f10 - (intrinsicWidth * fMin2)) / 2.0f, (f11 - (intrinsicHeight * fMin2)) / 2.0f);
        }
    }

    public void m(Drawable drawable, Matrix matrix) {
        float f10 = this.f35906n;
        float f11 = this.f35907o;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        float fMin = Math.min(f10 / intrinsicWidth, f11 / intrinsicHeight);
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((f10 - (intrinsicWidth * fMin)) / 2.0f, (f11 - (intrinsicHeight * fMin)) / 2.0f);
    }

    public float n(Matrix matrix) {
        return o(matrix, 0);
    }

    public float o(Matrix matrix, int i10) {
        matrix.getValues(this.f35905m);
        return this.f35905m[i10];
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        float fJ;
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int i16 = this.f35906n;
            int i17 = this.f35907o;
            int i18 = i12 - i10;
            this.f35906n = i18;
            int i19 = i13 - i11;
            this.f35907o = i19;
            i14 = i18 - i16;
            i15 = i19 - i17;
            PointF pointF = this.f35908p;
            pointF.x = i18 / 2.0f;
            pointF.y = i19 / 2.0f;
        } else {
            i14 = 0;
            i15 = 0;
        }
        Runnable runnable = this.f35898f;
        if (runnable != null) {
            this.f35898f = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable == null) {
            if (this.f35911s) {
                q(drawable);
            }
            if (z10 || this.f35911s || this.f35910r) {
                s(i10, i11, i12, i13);
            }
            if (this.f35911s) {
                this.f35911s = false;
            }
            if (this.f35910r) {
                this.f35910r = false;
                return;
            }
            return;
        }
        if (z10 || this.f35910r || this.f35911s) {
            j(this.f35909q);
            float fN = n(this.f35894b);
            float scale = getScale();
            float fMin = Math.min(1.0f, 1.0f / fN);
            l(drawable, this.f35894b);
            float fN2 = n(this.f35894b);
            if (this.f35911s || this.f35910r) {
                Matrix matrix = this.f35896d;
                if (matrix != null) {
                    this.f35895c.set(matrix);
                    this.f35896d = null;
                    fJ = getScale();
                } else {
                    this.f35895c.reset();
                    fJ = j(this.f35909q);
                }
                fJ = fJ;
                setImageMatrix(getImageViewMatrix());
                if (fJ != getScale()) {
                    G(fJ);
                }
            } else if (z10) {
                if (!this.f35903k) {
                    this.f35901i = -1.0f;
                }
                if (!this.f35902j) {
                    this.f35900h = -1.0f;
                }
                setImageMatrix(getImageViewMatrix());
                x(-i14, -i15);
                if (this.f35899g) {
                    fJ = ((double) Math.abs(scale - fMin)) > 0.001d ? (fN / fN2) * scale : 1.0f;
                    G(fJ);
                } else {
                    fJ = j(this.f35909q);
                    G(fJ);
                }
            }
            this.f35899g = false;
            if (fJ > getMaxScale() || fJ < getMinScale()) {
                G(fJ);
            }
            b(true, true);
            if (this.f35911s) {
                q(drawable);
            }
            if (z10 || this.f35911s || this.f35910r) {
                s(i10, i11, i12, i13);
            }
            if (this.f35910r) {
                this.f35910r = false;
            }
            if (this.f35911s) {
                this.f35911s = false;
            }
        }
    }

    public void p(Context context, AttributeSet attributeSet, int i10) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void q(Drawable drawable) {
        f(drawable);
    }

    public void r() {
    }

    public void s(int i10, int i11, int i12, int i13) {
        g(i10, i11, i12, i13);
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.f35909q) {
            this.f35899g = false;
            this.f35909q = displayType;
            this.f35910r = true;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        D(bitmap, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        E(drawable, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        Matrix imageMatrix = getImageMatrix();
        boolean z10 = (matrix == null && !imageMatrix.isIdentity()) || !(matrix == null || imageMatrix.equals(matrix));
        super.setImageMatrix(matrix);
        if (z10) {
            r();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        setImageDrawable(getContext().getResources().getDrawable(i10));
    }

    public void setMaxScale(float f10) {
        this.f35900h = f10;
    }

    public void setMinScale(float f10) {
        this.f35901i = f10;
    }

    public void setOnDrawableChangedListener(d dVar) {
        this.f35916x = dVar;
    }

    public void setOnLayoutChangeListener(e eVar) {
        this.f35917y = eVar;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void t(float f10) {
    }

    public void u(float f10) {
    }

    public void v(double d10, double d11) {
        RectF bitmapRect = getBitmapRect();
        this.f35915w.set((float) d10, (float) d11, 0.0f, 0.0f);
        F(bitmapRect, this.f35915w);
        RectF rectF = this.f35915w;
        x(rectF.left, rectF.top);
        b(true, true);
    }

    public void w(float f10, float f11, float f12) {
        this.f35895c.postScale(f10, f10, f11, f12);
        setImageMatrix(getImageViewMatrix());
    }

    public void x(float f10, float f11) {
        if (f10 == 0.0f && f11 == 0.0f) {
            return;
        }
        this.f35895c.postTranslate(f10, f11);
        setImageMatrix(getImageViewMatrix());
    }

    public void y(Matrix matrix) {
        float fO = o(matrix, 0);
        float fO2 = o(matrix, 4);
        float fO3 = o(matrix, 2);
        float fO4 = o(matrix, 5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("matrix: { x: ");
        sb2.append(fO3);
        sb2.append(", y: ");
        sb2.append(fO4);
        sb2.append(", scalex: ");
        sb2.append(fO);
        sb2.append(", scaley: ");
        sb2.append(fO2);
        sb2.append(" }");
    }

    public void z() {
        this.f35911s = true;
        requestLayout();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f35893a = new nj.d();
        this.f35894b = new Matrix();
        this.f35895c = new Matrix();
        this.f35897e = new Handler();
        this.f35898f = null;
        this.f35899g = false;
        this.f35900h = -1.0f;
        this.f35901i = -1.0f;
        this.f35904l = new Matrix();
        this.f35905m = new float[9];
        this.f35906n = -1;
        this.f35907o = -1;
        this.f35908p = new PointF();
        this.f35909q = DisplayType.NONE;
        this.f35912t = 200;
        this.f35913u = new RectF();
        this.f35914v = new RectF();
        this.f35915w = new RectF();
        p(context, attributeSet, i10);
    }
}
