package rx_activity_result2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import dj.o;
import dj.r;
import g.p0;
import java.util.concurrent.TimeUnit;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f49223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Activity f49224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f49225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f49226d = false;

    /* JADX INFO: renamed from: rx_activity_result2.a$a, reason: collision with other inner class name */
    public class C0562a implements Application.ActivityLifecycleCallbacks {
        public C0562a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.this.f49224b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            a.this.f49224b = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            a.this.f49224b = activity;
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
    }

    public class b implements o<Object, Activity> {
        public b() {
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Activity apply(Object obj) throws Exception {
            return (Activity) obj;
        }
    }

    public class c implements r<Object> {
        public c() {
        }

        @Override // dj.r
        public boolean a(Object obj) throws Exception {
            return obj instanceof Activity;
        }
    }

    public class d implements r<Object> {
        public d() {
        }

        @Override // dj.r
        public boolean a(Object obj) throws Exception {
            boolean z10 = !a.this.f49226d;
            if (obj instanceof Activity) {
                a.this.f49226d = true;
            }
            return z10;
        }
    }

    public class e implements o<Long, Object> {
        public e() {
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Long l10) throws Exception {
            if (a.this.f49224b == null) {
                return 0;
            }
            return a.this.f49224b;
        }
    }

    public a(Application application) {
        this.f49223a = application;
        c();
    }

    @p0
    public Activity a() {
        return this.f49224b;
    }

    public z<Activity> b() {
        this.f49226d = false;
        return z.e3(50L, 50L, TimeUnit.MILLISECONDS).A3(new e()).o6(new d()).h2(new c()).A3(new b());
    }

    public final void c() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f49225c;
        if (activityLifecycleCallbacks != null) {
            this.f49223a.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        C0562a c0562a = new C0562a();
        this.f49225c = c0562a;
        this.f49223a.registerActivityLifecycleCallbacks(c0562a);
    }
}
