package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import g.n0;
import g.p0;
import java.util.List;
import kd.h;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void a();

    h b();

    @g.b
    int c();

    void d();

    @p0
    h e();

    boolean f();

    void g(@n0 Animator.AnimatorListener animatorListener);

    void h(@n0 Animator.AnimatorListener animatorListener);

    void i();

    void j(@p0 h hVar);

    AnimatorSet k();

    List<Animator.AnimatorListener> l();

    void m(@p0 ExtendedFloatingActionButton.j jVar);

    void onAnimationStart(Animator animator);
}
