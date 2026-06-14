package a;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class w32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v32 f7753a;

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

    public static v32 c() {
        v32 v32Var;
        String str;
        v32 v32Var2 = f7753a;
        if (v32Var2 != null) {
            return v32Var2;
        }
        f7753a = new v32();
        String strA = a();
        String strB = b();
        if (k(strA, strB, "huawei")) {
            f7753a.f7656a = "huawei";
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split("_");
            if (strArrSplit.length > 1) {
                f7753a.b = strArrSplit[1];
            } else {
                f7753a.b = strD;
            }
            return f7753a;
        }
        if (k(strA, strB, "vivo")) {
            f7753a.f7656a = "vivo";
            v32Var = f7753a;
            str = "ro.vivo.os.build.display.id";
        } else if (k(strA, strB, "xiaomi")) {
            f7753a.f7656a = "xiaomi";
            v32Var = f7753a;
            str = "ro.build.version.incremental";
        } else if (k(strA, strB, "oppo")) {
            f7753a.f7656a = "oppo";
            v32Var = f7753a;
            str = "ro.build.version.opporom";
        } else {
            f7753a.f7656a = strB;
            v32Var = f7753a;
            str = "";
        }
        v32Var.b = d(str);
        return f7753a;
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
        } catch (Throwable th) {
            th = th;
        }
        try {
            line = bufferedReader.readLine();
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            bufferedReader2.close();
        } catch (Throwable th2) {
            th = th2;
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
        return "huawei".equals(c().f7656a);
    }

    public static boolean j() {
        return "oppo".equals(c().f7656a);
    }

    public static boolean k(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l() {
        return "vivo".equals(c().f7656a);
    }

    public static boolean m() {
        return "xiaomi".equals(c().f7656a);
    }
}
