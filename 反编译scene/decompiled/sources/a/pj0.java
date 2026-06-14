package a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pj0 {
    public ArrayList<ApplicationInfo> a(Context context) {
        ArrayList<ApplicationInfo> arrayList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(8192)) {
            try {
                try {
                    packageManager.getApplicationInfo(packageInfo.packageName, 0);
                } catch (Exception unused) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        arrayList.add(packageManager.getApplicationInfo(packageInfo.packageName, 8192));
                    }
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }
}
