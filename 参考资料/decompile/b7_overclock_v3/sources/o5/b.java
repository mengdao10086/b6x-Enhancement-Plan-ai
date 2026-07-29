package o5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.blankj.utilcode.util.i0;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.p0;
import com.blankj.utilcode.util.t0;
import g.v0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42732a = 5555;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f42733b = "tcpip:5555";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f42734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f42735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f42736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f42737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f42738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f42739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f42740i = "shell:pkill -f app_process32";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f42741j = 88;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f42742k = "(=*+1+,v+=;-*1,!v9<:16(-,";

    static {
        String absolutePath = new File(j1.a().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "diagnose").getAbsolutePath();
        f42734c = absolutePath;
        String str = "dumpsys input > " + absolutePath + "/input.txt";
        f42735d = str;
        String str2 = "dumpsys display > " + absolutePath + "/display.txt";
        f42736e = str2;
        String str3 = "getevent -i > " + absolutePath + "/event.txt";
        f42737f = str3;
        String str4 = "wm size > " + absolutePath + "/wmSize.txt";
        f42738g = str4;
        f42739h = "shell:" + str + " && " + str4 + " && " + str2 + " && " + str3;
    }

    public static boolean a(Context context) {
        boolean zK = k(context);
        if (h.l() || h.d()) {
            try {
                return zK && l();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (h.h()) {
            return zK && g(context) && f(context);
        }
        return zK;
    }

    public static String b(String str, byte b10) throws Exception {
        byte[] bytes = str.getBytes("GBK");
        for (int i10 = 0; i10 < bytes.length; i10++) {
            bytes[i10] = (byte) (bytes[i10] ^ b10);
        }
        return new String(bytes, "GBK");
    }

    public static int c() {
        int i10;
        int i11;
        String strC = o.c("service.adb.tcp.port", "");
        if (!TextUtils.isEmpty(strC) && TextUtils.isDigitsOnly(strC) && (i11 = Integer.parseInt(strC)) > 0 && i11 <= 65535) {
            return i11;
        }
        String strC2 = o.c("persist.adb.tcp.port", "");
        if (TextUtils.isEmpty(strC2) || !TextUtils.isDigitsOnly(strC2) || (i10 = Integer.parseInt(strC2)) <= 0 || i10 > 65535) {
            return -1;
        }
        return i10;
    }

    public static boolean d(Context context) {
        if (h.p() || h.m() || Build.VERSION.SDK_INT < 28) {
            return true;
        }
        return e(context);
    }

    public static boolean e(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public static boolean f(Context context) {
        if (h.h()) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "allow_charging_adb");
                if (string != null && !"".equals(string) && !i0.f11859x.equals(string)) {
                    if (!"1".equals(string) && "0".equals(string)) {
                        return false;
                    }
                }
                return Build.VERSION.SDK_INT < 24;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return true;
    }

    public static boolean g(Context context) {
        if (h.h()) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "usb_conn_prompt");
                if (string != null && !"".equals(string) && !i0.f11859x.equals(string)) {
                    if (!"1".equals(string) && "0".equals(string)) {
                        return false;
                    }
                }
                return Build.VERSION.SDK_INT < 24;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return true;
    }

    @v0(api = 23)
    public static boolean h(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return false;
    }

    public static boolean i(Context context) {
        return c() == 5555;
    }

    public static boolean j(Context context) {
        return (t0.u() ? Settings.System.getInt(context.getContentResolver(), "oem_acc_sensor_three_finger", 0) : 0) == 1;
    }

    public static boolean k(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean l() throws Exception {
        if (!p0.o()) {
            return true;
        }
        String strC = o.c(b(f42742k, f42741j), "");
        if (strC == null || "".equals(strC) || i0.f11859x.equals(strC)) {
            return h.d() ? Build.VERSION.SDK_INT < 29 : Build.VERSION.SDK_INT < 24;
        }
        if ("1".equals(strC)) {
            return true;
        }
        "0".equals(strC);
        return false;
    }

    public static boolean m(Context context) {
        return Build.VERSION.SDK_INT >= 30 && Settings.Global.getInt(context.getContentResolver(), "adb_wifi_enabled", 0) == 1;
    }

    @v0(api = 23)
    public static void n(Context context) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
