package xf;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f55198c = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55201f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55202g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f55203h = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f55207l = " agentweb/4.0.1 ";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f55208m = "AgentWeb";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f55196a = "agentweb-cache";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f55197b = File.separator + f55196a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f55199d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f55200e = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f55204i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f55205j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f55206k = c.class.getSimpleName();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f55209n = 5242880;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            CookieManager.getInstance().flush();
        }
    }

    public static class b implements ValueCallback<Boolean> {
        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(Boolean bool) {
            c0.c(c.f55206k, "removeExpiredCookies:" + bool);
        }
    }

    public static synchronized void b(Context context) {
        try {
            com.just.agentweb.a.f(new File(e(context)), 0);
            String strI = i(context);
            if (!TextUtils.isEmpty(strI)) {
                com.just.agentweb.a.f(new File(strI), 0);
            }
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
    }

    public static void c(Context context) {
    }

    public static void d() {
        f55199d = true;
        WebView.setWebContentsDebuggingEnabled(true);
    }

    public static String e(Context context) {
        return context.getCacheDir().getAbsolutePath() + f55197b;
    }

    public static String f(String str) {
        if (CookieManager.getInstance() == null) {
            return null;
        }
        return CookieManager.getInstance().getCookie(str);
    }

    public static String g(Context context) {
        return context.getApplicationContext().getDir("database", 0).getPath();
    }

    public static ValueCallback<Boolean> h() {
        return new b();
    }

    public static String i(Context context) {
        return com.just.agentweb.a.o(context);
    }

    public static synchronized void j(Context context) {
        if (!f55205j) {
            c(context);
            f55205j = true;
        }
    }

    public static void k() {
        l(null);
    }

    public static void l(@g.p0 ValueCallback<Boolean> valueCallback) {
        if (valueCallback == null) {
            valueCallback = h();
        }
        CookieManager.getInstance().removeAllCookies(valueCallback);
        q();
    }

    public static void m() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.removeExpiredCookie();
            q();
        }
    }

    public static void n() {
        o(null);
    }

    public static void o(ValueCallback<Boolean> valueCallback) {
        if (valueCallback == null) {
            valueCallback = h();
        }
        if (CookieManager.getInstance() == null) {
            valueCallback.onReceiveValue(new Boolean(false));
        } else {
            CookieManager.getInstance().removeSessionCookies(valueCallback);
            q();
        }
    }

    public static void p(String str, String str2) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2);
            q();
        }
    }

    public static void q() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new a());
    }
}
