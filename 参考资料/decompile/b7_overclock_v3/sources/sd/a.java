package sd;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import g.n0;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: sd.a$a, reason: collision with other inner class name */
    public class C0571a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f49662a;

        public C0571a(g gVar) {
            this.f49662a = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f49662a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f49662a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public static Animator a(@n0 g gVar, float f10, float f11, float f12) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(gVar, (Property<g, V>) g.c.f49684a, (TypeEvaluator) g.b.f49682b, (Object[]) new g.e[]{new g.e(f10, f11, f12)});
        g.e revealInfo = gVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) gVar, (int) f10, (int) f11, revealInfo.f49689c, f12);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public static Animator b(g gVar, float f10, float f11, float f12, float f13) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(gVar, (Property<g, V>) g.c.f49684a, (TypeEvaluator) g.b.f49682b, (Object[]) new g.e[]{new g.e(f10, f11, f12), new g.e(f10, f11, f13)});
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) gVar, (int) f10, (int) f11, f12, f13);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    @n0
    public static Animator.AnimatorListener c(@n0 g gVar) {
        return new C0571a(gVar);
    }
}
