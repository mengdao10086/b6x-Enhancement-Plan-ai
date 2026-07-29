package com.daasuu.bl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleLayout extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f12765j = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrowDirection f12766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y4.a f12767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f12770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f12771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12774i;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12775a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f12775a = iArr;
            try {
                iArr[ArrowDirection.LEFT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12775a[ArrowDirection.RIGHT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12775a[ArrowDirection.TOP_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12775a[ArrowDirection.BOTTOM_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12775a[ArrowDirection.TOP_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12775a[ArrowDirection.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12775a[ArrowDirection.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12775a[ArrowDirection.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12775a[ArrowDirection.TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12775a[ArrowDirection.BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public static float a(float dp2, Context context) {
        return dp2 * (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    public final void b(int left, int right, int top2, int bottom) {
        float f10;
        float f11;
        float f12;
        if (right < left || bottom < top2) {
            return;
        }
        float f13 = right;
        RectF rectF = new RectF(left, top2, f13, bottom);
        float f14 = this.f12771f;
        switch (a.f12775a[this.f12766a.ordinal()]) {
            case 1:
            case 2:
                f10 = (bottom - top2) / 2.0f;
                f11 = this.f12770e;
                f12 = f10 - (f11 / 2.0f);
                break;
            case 3:
            case 4:
                f10 = (right - left) / 2.0f;
                f11 = this.f12768c;
                f12 = f10 - (f11 / 2.0f);
                break;
            case 5:
            case 6:
                f12 = (f13 - this.f12771f) - (this.f12768c / 2.0f);
                break;
            default:
                f12 = f14;
                break;
        }
        this.f12767b = new y4.a(rectF, this.f12768c, this.f12769d, this.f12770e, f12, this.f12773h, this.f12774i, this.f12772g, this.f12766a);
    }

    public final void c() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (a.f12775a[this.f12766a.ordinal()]) {
            case 1:
            case 7:
                paddingLeft = (int) (paddingLeft + this.f12768c);
                break;
            case 2:
            case 8:
                paddingRight = (int) (paddingRight + this.f12768c);
                break;
            case 3:
            case 5:
            case 9:
                paddingTop = (int) (paddingTop + this.f12770e);
                break;
            case 4:
            case 6:
            case 10:
                paddingBottom = (int) (paddingBottom + this.f12770e);
                break;
        }
        float f10 = this.f12773h;
        if (f10 > 0.0f) {
            paddingLeft = (int) (paddingLeft + f10);
            paddingRight = (int) (paddingRight + f10);
            paddingTop = (int) (paddingTop + f10);
            paddingBottom = (int) (paddingBottom + f10);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void d() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (a.f12775a[this.f12766a.ordinal()]) {
            case 1:
            case 7:
                paddingLeft = (int) (paddingLeft - this.f12768c);
                break;
            case 2:
            case 8:
                paddingRight = (int) (paddingRight - this.f12768c);
                break;
            case 3:
            case 5:
            case 9:
                paddingTop = (int) (paddingTop - this.f12770e);
                break;
            case 4:
            case 6:
            case 10:
                paddingBottom = (int) (paddingBottom - this.f12770e);
                break;
        }
        float f10 = this.f12773h;
        if (f10 > 0.0f) {
            paddingLeft = (int) (paddingLeft - f10);
            paddingRight = (int) (paddingRight - f10);
            paddingTop = (int) (paddingTop - f10);
            paddingBottom = (int) (paddingBottom - f10);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        y4.a aVar = this.f12767b;
        if (aVar != null) {
            aVar.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    public BubbleLayout e(ArrowDirection arrowDirection) {
        d();
        this.f12766a = arrowDirection;
        c();
        return this;
    }

    public BubbleLayout f(float arrowHeight) {
        d();
        this.f12770e = arrowHeight;
        c();
        return this;
    }

    public BubbleLayout g(float arrowPosition) {
        d();
        this.f12771f = arrowPosition;
        c();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.f12766a;
    }

    public float getArrowHeight() {
        return this.f12770e;
    }

    public float getArrowPosition() {
        return this.f12771f;
    }

    public float getArrowWidth() {
        return this.f12768c;
    }

    public int getBubbleColor() {
        return this.f12772g;
    }

    public float getCornersRadius() {
        return this.f12769d;
    }

    public int getStrokeColor() {
        return this.f12774i;
    }

    public float getStrokeWidth() {
        return this.f12773h;
    }

    public BubbleLayout h(float arrowWidth) {
        d();
        this.f12768c = arrowWidth;
        c();
        return this;
    }

    public BubbleLayout i(int bubbleColor) {
        this.f12772g = bubbleColor;
        requestLayout();
        return this;
    }

    public BubbleLayout j(float cornersRadius) {
        this.f12769d = cornersRadius;
        requestLayout();
        return this;
    }

    public BubbleLayout k(int strokeColor) {
        this.f12774i = strokeColor;
        requestLayout();
        return this;
    }

    public BubbleLayout l(float strokeWidth) {
        d();
        this.f12773h = strokeWidth;
        c();
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        super.onLayout(changed, left, top2, right, bottom);
        b(0, getWidth(), 0, getHeight());
    }

    public BubbleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BubbleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.BubbleLayout);
        this.f12768c = typedArrayObtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, a(8.0f, context));
        this.f12770e = typedArrayObtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, a(8.0f, context));
        this.f12769d = typedArrayObtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.f12771f = typedArrayObtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, a(12.0f, context));
        this.f12772g = typedArrayObtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.f12773h = typedArrayObtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, f12765j);
        this.f12774i = typedArrayObtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.f12766a = ArrowDirection.fromInt(typedArrayObtainStyledAttributes.getInt(R.styleable.BubbleLayout_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        typedArrayObtainStyledAttributes.recycle();
        c();
    }
}
