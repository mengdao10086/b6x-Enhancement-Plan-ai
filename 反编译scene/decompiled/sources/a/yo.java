package a;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yo extends RecyclerView.n implements RecyclerView.s {
    public static final int[] c = {R.attr.state_pressed};
    public static final int[] d = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f3752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StateListDrawable f3753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f3755a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f3759b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f3760b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final StateListDrawable f3761b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f3764c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f3765d;
    public final int e;
    public final int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = 0;
    public int l = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3757a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3762b = false;
    public int m = 0;
    public int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f3758a = new int[2];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f3763b = new int[2];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueAnimator f3751a = ValueAnimator.ofFloat(0.0f, 1.0f);
    public int o = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f3756a = new uo(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RecyclerView.t f3754a = new vo(this);

    public yo(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f3753a = stateListDrawable;
        this.f3752a = drawable;
        this.f3761b = stateListDrawable2;
        this.f3760b = drawable2;
        this.f3764c = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f3765d = Math.max(i, drawable.getIntrinsicWidth());
        this.e = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f = Math.max(i, drawable2.getIntrinsicWidth());
        this.f3750a = i2;
        this.f3759b = i3;
        this.f3753a.setAlpha(255);
        this.f3752a.setAlpha(255);
        this.f3751a.addListener(new wo(this));
        this.f3751a.addUpdateListener(new xo(this));
        k(recyclerView);
    }

    public final void A() {
        this.f3755a.h(this);
        this.f3755a.k(this);
        this.f3755a.l(this.f3754a);
    }

    public void B() {
        int i = this.o;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.f3751a.cancel();
            }
        }
        this.o = 1;
        ValueAnimator valueAnimator = this.f3751a;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f3751a.setDuration(500L);
        this.f3751a.setStartDelay(0L);
        this.f3751a.start();
    }

    public void C(int i, int i2) {
        int iComputeVerticalScrollRange = this.f3755a.computeVerticalScrollRange();
        int i3 = this.l;
        this.f3757a = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.f3750a;
        int iComputeHorizontalScrollRange = this.f3755a.computeHorizontalScrollRange();
        int i4 = this.k;
        boolean z = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.f3750a;
        this.f3762b = z;
        if (!this.f3757a && !z) {
            if (this.m != 0) {
                z(0);
                return;
            }
            return;
        }
        if (this.f3757a) {
            float f = i3;
            this.h = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.g = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.f3762b) {
            float f2 = i4;
            this.j = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.i = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.m;
        if (i5 == 0 || i5 == 1) {
            z(1);
        }
    }

    public final void D(float f) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f));
        if (Math.abs(this.h - fMax) < 2.0f) {
            return;
        }
        int iY = y(this.f7997a, fMax, iArrQ, this.f3755a.computeVerticalScrollRange(), this.f3755a.computeVerticalScrollOffset(), this.l);
        if (iY != 0) {
            this.f3755a.scrollBy(0, iY);
        }
        this.f7997a = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.m;
        if (i == 1) {
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zV && !zU) {
                return false;
            }
            if (zU) {
                this.n = 1;
                this.b = (int) motionEvent.getX();
            } else if (zV) {
                this.n = 2;
                this.f7997a = (int) motionEvent.getY();
            }
            z(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void d(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.m == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            if (zV || zU) {
                if (zU) {
                    this.n = 1;
                    this.b = (int) motionEvent.getX();
                } else if (zV) {
                    this.n = 2;
                    this.f7997a = (int) motionEvent.getY();
                }
                z(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.m == 2) {
            this.f7997a = 0.0f;
            this.b = 0.0f;
            z(1);
            this.n = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.m == 2) {
            B();
            if (this.n == 1) {
                s(motionEvent.getX());
            }
            if (this.n == 2) {
                D(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void j(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.k != this.f3755a.getWidth() || this.l != this.f3755a.getHeight()) {
            this.k = this.f3755a.getWidth();
            this.l = this.f3755a.getHeight();
            z(0);
        } else if (this.o != 0) {
            if (this.f3757a) {
                o(canvas);
            }
            if (this.f3762b) {
                n(canvas);
            }
        }
    }

    public void k(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3755a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m();
        }
        this.f3755a = recyclerView;
        if (recyclerView != null) {
            A();
        }
    }

    public final void l() {
        this.f3755a.removeCallbacks(this.f3756a);
    }

    public final void m() {
        this.f3755a.V0(this);
        this.f3755a.X0(this);
        this.f3755a.Y0(this.f3754a);
        l();
    }

    public final void n(Canvas canvas) {
        int i = this.l;
        int i2 = this.e;
        int i3 = this.j;
        int i4 = this.i;
        this.f3761b.setBounds(0, 0, i4, i2);
        this.f3760b.setBounds(0, 0, this.k, this.f);
        canvas.translate(0.0f, i - i2);
        this.f3760b.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.f3761b.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void o(Canvas canvas) {
        int i = this.k;
        int i2 = this.f3764c;
        int i3 = i - i2;
        int i4 = this.h;
        int i5 = this.g;
        int i6 = i4 - (i5 / 2);
        this.f3753a.setBounds(0, 0, i2, i5);
        this.f3752a.setBounds(0, 0, this.f3765d, this.l);
        if (t()) {
            this.f3752a.draw(canvas);
            canvas.translate(this.f3764c, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f3753a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i3 = this.f3764c;
        } else {
            canvas.translate(i3, 0.0f);
            this.f3752a.draw(canvas);
            canvas.translate(0.0f, i6);
            this.f3753a.draw(canvas);
        }
        canvas.translate(-i3, -i6);
    }

    public final int[] p() {
        int[] iArr = this.f3763b;
        int i = this.f3759b;
        iArr[0] = i;
        iArr[1] = this.k - i;
        return iArr;
    }

    public final int[] q() {
        int[] iArr = this.f3758a;
        int i = this.f3759b;
        iArr[0] = i;
        iArr[1] = this.l - i;
        return iArr;
    }

    public void r(int i) {
        int i2 = this.o;
        if (i2 == 1) {
            this.f3751a.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.o = 3;
        ValueAnimator valueAnimator = this.f3751a;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f3751a.setDuration(i);
        this.f3751a.start();
    }

    public final void s(float f) {
        int[] iArrP = p();
        float fMax = Math.max(iArrP[0], Math.min(iArrP[1], f));
        if (Math.abs(this.j - fMax) < 2.0f) {
            return;
        }
        int iY = y(this.b, fMax, iArrP, this.f3755a.computeHorizontalScrollRange(), this.f3755a.computeHorizontalScrollOffset(), this.k);
        if (iY != 0) {
            this.f3755a.scrollBy(iY, 0);
        }
        this.b = fMax;
    }

    public final boolean t() {
        return eh.y(this.f3755a) == 1;
    }

    public boolean u(float f, float f2) {
        if (f2 >= this.l - this.e) {
            int i = this.j;
            int i2 = this.i;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean v(float f, float f2) {
        if (!t() ? f >= this.k - this.f3764c : f <= this.f3764c / 2) {
            int i = this.h;
            int i2 = this.g;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void w() {
        this.f3755a.invalidate();
    }

    public final void x(int i) {
        l();
        this.f3755a.postDelayed(this.f3756a, i);
    }

    public final int y(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    public void z(int i) {
        int i2;
        if (i == 2 && this.m != 2) {
            this.f3753a.setState(c);
            l();
        }
        if (i == 0) {
            w();
        } else {
            B();
        }
        if (this.m != 2 || i == 2) {
            i2 = i == 1 ? 1500 : 1200;
            this.m = i;
        }
        this.f3753a.setState(d);
        x(i2);
        this.m = i;
    }
}
