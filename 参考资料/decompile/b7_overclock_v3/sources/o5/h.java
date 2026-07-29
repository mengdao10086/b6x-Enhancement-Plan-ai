package o5;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42744a = "RomUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f42745b = "MIUI";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f42746c = "EMUI";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f42747d = "VIVO";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f42748e = "OPPO";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f42749f = "FLYME";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f42750g = "SMARTISAN";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f42751h = "QIKU";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f42752i = "LETV";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f42753j = "LENOVO";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f42754k = "NUBIA";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f42755l = "ZTE";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f42756m = "COOLPAD";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f42757n = "UNKNOWN";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f42758o = "ro.miui.ui.version.name";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f42759p = "ro.build.version.emui";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f42760q = "ro.vivo.os.version";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f42761r = "ro.build.version.opporom";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f42762s = "ro.build.display.id";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f42763t = "ro.smartisan.version";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f42764u = "ro.letv.eui";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f42765v = "ro.lenovo.lvp.version";

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static boolean A() {
        return Build.MANUFACTURER.toLowerCase().contains("xiaomi");
    }

    public static boolean B() {
        String str = Build.MANUFACTURER;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && (str2.toLowerCase().contains(f42754k) || str2.toLowerCase().contains(f42755l))) || (!TextUtils.isEmpty(str2) && (str2.toLowerCase().contains(f42754k) || str2.toLowerCase().contains(f42755l)));
    }

    public static void C(Context context) {
        context.startActivity(l() ? new Intent("android.settings.SETTINGS") : new Intent("android.settings.DISPLAY_SETTINGS"));
    }

    public static String a() {
        return l() ? f42745b : h() ? f42746c : p() ? f42747d : m() ? f42748e : k() ? f42749f : o() ? f42750g : c() ? f42751h : j() ? f42752i : i() ? f42753j : B() ? f42755l : e() ? f42756m : f42757n;
    }

    public static String b(String str) {
        return o.c(str, null);
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toUpperCase().contains(f42751h);
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase().contains("blackshark");
    }

    public static boolean e() {
        String str = Build.MODEL;
        String str2 = Build.FINGERPRINT;
        return (!TextUtils.isEmpty(str) && str.toLowerCase().contains(f42756m)) || (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains(f42756m));
    }

    public static boolean f() {
        return l() || h() || k() || c() || m() || p() || j() || B() || i() || e();
    }

    public static boolean g() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean h() {
        return !TextUtils.isEmpty(b("ro.build.version.emui"));
    }

    public static boolean i() {
        return !TextUtils.isEmpty(b(f42765v));
    }

    public static boolean j() {
        return !TextUtils.isEmpty(b(f42764u));
    }

    public static boolean k() {
        String strB = b(f42762s);
        return !TextUtils.isEmpty(strB) && strB.toUpperCase().contains(f42749f);
    }

    public static boolean l() {
        return !TextUtils.isEmpty(b(f42758o));
    }

    public static boolean m() {
        return !TextUtils.isEmpty(b("ro.build.version.opporom"));
    }

    public static boolean n() {
        return Build.MODEL.contains("DE106");
    }

    public static boolean o() {
        return !TextUtils.isEmpty(b(f42763t));
    }

    public static boolean p() {
        return !TextUtils.isEmpty(b(f42760q));
    }

    public static boolean q() {
        return Build.MODEL.contains("vivo X21");
    }

    public static boolean r() {
        return Build.MODEL.contains("V1814");
    }

    public static boolean s() {
        String str = Build.MODEL;
        return str.contains("V1809") || str.contains("V1816");
    }

    public static boolean t() {
        return Build.MODEL.contains("V1732");
    }

    public static boolean u() {
        return Build.MODEL.contains("Y83");
    }

    public static boolean v() {
        return Build.MODEL.contains("vivo Y85");
    }

    public static boolean w() {
        return Build.MODEL.contains("V1818");
    }

    public static boolean x() {
        String str = Build.MODEL;
        return str.contains("V1813A") || str.contains("V1813T");
    }

    public static boolean y() {
        return Build.MODEL.contains("V1730");
    }

    public static boolean z() {
        return Build.MODEL.contains("V1813BA");
    }
}
