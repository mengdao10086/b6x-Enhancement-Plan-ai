package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.SparseLongArray;
import g.v0;
import kotlin.collections.k0;
import kotlin.collections.l0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n103#1,4:127\n1#2:126\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n97#1:127,4\n*E\n"})
public final class e0 {

    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseLongArray f4726b;

        public a(SparseLongArray sparseLongArray) {
            this.f4726b = sparseLongArray;
        }

        @Override // kotlin.collections.k0
        public int b() {
            SparseLongArray sparseLongArray = this.f4726b;
            int i10 = this.f4725a;
            this.f4725a = i10 + 1;
            return sparseLongArray.keyAt(i10);
        }

        public final int d() {
            return this.f4725a;
        }

        public final void e(int i10) {
            this.f4725a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4725a < this.f4726b.size();
        }
    }

    public static final class b extends l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseLongArray f4728b;

        public b(SparseLongArray sparseLongArray) {
            this.f4728b = sparseLongArray;
        }

        @Override // kotlin.collections.l0
        public long b() {
            SparseLongArray sparseLongArray = this.f4728b;
            int i10 = this.f4727a;
            this.f4727a = i10 + 1;
            return sparseLongArray.valueAt(i10);
        }

        public final int d() {
            return this.f4727a;
        }

        public final void e(int i10) {
            this.f4727a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4727a < this.f4728b.size();
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean a(@yt.k SparseLongArray sparseLongArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean b(@yt.k SparseLongArray sparseLongArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfKey(i10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean c(@yt.k SparseLongArray sparseLongArray, long j10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.indexOfValue(j10) >= 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final void d(@yt.k SparseLongArray sparseLongArray, @yt.k ik.p<? super Integer, ? super Long, z1> action) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = sparseLongArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.r0(Integer.valueOf(sparseLongArray.keyAt(i10)), Long.valueOf(sparseLongArray.valueAt(i10)));
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final long e(@yt.k SparseLongArray sparseLongArray, int i10, long j10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.get(i10, j10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final long f(@yt.k SparseLongArray sparseLongArray, int i10, @yt.k ik.a<Long> defaultValue) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : defaultValue.o().longValue();
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final int g(@yt.k SparseLongArray sparseLongArray) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.size();
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean h(@yt.k SparseLongArray sparseLongArray) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() == 0;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean i(@yt.k SparseLongArray sparseLongArray) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return sparseLongArray.size() != 0;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final k0 j(@yt.k SparseLongArray sparseLongArray) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return new a(sparseLongArray);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final SparseLongArray k(@yt.k SparseLongArray sparseLongArray, @yt.k SparseLongArray other) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        SparseLongArray sparseLongArray2 = new SparseLongArray(sparseLongArray.size() + other.size());
        l(sparseLongArray2, sparseLongArray);
        l(sparseLongArray2, other);
        return sparseLongArray2;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final void l(@yt.k SparseLongArray sparseLongArray, @yt.k SparseLongArray other) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseLongArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final boolean m(@yt.k SparseLongArray sparseLongArray, int i10, long j10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        int iIndexOfKey = sparseLongArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || j10 != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final void n(@yt.k SparseLongArray sparseLongArray, int i10, long j10) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        sparseLongArray.put(i10, j10);
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(18)
    public static final l0 o(@yt.k SparseLongArray sparseLongArray) {
        kotlin.jvm.internal.f0.p(sparseLongArray, "<this>");
        return new b(sparseLongArray);
    }
}
