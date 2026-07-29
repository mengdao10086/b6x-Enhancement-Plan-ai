package au;

import com.umeng.analytics.pro.an;
import dalvik.system.VMRuntime;
import fh.a;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;
import xf.j;

/* JADX INFO: loaded from: classes6.dex */
@v0(28)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f8891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f8892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f8893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f8894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f8895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f8897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f8898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f8899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f8900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f8901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f8902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f8903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set f8904n = new HashSet();

    static {
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            f8891a = unsafe;
            f8892b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
            f8893c = unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
            long jObjectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
            f8894d = jObjectFieldOffset;
            f8895e = unsafe.objectFieldOffset(g.class.getDeclaredField(a.g.f28420k));
            long jObjectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
            f8896f = jObjectFieldOffset2;
            long jObjectFieldOffset3 = unsafe.objectFieldOffset(b.class.getDeclaredField("iFields"));
            f8897g = jObjectFieldOffset3;
            f8898h = unsafe.objectFieldOffset(b.class.getDeclaredField("sFields"));
            f8899i = unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
            Method declaredMethod = h.class.getDeclaredMethod("a", new Class[0]);
            Method declaredMethod2 = h.class.getDeclaredMethod("b", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j10 = unsafe.getLong(methodHandleUnreflect, jObjectFieldOffset);
            long j11 = unsafe.getLong(methodHandleUnreflect2, jObjectFieldOffset);
            long j12 = unsafe.getLong(h.class, jObjectFieldOffset2);
            long j13 = j11 - j10;
            f8900j = j13;
            f8901k = (j10 - j12) - j13;
            Field declaredField = h.class.getDeclaredField("i");
            Field declaredField2 = h.class.getDeclaredField(j.f55230b);
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            long j14 = unsafe.getLong(methodHandleUnreflectGetter, jObjectFieldOffset);
            long j15 = unsafe.getLong(methodHandleUnreflectGetter2, jObjectFieldOffset);
            long j16 = unsafe.getLong(h.class, jObjectFieldOffset3);
            f8902l = j15 - j14;
            f8903m = j14 - j16;
        } catch (ReflectiveOperationException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    @i1
    public static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (clsArr[i10].isPrimitive()) {
                if (clsArr[i10] == Integer.TYPE && !(objArr[i10] instanceof Integer)) {
                    return false;
                }
                if (clsArr[i10] == Byte.TYPE && !(objArr[i10] instanceof Byte)) {
                    return false;
                }
                if (clsArr[i10] == Character.TYPE && !(objArr[i10] instanceof Character)) {
                    return false;
                }
                if (clsArr[i10] == Boolean.TYPE && !(objArr[i10] instanceof Boolean)) {
                    return false;
                }
                if (clsArr[i10] == Double.TYPE && !(objArr[i10] instanceof Double)) {
                    return false;
                }
                if (clsArr[i10] == Float.TYPE && !(objArr[i10] instanceof Float)) {
                    return false;
                }
                if (clsArr[i10] == Long.TYPE && !(objArr[i10] instanceof Long)) {
                    return false;
                }
                if (clsArr[i10] == Short.TYPE && !(objArr[i10] instanceof Short)) {
                    return false;
                }
            } else if (objArr[i10] != null && !clsArr[i10].isInstance(objArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        Set set = f8904n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return k(strArr2);
    }

    public static boolean c() {
        ((HashSet) f8904n).clear();
        return k(new String[0]);
    }

    @n0
    public static Constructor d(@n0 Class cls, @n0 Class... clsArr) throws NoSuchMethodException {
        for (Executable executable : f(cls)) {
            if (executable instanceof Constructor) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i10 = 0; i10 < clsArr.length; i10++) {
                        if (clsArr[i10] != parameterTypes[i10]) {
                            break;
                        }
                    }
                    return (Constructor) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    @n0
    public static Method e(@n0 Class cls, @n0 String str, @n0 Class... clsArr) throws NoSuchMethodException {
        for (Executable executable : f(cls)) {
            if (executable.getName().equals(str) && (executable instanceof Method)) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i10 = 0; i10 < clsArr.length; i10++) {
                        if (clsArr[i10] != parameterTypes[i10]) {
                            break;
                        }
                    }
                    return (Method) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    @n0
    public static List f(@n0 Class cls) {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Method declaredMethod = h.class.getDeclaredMethod("a", new Class[0]);
                declaredMethod.setAccessible(true);
                MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
                Unsafe unsafe = f8891a;
                long j10 = unsafe.getLong(cls, f8896f);
                if (j10 == 0) {
                    return arrayList;
                }
                int i10 = unsafe.getInt(j10);
                for (int i11 = 0; i11 < i10; i11++) {
                    long j11 = (((long) i11) * f8900j) + j10 + f8901k;
                    Unsafe unsafe2 = f8891a;
                    unsafe2.putLong(methodHandleUnreflect, f8894d, j11);
                    unsafe2.putObject(methodHandleUnreflect, f8895e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflect);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f8891a;
                    arrayList.add((Executable) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflect, f8895e), f8899i));
                }
            } catch (IllegalAccessException | NoSuchMethodException unused2) {
            }
        }
        return arrayList;
    }

    @n0
    public static List g(@n0 Class cls) {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = h.class.getDeclaredField("i");
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe = f8891a;
                long j10 = unsafe.getLong(cls, f8897g);
                if (j10 == 0) {
                    return arrayList;
                }
                int i10 = unsafe.getInt(j10);
                for (int i11 = 0; i11 < i10; i11++) {
                    long j11 = (((long) i11) * f8902l) + j10 + f8903m;
                    Unsafe unsafe2 = f8891a;
                    unsafe2.putLong(methodHandleUnreflectGetter, f8894d, j11);
                    unsafe2.putObject(methodHandleUnreflectGetter, f8895e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflectGetter);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f8891a;
                    arrayList.add((Field) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflectGetter, f8895e), f8899i));
                }
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return arrayList;
    }

    @n0
    public static List h(@n0 Class cls) {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = h.class.getDeclaredField(an.aB);
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe = f8891a;
                long j10 = unsafe.getLong(cls, f8898h);
                if (j10 == 0) {
                    return arrayList;
                }
                int i10 = unsafe.getInt(j10);
                for (int i11 = 0; i11 < i10; i11++) {
                    long j11 = (((long) i11) * f8902l) + j10 + f8903m;
                    Unsafe unsafe2 = f8891a;
                    unsafe2.putLong(methodHandleUnreflectGetter, f8894d, j11);
                    unsafe2.putObject(methodHandleUnreflectGetter, f8895e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflectGetter);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f8891a;
                    arrayList.add((Field) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflectGetter, f8895e), f8899i));
                }
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return arrayList;
    }

    public static Object i(@n0 Class cls, @p0 Object obj, @n0 String str, Object... objArr) throws NoSuchMethodException {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = f8891a;
        long j10 = unsafe.getLong(cls, f8896f);
        if (j10 == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i10 = unsafe.getInt(j10);
        for (int i11 = 0; i11 < i10; i11++) {
            f8891a.putLong(declaredMethod, f8892b, (((long) i11) * f8900j) + j10 + f8901k);
            if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Object j(@n0 Class cls, Object... objArr) throws NoSuchMethodException {
        Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
        Constructor declaredConstructor = e.class.getDeclaredConstructor(Object[].class);
        declaredConstructor.setAccessible(true);
        Unsafe unsafe = f8891a;
        long j10 = unsafe.getLong(cls, f8896f);
        if (j10 == 0) {
            throw new NoSuchMethodException("Cannot find matching constructor");
        }
        int i10 = unsafe.getInt(j10);
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = (((long) i11) * f8900j) + j10 + f8901k;
            Unsafe unsafe2 = f8891a;
            long j12 = f8892b;
            unsafe2.putLong(declaredMethod, j12, j11);
            if ("<init>".equals(declaredMethod.getName())) {
                unsafe2.putLong(declaredConstructor, j12, j11);
                unsafe2.putObject(declaredConstructor, f8893c, cls);
                if (a(declaredConstructor.getParameterTypes(), objArr)) {
                    return declaredConstructor.newInstance(objArr);
                }
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean k(@n0 String... strArr) {
        try {
            i(VMRuntime.class, i(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
