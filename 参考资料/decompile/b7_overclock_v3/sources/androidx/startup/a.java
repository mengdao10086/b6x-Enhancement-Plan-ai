package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f7682d = "Startup";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f7683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f7684f = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Context f7687c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Set<Class<? extends e2.a<?>>> f7686b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Map<Class<?>, Object> f7685a = new HashMap();

    public a(@n0 Context context) {
        this.f7687c = context.getApplicationContext();
    }

    @n0
    public static a e(@n0 Context context) {
        if (f7683e == null) {
            synchronized (f7684f) {
                if (f7683e == null) {
                    f7683e = new a(context);
                }
            }
        }
        return f7683e;
    }

    public static void h(@n0 a aVar) {
        synchronized (f7684f) {
            f7683e = aVar;
        }
    }

    public void a() {
        try {
            try {
                f2.a.c(f7682d);
                b(this.f7687c.getPackageManager().getProviderInfo(new ComponentName(this.f7687c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e10) {
                throw new StartupException(e10);
            }
        } finally {
            f2.a.f();
        }
    }

    public void b(@p0 Bundle bundle) {
        String string = this.f7687c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (e2.a.class.isAssignableFrom(cls)) {
                            this.f7686b.add((Class<? extends e2.a<?>>) cls);
                        }
                    }
                }
                Iterator<Class<? extends e2.a<?>>> it2 = this.f7686b.iterator();
                while (it2.hasNext()) {
                    d(it2.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new StartupException(e10);
            }
        }
    }

    @n0
    public <T> T c(@n0 Class<? extends e2.a<?>> cls) {
        T t10;
        synchronized (f7684f) {
            t10 = (T) this.f7685a.get(cls);
            if (t10 == null) {
                t10 = (T) d(cls, new HashSet());
            }
        }
        return t10;
    }

    @n0
    public final <T> T d(@n0 Class<? extends e2.a<?>> cls, @n0 Set<Class<?>> set) {
        T t10;
        if (f2.a.h()) {
            try {
                f2.a.c(cls.getSimpleName());
            } finally {
                f2.a.f();
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f7685a.containsKey(cls)) {
            t10 = (T) this.f7685a.get(cls);
        } else {
            set.add(cls);
            try {
                e2.a<?> aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends e2.a<?>>> listA = aVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends e2.a<?>> cls2 : listA) {
                        if (!this.f7685a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t10 = (T) aVarNewInstance.b(this.f7687c);
                set.remove(cls);
                this.f7685a.put(cls, t10);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        return t10;
    }

    @n0
    public <T> T f(@n0 Class<? extends e2.a<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(@n0 Class<? extends e2.a<?>> cls) {
        return this.f7686b.contains(cls);
    }
}
