package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.j1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k1 f11899g = new k1();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Activity f11900h = new Activity();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Activity> f11901a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j1.d> f11902b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Activity, List<j1.a>> f11903c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11904d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11905e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11906f = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f11907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j1.a f11908b;

        public a(Activity activity, j1.a aVar) {
            this.f11907a = activity;
            this.f11908b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1.this.f(this.f11907a, this.f11908b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f11910a;

        public b(Activity activity) {
            this.f11910a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1.this.f11903c.remove(this.f11910a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f11912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j1.a f11913b;

        public c(Activity activity, j1.a aVar) {
            this.f11912a = activity;
            this.f11913b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1.this.x(this.f11912a, this.f11913b);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f11915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11916b;

        public d(Activity activity, Object obj) {
            this.f11915a = activity;
            this.f11916b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.f11915a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f11916b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void z() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void A(Activity activity) {
        if (!this.f11901a.contains(activity)) {
            this.f11901a.addFirst(activity);
        } else {
            if (this.f11901a.getFirst().equals(activity)) {
                return;
            }
            this.f11901a.remove(activity);
            this.f11901a.addFirst(activity);
        }
    }

    public void B(Application application) {
        this.f11901a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public void d(Activity activity, j1.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        l1.U0(new a(activity, aVar));
    }

    public void e(j1.a aVar) {
        d(f11900h, aVar);
    }

    public final void f(Activity activity, j1.a aVar) {
        List<j1.a> copyOnWriteArrayList = this.f11903c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f11903c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public void g(j1.d dVar) {
        this.f11902b.add(dVar);
    }

    public final void h(Activity activity, Lifecycle.Event event) {
        i(activity, event, this.f11903c.get(activity));
        i(activity, event, this.f11903c.get(f11900h));
    }

    public final void i(Activity activity, Lifecycle.Event event, List<j1.a> list) {
        if (list == null) {
            return;
        }
        for (j1.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f11903c.remove(activity);
        }
    }

    public final List<Activity> j() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objL = l();
            Field declaredField = objL.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objL);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object obj2 : ((Map) obj).values()) {
                Class<?> cls = obj2.getClass();
                Field declaredField2 = cls.getDeclaredField(androidx.appcompat.widget.c.f2369r);
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(obj2);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (declaredField3.getBoolean(obj2)) {
                        linkedList.add(activity2);
                    } else {
                        activity = activity2;
                    }
                } else {
                    linkedList.add(activity2);
                }
            }
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getActivitiesByReflect: ");
            sb2.append(e10.getMessage());
        }
        if (activity != null) {
            linkedList.addFirst(activity);
        }
        return linkedList;
    }

    public List<Activity> k() {
        if (!this.f11901a.isEmpty()) {
            return new LinkedList(this.f11901a);
        }
        this.f11901a.addAll(j());
        return new LinkedList(this.f11901a);
    }

    public final Object l() {
        Object objM = m();
        return objM != null ? objM : n();
    }

    public final Object m() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getActivityThreadInActivityThreadStaticField: ");
            sb2.append(e10.getMessage());
            return null;
        }
    }

    public final Object n() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getActivityThreadInActivityThreadStaticMethod: ");
            sb2.append(e10.getMessage());
            return null;
        }
    }

    public Application o() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(l(), new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return null;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            return null;
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@g.n0 Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h0.b(activity);
        z();
        A(activity);
        h(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11901a.remove(activity);
        l1.E(activity);
        h(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        h(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@g.n0 Activity activity, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@g.n0 Activity activity, @g.n0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@g.n0 Activity activity, @g.p0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@g.n0 Activity activity, @g.n0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A(activity);
        if (this.f11906f) {
            this.f11906f = false;
            s(activity, true);
        }
        t(activity, false);
        h(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@g.n0 Activity activity, @g.n0 Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@g.n0 Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (!this.f11906f) {
            A(activity);
        }
        int i10 = this.f11905e;
        if (i10 < 0) {
            this.f11905e = i10 + 1;
        } else {
            this.f11904d++;
        }
        h(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f11905e--;
        } else {
            int i10 = this.f11904d - 1;
            this.f11904d = i10;
            if (i10 <= 0) {
                this.f11906f = true;
                s(activity, false);
            }
        }
        t(activity, true);
        h(activity, Lifecycle.Event.ON_STOP);
    }

    public Activity p() {
        for (Activity activity : k()) {
            if (l1.p0(activity)) {
                return activity;
            }
        }
        return null;
    }

    public void q(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean r() {
        return !this.f11906f;
    }

    public final void s(Activity activity, boolean z10) {
        if (this.f11902b.isEmpty()) {
            return;
        }
        for (j1.d dVar : this.f11902b) {
            if (z10) {
                dVar.a(activity);
            } else {
                dVar.b(activity);
            }
        }
    }

    public final void t(Activity activity, boolean z10) {
        try {
            if (z10) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(f.f11760c, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                Object tag = activity.getWindow().getDecorView().getTag(f.f11760c);
                if (!(tag instanceof Integer)) {
                } else {
                    l1.V0(new d(activity, tag), 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void u(Activity activity) {
        if (activity == null) {
            return;
        }
        l1.U0(new b(activity));
    }

    public void v(Activity activity, j1.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        l1.U0(new c(activity, aVar));
    }

    public void w(j1.a aVar) {
        v(f11900h, aVar);
    }

    public final void x(Activity activity, j1.a aVar) {
        List<j1.a> list = this.f11903c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public void y(j1.d dVar) {
        this.f11902b.remove(dVar);
    }
}
