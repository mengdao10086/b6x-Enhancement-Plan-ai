package se;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.p0;
import g.x;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f49705b = 0.35f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f49706a = 0.35f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f49707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f49708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f49709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f49710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ float f49711e;

        public a(View view, float f10, float f11, float f12, float f13) {
            this.f49707a = view;
            this.f49708b = f10;
            this.f49709c = f11;
            this.f49710d = f12;
            this.f49711e = f13;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f49707a.setAlpha(u.l(this.f49708b, this.f49709c, this.f49710d, this.f49711e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f49712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f49713b;

        public b(View view, float f10) {
            this.f49712a = view;
            this.f49713b = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f49712a.setAlpha(this.f49713b);
        }
    }

    public static Animator c(View view, float f10, float f11, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f12, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f13, float f14) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f10, f11, f12, f13));
        valueAnimatorOfFloat.addListener(new b(view, f14));
        return valueAnimatorOfFloat;
    }

    @Override // se.v
    @p0
    public Animator a(@n0 ViewGroup viewGroup, @n0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, this.f49706a, 1.0f, alpha);
    }

    @Override // se.v
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.f49706a, alpha);
    }

    public float d() {
        return this.f49706a;
    }

    public void e(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f49706a = f10;
    }
}
