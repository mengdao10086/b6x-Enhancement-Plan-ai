package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.blankj.utilcode.util.j1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f11730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11732e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11734g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i10, boolean z10) {
            i(str2);
            h(drawable);
            j(str);
            k(str3);
            n(str4);
            m(i10);
            l(z10);
        }

        public Drawable a() {
            return this.f11730c;
        }

        public String b() {
            return this.f11729b;
        }

        public String c() {
            return this.f11728a;
        }

        public String d() {
            return this.f11731d;
        }

        public int e() {
            return this.f11733f;
        }

        public String f() {
            return this.f11732e;
        }

        public boolean g() {
            return this.f11734g;
        }

        public void h(Drawable drawable) {
            this.f11730c = drawable;
        }

        public void i(String str) {
            this.f11729b = str;
        }

        public void j(String str) {
            this.f11728a = str;
        }

        public void k(String str) {
            this.f11731d = str;
        }

        public void l(boolean z10) {
            this.f11734g = z10;
        }

        public void m(int i10) {
            this.f11733f = i10;
        }

        public void n(String str) {
            this.f11732e = str;
        }

        public String toString() {
            return "{\n    pkg name: " + c() + "\n    app icon: " + a() + "\n    app name: " + b() + "\n    app path: " + d() + "\n    app v name: " + f() + "\n    app v code: " + e() + "\n    is system: " + g() + "\n}";
        }
    }

    public d() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int A() {
        return B(j1.a().getPackageName());
    }

    public static int B(String str) {
        if (l1.C0(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = j1.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String C() {
        return D(j1.a().getPackageName());
    }

    public static String D(String str) {
        if (l1.C0(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = j1.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static List<a> E() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = j1.a().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        Iterator<PackageInfo> it2 = packageManager.getInstalledPackages(0).iterator();
        while (it2.hasNext()) {
            a aVarF = F(packageManager, it2.next());
            if (aVarF != null) {
                arrayList.add(aVarF);
            }
        }
        return arrayList;
    }

    public static a F(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return new a(packageInfo.packageName, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static void G(Uri uri) {
        Intent intentV = l1.V(uri);
        if (intentV == null) {
            return;
        }
        j1.a().startActivity(intentV);
    }

    public static void H(File file) {
        Intent intentW = l1.W(file);
        if (intentW == null) {
            return;
        }
        j1.a().startActivity(intentW);
    }

    public static void I(String str) {
        H(l1.P(str));
    }

    public static boolean J() {
        return K(j1.a().getPackageName());
    }

    public static boolean K(String str) {
        ApplicationInfo applicationInfo;
        return (l1.C0(str) || (applicationInfo = j1.a().getApplicationInfo()) == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }

    public static boolean L() {
        return l1.r0();
    }

    public static boolean M(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return !l1.C0(str) && str.equals(l1.Q());
    }

    public static boolean N(String str) {
        if (l1.C0(str)) {
            return false;
        }
        try {
            return j1.a().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean O() {
        return l1.B("echo root", true).f11696a == 0;
    }

    public static boolean P(String str) {
        if (l1.C0(str)) {
            return false;
        }
        int i10 = j1.a().getApplicationInfo().uid;
        ActivityManager activityManager = (ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r);
        if (activityManager != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            if (runningTasks != null && runningTasks.size() > 0) {
                Iterator<ActivityManager.RunningTaskInfo> it2 = runningTasks.iterator();
                while (it2.hasNext()) {
                    ComponentName componentName = it2.next().baseActivity;
                    if (componentName != null && str.equals(componentName.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() > 0) {
                Iterator<ActivityManager.RunningServiceInfo> it3 = runningServices.iterator();
                while (it3.hasNext()) {
                    if (i10 == it3.next().uid) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean Q() {
        return R(j1.a().getPackageName());
    }

    public static boolean R(String str) {
        if (l1.C0(str)) {
            return false;
        }
        try {
            ApplicationInfo applicationInfo = j1.a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 1) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void S(String str) {
        Intent intentY;
        if (l1.C0(str) || (intentY = l1.Y(str)) == null) {
            return;
        }
        j1.a().startActivity(intentY);
    }

    public static void T() {
        W(j1.a().getPackageName());
    }

    public static void U(Activity activity, int i10) {
        V(activity, i10, j1.a().getPackageName());
    }

    public static void V(Activity activity, int i10, String str) {
        if (activity == null || l1.C0(str)) {
            return;
        }
        Intent intentX = l1.X(str, false);
        if (l1.x0(intentX)) {
            activity.startActivityForResult(intentX, i10);
        }
    }

    public static void W(String str) {
        if (l1.C0(str)) {
            return;
        }
        Intent intentX = l1.X(str, true);
        if (l1.x0(intentX)) {
            j1.a().startActivity(intentX);
        }
    }

    public static void X(@g.n0 j1.d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l1.c(dVar);
    }

    public static void Y() {
        Z(false);
    }

    public static void Z(boolean z10) {
        Intent intentY = l1.Y(j1.a().getPackageName());
        if (intentY == null) {
            return;
        }
        intentY.addFlags(335577088);
        j1.a().startActivity(intentY);
        if (z10) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void a() {
        l1.D();
        System.exit(0);
    }

    public static void a0(String str) {
        if (l1.C0(str)) {
            return;
        }
        j1.a().startActivity(l1.i0(str));
    }

    public static a b(File file) {
        if (file != null && file.isFile() && file.exists()) {
            return c(file.getAbsolutePath());
        }
        return null;
    }

    public static void b0(@g.n0 j1.d dVar) {
        Objects.requireNonNull(dVar, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        l1.T0(dVar);
    }

    public static a c(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (l1.C0(str) || (packageManager = j1.a().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return F(packageManager, packageArchiveInfo);
    }

    public static Drawable d() {
        return e(j1.a().getPackageName());
    }

    public static Drawable e(String str) {
        if (l1.C0(str)) {
            return null;
        }
        try {
            PackageManager packageManager = j1.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int f() {
        return g(j1.a().getPackageName());
    }

    public static int g(String str) {
        if (l1.C0(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = j1.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static a h() {
        return i(j1.a().getPackageName());
    }

    public static a i(String str) {
        try {
            PackageManager packageManager = j1.a().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return F(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String j() {
        return k(j1.a().getPackageName());
    }

    public static String k(String str) {
        if (l1.C0(str)) {
            return "";
        }
        try {
            PackageManager packageManager = j1.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String l() {
        return j1.a().getPackageName();
    }

    public static String m() {
        return n(j1.a().getPackageName());
    }

    public static String n(String str) {
        if (l1.C0(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = j1.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static Signature[] o() {
        return q(j1.a().getPackageName());
    }

    public static Signature[] p(File file) {
        if (file == null) {
            return null;
        }
        PackageManager packageManager = j1.a().getPackageManager();
        if (Build.VERSION.SDK_INT < 28) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 64);
            if (packageArchiveInfo == null) {
                return null;
            }
            return packageArchiveInfo.signatures;
        }
        PackageInfo packageArchiveInfo2 = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 134217728);
        if (packageArchiveInfo2 == null) {
            return null;
        }
        SigningInfo signingInfo = packageArchiveInfo2.signingInfo;
        return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
    }

    public static Signature[] q(String str) {
        if (l1.C0(str)) {
            return null;
        }
        try {
            PackageManager packageManager = j1.a().getPackageManager();
            if (Build.VERSION.SDK_INT < 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo2 == null) {
                return null;
            }
            SigningInfo signingInfo = packageInfo2.signingInfo;
            return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static List<String> r(String str, String str2) {
        Signature[] signatureArrQ;
        ArrayList arrayList = new ArrayList();
        if (!l1.C0(str) && (signatureArrQ = q(str)) != null && signatureArrQ.length > 0) {
            for (Signature signature : signatureArrQ) {
                arrayList.add(l1.l(l1.j0(signature.toByteArray(), str2)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0"));
            }
        }
        return arrayList;
    }

    public static List<String> s() {
        return t(j1.a().getPackageName());
    }

    public static List<String> t(String str) {
        return r(str, "MD5");
    }

    public static List<String> u() {
        return v(j1.a().getPackageName());
    }

    public static List<String> v(String str) {
        return r(str, "SHA1");
    }

    public static List<String> w() {
        return x(j1.a().getPackageName());
    }

    public static List<String> x(String str) {
        return r(str, "SHA256");
    }

    public static int y() {
        return z(j1.a().getPackageName());
    }

    public static int z(String str) {
        try {
            return j1.a().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }
}
