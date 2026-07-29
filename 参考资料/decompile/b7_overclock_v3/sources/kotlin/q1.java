package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n62#1:87,3\n*E\n"})
@s
@v0(version = "1.3")
@hk.f
public final class q1 implements Collection<p1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final long[] f37998a;

    public static final class a implements Iterator<p1>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final long[] f37999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38000b;

        public a(@yt.k long[] array) {
            kotlin.jvm.internal.f0.p(array, "array");
            this.f37999a = array;
        }

        public long a() {
            int i10 = this.f38000b;
            long[] jArr = this.f37999a;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f38000b));
            }
            this.f38000b = i10 + 1;
            return p1.j(jArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38000b < this.f37999a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ p1 next() {
            return p1.d(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @s0
    public /* synthetic */ q1(long[] jArr) {
        this.f37998a = jArr;
    }

    public static final /* synthetic */ q1 b(long[] jArr) {
        return new q1(jArr);
    }

    @yt.k
    public static long[] d(int i10) {
        return e(new long[i10]);
    }

    @s0
    @yt.k
    public static long[] e(@yt.k long[] storage) {
        kotlin.jvm.internal.f0.p(storage, "storage");
        return storage;
    }

    public static boolean j(long[] jArr, long j10) {
        return ArraysKt___ArraysKt.S8(jArr, j10);
    }

    public static boolean l(long[] jArr, @yt.k Collection<p1> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (!((obj instanceof p1) && ArraysKt___ArraysKt.S8(jArr, ((p1) obj).l0()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m(long[] jArr, Object obj) {
        return (obj instanceof q1) && kotlin.jvm.internal.f0.g(jArr, ((q1) obj).y());
    }

    public static final boolean o(long[] jArr, long[] jArr2) {
        return kotlin.jvm.internal.f0.g(jArr, jArr2);
    }

    public static final long p(long[] jArr, int i10) {
        return p1.j(jArr[i10]);
    }

    public static int r(long[] jArr) {
        return jArr.length;
    }

    @s0
    public static /* synthetic */ void s() {
    }

    public static int t(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean u(long[] jArr) {
        return jArr.length == 0;
    }

    @yt.k
    public static Iterator<p1> v(long[] jArr) {
        return new a(jArr);
    }

    public static final void w(long[] jArr, int i10, long j10) {
        jArr[i10] = j10;
    }

    public static String x(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public boolean a(long j10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(p1 p1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends p1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof p1) {
            return g(((p1) obj).l0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@yt.k Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return l(this.f37998a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m(this.f37998a, obj);
    }

    public boolean g(long j10) {
        return j(this.f37998a, j10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return t(this.f37998a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f37998a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<p1> iterator() {
        return v(this.f37998a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f37998a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }

    public String toString() {
        return x(this.f37998a);
    }

    public final /* synthetic */ long[] y() {
        return this.f37998a;
    }
}
