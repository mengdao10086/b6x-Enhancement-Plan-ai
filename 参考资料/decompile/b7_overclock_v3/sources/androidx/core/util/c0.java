package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.k0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
public final class c0 {

    public static final class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseBooleanArray f4718b;

        public a(SparseBooleanArray sparseBooleanArray) {
            this.f4718b = sparseBooleanArray;
        }

        @Override // kotlin.collections.k0
        public int b() {
            SparseBooleanArray sparseBooleanArray = this.f4718b;
            int i10 = this.f4717a;
            this.f4717a = i10 + 1;
            return sparseBooleanArray.keyAt(i10);
        }

        public final int d() {
            return this.f4717a;
        }

        public final void e(int i10) {
            this.f4717a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4717a < this.f4718b.size();
        }
    }

    public static final class b extends kotlin.collections.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseBooleanArray f4720b;

        public b(SparseBooleanArray sparseBooleanArray) {
            this.f4720b = sparseBooleanArray;
        }

        @Override // kotlin.collections.o
        public boolean b() {
            SparseBooleanArray sparseBooleanArray = this.f4720b;
            int i10 = this.f4719a;
            this.f4719a = i10 + 1;
            return sparseBooleanArray.valueAt(i10);
        }

        public final int d() {
            return this.f4719a;
        }

        public final void e(int i10) {
            this.f4719a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4719a < this.f4720b.size();
        }
    }

    public static final boolean a(@yt.k SparseBooleanArray sparseBooleanArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean b(@yt.k SparseBooleanArray sparseBooleanArray, int i10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfKey(i10) >= 0;
    }

    public static final boolean c(@yt.k SparseBooleanArray sparseBooleanArray, boolean z10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.indexOfValue(z10) >= 0;
    }

    public static final void d(@yt.k SparseBooleanArray sparseBooleanArray, @yt.k ik.p<? super Integer, ? super Boolean, z1> action) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        kotlin.jvm.internal.f0.p(action, "action");
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.r0(Integer.valueOf(sparseBooleanArray.keyAt(i10)), Boolean.valueOf(sparseBooleanArray.valueAt(i10)));
        }
    }

    public static final boolean e(@yt.k SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.get(i10, z10);
    }

    public static final boolean f(@yt.k SparseBooleanArray sparseBooleanArray, int i10, @yt.k ik.a<Boolean> defaultValue) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : defaultValue.o().booleanValue();
    }

    public static final int g(@yt.k SparseBooleanArray sparseBooleanArray) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size();
    }

    public static final boolean h(@yt.k SparseBooleanArray sparseBooleanArray) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean i(@yt.k SparseBooleanArray sparseBooleanArray) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return sparseBooleanArray.size() != 0;
    }

    @yt.k
    public static final k0 j(@yt.k SparseBooleanArray sparseBooleanArray) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return new a(sparseBooleanArray);
    }

    @yt.k
    public static final SparseBooleanArray k(@yt.k SparseBooleanArray sparseBooleanArray, @yt.k SparseBooleanArray other) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(sparseBooleanArray.size() + other.size());
        l(sparseBooleanArray2, sparseBooleanArray);
        l(sparseBooleanArray2, other);
        return sparseBooleanArray2;
    }

    public static final void l(@yt.k SparseBooleanArray sparseBooleanArray, @yt.k SparseBooleanArray other) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        int size = other.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseBooleanArray.put(other.keyAt(i10), other.valueAt(i10));
        }
    }

    public static final boolean m(@yt.k SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i10);
        if (iIndexOfKey < 0 || z10 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i10);
        return true;
    }

    public static final void n(@yt.k SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        sparseBooleanArray.put(i10, z10);
    }

    @yt.k
    public static final kotlin.collections.o o(@yt.k SparseBooleanArray sparseBooleanArray) {
        kotlin.jvm.internal.f0.p(sparseBooleanArray, "<this>");
        return new b(sparseBooleanArray);
    }
}
