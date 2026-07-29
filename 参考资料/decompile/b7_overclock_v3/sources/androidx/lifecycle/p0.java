package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class p0 extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final b f6231b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final String f6232c = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public a f6233a;

    public interface a {
        void b();

        void c();

        void d();
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        public static /* synthetic */ void c(Activity activity) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @hk.m
        public final void a(@yt.k Activity activity, @yt.k Lifecycle.Event event) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            kotlin.jvm.internal.f0.p(event, "event");
            if (activity instanceof c0) {
                ((c0) activity).e().l(event);
            } else if (activity instanceof y) {
                Lifecycle lifecycleE = ((y) activity).e();
                if (lifecycleE instanceof a0) {
                    ((a0) lifecycleE).l(event);
                }
            }
        }

        @hk.h(name = "get")
        @yt.k
        public final p0 b(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag(p0.f6232c);
            kotlin.jvm.internal.f0.n(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (p0) fragmentFindFragmentByTag;
        }

        @hk.m
        public final void d(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag(p0.f6232c) == null) {
                fragmentManager.beginTransaction().add(new p0(), p0.f6232c).commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    @g.v0(29)
    public static final class c implements Application.ActivityLifecycleCallbacks {

        @yt.k
        public static final a Companion = new a(null);

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }

            @hk.m
            public final void a(@yt.k Activity activity) {
                kotlin.jvm.internal.f0.p(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }
        }

        @hk.m
        public static final void registerIn(@yt.k Activity activity) {
            Companion.a(activity);
        }

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
        public void onActivityPostCreated(@yt.k Activity activity, @yt.l Bundle bundle) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            p0.f6231b.a(activity, Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@yt.k Activity activity) {
            kotlin.jvm.internal.f0.p(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@yt.k Activity activity, @yt.k Bundle bundle) {
            kotlin.jvm.internal.f0.p(activity, "activity");
            kotlin.jvm.internal.f0.p(bundle, "bundle");
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

    @hk.m
    public static final void b(@yt.k Activity activity, @yt.k Lifecycle.Event event) {
        f6231b.a(activity, event);
    }

    @hk.h(name = "get")
    @yt.k
    public static final p0 f(@yt.k Activity activity) {
        return f6231b.b(activity);
    }

    @hk.m
    public static final void g(@yt.k Activity activity) {
        f6231b.d(activity);
    }

    public final void a(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f6231b;
            Activity activity = getActivity();
            kotlin.jvm.internal.f0.o(activity, "activity");
            bVar.a(activity, event);
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.d();
        }
    }

    public final void e(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void h(@yt.l a aVar) {
        this.f6233a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@yt.l Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f6233a);
        a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f6233a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.f6233a);
        a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(this.f6233a);
        a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }
}
