package ge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.common.collect.LinkedHashMultimap;
import g.i1;
import g.n0;
import g.p0;
import g.x;
import h2.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends Drawable implements h2.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f29319o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f29320p = 500;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Property<i, Float> f29321q = new c(Float.class, "growFraction");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f29322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ge.c f29323b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f29325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f29326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f29328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f29329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<b.a> f29330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b.a f29331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f29332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f29333l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f29335n;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f29334m = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ge.a f29324c = new ge.a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            i.this.h();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            i.super.setVisible(false, false);
            i.this.g();
        }
    }

    public class c extends Property<i, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(i iVar) {
            return Float.valueOf(iVar.j());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, Float f10) {
            iVar.p(f10.floatValue());
        }
    }

    public i(@n0 Context context, @n0 ge.c cVar) {
        this.f29322a = context;
        this.f29323b = cVar;
        setAlpha(255);
    }

    public boolean b(@n0 b.a aVar) {
        List<b.a> list = this.f29330i;
        if (list == null || !list.contains(aVar)) {
            return false;
        }
        this.f29330i.remove(aVar);
        if (!this.f29330i.isEmpty()) {
            return true;
        }
        this.f29330i = null;
        return true;
    }

    public void c(@n0 b.a aVar) {
        if (this.f29330i == null) {
            this.f29330i = new ArrayList();
        }
        if (this.f29330i.contains(aVar)) {
            return;
        }
        this.f29330i.add(aVar);
    }

    public void d() {
        this.f29330i.clear();
        this.f29330i = null;
    }

    public final void g() {
        b.a aVar = this.f29331j;
        if (aVar != null) {
            aVar.b(this);
        }
        List<b.a> list = this.f29330i;
        if (list == null || this.f29332k) {
            return;
        }
        Iterator<b.a> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f29335n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h() {
        b.a aVar = this.f29331j;
        if (aVar != null) {
            aVar.c(this);
        }
        List<b.a> list = this.f29330i;
        if (list == null || this.f29332k) {
            return;
        }
        Iterator<b.a> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().c(this);
        }
    }

    public final void i(@n0 ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f29332k;
        this.f29332k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f29332k = z10;
    }

    public boolean isRunning() {
        return n() || m();
    }

    public float j() {
        if (this.f29323b.b() || this.f29323b.a()) {
            return (this.f29328g || this.f29327f) ? this.f29329h : this.f29333l;
        }
        return 1.0f;
    }

    @n0
    public ValueAnimator k() {
        return this.f29326e;
    }

    public boolean l() {
        return v(false, false, false);
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f29326e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f29328g;
    }

    public boolean n() {
        ValueAnimator valueAnimator = this.f29325d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f29327f;
    }

    public final void o() {
        if (this.f29325d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f29321q, 0.0f, 1.0f);
            this.f29325d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f29325d.setInterpolator(kd.a.f37167b);
            u(this.f29325d);
        }
        if (this.f29326e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f29321q, 1.0f, 0.0f);
            this.f29326e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f29326e.setInterpolator(kd.a.f37167b);
            q(this.f29326e);
        }
    }

    public void p(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        if (this.f29333l != f10) {
            this.f29333l = f10;
            invalidateSelf();
        }
    }

    public final void q(@n0 ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f29326e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f29326e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    public void r(@n0 b.a aVar) {
        this.f29331j = aVar;
    }

    @i1
    public void s(boolean z10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f29328g = z10;
        this.f29329h = f10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f29335n = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@p0 ColorFilter colorFilter) {
        this.f29334m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return v(z10, z11, true);
    }

    public void start() {
        w(true, true, false);
    }

    public void stop() {
        w(false, true, false);
    }

    @i1
    public void t(boolean z10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f29327f = z10;
        this.f29329h = f10;
    }

    public final void u(@n0 ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f29325d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f29325d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public boolean v(boolean z10, boolean z11, boolean z12) {
        return w(z10, z11, z12 && this.f29324c.a(this.f29322a.getContentResolver()) > 0.0f);
    }

    public boolean w(boolean z10, boolean z11, boolean z12) {
        o();
        if (!isVisible() && !z10) {
            return false;
        }
        ValueAnimator valueAnimator = z10 ? this.f29325d : this.f29326e;
        if (!z12) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                i(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (z12 && valueAnimator.isRunning()) {
            return false;
        }
        boolean z13 = !z10 || super.setVisible(z10, false);
        if (!(z10 ? this.f29323b.b() : this.f29323b.a())) {
            i(valueAnimator);
            return z13;
        }
        if (z11 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z13;
    }
}
