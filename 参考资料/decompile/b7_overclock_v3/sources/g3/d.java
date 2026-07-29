package g3;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Class<? extends IRouteGroup>> f28999a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, RouteMeta> f29000b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<Class, IProvider> f29001c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, RouteMeta> f29002d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<Integer, Class<? extends IInterceptor>> f29003e = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<IInterceptor> f29004f = new ArrayList();

    public static void a() {
        f29000b.clear();
        f28999a.clear();
        f29001c.clear();
        f29002d.clear();
        f29004f.clear();
        f29003e.clear();
    }
}
