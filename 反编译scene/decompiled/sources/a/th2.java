package a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class th2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7503a = d(Throwable.class, -1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ReentrantReadWriteLock f3032a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final WeakHashMap<Class<? extends Throwable>, g82<Throwable, Throwable>> f3031a = new WeakHashMap<>();

    public static final g82<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ph2(constructor);
        }
        if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (f92.a(cls, Throwable.class)) {
                return new nh2(constructor);
            }
            if (f92.a(cls, String.class)) {
                return new oh2(constructor);
            }
        } else if (length == 2 && f92.a(parameterTypes[0], String.class) && f92.a(parameterTypes[1], Throwable.class)) {
            return new mh2(constructor);
        }
        return null;
    }

    public static final int b(Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    public static final int d(Class<?> cls, int i) {
        Object objA;
        u72.b(cls);
        try {
            e42 e42Var = g42.f6169a;
            objA = Integer.valueOf(c(cls, 0, 1, null));
            g42.a(objA);
        } catch (Throwable th) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th);
            g42.a(objA);
        }
        Integer numValueOf = Integer.valueOf(i);
        if (g42.c(objA)) {
            objA = numValueOf;
        }
        return ((Number) objA).intValue();
    }

    public static final <E extends Throwable> E e(E e) {
        Object objA;
        if (e instanceof kd2) {
            try {
                e42 e42Var = g42.f6169a;
                objA = ((kd2) e).a();
                g42.a(objA);
            } catch (Throwable th) {
                e42 e42Var2 = g42.f6169a;
                objA = h42.a(th);
                g42.a(objA);
            }
            return (E) (g42.c(objA) ? null : objA);
        }
        ReentrantReadWriteLock.ReadLock lock = f3032a.readLock();
        lock.lock();
        try {
            g82<Throwable, Throwable> g82Var = f3031a.get(e.getClass());
            if (g82Var != null) {
                return (E) g82Var.f(e);
            }
            int i = 0;
            if (f7503a != d(e.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = f3032a;
                ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    lock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f3031a.put((Class<? extends Throwable>) e.getClass(), rh2.f7301a);
                    m42 m42Var = m42.f6769a;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        lock2.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            Iterator it = u42.F(e.getClass().getConstructors(), new qh2()).iterator();
            g82<Throwable, Throwable> g82VarA = null;
            while (it.hasNext() && (g82VarA = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f3032a;
            ReentrantReadWriteLock.ReadLock lock3 = reentrantReadWriteLock2.readLock();
            int readHoldCount2 = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount2; i3++) {
                lock3.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
            writeLock2.lock();
            try {
                f3031a.put((Class<? extends Throwable>) e.getClass(), g82VarA != null ? g82VarA : sh2.f7400a);
                m42 m42Var2 = m42.f6769a;
                while (i < readHoldCount2) {
                    lock3.lock();
                    i++;
                }
                writeLock2.unlock();
                if (g82VarA != null) {
                    return (E) g82VarA.f(e);
                }
                return null;
            } finally {
                while (i < readHoldCount2) {
                    lock3.lock();
                    i++;
                }
                writeLock2.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
