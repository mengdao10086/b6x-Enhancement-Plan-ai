package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f22678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f22679b;

    public static String a() {
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f22678a)) {
            return f22678a;
        }
        if (context == null) {
            return "";
        }
        f22678a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f22678a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return f22678a;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context) {
        return "";
    }

    public static String c(Context context) {
        return "";
    }

    public static String d(Context context) {
        return "";
    }

    public static String e(Context context) {
        try {
            if (f22679b == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("imei=");
                sb2.append(b(context));
                sb2.append('&');
                sb2.append("model=");
                sb2.append(Build.MODEL);
                sb2.append('&');
                sb2.append("os=");
                sb2.append(Build.VERSION.RELEASE);
                sb2.append('&');
                sb2.append("apilevel=");
                sb2.append(Build.VERSION.SDK_INT);
                sb2.append('&');
                String strB = a.b(context);
                if (strB == null) {
                    strB = "";
                }
                sb2.append("network=");
                sb2.append(strB);
                sb2.append('&');
                sb2.append("sdcard=");
                sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb2.append('&');
                sb2.append("display=");
                sb2.append(displayMetrics.widthPixels);
                sb2.append('*');
                sb2.append(displayMetrics.heightPixels);
                sb2.append('&');
                sb2.append("manu=");
                sb2.append(Build.MANUFACTURER);
                sb2.append("&");
                sb2.append("wifi=");
                sb2.append(a.e(context));
                f22679b = sb2.toString();
            }
            return f22679b;
        } catch (Exception unused) {
            return null;
        }
    }
}
