package b0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f8924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f8926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f8927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f8929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Path f8931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewOutlineProvider f8932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f8933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable[] f8934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LayerDrawable f8935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8936p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8937q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f8938r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f8939s;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, b.this.getWidth(), b.this.getHeight(), (Math.min(r3, r4) * b.this.f8929i) / 2.0f);
        }
    }

    /* JADX INFO: renamed from: b0.b$b, reason: collision with other inner class name */
    public class C0094b extends ViewOutlineProvider {
        public C0094b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, b.this.getWidth(), b.this.getHeight(), b.this.f8930j);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f8942a = new float[20];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorMatrix f8943b = new ColorMatrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorMatrix f8944c = new ColorMatrix();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8945d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8946e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8947f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8948g = 1.0f;

        public final void a(float brightness) {
            float[] fArr = this.f8942a;
            fArr[0] = brightness;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = brightness;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = brightness;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void b(float saturationStrength) {
            float f10 = 1.0f - saturationStrength;
            float f11 = 0.2999f * f10;
            float f12 = 0.587f * f10;
            float f13 = f10 * 0.114f;
            float[] fArr = this.f8942a;
            fArr[0] = f11 + saturationStrength;
            fArr[1] = f12;
            fArr[2] = f13;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f11;
            fArr[6] = f12 + saturationStrength;
            fArr[7] = f13;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f11;
            fArr[11] = f12;
            fArr[12] = f13 + saturationStrength;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void c(ImageView view) {
            boolean z10;
            this.f8943b.reset();
            float f10 = this.f8946e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f8943b.set(this.f8942a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f8947f;
            if (f11 != 1.0f) {
                this.f8944c.setScale(f11, f11, f11, 1.0f);
                this.f8943b.postConcat(this.f8944c);
                z10 = true;
            }
            float f12 = this.f8948g;
            if (f12 != 1.0f) {
                d(f12);
                this.f8944c.set(this.f8942a);
                this.f8943b.postConcat(this.f8944c);
                z10 = true;
            }
            float f13 = this.f8945d;
            if (f13 != 1.0f) {
                a(f13);
                this.f8944c.set(this.f8942a);
                this.f8943b.postConcat(this.f8944c);
            } else {
                z11 = z10;
            }
            if (z11) {
                view.setColorFilter(new ColorMatrixColorFilter(this.f8943b));
            } else {
                view.clearColorFilter();
            }
        }

        public final void d(float warmth) {
            float fLog;
            float fPow;
            if (warmth <= 0.0f) {
                warmth = 0.01f;
            }
            float f10 = (5000.0f / warmth) / 100.0f;
            if (f10 > 66.0f) {
                double d10 = f10 - 60.0f;
                fPow = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d10, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f10)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            float fLog2 = f10 < 66.0f ? f10 > 19.0f ? (((float) Math.log(f10 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f8942a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public b(Context context) {
        super(context);
        this.f8924d = new c();
        this.f8925e = true;
        this.f8926f = null;
        this.f8927g = null;
        this.f8928h = 0.0f;
        this.f8929i = 0.0f;
        this.f8930j = Float.NaN;
        this.f8934n = new Drawable[2];
        this.f8936p = Float.NaN;
        this.f8937q = Float.NaN;
        this.f8938r = Float.NaN;
        this.f8939s = Float.NaN;
        e(context, null);
    }

    private void setOverlay(boolean overlay) {
        this.f8925e = overlay;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public final void e(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f8926f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f8928h = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f8925e));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f8936p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f8937q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f8939s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f8938r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f8927g = drawable;
            if (this.f8926f == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f8927g = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f8934n;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f8927g = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f8934n;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f8927g = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f8934n[1] = this.f8926f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f8934n);
            this.f8935o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f8928h * 255.0f));
            if (!this.f8925e) {
                this.f8935o.getDrawable(0).setAlpha((int) ((1.0f - this.f8928h) * 255.0f));
            }
            super.setImageDrawable(this.f8935o);
        }
    }

    public final void f() {
        if (Float.isNaN(this.f8936p) && Float.isNaN(this.f8937q) && Float.isNaN(this.f8938r) && Float.isNaN(this.f8939s)) {
            return;
        }
        float f10 = Float.isNaN(this.f8936p) ? 0.0f : this.f8936p;
        float f11 = Float.isNaN(this.f8937q) ? 0.0f : this.f8937q;
        float f12 = Float.isNaN(this.f8938r) ? 1.0f : this.f8938r;
        float f13 = Float.isNaN(this.f8939s) ? 0.0f : this.f8939s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f14 = f12 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f14, f14);
        float f15 = intrinsicWidth * f14;
        float f16 = f14 * intrinsicHeight;
        matrix.postTranslate((((f10 * (width - f15)) + width) - f15) * 0.5f, (((f11 * (height - f16)) + height) - f16) * 0.5f);
        matrix.postRotate(f13, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void g() {
        if (Float.isNaN(this.f8936p) && Float.isNaN(this.f8937q) && Float.isNaN(this.f8938r) && Float.isNaN(this.f8939s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            f();
        }
    }

    public float getBrightness() {
        return this.f8924d.f8945d;
    }

    public float getContrast() {
        return this.f8924d.f8947f;
    }

    public float getCrossfade() {
        return this.f8928h;
    }

    public float getImagePanX() {
        return this.f8936p;
    }

    public float getImagePanY() {
        return this.f8937q;
    }

    public float getImageRotate() {
        return this.f8939s;
    }

    public float getImageZoom() {
        return this.f8938r;
    }

    public float getRound() {
        return this.f8930j;
    }

    public float getRoundPercent() {
        return this.f8929i;
    }

    public float getSaturation() {
        return this.f8924d.f8946e;
    }

    public float getWarmth() {
        return this.f8924d.f8948g;
    }

    @Override // android.view.View
    public void layout(int l10, int t10, int r10, int b10) {
        super.layout(l10, t10, r10, b10);
        f();
    }

    public void setAltImageResource(int resId) {
        Drawable drawableMutate = i.a.b(getContext(), resId).mutate();
        this.f8926f = drawableMutate;
        Drawable[] drawableArr = this.f8934n;
        drawableArr[0] = this.f8927g;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8934n);
        this.f8935o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8928h);
    }

    public void setBrightness(float brightness) {
        c cVar = this.f8924d;
        cVar.f8945d = brightness;
        cVar.c(this);
    }

    public void setContrast(float contrast) {
        c cVar = this.f8924d;
        cVar.f8947f = contrast;
        cVar.c(this);
    }

    public void setCrossfade(float crossfade) {
        this.f8928h = crossfade;
        if (this.f8934n != null) {
            if (!this.f8925e) {
                this.f8935o.getDrawable(0).setAlpha((int) ((1.0f - this.f8928h) * 255.0f));
            }
            this.f8935o.getDrawable(1).setAlpha((int) (this.f8928h * 255.0f));
            super.setImageDrawable(this.f8935o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f8926f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f8927g = drawableMutate;
        Drawable[] drawableArr = this.f8934n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f8926f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8934n);
        this.f8935o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8928h);
    }

    public void setImagePanX(float pan) {
        this.f8936p = pan;
        g();
    }

    public void setImagePanY(float pan) {
        this.f8937q = pan;
        g();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        if (this.f8926f == null) {
            super.setImageResource(resId);
            return;
        }
        Drawable drawableMutate = i.a.b(getContext(), resId).mutate();
        this.f8927g = drawableMutate;
        Drawable[] drawableArr = this.f8934n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f8926f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8934n);
        this.f8935o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8928h);
    }

    public void setImageRotate(float rotation) {
        this.f8939s = rotation;
        g();
    }

    public void setImageZoom(float zoom) {
        this.f8938r = zoom;
        g();
    }

    @v0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f8930j = round;
            float f10 = this.f8929i;
            this.f8929i = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z10 = this.f8930j != round;
        this.f8930j = round;
        if (round != 0.0f) {
            if (this.f8931k == null) {
                this.f8931k = new Path();
            }
            if (this.f8933m == null) {
                this.f8933m = new RectF();
            }
            if (this.f8932l == null) {
                C0094b c0094b = new C0094b();
                this.f8932l = c0094b;
                setOutlineProvider(c0094b);
            }
            setClipToOutline(true);
            this.f8933m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8931k.reset();
            Path path = this.f8931k;
            RectF rectF = this.f8933m;
            float f11 = this.f8930j;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @v0(21)
    public void setRoundPercent(float round) {
        boolean z10 = this.f8929i != round;
        this.f8929i = round;
        if (round != 0.0f) {
            if (this.f8931k == null) {
                this.f8931k = new Path();
            }
            if (this.f8933m == null) {
                this.f8933m = new RectF();
            }
            if (this.f8932l == null) {
                a aVar = new a();
                this.f8932l = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f8929i) / 2.0f;
            this.f8933m.set(0.0f, 0.0f, width, height);
            this.f8931k.reset();
            this.f8931k.addRoundRect(this.f8933m, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float saturation) {
        c cVar = this.f8924d;
        cVar.f8946e = saturation;
        cVar.c(this);
    }

    public void setWarmth(float warmth) {
        c cVar = this.f8924d;
        cVar.f8948g = warmth;
        cVar.c(this);
    }

    public b(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f8924d = new c();
        this.f8925e = true;
        this.f8926f = null;
        this.f8927g = null;
        this.f8928h = 0.0f;
        this.f8929i = 0.0f;
        this.f8930j = Float.NaN;
        this.f8934n = new Drawable[2];
        this.f8936p = Float.NaN;
        this.f8937q = Float.NaN;
        this.f8938r = Float.NaN;
        this.f8939s = Float.NaN;
        e(context, attrs);
    }

    public b(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8924d = new c();
        this.f8925e = true;
        this.f8926f = null;
        this.f8927g = null;
        this.f8928h = 0.0f;
        this.f8929i = 0.0f;
        this.f8930j = Float.NaN;
        this.f8934n = new Drawable[2];
        this.f8936p = Float.NaN;
        this.f8937q = Float.NaN;
        this.f8938r = Float.NaN;
        this.f8939s = Float.NaN;
        e(context, attrs);
    }
}
