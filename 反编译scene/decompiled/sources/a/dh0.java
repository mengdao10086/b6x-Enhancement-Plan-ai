package a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ix0 f5900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f561a;

    public dh0(Context context) {
        f92.d(context, "context");
        this.f560a = context;
        this.f561a = context.getPackageManager();
        this.f5900a = new ix0(this.f560a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object, java.util.List] */
    public final void c() {
        int i = Build.VERSION.SDK_INT;
        n92 n92Var = new n92();
        ?? installedPackages = this.f561a.getInstalledPackages(0);
        f92.c(installedPackages, "packageManager.getInstalledPackages(0)");
        n92Var.f6891a = installedPackages;
        pc2.b(null, new ch0(this, n92Var, 527, null), 1, null);
    }

    public final ArrayList<ActivityInfo> d(String str) {
        f92.d(str, "packageName");
        int i = Build.VERSION.SDK_INT;
        ActivityInfo[] activityInfoArr = this.f561a.getPackageInfo(str, 513).activities;
        return activityInfoArr != null ? new ArrayList<>(u42.I(activityInfoArr)) : new ArrayList<>();
    }

    public final ArrayList<ProviderInfo> e(String str) {
        f92.d(str, "packageName");
        int i = Build.VERSION.SDK_INT;
        ProviderInfo[] providerInfoArr = this.f561a.getPackageInfo(str, 520).providers;
        return providerInfoArr != null ? new ArrayList<>(u42.I(providerInfoArr)) : new ArrayList<>();
    }

    public final ArrayList<ActivityInfo> f(String str) {
        f92.d(str, "packageName");
        int i = Build.VERSION.SDK_INT;
        ActivityInfo[] activityInfoArr = this.f561a.getPackageInfo(str, 514).receivers;
        return activityInfoArr != null ? new ArrayList<>(u42.I(activityInfoArr)) : new ArrayList<>();
    }

    public final ArrayList<ServiceInfo> g(String str) {
        f92.d(str, "packageName");
        int i = Build.VERSION.SDK_INT;
        ServiceInfo[] serviceInfoArr = this.f561a.getPackageInfo(str, 516).services;
        return serviceInfoArr != null ? new ArrayList<>(u42.I(serviceInfoArr)) : new ArrayList<>();
    }
}
