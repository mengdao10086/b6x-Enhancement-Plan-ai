package t3;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f50860a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50861b = "NewbieGuide";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f50862c = 8;

    public static void a(String str) {
    }

    public static void b(String str, Throwable th2) {
    }

    public static void c(String str) {
    }

    public static void d(String str, Throwable th2) {
    }

    public static String e() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String str = String.format(Locale.CHINA, "%s.%s(L:%d)", className.substring(className.lastIndexOf(j3.b.f36044h) + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        if (TextUtils.isEmpty("NewbieGuide")) {
            return str;
        }
        return "NewbieGuide:" + str;
    }

    public static void f(String str) {
    }

    public static void g(String str, Throwable th2) {
    }

    public static void h(String str) {
    }

    public static void i(String str, Throwable th2) {
    }

    public static void j(String str) {
    }

    public static void k(String str, Throwable th2) {
    }
}
