package com.flydigi.base.widget.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.i0;
import com.flydigi.base.R;
import g.c1;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class CBRatingBar extends View {
    public static final int A = 1;
    public static final int B = 0;
    public static final int C = 1;
    public static final float C1 = 0.0f;
    public static final int C2 = -65536;
    public static final boolean D = true;
    public static final int E7 = R.string.round_star;
    public static final int K0 = -1;
    public static final boolean K1 = false;
    public static final boolean K2 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f13574k0 = -65536;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f13575k1 = -65536;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final float f13576v1 = 100.0f;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f13577v2 = -256;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f13578z = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f13579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f13580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f13581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f13582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13589k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13590l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13591m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f13592n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13593o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13594p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13595q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13596r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13597s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13598t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f13599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Path f13600v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f13601w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @c1
    public int f13602x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13603y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f13604a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f13605b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f13606c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f13607d = 3;
    }

    public interface b {
        void a(int i10);
    }

    public CBRatingBar(Context context) {
        this(context, null);
    }

    public CBRatingBar A(float f10) {
        this.f13592n = Math.min(Math.max(0.0f, f10), this.f13591m);
        l(false);
        return this;
    }

    public CBRatingBar B(int i10) {
        if (i10 <= 0) {
            i10 = 20;
        }
        this.f13583e = i10;
        float f10 = i10;
        m(this.f13600v, f10, f10);
        l(true);
        return this;
    }

    public CBRatingBar C(int i10) {
        this.f13585g = i10;
        l(true);
        return this;
    }

    public CBRatingBar D(int i10) {
        this.f13588j = i10;
        J();
        l(false);
        return this;
    }

    public CBRatingBar E(int i10) {
        this.f13586h = i10;
        J();
        l(false);
        return this;
    }

    public CBRatingBar F(int i10) {
        this.f13594p = i10;
        H();
        l(false);
        return this;
    }

    public CBRatingBar G(boolean z10) {
        this.f13593o = z10;
        H();
        l(false);
        return this;
    }

    public final void H() {
        this.f13581c.reset();
        this.f13581c.setAntiAlias(true);
        this.f13581c.setStyle(Paint.Style.FILL);
        if (this.f13593o) {
            this.f13581c.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f13583e, this.f13594p, this.f13595q, Shader.TileMode.CLAMP));
        } else {
            this.f13581c.setColor(this.f13590l);
        }
    }

    public final void I() {
        this.f13580b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f13580b.setColor(this.f13589k);
    }

    public final void J() {
        this.f13579a.setStyle(Paint.Style.STROKE);
        this.f13579a.setStrokeWidth(this.f13586h);
        this.f13579a.setColor(this.f13588j);
    }

    public final void a(PointF pointF) {
        float f10 = pointF.x;
        int i10 = this.f13583e;
        int i11 = this.f13584f;
        int i12 = this.f13585g;
        if (f10 > (i10 * i11) + ((i11 - 1) * i12) || pointF.y > i10) {
            return;
        }
        int i13 = ((int) (f10 / (i10 + i12))) + 1;
        if (f10 > ((i10 + i12) * i13) - i12) {
            i13 = 0;
        }
        if (i13 > 0) {
            this.f13597s = i13;
            if (this.f13603y == 1) {
                this.f13597s = (i11 - i13) + 1;
            }
            A((this.f13591m / i11) * this.f13597s);
            b bVar = this.f13599u;
            if (bVar != null) {
                bVar.a(this.f13597s);
            }
        }
    }

    public final void b(Canvas canvas, Paint paint) {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f13584f; i11++) {
            canvas.drawPath(d(i10), paint);
            i10 += this.f13583e + this.f13585g;
        }
    }

    public final Bitmap c(float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f13598t, this.f13583e, Bitmap.Config.ARGB_8888);
        b(new Canvas(bitmapCreateBitmap), this.f13580b);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f13598t, this.f13583e, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.save();
        int i10 = this.f13603y;
        if (i10 == 0) {
            f11 = f10;
            f12 = this.f13583e;
        } else {
            if (i10 == 1) {
                int i11 = this.f13598t;
                f13 = i11 - f10;
                f11 = i11;
                f12 = this.f13583e;
                f14 = 0.0f;
                canvas.clipRect(f13, f14, f11, f12);
                canvas.drawRect(f13, f14, f11, f12, this.f13581c);
                canvas.restore();
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.f13582d);
                return bitmapCreateBitmap2;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    f13 = 0.0f;
                    f14 = 0.0f;
                    f11 = 0.0f;
                    f12 = 0.0f;
                } else {
                    int i12 = this.f13583e;
                    f11 = this.f13598t;
                    f12 = i12;
                    f14 = i12 - f10;
                    f13 = 0.0f;
                }
                canvas.clipRect(f13, f14, f11, f12);
                canvas.drawRect(f13, f14, f11, f12, this.f13581c);
                canvas.restore();
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.f13582d);
                return bitmapCreateBitmap2;
            }
            f12 = f10;
            f11 = this.f13598t;
        }
        f13 = 0.0f;
        f14 = 0.0f;
        canvas.clipRect(f13, f14, f11, f12);
        canvas.drawRect(f13, f14, f11, f12, this.f13581c);
        canvas.restore();
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.f13582d);
        return bitmapCreateBitmap2;
    }

    public final Path d(int i10) {
        Path path = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate(i10, 0.0f);
        path.addPath(this.f13600v, matrix);
        return path;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CBRatingBar);
        this.f13583e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CBRatingBar_starSize, 20);
        this.f13584f = typedArrayObtainStyledAttributes.getInteger(R.styleable.CBRatingBar_starCount, 1);
        this.f13585g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CBRatingBar_starSpace, 0);
        this.f13586h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CBRatingBar_starStrokeWidth, 1);
        this.f13587i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CBRatingBar_starShowStroke, true);
        this.f13588j = typedArrayObtainStyledAttributes.getColor(R.styleable.CBRatingBar_starStrokeColor, -65536);
        this.f13589k = typedArrayObtainStyledAttributes.getColor(R.styleable.CBRatingBar_starFillColor, -1);
        this.f13590l = typedArrayObtainStyledAttributes.getColor(R.styleable.CBRatingBar_starCoverColor, -65536);
        this.f13591m = typedArrayObtainStyledAttributes.getFloat(R.styleable.CBRatingBar_starMaxProgress, 100.0f);
        this.f13592n = typedArrayObtainStyledAttributes.getFloat(R.styleable.CBRatingBar_starProgress, 0.0f);
        this.f13593o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CBRatingBar_starUseGradient, false);
        this.f13594p = typedArrayObtainStyledAttributes.getColor(R.styleable.CBRatingBar_starStartColor, -256);
        this.f13595q = typedArrayObtainStyledAttributes.getColor(R.styleable.CBRatingBar_starEndColor, -65536);
        this.f13596r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CBRatingBar_starCanTouch, false);
        this.f13601w = typedArrayObtainStyledAttributes.getString(R.styleable.CBRatingBar_starPathData);
        this.f13602x = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CBRatingBar_starPathDataId, E7);
        this.f13603y = typedArrayObtainStyledAttributes.getInteger(R.styleable.CBRatingBar_starCoverDir, 0);
        float fMax = Math.max(this.f13592n, 0.0f);
        this.f13592n = fMax;
        this.f13592n = Math.min(fMax, this.f13591m);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f() {
        if (this.f13602x != -1) {
            this.f13601w = getResources().getString(this.f13602x);
        }
        String str = this.f13601w;
        if (str != null && !"".equals(str.trim().replace(i0.f11861z, ""))) {
            this.f13600v = r5.b.f(this.f13601w);
        }
        Path path = this.f13600v;
        int i10 = this.f13583e;
        m(path, i10, i10);
    }

    public boolean g() {
        return this.f13596r;
    }

    public int getCoverDir() {
        return this.f13603y;
    }

    public int getEndColor() {
        return this.f13595q;
    }

    public Path getPath() {
        return this.f13600v;
    }

    public String getPathData() {
        return this.f13601w;
    }

    public int getPathDataId() {
        return this.f13602x;
    }

    public int getStarCount() {
        return this.f13584f;
    }

    public int getStarCoverColor() {
        return this.f13590l;
    }

    public int getStarFillColor() {
        return this.f13589k;
    }

    public float getStarMaxProgress() {
        return this.f13591m;
    }

    public float getStarProgress() {
        return this.f13592n;
    }

    public int getStarSize() {
        return this.f13583e;
    }

    public int getStarSpace() {
        return this.f13585g;
    }

    public int getStarStrokeColor() {
        return this.f13588j;
    }

    public int getStarStrokeWidth() {
        return this.f13586h;
    }

    public int getStartColor() {
        return this.f13594p;
    }

    public int getTouchCount() {
        return this.f13597s;
    }

    public boolean h() {
        return this.f13587i;
    }

    public boolean i() {
        return this.f13593o;
    }

    public final int j(int i10) {
        float fMin;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            fMin = size;
        } else {
            float f10 = this.f13583e;
            fMin = mode == Integer.MIN_VALUE ? Math.min(f10, size) : f10;
        }
        return (int) fMin;
    }

    public final int k(int i10) {
        float fMin;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            fMin = size;
        } else {
            int i11 = this.f13583e;
            int i12 = this.f13584f;
            float f10 = (i11 * i12) + ((i12 - 1) * this.f13585g);
            fMin = mode == Integer.MIN_VALUE ? Math.min(f10, size) : f10;
        }
        int i13 = (int) fMin;
        this.f13598t = i13;
        return i13;
    }

    public final void l(boolean z10) {
        if (z10) {
            requestLayout();
        }
        invalidate();
    }

    public void m(Path path, float f10, float f11) {
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        RectF rectF2 = new RectF();
        path.computeBounds(rectF2, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
        path.transform(matrix);
    }

    public CBRatingBar n(boolean z10) {
        this.f13596r = z10;
        return this;
    }

    public CBRatingBar o(int i10) {
        if (i10 < 0 || i10 > 3) {
            i10 = 0;
        }
        this.f13603y = i10;
        l(false);
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.f13598t;
        float f11 = this.f13592n;
        double d10 = ((double) (f10 * f11)) * 1.0d;
        float f12 = this.f13591m;
        float f13 = (float) (d10 / ((double) f12));
        int i10 = this.f13603y;
        if (i10 == 2 || i10 == 3) {
            f13 = (float) ((((double) (this.f13583e * f11)) * 1.0d) / ((double) f12));
        }
        canvas.drawBitmap(c(f13), 0.0f, 0.0f, (Paint) null);
        if (this.f13587i) {
            b(canvas, this.f13579a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(k(i10), j(i11));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        if (this.f13596r && ((i10 = this.f13603y) == 0 || i10 == 1)) {
            a(new PointF(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onTouchEvent(motionEvent);
    }

    public CBRatingBar p() {
        return u(E7);
    }

    public CBRatingBar q(int i10) {
        this.f13595q = i10;
        H();
        l(false);
        return this;
    }

    public CBRatingBar r(b bVar) {
        this.f13599u = bVar;
        return this;
    }

    public CBRatingBar s(Path path) {
        this.f13600v = path;
        l(false);
        return this;
    }

    public void setTouchCount(int i10) {
        this.f13597s = i10;
    }

    public CBRatingBar t(String str) {
        this.f13601w = str;
        this.f13602x = -1;
        f();
        l(false);
        return this;
    }

    public CBRatingBar u(int i10) {
        this.f13602x = i10;
        this.f13601w = null;
        f();
        l(false);
        return this;
    }

    public CBRatingBar v(boolean z10) {
        this.f13587i = z10;
        l(false);
        return this;
    }

    public CBRatingBar w(int i10) {
        if (i10 <= 0) {
            i10 = 1;
        }
        this.f13584f = i10;
        l(true);
        return this;
    }

    public CBRatingBar x(int i10) {
        this.f13590l = i10;
        H();
        l(false);
        return this;
    }

    public CBRatingBar y(int i10) {
        this.f13589k = i10;
        I();
        l(false);
        return this;
    }

    public CBRatingBar z(float f10) {
        if (f10 <= 0.0f) {
            f10 = 100.0f;
        }
        this.f13591m = f10;
        l(false);
        return this;
    }

    public CBRatingBar(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CBRatingBar(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13579a = new Paint(1);
        this.f13580b = new Paint(1);
        this.f13581c = new Paint(1);
        Paint paint = new Paint(1);
        this.f13582d = paint;
        this.f13597s = -1;
        this.f13600v = new Path();
        e(context, attributeSet);
        f();
        int i11 = this.f13583e;
        int i12 = this.f13584f;
        this.f13598t = (i11 * i12) + ((i12 - 1) * this.f13585g);
        J();
        I();
        H();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }
}
