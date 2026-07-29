package wf;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f54658a = "yyyy-MM-dd-HH:mm:ss.SSS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f54659b = "ota.txt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f54660c = "Log.txt";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f54661d = "HwCloudLog.txt";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f54662e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f54663f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f54664g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f54665h = true;

    public static void A(String str, String str2) {
        b();
        if (f54662e) {
            c.j(c.f54653e, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "\t< " + str + " >\t" + str2 + "\t\n");
        }
    }

    public static void a(boolean z10, boolean z11, boolean z12, boolean z13) {
        f54662e = z11;
        f54663f = z12;
        f54664g = z13;
        f54665h = z10;
    }

    public static void b() {
        f54662e = true;
        f54663f = true;
        f54664g = true;
        f54665h = true;
    }

    public static void c(String str, String str2) {
        b();
    }

    public static void d(String str, String str2, Throwable th2) {
        b();
    }

    public static void e(String str, String str2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void f(String str, String str2, Throwable th2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void g(String str, String str2) {
        b();
    }

    public static void h(String str, String str2, Throwable th2) {
        b();
    }

    public static void i(String str, String str2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void j(String str, String str2, Throwable th2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static String k(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        return stringWriter.toString();
    }

    public static void l(String str, String str2) {
        b();
    }

    public static void m(String str, String str2, Throwable th2) {
        b();
    }

    public static void n(String str, String str2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void o(String str, String str2, Throwable th2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void p(String str, String str2) {
        b();
    }

    public static void q(String str, String str2, Throwable th2) {
        b();
    }

    public static void r(String str, String str2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void s(String str, String str2, Throwable th2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void t(String str, String str2) {
        b();
    }

    public static void u(String str, String str2, Throwable th2) {
        b();
    }

    public static void v(String str, String str2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void w(String str, String str2, Throwable th2) {
        b();
        if (!f54662e || str2 == null) {
            return;
        }
        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        c.j(f54660c, str3 + "Vt<" + str + ">---" + str2);
    }

    public static void x(String str, String str2, String str3) {
        b();
        c.j(str2, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "\t< " + str + " >\t" + str3 + "\t\n");
    }

    public static void y(String str, String str2) {
        b();
        if (f54662e) {
            c.j(c.f54652d, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "\t< " + str + " >\t" + str2 + "\t\n");
        }
    }

    public static void z(String str, String str2) {
        b();
        if (f54662e) {
            c.j(c.f54652d, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "\t< " + str + " >\t" + str2 + "\t\n");
        }
    }
}
