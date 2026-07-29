package m0;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(21)
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40530a = "WeightTypeface";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40531b = "native_instance";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f40532c = "nativeCreateFromTypeface";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f40533d = "nativeCreateWeightAlias";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Field f40534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f40535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f40536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Constructor<Typeface> f40537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.b0("sWeightCacheLock")
    public static final androidx.collection.h<SparseArray<Typeface>> f40538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f40539j;

    static {
        Method declaredMethod;
        Method declaredMethod2;
        Constructor<Typeface> declaredConstructor;
        Field field = null;
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            Class cls2 = Integer.TYPE;
            declaredMethod = Typeface.class.getDeclaredMethod(f40532c, cls, cls2);
            declaredMethod.setAccessible(true);
            declaredMethod2 = Typeface.class.getDeclaredMethod(f40533d, cls, cls2);
            declaredMethod2.setAccessible(true);
            declaredConstructor = Typeface.class.getDeclaredConstructor(cls);
            declaredConstructor.setAccessible(true);
            field = declaredField;
        } catch (NoSuchFieldException | NoSuchMethodException unused) {
            declaredMethod = null;
            declaredMethod2 = null;
            declaredConstructor = null;
        }
        f40534e = field;
        f40535f = declaredMethod;
        f40536g = declaredMethod2;
        f40537h = declaredConstructor;
        f40538i = new androidx.collection.h<>(3);
        f40539j = new Object();
    }

    @p0
    public static Typeface a(long j10) {
        try {
            return f40537h.newInstance(Long.valueOf(j10));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @p0
    public static Typeface b(@n0 Typeface typeface, int i10, boolean z10) {
        if (!d()) {
            return null;
        }
        int i11 = (i10 << 1) | (z10 ? 1 : 0);
        synchronized (f40539j) {
            long jC = c(typeface);
            androidx.collection.h<SparseArray<Typeface>> hVar = f40538i;
            SparseArray<Typeface> sparseArrayH = hVar.h(jC);
            if (sparseArrayH == null) {
                sparseArrayH = new SparseArray<>(4);
                hVar.n(jC, sparseArrayH);
            } else {
                Typeface typeface2 = sparseArrayH.get(i11);
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            Typeface typefaceA = z10 == typeface.isItalic() ? a(f(jC, i10)) : a(e(jC, i10, z10));
            sparseArrayH.put(i11, typefaceA);
            return typefaceA;
        }
    }

    public static long c(@n0 Typeface typeface) {
        try {
            return f40534e.getLong(typeface);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean d() {
        return f40534e != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static long e(long j10, int i10, boolean z10) {
        try {
            return ((Long) f40536g.invoke(null, Long.valueOf(((Long) f40535f.invoke(null, Long.valueOf(j10), Integer.valueOf(z10 ? 2 : 0))).longValue()), Integer.valueOf(i10))).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static long f(long j10, int i10) {
        try {
            return ((Long) f40536g.invoke(null, Long.valueOf(j10), Integer.valueOf(i10))).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
