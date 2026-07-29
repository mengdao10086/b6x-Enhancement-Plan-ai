package com.umeng.socialize.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f24531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f24532b;

    public static String a() {
        if (TextUtils.isEmpty(f24531a)) {
            String str = Build.BRAND;
            f24531a = str;
            if (TextUtils.isEmpty(str)) {
                f24531a = Build.MANUFACTURER;
            }
        }
        return f24531a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f24532b)) {
            f24532b = Build.MODEL;
        }
        return f24532b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Object a(Object obj, String str, int i10) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
