package dl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes5.dex */
@TargetApi(11)
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f26286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26287c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MagicIndicator> f26285a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26288d = 150;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Interpolator f26289e = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f26290f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f26291g = new C0298b();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.e(0);
            b.this.f26286b = null;
        }
    }

    /* JADX INFO: renamed from: dl.b$b, reason: collision with other inner class name */
    public class C0298b implements ValueAnimator.AnimatorUpdateListener {
        public C0298b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i10 = (int) fFloatValue;
            float f10 = fFloatValue - i10;
            if (fFloatValue < 0.0f) {
                i10--;
                f10 += 1.0f;
            }
            b.this.f(i10, f10, 0);
        }
    }

    public b() {
    }

    public static kl.a h(List<kl.a> list, int i10) {
        kl.a aVar;
        if (i10 >= 0 && i10 <= list.size() - 1) {
            return list.get(i10);
        }
        kl.a aVar2 = new kl.a();
        if (i10 < 0) {
            aVar = list.get(0);
        } else {
            i10 = (i10 - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.f37414a = aVar.f37414a + (aVar.f() * i10);
        aVar2.f37415b = aVar.f37415b;
        aVar2.f37416c = aVar.f37416c + (aVar.f() * i10);
        aVar2.f37417d = aVar.f37417d;
        aVar2.f37418e = aVar.f37418e + (aVar.f() * i10);
        aVar2.f37419f = aVar.f37419f;
        aVar2.f37420g = aVar.f37420g + (i10 * aVar.f());
        aVar2.f37421h = aVar.f37421h;
        return aVar2;
    }

    public void d(MagicIndicator magicIndicator) {
        this.f26285a.add(magicIndicator);
    }

    public final void e(int i10) {
        Iterator<MagicIndicator> it2 = this.f26285a.iterator();
        while (it2.hasNext()) {
            it2.next().a(i10);
        }
    }

    public final void f(int i10, float f10, int i11) {
        Iterator<MagicIndicator> it2 = this.f26285a.iterator();
        while (it2.hasNext()) {
            it2.next().b(i10, f10, i11);
        }
    }

    public final void g(int i10) {
        Iterator<MagicIndicator> it2 = this.f26285a.iterator();
        while (it2.hasNext()) {
            it2.next().c(i10);
        }
    }

    public void i(int i10) {
        j(i10, true);
    }

    public void j(int i10, boolean z10) {
        if (this.f26287c == i10) {
            return;
        }
        if (z10) {
            ValueAnimator valueAnimator = this.f26286b;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e(2);
            }
            g(i10);
            float fFloatValue = this.f26287c;
            ValueAnimator valueAnimator2 = this.f26286b;
            if (valueAnimator2 != null) {
                fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                this.f26286b.cancel();
                this.f26286b = null;
            }
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.f26286b = valueAnimator3;
            valueAnimator3.setFloatValues(fFloatValue, i10);
            this.f26286b.addUpdateListener(this.f26291g);
            this.f26286b.addListener(this.f26290f);
            this.f26286b.setInterpolator(this.f26289e);
            this.f26286b.setDuration(this.f26288d);
            this.f26286b.start();
        } else {
            g(i10);
            ValueAnimator valueAnimator4 = this.f26286b;
            if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                f(this.f26287c, 0.0f, 0);
            }
            e(0);
            f(i10, 0.0f, 0);
        }
        this.f26287c = i10;
    }

    public void k(int i10) {
        this.f26288d = i10;
    }

    public void l(Interpolator interpolator) {
        if (interpolator == null) {
            this.f26289e = new AccelerateDecelerateInterpolator();
        } else {
            this.f26289e = interpolator;
        }
    }

    public b(MagicIndicator magicIndicator) {
        this.f26285a.add(magicIndicator);
    }
}
