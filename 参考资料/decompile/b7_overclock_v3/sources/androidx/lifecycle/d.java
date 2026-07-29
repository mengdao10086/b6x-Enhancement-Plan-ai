package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f6176c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6177d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6178e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6179f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a> f6180a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Boolean> f6181b = new HashMap();

    @Deprecated
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Lifecycle.Event, List<b>> f6182a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f6183b;

        public a(Map<b, Lifecycle.Event> map) {
            this.f6183b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> arrayList = this.f6182a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f6182a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void b(List<b> list, y yVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(yVar, event, obj);
                }
            }
        }

        public void a(y yVar, Lifecycle.Event event, Object obj) {
            b(this.f6182a.get(event), yVar, event, obj);
            b(this.f6182a.get(Lifecycle.Event.ON_ANY), yVar, event, obj);
        }
    }

    @Deprecated
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f6185b;

        public b(int i10, Method method) {
            this.f6184a = i10;
            this.f6185b = method;
            method.setAccessible(true);
        }

        public void a(y yVar, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f6184a;
                if (i10 == 0) {
                    this.f6185b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f6185b.invoke(obj, yVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f6185b.invoke(obj, yVar, event);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f6184a == bVar.f6184a && this.f6185b.getName().equals(bVar.f6185b.getName());
        }

        public int hashCode() {
            return (this.f6184a * 31) + this.f6185b.getName().hashCode();
        }
    }

    public final a a(Class<?> cls, @g.p0 Method[] methodArr) {
        int i10;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f6183b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : c(cls2).f6183b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            l0 l0Var = (l0) method.getAnnotation(l0.class);
            if (l0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!y.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                Lifecycle.Event eventValue = l0Var.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventValue != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i10, method), eventValue, cls);
                z10 = true;
            }
        }
        a aVar = new a(map);
        this.f6180a.put(cls, aVar);
        this.f6181b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    public final Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public a c(Class<?> cls) {
        a aVar = this.f6180a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class<?> cls) {
        Boolean bool = this.f6181b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((l0) method.getAnnotation(l0.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f6181b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f6185b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }
}
