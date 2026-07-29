package j3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f36054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f36055b;

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            h3.a.f30402e.error("ARouter::", "Get package info error.");
            return null;
        }
    }

    public static boolean b(Context context) {
        PackageInfo packageInfoA = a(context);
        if (packageInfoA != null) {
            String str = packageInfoA.versionName;
            int i10 = packageInfoA.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences(b.f36046j, 0);
            if (str.equals(sharedPreferences.getString(b.f36048l, null)) && i10 == sharedPreferences.getInt(b.f36049m, -1)) {
                return false;
            }
            f36054a = str;
            f36055b = i10;
        }
        return true;
    }

    public static void c(Context context) {
        if (TextUtils.isEmpty(f36054a) || f36055b == 0) {
            return;
        }
        context.getSharedPreferences(b.f36046j, 0).edit().putString(b.f36048l, f36054a).putInt(b.f36049m, f36055b).apply();
    }
}
