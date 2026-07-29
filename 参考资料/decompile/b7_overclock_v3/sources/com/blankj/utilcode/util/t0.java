package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {
    public static final String A = "ro.build.MiFavor_version";
    public static final String B = "ro.rom.version";
    public static final String C = "ro.build.rom.id";
    public static final String D = "unknown";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11995u = "ro.build.version.emui";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f11996v = "ro.vivo.os.build.display.id";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f11997w = "ro.build.version.incremental";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f11998x = "ro.build.version.opporom";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f11999y = "ro.letv.release.version";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f12000z = "ro.build.uiversion";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f11975a = {"huawei"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11976b = {"vivo"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11977c = {"xiaomi"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11978d = {"oppo"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f11979e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f11980f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f11981g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f11982h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f11983i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f11984j = {"coolpad", "yulong"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f11985k = {"lg", com.google.android.material.internal.i.f20421a};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f11986l = {"google"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f11987m = {com.google.android.material.internal.i.f20422b};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f11988n = {com.google.android.material.internal.i.f20423c};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f11989o = {"lenovo"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f11990p = {"smartisan"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f11991q = {"htc"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f11992r = {"sony"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f11993s = {"gionee", "amigo"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f11994t = {"motorola"};
    public static a E = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12002b;

        public String d() {
            return this.f12001a;
        }

        public String e() {
            return this.f12002b;
        }

        public String toString() {
            return "RomInfo{name=" + this.f12001a + ", version=" + this.f12002b + zc.a.f58317e;
        }
    }

    public t0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A() {
        return f11976b[0].equals(c().f12001a);
    }

    public static boolean B() {
        return f11977c[0].equals(c().f12001a);
    }

    public static boolean C() {
        return f11981g[0].equals(c().f12001a);
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static a c() {
        a aVar = E;
        if (aVar != null) {
            return aVar;
        }
        E = new a();
        String strA = a();
        String strB = b();
        String[] strArr = f11975a;
        if (w(strA, strB, strArr)) {
            E.f12001a = strArr[0];
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split("_");
            if (strArrSplit.length > 1) {
                E.f12002b = strArrSplit[1];
            } else {
                E.f12002b = strD;
            }
            return E;
        }
        String[] strArr2 = f11976b;
        if (w(strA, strB, strArr2)) {
            E.f12001a = strArr2[0];
            E.f12002b = d(f11996v);
            return E;
        }
        String[] strArr3 = f11977c;
        if (w(strA, strB, strArr3)) {
            E.f12001a = strArr3[0];
            E.f12002b = d(f11997w);
            return E;
        }
        String[] strArr4 = f11978d;
        if (w(strA, strB, strArr4)) {
            E.f12001a = strArr4[0];
            E.f12002b = d("ro.build.version.opporom");
            return E;
        }
        String[] strArr5 = f11979e;
        if (w(strA, strB, strArr5)) {
            E.f12001a = strArr5[0];
            E.f12002b = d(f11999y);
            return E;
        }
        String[] strArr6 = f11980f;
        if (w(strA, strB, strArr6)) {
            E.f12001a = strArr6[0];
            E.f12002b = d(f12000z);
            return E;
        }
        String[] strArr7 = f11981g;
        if (w(strA, strB, strArr7)) {
            E.f12001a = strArr7[0];
            E.f12002b = d(A);
            return E;
        }
        String[] strArr8 = f11982h;
        if (w(strA, strB, strArr8)) {
            E.f12001a = strArr8[0];
            E.f12002b = d(B);
            return E;
        }
        String[] strArr9 = f11983i;
        if (w(strA, strB, strArr9)) {
            E.f12001a = strArr9[0];
            E.f12002b = d(C);
            return E;
        }
        String[] strArr10 = f11984j;
        if (w(strA, strB, strArr10)) {
            E.f12001a = strArr10[0];
        } else {
            String[] strArr11 = f11985k;
            if (w(strA, strB, strArr11)) {
                E.f12001a = strArr11[0];
            } else {
                String[] strArr12 = f11986l;
                if (w(strA, strB, strArr12)) {
                    E.f12001a = strArr12[0];
                } else {
                    String[] strArr13 = f11987m;
                    if (w(strA, strB, strArr13)) {
                        E.f12001a = strArr13[0];
                    } else {
                        String[] strArr14 = f11988n;
                        if (w(strA, strB, strArr14)) {
                            E.f12001a = strArr14[0];
                        } else {
                            String[] strArr15 = f11989o;
                            if (w(strA, strB, strArr15)) {
                                E.f12001a = strArr15[0];
                            } else {
                                String[] strArr16 = f11990p;
                                if (w(strA, strB, strArr16)) {
                                    E.f12001a = strArr16[0];
                                } else {
                                    String[] strArr17 = f11991q;
                                    if (w(strA, strB, strArr17)) {
                                        E.f12001a = strArr17[0];
                                    } else {
                                        String[] strArr18 = f11992r;
                                        if (w(strA, strB, strArr18)) {
                                            E.f12001a = strArr18[0];
                                        } else {
                                            String[] strArr19 = f11993s;
                                            if (w(strA, strB, strArr19)) {
                                                E.f12001a = strArr19[0];
                                            } else {
                                                String[] strArr20 = f11994t;
                                                if (w(strA, strB, strArr20)) {
                                                    E.f12001a = strArr20[0];
                                                } else {
                                                    E.f12001a = strB;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        E.f12002b = d("");
        return E;
    }

    public static String d(String str) {
        String strE = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(strE) || strE.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strE = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strE) ? "unknown" : strE;
    }

    public static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    public static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            } catch (IOException unused) {
                return "";
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            line = bufferedReader.readLine();
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            bufferedReader2.close();
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        if (line != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused5) {
            }
            return line;
        }
        bufferedReader.close();
        return "";
    }

    public static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i() {
        return f11980f[0].equals(c().f12001a);
    }

    public static boolean j() {
        return f11984j[0].equals(c().f12001a);
    }

    public static boolean k() {
        return f11993s[0].equals(c().f12001a);
    }

    public static boolean l() {
        return f11986l[0].equals(c().f12001a);
    }

    public static boolean m() {
        return f11991q[0].equals(c().f12001a);
    }

    public static boolean n() {
        return f11975a[0].equals(c().f12001a);
    }

    public static boolean o() {
        return f11979e[0].equals(c().f12001a);
    }

    public static boolean p() {
        return f11989o[0].equals(c().f12001a);
    }

    public static boolean q() {
        return f11985k[0].equals(c().f12001a);
    }

    public static boolean r() {
        return f11988n[0].equals(c().f12001a);
    }

    public static boolean s() {
        return f11994t[0].equals(c().f12001a);
    }

    public static boolean t() {
        return f11983i[0].equals(c().f12001a);
    }

    public static boolean u() {
        return f11982h[0].equals(c().f12001a);
    }

    public static boolean v() {
        return f11978d[0].equals(c().f12001a);
    }

    public static boolean w(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean x() {
        return f11987m[0].equals(c().f12001a);
    }

    public static boolean y() {
        return f11990p[0].equals(c().f12001a);
    }

    public static boolean z() {
        return f11992r[0].equals(c().f12001a);
    }
}
