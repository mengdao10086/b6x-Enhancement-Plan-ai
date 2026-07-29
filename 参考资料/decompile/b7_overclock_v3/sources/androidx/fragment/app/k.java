package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.l<ClassLoader, androidx.collection.l<String, Class<?>>> f5999a = new androidx.collection.l<>();

    public static boolean b(@g.n0 ClassLoader classLoader, @g.n0 String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @g.n0
    public static Class<?> c(@g.n0 ClassLoader classLoader, @g.n0 String str) throws ClassNotFoundException {
        androidx.collection.l<ClassLoader, androidx.collection.l<String, Class<?>>> lVar = f5999a;
        androidx.collection.l<String, Class<?>> lVar2 = lVar.get(classLoader);
        if (lVar2 == null) {
            lVar2 = new androidx.collection.l<>();
            lVar.put(classLoader, lVar2);
        }
        Class<?> cls = lVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        lVar2.put(str, cls2);
        return cls2;
    }

    @g.n0
    public static Class<? extends Fragment> d(@g.n0 ClassLoader classLoader, @g.n0 String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e10) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e10);
        } catch (ClassNotFoundException e11) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e11);
        }
    }

    @g.n0
    public Fragment a(@g.n0 ClassLoader classLoader, @g.n0 String str) {
        try {
            return d(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e10) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (InstantiationException e11) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }
}
