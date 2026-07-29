package te;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class s implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f51222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f51226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f51227f;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f51229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f51230c;

        public a(View view, float f10, float f11) {
            this.f51228a = view;
            this.f51229b = f10;
            this.f51230c = f11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f51228a.setScaleX(this.f51229b);
            this.f51228a.setScaleY(this.f51230c);
        }
    }

    public s() {
        this(true);
    }

    public static Animator c(View view, float f10, float f11) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f10, scaleX * f11), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f10 * scaleY, f11 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // te.w
    @p0
    public Animator a(@n0 ViewGroup viewGroup, @n0 View view) {
        return this.f51226e ? c(view, this.f51224c, this.f51225d) : c(view, this.f51223b, this.f51222a);
    }

    @Override // te.w
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        if (this.f51227f) {
            return this.f51226e ? c(view, this.f51222a, this.f51223b) : c(view, this.f51225d, this.f51224c);
        }
        return null;
    }

    public float d() {
        return this.f51225d;
    }

    public float e() {
        return this.f51224c;
    }

    public float f() {
        return this.f51223b;
    }

    public float g() {
        return this.f51222a;
    }

    public boolean h() {
        return this.f51226e;
    }

    public boolean i() {
        return this.f51227f;
    }

    public void j(boolean z10) {
        this.f51226e = z10;
    }

    public void k(float f10) {
        this.f51225d = f10;
    }

    public void l(float f10) {
        this.f51224c = f10;
    }

    public void m(float f10) {
        this.f51223b = f10;
    }

    public void n(float f10) {
        this.f51222a = f10;
    }

    public void o(boolean z10) {
        this.f51227f = z10;
    }

    public s(boolean z10) {
        this.f51222a = 1.0f;
        this.f51223b = 1.1f;
        this.f51224c = 0.8f;
        this.f51225d = 1.0f;
        this.f51227f = true;
        this.f51226e = z10;
    }
}
