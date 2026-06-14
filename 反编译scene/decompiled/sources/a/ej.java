package a;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ej implements View.OnTouchListener {
    public static final int c = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f745a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f747b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f749c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cj f742a = new cj();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Interpolator f744a = new AccelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f746a = {0.0f, 0.0f};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float[] f748b = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float[] f750c = {0.0f, 0.0f};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public float[] f751d = {0.0f, 0.0f};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public float[] f752e = {Float.MAX_VALUE, Float.MAX_VALUE};

    public ej(View view) {
        this.f743a = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        o(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        p(f3, f3);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(c);
        r(500);
        q(500);
    }

    public static float e(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    public static int f(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f743a.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i, float f, float f2, float f3) {
        float fH = h(this.f746a[i], f2, this.f748b[i], f);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f750c[i];
        float f5 = this.f751d[i];
        float f6 = this.f752e[i];
        float f7 = f4 * f3;
        return fH > 0.0f ? e(fH * f7, f5, f6) : -e((-fH) * f7, f5, f6);
    }

    public final float g(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f6010a;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.e && this.f6010a == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public final float h(float f, float f2, float f3, float f4) {
        float interpolation;
        float fE = e(f * f2, 0.0f, f3);
        float fG = g(f2 - f4, fE) - g(f4, fE);
        if (fG < 0.0f) {
            interpolation = -this.f744a.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f744a.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f749c) {
            this.e = false;
        } else {
            this.f742a.i();
        }
    }

    public abstract void j(int i, int i2);

    public ej k(int i) {
        this.b = i;
        return this;
    }

    public ej l(int i) {
        this.f6010a = i;
        return this;
    }

    public ej m(boolean z) {
        if (this.f && !z) {
            i();
        }
        this.f = z;
        return this;
    }

    public ej n(float f, float f2) {
        float[] fArr = this.f748b;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public ej o(float f, float f2) {
        float[] fArr = this.f752e;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.d = r2
            r5.f747b = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f743a
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f743a
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            a.cj r7 = r5.f742a
            r7.l(r0, r6)
            boolean r6 = r5.e
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.g
            if (r6 == 0) goto L61
            boolean r6 = r5.e
            if (r6 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ej.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public ej p(float f, float f2) {
        float[] fArr = this.f751d;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public ej q(int i) {
        this.f742a.j(i);
        return this;
    }

    public ej r(int i) {
        this.f742a.k(i);
        return this;
    }

    public ej s(float f, float f2) {
        float[] fArr = this.f746a;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    public ej t(float f, float f2) {
        float[] fArr = this.f750c;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    public boolean u() {
        cj cjVar = this.f742a;
        int iF = cjVar.f();
        int iD = cjVar.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }

    public final void v() {
        int i;
        if (this.f745a == null) {
            this.f745a = new dj(this);
        }
        this.e = true;
        this.f749c = true;
        if (this.f747b || (i = this.b) <= 0) {
            this.f745a.run();
        } else {
            eh.d0(this.f743a, this.f745a, i);
        }
        this.f747b = true;
    }
}
