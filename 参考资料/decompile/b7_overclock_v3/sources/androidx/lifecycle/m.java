package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@yt.k Activity activity, @yt.l Bundle bundle) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@yt.k Activity activity, @yt.k Bundle outState) {
        kotlin.jvm.internal.f0.p(activity, "activity");
        kotlin.jvm.internal.f0.p(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
    }
}
