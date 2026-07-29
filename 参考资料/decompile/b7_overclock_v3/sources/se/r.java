package se;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f49799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f49800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f49801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f49802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f49803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49804f;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f49805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f49806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f49807c;

        public a(View view, float f10, float f11) {
            this.f49805a = view;
            this.f49806b = f10;
            this.f49807c = f11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f49805a.setScaleX(this.f49806b);
            this.f49805a.setScaleY(this.f49807c);
        }
    }

    public r() {
        this(true);
    }

    public static Animator c(View view, float f10, float f11) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f10, scaleX * f11), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f10 * scaleY, f11 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // se.v
    @p0
    public Animator a(@n0 ViewGroup viewGroup, @n0 View view) {
        return this.f49803e ? c(view, this.f49801c, this.f49802d) : c(view, this.f49800b, this.f49799a);
    }

    @Override // se.v
    @p0
    public Animator b(@n0 ViewGroup viewGroup, @n0 View view) {
        if (this.f49804f) {
            return this.f49803e ? c(view, this.f49799a, this.f49800b) : c(view, this.f49802d, this.f49801c);
        }
        return null;
    }

    public float d() {
        return this.f49802d;
    }

    public float e() {
        return this.f49801c;
    }

    public float f() {
        return this.f49800b;
    }

    public float g() {
        return this.f49799a;
    }

    public boolean h() {
        return this.f49803e;
    }

    public boolean i() {
        return this.f49804f;
    }

    public void j(boolean z10) {
        this.f49803e = z10;
    }

    public void k(float f10) {
        this.f49802d = f10;
    }

    public void l(float f10) {
        this.f49801c = f10;
    }

    public void m(float f10) {
        this.f49800b = f10;
    }

    public void n(float f10) {
        this.f49799a = f10;
    }

    public void o(boolean z10) {
        this.f49804f = z10;
    }

    public r(boolean z10) {
        this.f49799a = 1.0f;
        this.f49800b = 1.1f;
        this.f49801c = 0.8f;
        this.f49802d = 1.0f;
        this.f49804f = true;
        this.f49803e = z10;
    }
}
