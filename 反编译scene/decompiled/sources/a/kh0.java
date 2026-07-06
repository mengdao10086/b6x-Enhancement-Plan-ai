package a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.omarea.model.AppInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PackageManager f1633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1634a;

    public kh0(Context context, boolean z) {
        f92.d(context, "context");
        this.f6606a = context;
        this.f1634a = z;
        PackageManager packageManager = context.getPackageManager();
        f92.c(packageManager, "context.packageManager");
        this.f1633a = packageManager;
    }

    public /* synthetic */ kh0(Context context, boolean z, int i, b92 b92Var) {
        this(context, (i & 2) != 0 ? true : z);
    }

    public static /* synthetic */ ArrayList f(kh0 kh0Var, Boolean bool, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return kh0Var.e(bool, z);
    }

    public final String a(PackageInfo packageInfo) {
        f92.d(packageInfo, "backupInfo");
        try {
            PackageInfo packageInfo2 = this.f1633a.getPackageInfo(packageInfo.packageName, 0);
            if (packageInfo2 == null) {
                return "";
            }
            if (packageInfo.versionCode == packageInfo2.versionCode) {
                return this.f6606a.getString(u61.apps_tag_installed) + " ";
            }
            if (packageInfo.versionCode > packageInfo2.versionCode) {
                return this.f6606a.getString(u61.apps_tag_old_installed) + " ";
            }
            return this.f6606a.getString(u61.apps_tag_new_installed) + " ";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public final boolean b(String str) {
        return ec2.C(str, ".overlay", false, 2, null) || ec2.C(str, "com.android.theme.color", false, 2, null) || ec2.C(str, "com.android.theme.icon", false, 2, null);
    }

    public final ArrayList<AppInfo> c() {
        return e(null, false);
    }

    public final AppInfo d(String str) {
        f92.d(str, "packageName");
        try {
            ApplicationInfo applicationInfo = this.f1633a.getApplicationInfo(str, 8192);
            f92.c(applicationInfo, "packageManager.getApplic…TCH_UNINSTALLED_PACKAGES)");
            return g(applicationInfo, null, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public final ArrayList<AppInfo> e(Boolean bool, boolean z) {
        List<ApplicationInfo> installedApplications = this.f1633a.getInstalledApplications(0);
        f92.c(installedApplications, "packageManager.getInstalledApplications(0)");
        ArrayList<AppInfo> arrayList = new ArrayList<>();
        int size = installedApplications.size();
        for (int i = 0; i < size; i++) {
            ApplicationInfo applicationInfo = installedApplications.get(i);
            f92.c(applicationInfo, "applicationInfo");
            AppInfo appInfoG = g(applicationInfo, bool, z);
            if (appInfoG != null) {
                arrayList.add(appInfoG);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (b(r14) != false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.omarea.model.AppInfo g(android.content.pm.ApplicationInfo r12, java.lang.Boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.kh0.g(android.content.pm.ApplicationInfo, java.lang.Boolean, boolean):com.omarea.model.AppInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<com.omarea.model.AppInfo> h(java.lang.Boolean r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.kh0.h(java.lang.Boolean, boolean):java.util.ArrayList");
    }

    public final ArrayList<AppInfo> i() {
        File[] fileArrListFiles;
        String strA = g61.f6176a.a();
        ArrayList<AppInfo> arrayList = new ArrayList<>();
        File file = new File(strA);
        if (!file.exists()) {
            return arrayList;
        }
        if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
            return arrayList;
        }
        if (!file.canRead() || (fileArrListFiles = file.listFiles(jh0.f6509a)) == null) {
            return arrayList;
        }
        for (File file2 : fileArrListFiles) {
            f92.c(file2, "files[i]");
            String absolutePath = file2.getAbsolutePath();
            try {
                PackageInfo packageArchiveInfo = this.f1633a.getPackageArchiveInfo(absolutePath, 1);
                if (packageArchiveInfo != null) {
                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                    applicationInfo.sourceDir = absolutePath;
                    applicationInfo.publicSourceDir = absolutePath;
                    AppInfo item = AppInfo.getItem();
                    item.setSelected(false);
                    item.setAppName(applicationInfo.loadLabel(this.f1633a).toString() + "  (" + packageArchiveInfo.versionCode + ")");
                    String str = applicationInfo.packageName;
                    f92.c(str, "applicationInfo.packageName");
                    item.setPackageName(str);
                    item.path = applicationInfo.sourceDir;
                    item.stateTags = a(packageArchiveInfo);
                    item.versionName = packageArchiveInfo.versionName;
                    item.versionCode = packageArchiveInfo.versionCode;
                    item.appType = AppInfo.AppType.BACKUPFILE;
                    arrayList.add(item);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public final ArrayList<AppInfo> j() {
        return f(this, Boolean.TRUE, false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(android.content.pm.ApplicationInfo r9) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.kh0.k(android.content.pm.ApplicationInfo):java.lang.String");
    }

    public final ArrayList<AppInfo> l() {
        return f(this, Boolean.FALSE, false, 2, null);
    }

    public final boolean m(ApplicationInfo applicationInfo) {
        f92.d(applicationInfo, "applicationInfo");
        return (applicationInfo.flags & 128) != 0;
    }
}
