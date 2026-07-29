package be;

import android.animation.Animator;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public Animator f9387a;

    public void a() {
        Animator animator = this.f9387a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f9387a = null;
    }

    public void c(Animator animator) {
        a();
        this.f9387a = animator;
    }
}
