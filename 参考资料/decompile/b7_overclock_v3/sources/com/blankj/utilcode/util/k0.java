package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    public k0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a(@g.n0 Activity activity, @g.n0 String str) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return b(activity.getClass(), str);
    }

    public static String b(@g.n0 Class<? extends Activity> cls, @g.n0 String str) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return String.valueOf(j1.a().getPackageManager().getActivityInfo(new ComponentName(j1.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return String.valueOf(j1.a().getPackageManager().getApplicationInfo(j1.a().getPackageName(), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String d(@g.n0 BroadcastReceiver broadcastReceiver, @g.n0 String str) {
        Objects.requireNonNull(broadcastReceiver, "Argument 'receiver' of type BroadcastReceiver (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return d(broadcastReceiver, str);
    }

    public static String e(@g.n0 Class<? extends BroadcastReceiver> cls, @g.n0 String str) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends BroadcastReceiver> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return String.valueOf(j1.a().getPackageManager().getReceiverInfo(new ComponentName(j1.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String f(@g.n0 Service service, @g.n0 String str) {
        Objects.requireNonNull(service, "Argument 'service' of type Service (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return g(service.getClass(), str);
    }

    public static String g(@g.n0 Class<? extends Service> cls, @g.n0 String str) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Service> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'key' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return String.valueOf(j1.a().getPackageManager().getServiceInfo(new ComponentName(j1.a(), cls), 128).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
