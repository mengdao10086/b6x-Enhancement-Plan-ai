package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import g.i1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@i1
public class k extends RecyclerView.n implements RecyclerView.s {
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 500;
    public static final int O = 1500;
    public static final int P = 1200;
    public static final int Q = 500;
    public static final int R = 255;
    public static final int[] S = {R.attr.state_pressed};
    public static final int[] T = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.t C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f7064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f7065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f7067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f7068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f7069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f7070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @i1
    public int f7072k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @i1
    public int f7073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @i1
    public float f7074m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @i1
    public int f7075n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @i1
    public int f7076o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @i1
    public float f7077p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f7080s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f7087z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7078q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7079r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7081t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7082u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7083v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7084w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f7085x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f7086y = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.t(500);
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i10, int i11) {
            k.this.G(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7090a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7090a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7090a) {
                this.f7090a = false;
                return;
            }
            if (((Float) k.this.f7087z.getAnimatedValue()).floatValue() == 0.0f) {
                k kVar = k.this;
                kVar.A = 0;
                kVar.D(0);
            } else {
                k kVar2 = k.this;
                kVar2.A = 2;
                kVar2.A();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            k.this.f7064c.setAlpha(iFloatValue);
            k.this.f7065d.setAlpha(iFloatValue);
            k.this.A();
        }
    }

    public k(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7087z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f7064c = stateListDrawable;
        this.f7065d = drawable;
        this.f7068g = stateListDrawable2;
        this.f7069h = drawable2;
        this.f7066e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f7067f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f7070i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f7071j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f7062a = i11;
        this.f7063b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        i(recyclerView);
    }

    public void A() {
        this.f7080s.invalidate();
    }

    public final void B(int i10) {
        j();
        this.f7080s.postDelayed(this.B, i10);
    }

    public final int C(float f10, float f11, int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[1] - iArr[0];
        if (i13 == 0) {
            return 0;
        }
        int i14 = i10 - i12;
        int i15 = (int) (((f11 - f10) / i13) * i14);
        int i16 = i11 + i15;
        if (i16 >= i14 || i16 < 0) {
            return 0;
        }
        return i15;
    }

    public void D(int i10) {
        if (i10 == 2 && this.f7083v != 2) {
            this.f7064c.setState(S);
            j();
        }
        if (i10 == 0) {
            A();
        } else {
            F();
        }
        if (this.f7083v == 2 && i10 != 2) {
            this.f7064c.setState(T);
            B(P);
        } else if (i10 == 1) {
            B(1500);
        }
        this.f7083v = i10;
    }

    public final void E() {
        this.f7080s.n(this);
        this.f7080s.q(this);
        this.f7080s.r(this.C);
    }

    public void F() {
        int i10 = this.A;
        if (i10 != 0) {
            if (i10 != 3) {
                return;
            } else {
                this.f7087z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f7087z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f7087z.setDuration(500L);
        this.f7087z.setStartDelay(0L);
        this.f7087z.start();
    }

    public void G(int i10, int i11) {
        int iComputeVerticalScrollRange = this.f7080s.computeVerticalScrollRange();
        int i12 = this.f7079r;
        this.f7081t = iComputeVerticalScrollRange - i12 > 0 && i12 >= this.f7062a;
        int iComputeHorizontalScrollRange = this.f7080s.computeHorizontalScrollRange();
        int i13 = this.f7078q;
        boolean z10 = iComputeHorizontalScrollRange - i13 > 0 && i13 >= this.f7062a;
        this.f7082u = z10;
        boolean z11 = this.f7081t;
        if (!z11 && !z10) {
            if (this.f7083v != 0) {
                D(0);
                return;
            }
            return;
        }
        if (z11) {
            float f10 = i12;
            this.f7073l = (int) ((f10 * (i11 + (f10 / 2.0f))) / iComputeVerticalScrollRange);
            this.f7072k = Math.min(i12, (i12 * i12) / iComputeVerticalScrollRange);
        }
        if (this.f7082u) {
            float f11 = i13;
            this.f7076o = (int) ((f11 * (i10 + (f11 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f7075n = Math.min(i13, (i13 * i13) / iComputeHorizontalScrollRange);
        }
        int i14 = this.f7083v;
        if (i14 == 0 || i14 == 1) {
            D(1);
        }
    }

    public final void H(float f10) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f10));
        if (Math.abs(this.f7073l - fMax) < 2.0f) {
            return;
        }
        int iC = C(this.f7074m, fMax, iArrQ, this.f7080s.computeVerticalScrollRange(), this.f7080s.computeVerticalScrollOffset(), this.f7079r);
        if (iC != 0) {
            this.f7080s.scrollBy(0, iC);
        }
        this.f7074m = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        if (this.f7078q != this.f7080s.getWidth() || this.f7079r != this.f7080s.getHeight()) {
            this.f7078q = this.f7080s.getWidth();
            this.f7079r = this.f7080s.getHeight();
            D(0);
        } else if (this.A != 0) {
            if (this.f7081t) {
                m(canvas);
            }
            if (this.f7082u) {
                l(canvas);
            }
        }
    }

    public void i(@p0 RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7080s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            k();
        }
        this.f7080s = recyclerView;
        if (recyclerView != null) {
            E();
        }
    }

    public final void j() {
        this.f7080s.removeCallbacks(this.B);
    }

    public final void k() {
        this.f7080s.q1(this);
        this.f7080s.t1(this);
        this.f7080s.u1(this.C);
        j();
    }

    public final void l(Canvas canvas) {
        int i10 = this.f7079r;
        int i11 = this.f7070i;
        int i12 = this.f7076o;
        int i13 = this.f7075n;
        this.f7068g.setBounds(0, 0, i13, i11);
        this.f7069h.setBounds(0, 0, this.f7078q, this.f7071j);
        canvas.translate(0.0f, i10 - i11);
        this.f7069h.draw(canvas);
        canvas.translate(i12 - (i13 / 2), 0.0f);
        this.f7068g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void m(Canvas canvas) {
        int i10 = this.f7078q;
        int i11 = this.f7066e;
        int i12 = i10 - i11;
        int i13 = this.f7073l;
        int i14 = this.f7072k;
        int i15 = i13 - (i14 / 2);
        this.f7064c.setBounds(0, 0, i11, i14);
        this.f7065d.setBounds(0, 0, this.f7067f, this.f7079r);
        if (!w()) {
            canvas.translate(i12, 0.0f);
            this.f7065d.draw(canvas);
            canvas.translate(0.0f, i15);
            this.f7064c.draw(canvas);
            canvas.translate(-i12, -i15);
            return;
        }
        this.f7065d.draw(canvas);
        canvas.translate(this.f7066e, i15);
        canvas.scale(-1.0f, 1.0f);
        this.f7064c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f7066e, -i15);
    }

    public final int[] n() {
        int[] iArr = this.f7086y;
        int i10 = this.f7063b;
        iArr[0] = i10;
        iArr[1] = this.f7078q - i10;
        return iArr;
    }

    @i1
    public Drawable o() {
        return this.f7068g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean onInterceptTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
        int i10 = this.f7083v;
        if (i10 == 1) {
            boolean zY = y(motionEvent.getX(), motionEvent.getY());
            boolean zX = x(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zY && !zX) {
                return false;
            }
            if (zX) {
                this.f7084w = 1;
                this.f7077p = (int) motionEvent.getX();
            } else if (zY) {
                this.f7084w = 2;
                this.f7074m = (int) motionEvent.getY();
            }
            D(2);
        } else if (i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void onTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
        if (this.f7083v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zY = y(motionEvent.getX(), motionEvent.getY());
            boolean zX = x(motionEvent.getX(), motionEvent.getY());
            if (zY || zX) {
                if (zX) {
                    this.f7084w = 1;
                    this.f7077p = (int) motionEvent.getX();
                } else if (zY) {
                    this.f7084w = 2;
                    this.f7074m = (int) motionEvent.getY();
                }
                D(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f7083v == 2) {
            this.f7074m = 0.0f;
            this.f7077p = 0.0f;
            D(1);
            this.f7084w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f7083v == 2) {
            F();
            if (this.f7084w == 1) {
                u(motionEvent.getX());
            }
            if (this.f7084w == 2) {
                H(motionEvent.getY());
            }
        }
    }

    @i1
    public Drawable p() {
        return this.f7069h;
    }

    public final int[] q() {
        int[] iArr = this.f7085x;
        int i10 = this.f7063b;
        iArr[0] = i10;
        iArr[1] = this.f7079r - i10;
        return iArr;
    }

    @i1
    public Drawable r() {
        return this.f7064c;
    }

    @i1
    public Drawable s() {
        return this.f7065d;
    }

    @i1
    public void t(int i10) {
        int i11 = this.A;
        if (i11 == 1) {
            this.f7087z.cancel();
        } else if (i11 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f7087z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f7087z.setDuration(i10);
        this.f7087z.start();
    }

    public final void u(float f10) {
        int[] iArrN = n();
        float fMax = Math.max(iArrN[0], Math.min(iArrN[1], f10));
        if (Math.abs(this.f7076o - fMax) < 2.0f) {
            return;
        }
        int iC = C(this.f7077p, fMax, iArrN, this.f7080s.computeHorizontalScrollRange(), this.f7080s.computeHorizontalScrollOffset(), this.f7078q);
        if (iC != 0) {
            this.f7080s.scrollBy(iC, 0);
        }
        this.f7077p = fMax;
    }

    public boolean v() {
        return this.f7083v == 2;
    }

    public final boolean w() {
        return u0.Z(this.f7080s) == 1;
    }

    @i1
    public boolean x(float f10, float f11) {
        if (f11 >= this.f7079r - this.f7070i) {
            int i10 = this.f7076o;
            int i11 = this.f7075n;
            if (f10 >= i10 - (i11 / 2) && f10 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    @i1
    public boolean y(float f10, float f11) {
        if (!w() ? f10 >= this.f7078q - this.f7066e : f10 <= this.f7066e / 2) {
            int i10 = this.f7073l;
            int i11 = this.f7072k;
            if (f11 >= i10 - (i11 / 2) && f11 <= i10 + (i11 / 2)) {
                return true;
            }
        }
        return false;
    }

    @i1
    public boolean z() {
        return this.f7083v == 1;
    }
}
