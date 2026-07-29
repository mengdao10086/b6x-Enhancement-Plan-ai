package com.uc.crashsdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23026a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f23027b = false;

    private void a(Activity activity, int i10) {
        if (1 == i10) {
            String unused = b.f22993ad = activity.getComponentName().flattenToShortString();
        } else {
            String unused2 = b.f22993ad = "";
        }
        b.D();
        if (g.L()) {
            b.O();
            synchronized (b.f22991ab) {
                b.f22991ab.put(activity, Integer.valueOf(i10));
                a(i10);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (g.L()) {
            b.O();
            synchronized (b.f22991ab) {
                b.f22991ab.remove(activity);
                a(2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, 2);
    }

    private void a(int i10) {
        if (e.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", "[LifeCycle] ignore state change while crashing");
            return;
        }
        boolean z10 = true;
        boolean z11 = 1 == i10;
        if (z11) {
            z10 = z11;
        } else {
            Iterator it2 = b.f22991ab.entrySet().iterator();
            while (it2.hasNext()) {
                Object value = ((Map.Entry) it2.next()).getValue();
                if (value != null && ((Integer) value).intValue() == 1) {
                    break;
                }
            }
            z10 = z11;
        }
        if (this.f23026a != z10) {
            b.b(z10);
            this.f23026a = z10;
        }
        boolean zIsEmpty = b.f22991ab.isEmpty();
        if (this.f23027b != zIsEmpty) {
            if (zIsEmpty) {
                b.w();
            }
            this.f23027b = zIsEmpty;
        }
    }
}
