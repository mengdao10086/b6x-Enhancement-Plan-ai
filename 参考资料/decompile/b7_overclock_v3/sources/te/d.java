package te;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.p0;
import g.v0;
import g.x;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class d implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f51088a = 1.0f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f51091c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f51092d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f51093e;

        public a(View view, float f10, float f11, float f12, float f13) {
            this.f51089a = view;
            this.f51090b = f10;
            this.f51091c = f11;
            this.f51092d = f12;
            this.f51093e = f13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f51089a.setAlpha(v.l(this.f51090b, this.f51091c, this.f51092d, this.f51093e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51095b;

        public b(View view, float f10) {
            this.f51094a = view;
            this.f51095b = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f51094a.setAlpha(this.f51095b);
        }
    }

    public static Animator c(View view, float f10, float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f13, float f14) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f10, f11, f12, f13));
        valueAnimatorOfFloat.addListener(new b(view, f14));
        return valueAnimatorOfFloat;
    }

    @Override // te.w
    @p0
    public Animator a(@n0 ViewGroup viewGroup, @n0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, 0.0f, this.f51088a, alpha);
    }

    @Override // te.w
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    public float d() {
        return this.f51088a;
    }

    public void e(float f10) {
        this.f51088a = f10;
    }
}
