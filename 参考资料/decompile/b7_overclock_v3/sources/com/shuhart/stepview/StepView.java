package com.shuhart.stepview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.u0;
import g.l;
import g.p0;
import g.r;
import j0.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import m0.g;

/* JADX INFO: loaded from: classes5.dex */
public class StepView extends View {
    public static final int F7 = 0;
    public static final int G7 = 1;
    public static final int H7 = 2;
    public static final int I7 = 3;
    public static final int J7 = 0;
    public static final int K7 = 1;
    public static final int L7 = 0;
    public static final int M7 = 1;
    public static final int N7 = 0;

    @l
    public int A;
    public Paint B;
    public TextPaint C;
    public int C1;
    public boolean C2;
    public ValueAnimator D;
    public Rect E7;
    public int[] K0;
    public int K1;
    public StaticLayout[] K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f22298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f22300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public int f22306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @r
    public int f22307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public int f22308k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int[] f22309k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int[] f22310k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public int f22311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @r
    public int f22312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public int f22313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @l
    public int f22314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @r
    public int f22315p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @l
    public int f22316q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @l
    public int f22317r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @r
    public int f22318s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @r(unit = 2)
    public float f22319t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @r
    public int f22320u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f22321v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float[] f22322v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public float f22323v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @r(unit = 2)
    public float f22324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public int f22325x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f22326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f22327z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StepView.this.f22323v2 = valueAnimator.getAnimatedFraction();
            StepView.this.invalidate();
        }
    }

    public class b extends vg.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22329a;

        public b(int i10) {
            this.f22329a = i10;
        }

        @Override // vg.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StepView.this.f22304g = 1;
            StepView.this.f22302e = this.f22329a;
            StepView.this.invalidate();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public interface e {
        void a(int i10);
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f22331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public int f22334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @r
        public int f22335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @l
        public int f22336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @l
        public int f22337g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @r
        public int f22338h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @l
        public int f22339i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @l
        public int f22340j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @r
        public int f22341k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @l
        public int f22342l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @l
        public int f22343m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @r
        public int f22344n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @r(unit = 2)
        public float f22345o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @r
        public int f22346p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @l
        public int f22347q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @r(unit = 2)
        public float f22348r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @l
        public int f22349s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f22350t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f22351u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @l
        public int f22352v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Typeface f22353w;

        public f() {
            this.f22333c = StepView.this.f22305h;
            this.f22334d = StepView.this.f22306i;
            this.f22335e = StepView.this.f22307j;
            this.f22336f = StepView.this.f22308k;
            this.f22337g = StepView.this.f22311l;
            this.f22338h = StepView.this.f22312m;
            this.f22339i = StepView.this.f22313n;
            this.f22340j = StepView.this.f22314o;
            this.f22341k = StepView.this.f22315p;
            this.f22342l = StepView.this.f22316q;
            this.f22343m = StepView.this.f22317r;
            this.f22344n = StepView.this.f22318s;
            this.f22345o = StepView.this.f22319t;
            this.f22346p = StepView.this.f22320u;
            this.f22347q = StepView.this.f22321v;
            this.f22348r = StepView.this.f22324w;
            this.f22349s = StepView.this.f22325x;
            this.f22350t = StepView.this.f22326y;
            this.f22351u = StepView.this.f22327z;
            this.f22352v = StepView.this.A;
            this.f22353w = StepView.this.B.getTypeface();
        }

        public f a(int i10) {
            this.f22350t = i10;
            return this;
        }

        public f b(int i10) {
            this.f22333c = i10;
            return this;
        }

        public void c() {
            StepView.this.f22305h = this.f22333c;
            StepView.this.f22308k = this.f22336f;
            StepView.this.f22307j = this.f22335e;
            StepView.this.f22306i = this.f22334d;
            StepView.this.f22311l = this.f22337g;
            StepView.this.f22312m = this.f22338h;
            StepView.this.f22313n = this.f22339i;
            StepView.this.f22314o = this.f22340j;
            StepView.this.f22315p = this.f22341k;
            StepView.this.f22316q = this.f22342l;
            StepView.this.f22317r = this.f22343m;
            StepView.this.f22318s = this.f22344n;
            StepView.this.f22319t = this.f22345o;
            StepView.this.f22320u = this.f22346p;
            StepView.this.f22321v = this.f22347q;
            StepView.this.f22324w = this.f22348r;
            StepView.this.f22325x = this.f22349s;
            StepView.this.f22326y = this.f22350t;
            StepView.this.setTypeface(this.f22353w);
            StepView.this.f22327z = this.f22351u;
            StepView.this.A = this.f22352v;
            if (this.f22331a != null && !StepView.this.f22300c.equals(this.f22331a)) {
                StepView.this.setSteps(this.f22331a);
                return;
            }
            int i10 = this.f22332b;
            if (i10 == 0 || i10 == StepView.this.f22301d) {
                StepView.this.invalidate();
            } else {
                StepView.this.setStepsNumber(this.f22332b);
            }
        }

        public f d(@l int i10) {
            this.f22337g = i10;
            return this;
        }

        public f e(@r int i10) {
            this.f22338h = i10;
            return this;
        }

        public f f(@l int i10) {
            this.f22343m = i10;
            return this;
        }

        public f g(@l int i10) {
            this.f22349s = i10;
            return this;
        }

        public f h(@l int i10) {
            this.f22339i = i10;
            return this;
        }

        public f i(@l int i10) {
            this.f22352v = i10;
            return this;
        }

        public f j(boolean z10) {
            this.f22351u = z10;
            return this;
        }

        public f k(@l int i10) {
            this.f22342l = i10;
            return this;
        }

        public f l(@l int i10) {
            this.f22340j = i10;
            return this;
        }

        public f m(@l int i10) {
            this.f22334d = i10;
            return this;
        }

        public f n(@r int i10) {
            this.f22335e = i10;
            return this;
        }

        public f o(@l int i10) {
            this.f22347q = i10;
            return this;
        }

        public f p(@l int i10) {
            this.f22336f = i10;
            return this;
        }

        public f q(@r int i10) {
            this.f22344n = i10;
            return this;
        }

        public f r(@r(unit = 2) int i10) {
            this.f22348r = i10;
            return this;
        }

        public f s(@r int i10) {
            this.f22341k = i10;
            return this;
        }

        public f t(List<String> list) {
            this.f22331a = list;
            return this;
        }

        public f u(int i10) {
            this.f22332b = i10;
            return this;
        }

        public f v(@r int i10) {
            this.f22346p = i10;
            return this;
        }

        public f w(@r(unit = 2) int i10) {
            this.f22345o = i10;
            return this;
        }

        public f x(Typeface typeface) {
            this.f22353w = typeface;
            return this;
        }
    }

    public StepView(Context context) {
        this(context, null);
    }

    private int[] getCirclePositions() {
        int i10;
        int i11;
        int stepCount = getStepCount();
        int[] iArr = new int[stepCount];
        if (stepCount == 0) {
            return iArr;
        }
        iArr[0] = getStartCirclePosition();
        int i12 = 1;
        if (stepCount == 1) {
            return iArr;
        }
        int i13 = stepCount - 1;
        iArr[i13] = getEndCirclePosition();
        if (stepCount < 3) {
            return iArr;
        }
        if (j0()) {
            i10 = iArr[0];
            i11 = iArr[i13];
        } else {
            i10 = iArr[i13];
            i11 = iArr[0];
        }
        int i14 = (int) ((i10 - i11) / i13);
        if (j0()) {
            while (i12 < i13) {
                iArr[i12] = iArr[i12 - 1] - i14;
                i12++;
            }
        } else {
            while (i12 < i13) {
                iArr[i12] = iArr[i12 - 1] + i14;
                i12++;
            }
        }
        return iArr;
    }

    private int getCircleY() {
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (this.f22299b == 1) {
            return measuredHeight / 2;
        }
        return getPaddingTop() + ((measuredHeight - ((getMaxTextHeight() + Math.max(this.f22307j, this.f22312m)) + this.f22320u)) / 2) + this.f22307j;
    }

    private int getEndCirclePosition() {
        int measuredWidth;
        int iMax;
        int paddingLeft;
        int iMax2;
        if (this.f22299b == 0) {
            if (j0()) {
                paddingLeft = getPaddingLeft();
                iMax2 = Math.max(g0((StaticLayout) k0(this.K2)) / 2, this.f22307j);
                return paddingLeft + iMax2;
            }
            measuredWidth = getMeasuredWidth() - getPaddingRight();
            iMax = Math.max(g0((StaticLayout) k0(this.K2)) / 2, this.f22307j);
            return measuredWidth - iMax;
        }
        if (j0()) {
            paddingLeft = getPaddingLeft();
            iMax2 = this.f22307j;
            return paddingLeft + iMax2;
        }
        measuredWidth = getMeasuredWidth() - getPaddingRight();
        iMax = this.f22307j;
        return measuredWidth - iMax;
    }

    private int getMaxTextHeight() {
        StaticLayout[] staticLayoutArr = this.K2;
        if (staticLayoutArr == null || staticLayoutArr.length == 0) {
            return 0;
        }
        int iMax = 0;
        for (StaticLayout staticLayout : staticLayoutArr) {
            iMax = Math.max(staticLayout.getHeight(), iMax);
        }
        return iMax;
    }

    private int getStartCirclePosition() {
        int paddingLeft;
        int iMax;
        int measuredWidth;
        int iMax2;
        if (this.f22299b == 0) {
            if (j0()) {
                measuredWidth = getMeasuredWidth() - getPaddingRight();
                iMax2 = Math.max(g0(this.K2[0]) / 2, this.f22307j);
                return measuredWidth - iMax2;
            }
            paddingLeft = getPaddingLeft();
            iMax = Math.max(g0(this.K2[0]) / 2, this.f22307j);
            return paddingLeft + iMax;
        }
        if (j0()) {
            measuredWidth = getMeasuredWidth() - getPaddingRight();
            iMax2 = this.f22307j;
            return measuredWidth - iMax2;
        }
        paddingLeft = getPaddingLeft();
        iMax = this.f22307j;
        return paddingLeft + iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeface(Typeface typeface) {
        if (typeface != null) {
            this.C.setTypeface(typeface);
            this.B.setTypeface(typeface);
        }
    }

    public final void V(int i10) {
        e0();
        ValueAnimator valueAnimatorF0 = f0(i10);
        this.D = valueAnimatorF0;
        if (valueAnimatorF0 == null) {
            return;
        }
        valueAnimatorF0.addUpdateListener(new a());
        this.D.addListener(new b(i10));
        this.D.setDuration(this.f22326y);
        this.D.start();
    }

    public final void W(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepView, i10, R.style.StepView);
        this.f22306i = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_selectedCircleColor, 0);
        this.f22307j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepView_sv_selectedCircleRadius, 0);
        this.f22308k = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_selectedTextColor, 0);
        this.f22321v = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_selectedStepNumberColor, 0);
        this.f22325x = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_doneStepMarkColor, 0);
        this.f22311l = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_doneCircleColor, 0);
        this.f22312m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepView_sv_doneCircleRadius, 0);
        this.f22313n = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_doneTextColor, 0);
        this.f22314o = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_nextTextColor, 0);
        this.f22315p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepView_sv_stepPadding, 0);
        this.f22316q = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_nextStepLineColor, 0);
        this.f22317r = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_doneStepLineColor, 0);
        this.f22318s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepView_sv_stepLineWidth, 0);
        this.f22320u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepView_sv_textPadding, 0);
        this.f22324w = typedArrayObtainStyledAttributes.getDimension(R.styleable.StepView_sv_stepNumberTextSize, 0.0f);
        this.f22319t = typedArrayObtainStyledAttributes.getDimension(R.styleable.StepView_sv_textSize, 0.0f);
        this.f22326y = typedArrayObtainStyledAttributes.getInteger(R.styleable.StepView_sv_animationDuration, 0);
        this.f22305h = typedArrayObtainStyledAttributes.getInteger(R.styleable.StepView_sv_animationType, 0);
        this.f22301d = typedArrayObtainStyledAttributes.getInteger(R.styleable.StepView_sv_stepsNumber, 0);
        this.f22327z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepView_sv_nextStepCircleEnabled, false);
        this.A = typedArrayObtainStyledAttributes.getColor(R.styleable.StepView_sv_nextStepCircleColor, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(R.styleable.StepView_sv_steps);
        if (textArray != null) {
            for (CharSequence charSequence : textArray) {
                this.f22300c.add(charSequence.toString());
            }
            this.f22299b = 0;
        } else {
            this.f22299b = 1;
        }
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepView_sv_background);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepView_sv_typeface, 0);
        if (resourceId != 0) {
            setTypeface(i.j(context, resourceId));
        }
        this.C.setTextSize(this.f22319t);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void X(boolean z10) {
        this.C2 = z10;
        invalidate();
    }

    public final void Y(Canvas canvas, int i10, int i11) {
        this.B.setColor(this.f22325x);
        float f10 = this.f22324w * 0.1f;
        this.B.setStrokeWidth(f10);
        double d10 = i10;
        double d11 = f10;
        double d12 = 4.5d * d11;
        double d13 = i11;
        double d14 = d11 * 3.5d;
        Rect rect = new Rect((int) (d10 - d12), (int) (d13 - d14), (int) (d10 + d12), (int) (d13 + d14));
        int i12 = rect.left;
        float f11 = i12 + (0.5f * f10);
        int i13 = rect.bottom;
        float f12 = 3.25f * f10;
        float f13 = i13 - f12;
        float f14 = i12 + f12;
        float f15 = i13;
        float f16 = 0.75f * f10;
        canvas.drawLine(f11, f13, f14, f15 - f16, this.B);
        canvas.drawLine(rect.left + (2.75f * f10), rect.bottom - f16, rect.right - (f10 * 0.375f), rect.top + f16, this.B);
    }

    public final void Z() {
        if (isInEditMode()) {
            if (this.f22299b != 0) {
                if (this.f22301d == 0) {
                    this.f22301d = 4;
                }
                setStepsNumber(this.f22301d);
            } else {
                if (this.f22300c.isEmpty()) {
                    this.f22300c.add("Step 1");
                    this.f22300c.add("Step 2");
                    this.f22300c.add("Step 3");
                }
                setSteps(this.f22300c);
            }
        }
    }

    public final void a0(Canvas canvas, int i10, int i11, int i12, boolean z10) {
        if (z10) {
            this.B.setColor(this.f22317r);
            this.B.setStrokeWidth(this.f22318s);
            float f10 = i12;
            canvas.drawLine(i10, f10, i11, f10, this.B);
            return;
        }
        this.B.setColor(this.f22316q);
        this.B.setStrokeWidth(this.f22318s);
        float f11 = i12;
        canvas.drawLine(i10, f11, i11, f11, this.B);
    }

    public final void b0(Canvas canvas, String str, int i10, Paint paint) {
        paint.getTextBounds(str, 0, str.length(), this.E7);
        canvas.drawText(str, i10, (this.C1 + (this.E7.height() / 2.0f)) - this.E7.bottom, paint);
    }

    public final void c0(Canvas canvas, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.f22299b == 0 ? this.f22300c.get(i10) : "";
        int i20 = this.f22302e;
        boolean z10 = false;
        boolean z11 = i10 == i20;
        if (!this.C2 ? i10 < i20 : i10 <= i20) {
            z10 = true;
        }
        String strValueOf = String.valueOf(i10 + 1);
        if (z11 && !z10) {
            this.B.setColor(this.f22306i);
            if (this.f22304g != 0 || (!((i18 = this.f22305h) == 1 || i18 == 2) || this.f22303f >= this.f22302e)) {
                i17 = this.f22307j;
            } else {
                boolean z12 = this.f22327z;
                if (!z12 || this.A == 0) {
                    int i21 = this.f22307j;
                    i17 = (int) (i21 - (i21 * this.f22323v2));
                } else {
                    i17 = this.f22307j;
                }
                if (z12 && (i19 = this.A) != 0) {
                    this.B.setColor(g.i(this.f22306i, i19, this.f22323v2));
                }
            }
            canvas.drawCircle(i11, i12, i17, this.B);
            this.B.setColor(this.f22321v);
            this.B.setTextSize(this.f22324w);
            b0(canvas, strValueOf, i11, this.B);
            this.C.setTextSize(this.f22319t);
            this.C.setColor(this.f22308k);
            d0(canvas, str, this.K1, i10);
            return;
        }
        if (z10) {
            this.B.setColor(this.f22311l);
            canvas.drawCircle(i11, i12, this.f22312m, this.B);
            Y(canvas, i11, i12);
            if (this.f22304g == 0 && i10 == (i16 = this.f22303f) && i16 < this.f22302e) {
                this.B.setColor(this.f22308k);
                this.B.setAlpha(Math.max(Color.alpha(this.f22313n), (int) (this.f22323v2 * 255.0f)));
            } else {
                this.B.setColor(this.f22313n);
            }
            this.C.setTextSize(this.f22319t);
            this.C.setColor(this.f22313n);
            d0(canvas, str, this.K1, i10);
            return;
        }
        if (this.f22304g != 0 || i10 != (i14 = this.f22303f) || i14 <= this.f22302e) {
            if (this.f22327z && (i13 = this.A) != 0) {
                this.B.setColor(i13);
                canvas.drawCircle(i11, i12, this.f22307j, this.B);
            }
            this.B.setColor(this.f22314o);
            this.B.setTextSize(this.f22324w);
            b0(canvas, strValueOf, i11, this.B);
            this.C.setTextSize(this.f22319t);
            this.C.setColor(this.f22314o);
            d0(canvas, str, this.K1, i10);
            return;
        }
        int i22 = this.f22305h;
        if (i22 == 1 || i22 == 2) {
            if (!this.f22327z || (i15 = this.A) == 0) {
                int i23 = (int) (this.f22307j * this.f22323v2);
                this.B.setColor(this.f22306i);
                canvas.drawCircle(i11, i12, i23, this.B);
            } else {
                this.B.setColor(g.i(i15, this.f22306i, this.f22323v2));
                canvas.drawCircle(i11, i12, this.f22307j, this.B);
            }
        }
        int i24 = this.f22305h;
        if (i24 == 3) {
            this.B.setTextSize(this.f22324w);
            this.B.setColor(this.f22314o);
            b0(canvas, strValueOf, i11, this.B);
        } else if (i24 == 1 || i24 == 2) {
            this.B.setColor(this.f22321v);
            this.B.setAlpha((int) (this.f22323v2 * 255.0f));
            this.B.setTextSize(this.f22324w * this.f22323v2);
            b0(canvas, strValueOf, i11, this.B);
        } else {
            this.B.setTextSize(this.f22324w);
            this.B.setColor(this.f22314o);
            b0(canvas, strValueOf, i11, this.B);
        }
        this.C.setTextSize(this.f22319t);
        this.C.setColor(this.f22314o);
        this.C.setAlpha((int) Math.max(Color.alpha(this.f22314o), this.f22323v2 * 255.0f));
        d0(canvas, str, this.K1, i10);
    }

    public final void d0(Canvas canvas, String str, int i10, int i11) {
        if (str.isEmpty()) {
            return;
        }
        StaticLayout staticLayout = this.K2[i11];
        canvas.save();
        canvas.translate(this.f22309k0[i11], i10);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public final void e0() {
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.D.end();
    }

    @p0
    public final ValueAnimator f0(int i10) {
        int i11 = this.f22302e;
        if (i10 > i11) {
            int i12 = this.f22305h;
            if (i12 == 0) {
                int i13 = i10 - 1;
                return ValueAnimator.ofInt(this.K0[i13], this.f22310k1[i13]);
            }
            if (i12 == 1) {
                return ValueAnimator.ofInt(0, this.f22307j);
            }
            if (i12 == 2) {
                int i14 = i10 - 1;
                return ValueAnimator.ofInt(0, ((this.f22310k1[i14] - this.K0[i14]) + this.f22307j) / 2);
            }
        } else if (i10 < i11) {
            int i15 = this.f22305h;
            if (i15 == 0) {
                return ValueAnimator.ofInt(this.f22310k1[i10], this.K0[i10]);
            }
            if (i15 == 1) {
                return ValueAnimator.ofInt(0, this.f22307j);
            }
            if (i15 == 2) {
                return ValueAnimator.ofInt(0, ((this.f22310k1[i10] - this.K0[i10]) + this.f22307j) / 2);
            }
        }
        return null;
    }

    public final int g0(StaticLayout staticLayout) {
        int lineCount = staticLayout.getLineCount();
        int iMax = 0;
        for (int i10 = 0; i10 < lineCount; i10++) {
            iMax = (int) Math.max(staticLayout.getLineWidth(i10), iMax);
        }
        return iMax;
    }

    public int getCurrentStep() {
        return this.f22302e;
    }

    public f getState() {
        return new f();
    }

    public int getStepCount() {
        return this.f22299b == 0 ? this.f22300c.size() : this.f22301d;
    }

    public int h0(float f10, float f11) {
        int stepCount = getStepCount();
        int i10 = 0;
        while (true) {
            float[] fArr = this.f22322v1;
            if (i10 >= fArr.length) {
                return stepCount - 1;
            }
            if (f10 <= fArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    public void i0(int i10, boolean z10) {
        if (i10 < 0 || i10 >= getStepCount()) {
            return;
        }
        if (!z10 || this.f22305h == 3 || this.K0 == null) {
            this.f22302e = i10;
            invalidate();
        } else if (Math.abs(i10 - this.f22302e) > 1) {
            e0();
            this.f22302e = i10;
            invalidate();
        } else {
            this.f22303f = i10;
            this.f22304g = 0;
            V(i10);
            invalidate();
        }
    }

    @TargetApi(17)
    public final boolean j0() {
        return u0.Z(this) == 1;
    }

    public final <T> T k0(T[] tArr) {
        return tArr[tArr.length - 1];
    }

    public final void l0() {
        int circleY = getCircleY();
        this.C1 = circleY;
        if (this.f22299b == 1) {
            this.C1 = circleY + getPaddingTop();
        }
        this.f22309k0 = getCirclePositions();
        if (this.f22299b == 1) {
            this.B.setTextSize(this.f22324w);
        } else {
            this.B.setTextSize(this.f22324w);
            this.B.setTextSize(this.f22319t);
            this.K1 = this.C1 + this.f22307j + this.f22320u;
        }
        o0();
    }

    public final void m0(int i10) {
        float[] fArr = new float[getStepCount()];
        this.f22322v1 = fArr;
        fArr[0] = i10 / getStepCount();
        int i11 = 1;
        while (true) {
            float[] fArr2 = this.f22322v1;
            if (i11 >= fArr2.length) {
                return;
            }
            int i12 = i11 + 1;
            fArr2[i11] = fArr2[0] * i12;
            i11 = i12;
        }
    }

    public final int n0(int i10) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom() + (Math.max(this.f22307j, this.f22312m) * 2) + (this.f22299b == 0 ? this.f22320u : 0);
        if (!this.f22300c.isEmpty()) {
            paddingTop += p0();
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(paddingTop, size);
        }
        if (mode == 0) {
            return paddingTop;
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final void o0() {
        this.K0 = new int[getStepCount() - 1];
        this.f22310k1 = new int[getStepCount() - 1];
        int i10 = this.f22315p + this.f22307j;
        for (int i11 = 1; i11 < getStepCount(); i11++) {
            if (j0()) {
                int[] iArr = this.K0;
                int i12 = i11 - 1;
                int[] iArr2 = this.f22309k0;
                iArr[i12] = iArr2[i12] - i10;
                this.f22310k1[i12] = iArr2[i11] + i10;
            } else {
                int[] iArr3 = this.K0;
                int i13 = i11 - 1;
                int[] iArr4 = this.f22309k0;
                iArr3[i13] = iArr4[i13] + i10;
                this.f22310k1[i13] = iArr4[i11] - i10;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.D.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            int r0 = r8.getHeight()
            if (r0 != 0) goto L7
            return
        L7:
            int r0 = r8.getStepCount()
            if (r0 != 0) goto Le
            return
        Le:
            r1 = 0
            r2 = 0
        L10:
            if (r2 >= r0) goto L1e
            int[] r3 = r8.f22309k0
            r3 = r3[r2]
            int r4 = r8.C1
            r8.c0(r9, r2, r3, r4)
            int r2 = r2 + 1
            goto L10
        L1e:
            r6 = 0
        L1f:
            int[] r0 = r8.K0
            int r1 = r0.length
            if (r6 >= r1) goto Lc0
            int r1 = r8.f22304g
            r2 = 2
            if (r1 != 0) goto L62
            int r3 = r8.f22303f
            int r4 = r3 + (-1)
            if (r6 != r4) goto L62
            int r4 = r8.f22302e
            if (r3 <= r4) goto L62
            int r3 = r8.f22305h
            if (r3 == 0) goto L39
            if (r3 != r2) goto L62
        L39:
            r1 = r0[r6]
            float r1 = (float) r1
            float r2 = r8.f22323v2
            int[] r3 = r8.f22310k1
            r3 = r3[r6]
            r4 = r0[r6]
            int r3 = r3 - r4
            float r3 = (float) r3
            float r2 = r2 * r3
            float r1 = r1 + r2
            int r7 = (int) r1
            r2 = r0[r6]
            int r4 = r8.C1
            r5 = 1
            r0 = r8
            r1 = r9
            r3 = r7
            r0.a0(r1, r2, r3, r4, r5)
            int[] r0 = r8.f22310k1
            r3 = r0[r6]
            int r4 = r8.C1
            r5 = 0
            r0 = r8
            r2 = r7
            r0.a0(r1, r2, r3, r4, r5)
            goto Lbc
        L62:
            if (r1 != 0) goto L9b
            int r1 = r8.f22303f
            if (r6 != r1) goto L9b
            int r3 = r8.f22302e
            if (r1 >= r3) goto L9b
            int r1 = r8.f22305h
            if (r1 == 0) goto L72
            if (r1 != r2) goto L9b
        L72:
            int[] r1 = r8.f22310k1
            r2 = r1[r6]
            float r2 = (float) r2
            float r3 = r8.f22323v2
            r1 = r1[r6]
            r4 = r0[r6]
            int r1 = r1 - r4
            float r1 = (float) r1
            float r3 = r3 * r1
            float r2 = r2 - r3
            int r7 = (int) r2
            r2 = r0[r6]
            int r4 = r8.C1
            r5 = 1
            r0 = r8
            r1 = r9
            r3 = r7
            r0.a0(r1, r2, r3, r4, r5)
            int[] r0 = r8.f22310k1
            r3 = r0[r6]
            int r4 = r8.C1
            r5 = 0
            r0 = r8
            r2 = r7
            r0.a0(r1, r2, r3, r4, r5)
            goto Lbc
        L9b:
            int r1 = r8.f22302e
            if (r6 >= r1) goto Lae
            r2 = r0[r6]
            int[] r0 = r8.f22310k1
            r3 = r0[r6]
            int r4 = r8.C1
            r5 = 1
            r0 = r8
            r1 = r9
            r0.a0(r1, r2, r3, r4, r5)
            goto Lbc
        Lae:
            r2 = r0[r6]
            int[] r0 = r8.f22310k1
            r3 = r0[r6]
            int r4 = r8.C1
            r5 = 0
            r0 = r8
            r1 = r9
            r0.a0(r1, r2, r3, r4, r5)
        Lbc:
            int r6 = r6 + 1
            goto L1f
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuhart.stepview.StepView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int iQ0 = q0(i10);
        if (getStepCount() == 0) {
            setMeasuredDimension(iQ0, 0);
        } else {
            if (iQ0 == 0) {
                setMeasuredDimension(iQ0, 0);
                return;
            }
            m0(iQ0);
            setMeasuredDimension(iQ0, n0(i11));
            l0();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.f22298a != null && isEnabled() && motionEvent.getActionMasked() == 1) {
            this.f22298a.a(h0(motionEvent.getX(), motionEvent.getY()));
        }
        return zOnTouchEvent;
    }

    public final int p0() {
        this.K2 = new StaticLayout[this.f22300c.size()];
        this.C.setTextSize(this.f22319t);
        int iMax = 0;
        for (int i10 = 0; i10 < this.f22300c.size(); i10++) {
            this.K2[i10] = new StaticLayout(this.f22300c.get(i10), this.C, getMeasuredWidth() / this.f22300c.size(), j0() ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            iMax = Math.max(this.K2[i10].getHeight(), iMax);
        }
        return iMax;
    }

    public final int q0(int i10) {
        return View.MeasureSpec.getSize(i10);
    }

    public void setOnStepClickListener(e eVar) {
        setClickable(eVar != null);
        this.f22298a = eVar;
    }

    public void setSteps(List<String> list) {
        this.f22301d = 0;
        this.f22299b = 0;
        this.f22300c.clear();
        this.f22300c.addAll(list);
        requestLayout();
        i0(0, false);
    }

    public void setStepsNumber(int i10) {
        this.f22300c.clear();
        this.f22299b = 1;
        this.f22301d = i10;
        requestLayout();
        i0(0, false);
    }

    public StepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sv_stepViewStyle);
    }

    public StepView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22299b = 0;
        this.f22300c = new ArrayList();
        this.f22301d = 0;
        this.f22302e = 0;
        this.f22304g = 1;
        this.E7 = new Rect();
        Paint paint = new Paint(1);
        this.B = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint = new TextPaint(1);
        this.C = textPaint;
        textPaint.setTextAlign(Paint.Align.CENTER);
        W(context, attributeSet, i10);
        Z();
    }
}
