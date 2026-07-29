package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {
    public y0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(@g.n0 Intent intent, @g.n0 ServiceConnection serviceConnection, int i10) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(serviceConnection, "Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            j1.a().bindService(intent, serviceConnection, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void b(@g.n0 Class<?> cls, @g.n0 ServiceConnection serviceConnection, int i10) {
        Objects.requireNonNull(cls, "Argument 'cls' of type Class<?> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(serviceConnection, "Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        a(new Intent(j1.a(), cls), serviceConnection, i10);
    }

    public static void c(@g.n0 String str, @g.n0 ServiceConnection serviceConnection, int i10) {
        Objects.requireNonNull(str, "Argument 'className' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(serviceConnection, "Argument 'conn' of type ServiceConnection (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            b(Class.forName(str), serviceConnection, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static Set<String> d() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r)).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices == null || runningServices.size() == 0) {
            return null;
        }
        Iterator<ActivityManager.RunningServiceInfo> it2 = runningServices.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next().service.getClassName());
        }
        return hashSet;
    }

    public static boolean e(@g.n0 Class<?> cls) {
        Objects.requireNonNull(cls, "Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(cls.getName());
    }

    public static boolean f(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r)).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() != 0) {
                Iterator<ActivityManager.RunningServiceInfo> it2 = runningServices.iterator();
                while (it2.hasNext()) {
                    if (str.equals(it2.next().service.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void g(Intent intent) {
        try {
            intent.setFlags(32);
            if (Build.VERSION.SDK_INT >= 26) {
                j1.a().startForegroundService(intent);
            } else {
                j1.a().startService(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void h(@g.n0 Class<?> cls) {
        Objects.requireNonNull(cls, "Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        g(new Intent(j1.a(), cls));
    }

    public static void i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            h(Class.forName(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean j(@g.n0 Intent intent) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return j1.a().stopService(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean k(@g.n0 Class<?> cls) {
        Objects.requireNonNull(cls, "Argument 'cls' of type Class<?> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(new Intent(j1.a(), cls));
    }

    public static boolean l(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'className' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return k(Class.forName(str));
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void m(@g.n0 ServiceConnection serviceConnection) {
        Objects.requireNonNull(serviceConnection, "Argument 'conn' of type ServiceConnection (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        j1.a().unbindService(serviceConnection);
    }
}
