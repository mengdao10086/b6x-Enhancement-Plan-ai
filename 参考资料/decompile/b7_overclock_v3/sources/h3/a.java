package h3;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30398a = "NTeRQWvye18AkPd6G";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30399b = "wmHzgD4lOj5o4241";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f30400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f30401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ILogger f30402e;

    @Deprecated
    public static void b() {
        b.g();
    }

    @Deprecated
    public static boolean f() {
        return b.k();
    }

    public static boolean g() {
        return b.l();
    }

    @Deprecated
    public static synchronized void i() {
        b.n();
    }

    public static a j() {
        if (!f30401d) {
            throw new InitException("ARouter::Init::Invoke init(context) first!");
        }
        if (f30400c == null) {
            synchronized (a.class) {
                if (f30400c == null) {
                    f30400c = new a();
                }
            }
        }
        return f30400c;
    }

    public static void k(Application application) {
        if (f30401d) {
            return;
        }
        ILogger iLogger = b.f30403a;
        f30402e = iLogger;
        iLogger.info("ARouter::", "ARouter init start.");
        f30401d = b.q(application);
        if (f30401d) {
            b.f();
        }
        b.f30403a.info("ARouter::", "ARouter init over.");
    }

    public static boolean m() {
        return b.s();
    }

    public static synchronized void n() {
        b.t();
    }

    public static synchronized void q() {
        b.w();
    }

    public static synchronized void r() {
        b.x();
    }

    public static synchronized void s() {
        b.y();
    }

    public static synchronized void t(ThreadPoolExecutor threadPoolExecutor) {
        b.A(threadPoolExecutor);
    }

    public static void u(ILogger iLogger) {
        b.B(iLogger);
    }

    public boolean a(IRouteGroup iRouteGroup) {
        return b.p().e(iRouteGroup);
    }

    public Postcard c(Uri uri) {
        return b.p().h(uri);
    }

    public Postcard d(String str) {
        return b.p().i(str);
    }

    @Deprecated
    public Postcard e(String str, String str2) {
        return b.p().j(str, str2, Boolean.FALSE);
    }

    public synchronized void h() {
        b.m();
        f30401d = false;
    }

    public void l(Object obj) {
        b.r(obj);
    }

    public Object o(Context context, Postcard postcard, int i10, NavigationCallback navigationCallback) {
        return b.p().u(context, postcard, i10, navigationCallback);
    }

    public <T> T p(Class<? extends T> cls) {
        return (T) b.p().v(cls);
    }
}
