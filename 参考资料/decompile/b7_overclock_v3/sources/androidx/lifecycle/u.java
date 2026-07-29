package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import g.i1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final u f6258a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicBoolean f6259b = new AtomicBoolean(false);

    @i1
    public static final class a extends m {
        @Override // androidx.lifecycle.m, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@yt.k Activity activity, @yt.l Bundle bundle) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.d(activity);
        }
    }

    @hk.m
    public static final void a(@yt.k Context context) {
        kotlin.jvm.internal.f0.p(context, "context");
        if (f6259b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.f0.n(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
