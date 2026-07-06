package a;

import a.hn;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static dn f5917a = new dn();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Class, a> f584a = new HashMap();
    public final Map<Class, Boolean> b = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<hn.a, List<en>> f5918a = new HashMap();
        public final Map<en, hn.a> b;

        public a(Map<en, hn.a> map) {
            this.b = map;
            for (Map.Entry<en, hn.a> entry : map.entrySet()) {
                hn.a value = entry.getValue();
                List<en> arrayList = this.f5918a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f5918a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        public static void b(List<en> list, kn knVar, hn.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(knVar, aVar, obj);
                }
            }
        }

        public void a(kn knVar, hn.a aVar, Object obj) {
            b(this.f5918a.get(aVar), knVar, aVar, obj);
            b(this.f5918a.get(hn.a.ON_ANY), knVar, aVar, obj);
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<en, hn.a> entry : c(cls2).b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            sn snVar = (sn) method.getAnnotation(sn.class);
            if (snVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(kn.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                hn.a aVarValue = snVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(hn.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != hn.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new en(i, method), aVarValue, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.f584a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public a c(Class cls) {
        a aVar = this.f584a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = this.b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((sn) method.getAnnotation(sn.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<en, hn.a> map, en enVar, hn.a aVar, Class cls) {
        hn.a aVar2 = map.get(enVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(enVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + enVar.f774a.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }
}
