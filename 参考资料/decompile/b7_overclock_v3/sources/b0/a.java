package b0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.n;
import androidx.constraintlayout.widget.R;
import b0.b;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b.c f8906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f8910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewOutlineProvider f8911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f8912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable[] f8913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayerDrawable f8914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8915m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f8916n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f8917o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8918p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8919q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f8920r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f8921s;

    /* JADX INFO: renamed from: b0.a$a, reason: collision with other inner class name */
    public class C0093a extends ViewOutlineProvider {
        public C0093a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, a.this.getWidth(), a.this.getHeight(), (Math.min(r3, r4) * a.this.f8908f) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, a.this.getWidth(), a.this.getHeight(), a.this.f8909g);
        }
    }

    public a(Context context) {
        super(context);
        this.f8906d = new b.c();
        this.f8907e = 0.0f;
        this.f8908f = 0.0f;
        this.f8909g = Float.NaN;
        this.f8913k = new Drawable[2];
        this.f8915m = true;
        this.f8916n = null;
        this.f8917o = null;
        this.f8918p = Float.NaN;
        this.f8919q = Float.NaN;
        this.f8920r = Float.NaN;
        this.f8921s = Float.NaN;
        c(context, null);
    }

    private void setOverlay(boolean overlay) {
        this.f8915m = overlay;
    }

    public final void c(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f8916n = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f8907e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f8915m));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f8918p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f8919q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f8921s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f8920r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f8917o = drawable;
            if (this.f8916n == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f8917o = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f8913k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f8917o = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f8913k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f8917o = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f8913k[1] = this.f8916n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f8913k);
            this.f8914l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f8907e * 255.0f));
            if (!this.f8915m) {
                this.f8914l.getDrawable(0).setAlpha((int) ((1.0f - this.f8907e) * 255.0f));
            }
            super.setImageDrawable(this.f8914l);
        }
    }

    public final void d() {
        if (Float.isNaN(this.f8918p) && Float.isNaN(this.f8919q) && Float.isNaN(this.f8920r) && Float.isNaN(this.f8921s)) {
            return;
        }
        float f10 = Float.isNaN(this.f8918p) ? 0.0f : this.f8918p;
        float f11 = Float.isNaN(this.f8919q) ? 0.0f : this.f8919q;
        float f12 = Float.isNaN(this.f8920r) ? 1.0f : this.f8920r;
        float f13 = Float.isNaN(this.f8921s) ? 0.0f : this.f8921s;
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

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public final void e() {
        if (Float.isNaN(this.f8918p) && Float.isNaN(this.f8919q) && Float.isNaN(this.f8920r) && Float.isNaN(this.f8921s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    public float getContrast() {
        return this.f8906d.f8947f;
    }

    public float getCrossfade() {
        return this.f8907e;
    }

    public float getImagePanX() {
        return this.f8918p;
    }

    public float getImagePanY() {
        return this.f8919q;
    }

    public float getImageRotate() {
        return this.f8921s;
    }

    public float getImageZoom() {
        return this.f8920r;
    }

    public float getRound() {
        return this.f8909g;
    }

    public float getRoundPercent() {
        return this.f8908f;
    }

    public float getSaturation() {
        return this.f8906d.f8946e;
    }

    public float getWarmth() {
        return this.f8906d.f8948g;
    }

    @Override // android.view.View
    public void layout(int l10, int t10, int r10, int b10) {
        super.layout(l10, t10, r10, b10);
        d();
    }

    public void setAltImageResource(int resId) {
        Drawable drawableMutate = i.a.b(getContext(), resId).mutate();
        this.f8916n = drawableMutate;
        Drawable[] drawableArr = this.f8913k;
        drawableArr[0] = this.f8917o;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8913k);
        this.f8914l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8907e);
    }

    public void setBrightness(float brightness) {
        b.c cVar = this.f8906d;
        cVar.f8945d = brightness;
        cVar.c(this);
    }

    public void setContrast(float contrast) {
        b.c cVar = this.f8906d;
        cVar.f8947f = contrast;
        cVar.c(this);
    }

    public void setCrossfade(float crossfade) {
        this.f8907e = crossfade;
        if (this.f8913k != null) {
            if (!this.f8915m) {
                this.f8914l.getDrawable(0).setAlpha((int) ((1.0f - this.f8907e) * 255.0f));
            }
            this.f8914l.getDrawable(1).setAlpha((int) (this.f8907e * 255.0f));
            super.setImageDrawable(this.f8914l);
        }
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f8916n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f8917o = drawableMutate;
        Drawable[] drawableArr = this.f8913k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f8916n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8913k);
        this.f8914l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8907e);
    }

    public void setImagePanX(float pan) {
        this.f8918p = pan;
        e();
    }

    public void setImagePanY(float pan) {
        this.f8919q = pan;
        e();
    }

    @Override // androidx.appcompat.widget.n, android.widget.ImageView
    public void setImageResource(int resId) {
        if (this.f8916n == null) {
            super.setImageResource(resId);
            return;
        }
        Drawable drawableMutate = i.a.b(getContext(), resId).mutate();
        this.f8917o = drawableMutate;
        Drawable[] drawableArr = this.f8913k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f8916n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f8913k);
        this.f8914l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f8907e);
    }

    public void setImageRotate(float rotation) {
        this.f8921s = rotation;
        e();
    }

    public void setImageZoom(float zoom) {
        this.f8920r = zoom;
        e();
    }

    @v0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f8909g = round;
            float f10 = this.f8908f;
            this.f8908f = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z10 = this.f8909g != round;
        this.f8909g = round;
        if (round != 0.0f) {
            if (this.f8910h == null) {
                this.f8910h = new Path();
            }
            if (this.f8912j == null) {
                this.f8912j = new RectF();
            }
            if (this.f8911i == null) {
                b bVar = new b();
                this.f8911i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f8912j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8910h.reset();
            Path path = this.f8910h;
            RectF rectF = this.f8912j;
            float f11 = this.f8909g;
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
        boolean z10 = this.f8908f != round;
        this.f8908f = round;
        if (round != 0.0f) {
            if (this.f8910h == null) {
                this.f8910h = new Path();
            }
            if (this.f8912j == null) {
                this.f8912j = new RectF();
            }
            if (this.f8911i == null) {
                C0093a c0093a = new C0093a();
                this.f8911i = c0093a;
                setOutlineProvider(c0093a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f8908f) / 2.0f;
            this.f8912j.set(0.0f, 0.0f, width, height);
            this.f8910h.reset();
            this.f8910h.addRoundRect(this.f8912j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float saturation) {
        b.c cVar = this.f8906d;
        cVar.f8946e = saturation;
        cVar.c(this);
    }

    public void setWarmth(float warmth) {
        b.c cVar = this.f8906d;
        cVar.f8948g = warmth;
        cVar.c(this);
    }

    public a(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f8906d = new b.c();
        this.f8907e = 0.0f;
        this.f8908f = 0.0f;
        this.f8909g = Float.NaN;
        this.f8913k = new Drawable[2];
        this.f8915m = true;
        this.f8916n = null;
        this.f8917o = null;
        this.f8918p = Float.NaN;
        this.f8919q = Float.NaN;
        this.f8920r = Float.NaN;
        this.f8921s = Float.NaN;
        c(context, attrs);
    }

    public a(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8906d = new b.c();
        this.f8907e = 0.0f;
        this.f8908f = 0.0f;
        this.f8909g = Float.NaN;
        this.f8913k = new Drawable[2];
        this.f8915m = true;
        this.f8916n = null;
        this.f8917o = null;
        this.f8918p = Float.NaN;
        this.f8919q = Float.NaN;
        this.f8920r = Float.NaN;
        this.f8921s = Float.NaN;
        c(context, attrs);
    }
}
