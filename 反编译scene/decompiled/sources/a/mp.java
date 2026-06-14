package a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class mp implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueAnimator f1972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RecyclerView.d0 f1973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1974a;
    public final float b;
    public final float c;
    public final float d;
    public float e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1975b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1976c = false;

    public mp(RecyclerView.d0 d0Var, int i, int i2, float f, float f2, float f3, float f4) {
        this.f1971a = i2;
        this.f1973a = d0Var;
        this.f6830a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1972a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new lp(this));
        this.f1972a.setTarget(d0Var.f4387a);
        this.f1972a.addListener(this);
        c(0.0f);
    }

    public void a() {
        this.f1972a.cancel();
    }

    public void b(long j) {
        this.f1972a.setDuration(j);
    }

    public void c(float f) {
        this.g = f;
    }

    public void d() {
        this.f1973a.G(false);
        this.f1972a.start();
    }

    public void e() {
        float f = this.f6830a;
        float f2 = this.c;
        this.e = f == f2 ? this.f1973a.f4387a.getTranslationX() : f + (this.g * (f2 - f));
        float f3 = this.b;
        float f4 = this.d;
        this.f = f3 == f4 ? this.f1973a.f4387a.getTranslationY() : f3 + (this.g * (f4 - f3));
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        c(1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f1976c) {
            this.f1973a.G(true);
        }
        this.f1976c = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
