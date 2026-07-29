package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    public interface InterfaceC0073a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public static void a(@n0 Animator animator, @n0 AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void b(@n0 Animator animator) {
        animator.pause();
    }

    public static void c(@n0 Animator animator) {
        animator.resume();
    }
}
