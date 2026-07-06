package androidx.cardview.widget;

import a.l9;
import a.m9;
import a.o9;
import a.p9;
import a.r9;
import a.s9;
import a.u9;
import a.v9;
import a.w9;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w9 f8181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f4138a = {R.attr.colorBackground};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v9 f4140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4141a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4142b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4143b;
    public boolean c;

    public class a implements v9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f8182a;

        public a() {
        }

        @Override // a.v9
        public void a(int i, int i2, int i3, int i4) {
            CardView.this.f4142b.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f4141a;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        @Override // a.v9
        public Drawable b() {
            return this.f8182a;
        }

        @Override // a.v9
        public boolean c() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // a.v9
        public boolean d() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // a.v9
        public void e(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.f4139a) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.b) {
                CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // a.v9
        public void f(Drawable drawable) {
            this.f8182a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // a.v9
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f8181a = i >= 21 ? new s9() : i >= 17 ? new r9() : new u9();
        f8181a.c();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l9.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        Resources resources;
        int i2;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        this.f4141a = new Rect();
        this.f4142b = new Rect();
        this.f4140a = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p9.CardView, i, o9.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(p9.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(p9.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f4138a);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i2 = m9.cardview_light_background;
            } else {
                resources = getResources();
                i2 = m9.cardview_dark_background;
            }
            colorStateListValueOf = ColorStateList.valueOf(resources.getColor(i2));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(p9.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(p9.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(p9.CardView_cardMaxElevation, 0.0f);
        this.f4143b = typedArrayObtainStyledAttributes.getBoolean(p9.CardView_cardUseCompatPadding, false);
        this.c = typedArrayObtainStyledAttributes.getBoolean(p9.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_contentPadding, 0);
        this.f4141a.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f4141a.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_contentPaddingTop, dimensionPixelSize);
        this.f4141a.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_contentPaddingRight, dimensionPixelSize);
        this.f4141a.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f4139a = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_android_minWidth, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(p9.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f8181a.b(this.f4140a, context, colorStateList, dimension, dimension2, f);
    }

    public ColorStateList getCardBackgroundColor() {
        return f8181a.j(this.f4140a);
    }

    public float getCardElevation() {
        return f8181a.i(this.f4140a);
    }

    public int getContentPaddingBottom() {
        return this.f4141a.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f4141a.left;
    }

    public int getContentPaddingRight() {
        return this.f4141a.right;
    }

    public int getContentPaddingTop() {
        return this.f4141a.top;
    }

    public float getMaxCardElevation() {
        return f8181a.m(this.f4140a);
    }

    public boolean getPreventCornerOverlap() {
        return this.c;
    }

    public float getRadius() {
        return f8181a.d(this.f4140a);
    }

    public boolean getUseCompatPadding() {
        return this.f4143b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!(f8181a instanceof s9)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f8181a.h(this.f4140a)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f8181a.l(this.f4140a)), View.MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f8181a.f(this.f4140a, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f8181a.f(this.f4140a, colorStateList);
    }

    public void setCardElevation(float f) {
        f8181a.n(this.f4140a, f);
    }

    public void setMaxCardElevation(float f) {
        f8181a.g(this.f4140a, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.b = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f4139a = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.c) {
            this.c = z;
            f8181a.k(this.f4140a);
        }
    }

    public void setRadius(float f) {
        f8181a.a(this.f4140a, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f4143b != z) {
            this.f4143b = z;
            f8181a.e(this.f4140a);
        }
    }
}
