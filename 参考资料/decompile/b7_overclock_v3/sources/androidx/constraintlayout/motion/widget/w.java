package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public static final String G = "TouchResponse";
    public static final boolean H = false;
    public static final int I = 1000;
    public static final float J = 1.0E-7f;
    public static final float[][] K = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] L = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;
    public static final int Q = 4;
    public static final int R = 5;
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 2;
    public static final int V = 3;
    public static final int W = 4;
    public static final int X = 5;
    public static final int Y = 6;
    public static final int Z = 1;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f3988a0 = 2;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f3989b0 = 4;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f3990c0 = 0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f3991d0 = 1;
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f4000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f4004m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4006o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f4007p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f4008q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4009r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f4010s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MotionLayout f4011t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f4012u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f4013v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4014w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f4015x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4016y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f4017z;

    public class a implements View.OnTouchListener {
        public a(final w this$0) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public class b implements NestedScrollView.c {
        public b(final w this$0) {
        }

        @Override // androidx.core.widget.NestedScrollView.c
        public void a(NestedScrollView v10, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        }
    }

    public w(Context context, MotionLayout layout, XmlPullParser parser) {
        this.f3992a = 0;
        this.f3993b = 0;
        this.f3994c = 0;
        this.f3995d = -1;
        this.f3996e = -1;
        this.f3997f = -1;
        this.f3998g = 0.5f;
        this.f3999h = 0.5f;
        this.f4000i = 0.5f;
        this.f4001j = 0.5f;
        this.f4002k = -1;
        this.f4003l = false;
        this.f4004m = 0.0f;
        this.f4005n = 1.0f;
        this.f4006o = false;
        this.f4007p = new float[2];
        this.f4008q = new int[2];
        this.f4012u = 4.0f;
        this.f4013v = 1.2f;
        this.f4014w = true;
        this.f4015x = 1.0f;
        this.f4016y = 0;
        this.f4017z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.f4011t = layout;
        c(context, Xml.asAttributeSet(parser));
    }

    public void A(float lastTouchX, float lastTouchY) {
        this.f4009r = lastTouchX;
        this.f4010s = lastTouchY;
    }

    public void B(float acceleration) {
        this.f4013v = acceleration;
    }

    public void C(float velocity) {
        this.f4012u = velocity;
    }

    public void D(boolean rtl) {
        if (rtl) {
            float[][] fArr = L;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = K;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = L;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = K;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = K;
        int i10 = this.f3992a;
        this.f3999h = fArr5[i10][0];
        this.f3998g = fArr5[i10][1];
        int i11 = this.f3993b;
        float[][] fArr6 = L;
        if (i11 >= fArr6.length) {
            return;
        }
        this.f4004m = fArr6[i11][0];
        this.f4005n = fArr6[i11][1];
    }

    public void E(float x10, float y10) {
        this.f3999h = x10;
        this.f3998g = y10;
    }

    public void F(int touchUpMode) {
        this.f3994c = touchUpMode;
    }

    public void G(float lastTouchX, float lastTouchY) {
        this.f4009r = lastTouchX;
        this.f4010s = lastTouchY;
        this.f4006o = false;
    }

    public void H() {
        View viewFindViewById;
        int i10 = this.f3995d;
        if (i10 != -1) {
            viewFindViewById = this.f4011t.findViewById(i10);
            if (viewFindViewById == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("cannot find TouchAnchorId @id/");
                sb2.append(c.i(this.f4011t.getContext(), this.f3995d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    public float a(float dx, float dy) {
        return (dx * this.f4004m) + (dy * this.f4005n);
    }

    public final void b(TypedArray a10) {
        int indexCount = a10.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = a10.getIndex(i10);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f3995d = a10.getResourceId(index, this.f3995d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i11 = a10.getInt(index, this.f3992a);
                this.f3992a = i11;
                float[][] fArr = K;
                this.f3999h = fArr[i11][0];
                this.f3998g = fArr[i11][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i12 = a10.getInt(index, this.f3993b);
                this.f3993b = i12;
                float[][] fArr2 = L;
                if (i12 < fArr2.length) {
                    this.f4004m = fArr2[i12][0];
                    this.f4005n = fArr2[i12][1];
                } else {
                    this.f4005n = Float.NaN;
                    this.f4004m = Float.NaN;
                    this.f4003l = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f4012u = a10.getFloat(index, this.f4012u);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f4013v = a10.getFloat(index, this.f4013v);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f4014w = a10.getBoolean(index, this.f4014w);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f4015x = a10.getFloat(index, this.f4015x);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f4017z = a10.getFloat(index, this.f4017z);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f3996e = a10.getResourceId(index, this.f3996e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f3994c = a10.getInt(index, this.f3994c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f4016y = a10.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f3997f = a10.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.f4002k = a10.getResourceId(index, this.f4002k);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.A = a10.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.B = a10.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.C = a10.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.D = a10.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.E = a10.getInt(index, this.E);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.F = a10.getInt(index, this.F);
            }
        }
    }

    public final void c(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.OnSwipe);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int d() {
        return this.f3995d;
    }

    public int e() {
        return this.F;
    }

    public int f() {
        return this.f4016y;
    }

    public RectF g(ViewGroup layout, RectF rect) {
        View viewFindViewById;
        int i10 = this.f3997f;
        if (i10 == -1 || (viewFindViewById = layout.findViewById(i10)) == null) {
            return null;
        }
        rect.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rect;
    }

    public int h() {
        return this.f3997f;
    }

    public float i() {
        return this.f4013v;
    }

    public float j() {
        return this.f4012u;
    }

    public boolean k() {
        return this.f4014w;
    }

    public float l(float dx, float dy) {
        this.f4011t.G0(this.f3995d, this.f4011t.getProgress(), this.f3999h, this.f3998g, this.f4007p);
        float f10 = this.f4004m;
        if (f10 != 0.0f) {
            float[] fArr = this.f4007p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (dx * f10) / fArr[0];
        }
        float[] fArr2 = this.f4007p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (dy * this.f4005n) / fArr2[1];
    }

    public int m() {
        return this.E;
    }

    public float n() {
        return this.A;
    }

    public float o() {
        return this.B;
    }

    public float p() {
        return this.C;
    }

    public float q() {
        return this.D;
    }

    public RectF r(ViewGroup layout, RectF rect) {
        View viewFindViewById;
        int i10 = this.f3996e;
        if (i10 == -1 || (viewFindViewById = layout.findViewById(i10)) == null) {
            return null;
        }
        rect.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rect;
    }

    public int s() {
        return this.f3996e;
    }

    public boolean t() {
        return this.f4006o;
    }

    public String toString() {
        if (Float.isNaN(this.f4004m)) {
            return f.f3647i;
        }
        return this.f4004m + " , " + this.f4005n;
    }

    public void u(MotionEvent event, MotionLayout.i velocityTracker, int currentState, t motionScene) {
        int i10;
        if (this.f4003l) {
            v(event, velocityTracker, currentState, motionScene);
            return;
        }
        velocityTracker.e(event);
        int action = event.getAction();
        if (action == 0) {
            this.f4009r = event.getRawX();
            this.f4010s = event.getRawY();
            this.f4006o = false;
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            float rawY = event.getRawY() - this.f4010s;
            float rawX = event.getRawX() - this.f4009r;
            if (Math.abs((this.f4004m * rawX) + (this.f4005n * rawY)) > this.f4017z || this.f4006o) {
                float progress = this.f4011t.getProgress();
                if (!this.f4006o) {
                    this.f4006o = true;
                    this.f4011t.setProgress(progress);
                }
                int i11 = this.f3995d;
                if (i11 != -1) {
                    this.f4011t.G0(i11, progress, this.f3999h, this.f3998g, this.f4007p);
                } else {
                    float fMin = Math.min(this.f4011t.getWidth(), this.f4011t.getHeight());
                    float[] fArr = this.f4007p;
                    fArr[1] = this.f4005n * fMin;
                    fArr[0] = fMin * this.f4004m;
                }
                float f10 = this.f4004m;
                float[] fArr2 = this.f4007p;
                if (Math.abs(((f10 * fArr2[0]) + (this.f4005n * fArr2[1])) * this.f4015x) < 0.01d) {
                    float[] fArr3 = this.f4007p;
                    fArr3[0] = 0.01f;
                    fArr3[1] = 0.01f;
                }
                float fMax = Math.max(Math.min(progress + (this.f4004m != 0.0f ? rawX / this.f4007p[0] : rawY / this.f4007p[1]), 1.0f), 0.0f);
                if (this.f3994c == 6) {
                    fMax = Math.max(fMax, 0.01f);
                }
                if (this.f3994c == 7) {
                    fMax = Math.min(fMax, 0.99f);
                }
                float progress2 = this.f4011t.getProgress();
                if (fMax != progress2) {
                    if (progress2 == 0.0f || progress2 == 1.0f) {
                        this.f4011t.z0(progress2 == 0.0f);
                    }
                    this.f4011t.setProgress(fMax);
                    velocityTracker.h(1000);
                    this.f4011t.C2 = this.f4004m != 0.0f ? velocityTracker.g() / this.f4007p[0] : velocityTracker.f() / this.f4007p[1];
                } else {
                    this.f4011t.C2 = 0.0f;
                }
                this.f4009r = event.getRawX();
                this.f4010s = event.getRawY();
                return;
            }
            return;
        }
        this.f4006o = false;
        velocityTracker.h(1000);
        float fG = velocityTracker.g();
        float f11 = velocityTracker.f();
        float progress3 = this.f4011t.getProgress();
        int i12 = this.f3995d;
        if (i12 != -1) {
            this.f4011t.G0(i12, progress3, this.f3999h, this.f3998g, this.f4007p);
        } else {
            float fMin2 = Math.min(this.f4011t.getWidth(), this.f4011t.getHeight());
            float[] fArr4 = this.f4007p;
            fArr4[1] = this.f4005n * fMin2;
            fArr4[0] = fMin2 * this.f4004m;
        }
        float f12 = this.f4004m;
        float[] fArr5 = this.f4007p;
        float f13 = fArr5[0];
        float f14 = fArr5[1];
        float fAbs = f12 != 0.0f ? fG / fArr5[0] : f11 / fArr5[1];
        float f15 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress3 : progress3;
        if (f15 == 0.0f || f15 == 1.0f || (i10 = this.f3994c) == 3) {
            if (0.0f >= f15 || 1.0f <= f15) {
                this.f4011t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        float f16 = ((double) f15) < 0.5d ? 0.0f : 1.0f;
        if (i10 == 6) {
            if (progress3 + fAbs < 0.0f) {
                fAbs = Math.abs(fAbs);
            }
            f16 = 1.0f;
        }
        if (this.f3994c == 7) {
            if (progress3 + fAbs > 1.0f) {
                fAbs = -Math.abs(fAbs);
            }
            f16 = 0.0f;
        }
        this.f4011t.h1(this.f3994c, f16, fAbs);
        if (0.0f >= progress3 || 1.0f <= progress3) {
            this.f4011t.setState(MotionLayout.TransitionState.FINISHED);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.i r25, int r26, androidx.constraintlayout.motion.widget.t r27) {
        /*
            Method dump skipped, instruction units count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.w.v(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$i, int, androidx.constraintlayout.motion.widget.t):void");
    }

    public void w(float dx, float dy) {
        float progress = this.f4011t.getProgress();
        if (!this.f4006o) {
            this.f4006o = true;
            this.f4011t.setProgress(progress);
        }
        this.f4011t.G0(this.f3995d, progress, this.f3999h, this.f3998g, this.f4007p);
        float f10 = this.f4004m;
        float[] fArr = this.f4007p;
        if (Math.abs((f10 * fArr[0]) + (this.f4005n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f4007p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f11 = this.f4004m;
        float fMax = Math.max(Math.min(progress + (f11 != 0.0f ? (dx * f11) / this.f4007p[0] : (dy * this.f4005n) / this.f4007p[1]), 1.0f), 0.0f);
        if (fMax != this.f4011t.getProgress()) {
            this.f4011t.setProgress(fMax);
        }
    }

    public void x(float dx, float dy) {
        this.f4006o = false;
        float progress = this.f4011t.getProgress();
        this.f4011t.G0(this.f3995d, progress, this.f3999h, this.f3998g, this.f4007p);
        float f10 = this.f4004m;
        float[] fArr = this.f4007p;
        float f11 = fArr[0];
        float f12 = this.f4005n;
        float f13 = fArr[1];
        float f14 = f10 != 0.0f ? (dx * f10) / fArr[0] : (dy * f12) / fArr[1];
        if (!Float.isNaN(f14)) {
            progress += f14 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z10 = progress != 1.0f;
            int i10 = this.f3994c;
            if ((i10 != 3) && z10) {
                this.f4011t.h1(i10, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f14);
            }
        }
    }

    public void y(int id2) {
        this.f3995d = id2;
    }

    public void z(int autoCompleteMode) {
        this.F = autoCompleteMode;
    }

    public w(MotionLayout layout, u onSwipe) {
        this.f3992a = 0;
        this.f3993b = 0;
        this.f3994c = 0;
        this.f3995d = -1;
        this.f3996e = -1;
        this.f3997f = -1;
        this.f3998g = 0.5f;
        this.f3999h = 0.5f;
        this.f4000i = 0.5f;
        this.f4001j = 0.5f;
        this.f4002k = -1;
        this.f4003l = false;
        this.f4004m = 0.0f;
        this.f4005n = 1.0f;
        this.f4006o = false;
        this.f4007p = new float[2];
        this.f4008q = new int[2];
        this.f4012u = 4.0f;
        this.f4013v = 1.2f;
        this.f4014w = true;
        this.f4015x = 1.0f;
        this.f4016y = 0;
        this.f4017z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.f4011t = layout;
        this.f3995d = onSwipe.q();
        int iR = onSwipe.r();
        this.f3992a = iR;
        if (iR != -1) {
            float[][] fArr = K;
            this.f3999h = fArr[iR][0];
            this.f3998g = fArr[iR][1];
        }
        int iB = onSwipe.b();
        this.f3993b = iB;
        float[][] fArr2 = L;
        if (iB < fArr2.length) {
            this.f4004m = fArr2[iB][0];
            this.f4005n = fArr2[iB][1];
        } else {
            this.f4005n = Float.NaN;
            this.f4004m = Float.NaN;
            this.f4003l = true;
        }
        this.f4012u = onSwipe.g();
        this.f4013v = onSwipe.f();
        this.f4014w = onSwipe.h();
        this.f4015x = onSwipe.c();
        this.f4017z = onSwipe.d();
        this.f3996e = onSwipe.s();
        this.f3994c = onSwipe.j();
        this.f4016y = onSwipe.i();
        this.f3997f = onSwipe.e();
        this.f4002k = onSwipe.k();
        this.E = onSwipe.l();
        this.A = onSwipe.m();
        this.B = onSwipe.n();
        this.C = onSwipe.o();
        this.D = onSwipe.p();
        this.F = onSwipe.a();
    }
}
