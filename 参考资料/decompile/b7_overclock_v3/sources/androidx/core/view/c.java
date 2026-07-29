package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@g.v0(16)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final c f4844a = new c();

    @g.u
    @hk.m
    public static final void a(@yt.k View view, @yt.k Runnable action, long j10) {
        kotlin.jvm.internal.f0.p(view, "view");
        kotlin.jvm.internal.f0.p(action, "action");
        view.postOnAnimationDelayed(action, j10);
    }
}
