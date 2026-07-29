package nh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import g.f0;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import jh.c;
import mh.g;
import nh.b;

/* JADX INFO: loaded from: classes5.dex */
public class a extends nh.b {
    public static final int C2 = 500;
    public static final float E7 = 0.0f;
    public static final float F7 = 0.0f;
    public static final float K2 = 10.0f;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f42152v2 = 0;
    public float A;
    public float B;
    public c C;
    public int C1;
    public Runnable D;
    public float K0;
    public long K1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Runnable f42153k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f42154k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f42155v1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f42156y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Matrix f42157z;

    /* JADX INFO: renamed from: nh.a$a, reason: collision with other inner class name */
    public static class RunnableC0474a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f42158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f42159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f42160c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f42161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f42162e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f42163f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f42164g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f42165h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f42166i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f42167j;

        public RunnableC0474a(a aVar, long j10, float f10, float f11, float f12, float f13, float f14, float f15, boolean z10) {
            this.f42158a = new WeakReference<>(aVar);
            this.f42159b = j10;
            this.f42161d = f10;
            this.f42162e = f11;
            this.f42163f = f12;
            this.f42164g = f13;
            this.f42165h = f14;
            this.f42166i = f15;
            this.f42167j = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f42158a.get();
            if (aVar == null) {
                return;
            }
            float fMin = Math.min(this.f42159b, System.currentTimeMillis() - this.f42160c);
            float fC = mh.b.c(fMin, 0.0f, this.f42163f, this.f42159b);
            float fC2 = mh.b.c(fMin, 0.0f, this.f42164g, this.f42159b);
            float fB = mh.b.b(fMin, 0.0f, this.f42166i, this.f42159b);
            if (fMin < this.f42159b) {
                float[] fArr = aVar.f42180e;
                aVar.o(fC - (fArr[0] - this.f42161d), fC2 - (fArr[1] - this.f42162e));
                if (!this.f42167j) {
                    aVar.G(this.f42165h + fB, aVar.f42156y.centerX(), aVar.f42156y.centerY());
                }
                if (aVar.y()) {
                    return;
                }
                aVar.post(this);
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a> f42168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f42169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f42170c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f42171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f42172e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f42173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f42174g;

        public b(a aVar, long j10, float f10, float f11, float f12, float f13) {
            this.f42168a = new WeakReference<>(aVar);
            this.f42169b = j10;
            this.f42171d = f10;
            this.f42172e = f11;
            this.f42173f = f12;
            this.f42174g = f13;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f42168a.get();
            if (aVar == null) {
                return;
            }
            float fMin = Math.min(this.f42169b, System.currentTimeMillis() - this.f42170c);
            float fB = mh.b.b(fMin, 0.0f, this.f42172e, this.f42169b);
            if (fMin >= this.f42169b) {
                aVar.C();
            } else {
                aVar.G(this.f42171d + fB, this.f42173f, this.f42174g);
                aVar.post(this);
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public void A(float f10) {
        m(f10, this.f42156y.centerX(), this.f42156y.centerY());
    }

    public void B(@n0 TypedArray typedArray) {
        float fAbs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            this.A = 0.0f;
        } else {
            this.A = fAbs / fAbs2;
        }
    }

    public void C() {
        setImageToWrapCropBounds(true);
    }

    public final void D(float f10, float f11) {
        float fWidth = this.f42156y.width();
        float fHeight = this.f42156y.height();
        float fMax = Math.max(this.f42156y.width() / f10, this.f42156y.height() / f11);
        RectF rectF = this.f42156y;
        float f12 = ((fWidth - (f10 * fMax)) / 2.0f) + rectF.left;
        float f13 = ((fHeight - (f11 * fMax)) / 2.0f) + rectF.top;
        this.f42182g.reset();
        this.f42182g.postScale(fMax, fMax);
        this.f42182g.postTranslate(f12, f13);
        setImageMatrix(this.f42182g);
    }

    public void E(float f10, float f11, float f12, long j10) {
        if (f10 > getMaxScale()) {
            f10 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j10, currentScale, f10 - currentScale, f11, f12);
        this.f42153k0 = bVar;
        post(bVar);
    }

    public void F(float f10) {
        G(f10, this.f42156y.centerX(), this.f42156y.centerY());
    }

    public void G(float f10, float f11, float f12) {
        if (f10 <= getMaxScale()) {
            n(f10 / getCurrentScale(), f11, f12);
        }
    }

    public void H(float f10) {
        I(f10, this.f42156y.centerX(), this.f42156y.centerY());
    }

    public void I(float f10, float f11, float f12) {
        if (f10 >= getMinScale()) {
            n(f10 / getCurrentScale(), f11, f12);
        }
    }

    @p0
    public c getCropBoundsChangeListener() {
        return this.C;
    }

    public float getMaxScale() {
        return this.K0;
    }

    public float getMinScale() {
        return this.f42154k1;
    }

    public float getTargetAspectRatio() {
        return this.A;
    }

    @Override // nh.b
    public void l() {
        super.l();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.A == 0.0f) {
            this.A = intrinsicWidth / intrinsicHeight;
        }
        int i10 = this.f42183h;
        float f10 = this.A;
        int i11 = (int) (i10 / f10);
        int i12 = this.f42184i;
        if (i11 > i12) {
            this.f42156y.set((i10 - ((int) (i12 * f10))) / 2, 0.0f, r4 + r2, i12);
        } else {
            this.f42156y.set(0.0f, (i12 - i11) / 2, i10, i11 + r6);
        }
        v(intrinsicWidth, intrinsicHeight);
        D(intrinsicWidth, intrinsicHeight);
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(this.A);
        }
        b.InterfaceC0475b interfaceC0475b = this.f42185j;
        if (interfaceC0475b != null) {
            interfaceC0475b.d(getCurrentScale());
            this.f42185j.a(getCurrentAngle());
        }
    }

    @Override // nh.b
    public void n(float f10, float f11, float f12) {
        if (f10 > 1.0f && getCurrentScale() * f10 <= getMaxScale()) {
            super.n(f10, f11, f12);
        } else {
            if (f10 >= 1.0f || getCurrentScale() * f10 < getMinScale()) {
                return;
            }
            super.n(f10, f11, f12);
        }
    }

    public void setCropBoundsChangeListener(@p0 c cVar) {
        this.C = cVar;
    }

    public void setCropRect(RectF rectF) {
        this.A = rectF.width() / rectF.height();
        this.f42156y.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        u();
        C();
    }

    public void setImageToWrapCropBounds(boolean z10) {
        float f10;
        float fMax;
        float f11;
        if (!this.f42189n || y()) {
            return;
        }
        float[] fArr = this.f42180e;
        float f12 = fArr[0];
        float f13 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.f42156y.centerX() - f12;
        float fCenterY = this.f42156y.centerY() - f13;
        this.f42157z.reset();
        this.f42157z.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.f42179d;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f42157z.mapPoints(fArrCopyOf);
        boolean z11 = z(fArrCopyOf);
        if (z11) {
            float[] fArrT = t();
            float f14 = -(fArrT[0] + fArrT[2]);
            f11 = -(fArrT[1] + fArrT[3]);
            f10 = f14;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.f42156y);
            this.f42157z.reset();
            this.f42157z.setRotate(getCurrentAngle());
            this.f42157z.mapRect(rectF);
            float[] fArrC = g.c(this.f42179d);
            f10 = fCenterX;
            fMax = (Math.max(rectF.width() / fArrC[0], rectF.height() / fArrC[1]) * currentScale) - currentScale;
            f11 = fCenterY;
        }
        if (z10) {
            RunnableC0474a runnableC0474a = new RunnableC0474a(this, this.K1, f12, f13, f10, f11, currentScale, fMax, z11);
            this.D = runnableC0474a;
            post(runnableC0474a);
        } else {
            o(f10, f11);
            if (z11) {
                return;
            }
            G(currentScale + fMax, this.f42156y.centerX(), this.f42156y.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@f0(from = 100) long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.K1 = j10;
    }

    public void setMaxResultImageSizeX(@f0(from = g1.a.f28860g) int i10) {
        this.f42155v1 = i10;
    }

    public void setMaxResultImageSizeY(@f0(from = g1.a.f28860g) int i10) {
        this.C1 = i10;
    }

    public void setMaxScaleMultiplier(float f10) {
        this.B = f10;
    }

    public void setTargetAspectRatio(float f10) {
        if (getDrawable() == null) {
            this.A = f10;
            return;
        }
        if (f10 == 0.0f) {
            this.A = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.A = f10;
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(this.A);
        }
    }

    public final float[] t() {
        this.f42157z.reset();
        this.f42157z.setRotate(-getCurrentAngle());
        float[] fArr = this.f42179d;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        float[] fArrB = g.b(this.f42156y);
        this.f42157z.mapPoints(fArrCopyOf);
        this.f42157z.mapPoints(fArrB);
        RectF rectFD = g.d(fArrCopyOf);
        RectF rectFD2 = g.d(fArrB);
        float f10 = rectFD.left - rectFD2.left;
        float f11 = rectFD.top - rectFD2.top;
        float f12 = rectFD.right - rectFD2.right;
        float f13 = rectFD.bottom - rectFD2.bottom;
        float[] fArr2 = new float[4];
        if (f10 <= 0.0f) {
            f10 = 0.0f;
        }
        fArr2[0] = f10;
        if (f11 <= 0.0f) {
            f11 = 0.0f;
        }
        fArr2[1] = f11;
        if (f12 >= 0.0f) {
            f12 = 0.0f;
        }
        fArr2[2] = f12;
        if (f13 >= 0.0f) {
            f13 = 0.0f;
        }
        fArr2[3] = f13;
        this.f42157z.reset();
        this.f42157z.setRotate(getCurrentAngle());
        this.f42157z.mapPoints(fArr2);
        return fArr2;
    }

    public final void u() {
        if (getDrawable() == null) {
            return;
        }
        v(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    public final void v(float f10, float f11) {
        float fMin = Math.min(Math.min(this.f42156y.width() / f10, this.f42156y.width() / f11), Math.min(this.f42156y.height() / f11, this.f42156y.height() / f10));
        this.f42154k1 = fMin;
        this.K0 = fMin * this.B;
    }

    public void w() {
        removeCallbacks(this.D);
        removeCallbacks(this.f42153k0);
    }

    public void x(@n0 Bitmap.CompressFormat compressFormat, int i10, @p0 jh.a aVar) {
        w();
        setImageToWrapCropBounds(false);
        kh.c cVar = new kh.c(this.f42156y, g.d(this.f42179d), getCurrentScale(), getCurrentAngle());
        kh.a aVar2 = new kh.a(this.f42155v1, this.C1, compressFormat, i10, getImageInputPath(), getImageOutputPath(), getExifInfo());
        aVar2.j(getImageInputUri());
        aVar2.k(getImageOutputUri());
        new lh.a(getContext(), getViewBitmap(), cVar, aVar2, aVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public boolean y() {
        return z(this.f42179d);
    }

    public boolean z(float[] fArr) {
        this.f42157z.reset();
        this.f42157z.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.f42157z.mapPoints(fArrCopyOf);
        float[] fArrB = g.b(this.f42156y);
        this.f42157z.mapPoints(fArrB);
        return g.d(fArrCopyOf).contains(g.d(fArrB));
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f42156y = new RectF();
        this.f42157z = new Matrix();
        this.B = 10.0f;
        this.f42153k0 = null;
        this.f42155v1 = 0;
        this.C1 = 0;
        this.K1 = 500L;
    }
}
