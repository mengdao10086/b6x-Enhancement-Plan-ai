package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.e;
import androidx.core.view.h0;
import com.blankj.utilcode.util.i0;
import com.blankj.utilcode.util.z0;
import com.bumptech.glide.load.engine.GlideException;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MotionLayout extends ConstraintLayout implements h0 {

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public static final int f3485a9 = 0;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public static final int f3486b9 = 1;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public static final int f3487c9 = 2;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public static final int f3488d9 = 3;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public static final int f3489e9 = 4;

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public static final int f3490f9 = 5;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public static final int f3491g9 = 6;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public static final int f3492h9 = 7;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public static final String f3493i9 = "MotionLayout";

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public static final boolean f3494j9 = false;

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public static boolean f3495k9 = false;

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public static final int f3496l9 = 0;

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public static final int f3497m9 = 1;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public static final int f3498n9 = 2;

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    public static final int f3499o9 = 50;

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    public static final int f3500p9 = 0;

    /* JADX INFO: renamed from: q9, reason: collision with root package name */
    public static final int f3501q9 = 1;

    /* JADX INFO: renamed from: r9, reason: collision with root package name */
    public static final int f3502r9 = 2;

    /* JADX INFO: renamed from: s9, reason: collision with root package name */
    public static final int f3503s9 = 3;

    /* JADX INFO: renamed from: t9, reason: collision with root package name */
    public static final float f3504t9 = 1.0E-5f;
    public int A8;
    public int B8;
    public t C1;
    public float C2;
    public int C8;
    public int D8;
    public int E7;
    public float E8;
    public int F7;
    public w.g F8;
    public int G7;
    public boolean G8;
    public int H7;
    public k H8;
    public boolean I7;
    public Runnable I8;
    public HashMap<View, o> J7;
    public int[] J8;
    public Interpolator K1;
    public int K2;
    public long K7;
    public int K8;
    public float L7;
    public boolean L8;
    public float M7;
    public int M8;
    public float N7;
    public HashMap<View, a0.e> N8;
    public long O7;
    public int O8;
    public float P7;
    public int P8;
    public boolean Q7;
    public int Q8;
    public boolean R7;
    public Rect R8;
    public boolean S7;
    public boolean S8;
    public l T7;
    public TransitionState T8;
    public float U7;
    public h U8;
    public float V7;
    public boolean V8;
    public int W7;
    public RectF W8;
    public g X7;
    public View X8;
    public boolean Y7;
    public Matrix Y8;
    public a0.b Z7;
    public ArrayList<Integer> Z8;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public f f3505a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public androidx.constraintlayout.motion.widget.d f3506b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public boolean f3507c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public int f3508d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f3509e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f3510f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public int f3511g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public boolean f3512h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public float f3513i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public float f3514j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public long f3515k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public float f3516l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public boolean f3517m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public ArrayList<p> f3518n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public ArrayList<p> f3519o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public ArrayList<p> f3520p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public CopyOnWriteArrayList<l> f3521q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public int f3522r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public long f3523s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public float f3524t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public int f3525u8;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public Interpolator f3526v2;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public float f3527v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f3528w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public boolean f3529x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public int f3530y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public int f3531z8;

    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.H8.a();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.L8 = false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3534a;

        public c(final MotionLayout this$0, final View val$target) {
            this.f3534a = val$target;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3534a.setNestedScrollingEnabled(true);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.H8.a();
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3536a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f3536a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3536a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3536a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3536a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class f extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3537a = 0.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3538b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3539c;

        public f() {
        }

        @Override // androidx.constraintlayout.motion.widget.r
        public float a() {
            return MotionLayout.this.C2;
        }

        public void b(float velocity, float position, float maxAcceleration) {
            this.f3537a = velocity;
            this.f3538b = position;
            this.f3539c = maxAcceleration;
        }

        @Override // androidx.constraintlayout.motion.widget.r, android.animation.TimeInterpolator
        public float getInterpolation(float time) {
            float f10;
            float f11;
            float f12 = this.f3537a;
            if (f12 > 0.0f) {
                float f13 = this.f3539c;
                if (f12 / f13 < time) {
                    time = f12 / f13;
                }
                MotionLayout.this.C2 = f12 - (f13 * time);
                f10 = (f12 * time) - (((f13 * time) * time) / 2.0f);
                f11 = this.f3538b;
            } else {
                float f14 = this.f3539c;
                if ((-f12) / f14 < time) {
                    time = (-f12) / f14;
                }
                MotionLayout.this.C2 = (f14 * time) + f12;
                f10 = (f12 * time) + (((f14 * time) * time) / 2.0f);
                f11 = this.f3538b;
            }
            return f10 + f11;
        }
    }

    public class g {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f3541v = 16;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float[] f3542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int[] f3543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f3544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f3545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f3546e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Paint f3547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Paint f3548g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Paint f3549h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Paint f3550i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float[] f3551j;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public DashPathEffect f3557p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3558q;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f3561t;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f3552k = -21965;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f3553l = -2067046;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f3554m = -13391360;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f3555n = 1996488704;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f3556o = 10;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Rect f3559r = new Rect();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f3560s = false;

        public g() {
            this.f3561t = 1;
            Paint paint = new Paint();
            this.f3546e = paint;
            paint.setAntiAlias(true);
            this.f3546e.setColor(-21965);
            this.f3546e.setStrokeWidth(2.0f);
            this.f3546e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f3547f = paint2;
            paint2.setAntiAlias(true);
            this.f3547f.setColor(-2067046);
            this.f3547f.setStrokeWidth(2.0f);
            this.f3547f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f3548g = paint3;
            paint3.setAntiAlias(true);
            this.f3548g.setColor(-13391360);
            this.f3548g.setStrokeWidth(2.0f);
            this.f3548g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f3549h = paint4;
            paint4.setAntiAlias(true);
            this.f3549h.setColor(-13391360);
            this.f3549h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f3551j = new float[8];
            Paint paint5 = new Paint();
            this.f3550i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f3557p = dashPathEffect;
            this.f3548g.setPathEffect(dashPathEffect);
            this.f3544c = new float[100];
            this.f3543b = new int[50];
            if (this.f3560s) {
                this.f3546e.setStrokeWidth(8.0f);
                this.f3550i.setStrokeWidth(8.0f);
                this.f3547f.setStrokeWidth(8.0f);
                this.f3561t = 4;
            }
        }

        public void a(Canvas canvas, HashMap<View, o> frameArrayList, int duration, int debugPath) {
            if (frameArrayList == null || frameArrayList.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (debugPath & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.F7) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f3549h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f3546e);
            }
            for (o oVar : frameArrayList.values()) {
                int iQ = oVar.q();
                if (debugPath > 0 && iQ == 0) {
                    iQ = 1;
                }
                if (iQ != 0) {
                    this.f3558q = oVar.e(this.f3544c, this.f3543b);
                    if (iQ >= 1) {
                        int i10 = duration / 16;
                        float[] fArr = this.f3542a;
                        if (fArr == null || fArr.length != i10 * 2) {
                            this.f3542a = new float[i10 * 2];
                            this.f3545d = new Path();
                        }
                        int i11 = this.f3561t;
                        canvas.translate(i11, i11);
                        this.f3546e.setColor(1996488704);
                        this.f3550i.setColor(1996488704);
                        this.f3547f.setColor(1996488704);
                        this.f3548g.setColor(1996488704);
                        oVar.f(this.f3542a, i10);
                        b(canvas, iQ, this.f3558q, oVar);
                        this.f3546e.setColor(-21965);
                        this.f3547f.setColor(-2067046);
                        this.f3550i.setColor(-2067046);
                        this.f3548g.setColor(-13391360);
                        int i12 = this.f3561t;
                        canvas.translate(-i12, -i12);
                        b(canvas, iQ, this.f3558q, oVar);
                        if (iQ == 5) {
                            j(canvas, oVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int mode, int keyFrames, o motionController) {
            if (mode == 4) {
                d(canvas);
            }
            if (mode == 2) {
                g(canvas);
            }
            if (mode == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, mode, keyFrames, motionController);
        }

        public final void c(Canvas canvas) {
            canvas.drawLines(this.f3542a, this.f3546e);
        }

        public final void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f3558q; i10++) {
                int[] iArr = this.f3543b;
                if (iArr[i10] == 1) {
                    z10 = true;
                }
                if (iArr[i10] == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        public final void e(Canvas canvas) {
            float[] fArr = this.f3542a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f3548g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f3548g);
        }

        public final void f(Canvas canvas, float x10, float y10) {
            float[] fArr = this.f3542a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            float fMin = Math.min(f10, f12);
            float fMax = Math.max(f11, f13);
            float fMin2 = x10 - Math.min(f10, f12);
            float fMax2 = Math.max(f11, f13) - y10;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f12 - f10))) + 0.5d)) / 100.0f);
            m(str, this.f3549h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f3559r.width() / 2)) + fMin, y10 - 20.0f, this.f3549h);
            canvas.drawLine(x10, y10, Math.min(f10, f12), y10, this.f3548g);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f13 - f11))) + 0.5d)) / 100.0f);
            m(str2, this.f3549h);
            canvas.drawText(str2, x10 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f3559r.height() / 2)), this.f3549h);
            canvas.drawLine(x10, y10, x10, Math.max(f11, f13), this.f3548g);
        }

        public final void g(Canvas canvas) {
            float[] fArr = this.f3542a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f3548g);
        }

        public final void h(Canvas canvas, float x10, float y10) {
            float[] fArr = this.f3542a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f10 - f12, f11 - f13);
            float f14 = f12 - f10;
            float f15 = f13 - f11;
            float f16 = (((x10 - f10) * f14) + ((y10 - f11) * f15)) / (fHypot * fHypot);
            float f17 = f10 + (f14 * f16);
            float f18 = f11 + (f16 * f15);
            Path path = new Path();
            path.moveTo(x10, y10);
            path.lineTo(f17, f18);
            float fHypot2 = (float) Math.hypot(f17 - x10, f18 - y10);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            m(str, this.f3549h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f3559r.width() / 2), -20.0f, this.f3549h);
            canvas.drawLine(x10, y10, f17, f18, this.f3548g);
        }

        public final void i(Canvas canvas, float x10, float y10, int viewWidth, int viewHeight) {
            String str = "" + (((int) (((double) (((x10 - (viewWidth / 2)) * 100.0f) / (MotionLayout.this.getWidth() - viewWidth))) + 0.5d)) / 100.0f);
            m(str, this.f3549h);
            canvas.drawText(str, ((x10 / 2.0f) - (this.f3559r.width() / 2)) + 0.0f, y10 - 20.0f, this.f3549h);
            canvas.drawLine(x10, y10, Math.min(0.0f, 1.0f), y10, this.f3548g);
            String str2 = "" + (((int) (((double) (((y10 - (viewHeight / 2)) * 100.0f) / (MotionLayout.this.getHeight() - viewHeight))) + 0.5d)) / 100.0f);
            m(str2, this.f3549h);
            canvas.drawText(str2, x10 + 5.0f, 0.0f - ((y10 / 2.0f) - (this.f3559r.height() / 2)), this.f3549h);
            canvas.drawLine(x10, y10, x10, Math.max(0.0f, 1.0f), this.f3548g);
        }

        public final void j(Canvas canvas, o motionController) {
            this.f3545d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                motionController.g(i10 / 50, this.f3551j, 0);
                Path path = this.f3545d;
                float[] fArr = this.f3551j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f3545d;
                float[] fArr2 = this.f3551j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f3545d;
                float[] fArr3 = this.f3551j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f3545d;
                float[] fArr4 = this.f3551j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f3545d.close();
            }
            this.f3546e.setColor(z0.a.f12026i);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f3545d, this.f3546e);
            canvas.translate(-2.0f, -2.0f);
            this.f3546e.setColor(-65536);
            canvas.drawPath(this.f3545d, this.f3546e);
        }

        public final void k(Canvas canvas, int mode, int keyFrames, o motionController) {
            int width;
            int height;
            float f10;
            float f11;
            View view = motionController.f3844b;
            if (view != null) {
                width = view.getWidth();
                height = motionController.f3844b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i10 = 1; i10 < keyFrames - 1; i10++) {
                if (mode != 4 || this.f3543b[i10 - 1] != 0) {
                    float[] fArr = this.f3544c;
                    int i11 = i10 * 2;
                    float f12 = fArr[i11];
                    float f13 = fArr[i11 + 1];
                    this.f3545d.reset();
                    this.f3545d.moveTo(f12, f13 + 10.0f);
                    this.f3545d.lineTo(f12 + 10.0f, f13);
                    this.f3545d.lineTo(f12, f13 - 10.0f);
                    this.f3545d.lineTo(f12 - 10.0f, f13);
                    this.f3545d.close();
                    int i12 = i10 - 1;
                    motionController.w(i12);
                    if (mode == 4) {
                        int[] iArr = this.f3543b;
                        if (iArr[i12] == 1) {
                            h(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else if (iArr[i12] == 0) {
                            f(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else {
                            if (iArr[i12] == 2) {
                                f10 = f13;
                                f11 = f12;
                                i(canvas, f12 - 0.0f, f13 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.f3545d, this.f3550i);
                        }
                        f10 = f13;
                        f11 = f12;
                        canvas.drawPath(this.f3545d, this.f3550i);
                    } else {
                        f10 = f13;
                        f11 = f12;
                    }
                    if (mode == 2) {
                        h(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (mode == 3) {
                        f(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (mode == 6) {
                        i(canvas, f11 - 0.0f, f10 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f3545d, this.f3550i);
                }
            }
            float[] fArr2 = this.f3542a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f3547f);
                float[] fArr3 = this.f3542a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f3547f);
            }
        }

        public final void l(Canvas canvas, float x12, float y12, float x22, float y22) {
            canvas.drawRect(x12, y12, x22, y22, this.f3548g);
            canvas.drawLine(x12, y12, x22, y22, this.f3548g);
        }

        public void m(String text, Paint paint) {
            paint.getTextBounds(text, 0, text.length(), this.f3559r);
        }
    }

    public class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f3563a = new androidx.constraintlayout.core.widgets.d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.d f3564b = new androidx.constraintlayout.core.widgets.d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f3565c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f3566d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3567e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3568f;

        public h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0123 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instruction units count: 326
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.h.a():void");
        }

        public final void b(int widthMeasureSpec, int heightMeasureSpec) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.E7 == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar = this.f3564b;
                androidx.constraintlayout.widget.d dVar2 = this.f3566d;
                motionLayout2.A(dVar, optimizationLevel, (dVar2 == null || dVar2.f4287d == 0) ? widthMeasureSpec : heightMeasureSpec, (dVar2 == null || dVar2.f4287d == 0) ? heightMeasureSpec : widthMeasureSpec);
                androidx.constraintlayout.widget.d dVar3 = this.f3565c;
                if (dVar3 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.d dVar4 = this.f3563a;
                    int i10 = dVar3.f4287d;
                    int i11 = i10 == 0 ? widthMeasureSpec : heightMeasureSpec;
                    if (i10 == 0) {
                        widthMeasureSpec = heightMeasureSpec;
                    }
                    motionLayout3.A(dVar4, optimizationLevel, i11, widthMeasureSpec);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.d dVar5 = this.f3565c;
            if (dVar5 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar6 = this.f3563a;
                int i12 = dVar5.f4287d;
                motionLayout4.A(dVar6, optimizationLevel, i12 == 0 ? widthMeasureSpec : heightMeasureSpec, i12 == 0 ? heightMeasureSpec : widthMeasureSpec);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.d dVar7 = this.f3564b;
            androidx.constraintlayout.widget.d dVar8 = this.f3566d;
            int i13 = (dVar8 == null || dVar8.f4287d == 0) ? widthMeasureSpec : heightMeasureSpec;
            if (dVar8 == null || dVar8.f4287d == 0) {
                widthMeasureSpec = heightMeasureSpec;
            }
            motionLayout5.A(dVar7, optimizationLevel, i13, widthMeasureSpec);
        }

        public void c(androidx.constraintlayout.core.widgets.d src, androidx.constraintlayout.core.widgets.d dest) {
            ArrayList<ConstraintWidget> arrayListL2 = src.l2();
            HashMap<ConstraintWidget, ConstraintWidget> map = new HashMap<>();
            map.put(src, dest);
            dest.l2().clear();
            dest.n(src, map);
            for (ConstraintWidget constraintWidget : arrayListL2) {
                ConstraintWidget aVar = constraintWidget instanceof androidx.constraintlayout.core.widgets.a ? new androidx.constraintlayout.core.widgets.a() : constraintWidget instanceof androidx.constraintlayout.core.widgets.f ? new androidx.constraintlayout.core.widgets.f() : constraintWidget instanceof androidx.constraintlayout.core.widgets.e ? new androidx.constraintlayout.core.widgets.e() : constraintWidget instanceof androidx.constraintlayout.core.widgets.h ? new androidx.constraintlayout.core.widgets.h() : constraintWidget instanceof y.a ? new y.b() : new ConstraintWidget();
                dest.b(aVar);
                map.put(constraintWidget, aVar);
            }
            for (ConstraintWidget constraintWidget2 : arrayListL2) {
                map.get(constraintWidget2).n(constraintWidget2, map);
            }
        }

        @SuppressLint({"LogConditional"})
        public final void d(String title, androidx.constraintlayout.core.widgets.d c10) {
            String str = title + i0.f11861z + androidx.constraintlayout.motion.widget.c.k((View) c10.w());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("  ========= ");
            sb2.append(c10);
            int size = c10.l2().size();
            for (int i10 = 0; i10 < size; i10++) {
                String str2 = str + "[" + i10 + "] ";
                ConstraintWidget constraintWidget = c10.l2().get(i10);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(constraintWidget.R.f3204f != null ? i1.a.f31577d5 : "_");
                String string = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string);
                sb4.append(constraintWidget.T.f3204f != null ? "B" : "_");
                String string2 = sb4.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(string2);
                sb5.append(constraintWidget.Q.f3204f != null ? "L" : "_");
                String string3 = sb5.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(string3);
                sb6.append(constraintWidget.S.f3204f != null ? "R" : "_");
                String string4 = sb6.toString();
                View view = (View) constraintWidget.w();
                String strK = androidx.constraintlayout.motion.widget.c.k(view);
                if (view instanceof TextView) {
                    strK = strK + ee.a.f26978c + ((Object) ((TextView) view).getText()) + ee.a.f26979d;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str2);
                sb7.append(GlideException.a.f12263d);
                sb7.append(strK);
                sb7.append(i0.f11861z);
                sb7.append(constraintWidget);
                sb7.append(i0.f11861z);
                sb7.append(string4);
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str);
            sb8.append(" done. ");
        }

        @SuppressLint({"LogConditional"})
        public final void e(String str, ConstraintLayout.b params) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i0.f11861z);
            sb2.append(params.f4111t != -1 ? "SS" : "__");
            String string = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append(params.f4109s != -1 ? "|SE" : "|__");
            String string2 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string2);
            sb4.append(params.f4113u != -1 ? "|ES" : "|__");
            String string3 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string3);
            sb5.append(params.f4115v != -1 ? "|EE" : "|__");
            String string4 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(string4);
            sb6.append(params.f4081e != -1 ? "|LL" : "|__");
            String string5 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string5);
            sb7.append(params.f4083f != -1 ? "|LR" : "|__");
            String string6 = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string6);
            sb8.append(params.f4085g != -1 ? "|RL" : "|__");
            String string7 = sb8.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(string7);
            sb9.append(params.f4087h != -1 ? "|RR" : "|__");
            String string8 = sb9.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(string8);
            sb10.append(params.f4089i != -1 ? "|TT" : "|__");
            String string9 = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(string9);
            sb11.append(params.f4091j != -1 ? "|TB" : "|__");
            String string10 = sb11.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append(string10);
            sb12.append(params.f4093k != -1 ? "|BT" : "|__");
            String string11 = sb12.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(string11);
            sb13.append(params.f4095l != -1 ? "|BB" : "|__");
            String string12 = sb13.toString();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str);
            sb14.append(string12);
        }

        @SuppressLint({"LogConditional"})
        public final void f(String str, ConstraintWidget child) {
            String string;
            String string2;
            String string3;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i0.f11861z);
            String string4 = "__";
            if (child.R.f3204f != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i1.a.f31577d5);
                sb3.append(child.R.f3204f.f3203e == ConstraintAnchor.Type.TOP ? i1.a.f31577d5 : "B");
                string = sb3.toString();
            } else {
                string = "__";
            }
            sb2.append(string);
            String string5 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string5);
            if (child.T.f3204f != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("B");
                sb5.append(child.T.f3204f.f3203e == ConstraintAnchor.Type.TOP ? i1.a.f31577d5 : "B");
                string2 = sb5.toString();
            } else {
                string2 = "__";
            }
            sb4.append(string2);
            String string6 = sb4.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(string6);
            if (child.Q.f3204f != null) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("L");
                sb7.append(child.Q.f3204f.f3203e == ConstraintAnchor.Type.LEFT ? "L" : "R");
                string3 = sb7.toString();
            } else {
                string3 = "__";
            }
            sb6.append(string3);
            String string7 = sb6.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string7);
            if (child.S.f3204f != null) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("R");
                sb9.append(child.S.f3204f.f3203e == ConstraintAnchor.Type.LEFT ? "L" : "R");
                string4 = sb9.toString();
            }
            sb8.append(string4);
            String string8 = sb8.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str);
            sb10.append(string8);
            sb10.append(" ---  ");
            sb10.append(child);
        }

        public ConstraintWidget g(androidx.constraintlayout.core.widgets.d container, View view) {
            if (container.w() == view) {
                return container;
            }
            ArrayList<ConstraintWidget> arrayListL2 = container.l2();
            int size = arrayListL2.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = arrayListL2.get(i10);
                if (constraintWidget.w() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void h(androidx.constraintlayout.core.widgets.d baseLayout, androidx.constraintlayout.widget.d start, androidx.constraintlayout.widget.d end) {
            this.f3565c = start;
            this.f3566d = end;
            this.f3563a = new androidx.constraintlayout.core.widgets.d();
            this.f3564b = new androidx.constraintlayout.core.widgets.d();
            this.f3563a.U2(MotionLayout.this.f4046c.G2());
            this.f3564b.U2(MotionLayout.this.f4046c.G2());
            this.f3563a.p2();
            this.f3564b.p2();
            c(MotionLayout.this.f4046c, this.f3563a);
            c(MotionLayout.this.f4046c, this.f3564b);
            if (MotionLayout.this.N7 > 0.5d) {
                if (start != null) {
                    m(this.f3563a, start);
                }
                m(this.f3564b, end);
            } else {
                m(this.f3564b, end);
                if (start != null) {
                    m(this.f3563a, start);
                }
            }
            this.f3563a.Y2(MotionLayout.this.v());
            this.f3563a.a3();
            this.f3564b.Y2(MotionLayout.this.v());
            this.f3564b.a3();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.d dVar = this.f3563a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar.D1(dimensionBehaviour);
                    this.f3564b.D1(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f3563a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.Y1(dimensionBehaviour2);
                    this.f3564b.Y1(dimensionBehaviour2);
                }
            }
        }

        public boolean i(int startId, int endId) {
            return (startId == this.f3567e && endId == this.f3568f) ? false : true;
        }

        public void j(int widthMeasureSpec, int heightMeasureSpec) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.C8 = mode;
            motionLayout.D8 = mode2;
            motionLayout.getOptimizationLevel();
            b(widthMeasureSpec, heightMeasureSpec);
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                b(widthMeasureSpec, heightMeasureSpec);
                MotionLayout.this.f3530y8 = this.f3563a.m0();
                MotionLayout.this.f3531z8 = this.f3563a.D();
                MotionLayout.this.A8 = this.f3564b.m0();
                MotionLayout.this.B8 = this.f3564b.D();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f3529x8 = (motionLayout2.f3530y8 == motionLayout2.A8 && motionLayout2.f3531z8 == motionLayout2.B8) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i10 = motionLayout3.f3530y8;
            int i11 = motionLayout3.f3531z8;
            int i12 = motionLayout3.C8;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                i10 = (int) (i10 + (motionLayout3.E8 * (motionLayout3.A8 - i10)));
            }
            int i13 = i10;
            int i14 = motionLayout3.D8;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i11 = (int) (i11 + (motionLayout3.E8 * (motionLayout3.B8 - i11)));
            }
            MotionLayout.this.z(widthMeasureSpec, heightMeasureSpec, i13, i11, this.f3563a.P2() || this.f3564b.P2(), this.f3563a.N2() || this.f3564b.N2());
        }

        public void k() {
            j(MotionLayout.this.G7, MotionLayout.this.H7);
            MotionLayout.this.f1();
        }

        public void l(int startId, int endId) {
            this.f3567e = startId;
            this.f3568f = endId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void m(androidx.constraintlayout.core.widgets.d base, androidx.constraintlayout.widget.d cSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            e.a aVar = new e.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, base);
            sparseArray.put(MotionLayout.this.getId(), base);
            if (cSet != null && cSet.f4287d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.A(this.f3564b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            for (ConstraintWidget constraintWidget : base.l2()) {
                constraintWidget.f1(true);
                sparseArray.put(((View) constraintWidget.w()).getId(), constraintWidget);
            }
            for (ConstraintWidget constraintWidget2 : base.l2()) {
                View view = (View) constraintWidget2.w();
                cSet.u(view.getId(), aVar);
                constraintWidget2.c2(cSet.u0(view.getId()));
                constraintWidget2.y1(cSet.n0(view.getId()));
                if (view instanceof androidx.constraintlayout.widget.a) {
                    cSet.s((androidx.constraintlayout.widget.a) view, constraintWidget2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).I();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.m(false, view, constraintWidget2, aVar, sparseArray);
                if (cSet.t0(view.getId()) == 1) {
                    constraintWidget2.b2(view.getVisibility());
                } else {
                    constraintWidget2.b2(cSet.s0(view.getId()));
                }
            }
            for (ConstraintWidget constraintWidget3 : base.l2()) {
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i) {
                    androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) constraintWidget3.w();
                    y.a aVar3 = (y.a) constraintWidget3;
                    aVar2.G(base, aVar3, sparseArray);
                    ((androidx.constraintlayout.core.widgets.i) aVar3).n2();
                }
            }
        }
    }

    public interface i {
        void a();

        void b(int units, float maxVelocity);

        float c(int id2);

        void clear();

        float d(int id2);

        void e(MotionEvent event);

        float f();

        float g();

        void h(int units);
    }

    public static class j implements i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static j f3570b = new j();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f3571a;

        public static j i() {
            f3570b.f3571a = VelocityTracker.obtain();
            return f3570b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void a() {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f3571a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void b(int units, float maxVelocity) {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(units, maxVelocity);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float c(int id2) {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(id2);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void clear() {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float d(int id2) {
            if (this.f3571a != null) {
                return d(id2);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void e(MotionEvent event) {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(event);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float f() {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public float g() {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
        public void h(int units) {
            VelocityTracker velocityTracker = this.f3571a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(units);
            }
        }
    }

    public class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3572a = Float.NaN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3573b = Float.NaN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3574c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3575d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f3576e = "motion.progress";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f3577f = "motion.velocity";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f3578g = "motion.StartState";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f3579h = "motion.EndState";

        public k() {
        }

        public void a() {
            int i10 = this.f3574c;
            if (i10 != -1 || this.f3575d != -1) {
                if (i10 == -1) {
                    MotionLayout.this.m1(this.f3575d);
                } else {
                    int i11 = this.f3575d;
                    if (i11 == -1) {
                        MotionLayout.this.I(i10, -1, -1);
                    } else {
                        MotionLayout.this.e1(i10, i11);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f3573b)) {
                if (Float.isNaN(this.f3572a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f3572a);
            } else {
                MotionLayout.this.d1(this.f3572a, this.f3573b);
                this.f3572a = Float.NaN;
                this.f3573b = Float.NaN;
                this.f3574c = -1;
                this.f3575d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f3572a);
            bundle.putFloat("motion.velocity", this.f3573b);
            bundle.putInt("motion.StartState", this.f3574c);
            bundle.putInt("motion.EndState", this.f3575d);
            return bundle;
        }

        public void c() {
            this.f3575d = MotionLayout.this.F7;
            this.f3574c = MotionLayout.this.K2;
            this.f3573b = MotionLayout.this.getVelocity();
            this.f3572a = MotionLayout.this.getProgress();
        }

        public void d(int endState) {
            this.f3575d = endState;
        }

        public void e(float progress) {
            this.f3572a = progress;
        }

        public void f(int startState) {
            this.f3574c = startState;
        }

        public void g(Bundle bundle) {
            this.f3572a = bundle.getFloat("motion.progress");
            this.f3573b = bundle.getFloat("motion.velocity");
            this.f3574c = bundle.getInt("motion.StartState");
            this.f3575d = bundle.getInt("motion.EndState");
        }

        public void h(float mVelocity) {
            this.f3573b = mVelocity;
        }
    }

    public interface l {
        void a(MotionLayout motionLayout, int startId, int endId, float progress);

        void c(MotionLayout motionLayout, int startId, int endId);

        void d(MotionLayout motionLayout, int triggerId, boolean positive, float progress);

        void k(MotionLayout motionLayout, int currentId);
    }

    public MotionLayout(@n0 Context context) {
        super(context);
        this.f3526v2 = null;
        this.C2 = 0.0f;
        this.K2 = -1;
        this.E7 = -1;
        this.F7 = -1;
        this.G7 = 0;
        this.H7 = 0;
        this.I7 = true;
        this.J7 = new HashMap<>();
        this.K7 = 0L;
        this.L7 = 1.0f;
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.P7 = 0.0f;
        this.R7 = false;
        this.S7 = false;
        this.W7 = 0;
        this.Y7 = false;
        this.Z7 = new a0.b();
        this.f3505a8 = new f();
        this.f3507c8 = true;
        this.f3512h8 = false;
        this.f3517m8 = false;
        this.f3518n8 = null;
        this.f3519o8 = null;
        this.f3520p8 = null;
        this.f3521q8 = null;
        this.f3522r8 = 0;
        this.f3523s8 = -1L;
        this.f3524t8 = 0.0f;
        this.f3525u8 = 0;
        this.f3527v8 = 0.0f;
        this.f3528w8 = false;
        this.f3529x8 = false;
        this.F8 = new w.g();
        this.G8 = false;
        this.I8 = null;
        this.J8 = null;
        this.K8 = 0;
        this.L8 = false;
        this.M8 = 0;
        this.N8 = new HashMap<>();
        this.R8 = new Rect();
        this.S8 = false;
        this.T8 = TransitionState.UNDEFINED;
        this.U8 = new h();
        this.V8 = false;
        this.W8 = new RectF();
        this.X8 = null;
        this.Y8 = null;
        this.Z8 = new ArrayList<>();
        O0(null);
    }

    public static boolean u1(float velocity, float position, float maxAcceleration) {
        if (velocity > 0.0f) {
            float f10 = velocity / maxAcceleration;
            return position + ((velocity * f10) - (((maxAcceleration * f10) * f10) / 2.0f)) > 1.0f;
        }
        float f11 = (-velocity) / maxAcceleration;
        return position + ((velocity * f11) + (((maxAcceleration * f11) * f11) / 2.0f)) < 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6 A[PHI: r2
  0x00e6: PHI (r2v48 float) = (r2v47 float), (r2v49 float), (r2v49 float) binds: [B:47:0x00ae, B:58:0x00da, B:60:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0(boolean r24) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.A0(boolean):void");
    }

    @Override // androidx.core.view.h0
    public void B(@n0 View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (this.f3512h8 || dxConsumed != 0 || dyConsumed != 0) {
            consumed[0] = consumed[0] + dxUnconsumed;
            consumed[1] = consumed[1] + dyUnconsumed;
        }
        this.f3512h8 = false;
    }

    public final void B0() {
        boolean z10;
        float fSignum = Math.signum(this.P7 - this.N7);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.K1;
        float interpolation = this.N7 + (!(interpolator instanceof a0.b) ? (((nanoTime - this.O7) * fSignum) * 1.0E-9f) / this.L7 : 0.0f);
        if (this.Q7) {
            interpolation = this.P7;
        }
        if ((fSignum <= 0.0f || interpolation < this.P7) && (fSignum > 0.0f || interpolation > this.P7)) {
            z10 = false;
        } else {
            interpolation = this.P7;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            interpolation = this.Y7 ? interpolator.getInterpolation((nanoTime - this.K7) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.P7) || (fSignum <= 0.0f && interpolation <= this.P7)) {
            interpolation = this.P7;
        }
        this.E8 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f3526v2;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            o oVar = this.J7.get(childAt);
            if (oVar != null) {
                oVar.L(childAt, interpolation, nanoTime2, this.F8);
            }
        }
        if (this.f3529x8) {
            requestLayout();
        }
    }

    public final void C0() {
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if ((this.T7 == null && ((copyOnWriteArrayList = this.f3521q8) == null || copyOnWriteArrayList.isEmpty())) || this.f3527v8 == this.M7) {
            return;
        }
        if (this.f3525u8 != -1) {
            l lVar = this.T7;
            if (lVar != null) {
                lVar.c(this, this.K2, this.F7);
            }
            CopyOnWriteArrayList<l> copyOnWriteArrayList2 = this.f3521q8;
            if (copyOnWriteArrayList2 != null) {
                Iterator<l> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().c(this, this.K2, this.F7);
                }
            }
            this.f3528w8 = true;
        }
        this.f3525u8 = -1;
        float f10 = this.M7;
        this.f3527v8 = f10;
        l lVar2 = this.T7;
        if (lVar2 != null) {
            lVar2.a(this, this.K2, this.F7, f10);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList3 = this.f3521q8;
        if (copyOnWriteArrayList3 != null) {
            Iterator<l> it3 = copyOnWriteArrayList3.iterator();
            while (it3.hasNext()) {
                it3.next().a(this, this.K2, this.F7, this.M7);
            }
        }
        this.f3528w8 = true;
    }

    @Override // androidx.core.view.g0
    public void D(@n0 View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
    }

    public void D0() {
        int iIntValue;
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if ((this.T7 != null || ((copyOnWriteArrayList = this.f3521q8) != null && !copyOnWriteArrayList.isEmpty())) && this.f3525u8 == -1) {
            this.f3525u8 = this.E7;
            if (this.Z8.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.Z8;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i10 = this.E7;
            if (iIntValue != i10 && i10 != -1) {
                this.Z8.add(Integer.valueOf(i10));
            }
        }
        X0();
        Runnable runnable = this.I8;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.J8;
        if (iArr == null || this.K8 <= 0) {
            return;
        }
        m1(iArr[0]);
        int[] iArr2 = this.J8;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.K8--;
    }

    public final void E0(MotionLayout motionLayout, int mBeginState, int mEndState) {
        l lVar = this.T7;
        if (lVar != null) {
            lVar.c(this, mBeginState, mEndState);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3521q8;
        if (copyOnWriteArrayList != null) {
            Iterator<l> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                it2.next().c(motionLayout, mBeginState, mEndState);
            }
        }
    }

    public void F0(int triggerId, boolean positive, float progress) {
        l lVar = this.T7;
        if (lVar != null) {
            lVar.d(this, triggerId, positive, progress);
        }
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3521q8;
        if (copyOnWriteArrayList != null) {
            Iterator<l> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                it2.next().d(this, triggerId, positive, progress);
            }
        }
    }

    @Override // androidx.core.view.g0
    public boolean G(@n0 View child, @n0 View target, int axes, int type) {
        t.b bVar;
        t tVar = this.C1;
        return (tVar == null || (bVar = tVar.f3908c) == null || bVar.J() == null || (this.C1.f3908c.J().f() & 2) != 0) ? false : true;
    }

    public void G0(int mTouchAnchorId, float pos, float locationX, float locationY, float[] mAnchorDpDt) {
        String resourceName;
        HashMap<View, o> map = this.J7;
        View viewS = s(mTouchAnchorId);
        o oVar = map.get(viewS);
        if (oVar != null) {
            oVar.p(pos, locationX, locationY, mAnchorDpDt);
            float y10 = viewS.getY();
            this.U7 = pos;
            this.V7 = y10;
            return;
        }
        if (viewS == null) {
            resourceName = "" + mTouchAnchorId;
        } else {
            resourceName = viewS.getContext().getResources().getResourceName(mTouchAnchorId);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("WARNING could not find view id ");
        sb2.append(resourceName);
    }

    @Override // androidx.core.view.g0
    public void H(@n0 View child, @n0 View target, int axes, int type) {
        this.f3515k8 = getNanoTime();
        this.f3516l8 = 0.0f;
        this.f3513i8 = 0.0f;
        this.f3514j8 = 0.0f;
    }

    public androidx.constraintlayout.widget.d H0(int id2) {
        t tVar = this.C1;
        if (tVar == null) {
            return null;
        }
        return tVar.o(id2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void I(int id2, int screenWidth, int screenHeight) {
        setState(TransitionState.SETUP);
        this.E7 = id2;
        this.K2 = -1;
        this.F7 = -1;
        androidx.constraintlayout.widget.b bVar = this.f4054k;
        if (bVar != null) {
            bVar.e(id2, screenWidth, screenHeight);
            return;
        }
        t tVar = this.C1;
        if (tVar != null) {
            tVar.o(id2).r(this);
        }
    }

    public String I0(int id2) {
        t tVar = this.C1;
        if (tVar == null) {
            return null;
        }
        return tVar.X(id2);
    }

    @Override // androidx.core.view.g0
    public void J(@n0 View target, int type) {
        t tVar = this.C1;
        if (tVar != null) {
            float f10 = this.f3516l8;
            if (f10 == 0.0f) {
                return;
            }
            tVar.e0(this.f3513i8 / f10, this.f3514j8 / f10);
        }
    }

    public void J0(boolean showPaths) {
        this.W7 = showPaths ? 2 : 1;
        invalidate();
    }

    @Override // androidx.core.view.g0
    public void K(@n0 View target, int dx, int dy, @n0 int[] consumed, int type) {
        t.b bVar;
        w wVarJ;
        int iS;
        t tVar = this.C1;
        if (tVar == null || (bVar = tVar.f3908c) == null || !bVar.K()) {
            return;
        }
        int i10 = -1;
        if (!bVar.K() || (wVarJ = bVar.J()) == null || (iS = wVarJ.s()) == -1 || target.getId() == iS) {
            if (tVar.D()) {
                w wVarJ2 = bVar.J();
                if (wVarJ2 != null && (wVarJ2.f() & 4) != 0) {
                    i10 = dy;
                }
                float f10 = this.M7;
                if ((f10 == 1.0f || f10 == 0.0f) && target.canScrollVertically(i10)) {
                    return;
                }
            }
            if (bVar.J() != null && (bVar.J().f() & 1) != 0) {
                float F = tVar.F(dx, dy);
                float f11 = this.N7;
                if ((f11 <= 0.0f && F < 0.0f) || (f11 >= 1.0f && F > 0.0f)) {
                    target.setNestedScrollingEnabled(false);
                    target.post(new c(this, target));
                    return;
                }
            }
            float f12 = this.M7;
            long nanoTime = getNanoTime();
            float f13 = dx;
            this.f3513i8 = f13;
            float f14 = dy;
            this.f3514j8 = f14;
            this.f3516l8 = (float) ((nanoTime - this.f3515k8) * 1.0E-9d);
            this.f3515k8 = nanoTime;
            tVar.d0(f13, f14);
            if (f12 != this.M7) {
                consumed[0] = dx;
                consumed[1] = dy;
            }
            A0(false);
            if (consumed[0] == 0 && consumed[1] == 0) {
                return;
            }
            this.f3512h8 = true;
        }
    }

    public o K0(int mTouchAnchorId) {
        return this.J7.get(findViewById(mTouchAnchorId));
    }

    public t.b L0(int id2) {
        return this.C1.O(id2);
    }

    public void M0(View view, float posOnViewX, float posOnViewY, float[] returnVelocity, int type) {
        float f10;
        float fA = this.C2;
        float f11 = this.N7;
        if (this.K1 != null) {
            float fSignum = Math.signum(this.P7 - f11);
            float interpolation = this.K1.getInterpolation(this.N7 + 1.0E-5f);
            float interpolation2 = this.K1.getInterpolation(this.N7);
            fA = (fSignum * ((interpolation - interpolation2) / 1.0E-5f)) / this.L7;
            f10 = interpolation2;
        } else {
            f10 = f11;
        }
        Interpolator interpolator = this.K1;
        if (interpolator instanceof r) {
            fA = ((r) interpolator).a();
        }
        o oVar = this.J7.get(view);
        if ((type & 1) == 0) {
            oVar.C(f10, view.getWidth(), view.getHeight(), posOnViewX, posOnViewY, returnVelocity);
        } else {
            oVar.p(f10, posOnViewX, posOnViewY, returnVelocity);
        }
        if (type < 2) {
            returnVelocity[0] = returnVelocity[0] * fA;
            returnVelocity[1] = returnVelocity[1] * fA;
        }
    }

    public final boolean N0(float x10, float y10, View view, MotionEvent event) {
        boolean z10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (N0((r3.getLeft() + x10) - view.getScrollX(), (r3.getTop() + y10) - view.getScrollY(), viewGroup.getChildAt(childCount), event)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.W8.set(x10, y10, (view.getRight() + x10) - view.getLeft(), (view.getBottom() + y10) - view.getTop());
            if ((event.getAction() != 0 || this.W8.contains(event.getX(), event.getY())) && p0(view, event, -x10, -y10)) {
                return true;
            }
        }
        return z10;
    }

    public final void O0(AttributeSet attrs) {
        t tVar;
        f3495k9 = isInEditMode();
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.C1 = new t(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.E7 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.P7 = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.R7 = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.W7 == 0) {
                        this.W7 = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.W7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (!z10) {
                this.C1 = null;
            }
        }
        if (this.W7 != 0) {
            q0();
        }
        if (this.E7 != -1 || (tVar = this.C1) == null) {
            return;
        }
        this.E7 = tVar.N();
        this.K2 = this.C1.N();
        this.F7 = this.C1.u();
    }

    public boolean P0() {
        return this.S8;
    }

    public boolean Q0() {
        return this.L8;
    }

    public boolean R0() {
        return this.I7;
    }

    public boolean S0(int viewTransitionId) {
        t tVar = this.C1;
        if (tVar != null) {
            return tVar.U(viewTransitionId);
        }
        return false;
    }

    public void T0(int id2) {
        if (!isAttachedToWindow()) {
            this.E7 = id2;
        }
        if (this.K2 == id2) {
            setProgress(0.0f);
        } else if (this.F7 == id2) {
            setProgress(1.0f);
        } else {
            e1(id2, id2);
        }
    }

    public int U0(String id2) {
        t tVar = this.C1;
        if (tVar == null) {
            return 0;
        }
        return tVar.W(id2);
    }

    public i V0() {
        return j.i();
    }

    public void W0() {
        t tVar = this.C1;
        if (tVar == null) {
            return;
        }
        if (tVar.i(this, this.E7)) {
            requestLayout();
            return;
        }
        int i10 = this.E7;
        if (i10 != -1) {
            this.C1.f(this, i10);
        }
        if (this.C1.r0()) {
            this.C1.p0();
        }
    }

    public final void X0() {
        CopyOnWriteArrayList<l> copyOnWriteArrayList;
        if (this.T7 == null && ((copyOnWriteArrayList = this.f3521q8) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f3528w8 = false;
        for (Integer num : this.Z8) {
            l lVar = this.T7;
            if (lVar != null) {
                lVar.k(this, num.intValue());
            }
            CopyOnWriteArrayList<l> copyOnWriteArrayList2 = this.f3521q8;
            if (copyOnWriteArrayList2 != null) {
                Iterator<l> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().k(this, num.intValue());
                }
            }
        }
        this.Z8.clear();
    }

    @Deprecated
    public void Y0() {
        Z0();
    }

    public void Z0() {
        this.U8.k();
        invalidate();
    }

    public boolean a1(l listener) {
        CopyOnWriteArrayList<l> copyOnWriteArrayList = this.f3521q8;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(listener);
    }

    @v0(api = 17)
    public void b1(int id2, int duration) {
        this.L8 = true;
        this.O8 = getWidth();
        this.P8 = getHeight();
        int rotation = getDisplay().getRotation();
        this.M8 = (rotation + 1) % 4 <= (this.Q8 + 1) % 4 ? 2 : 1;
        this.Q8 = rotation;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            a0.e eVar = this.N8.get(childAt);
            if (eVar == null) {
                eVar = new a0.e();
                this.N8.put(childAt, eVar);
            }
            eVar.a(childAt);
        }
        this.K2 = -1;
        this.F7 = id2;
        this.C1.n0(-1, id2);
        this.U8.h(this.f4046c, null, this.C1.o(this.F7));
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        invalidate();
        k1(new b());
        if (duration > 0) {
            this.L7 = duration / 1000.0f;
        }
    }

    public void c1(int id2) {
        if (getCurrentState() == -1) {
            m1(id2);
            return;
        }
        int[] iArr = this.J8;
        if (iArr == null) {
            this.J8 = new int[4];
        } else if (iArr.length <= this.K8) {
            this.J8 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.J8;
        int i10 = this.K8;
        this.K8 = i10 + 1;
        iArr2[i10] = id2;
    }

    public void d1(float pos, float velocity) {
        if (!isAttachedToWindow()) {
            if (this.H8 == null) {
                this.H8 = new k();
            }
            this.H8.e(pos);
            this.H8.h(velocity);
            return;
        }
        setProgress(pos);
        setState(TransitionState.MOVING);
        this.C2 = velocity;
        if (velocity != 0.0f) {
            n0(velocity <= 0.0f ? 0.0f : 1.0f);
        } else {
            if (pos == 0.0f || pos == 1.0f) {
                return;
            }
            n0(pos <= 0.5f ? 0.0f : 1.0f);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        b0 b0Var;
        ArrayList<p> arrayList = this.f3520p8;
        if (arrayList != null) {
            Iterator<p> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().h(canvas);
            }
        }
        A0(false);
        t tVar = this.C1;
        if (tVar != null && (b0Var = tVar.f3924s) != null) {
            b0Var.d();
        }
        super.dispatchDraw(canvas);
        if (this.C1 == null) {
            return;
        }
        if ((this.W7 & 1) == 1 && !isInEditMode()) {
            this.f3522r8++;
            long nanoTime = getNanoTime();
            long j10 = this.f3523s8;
            if (j10 != -1) {
                if (nanoTime - j10 > 200000000) {
                    this.f3524t8 = ((int) ((this.f3522r8 / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f3522r8 = 0;
                    this.f3523s8 = nanoTime;
                }
            } else {
                this.f3523s8 = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.f3524t8 + " fps " + androidx.constraintlayout.motion.widget.c.l(this, this.K2) + " -> ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(androidx.constraintlayout.motion.widget.c.l(this, this.F7));
            sb2.append(" (progress: ");
            sb2.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb2.append(" ) state=");
            int i10 = this.E7;
            sb2.append(i10 == -1 ? "undefined" : androidx.constraintlayout.motion.widget.c.l(this, i10));
            String string = sb2.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.W7 > 1) {
            if (this.X7 == null) {
                this.X7 = new g();
            }
            this.X7.a(canvas, this.J7, this.C1.t(), this.W7);
        }
        ArrayList<p> arrayList2 = this.f3520p8;
        if (arrayList2 != null) {
            Iterator<p> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                it3.next().i(canvas);
            }
        }
    }

    public void e1(int beginId, int endId) {
        if (!isAttachedToWindow()) {
            if (this.H8 == null) {
                this.H8 = new k();
            }
            this.H8.f(beginId);
            this.H8.d(endId);
            return;
        }
        t tVar = this.C1;
        if (tVar != null) {
            this.K2 = beginId;
            this.F7 = endId;
            tVar.n0(beginId, endId);
            this.U8.h(this.f4046c, this.C1.o(beginId), this.C1.o(endId));
            Z0();
            this.N7 = 0.0f;
            l1();
        }
    }

    public final void f1() {
        int childCount = getChildCount();
        this.U8.a();
        boolean z10 = true;
        this.R7 = true;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            sparseArray.put(childAt.getId(), this.J7.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iM = this.C1.m();
        if (iM != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                o oVar = this.J7.get(getChildAt(i12));
                if (oVar != null) {
                    oVar.U(iM);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.J7.size()];
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            o oVar2 = this.J7.get(getChildAt(i14));
            if (oVar2.k() != -1) {
                sparseBooleanArray.put(oVar2.k(), true);
                iArr[i13] = oVar2.k();
                i13++;
            }
        }
        if (this.f3520p8 != null) {
            for (int i15 = 0; i15 < i13; i15++) {
                o oVar3 = this.J7.get(findViewById(iArr[i15]));
                if (oVar3 != null) {
                    this.C1.z(oVar3);
                }
            }
            Iterator<p> it2 = this.f3520p8.iterator();
            while (it2.hasNext()) {
                it2.next().g(this, this.J7);
            }
            for (int i16 = 0; i16 < i13; i16++) {
                o oVar4 = this.J7.get(findViewById(iArr[i16]));
                if (oVar4 != null) {
                    oVar4.a0(width, height, this.L7, getNanoTime());
                }
            }
        } else {
            for (int i17 = 0; i17 < i13; i17++) {
                o oVar5 = this.J7.get(findViewById(iArr[i17]));
                if (oVar5 != null) {
                    this.C1.z(oVar5);
                    oVar5.a0(width, height, this.L7, getNanoTime());
                }
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            o oVar6 = this.J7.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && oVar6 != null) {
                this.C1.z(oVar6);
                oVar6.a0(width, height, this.L7, getNanoTime());
            }
        }
        float fM = this.C1.M();
        if (fM != 0.0f) {
            boolean z11 = ((double) fM) < 0.0d;
            float fAbs = Math.abs(fM);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            int i19 = 0;
            float fMin2 = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            while (true) {
                if (i19 >= childCount) {
                    z10 = false;
                    break;
                }
                o oVar7 = this.J7.get(getChildAt(i19));
                if (!Float.isNaN(oVar7.f3855m)) {
                    break;
                }
                float fT = oVar7.t();
                float fU = oVar7.u();
                float f10 = z11 ? fU - fT : fU + fT;
                fMin2 = Math.min(fMin2, f10);
                fMax2 = Math.max(fMax2, f10);
                i19++;
            }
            if (!z10) {
                while (i10 < childCount) {
                    o oVar8 = this.J7.get(getChildAt(i10));
                    float fT2 = oVar8.t();
                    float fU2 = oVar8.u();
                    float f11 = z11 ? fU2 - fT2 : fU2 + fT2;
                    oVar8.f3857o = 1.0f / (1.0f - fAbs);
                    oVar8.f3856n = fAbs - (((f11 - fMin2) * fAbs) / (fMax2 - fMin2));
                    i10++;
                }
                return;
            }
            for (int i20 = 0; i20 < childCount; i20++) {
                o oVar9 = this.J7.get(getChildAt(i20));
                if (!Float.isNaN(oVar9.f3855m)) {
                    fMin = Math.min(fMin, oVar9.f3855m);
                    fMax = Math.max(fMax, oVar9.f3855m);
                }
            }
            while (i10 < childCount) {
                o oVar10 = this.J7.get(getChildAt(i10));
                if (!Float.isNaN(oVar10.f3855m)) {
                    oVar10.f3857o = 1.0f / (1.0f - fAbs);
                    if (z11) {
                        oVar10.f3856n = fAbs - (((fMax - oVar10.f3855m) / (fMax - fMin)) * fAbs);
                    } else {
                        oVar10.f3856n = fAbs - (((oVar10.f3855m - fMin) * fAbs) / (fMax - fMin));
                    }
                }
                i10++;
            }
        }
    }

    public final Rect g1(ConstraintWidget cw) {
        this.R8.top = cw.p0();
        this.R8.left = cw.o0();
        Rect rect = this.R8;
        int iM0 = cw.m0();
        Rect rect2 = this.R8;
        rect.right = iM0 + rect2.left;
        int iD = cw.D();
        Rect rect3 = this.R8;
        rect2.bottom = iD + rect3.top;
        return rect3;
    }

    public int[] getConstraintSetIds() {
        t tVar = this.C1;
        if (tVar == null) {
            return null;
        }
        return tVar.r();
    }

    public int getCurrentState() {
        return this.E7;
    }

    public ArrayList<t.b> getDefinedTransitions() {
        t tVar = this.C1;
        if (tVar == null) {
            return null;
        }
        return tVar.s();
    }

    public androidx.constraintlayout.motion.widget.d getDesignTool() {
        if (this.f3506b8 == null) {
            this.f3506b8 = new androidx.constraintlayout.motion.widget.d(this);
        }
        return this.f3506b8;
    }

    public int getEndState() {
        return this.F7;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.N7;
    }

    public t getScene() {
        return this.C1;
    }

    public int getStartState() {
        return this.K2;
    }

    public float getTargetPosition() {
        return this.P7;
    }

    public Bundle getTransitionState() {
        if (this.H8 == null) {
            this.H8 = new k();
        }
        this.H8.c();
        return this.H8.b();
    }

    public long getTransitionTimeMs() {
        if (this.C1 != null) {
            this.L7 = r0.t() / 1000.0f;
        }
        return (long) (this.L7 * 1000.0f);
    }

    public float getVelocity() {
        return this.C2;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h1(int r10, float r11, float r12) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.h1(int, float, float):void");
    }

    public void i1(float position, float currentVelocity) {
        if (this.C1 == null || this.N7 == position) {
            return;
        }
        this.Y7 = true;
        this.K7 = getNanoTime();
        this.L7 = this.C1.t() / 1000.0f;
        this.P7 = position;
        this.R7 = true;
        this.Z7.f(this.N7, position, currentVelocity, this.C1.J(), this.C1.K(), this.C1.I(), this.C1.L(), this.C1.H());
        int i10 = this.E7;
        this.P7 = position;
        this.E7 = i10;
        this.K1 = this.Z7;
        this.Q7 = false;
        this.K7 = getNanoTime();
        invalidate();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j1() {
        n0(1.0f);
        this.I8 = null;
    }

    public void k1(Runnable onComplete) {
        n0(1.0f);
        this.I8 = onComplete;
    }

    public void l1() {
        n0(0.0f);
    }

    public void m0(l listener) {
        if (this.f3521q8 == null) {
            this.f3521q8 = new CopyOnWriteArrayList<>();
        }
        this.f3521q8.add(listener);
    }

    public void m1(int id2) {
        if (isAttachedToWindow()) {
            o1(id2, -1, -1);
            return;
        }
        if (this.H8 == null) {
            this.H8 = new k();
        }
        this.H8.d(id2);
    }

    public void n0(float position) {
        if (this.C1 == null) {
            return;
        }
        float f10 = this.N7;
        float f11 = this.M7;
        if (f10 != f11 && this.Q7) {
            this.N7 = f11;
        }
        float f12 = this.N7;
        if (f12 == position) {
            return;
        }
        this.Y7 = false;
        this.P7 = position;
        this.L7 = r0.t() / 1000.0f;
        setProgress(this.P7);
        this.K1 = null;
        this.f3526v2 = this.C1.x();
        this.Q7 = false;
        this.K7 = getNanoTime();
        this.R7 = true;
        this.M7 = f12;
        this.N7 = f12;
        invalidate();
    }

    public void n1(int id2, int duration) {
        if (isAttachedToWindow()) {
            p1(id2, -1, -1, duration);
            return;
        }
        if (this.H8 == null) {
            this.H8 = new k();
        }
        this.H8.d(id2);
    }

    public boolean o0(int viewTransitionId, o motionController) {
        t tVar = this.C1;
        if (tVar != null) {
            return tVar.h(viewTransitionId, motionController);
        }
        return false;
    }

    public void o1(int id2, int screenWidth, int screenHeight) {
        p1(id2, screenWidth, screenHeight, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        t.b bVar;
        int i10;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.Q8 = display.getRotation();
        }
        t tVar = this.C1;
        if (tVar != null && (i10 = this.E7) != -1) {
            androidx.constraintlayout.widget.d dVarO = tVar.o(i10);
            this.C1.h0(this);
            ArrayList<p> arrayList = this.f3520p8;
            if (arrayList != null) {
                Iterator<p> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this);
                }
            }
            if (dVarO != null) {
                dVarO.r(this);
            }
            this.K2 = this.E7;
        }
        W0();
        k kVar = this.H8;
        if (kVar != null) {
            if (this.S8) {
                post(new d());
                return;
            } else {
                kVar.a();
                return;
            }
        }
        t tVar2 = this.C1;
        if (tVar2 == null || (bVar = tVar2.f3908c) == null || bVar.z() != 4) {
            return;
        }
        j1();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        w wVarJ;
        int iS;
        RectF rectFR;
        t tVar = this.C1;
        if (tVar != null && this.I7) {
            b0 b0Var = tVar.f3924s;
            if (b0Var != null) {
                b0Var.l(event);
            }
            t.b bVar = this.C1.f3908c;
            if (bVar != null && bVar.K() && (wVarJ = bVar.J()) != null && ((event.getAction() != 0 || (rectFR = wVarJ.r(this, new RectF())) == null || rectFR.contains(event.getX(), event.getY())) && (iS = wVarJ.s()) != -1)) {
                View view = this.X8;
                if (view == null || view.getId() != iS) {
                    this.X8 = findViewById(iS);
                }
                if (this.X8 != null) {
                    this.W8.set(r0.getLeft(), this.X8.getTop(), this.X8.getRight(), this.X8.getBottom());
                    if (this.W8.contains(event.getX(), event.getY()) && !N0(this.X8.getLeft(), this.X8.getTop(), this.X8, event)) {
                        return onTouchEvent(event);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        this.G8 = true;
        try {
            if (this.C1 == null) {
                super.onLayout(changed, left, top2, right, bottom);
                return;
            }
            int i10 = right - left;
            int i11 = bottom - top2;
            if (this.f3510f8 != i10 || this.f3511g8 != i11) {
                Z0();
                A0(true);
            }
            this.f3510f8 = i10;
            this.f3511g8 = i11;
            this.f3508d8 = i10;
            this.f3509e8 = i11;
        } finally {
            this.G8 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.C1 == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        boolean z10 = false;
        boolean z11 = (this.G7 == widthMeasureSpec && this.H7 == heightMeasureSpec) ? false : true;
        if (this.V8) {
            this.V8 = false;
            W0();
            X0();
            z11 = true;
        }
        if (this.f4051h) {
            z11 = true;
        }
        this.G7 = widthMeasureSpec;
        this.H7 = heightMeasureSpec;
        int iN = this.C1.N();
        int iU = this.C1.u();
        if ((z11 || this.U8.i(iN, iU)) && this.K2 != -1) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.U8.h(this.f4046c, this.C1.o(iN), this.C1.o(iU));
            this.U8.k();
            this.U8.l(iN, iU);
        } else {
            if (z11) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
            z10 = true;
        }
        if (this.f3529x8 || z10) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iM0 = this.f4046c.m0() + getPaddingLeft() + getPaddingRight();
            int iD = this.f4046c.D() + paddingTop;
            int i10 = this.C8;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                iM0 = (int) (this.f3530y8 + (this.E8 * (this.A8 - r8)));
                requestLayout();
            }
            int i11 = this.D8;
            if (i11 == Integer.MIN_VALUE || i11 == 0) {
                iD = (int) (this.f3531z8 + (this.E8 * (this.B8 - r8)));
                requestLayout();
            }
            setMeasuredDimension(iM0, iD);
        }
        B0();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(@n0 View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(@n0 View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        t tVar = this.C1;
        if (tVar != null) {
            tVar.m0(v());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        t tVar = this.C1;
        if (tVar == null || !this.I7 || !tVar.r0()) {
            return super.onTouchEvent(event);
        }
        t.b bVar = this.C1.f3908c;
        if (bVar != null && !bVar.K()) {
            return super.onTouchEvent(event);
        }
        this.C1.f0(event, getCurrentState(), this);
        if (this.C1.f3908c.L(4)) {
            return this.C1.f3908c.J().t();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof p) {
            p pVar = (p) view;
            if (this.f3521q8 == null) {
                this.f3521q8 = new CopyOnWriteArrayList<>();
            }
            this.f3521q8.add(pVar);
            if (pVar.e()) {
                if (this.f3518n8 == null) {
                    this.f3518n8 = new ArrayList<>();
                }
                this.f3518n8.add(pVar);
            }
            if (pVar.f()) {
                if (this.f3519o8 == null) {
                    this.f3519o8 = new ArrayList<>();
                }
                this.f3519o8.add(pVar);
            }
            if (pVar.j()) {
                if (this.f3520p8 == null) {
                    this.f3520p8 = new ArrayList<>();
                }
                this.f3520p8.add(pVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<p> arrayList = this.f3518n8;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<p> arrayList2 = this.f3519o8;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final boolean p0(View view, MotionEvent event, float offsetX, float offsetY) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            event.offsetLocation(offsetX, offsetY);
            boolean zOnTouchEvent = view.onTouchEvent(event);
            event.offsetLocation(-offsetX, -offsetY);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        motionEventObtain.offsetLocation(offsetX, offsetY);
        if (this.Y8 == null) {
            this.Y8 = new Matrix();
        }
        matrix.invert(this.Y8);
        motionEventObtain.transform(this.Y8);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    public void p1(int id2, int screenWidth, int screenHeight, int duration) {
        androidx.constraintlayout.widget.j jVar;
        int iA;
        t tVar = this.C1;
        if (tVar != null && (jVar = tVar.f3907b) != null && (iA = jVar.a(this.E7, id2, screenWidth, screenHeight)) != -1) {
            id2 = iA;
        }
        int i10 = this.E7;
        if (i10 == id2) {
            return;
        }
        if (this.K2 == id2) {
            n0(0.0f);
            if (duration > 0) {
                this.L7 = duration / 1000.0f;
                return;
            }
            return;
        }
        if (this.F7 == id2) {
            n0(1.0f);
            if (duration > 0) {
                this.L7 = duration / 1000.0f;
                return;
            }
            return;
        }
        this.F7 = id2;
        if (i10 != -1) {
            e1(i10, id2);
            n0(1.0f);
            this.N7 = 0.0f;
            j1();
            if (duration > 0) {
                this.L7 = duration / 1000.0f;
                return;
            }
            return;
        }
        this.Y7 = false;
        this.P7 = 1.0f;
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.O7 = getNanoTime();
        this.K7 = getNanoTime();
        this.Q7 = false;
        this.K1 = null;
        if (duration == -1) {
            this.L7 = this.C1.t() / 1000.0f;
        }
        this.K2 = -1;
        this.C1.n0(-1, this.F7);
        SparseArray sparseArray = new SparseArray();
        if (duration == 0) {
            this.L7 = this.C1.t() / 1000.0f;
        } else if (duration > 0) {
            this.L7 = duration / 1000.0f;
        }
        int childCount = getChildCount();
        this.J7.clear();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            this.J7.put(childAt, new o(childAt));
            sparseArray.put(childAt.getId(), this.J7.get(childAt));
        }
        this.R7 = true;
        this.U8.h(this.f4046c, null, this.C1.o(id2));
        Z0();
        this.U8.a();
        u0();
        int width = getWidth();
        int height = getHeight();
        if (this.f3520p8 != null) {
            for (int i12 = 0; i12 < childCount; i12++) {
                o oVar = this.J7.get(getChildAt(i12));
                if (oVar != null) {
                    this.C1.z(oVar);
                }
            }
            Iterator<p> it2 = this.f3520p8.iterator();
            while (it2.hasNext()) {
                it2.next().g(this, this.J7);
            }
            for (int i13 = 0; i13 < childCount; i13++) {
                o oVar2 = this.J7.get(getChildAt(i13));
                if (oVar2 != null) {
                    oVar2.a0(width, height, this.L7, getNanoTime());
                }
            }
        } else {
            for (int i14 = 0; i14 < childCount; i14++) {
                o oVar3 = this.J7.get(getChildAt(i14));
                if (oVar3 != null) {
                    this.C1.z(oVar3);
                    oVar3.a0(width, height, this.L7, getNanoTime());
                }
            }
        }
        float fM = this.C1.M();
        if (fM != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i15 = 0; i15 < childCount; i15++) {
                o oVar4 = this.J7.get(getChildAt(i15));
                float fU = oVar4.u() + oVar4.t();
                fMin = Math.min(fMin, fU);
                fMax = Math.max(fMax, fU);
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                o oVar5 = this.J7.get(getChildAt(i16));
                float fT = oVar5.t();
                float fU2 = oVar5.u();
                oVar5.f3857o = 1.0f / (1.0f - fM);
                oVar5.f3856n = fM - ((((fT + fU2) - fMin) * fM) / (fMax - fMin));
            }
        }
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.R7 = true;
        invalidate();
    }

    public final void q0() {
        t tVar = this.C1;
        if (tVar == null) {
            return;
        }
        int iN = tVar.N();
        t tVar2 = this.C1;
        r0(iN, tVar2.o(tVar2.N()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (t.b bVar : this.C1.s()) {
            t.b bVar2 = this.C1.f3908c;
            s0(bVar);
            int I = bVar.I();
            int iB = bVar.B();
            String strI = androidx.constraintlayout.motion.widget.c.i(getContext(), I);
            String strI2 = androidx.constraintlayout.motion.widget.c.i(getContext(), iB);
            if (sparseIntArray.get(I) == iB) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CHECK: two transitions with the same start and end ");
                sb2.append(strI);
                sb2.append("->");
                sb2.append(strI2);
            }
            if (sparseIntArray2.get(iB) == I) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CHECK: you can't have reverse transitions");
                sb3.append(strI);
                sb3.append("->");
                sb3.append(strI2);
            }
            sparseIntArray.put(I, iB);
            sparseIntArray2.put(iB, I);
            if (this.C1.o(I) == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" no such constraintSetStart ");
                sb4.append(strI);
            }
            if (this.C1.o(iB) == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" no such constraintSetEnd ");
                sb5.append(strI);
            }
        }
    }

    public void q1() {
        this.U8.h(this.f4046c, this.C1.o(this.K2), this.C1.o(this.F7));
        Z0();
    }

    public final void r0(int csetId, androidx.constraintlayout.widget.d set) {
        String strI = androidx.constraintlayout.motion.widget.c.i(getContext(), csetId);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            if (id2 == -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CHECK: ");
                sb2.append(strI);
                sb2.append(" ALL VIEWS SHOULD HAVE ID's ");
                sb2.append(childAt.getClass().getName());
                sb2.append(" does not!");
            }
            if (set.k0(id2) == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("CHECK: ");
                sb3.append(strI);
                sb3.append(" NO CONSTRAINTS for ");
                sb3.append(androidx.constraintlayout.motion.widget.c.k(childAt));
            }
        }
        int[] iArrO0 = set.o0();
        for (int i11 = 0; i11 < iArrO0.length; i11++) {
            int i12 = iArrO0[i11];
            String strI2 = androidx.constraintlayout.motion.widget.c.i(getContext(), i12);
            if (findViewById(iArrO0[i11]) == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CHECK: ");
                sb4.append(strI);
                sb4.append(" NO View matches id ");
                sb4.append(strI2);
            }
            if (set.n0(i12) == -1) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("CHECK: ");
                sb5.append(strI);
                sb5.append(ee.a.f26978c);
                sb5.append(strI2);
                sb5.append(") no LAYOUT_HEIGHT");
            }
            if (set.u0(i12) == -1) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("CHECK: ");
                sb6.append(strI);
                sb6.append(ee.a.f26978c);
                sb6.append(strI2);
                sb6.append(") no LAYOUT_HEIGHT");
            }
        }
    }

    public void r1(int stateId, androidx.constraintlayout.widget.d set) {
        t tVar = this.C1;
        if (tVar != null) {
            tVar.j0(stateId, set);
        }
        q1();
        if (this.E7 == stateId) {
            set.r(this);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        t tVar;
        t.b bVar;
        if (!this.f3529x8 && this.E7 == -1 && (tVar = this.C1) != null && (bVar = tVar.f3908c) != null) {
            int iE = bVar.E();
            if (iE == 0) {
                return;
            }
            if (iE == 2) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    this.J7.get(getChildAt(i10)).P();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public final void s0(t.b transition) {
        transition.I();
        transition.B();
    }

    public void s1(int stateId, androidx.constraintlayout.widget.d set, int duration) {
        if (this.C1 != null && this.E7 == stateId) {
            int i10 = R.id.view_transition;
            r1(i10, H0(stateId));
            I(i10, -1, -1);
            r1(stateId, set);
            t.b bVar = new t.b(-1, this.C1, i10, stateId);
            bVar.O(duration);
            setTransition(bVar);
            j1();
        }
    }

    public void setDebugMode(int debugMode) {
        this.W7 = debugMode;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean delayedApply) {
        this.S8 = delayedApply;
    }

    public void setInteractionEnabled(boolean enabled) {
        this.I7 = enabled;
    }

    public void setInterpolatedProgress(float pos) {
        if (this.C1 != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolatorX = this.C1.x();
            if (interpolatorX != null) {
                setProgress(interpolatorX.getInterpolation(pos));
                return;
            }
        }
        setProgress(pos);
    }

    public void setOnHide(float progress) {
        ArrayList<p> arrayList = this.f3519o8;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3519o8.get(i10).setProgress(progress);
            }
        }
    }

    public void setOnShow(float progress) {
        ArrayList<p> arrayList = this.f3518n8;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3518n8.get(i10).setProgress(progress);
            }
        }
    }

    public void setProgress(float pos) {
        if (pos >= 0.0f) {
            int i10 = (pos > 1.0f ? 1 : (pos == 1.0f ? 0 : -1));
        }
        if (!isAttachedToWindow()) {
            if (this.H8 == null) {
                this.H8 = new k();
            }
            this.H8.e(pos);
            return;
        }
        if (pos <= 0.0f) {
            if (this.N7 == 1.0f && this.E7 == this.F7) {
                setState(TransitionState.MOVING);
            }
            this.E7 = this.K2;
            if (this.N7 == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (pos >= 1.0f) {
            if (this.N7 == 0.0f && this.E7 == this.K2) {
                setState(TransitionState.MOVING);
            }
            this.E7 = this.F7;
            if (this.N7 == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.E7 = -1;
            setState(TransitionState.MOVING);
        }
        if (this.C1 == null) {
            return;
        }
        this.Q7 = true;
        this.P7 = pos;
        this.M7 = pos;
        this.O7 = -1L;
        this.K7 = -1L;
        this.K1 = null;
        this.R7 = true;
        invalidate();
    }

    public void setScene(t scene) {
        this.C1 = scene;
        scene.m0(v());
        Z0();
    }

    public void setStartState(int beginId) {
        if (isAttachedToWindow()) {
            this.E7 = beginId;
            return;
        }
        if (this.H8 == null) {
            this.H8 = new k();
        }
        this.H8.f(beginId);
        this.H8.d(beginId);
    }

    public void setState(TransitionState newState) {
        TransitionState transitionState = TransitionState.FINISHED;
        if (newState == transitionState && this.E7 == -1) {
            return;
        }
        TransitionState transitionState2 = this.T8;
        this.T8 = newState;
        TransitionState transitionState3 = TransitionState.MOVING;
        if (transitionState2 == transitionState3 && newState == transitionState3) {
            C0();
        }
        int i10 = e.f3536a[transitionState2.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3 && newState == transitionState) {
                D0();
                return;
            }
            return;
        }
        if (newState == transitionState3) {
            C0();
        }
        if (newState == transitionState) {
            D0();
        }
    }

    public void setTransition(int transitionId) {
        if (this.C1 != null) {
            t.b bVarL0 = L0(transitionId);
            this.K2 = bVarL0.I();
            this.F7 = bVarL0.B();
            if (!isAttachedToWindow()) {
                if (this.H8 == null) {
                    this.H8 = new k();
                }
                this.H8.f(this.K2);
                this.H8.d(this.F7);
                return;
            }
            float f10 = Float.NaN;
            int i10 = this.E7;
            if (i10 == this.K2) {
                f10 = 0.0f;
            } else if (i10 == this.F7) {
                f10 = 1.0f;
            }
            this.C1.o0(bVarL0);
            this.U8.h(this.f4046c, this.C1.o(this.K2), this.C1.o(this.F7));
            Z0();
            if (this.N7 != f10) {
                if (f10 == 0.0f) {
                    z0(true);
                    this.C1.o(this.K2).r(this);
                } else if (f10 == 1.0f) {
                    z0(false);
                    this.C1.o(this.F7).r(this);
                }
            }
            this.N7 = Float.isNaN(f10) ? 0.0f : f10;
            if (!Float.isNaN(f10)) {
                setProgress(f10);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(androidx.constraintlayout.motion.widget.c.g());
            sb2.append(" transitionToStart ");
            l1();
        }
    }

    public void setTransitionDuration(int milliseconds) {
        t tVar = this.C1;
        if (tVar == null) {
            return;
        }
        tVar.k0(milliseconds);
    }

    public void setTransitionListener(l listener) {
        this.T7 = listener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.H8 == null) {
            this.H8 = new k();
        }
        this.H8.g(bundle);
        if (isAttachedToWindow()) {
            this.H8.a();
        }
    }

    public androidx.constraintlayout.widget.d t0(int id2) {
        t tVar = this.C1;
        if (tVar == null) {
            return null;
        }
        androidx.constraintlayout.widget.d dVarO = tVar.o(id2);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.I(dVarO);
        return dVar;
    }

    public void t1(int viewTransitionId, View... view) {
        t tVar = this.C1;
        if (tVar != null) {
            tVar.t0(viewTransitionId, view);
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.c.i(context, this.K2) + "->" + androidx.constraintlayout.motion.widget.c.i(context, this.F7) + " (pos:" + this.N7 + " Dpos/Dt:" + this.C2;
    }

    public final void u0() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            o oVar = this.J7.get(childAt);
            if (oVar != null) {
                oVar.V(childAt);
            }
        }
    }

    @SuppressLint({"LogConditional"})
    public final void v0() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i0.f11861z);
            sb2.append(androidx.constraintlayout.motion.widget.c.g());
            sb2.append(i0.f11861z);
            sb2.append(androidx.constraintlayout.motion.widget.c.k(this));
            sb2.append(i0.f11861z);
            sb2.append(androidx.constraintlayout.motion.widget.c.i(getContext(), this.E7));
            sb2.append(i0.f11861z);
            sb2.append(androidx.constraintlayout.motion.widget.c.k(childAt));
            sb2.append(childAt.getLeft());
            sb2.append(i0.f11861z);
            sb2.append(childAt.getTop());
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void w(int motionScene) {
        t.b bVar;
        if (motionScene == 0) {
            this.C1 = null;
            return;
        }
        try {
            t tVar = new t(getContext(), this, motionScene);
            this.C1 = tVar;
            if (this.E7 == -1) {
                this.E7 = tVar.N();
                this.K2 = this.C1.N();
                this.F7 = this.C1.u();
            }
            if (!isAttachedToWindow()) {
                this.C1 = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.Q8 = display == null ? 0 : display.getRotation();
                t tVar2 = this.C1;
                if (tVar2 != null) {
                    androidx.constraintlayout.widget.d dVarO = tVar2.o(this.E7);
                    this.C1.h0(this);
                    ArrayList<p> arrayList = this.f3520p8;
                    if (arrayList != null) {
                        Iterator<p> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next().b(this);
                        }
                    }
                    if (dVarO != null) {
                        dVarO.r(this);
                    }
                    this.K2 = this.E7;
                }
                W0();
                k kVar = this.H8;
                if (kVar != null) {
                    if (this.S8) {
                        post(new a());
                        return;
                    } else {
                        kVar.a();
                        return;
                    }
                }
                t tVar3 = this.C1;
                if (tVar3 == null || (bVar = tVar3.f3908c) == null || bVar.z() != 4) {
                    return;
                }
                j1();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e10) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e10);
            }
        } catch (Exception e11) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e11);
        }
    }

    public void w0(boolean disable) {
        t tVar = this.C1;
        if (tVar == null) {
            return;
        }
        tVar.k(disable);
    }

    public void x0(int transitionID, boolean enable) {
        t.b bVarL0 = L0(transitionID);
        if (enable) {
            bVarL0.Q(true);
            return;
        }
        t tVar = this.C1;
        if (bVarL0 == tVar.f3908c) {
            Iterator<t.b> it2 = tVar.Q(this.E7).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                t.b next = it2.next();
                if (next.K()) {
                    this.C1.f3908c = next;
                    break;
                }
            }
        }
        bVarL0.Q(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void y(int id2) {
        this.f4054k = null;
    }

    public void y0(int viewTransitionId, boolean enable) {
        t tVar = this.C1;
        if (tVar != null) {
            tVar.l(viewTransitionId, enable);
        }
    }

    public void z0(boolean start) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            o oVar = this.J7.get(getChildAt(i10));
            if (oVar != null) {
                oVar.i(start);
            }
        }
    }

    public void setTransition(t.b transition) {
        this.C1.o0(transition);
        setState(TransitionState.SETUP);
        if (this.E7 == this.C1.u()) {
            this.N7 = 1.0f;
            this.M7 = 1.0f;
            this.P7 = 1.0f;
        } else {
            this.N7 = 0.0f;
            this.M7 = 0.0f;
            this.P7 = 0.0f;
        }
        this.O7 = transition.L(1) ? -1L : getNanoTime();
        int iN = this.C1.N();
        int iU = this.C1.u();
        if (iN == this.K2 && iU == this.F7) {
            return;
        }
        this.K2 = iN;
        this.F7 = iU;
        this.C1.n0(iN, iU);
        this.U8.h(this.f4046c, this.C1.o(this.K2), this.C1.o(this.F7));
        this.U8.l(this.K2, this.F7);
        this.U8.k();
        Z0();
    }

    public MotionLayout(@n0 Context context, @p0 AttributeSet attrs) {
        super(context, attrs);
        this.f3526v2 = null;
        this.C2 = 0.0f;
        this.K2 = -1;
        this.E7 = -1;
        this.F7 = -1;
        this.G7 = 0;
        this.H7 = 0;
        this.I7 = true;
        this.J7 = new HashMap<>();
        this.K7 = 0L;
        this.L7 = 1.0f;
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.P7 = 0.0f;
        this.R7 = false;
        this.S7 = false;
        this.W7 = 0;
        this.Y7 = false;
        this.Z7 = new a0.b();
        this.f3505a8 = new f();
        this.f3507c8 = true;
        this.f3512h8 = false;
        this.f3517m8 = false;
        this.f3518n8 = null;
        this.f3519o8 = null;
        this.f3520p8 = null;
        this.f3521q8 = null;
        this.f3522r8 = 0;
        this.f3523s8 = -1L;
        this.f3524t8 = 0.0f;
        this.f3525u8 = 0;
        this.f3527v8 = 0.0f;
        this.f3528w8 = false;
        this.f3529x8 = false;
        this.F8 = new w.g();
        this.G8 = false;
        this.I8 = null;
        this.J8 = null;
        this.K8 = 0;
        this.L8 = false;
        this.M8 = 0;
        this.N8 = new HashMap<>();
        this.R8 = new Rect();
        this.S8 = false;
        this.T8 = TransitionState.UNDEFINED;
        this.U8 = new h();
        this.V8 = false;
        this.W8 = new RectF();
        this.X8 = null;
        this.Y8 = null;
        this.Z8 = new ArrayList<>();
        O0(attrs);
    }

    public MotionLayout(@n0 Context context, @p0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3526v2 = null;
        this.C2 = 0.0f;
        this.K2 = -1;
        this.E7 = -1;
        this.F7 = -1;
        this.G7 = 0;
        this.H7 = 0;
        this.I7 = true;
        this.J7 = new HashMap<>();
        this.K7 = 0L;
        this.L7 = 1.0f;
        this.M7 = 0.0f;
        this.N7 = 0.0f;
        this.P7 = 0.0f;
        this.R7 = false;
        this.S7 = false;
        this.W7 = 0;
        this.Y7 = false;
        this.Z7 = new a0.b();
        this.f3505a8 = new f();
        this.f3507c8 = true;
        this.f3512h8 = false;
        this.f3517m8 = false;
        this.f3518n8 = null;
        this.f3519o8 = null;
        this.f3520p8 = null;
        this.f3521q8 = null;
        this.f3522r8 = 0;
        this.f3523s8 = -1L;
        this.f3524t8 = 0.0f;
        this.f3525u8 = 0;
        this.f3527v8 = 0.0f;
        this.f3528w8 = false;
        this.f3529x8 = false;
        this.F8 = new w.g();
        this.G8 = false;
        this.I8 = null;
        this.J8 = null;
        this.K8 = 0;
        this.L8 = false;
        this.M8 = 0;
        this.N8 = new HashMap<>();
        this.R8 = new Rect();
        this.S8 = false;
        this.T8 = TransitionState.UNDEFINED;
        this.U8 = new h();
        this.V8 = false;
        this.W8 = new RectF();
        this.X8 = null;
        this.Y8 = null;
        this.Z8 = new ArrayList<>();
        O0(attrs);
    }
}
