package androidx.core.animation;

import android.animation.Animator;
import g.u;
import g.v0;
import hk.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@v0(19)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f4588a = new a();

    @u
    @m
    public static final void a(@k Animator animator, @k Animator.AnimatorPauseListener listener) {
        f0.p(animator, "animator");
        f0.p(listener, "listener");
        animator.addPauseListener(listener);
    }
}
