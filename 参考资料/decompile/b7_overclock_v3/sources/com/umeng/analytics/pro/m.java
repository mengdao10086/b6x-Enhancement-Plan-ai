package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static m f23681a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23682b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23683c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23684d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f23685e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<n> f23686f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f23687g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f23683c || !m.this.f23684d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f23683c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i10 = 0; i10 < m.this.f23686f.size(); i10++) {
                ((n) m.this.f23686f.get(i10)).n();
            }
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f23684d = true;
        a aVar = this.f23687g;
        if (aVar != null) {
            this.f23685e.removeCallbacks(aVar);
            this.f23685e.postDelayed(this.f23687g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f23684d = false;
        this.f23683c = true;
        a aVar = this.f23687g;
        if (aVar != null) {
            this.f23685e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i10 = 0; i10 < this.f23686f.size(); i10++) {
                if (this.f23686f.get(i10) == nVar) {
                    this.f23686f.remove(i10);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f23681a);
        }
    }

    public static m a() {
        return f23681a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f23686f.add(nVar);
        }
    }
}
