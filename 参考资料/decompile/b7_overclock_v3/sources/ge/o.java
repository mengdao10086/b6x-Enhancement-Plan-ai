package ge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.R;
import g.i1;
import g.n0;
import h2.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends k<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f29358l = 1800;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f29359m = {gg.b.f29510y0, 567, 850, 750};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f29360n = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Property<o, Float> f29361o = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f29362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f29363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator[] f29364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ge.c f29365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f29367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f29368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b.a f29369k;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            o oVar = o.this;
            oVar.f29366h = (oVar.f29366h + 1) % o.this.f29365g.f29274c.length;
            o.this.f29367i = true;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            o.this.a();
            o oVar = o.this;
            b.a aVar = oVar.f29369k;
            if (aVar != null) {
                aVar.b(oVar.f29340a);
            }
        }
    }

    public class c extends Property<o, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(o oVar) {
            return Float.valueOf(oVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(o oVar, Float f10) {
            oVar.r(f10.floatValue());
        }
    }

    public o(@n0 Context context, @n0 q qVar) {
        super(2);
        this.f29366h = 0;
        this.f29369k = null;
        this.f29365g = qVar;
        this.f29364f = new Interpolator[]{h2.d.b(context, R.anim.linear_indeterminate_line1_head_interpolator), h2.d.b(context, R.anim.linear_indeterminate_line1_tail_interpolator), h2.d.b(context, R.anim.linear_indeterminate_line2_head_interpolator), h2.d.b(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // ge.k
    public void a() {
        ObjectAnimator objectAnimator = this.f29362d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ge.k
    public void c() {
        q();
    }

    @Override // ge.k
    public void d(@n0 b.a aVar) {
        this.f29369k = aVar;
    }

    @Override // ge.k
    public void f() {
        ObjectAnimator objectAnimator = this.f29363e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.f29340a.isVisible()) {
            this.f29363e.setFloatValues(this.f29368j, 1.0f);
            this.f29363e.setDuration((long) ((1.0f - this.f29368j) * 1800.0f));
            this.f29363e.start();
        }
    }

    @Override // ge.k
    public void g() {
        o();
        q();
        this.f29362d.start();
    }

    @Override // ge.k
    public void h() {
        this.f29369k = null;
    }

    public final float n() {
        return this.f29368j;
    }

    public final void o() {
        if (this.f29362d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f29361o, 0.0f, 1.0f);
            this.f29362d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f29362d.setInterpolator(null);
            this.f29362d.setRepeatCount(-1);
            this.f29362d.addListener(new a());
        }
        if (this.f29363e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f29361o, 1.0f);
            this.f29363e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f29363e.setInterpolator(null);
            this.f29363e.addListener(new b());
        }
    }

    public final void p() {
        if (this.f29367i) {
            Arrays.fill(this.f29342c, vd.m.a(this.f29365g.f29274c[this.f29366h], this.f29340a.getAlpha()));
            this.f29367i = false;
        }
    }

    @i1
    public void q() {
        this.f29366h = 0;
        int iA = vd.m.a(this.f29365g.f29274c[0], this.f29340a.getAlpha());
        int[] iArr = this.f29342c;
        iArr[0] = iA;
        iArr[1] = iA;
    }

    @i1
    public void r(float f10) {
        this.f29368j = f10;
        s((int) (f10 * 1800.0f));
        p();
        this.f29340a.invalidateSelf();
    }

    public final void s(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            this.f29341b[i11] = Math.max(0.0f, Math.min(1.0f, this.f29364f[i11].getInterpolation(b(i10, f29360n[i11], f29359m[i11]))));
        }
    }
}
