package m0;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import j0.f;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40525a = "WeightTypeface";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f40526b = "native_instance";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f40527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.b0("sWeightCacheLock")
    public static final androidx.collection.h<SparseArray<Typeface>> f40528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f40529e;

    static {
        Field declaredField;
        try {
            declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
        } catch (Exception unused) {
            declaredField = null;
        }
        f40527c = declaredField;
        f40528d = new androidx.collection.h<>(3);
        f40529e = new Object();
    }

    @p0
    public static Typeface a(@n0 c0 c0Var, @n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        if (!d()) {
            return null;
        }
        int i11 = (i10 << 1) | (z10 ? 1 : 0);
        synchronized (f40529e) {
            long jC = c(typeface);
            androidx.collection.h<SparseArray<Typeface>> hVar = f40528d;
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
            Typeface typefaceB = b(c0Var, context, typeface, i10, z10);
            if (typefaceB == null) {
                typefaceB = e(typeface, i10, z10);
            }
            sparseArrayH.put(i11, typefaceB);
            return typefaceB;
        }
    }

    @p0
    public static Typeface b(@n0 c0 c0Var, @n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        f.d dVarM = c0Var.m(typeface);
        if (dVarM == null) {
            return null;
        }
        return c0Var.c(context, dVarM, context.getResources(), i10, z10);
    }

    public static long c(@n0 Typeface typeface) {
        try {
            return ((Number) f40527c.get(typeface)).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean d() {
        return f40527c != null;
    }

    public static Typeface e(Typeface typeface, int i10, boolean z10) {
        int i11 = 1;
        boolean z11 = i10 >= 600;
        if (!z11 && !z10) {
            i11 = 0;
        } else if (!z11) {
            i11 = 2;
        } else if (z10) {
            i11 = 3;
        }
        return Typeface.create(typeface, i11);
    }
}
