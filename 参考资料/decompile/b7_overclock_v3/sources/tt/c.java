package tt;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f51636s = "EventBus";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile c f51637t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final tt.d f51638u = new tt.d();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Map<Class<?>, List<Class<?>>> f51639v = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<p>> f51640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f51641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, Object> f51642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<d> f51643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f51644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f51645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final tt.b f51646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final tt.a f51647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o f51648i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExecutorService f51649j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f51650k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f51651l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f51652m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f51653n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f51654o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f51655p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f51656q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f51657r;

    public class a extends ThreadLocal<d> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d initialValue() {
            return new d();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51659a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f51659a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51659a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51659a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f51659a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f51659a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: tt.c$c, reason: collision with other inner class name */
    public interface InterfaceC0593c {
        void a(List<m> list);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f51660a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f51661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public p f51663d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f51664e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f51665f;
    }

    public c() {
        this(f51638u);
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static tt.d b() {
        return new tt.d();
    }

    public static void e() {
        o.a();
        f51639v.clear();
    }

    public static c f() {
        c cVar = f51637t;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = f51637t;
                if (cVar == null) {
                    cVar = new c();
                    f51637t = cVar;
                }
            }
        }
        return cVar;
    }

    public static List<Class<?>> p(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = f51639v;
        synchronized (map) {
            arrayList = map.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                f51639v.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public synchronized void A(Object obj) {
        List<Class<?>> list = this.f51641b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                B(obj, it2.next());
            }
            this.f51641b.remove(obj);
        } else {
            this.f51657r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public final void B(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList = this.f51640a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                p pVar = copyOnWriteArrayList.get(i10);
                if (pVar.f51720a == obj) {
                    pVar.f51722c = false;
                    copyOnWriteArrayList.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    public void c(Object obj) {
        d dVar = this.f51643d.get();
        if (!dVar.f51661b) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj == null) {
            throw new EventBusException("Event may not be null");
        }
        if (dVar.f51664e != obj) {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        if (dVar.f51663d.f51721b.f51698b != ThreadMode.POSTING) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
        dVar.f51665f = true;
    }

    public final void d(p pVar, Object obj) {
        if (obj != null) {
            u(pVar, obj, n());
        }
    }

    public ExecutorService g() {
        return this.f51649j;
    }

    public f h() {
        return this.f51657r;
    }

    public <T> T i(Class<T> cls) {
        T tCast;
        synchronized (this.f51642c) {
            tCast = cls.cast(this.f51642c.get(cls));
        }
        return tCast;
    }

    public final void j(p pVar, Object obj, Throwable th2) {
        if (!(obj instanceof m)) {
            if (this.f51650k) {
                throw new EventBusException("Invoking subscriber failed", th2);
            }
            if (this.f51651l) {
                this.f51657r.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + pVar.f51720a.getClass(), th2);
            }
            if (this.f51653n) {
                q(new m(this, th2, obj, pVar.f51720a));
                return;
            }
            return;
        }
        if (this.f51651l) {
            f fVar = this.f51657r;
            Level level = Level.SEVERE;
            fVar.b(level, "SubscriberExceptionEvent subscriber " + pVar.f51720a.getClass() + " threw an exception", th2);
            m mVar = (m) obj;
            this.f51657r.b(level, "Initial event " + mVar.f51695c + " caused exception in " + mVar.f51696d, mVar.f51694b);
        }
    }

    public boolean k(Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList;
        List<Class<?>> listP = p(cls);
        if (listP != null) {
            int size = listP.size();
            for (int i10 = 0; i10 < size; i10++) {
                Class<?> cls2 = listP.get(i10);
                synchronized (this) {
                    copyOnWriteArrayList = this.f51640a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(i iVar) {
        Object obj = iVar.f51688a;
        p pVar = iVar.f51689b;
        i.b(iVar);
        if (pVar.f51722c) {
            m(pVar, obj);
        }
    }

    public void m(p pVar, Object obj) {
        try {
            pVar.f51721b.f51697a.invoke(pVar.f51720a, obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Unexpected exception", e10);
        } catch (InvocationTargetException e11) {
            j(pVar, obj, e11.getCause());
        }
    }

    public final boolean n() {
        g gVar = this.f51644e;
        return gVar == null || gVar.b();
    }

    public synchronized boolean o(Object obj) {
        return this.f51641b.containsKey(obj);
    }

    public void q(Object obj) {
        d dVar = this.f51643d.get();
        List<Object> list = dVar.f51660a;
        list.add(obj);
        if (dVar.f51661b) {
            return;
        }
        dVar.f51662c = n();
        dVar.f51661b = true;
        if (dVar.f51665f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    r(list.remove(0), dVar);
                }
            } finally {
                dVar.f51661b = false;
                dVar.f51662c = false;
            }
        }
    }

    public final void r(Object obj, d dVar) throws Error {
        boolean zS;
        Class<?> cls = obj.getClass();
        if (this.f51655p) {
            List<Class<?>> listP = p(cls);
            int size = listP.size();
            zS = false;
            for (int i10 = 0; i10 < size; i10++) {
                zS |= s(obj, dVar, listP.get(i10));
            }
        } else {
            zS = s(obj, dVar, cls);
        }
        if (zS) {
            return;
        }
        if (this.f51652m) {
            this.f51657r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f51654o || cls == h.class || cls == m.class) {
            return;
        }
        q(new h(this, obj));
    }

    public final boolean s(Object obj, d dVar, Class<?> cls) {
        CopyOnWriteArrayList<p> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f51640a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (p pVar : copyOnWriteArrayList) {
            dVar.f51664e = obj;
            dVar.f51663d = pVar;
            try {
                u(pVar, obj, dVar.f51662c);
                if (dVar.f51665f) {
                    return true;
                }
            } finally {
                dVar.f51664e = null;
                dVar.f51663d = null;
                dVar.f51665f = false;
            }
        }
        return true;
    }

    public void t(Object obj) {
        synchronized (this.f51642c) {
            this.f51642c.put(obj.getClass(), obj);
        }
        q(obj);
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f51656q + ", eventInheritance=" + this.f51655p + "]";
    }

    public final void u(p pVar, Object obj, boolean z10) {
        int i10 = b.f51659a[pVar.f51721b.f51698b.ordinal()];
        if (i10 == 1) {
            m(pVar, obj);
            return;
        }
        if (i10 == 2) {
            if (z10) {
                m(pVar, obj);
                return;
            } else {
                this.f51645f.a(pVar, obj);
                return;
            }
        }
        if (i10 == 3) {
            k kVar = this.f51645f;
            if (kVar != null) {
                kVar.a(pVar, obj);
                return;
            } else {
                m(pVar, obj);
                return;
            }
        }
        if (i10 == 4) {
            if (z10) {
                this.f51646g.a(pVar, obj);
                return;
            } else {
                m(pVar, obj);
                return;
            }
        }
        if (i10 == 5) {
            this.f51647h.a(pVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + pVar.f51721b.f51698b);
    }

    public void v(Object obj) {
        if (ut.b.c() && !ut.b.a()) {
            throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
        }
        List<n> listB = this.f51648i.b(obj.getClass());
        synchronized (this) {
            Iterator<n> it2 = listB.iterator();
            while (it2.hasNext()) {
                z(obj, it2.next());
            }
        }
    }

    public void w() {
        synchronized (this.f51642c) {
            this.f51642c.clear();
        }
    }

    public <T> T x(Class<T> cls) {
        T tCast;
        synchronized (this.f51642c) {
            tCast = cls.cast(this.f51642c.remove(cls));
        }
        return tCast;
    }

    public boolean y(Object obj) {
        synchronized (this.f51642c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f51642c.get(cls))) {
                return false;
            }
            this.f51642c.remove(cls);
            return true;
        }
    }

    public final void z(Object obj, n nVar) {
        Class<?> cls = nVar.f51699c;
        p pVar = new p(obj, nVar);
        CopyOnWriteArrayList<p> copyOnWriteArrayList = this.f51640a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f51640a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(pVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i10 = 0; i10 <= size; i10++) {
            if (i10 == size || nVar.f51700d > copyOnWriteArrayList.get(i10).f51721b.f51700d) {
                copyOnWriteArrayList.add(i10, pVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f51641b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f51641b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (nVar.f51701e) {
            if (!this.f51655p) {
                d(pVar, this.f51642c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f51642c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    d(pVar, entry.getValue());
                }
            }
        }
    }

    public c(tt.d dVar) {
        this.f51643d = new a();
        this.f51657r = dVar.e();
        this.f51640a = new HashMap();
        this.f51641b = new HashMap();
        this.f51642c = new ConcurrentHashMap();
        g gVarF = dVar.f();
        this.f51644e = gVarF;
        this.f51645f = gVarF != null ? gVarF.a(this) : null;
        this.f51646g = new tt.b(this);
        this.f51647h = new tt.a(this);
        List<vt.d> list = dVar.f51677k;
        this.f51656q = list != null ? list.size() : 0;
        this.f51648i = new o(dVar.f51677k, dVar.f51674h, dVar.f51673g);
        this.f51651l = dVar.f51667a;
        this.f51652m = dVar.f51668b;
        this.f51653n = dVar.f51669c;
        this.f51654o = dVar.f51670d;
        this.f51650k = dVar.f51671e;
        this.f51655p = dVar.f51672f;
        this.f51649j = dVar.f51675i;
    }
}
