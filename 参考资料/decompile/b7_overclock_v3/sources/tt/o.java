package tt;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51703d = 64;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f51704e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f51705f = 5192;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f51707h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<vt.d> f51709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f51711c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Class<?>, List<n>> f51706g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a[] f51708i = new a[4];

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f51712a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Class, Object> f51713b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Class> f51714c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f51715d = new StringBuilder(128);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Class<?> f51716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Class<?> f51717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f51718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public vt.c f51719h;

        public boolean a(Method method, Class<?> cls) {
            Object objPut = this.f51713b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f51713b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.f51715d.setLength(0);
            this.f51715d.append(method.getName());
            StringBuilder sb2 = this.f51715d;
            sb2.append('>');
            sb2.append(cls.getName());
            String string = this.f51715d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f51714c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f51714c.put(string, clsPut);
            return false;
        }

        public void c(Class<?> cls) {
            this.f51717f = cls;
            this.f51716e = cls;
            this.f51718g = false;
            this.f51719h = null;
        }

        public void d() {
            if (this.f51718g) {
                this.f51717f = null;
                return;
            }
            Class<? super Object> superclass = this.f51717f.getSuperclass();
            this.f51717f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.f51717f = null;
            }
        }

        public void e() {
            this.f51712a.clear();
            this.f51713b.clear();
            this.f51714c.clear();
            this.f51715d.setLength(0);
            this.f51716e = null;
            this.f51717f = null;
            this.f51718g = false;
            this.f51719h = null;
        }
    }

    public o(List<vt.d> list, boolean z10, boolean z11) {
        this.f51709a = list;
        this.f51710b = z10;
        this.f51711c = z11;
    }

    public static void a() {
        f51706g.clear();
    }

    public List<n> b(Class<?> cls) {
        Map<Class<?>, List<n>> map = f51706g;
        List<n> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<n> listD = this.f51711c ? d(cls) : c(cls);
        if (!listD.isEmpty()) {
            map.put(cls, listD);
            return listD;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<n> c(Class<?> cls) {
        a aVarH = h();
        aVarH.c(cls);
        while (aVarH.f51717f != null) {
            vt.c cVarG = g(aVarH);
            aVarH.f51719h = cVarG;
            if (cVarG != null) {
                for (n nVar : cVarG.a()) {
                    if (aVarH.a(nVar.f51697a, nVar.f51699c)) {
                        aVarH.f51712a.add(nVar);
                    }
                }
            } else {
                e(aVarH);
            }
            aVarH.d();
        }
        return f(aVarH);
    }

    public final List<n> d(Class<?> cls) {
        a aVarH = h();
        aVarH.c(cls);
        while (aVarH.f51717f != null) {
            e(aVarH);
            aVarH.d();
        }
        return f(aVarH);
    }

    public final void e(a aVar) {
        Method[] methods;
        try {
            try {
                methods = aVar.f51717f.getDeclaredMethods();
            } catch (LinkageError e10) {
                String str = "Could not inspect methods of " + aVar.f51717f.getName();
                throw new EventBusException(this.f51711c ? str + ". Please consider using EventBus annotation processor to avoid reflection." : str + ". Please make this class visible to EventBus annotation processor to avoid reflection.", e10);
            }
        } catch (Throwable unused) {
            methods = aVar.f51717f.getMethods();
            aVar.f51718g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & f51705f) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    l lVar = (l) method.getAnnotation(l.class);
                    if (lVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f51712a.add(new n(method, cls, lVar.threadMode(), lVar.priority(), lVar.sticky()));
                        }
                    }
                } else if (this.f51710b && method.isAnnotationPresent(l.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + j3.b.f36044h + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f51710b && method.isAnnotationPresent(l.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + j3.b.f36044h + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List<n> f(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f51712a);
        aVar.e();
        synchronized (f51708i) {
            int i10 = 0;
            while (true) {
                if (i10 >= 4) {
                    break;
                }
                a[] aVarArr = f51708i;
                if (aVarArr[i10] == null) {
                    aVarArr[i10] = aVar;
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    public final vt.c g(a aVar) {
        vt.c cVar = aVar.f51719h;
        if (cVar != null && cVar.b() != null) {
            vt.c cVarB = aVar.f51719h.b();
            if (aVar.f51717f == cVarB.d()) {
                return cVarB;
            }
        }
        List<vt.d> list = this.f51709a;
        if (list == null) {
            return null;
        }
        Iterator<vt.d> it2 = list.iterator();
        while (it2.hasNext()) {
            vt.c cVarA = it2.next().a(aVar.f51717f);
            if (cVarA != null) {
                return cVarA;
            }
        }
        return null;
    }

    public final a h() {
        synchronized (f51708i) {
            for (int i10 = 0; i10 < 4; i10++) {
                a[] aVarArr = f51708i;
                a aVar = aVarArr[i10];
                if (aVar != null) {
                    aVarArr[i10] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
