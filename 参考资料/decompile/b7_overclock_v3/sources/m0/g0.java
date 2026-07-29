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
@v0(26)
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40548a = "WeightTypeface";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40549b = "native_instance";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f40550c = "nativeCreateFromTypefaceWithExactStyle";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Field f40551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f40552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Constructor<Typeface> f40553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.b0("sWeightCacheLock")
    public static final androidx.collection.h<SparseArray<Typeface>> f40554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f40555h;

    static {
        Method declaredMethod;
        Constructor<Typeface> declaredConstructor;
        Field field = null;
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            declaredMethod = Typeface.class.getDeclaredMethod(f40550c, cls, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredConstructor = Typeface.class.getDeclaredConstructor(cls);
            declaredConstructor.setAccessible(true);
            field = declaredField;
        } catch (NoSuchFieldException | NoSuchMethodException unused) {
            declaredMethod = null;
            declaredConstructor = null;
        }
        f40551d = field;
        f40552e = declaredMethod;
        f40553f = declaredConstructor;
        f40554g = new androidx.collection.h<>(3);
        f40555h = new Object();
    }

    @p0
    public static Typeface a(long j10) {
        try {
            return f40553f.newInstance(Long.valueOf(j10));
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
        synchronized (f40555h) {
            long jC = c(typeface);
            androidx.collection.h<SparseArray<Typeface>> hVar = f40554g;
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
            Typeface typefaceA = a(e(jC, i10, z10));
            sparseArrayH.put(i11, typefaceA);
            return typefaceA;
        }
    }

    public static long c(@n0 Typeface typeface) {
        try {
            return f40551d.getLong(typeface);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean d() {
        return f40551d != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static long e(long j10, int i10, boolean z10) {
        try {
            return ((Long) f40552e.invoke(null, Long.valueOf(j10), Integer.valueOf(i10), Boolean.valueOf(z10))).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
