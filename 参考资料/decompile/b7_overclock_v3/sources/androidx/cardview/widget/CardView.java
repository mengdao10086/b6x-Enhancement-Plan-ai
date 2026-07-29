package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import g.l;
import g.n0;
import g.p0;
import g.t0;
import r.b;
import r.d;
import r.e;

/* JADX INFO: loaded from: classes2.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f2782h = {R.attr.colorBackground};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f2783i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f2788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f2789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f2790g;

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f2791a;

        public a() {
        }

        @Override // r.d
        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f2789f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2788e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        @Override // r.d
        public void b(int i10, int i11) {
            CardView cardView = CardView.this;
            if (i10 > cardView.f2786c) {
                CardView.super.setMinimumWidth(i10);
            }
            CardView cardView2 = CardView.this;
            if (i11 > cardView2.f2787d) {
                CardView.super.setMinimumHeight(i11);
            }
        }

        @Override // r.d
        public void c(Drawable drawable) {
            this.f2791a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // r.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // r.d
        public boolean e() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // r.d
        public Drawable f() {
            return this.f2791a;
        }

        @Override // r.d
        public View g() {
            return CardView.this;
        }
    }

    static {
        b bVar = new b();
        f2783i = bVar;
        bVar.l();
    }

    public CardView(@n0 Context context) {
        this(context, null);
    }

    @n0
    public ColorStateList getCardBackgroundColor() {
        return f2783i.c(this.f2790g);
    }

    public float getCardElevation() {
        return f2783i.d(this.f2790g);
    }

    @t0
    public int getContentPaddingBottom() {
        return this.f2788e.bottom;
    }

    @t0
    public int getContentPaddingLeft() {
        return this.f2788e.left;
    }

    @t0
    public int getContentPaddingRight() {
        return this.f2788e.right;
    }

    @t0
    public int getContentPaddingTop() {
        return this.f2788e.top;
    }

    public float getMaxCardElevation() {
        return f2783i.g(this.f2790g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2785b;
    }

    public float getRadius() {
        return f2783i.k(this.f2790g);
    }

    public boolean getUseCompatPadding() {
        return this.f2784a;
    }

    public void h(@t0 int i10, @t0 int i11, @t0 int i12, @t0 int i13) {
        this.f2788e.set(i10, i11, i12, i13);
        f2783i.m(this.f2790g);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (f2783i instanceof b) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.h(this.f2790g)), View.MeasureSpec.getSize(i10)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.b(this.f2790g)), View.MeasureSpec.getSize(i11)), mode2);
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(@l int i10) {
        f2783i.o(this.f2790g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f2783i.e(this.f2790g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f2783i.n(this.f2790g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f2787d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f2786c = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f2785b) {
            this.f2785b = z10;
            f2783i.f(this.f2790g);
        }
    }

    public void setRadius(float f10) {
        f2783i.j(this.f2790g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f2784a != z10) {
            this.f2784a = z10;
            f2783i.i(this.f2790g);
        }
    }

    public CardView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@p0 ColorStateList colorStateList) {
        f2783i.o(this.f2790g, colorStateList);
    }

    public CardView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i10);
        Rect rect = new Rect();
        this.f2788e = rect;
        this.f2789f = new Rect();
        a aVar = new a();
        this.f2790g = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i10, androidx.cardview.R.style.CardView);
        int i11 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2782h);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f2784a = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f2785b = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2786c = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f2787d = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f2783i.a(aVar, context, colorStateList, dimension, dimension2, f10);
    }
}
