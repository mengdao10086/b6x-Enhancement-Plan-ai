package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.v0;
import ie.c;
import le.j;
import le.o;
import le.p;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeableImageView extends AppCompatImageView implements s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f20284v = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f20285w = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f20286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f20287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f20288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f20289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f20290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f20291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public ColorStateList f20292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public j f20293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f20294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @r
    public float f20295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Path f20296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @r
    public int f20297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @r
    public int f20298p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @r
    public int f20299q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @r
    public int f20300r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @r
    public int f20301s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @r
    public int f20302t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f20303u;

    @TargetApi(21)
    public class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f20304a = new Rect();

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f20294l == null) {
                return;
            }
            if (ShapeableImageView.this.f20293k == null) {
                ShapeableImageView.this.f20293k = new j(ShapeableImageView.this.f20294l);
            }
            ShapeableImageView.this.f20287e.round(this.f20304a);
            ShapeableImageView.this.f20293k.setBounds(this.f20304a);
            ShapeableImageView.this.f20293k.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    public final void g(Canvas canvas) {
        if (this.f20292j == null) {
            return;
        }
        this.f20289g.setStrokeWidth(this.f20295m);
        int colorForState = this.f20292j.getColorForState(getDrawableState(), this.f20292j.getDefaultColor());
        if (this.f20295m <= 0.0f || colorForState == 0) {
            return;
        }
        this.f20289g.setColor(colorForState);
        canvas.drawPath(this.f20291i, this.f20289g);
    }

    @r
    public int getContentPaddingBottom() {
        return this.f20300r;
    }

    @r
    public final int getContentPaddingEnd() {
        int i10 = this.f20302t;
        return i10 != Integer.MIN_VALUE ? i10 : i() ? this.f20297o : this.f20299q;
    }

    @r
    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f20302t) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f20301s) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f20297o;
    }

    @r
    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f20301s) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f20302t) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f20299q;
    }

    @r
    public final int getContentPaddingStart() {
        int i10 = this.f20301s;
        return i10 != Integer.MIN_VALUE ? i10 : i() ? this.f20299q : this.f20297o;
    }

    @r
    public int getContentPaddingTop() {
        return this.f20298p;
    }

    @Override // android.view.View
    @r
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @r
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @r
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @r
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @r
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @r
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        return this.f20294l;
    }

    @p0
    public ColorStateList getStrokeColor() {
        return this.f20292j;
    }

    @r
    public float getStrokeWidth() {
        return this.f20295m;
    }

    public final boolean h() {
        return (this.f20301s == Integer.MIN_VALUE && this.f20302t == Integer.MIN_VALUE) ? false : true;
    }

    public final boolean i() {
        return getLayoutDirection() == 1;
    }

    public void j(@r int i10, @r int i11, @r int i12, @r int i13) {
        this.f20301s = Integer.MIN_VALUE;
        this.f20302t = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.f20297o) + i10, (super.getPaddingTop() - this.f20298p) + i11, (super.getPaddingRight() - this.f20299q) + i12, (super.getPaddingBottom() - this.f20300r) + i13);
        this.f20297o = i10;
        this.f20298p = i11;
        this.f20299q = i12;
        this.f20300r = i13;
    }

    @v0(17)
    public void k(@r int i10, @r int i11, @r int i12, @r int i13) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i10, (super.getPaddingTop() - this.f20298p) + i11, (super.getPaddingEnd() - getContentPaddingEnd()) + i12, (super.getPaddingBottom() - this.f20300r) + i13);
        this.f20297o = i() ? i12 : i10;
        this.f20298p = i11;
        if (!i()) {
            i10 = i12;
        }
        this.f20299q = i10;
        this.f20300r = i13;
    }

    public final void l(int i10, int i11) {
        this.f20287e.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f20286d.d(this.f20294l, 1.0f, this.f20287e, this.f20291i);
        this.f20296n.rewind();
        this.f20296n.addPath(this.f20291i);
        this.f20288f.set(0.0f, 0.0f, i10, i11);
        this.f20296n.addRect(this.f20288f, Path.Direction.CCW);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f20296n, this.f20290h);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f20303u && isLayoutDirectionResolved()) {
            this.f20303u = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        l(i10, i11);
    }

    @Override // android.view.View
    public void setPadding(@r int i10, @r int i11, @r int i12, @r int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(@r int i10, @r int i11, @r int i12, @r int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        this.f20294l = oVar;
        j jVar = this.f20293k;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        l(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@p0 ColorStateList colorStateList) {
        this.f20292j = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@n int i10) {
        setStrokeColor(i.a.a(getContext(), i10));
    }

    public void setStrokeWidth(@r float f10) {
        if (this.f20295m != f10) {
            this.f20295m = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@q int i10) {
        setStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public ShapeableImageView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f20284v;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20286d = p.k();
        this.f20291i = new Path();
        this.f20303u = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f20290h = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f20287e = new RectF();
        this.f20288f = new RectF();
        this.f20296n = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i10, i11);
        setLayerType(2, null);
        this.f20292j = c.a(context2, typedArrayObtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.f20295m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
        this.f20297o = dimensionPixelSize;
        this.f20298p = dimensionPixelSize;
        this.f20299q = dimensionPixelSize;
        this.f20300r = dimensionPixelSize;
        this.f20297o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.f20298p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.f20299q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.f20300r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.f20301s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.f20302t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f20289g = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f20294l = o.e(context2, attributeSet, i10, i11).m();
        setOutlineProvider(new a());
    }
}
