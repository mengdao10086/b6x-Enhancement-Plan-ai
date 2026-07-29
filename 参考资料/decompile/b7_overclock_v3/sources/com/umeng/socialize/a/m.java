package com.umeng.socialize.a;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f24563a;

    public static void a(boolean z10) {
        f24563a = z10;
    }

    public static void b(String str, Object... objArr) {
        if (a()) {
            a(4, str, a(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (a()) {
            a(5, str, a(objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (a()) {
            a(6, str, a(objArr));
        }
    }

    public static boolean a() {
        return f24563a;
    }

    public static void a(String str, Object... objArr) {
        if (a()) {
            a(3, str, a(objArr));
        }
    }

    private static void b(int i10, String str, String str2) {
        if (i10 == 3) {
            a(str);
            return;
        }
        if (i10 == 4) {
            a(str);
        } else if (i10 == 5) {
            a(str);
        } else {
            if (i10 != 6) {
                return;
            }
            a(str);
        }
    }

    private static void a(int i10, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            String strSubstring = str2.substring(0, 3072);
            b(i10, str, strSubstring);
            str2 = str2.replace(strSubstring, "");
        }
        if (str2.length() > 0) {
            b(i10, str, str2);
        }
    }

    public static String a(Throwable th2) {
        return Log.getStackTraceString(th2);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "AZX";
        }
        return "AZX." + str;
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb2.append(obj);
            }
        }
        return sb2.toString();
    }
}
