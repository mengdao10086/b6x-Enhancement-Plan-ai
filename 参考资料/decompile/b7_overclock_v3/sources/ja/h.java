package ja;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import ha.b;
import la.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<T extends k<? extends qa.e<? extends Entry>>> extends e<T> {
    public float E7;
    public float F7;
    public boolean G7;
    public float H7;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            h.this.postInvalidate();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f36280c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f36280c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36280c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f36279b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36279b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36279b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f36278a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36278a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public h(Context context) {
        super(context);
        this.E7 = 270.0f;
        this.F7 = 270.0f;
        this.G7 = true;
        this.H7 = 0.0f;
    }

    @Override // ja.e
    public void H() {
        super.H();
        this.f36260n = new com.github.mikephil.charting.listener.c(this);
    }

    @Override // ja.e
    public void O() {
        if (this.f36247b == null) {
            return;
        }
        o();
        if (this.f36258l != null) {
            this.f36263q.a(this.f36247b);
        }
        p();
    }

    public float Z(float f10, float f11) {
        xa.g centerOffsets = getCenterOffsets();
        float f12 = centerOffsets.f54987c;
        float fSqrt = (float) Math.sqrt(Math.pow(f10 > f12 ? f10 - f12 : f12 - f10, 2.0d) + Math.pow(f11 > centerOffsets.f54988d ? f11 - r1 : r1 - f11, 2.0d));
        xa.g.h(centerOffsets);
        return fSqrt;
    }

    public float a0(float f10, float f11) {
        xa.g centerOffsets = getCenterOffsets();
        double d10 = f10 - centerOffsets.f54987c;
        double d11 = f11 - centerOffsets.f54988d;
        float degrees = (float) Math.toDegrees(Math.acos(d11 / Math.sqrt((d10 * d10) + (d11 * d11))));
        if (f10 > centerOffsets.f54987c) {
            degrees = 360.0f - degrees;
        }
        float f12 = degrees + 90.0f;
        if (f12 > 360.0f) {
            f12 -= 360.0f;
        }
        xa.g.h(centerOffsets);
        return f12;
    }

    public abstract int b0(float f10);

    public xa.g c0(xa.g gVar, float f10, float f11) {
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        d0(gVar, f10, f11, gVarC);
        return gVarC;
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f36260n;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.c) {
            ((com.github.mikephil.charting.listener.c) chartTouchListener).i();
        }
    }

    public void d0(xa.g gVar, float f10, float f11, xa.g gVar2) {
        double d10 = f10;
        double d11 = f11;
        gVar2.f54987c = (float) (((double) gVar.f54987c) + (Math.cos(Math.toRadians(d11)) * d10));
        gVar2.f54988d = (float) (((double) gVar.f54988d) + (d10 * Math.sin(Math.toRadians(d11))));
    }

    public boolean e0() {
        return this.G7;
    }

    @SuppressLint({"NewApi"})
    public void f0(int i10, float f10, float f11, b.c0 c0Var) {
        setRotationAngle(f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f10, f11);
        objectAnimatorOfFloat.setDuration(i10);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.addUpdateListener(new a());
        objectAnimatorOfFloat.start();
    }

    public float getDiameter() {
        RectF rectFQ = this.f36266t.q();
        rectFQ.left += getExtraLeftOffset();
        rectFQ.top += getExtraTopOffset();
        rectFQ.right -= getExtraRightOffset();
        rectFQ.bottom -= getExtraBottomOffset();
        return Math.min(rectFQ.width(), rectFQ.height());
    }

    @Override // pa.e
    public int getMaxVisibleCount() {
        return this.f36247b.r();
    }

    public float getMinOffset() {
        return this.H7;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.F7;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.E7;
    }

    @Override // pa.e
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // pa.e
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // ja.e
    public void o() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.f36255j || (chartTouchListener = this.f36260n) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // ja.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ja.h.p():void");
    }

    public void setMinOffset(float f10) {
        this.H7 = f10;
    }

    public void setRotationAngle(float f10) {
        this.F7 = f10;
        this.E7 = xa.k.z(f10);
    }

    public void setRotationEnabled(boolean z10) {
        this.G7 = z10;
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E7 = 270.0f;
        this.F7 = 270.0f;
        this.G7 = true;
        this.H7 = 0.0f;
    }

    public h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E7 = 270.0f;
        this.F7 = 270.0f;
        this.G7 = true;
        this.H7 = 0.0f;
    }
}
