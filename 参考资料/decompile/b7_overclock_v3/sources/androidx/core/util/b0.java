package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.k0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
public final class b0 {

    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseArray<T> f4714b;

        public a(SparseArray<T> sparseArray) {
            this.f4714b = sparseArray;
        }

        @Override // kotlin.collections.k0
        public int b() {
            SparseArray<T> sparseArray = this.f4714b;
            int i10 = this.f4713a;
            this.f4713a = i10 + 1;
            return sparseArray.keyAt(i10);
        }

        public final int d() {
            return this.f4713a;
        }

        public final void e(int i10) {
            this.f4713a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4713a < this.f4714b.size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseArray<T> f4716b;

        public b(SparseArray<T> sparseArray) {
            this.f4716b = sparseArray;
        }

        public final int a() {
            return this.f4715a;
        }

        public final void b(int i10) {
            this.f4715a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4715a < this.f4716b.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.f4716b;
            int i10 = this.f4715a;
            this.f4715a = i10 + 1;
            return sparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final <T> boolean a(@yt.k SparseArray<T> sparseArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean b(@yt.k SparseArray<T> sparseArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.indexOfKey(i10) >= 0;
    }

    public static final <T> boolean c(@yt.k SparseArray<T> sparseArray, T t10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.indexOfValue(t10) >= 0;
    }

    public static final <T> void d(@yt.k SparseArray<T> sparseArray, @yt.k ik.p<? super Integer, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.r0(Integer.valueOf(sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
        }
    }

    public static final <T> T e(@yt.k SparseArray<T> sparseArray, int i10, T t10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        T t11 = sparseArray.get(i10);
        return t11 == null ? t10 : t11;
    }

    public static final <T> T f(@yt.k SparseArray<T> sparseArray, int i10, @yt.k ik.a<? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        T t10 = sparseArray.get(i10);
        return t10 == null ? defaultValue.o() : t10;
    }

    public static final <T> int g(@yt.k SparseArray<T> sparseArray) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.size();
    }

    public static final <T> boolean h(@yt.k SparseArray<T> sparseArray) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean i(@yt.k SparseArray<T> sparseArray) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return sparseArray.size() != 0;
    }

    @yt.k
    public static final <T> k0 j(@yt.k SparseArray<T> sparseArray) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return new a(sparseArray);
    }

    @yt.k
    public static final <T> SparseArray<T> k(@yt.k SparseArray<T> sparseArray, @yt.k SparseArray<T> other) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size() + other.size());
        l(sparseArray2, sparseArray);
        l(sparseArray2, other);
        return sparseArray2;
    }

    public static final <T> void l(@yt.k SparseArray<T> sparseArray, @yt.k SparseArray<T> other) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final <T> boolean m(@yt.k SparseArray<T> sparseArray, int i10, T t10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        int iIndexOfKey = sparseArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || !kotlin.jvm.internal.f0.g(t10, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void n(@yt.k SparseArray<T> sparseArray, int i10, T t10) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        sparseArray.put(i10, t10);
    }

    @yt.k
    public static final <T> Iterator<T> o(@yt.k SparseArray<T> sparseArray) {
        kotlin.jvm.internal.f0.p(sparseArray, "<this>");
        return new b(sparseArray);
    }
}
