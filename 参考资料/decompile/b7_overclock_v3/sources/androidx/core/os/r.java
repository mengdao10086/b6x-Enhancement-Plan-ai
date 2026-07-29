package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.os.a;
import g.n0;
import g.p0;
import g.r0;
import g.v0;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    @v0(29)
    public static class a {
        @g.u
        public static <T extends Parcelable> List<T> a(@n0 Parcel parcel, @n0 List<T> list, @p0 ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    @v0(30)
    public static class b {
        @g.u
        public static Parcelable.Creator<?> a(@n0 Parcel parcel, @p0 ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    @v0(33)
    public static class c {
        @g.u
        public static <T> T[] a(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return (T[]) parcel.readArray(classLoader, cls);
        }

        @g.u
        public static <T> ArrayList<T> b(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readArrayList(classLoader, cls);
        }

        @g.u
        public static <V, K> HashMap<K, V> c(Parcel parcel, ClassLoader classLoader, Class<? extends K> cls, Class<? extends V> cls2) {
            return parcel.readHashMap(classLoader, cls, cls2);
        }

        @g.u
        public static <T> void d(@n0 Parcel parcel, @n0 List<? super T> list, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
            parcel.readList(list, classLoader, cls);
        }

        @g.u
        public static <K, V> void e(Parcel parcel, Map<? super K, ? super V> map, ClassLoader classLoader, Class<K> cls, Class<V> cls2) {
            parcel.readMap(map, classLoader, cls, cls2);
        }

        @g.u
        public static <T extends Parcelable> T f(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
            return (T) parcel.readParcelable(classLoader, cls);
        }

        @g.u
        public static <T> T[] g(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
            return (T[]) parcel.readParcelableArray(classLoader, cls);
        }

        @g.u
        public static <T> Parcelable.Creator<T> h(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
            return parcel.readParcelableCreator(classLoader, cls);
        }

        @g.u
        public static <T> List<T> i(@n0 Parcel parcel, @n0 List<T> list, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
            return parcel.readParcelableList(list, classLoader, cls);
        }

        @g.u
        public static <T extends Serializable> T j(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
            return (T) parcel.readSerializable(classLoader, cls);
        }

        @g.u
        public static <T> SparseArray<T> k(Parcel parcel, ClassLoader classLoader, Class<? extends T> cls) {
            return parcel.readSparseArray(classLoader, cls);
        }
    }

    @p0
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <T> Object[] a(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        return androidx.core.os.a.l() ? c.a(parcel, classLoader, cls) : parcel.readArray(classLoader);
    }

    @p0
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <T> ArrayList<T> b(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<? extends T> cls) {
        return androidx.core.os.a.l() ? c.b(parcel, classLoader, cls) : parcel.readArrayList(classLoader);
    }

    public static boolean c(@n0 Parcel parcel) {
        return parcel.readInt() != 0;
    }

    @p0
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <K, V> HashMap<K, V> d(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<? extends K> cls, @n0 Class<? extends V> cls2) {
        return androidx.core.os.a.l() ? c.c(parcel, classLoader, cls, cls2) : parcel.readHashMap(classLoader);
    }

    @r0(markerClass = {a.b.class})
    public static <T> void e(@n0 Parcel parcel, @n0 List<? super T> list, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        if (androidx.core.os.a.l()) {
            c.d(parcel, list, classLoader, cls);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    @r0(markerClass = {a.b.class})
    public static <K, V> void f(@n0 Parcel parcel, @n0 Map<? super K, ? super V> map, @p0 ClassLoader classLoader, @n0 Class<K> cls, @n0 Class<V> cls2) {
        if (androidx.core.os.a.l()) {
            c.e(parcel, map, classLoader, cls, cls2);
        } else {
            parcel.readMap(map, classLoader);
        }
    }

    @p0
    @r0(markerClass = {a.b.class})
    public static <T extends Parcelable> T g(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        if (androidx.core.os.a.l()) {
            return (T) c.f(parcel, classLoader, cls);
        }
        T t10 = (T) parcel.readParcelable(classLoader);
        if (cls.isInstance(t10)) {
            return t10;
        }
        throw new BadParcelableException("Parcelable " + t10.getClass() + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    @Deprecated
    @p0
    public static <T> T[] h(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        if (androidx.core.os.a.l()) {
            return (T[]) c.g(parcel, classLoader, cls);
        }
        T[] tArr = (T[]) parcel.readParcelableArray(classLoader);
        if (cls.isAssignableFrom(Parcelable.class)) {
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, tArr.length));
        for (int i10 = 0; i10 < tArr.length; i10++) {
            try {
                tArr2[i10] = cls.cast(tArr[i10]);
            } catch (ClassCastException unused) {
                throw new BadParcelableException("Parcelable at index " + i10 + " is not a subclass of required class " + cls.getName() + " provided in the parameter");
            }
        }
        return tArr2;
    }

    @p0
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <T> Parcelable[] i(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        return androidx.core.os.a.l() ? (Parcelable[]) c.g(parcel, classLoader, cls) : parcel.readParcelableArray(classLoader);
    }

    @p0
    @r0(markerClass = {a.b.class})
    @v0(30)
    public static <T> Parcelable.Creator<T> j(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        return androidx.core.os.a.l() ? c.h(parcel, classLoader, cls) : (Parcelable.Creator<T>) b.a(parcel, classLoader);
    }

    @n0
    @r0(markerClass = {a.b.class})
    @v0(api = 29)
    public static <T> List<T> k(@n0 Parcel parcel, @n0 List<T> list, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        return androidx.core.os.a.l() ? c.i(parcel, list, classLoader, cls) : a.a(parcel, list, classLoader);
    }

    @p0
    @r0(markerClass = {a.b.class})
    public static <T extends Serializable> T l(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<T> cls) {
        return androidx.core.os.a.k() ? (T) c.j(parcel, classLoader, cls) : (T) parcel.readSerializable();
    }

    @p0
    @r0(markerClass = {a.b.class})
    public static <T> SparseArray<T> m(@n0 Parcel parcel, @p0 ClassLoader classLoader, @n0 Class<? extends T> cls) {
        return androidx.core.os.a.l() ? c.k(parcel, classLoader, cls) : parcel.readSparseArray(classLoader);
    }

    public static void n(@n0 Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }
}
