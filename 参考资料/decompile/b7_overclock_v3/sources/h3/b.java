package h3;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import j3.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogger f30403a = new j3.c("ARouter::");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f30404b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f30405c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f30406d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f30407e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f30408f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f30409g = i3.b.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f30410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Context f30411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static InterceptorService f30412j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Postcard f30413a;

        public a(Postcard postcard) {
            this.f30413a = postcard;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(b.f30411i, "There's no route matched!\n Path = [" + this.f30413a.getPath() + "]\n Group = [" + this.f30413a.getGroup() + "]", 1).show();
        }
    }

    /* JADX INFO: renamed from: h3.b$b, reason: collision with other inner class name */
    public class C0360b implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f30415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f30416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Postcard f30417c;

        public C0360b(int i10, NavigationCallback navigationCallback, Postcard postcard) {
            this.f30415a = i10;
            this.f30416b = navigationCallback;
            this.f30417c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            b.this.a(postcard, this.f30415a, this.f30416b);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th2) {
            NavigationCallback navigationCallback = this.f30416b;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f30417c);
            }
            b.f30403a.info("ARouter::", "Navigation failed, termination by interceptor : " + th2.getMessage());
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f30419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f30421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Postcard f30422d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f30423e;

        public c(int i10, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.f30419a = i10;
            this.f30420b = context;
            this.f30421c = intent;
            this.f30422d = postcard;
            this.f30423e = navigationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.C(this.f30419a, this.f30420b, this.f30421c, this.f30422d, this.f30423e);
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30425a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f30425a = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30425a[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30425a[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30425a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30425a[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30425a[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30425a[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static synchronized void A(ThreadPoolExecutor threadPoolExecutor) {
        f30409g = threadPoolExecutor;
    }

    public static void B(ILogger iLogger) {
        if (iLogger != null) {
            f30403a = iLogger;
        }
    }

    public static void f() {
        f30412j = (InterceptorService) h3.a.j().d("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    public static void g() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(objInvoke, new g3.b());
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ARouter hook instrumentation failed! [");
            sb2.append(e10.getMessage());
            sb2.append("]");
        }
    }

    @Deprecated
    public static boolean k() {
        return f30406d;
    }

    public static boolean l() {
        return f30405c;
    }

    public static synchronized void m() {
        if (l()) {
            f30408f = false;
            g3.c.l();
            f30403a.info("ARouter::", "ARouter destroy success!");
        } else {
            f30403a.error("ARouter::", "Destroy can be used in debug mode only!");
        }
    }

    @Deprecated
    public static synchronized void n() {
        f30406d = true;
    }

    public static b p() {
        if (!f30408f) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (f30407e == null) {
            synchronized (b.class) {
                if (f30407e == null) {
                    f30407e = new b();
                }
            }
        }
        return f30407e;
    }

    public static synchronized boolean q(Application application) {
        f30411i = application;
        g3.c.d(application, f30409g);
        f30403a.info("ARouter::", "ARouter init success!");
        f30408f = true;
        f30410h = new Handler(Looper.getMainLooper());
        return true;
    }

    public static void r(Object obj) {
        AutowiredService autowiredService = (AutowiredService) h3.a.j().d("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static boolean s() {
        return f30404b;
    }

    public static synchronized void t() {
        f30404b = true;
        f30403a.info("ARouter::", "ARouter monitorMode on");
    }

    public static synchronized void w() {
        f30405c = true;
        f30403a.info("ARouter::", "ARouter openDebug");
    }

    public static synchronized void x() {
        f30403a.showLog(true);
        f30403a.info("ARouter::", "ARouter openLog");
    }

    public static synchronized void y() {
        f30403a.showStackTrace(true);
        f30403a.info("ARouter::", "ARouter printStackTrace");
    }

    public final void C(int i10, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i10 < 0) {
            h0.d.w(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            f0.b.Q((Activity) context, intent, i10, postcard.getOptionsBundle());
        } else {
            f30403a.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    public final Object a(Postcard postcard, int i10, NavigationCallback navigationCallback) {
        Context context = postcard.getContext();
        int i11 = d.f30425a[postcard.getType().ordinal()];
        if (i11 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!f.d(action)) {
                intent.setAction(action);
            }
            z(new c(i10, context, intent, postcard, navigationCallback));
            return null;
        }
        if (i11 == 2) {
            return postcard.getProvider();
        }
        if (i11 == 3 || i11 == 4 || i11 == 5) {
            try {
                Object objNewInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof Fragment) {
                    ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                } else if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) objNewInstance).c5(postcard.getExtras());
                }
                return objNewInstance;
            } catch (Exception e10) {
                f30403a.error("ARouter::", "Fetch fragment instance error, " + f.a(e10.getStackTrace()));
            }
        }
        return null;
    }

    public boolean e(IRouteGroup iRouteGroup) {
        if (iRouteGroup == null) {
            return false;
        }
        String str = null;
        try {
            HashMap map = new HashMap();
            iRouteGroup.loadInto(map);
            for (Map.Entry<String, RouteMeta> entry : map.entrySet()) {
                String strO = o(entry.getKey());
                RouteMeta value = entry.getValue();
                if (str == null) {
                    str = strO;
                }
                if (str == null || !str.equals(strO) || !str.equals(value.getGroup())) {
                    return false;
                }
            }
            g3.c.a(str, iRouteGroup);
            f30403a.info("ARouter::", "Add route group [" + str + "] finish, " + map.size() + " new route meta.");
            return true;
        } catch (Exception e10) {
            f30403a.error("ARouter::", "Add route group dynamic exception!", e10);
            return false;
        }
    }

    public Postcard h(Uri uri) {
        if (uri == null || f.d(uri.toString())) {
            throw new HandlerException("ARouter::Parameter invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) h3.a.j().p(PathReplaceService.class);
        if (pathReplaceService != null) {
            uri = pathReplaceService.forUri(uri);
        }
        return new Postcard(uri.getPath(), o(uri.getPath()), uri, null);
    }

    public Postcard i(String str) {
        if (f.d(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) h3.a.j().p(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return j(str, o(str), Boolean.TRUE);
    }

    public Postcard j(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (f.d(str) || f.d(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) h3.a.j().p(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public final String o(String str) {
        if (f.d(str) || !str.startsWith(fh.a.f28350w)) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf(fh.a.f28350w, 1));
            if (f.d(strSubstring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e10) {
            f30403a.warning("ARouter::", "Failed to extract default group! " + e10.getMessage());
            return null;
        }
    }

    public Object u(Context context, Postcard postcard, int i10, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) h3.a.j().p(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? f30411i : context);
        try {
            g3.c.c(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(postcard, i10, navigationCallback);
            }
            f30412j.doInterceptions(postcard, new C0360b(i10, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e10) {
            f30403a.warning("ARouter::", e10.getMessage());
            if (l()) {
                z(new a(postcard));
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) h3.a.j().p(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public <T> T v(Class<? extends T> cls) {
        try {
            Postcard postcardB = g3.c.b(cls.getName());
            if (postcardB == null) {
                postcardB = g3.c.b(cls.getSimpleName());
            }
            if (postcardB == null) {
                return null;
            }
            postcardB.setContext(f30411i);
            g3.c.c(postcardB);
            return (T) postcardB.getProvider();
        } catch (NoRouteFoundException e10) {
            f30403a.warning("ARouter::", e10.getMessage());
            return null;
        }
    }

    public final void z(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f30410h.post(runnable);
        } else {
            runnable.run();
        }
    }
}
