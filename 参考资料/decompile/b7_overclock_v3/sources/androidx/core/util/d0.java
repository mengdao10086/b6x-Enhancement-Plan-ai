package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.k0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class d0 {

    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseIntArray f4722b;

        public a(SparseIntArray sparseIntArray) {
            this.f4722b = sparseIntArray;
        }

        @Override // kotlin.collections.k0
        public int b() {
            SparseIntArray sparseIntArray = this.f4722b;
            int i10 = this.f4721a;
            this.f4721a = i10 + 1;
            return sparseIntArray.keyAt(i10);
        }

        public final int d() {
            return this.f4721a;
        }

        public final void e(int i10) {
            this.f4721a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4721a < this.f4722b.size();
        }
    }

    public static final class b extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseIntArray f4724b;

        public b(SparseIntArray sparseIntArray) {
            this.f4724b = sparseIntArray;
        }

        @Override // kotlin.collections.k0
        public int b() {
            SparseIntArray sparseIntArray = this.f4724b;
            int i10 = this.f4723a;
            this.f4723a = i10 + 1;
            return sparseIntArray.valueAt(i10);
        }

        public final int d() {
            return this.f4723a;
        }

        public final void e(int i10) {
            this.f4723a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4723a < this.f4724b.size();
        }
    }

    public static final boolean a(@yt.k SparseIntArray sparseIntArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean b(@yt.k SparseIntArray sparseIntArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfKey(i10) >= 0;
    }

    public static final boolean c(@yt.k SparseIntArray sparseIntArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.indexOfValue(i10) >= 0;
    }

    public static final void d(@yt.k SparseIntArray sparseIntArray, @yt.k ik.p<? super Integer, ? super Integer, z1> action) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = sparseIntArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.r0(Integer.valueOf(sparseIntArray.keyAt(i10)), Integer.valueOf(sparseIntArray.valueAt(i10)));
        }
    }

    public static final int e(@yt.k SparseIntArray sparseIntArray, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.get(i10, i11);
    }

    public static final int f(@yt.k SparseIntArray sparseIntArray, int i10, @yt.k ik.a<Integer> defaultValue) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseIntArray.valueAt(iIndexOfKey) : defaultValue.o().intValue();
    }

    public static final int g(@yt.k SparseIntArray sparseIntArray) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.size();
    }

    public static final boolean h(@yt.k SparseIntArray sparseIntArray) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() == 0;
    }

    public static final boolean i(@yt.k SparseIntArray sparseIntArray) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return sparseIntArray.size() != 0;
    }

    @yt.k
    public static final k0 j(@yt.k SparseIntArray sparseIntArray) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return new a(sparseIntArray);
    }

    @yt.k
    public static final SparseIntArray k(@yt.k SparseIntArray sparseIntArray, @yt.k SparseIntArray other) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size() + other.size());
        l(sparseIntArray2, sparseIntArray);
        l(sparseIntArray2, other);
        return sparseIntArray2;
    }

    public static final void l(@yt.k SparseIntArray sparseIntArray, @yt.k SparseIntArray other) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseIntArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final boolean m(@yt.k SparseIntArray sparseIntArray, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        int iIndexOfKey = sparseIntArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || i11 != sparseIntArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void n(@yt.k SparseIntArray sparseIntArray, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        sparseIntArray.put(i10, i11);
    }

    @yt.k
    public static final k0 o(@yt.k SparseIntArray sparseIntArray) {
        kotlin.jvm.internal.f0.p(sparseIntArray, "<this>");
        return new b(sparseIntArray);
    }
}
