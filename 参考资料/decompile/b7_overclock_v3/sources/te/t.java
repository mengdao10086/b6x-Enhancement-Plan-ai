package te;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.t0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class t implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f51231c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @t0
    public int f51233b = -1;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51235b;

        public a(View view, float f10) {
            this.f51234a = view;
            this.f51235b = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f51234a.setTranslationX(this.f51235b);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51237b;

        public b(View view, float f10) {
            this.f51236a = view;
            this.f51237b = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f51236a.setTranslationY(this.f51237b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface c {
    }

    public t(int i10) {
        this.f51232a = i10;
    }

    public static Animator c(View view, View view2, int i10, @t0 int i11) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return e(view2, i11 + translationX, translationX, translationX);
        }
        if (i10 == 5) {
            return e(view2, translationX - i11, translationX, translationX);
        }
        if (i10 == 48) {
            return f(view2, translationY - i11, translationY, translationY);
        }
        if (i10 == 80) {
            return f(view2, i11 + translationY, translationY, translationY);
        }
        if (i10 == 8388611) {
            return e(view2, j(view) ? i11 + translationX : translationX - i11, translationX, translationX);
        }
        if (i10 == 8388613) {
            return e(view2, j(view) ? translationX - i11 : i11 + translationX, translationX, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i10);
    }

    public static Animator d(View view, View view2, int i10, @t0 int i11) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i10 == 3) {
            return e(view2, translationX, translationX - i11, translationX);
        }
        if (i10 == 5) {
            return e(view2, translationX, i11 + translationX, translationX);
        }
        if (i10 == 48) {
            return f(view2, translationY, i11 + translationY, translationY);
        }
        if (i10 == 80) {
            return f(view2, translationY, translationY - i11, translationY);
        }
        if (i10 == 8388611) {
            return e(view2, translationX, j(view) ? translationX - i11 : i11 + translationX, translationX);
        }
        if (i10 == 8388613) {
            return e(view2, translationX, j(view) ? i11 + translationX : translationX - i11, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i10);
    }

    public static Animator e(View view, float f10, float f11, float f12) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f10, f11));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, f12));
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static Animator f(View view, float f10, float f11, float f12) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f10, f11));
        objectAnimatorOfPropertyValuesHolder.addListener(new b(view, f12));
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static boolean j(View view) {
        return u0.Z(view) == 1;
    }

    @Override // te.w
    @p0
    public Animator a(@n0 ViewGroup viewGroup, @n0 View view) {
        return c(viewGroup, view, this.f51232a, h(view.getContext()));
    }

    @Override // te.w
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        return d(viewGroup, view, this.f51232a, h(view.getContext()));
    }

    @t0
    public int g() {
        return this.f51233b;
    }

    public final int h(Context context) {
        int i10 = this.f51233b;
        return i10 != -1 ? i10 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    public int i() {
        return this.f51232a;
    }

    public void k(@t0 int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.f51233b = i10;
    }

    public void l(int i10) {
        this.f51232a = i10;
    }
}
