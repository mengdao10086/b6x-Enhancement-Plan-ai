package a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bb implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f254a = false;
    public boolean b = false;
    public boolean c = false;

    public bb(Activity activity) {
        this.f252a = activity;
        this.f5690a = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f252a == activity) {
            this.f252a = null;
            this.b = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (!this.b || this.c || this.f254a || !cb.h(this.f253a, this.f5690a, activity)) {
            return;
        }
        this.c = true;
        this.f253a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f252a == activity) {
            this.f254a = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
