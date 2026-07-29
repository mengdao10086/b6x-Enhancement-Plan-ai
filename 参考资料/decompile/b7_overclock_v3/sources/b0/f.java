package b0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f8999s = "MotionTelltales";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f9000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MotionLayout f9001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f9002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Matrix f9003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f9006r;

    public f(Context context) {
        super(context);
        this.f9000l = new Paint();
        this.f9002n = new float[2];
        this.f9003o = new Matrix();
        this.f9004p = 0;
        this.f9005q = -65281;
        this.f9006r = 0.25f;
        a(context, null);
    }

    private void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f9005q = typedArrayObtainStyledAttributes.getColor(index, this.f9005q);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f9004p = typedArrayObtainStyledAttributes.getInt(index, this.f9004p);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f9006r = typedArrayObtainStyledAttributes.getFloat(index, this.f9006r);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f9000l.setColor(this.f9005q);
        this.f9000l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // b0.c, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f9003o);
        if (this.f9001m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f9001m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i10 = 0; i10 < 5; i10++) {
            float f10 = fArr[i10];
            for (int i11 = 0; i11 < 5; i11++) {
                float f11 = fArr[i11];
                this.f9001m.M0(this, f11, f10, this.f9002n, this.f9004p);
                this.f9003o.mapVectors(this.f9002n);
                float f12 = width * f11;
                float f13 = height * f10;
                float[] fArr2 = this.f9002n;
                float f14 = fArr2[0];
                float f15 = this.f9006r;
                float f16 = f13 - (fArr2[1] * f15);
                this.f9003o.mapVectors(fArr2);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, this.f9000l);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        super.onLayout(changed, left, top2, right, bottom);
        postInvalidate();
    }

    public void setText(CharSequence text) {
        this.f8954f = text.toString();
        requestLayout();
    }

    public f(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f9000l = new Paint();
        this.f9002n = new float[2];
        this.f9003o = new Matrix();
        this.f9004p = 0;
        this.f9005q = -65281;
        this.f9006r = 0.25f;
        a(context, attrs);
    }

    public f(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f9000l = new Paint();
        this.f9002n = new float[2];
        this.f9003o = new Matrix();
        this.f9004p = 0;
        this.f9005q = -65281;
        this.f9006r = 0.25f;
        a(context, attrs);
    }
}
