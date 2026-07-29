package g3;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import j3.e;
import j3.f;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f28995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f28996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f28997c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28998a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f28998a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28998a[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void a(String str, IRouteGroup iRouteGroup) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (d.f28999a.containsKey(str)) {
            d.f28999a.get(str).getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(d.f29000b);
            d.f28999a.remove(str);
        }
        if (iRouteGroup != null) {
            iRouteGroup.loadInto(d.f29000b);
        }
    }

    public static Postcard b(String str) {
        RouteMeta routeMeta = d.f29002d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void c(Postcard postcard) {
        if (postcard == null) {
            throw new NoRouteFoundException("ARouter::No postcard!");
        }
        RouteMeta routeMeta = d.f29000b.get(postcard.getPath());
        if (routeMeta != null) {
            postcard.setDestination(routeMeta.getDestination());
            postcard.setType(routeMeta.getType());
            postcard.setPriority(routeMeta.getPriority());
            postcard.setExtra(routeMeta.getExtra());
            Uri uri = postcard.getUri();
            if (uri != null) {
                Map<String, String> mapE = f.e(uri);
                Map<String, Integer> paramsType = routeMeta.getParamsType();
                if (j3.d.b(paramsType)) {
                    for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                        k(postcard, entry.getValue(), entry.getKey(), mapE.get(entry.getKey()));
                    }
                    postcard.getExtras().putStringArray(h3.a.f30399b, (String[]) paramsType.keySet().toArray(new String[0]));
                }
                postcard.withString(h3.a.f30398a, uri.toString());
            }
            int i10 = a.f28998a[routeMeta.getType().ordinal()];
            if (i10 == 1) {
                Class<?> destination = routeMeta.getDestination();
                IProvider iProvider = d.f29001c.get(destination);
                if (iProvider == null) {
                    try {
                        iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iProvider.init(f28995a);
                        d.f29001c.put(destination, iProvider);
                    } catch (Exception e10) {
                        h3.a.f30402e.error("ARouter::", "Init provider failed!", e10);
                        throw new HandlerException("Init provider failed!");
                    }
                }
                postcard.setProvider(iProvider);
                postcard.greenChannel();
            } else if (i10 == 2) {
                postcard.greenChannel();
            }
        } else {
            if (!d.f28999a.containsKey(postcard.getGroup())) {
                throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
            }
            try {
                if (h3.a.g()) {
                    h3.a.f30402e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                a(postcard.getGroup(), null);
                if (h3.a.g()) {
                    h3.a.f30402e.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                c(postcard);
            } catch (Exception e11) {
                throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e11.getMessage() + "]");
            }
        }
    }

    public static synchronized void d(Context context, ThreadPoolExecutor threadPoolExecutor) throws HandlerException {
        Set<String> setA;
        f28995a = context;
        f28996b = threadPoolExecutor;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            e();
            if (f28997c) {
                h3.a.f30402e.info("ARouter::", "Load router map by arouter-auto-register plugin.");
            } else {
                if (h3.a.g() || e.b(context)) {
                    h3.a.f30402e.info("ARouter::", "Run with debug mode or new install, rebuild router map.");
                    setA = j3.a.a(f28995a, j3.b.f36045i);
                    if (!setA.isEmpty()) {
                        context.getSharedPreferences(j3.b.f36046j, 0).edit().putStringSet(j3.b.f36047k, setA).apply();
                    }
                    e.c(context);
                } else {
                    h3.a.f30402e.info("ARouter::", "Load router map from cache.");
                    setA = new HashSet<>(context.getSharedPreferences(j3.b.f36046j, 0).getStringSet(j3.b.f36047k, new HashSet()));
                }
                h3.a.f30402e.info("ARouter::", "Find router map finished, map size = " + setA.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : setA) {
                    if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                        ((IRouteRoot) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(d.f28999a);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                        ((IInterceptorGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(d.f29003e);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                        ((IProviderGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(d.f29002d);
                    }
                }
            }
            h3.a.f30402e.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
            if (d.f28999a.size() == 0) {
                h3.a.f30402e.error("ARouter::", "No mapping files were found, check your configuration please!");
            }
            if (h3.a.g()) {
                h3.a.f30402e.debug("ARouter::", String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(d.f28999a.size()), Integer.valueOf(d.f29003e.size()), Integer.valueOf(d.f29002d.size())));
            }
        } catch (Exception e10) {
            throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e10.getMessage() + "]");
        }
    }

    public static void e() {
        f28997c = false;
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$device_manager");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$remote");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$community");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$account");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$game");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$headset");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$data");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$base");
        g("com.alibaba.android.arouter.routes.ARouter$$Root$$app");
        g("com.alibaba.android.arouter.routes.ARouter$$Interceptors$$data");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$device_manager");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$remote");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$community");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$account");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$game");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$headset");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$data");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$base");
        g("com.alibaba.android.arouter.routes.ARouter$$Providers$$app");
    }

    public static void f() {
        if (f28997c) {
            return;
        }
        f28997c = true;
    }

    public static void g(String str) {
        if (f.d(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IRouteRoot) {
                j((IRouteRoot) objNewInstance);
            } else if (objNewInstance instanceof IProviderGroup) {
                i((IProviderGroup) objNewInstance);
            } else if (objNewInstance instanceof IInterceptorGroup) {
                h((IInterceptorGroup) objNewInstance);
            } else {
                h3.a.f30402e.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
            }
        } catch (Exception e10) {
            h3.a.f30402e.error("ARouter::", "register class error:" + str, e10);
        }
    }

    public static void h(IInterceptorGroup iInterceptorGroup) {
        f();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(d.f29003e);
        }
    }

    public static void i(IProviderGroup iProviderGroup) {
        f();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(d.f29002d);
        }
    }

    public static void j(IRouteRoot iRouteRoot) {
        f();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(d.f28999a);
        }
    }

    public static void k(Postcard postcard, Integer num, String str, String str2) {
        if (f.d(str) || f.d(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th2) {
            h3.a.f30402e.warning("ARouter::", "LogisticsCenter setValue failed! " + th2.getMessage());
        }
    }

    public static void l() {
        d.a();
    }
}
