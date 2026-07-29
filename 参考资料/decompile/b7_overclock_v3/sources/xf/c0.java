package xf;

/* JADX INFO: loaded from: classes7.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f55210a = " agentweb - ";

    public static void a(String str, String str2) {
        if (d()) {
            f55210a.concat(str);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
    }

    public static void c(String str, String str2) {
        if (d()) {
            f55210a.concat(str);
        }
    }

    public static boolean d() {
        return c.f55199d;
    }

    public static void e(String str, String str2, Throwable th2) {
        if (!d()) {
            f55210a.concat(str);
            return;
        }
        throw new RuntimeException(f55210a.concat(str) + com.blankj.utilcode.util.i0.f11861z + str2, th2);
    }

    public static void f(String str, String str2) {
        if (d()) {
            f55210a.concat(str);
        }
    }
}
