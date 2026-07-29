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
public final class e implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f51096b = 0.35f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f51097a = 0.35f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f51100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f51101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f51102e;

        public a(View view, float f10, float f11, float f12, float f13) {
            this.f51098a = view;
            this.f51099b = f10;
            this.f51100c = f11;
            this.f51101d = f12;
            this.f51102e = f13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f51098a.setAlpha(v.l(this.f51099b, this.f51100c, this.f51101d, this.f51102e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51104b;

        public b(View view, float f10) {
            this.f51103a = view;
            this.f51104b = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f51103a.setAlpha(this.f51104b);
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
        return c(view, 0.0f, alpha, this.f51097a, 1.0f, alpha);
    }

    @Override // te.w
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.f51097a, alpha);
    }

    public float d() {
        return this.f51097a;
    }

    public void e(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f51097a = f10;
    }
}
