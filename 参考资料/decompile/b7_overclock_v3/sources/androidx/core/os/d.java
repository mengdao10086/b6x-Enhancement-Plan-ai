package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.core.os.a;
import g.n0;
import g.p0;
import g.r0;
import g.v0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    @v0(33)
    public static class a {
        @g.u
        public static <T> T a(@n0 Bundle bundle, @p0 String str, @n0 Class<T> cls) {
            return (T) bundle.getParcelable(str, cls);
        }

        @g.u
        public static <T> T[] b(@n0 Bundle bundle, @p0 String str, @n0 Class<T> cls) {
            return (T[]) bundle.getParcelableArray(str, cls);
        }

        @g.u
        public static <T> ArrayList<T> c(@n0 Bundle bundle, @p0 String str, @n0 Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        @g.u
        public static <T> SparseArray<T> d(@n0 Bundle bundle, @p0 String str, @n0 Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    @p0
    @r0(markerClass = {a.b.class})
    public static <T> T a(@n0 Bundle bundle, @p0 String str, @n0 Class<T> cls) {
        if (androidx.core.os.a.l()) {
            return (T) a.a(bundle, str, cls);
        }
        T t10 = (T) bundle.getParcelable(str);
        if (cls.isInstance(t10)) {
            return t10;
        }
        return null;
    }

    @p0
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static Parcelable[] b(@n0 Bundle bundle, @p0 String str, @n0 Class<? extends Parcelable> cls) {
        return androidx.core.os.a.l() ? (Parcelable[]) a.b(bundle, str, cls) : bundle.getParcelableArray(str);
    }

    @p0
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    @r0(markerClass = {a.b.class})
    public static <T> ArrayList<T> c(@n0 Bundle bundle, @p0 String str, @n0 Class<? extends T> cls) {
        return androidx.core.os.a.l() ? a.c(bundle, str, cls) : bundle.getParcelableArrayList(str);
    }

    @p0
    @r0(markerClass = {a.b.class})
    public static <T> SparseArray<T> d(@n0 Bundle bundle, @p0 String str, @n0 Class<? extends T> cls) {
        return androidx.core.os.a.l() ? a.d(bundle, str, cls) : bundle.getSparseParcelableArray(str);
    }
}
