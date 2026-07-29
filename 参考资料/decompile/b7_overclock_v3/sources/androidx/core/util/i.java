package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import g.v0;
import java.util.Iterator;
import kotlin.collections.l0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,132:1\n104#1,4:133\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n98#1:133,4\n*E\n"})
public final class i {

    public static final class a extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LongSparseArray<T> f4738b;

        public a(LongSparseArray<T> longSparseArray) {
            this.f4738b = longSparseArray;
        }

        @Override // kotlin.collections.l0
        @SuppressLint({"ClassVerificationFailure"})
        public long b() {
            LongSparseArray<T> longSparseArray = this.f4738b;
            int i10 = this.f4737a;
            this.f4737a = i10 + 1;
            return longSparseArray.keyAt(i10);
        }

        public final int d() {
            return this.f4737a;
        }

        public final void e(int i10) {
            this.f4737a = i10;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.f4737a < this.f4738b.size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements Iterator<T>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LongSparseArray<T> f4740b;

        public b(LongSparseArray<T> longSparseArray) {
            this.f4740b = longSparseArray;
        }

        public final int a() {
            return this.f4739a;
        }

        public final void b(int i10) {
            this.f4739a = i10;
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public boolean hasNext() {
            return this.f4739a < this.f4740b.size();
        }

        @Override // java.util.Iterator
        @SuppressLint({"ClassVerificationFailure"})
        public T next() {
            LongSparseArray<T> longSparseArray = this.f4740b;
            int i10 = this.f4739a;
            this.f4739a = i10 + 1;
            return longSparseArray.valueAt(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean a(@yt.k LongSparseArray<T> longSparseArray, long j10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean b(@yt.k LongSparseArray<T> longSparseArray, long j10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfKey(j10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean c(@yt.k LongSparseArray<T> longSparseArray, T t10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.indexOfValue(t10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> void d(@yt.k LongSparseArray<T> longSparseArray, @yt.k ik.p<? super Long, ? super T, z1> action) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.r0(Long.valueOf(longSparseArray.keyAt(i10)), longSparseArray.valueAt(i10));
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> T e(@yt.k LongSparseArray<T> longSparseArray, long j10, T t10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        T t11 = longSparseArray.get(j10);
        return t11 == null ? t10 : t11;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> T f(@yt.k LongSparseArray<T> longSparseArray, long j10, @yt.k ik.a<? extends T> defaultValue) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        T t10 = longSparseArray.get(j10);
        return t10 == null ? defaultValue.o() : t10;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> int g(@yt.k LongSparseArray<T> longSparseArray) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean h(@yt.k LongSparseArray<T> longSparseArray) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.size() == 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean i(@yt.k LongSparseArray<T> longSparseArray) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return longSparseArray.size() != 0;
    }

    @yt.k
    @v0(16)
    public static final <T> l0 j(@yt.k LongSparseArray<T> longSparseArray) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return new a(longSparseArray);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> LongSparseArray<T> k(@yt.k LongSparseArray<T> longSparseArray, @yt.k LongSparseArray<T> other) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>(longSparseArray.size() + other.size());
        l(longSparseArray2, longSparseArray);
        l(longSparseArray2, other);
        return longSparseArray2;
    }

    @v0(16)
    public static final <T> void l(@yt.k LongSparseArray<T> longSparseArray, @yt.k LongSparseArray<T> other) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            longSparseArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> boolean m(@yt.k LongSparseArray<T> longSparseArray, long j10, T t10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        int iIndexOfKey = longSparseArray.indexOfKey(j10);
        if (iIndexOfKey < 0 || !kotlin.jvm.internal.f0.g(t10, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(16)
    public static final <T> void n(@yt.k LongSparseArray<T> longSparseArray, long j10, T t10) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        longSparseArray.put(j10, t10);
    }

    @yt.k
    @v0(16)
    public static final <T> Iterator<T> o(@yt.k LongSparseArray<T> longSparseArray) {
        kotlin.jvm.internal.f0.p(longSparseArray, "<this>");
        return new b(longSparseArray);
    }
}
