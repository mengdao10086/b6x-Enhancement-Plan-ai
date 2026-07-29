package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23180a = "ro.build.version.emui";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23181b = "hw_sc.build.platform.version";

    public static aa a(Context context) {
        String str = Build.BRAND;
        am.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new ae();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new al();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new ak();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new ai();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new af();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new ah();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new aj();
        }
        if (b()) {
            return new ac();
        }
        if (a()) {
            return new ae();
        }
        if (str.equalsIgnoreCase(com.google.android.material.internal.i.f20423c) || str.equalsIgnoreCase("mblu")) {
            return new ag();
        }
        return null;
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a("ro.build.version.emui")) && TextUtils.isEmpty(a(f23181b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
