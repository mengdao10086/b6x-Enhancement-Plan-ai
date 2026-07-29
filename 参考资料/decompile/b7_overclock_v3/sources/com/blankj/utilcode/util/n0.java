package com.blankj.utilcode.util;

import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    public n0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A(Map map) {
        return !p(map);
    }

    public static <T> T B(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    public static <T> T C(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static void D(Object... objArr) {
        Objects.requireNonNull(objArr);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
        }
    }

    public static String E(Object obj) {
        return String.valueOf(obj);
    }

    public static String F(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }

    public static <T> int a(T t10, T t11, @g.n0 Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "Argument 'c' of type Comparator<? super T> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (t10 == t11) {
            return 0;
        }
        return comparator.compare(t10, t11);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T c(T t10, T t11) {
        return t10 == null ? t11 : t10;
    }

    public static int d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int e(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @g.v0(api = 16)
    public static boolean f(LongSparseArray longSparseArray) {
        return longSparseArray == null || longSparseArray.size() == 0;
    }

    public static boolean g(SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    public static boolean h(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray == null || sparseBooleanArray.size() == 0;
    }

    public static boolean i(SparseIntArray sparseIntArray) {
        return sparseIntArray == null || sparseIntArray.size() == 0;
    }

    @g.v0(api = 18)
    public static boolean j(SparseLongArray sparseLongArray) {
        return sparseLongArray == null || sparseLongArray.size() == 0;
    }

    public static boolean k(androidx.collection.h hVar) {
        return hVar == null || hVar.w() == 0;
    }

    public static boolean l(androidx.collection.l lVar) {
        return lVar == null || lVar.isEmpty();
    }

    public static boolean m(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().length() == 0;
    }

    public static boolean n(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if ((obj instanceof CharSequence) && obj.toString().length() == 0) {
            return true;
        }
        if ((obj instanceof Collection) && ((Collection) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof androidx.collection.l) && ((androidx.collection.l) obj).isEmpty()) {
            return true;
        }
        if ((obj instanceof SparseArray) && ((SparseArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseBooleanArray) && ((SparseBooleanArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseIntArray) && ((SparseIntArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof SparseLongArray) && ((SparseLongArray) obj).size() == 0) {
            return true;
        }
        if ((obj instanceof androidx.collection.h) && ((androidx.collection.h) obj).w() == 0) {
            return true;
        }
        return (obj instanceof LongSparseArray) && ((LongSparseArray) obj).size() == 0;
    }

    public static boolean o(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean p(Map map) {
        return map == null || map.isEmpty();
    }

    @g.v0(api = 16)
    public static boolean q(LongSparseArray longSparseArray) {
        return !f(longSparseArray);
    }

    public static boolean r(SparseArray sparseArray) {
        return !g(sparseArray);
    }

    public static boolean s(SparseBooleanArray sparseBooleanArray) {
        return !h(sparseBooleanArray);
    }

    public static boolean t(SparseIntArray sparseIntArray) {
        return !i(sparseIntArray);
    }

    @g.v0(api = 18)
    public static boolean u(SparseLongArray sparseLongArray) {
        return !j(sparseLongArray);
    }

    public static boolean v(androidx.collection.h hVar) {
        return !k(hVar);
    }

    public static boolean w(androidx.collection.l lVar) {
        return !l(lVar);
    }

    public static boolean x(CharSequence charSequence) {
        return !m(charSequence);
    }

    public static boolean y(Object obj) {
        return !n(obj);
    }

    public static boolean z(Collection collection) {
        return !o(collection);
    }
}
